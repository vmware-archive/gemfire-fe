package io.pivotal.bds.gemfire.fraud.test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.gemstone.gemfire.cache.execute.Execution;
import com.gemstone.gemfire.cache.execute.FunctionService;

import io.pivotal.bds.gemfire.fraud.common.data.ProcessTransactionRequest;

public class BasicTxnTest extends BaseTest {

    @Override
    protected void go() throws Exception {
        doTxn(12.34);
        doTxn(123.45);
        doTxn(1234.50);
        doTxn(12345.00);
    }

    private void doTxn(double amt) {
        ProcessTransactionRequest req = new ProcessTransactionRequest();

        req.setCardNumber("1234567890000004");
        req.setNameOnCard("Bill Smith");
        req.setCcv("123");
        req.setAmount(amt);
        req.setCardPresent(true);
        req.setExpiration(201705);
        req.setVendorId("vendor-0");
        req.setCreatedOn(new Date());

        Set<ProcessTransactionRequest> filter = new HashSet<>();
        filter.add(req);

        LOG.info("go: executing");
        Execution exec = FunctionService.onRegion(transactionRoutingRegion).withFilter(filter);
        Object res = exec.execute("ProcessTransactionFunction").getResult();
        LOG.info("req={}, res={}", req, res);
    }

    public static void main(String[] args) throws Exception {
        new BasicTxnTest().run(args);
    }
}
