package io.pivotal.bds.gemfire.fraud.server.function;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gemstone.gemfire.cache.Region;
import com.gemstone.gemfire.cache.execute.Execution;
import com.gemstone.gemfire.cache.execute.FunctionAdapter;
import com.gemstone.gemfire.cache.execute.FunctionContext;
import com.gemstone.gemfire.cache.execute.FunctionException;
import com.gemstone.gemfire.cache.execute.FunctionService;
import com.gemstone.gemfire.cache.execute.RegionFunctionContext;
import com.gemstone.gemfire.cache.execute.ResultCollector;
import com.gemstone.gemfire.cache.execute.ResultSender;

import io.pivotal.bds.gemfire.dao.exception.NotFoundException;
import io.pivotal.bds.gemfire.fraud.common.data.Account;
import io.pivotal.bds.gemfire.fraud.common.data.PartitionedProcessTransactionRequest;
import io.pivotal.bds.gemfire.fraud.common.data.ProcessTransactionRequest;
import io.pivotal.bds.gemfire.fraud.common.data.ProcessTransactionResponse;
import io.pivotal.bds.gemfire.fraud.common.data.TransactionResultCode;
import io.pivotal.bds.gemfire.fraud.common.key.AccountKey;
import io.pivotal.bds.gemfire.fraud.common.key.TransactionKey;
import io.pivotal.bds.gemfire.fraud.server.dao.CardNumberAccountKeyXrefDAO;

@SuppressWarnings("serial")
public class ProcessTransactionFunction extends FunctionAdapter {

    private CardNumberAccountKeyXrefDAO cardNumberAccountKeyXrefDAO;
    private Region<AccountKey, Account> accountRegion;

    private static final Logger LOG = LoggerFactory.getLogger(ProcessTransactionFunction.class);

    public ProcessTransactionFunction(CardNumberAccountKeyXrefDAO cardNumberAccountKeyXrefDAO,
            Region<AccountKey, Account> accountRegion) {
        this.cardNumberAccountKeyXrefDAO = cardNumberAccountKeyXrefDAO;
        this.accountRegion = accountRegion;
    }

    @Override
    public void execute(FunctionContext ctx) {
        try {
            ResultSender<ProcessTransactionResponse> sender = ctx.getResultSender();
            RegionFunctionContext rctx = (RegionFunctionContext) ctx;
            Set<?> filter = rctx.getFilter();
            LOG.debug("execute: filter.size={}", filter.size());

            if (filter.size() != 1) {
                throw new IllegalArgumentException("Wrong filter size: expected 1, but got " + filter.size());
            }

            ProcessTransactionRequest req = (ProcessTransactionRequest) filter.iterator().next();
            LOG.debug("execute: req={}", req);
            ProcessTransactionResponse resp = process(req);
            LOG.debug("execute: req={}, resp={}", req, resp);
            sender.lastResult(resp);
        } catch (Exception x) {
            throw new FunctionException(x.toString(), x);
        }
    }

    private ProcessTransactionResponse process(ProcessTransactionRequest req) {
        String txnId = UUID.randomUUID().toString();
        LOG.debug("process: txnId={}, req={}", txnId, req);

        try {
            String cardNumber = req.getCardNumber();
            AccountKey acctKey = cardNumberAccountKeyXrefDAO.retrieve(cardNumber);
            TransactionKey txnKey = new TransactionKey(txnId, acctKey.getId());

            PartitionedProcessTransactionRequest preq = new PartitionedProcessTransactionRequest();

            preq.setAccountKey(acctKey);
            preq.setTransactionKey(txnKey);
            preq.setRequest(req);

            Set<PartitionedProcessTransactionRequest> filter = new HashSet<>();
            filter.add(preq);

            Execution exec = FunctionService.onRegion(accountRegion).withFilter(filter);
            ResultCollector<?, ?> coll = exec.execute("ProcessTransactionPartitionedFunction");
            List<?> list = (List<?>) coll.getResult();

            if (list.size() != 1) {
                throw new IllegalArgumentException("Wrong number of responses: expected 1 but got " + list.size());
            }

            ProcessTransactionResponse resp = (ProcessTransactionResponse) list.get(0);
            LOG.debug("process: txnId={}, req={}, resp={}", txnId, req, resp);

            return resp;
        } catch (NotFoundException x) {
            LOG.error("process: x={}", x.toString(), x);
            ProcessTransactionResponse resp = new ProcessTransactionResponse();
            resp.setTransactionId(txnId);
            resp.setResultCode(TransactionResultCode.unknown_account);
            return resp;
        } catch (Exception x) {
            LOG.error("process: x={}", x.toString(), x);
            ProcessTransactionResponse resp = new ProcessTransactionResponse();
            resp.setTransactionId(txnId);
            resp.setResultCode(TransactionResultCode.error);
            return resp;
        }
    }

    @Override
    public String getId() {
        return getClass().getSimpleName();
    }

    @Override
    public boolean optimizeForWrite() {
        return true;
    }

}
