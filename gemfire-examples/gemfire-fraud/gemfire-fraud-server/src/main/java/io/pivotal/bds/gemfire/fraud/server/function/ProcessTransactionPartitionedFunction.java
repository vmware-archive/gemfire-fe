package io.pivotal.bds.gemfire.fraud.server.function;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.geotools.geometry.jts.JTS;
import org.opengis.referencing.operation.MathTransform;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.geode.cache.execute.FunctionAdapter;
import org.apache.geode.cache.execute.FunctionContext;
import org.apache.geode.cache.execute.FunctionException;
import org.apache.geode.cache.execute.RegionFunctionContext;
import org.apache.geode.cache.execute.ResultSender;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;

import io.pivotal.bds.gemfire.fraud.common.data.Account;
import io.pivotal.bds.gemfire.fraud.common.data.AccountAggregate;
import io.pivotal.bds.gemfire.fraud.common.data.AccountStatus;
import io.pivotal.bds.gemfire.fraud.common.data.Card;
import io.pivotal.bds.gemfire.fraud.common.data.CardBalance;
import io.pivotal.bds.gemfire.fraud.common.data.PartitionedProcessTransactionRequest;
import io.pivotal.bds.gemfire.fraud.common.data.ProcessTransactionRequest;
import io.pivotal.bds.gemfire.fraud.common.data.ProcessTransactionResponse;
import io.pivotal.bds.gemfire.fraud.common.data.TransactionResultCode;
import io.pivotal.bds.gemfire.fraud.common.data.Transaction;
import io.pivotal.bds.gemfire.fraud.common.data.TransactionAggregate;
import io.pivotal.bds.gemfire.fraud.common.data.TransactionHistory;
import io.pivotal.bds.gemfire.fraud.common.data.TransactionStatus;
import io.pivotal.bds.gemfire.fraud.common.data.TransactionStatusCode;
import io.pivotal.bds.gemfire.fraud.common.data.Vendor;
import io.pivotal.bds.gemfire.fraud.common.data.VendorStatus;
import io.pivotal.bds.gemfire.fraud.common.data.VendorType;
import io.pivotal.bds.gemfire.fraud.common.key.AccountKey;
import io.pivotal.bds.gemfire.fraud.common.key.CardKey;
import io.pivotal.bds.gemfire.fraud.common.key.TransactionHistoryKey;
import io.pivotal.bds.gemfire.fraud.common.key.TransactionKey;
import io.pivotal.bds.gemfire.fraud.common.key.VendorKey;
import io.pivotal.bds.gemfire.fraud.server.dao.AccountAggregateDAO;
import io.pivotal.bds.gemfire.fraud.server.dao.AccountDAO;
import io.pivotal.bds.gemfire.fraud.server.dao.CardBalanceDAO;
import io.pivotal.bds.gemfire.fraud.server.dao.CardClassifierDAO;
import io.pivotal.bds.gemfire.fraud.server.dao.CardDAO;
import io.pivotal.bds.gemfire.fraud.server.dao.CardLockDAO;
import io.pivotal.bds.gemfire.fraud.server.dao.AccountClassifierDAO;
import io.pivotal.bds.gemfire.fraud.server.dao.CardNumberCardKeyXrefDAO;
import io.pivotal.bds.gemfire.fraud.server.dao.TransactionDAO;
import io.pivotal.bds.gemfire.fraud.server.dao.TransactionHistoryDAO;
import io.pivotal.bds.gemfire.fraud.server.dao.TransactionStatusDAO;
import io.pivotal.bds.gemfire.fraud.server.dao.VendorDAO;
import io.pivotal.bds.gemfire.fraud.server.exception.InvalidTransactionException;
import smile.classification.Classifier;

@SuppressWarnings("serial")
public class ProcessTransactionPartitionedFunction extends FunctionAdapter {

    private CardNumberCardKeyXrefDAO cardKeyXrefDAO;
    private CardDAO cardDAO;
    private VendorDAO vendorDAO;
    private AccountDAO accountDAO;
    private AccountAggregateDAO accountAggregateDAO;
    private TransactionDAO transactionDAO;
    private TransactionHistoryDAO transactionHistoryDAO;
    private TransactionStatusDAO transactionStatusDAO;
    private AccountClassifierDAO accountClassifierDAO;
    private CardClassifierDAO cardClassifierDAO;
    private CardLockDAO cardLockDAO;
    private CardBalanceDAO cardBalanceDAO;

    private MathTransform latLonToCart;

    private static final GeometryFactory factory = new GeometryFactory();

    private static final Logger LOG = LoggerFactory.getLogger(ProcessTransactionPartitionedFunction.class);

