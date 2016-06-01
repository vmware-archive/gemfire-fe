package io.pivotal.bds.gemfire.fraud.test;

import io.pivotal.bds.gemfire.fraud.common.data.TransactionResultCode;
import io.pivotal.bds.gemfire.fraud.common.data.TransactionStatus;
import io.pivotal.bds.gemfire.fraud.common.key.TransactionKey;

public class UpdateTxnStatus extends BaseTest {

    @Override
    protected void go() throws Exception {
        TransactionKey key = new TransactionKey("66767446-4d15-4667-9a12-bda0f9437c18", "account-6");
        TransactionStatus txnStatus = transactionStatusRegion.get(key);
        txnStatus.setTransactionResultCode(TransactionResultCode.suspect_txn);
        transactionStatusRegion.put(key, txnStatus);
    }

    public static void main(String[] args) throws Exception {
        new UpdateTxnStatus().run(args);
    }
}
