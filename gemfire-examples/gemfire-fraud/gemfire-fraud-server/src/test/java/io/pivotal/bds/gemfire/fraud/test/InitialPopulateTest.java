package io.pivotal.bds.gemfire.fraud.test;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import io.pivotal.bds.gemfire.fraud.common.data.Account;
import io.pivotal.bds.gemfire.fraud.common.data.AccountBalance;
import io.pivotal.bds.gemfire.fraud.common.data.AccountStatus;
import io.pivotal.bds.gemfire.fraud.common.data.Card;
import io.pivotal.bds.gemfire.fraud.common.data.CardBalance;
import io.pivotal.bds.gemfire.fraud.common.data.Vendor;
import io.pivotal.bds.gemfire.fraud.common.data.VendorStatus;
import io.pivotal.bds.gemfire.fraud.common.data.VendorType;
import io.pivotal.bds.gemfire.fraud.common.key.AccountKey;
import io.pivotal.bds.gemfire.fraud.common.key.CardKey;
import io.pivotal.bds.gemfire.fraud.common.key.VendorKey;

public class InitialPopulateTest extends BaseTest {

    private double[] x = { -112.2745736, -112.2753567, -112.2764617, -112.2795597, -112.2394629, -94.5813198, -94.5833708,
            -94.5872574, -94.827274, -94.8747802 };
    private double[] y = { 33.711517, 33.710598, 33.712303, 33.67792, 33.632855, 39.097286, 39.098315, 39.087207, 39.122657,
            38.88568 };
    private static final long initCarNo = 1234567890000000L;

    @Override
    protected void go() throws Exception {
        LOG.info("go: vendors");
        // create vendors
        for (int i = 0; i < x.length; ++i) {
            String vid = "vendor-" + i;
            VendorKey vk = new VendorKey(vid);

            Vendor vendor = new Vendor();

            vendor.setVendorId(vid);
            vendor.setVendorType(i % 2 == 0 ? VendorType.physical : VendorType.virtual);
            vendor.setVendorStatus(VendorStatus.active);
            vendor.setX(x[i]);
            vendor.setY(y[i]);

            vendorRegion.put(vk, vendor);
        }

        Calendar cal = Calendar.getInstance();

        cal.set(Calendar.HOUR, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        cal.setTimeZone(TimeZone.getTimeZone("UTC"));

        cal.add(Calendar.YEAR, -1);
        Date expired = cal.getTime();

        cal.add(Calendar.YEAR, +2);
        Date notExpired = cal.getTime();

        double cardLimit = 1000.0;

        LOG.info("go: accounts");
        // accounts
        long cardNoNdx = 0;
        for (int i = 0; i < 10; ++i) {
            String aid = "account-" + i;
            AccountKey ak = new AccountKey(aid);

            Account acct = new Account();

            acct.setAccountId(aid);
            acct.setLimit(1000 * i);
            acct.setStatus(i % 2 == 0 ? AccountStatus.active : AccountStatus.disabled);

            accountRegion.put(ak, acct);

            AccountBalance bal = new AccountBalance();
            bal.setAccountId(aid);
            bal.setBalance(0.0);

            accountBalanceRegion.put(ak, bal);

            for (int j = 0; j < 2; ++j) {
                String cid = aid + "-" + j;
                CardKey ck = new CardKey(cid, aid);

                long cno = initCarNo + cardNoNdx++;
                String cardNo = Long.toString(cno);

                Card card = new Card();

                card.setAccountId(aid);
                card.setCardId(cid);
                card.setCardNumber(cardNo);
                card.setCcv("123");
                card.setNameOnCard("Bill Smith");
                card.setExpirationDate(j % 2 == 0 ? notExpired : expired);
                card.setCardLimit(cardLimit);
                cardLimit += 1000.0;

                cardRegion.put(ck, card);

                CardBalance cb = new CardBalance();

                cb.setAccountId(aid);
                cb.setCardId(cid);
                cb.setBalance(0.0);

                cardBalanceRegion.put(ck, cb);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new InitialPopulateTest().run(args);
    }
}