    public ProcessTransactionPartitionedFunction(CardNumberCardKeyXrefDAO cardKeyXrefDAO, CardDAO cardDAO, VendorDAO vendorDAO,
            AccountDAO accountDAO, AccountAggregateDAO accountAggregateDAO, TransactionDAO transactionDAO,
            TransactionHistoryDAO transactionHistoryDAO, TransactionStatusDAO transactionStatusDAO,
            AccountClassifierDAO accountClassifierDAO, CardClassifierDAO cardClassifierDAO, CardLockDAO cardLockDAO,
            CardBalanceDAO cardBalanceDAO, MathTransform latLonToCart) {
        this.cardKeyXrefDAO = cardKeyXrefDAO;
        this.cardDAO = cardDAO;
        this.vendorDAO = vendorDAO;
        this.accountDAO = accountDAO;
        this.accountAggregateDAO = accountAggregateDAO;
        this.transactionDAO = transactionDAO;
        this.transactionHistoryDAO = transactionHistoryDAO;
        this.transactionStatusDAO = transactionStatusDAO;
        this.accountClassifierDAO = accountClassifierDAO;
        this.cardClassifierDAO = cardClassifierDAO;
        this.cardLockDAO = cardLockDAO;
        this.cardBalanceDAO = cardBalanceDAO;
        this.latLonToCart = latLonToCart;
    }

    @Override
    public void execute(FunctionContext ctx) {
        try {
            ResultSender<ProcessTransactionResponse> sender = ctx.getResultSender();
            RegionFunctionContext rctx = (RegionFunctionContext) ctx;
            Set<?> filter = rctx.getFilter();
            LOG.debug("execute: filter.size={}", filter.size());

            if (filter.size() != 1) {
                throw new IllegalArgumentException("Wrong filter size: expected 1, got " + filter.size());
            }

            PartitionedProcessTransactionRequest req = (PartitionedProcessTransactionRequest) filter.iterator().next();
            LOG.debug("execute: req={}", req);
            ProcessTransactionResponse resp = process(req);
            LOG.debug("execute: req={}, resp={}", req, resp);
            sender.lastResult(resp);
        } catch (Exception x) {
            throw new FunctionException(x.toString(), x);
        }
    }

    private ProcessTransactionResponse process(PartitionedProcessTransactionRequest preq) {
        TransactionKey txnKey = preq.getTransactionKey();
        String txnId = txnKey.getId();
        LOG.debug("process: txnId={}, preq={}", txnId, preq);

        ProcessTransactionResponse resp = new ProcessTransactionResponse();
        resp.setTransactionId(txnId);

        try {
            ProcessTransactionRequest req = preq.getRequest();

            String cardNumber = req.getCardNumber();

            CardKey cardKey = cardKeyXrefDAO.retrieve(cardNumber);

            ReentrantReadWriteLock rrwl = cardLockDAO.get(cardKey);
            Lock writeLock = rrwl.writeLock();
            writeLock.lock();

            try {
                process(txnId, cardKey, preq, resp);
            } finally {
                writeLock.unlock();
            }
        } catch (Exception x) {
            LOG.error("process: x={}", x.toString(), x);
            resp.setResultCode(TransactionResultCode.error);
        }

        LOG.debug("process: txnId={}, resp={}", txnId, resp);
        return resp;
    }

    private void process(String txnId, CardKey cardKey, PartitionedProcessTransactionRequest preq,
            ProcessTransactionResponse resp) {
        ProcessTransactionRequest req = preq.getRequest();
        AccountKey acctKey = preq.getAccountKey();
        String acctId = acctKey.getId();
        String cardId = cardKey.getId();

        String vendorId = req.getVendorId();
        double amt = req.getAmount();
        Date createdOn = req.getCreatedOn();

        VendorKey vendorKey = new VendorKey(vendorId);
        Vendor vendor = vendorDAO.retrieve(vendorKey);

        TransactionKey txnKey = new TransactionKey(txnId, acctId);

        Transaction txn = new Transaction();

        txn.setTransactionId(txnId);
        txn.setAccountId(acctId);
        txn.setVendorId(vendorId);
        txn.setCreatedOn(createdOn);
        txn.setCardId(cardId);
        txn.setAmount(amt);

        transactionDAO.store(txnKey, txn);

        updateHistory(txn, TransactionStatusCode.initiated, TransactionResultCode.in_process);
        updateStatus(txnKey, TransactionStatusCode.initiated, TransactionResultCode.in_process);

        try {
            Card card = cardDAO.retrieve(cardKey);

            // verify card info matches
            int dateCode = req.getExpiration();
            int year = dateCode / 100;
            int month = dateCode - year * 100;

            Calendar cal = Calendar.getInstance();
            cal.setTime(card.getExpirationDate());
            int cardYear = cal.get(Calendar.YEAR);
            int cardMonth = cal.get(Calendar.MONTH) + 1;

            if (year != cardYear || month != cardMonth || !card.getCcv().equals(req.getCcv())
                    || !card.getNameOnCard().equals(req.getNameOnCard())) {
                throw new InvalidTransactionException(TransactionResultCode.invalid_card);
            } else if (LOG.isDebugEnabled()) {
                LOG.debug("process: expiration matches: year={}, month={}, card={}", year, month, card);
            }

            // check account status
            Account acct = accountDAO.retrieve(acctKey);
            if (acct.getStatus() != AccountStatus.active) {
                throw new InvalidTransactionException(TransactionResultCode.invalid_account);
            } else if (LOG.isDebugEnabled()) {
                LOG.debug("process: account status is active: acct={}", acct);
            }

            // check current balance
            CardBalance cardBal = cardBalanceDAO.retrieve(cardKey);
            if (cardBal.getBalance() + amt >= card.getCardLimit()) {
                throw new InvalidTransactionException(TransactionResultCode.limit_exceeded);
            } else if (LOG.isDebugEnabled()) {
                LOG.debug("process: balance is less than limit: amt={}, cardBal={}, card={}", amt, cardBal, card);
            }

            // check if vendor is suspect and if card was present
            if (vendor.getVendorStatus() == VendorStatus.suspect && !req.isCardPresent()) {
                throw new InvalidTransactionException(TransactionResultCode.suspect_vendor);
            } else if (LOG.isDebugEnabled()) {
                LOG.debug("process: vendor is not suspect or card is present: vendor={}, isCardPresent={}", vendor,
                        req.isCardPresent());
            }

            // check if valid and active vendor
            if (vendor.getVendorStatus() != VendorStatus.active) {
                throw new InvalidTransactionException(TransactionResultCode.invalid_vendor);
            } else if (LOG.isDebugEnabled()) {
                LOG.debug("process: vendor is active: vendor={}", vendor);
            }

            // check if most recent physical purchase was too far away
            if (vendor.getVendorType() == VendorType.physical) {
                Transaction recentTxn = findMostRecent(acctKey);

                if (recentTxn != null) {
                    VendorKey vk = new VendorKey(recentTxn.getVendorId());
                    Vendor recentVendor = vendorDAO.retrieve(vk);

                    Coordinate c1 = recentVendor.getLocation();
                    Coordinate c2 = vendor.getLocation();

                    Point p1 = factory.createPoint(c1);
                    Point p2 = factory.createPoint(c2);

                    Point pt1 = (Point) JTS.transform(p1, latLonToCart);
                    Point pt2 = (Point) JTS.transform(p2, latLonToCart);

                    double dist = Math.abs(pt1.distance(pt2));
                    double dtime = Math.abs(txn.getCreatedOn().getTime() - recentTxn.getCreatedOn().getTime()); // milliseconds
                    double rate = 1000.0 * dist / dtime; // meters/second
                    double maxRate = 0.0;

                    if (dist > 100.0) {
                        // probably flying, max about 200 m/s or 500 mi/hr
                        maxRate = 200.0;
                    } else {
                        // probably driving, max about 30 m/s or 60 mi/hr
                        maxRate = 30.0;
                    }

                    LOG.debug("process: dist={}, dtime={}, rate={}, maxRate={}", dist, dtime, rate, maxRate);

                    if (rate > maxRate) {
                        throw new InvalidTransactionException(TransactionResultCode.suspect_txn);
                    }
                }
            }

            double[] x = { amt };

            // check the txn against account model
            Classifier<double[]> accountClassifier = accountClassifierDAO.get(acctKey);

            if (accountClassifier != null) {
                int y = accountClassifier.predict(x);
                LOG.debug("process: account classifier: y={}, amt={}, acctKey={}", y, amt, acctKey);

                if (y == 1) {
                    throw new InvalidTransactionException(TransactionResultCode.suspect_txn);
                }
            } else if (LOG.isDebugEnabled()) {
                LOG.debug("process: no classifier for account found: acctKey={}", acctKey);
            }

            // check the txn against card model
            Classifier<double[]> cardClassifier = cardClassifierDAO.get(cardKey);

            if (cardClassifier != null) {
                int y = cardClassifier.predict(x);
                LOG.debug("process: card classifier: y={}, amt={}, cardKey={}", y, amt, cardKey);

                if (y == 1) {
                    throw new InvalidTransactionException(TransactionResultCode.suspect_txn);
                }
            } else if (LOG.isDebugEnabled()) {
                LOG.debug("process: no classifier for card found: cardKey={}", cardKey);
            }

            // score the txn and check against threshold

            // score the account and check against threshold

            // score the vendor and check against threshold

            // update the balance
            boolean done = false;
            for (int i = 0; !done && i < 3; ++i) {
                CardBalance newCardBal = new CardBalance();

                newCardBal.setAccountId(acctId);
                newCardBal.setCardId(cardId);
                newCardBal.setBalance(cardBal.getBalance() + amt);

                done = cardBalanceDAO.replace(cardKey, cardBal, newCardBal);
                LOG.debug("process: done={}, cardKey={}, cardBal={}, newCardBal={}", done, cardKey, cardBal, newCardBal);
            }

            if (!done) {
                throw new IllegalArgumentException("Cannot update balance");
            }

            // update the txn history
            updateHistory(txn, TransactionStatusCode.completed, TransactionResultCode.in_process);

            // update txn status
            updateStatus(txnKey, TransactionStatusCode.completed, TransactionResultCode.success);

            resp.setResultCode(TransactionResultCode.success);
        } catch (InvalidTransactionException x) {
            LOG.error("process: x={}", x.toString());
            TransactionResultCode resultCode = x.getResultCode();

            // update the txn history
            updateHistory(txn, TransactionStatusCode.completed, resultCode);

            // update the txn status
            updateStatus(txnKey, TransactionStatusCode.completed, resultCode);

            // set response
            resp.setResultCode(resultCode);
        } catch (Exception x) {
            LOG.error("process: x={}", x.toString(), x);
            updateHistory(txn, TransactionStatusCode.completed, TransactionResultCode.error);
            updateStatus(txnKey, TransactionStatusCode.completed, TransactionResultCode.error);
            resp.setResultCode(TransactionResultCode.error);
        }
    }

    private Transaction findMostRecent(AccountKey acctKey) {
        LOG.debug("findMostRecent: acctKey={}", acctKey);
        AccountAggregate acctAggr = this.accountAggregateDAO.retrieve(acctKey);
        List<TransactionAggregate> txnAggrs = acctAggr.getTransactions();

        for (int i = txnAggrs.size() - 1; i >= 0; --i) {
            TransactionAggregate txnAggr = txnAggrs.get(i);
            Transaction txn = txnAggr.getTransaction();
            TransactionKey txnKey = new TransactionKey(txn.getTransactionId(), txn.getAccountId());
            TransactionStatus txnStatus = this.transactionStatusDAO.retrieve(txnKey);

            if (txnStatus.getTransactionStatusCode() == TransactionStatusCode.completed
                    && txnStatus.getTransactionResultCode() == TransactionResultCode.success) {
                VendorKey vendorKey = new VendorKey(txn.getVendorId());
                Vendor vendor = this.vendorDAO.retrieve(vendorKey);

                if (vendor.getVendorType() == VendorType.physical) {
                    LOG.debug("findMostRecent: acctKey={}, txn={}", acctKey, txn);
                    return txn;
                }
            }
        }

        LOG.debug("findMostRecent: no txn found: acctKey={}", acctKey);
        return null;
    }

    private void updateHistory(Transaction txn, TransactionStatusCode status, TransactionResultCode result) {
        String txnHistId = UUID.randomUUID().toString();
        LOG.debug("updateHistory: txnHistId={}, txn={}, status={}, result={}", txnHistId, txn, status, result);

        String txnId = txn.getTransactionId();
        TransactionHistoryKey txnHistKey = new TransactionHistoryKey(txnHistId, txnId);

        TransactionHistory txnHist = new TransactionHistory(txn);

        txnHist.setTransactionHistoryId(txnHistId);
        txnHist.setTransactionId(txnId);
        txnHist.setUpdatedOn(new Date());
        txnHist.setTransactionStatusCode(status);
        txnHist.setTransactionResultCode(result);

        transactionHistoryDAO.store(txnHistKey, txnHist);
    }

    private void updateStatus(TransactionKey key, TransactionStatusCode status, TransactionResultCode result) {
        LOG.debug("updateStatus: key={}, status={}, result={}", key, status, result);
        TransactionStatus txnStatus = new TransactionStatus();

        txnStatus.setTransactionId(key.getId());
        txnStatus.setAccountId(key.getColocationId());
        txnStatus.setTransactionStatusCode(status);
        txnStatus.setTransactionResultCode(result);

        transactionStatusDAO.put(key, txnStatus);
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
