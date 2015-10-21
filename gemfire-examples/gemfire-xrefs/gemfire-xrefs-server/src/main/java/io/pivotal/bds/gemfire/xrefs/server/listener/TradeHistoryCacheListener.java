package io.pivotal.bds.gemfire.xrefs.server.listener;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import com.gemstone.gemfire.cache.EntryEvent;
import com.gemstone.gemfire.cache.Region;
import com.gemstone.gemfire.cache.util.CacheListenerAdapter;

import io.pivotal.bds.gemfire.data.securities.AccountHistory;
import io.pivotal.bds.gemfire.data.securities.AccountHistoryKey;
import io.pivotal.bds.gemfire.data.securities.AccountKey;
import io.pivotal.bds.gemfire.data.securities.AccountStatus;
import io.pivotal.bds.gemfire.data.securities.SecurityKey;
import io.pivotal.bds.gemfire.data.securities.SecurityPriceHistory;
import io.pivotal.bds.gemfire.data.securities.SecurityPriceHistoryKey;
import io.pivotal.bds.gemfire.data.securities.Trade;
import io.pivotal.bds.gemfire.data.securities.TradeKey;
import io.pivotal.bds.gemfire.keyfw.generator.ColocationKeyGenerator;

public class TradeHistoryCacheListener extends CacheListenerAdapter<TradeKey, Trade> {

    private Region<AccountHistoryKey, AccountHistory> accountHistoryRegion;
    private Region<AccountKey, AccountStatus> accountStatusRegion;
    private Region<SecurityPriceHistoryKey, SecurityPriceHistory> priceHistoryRegion;

    private ColocationKeyGenerator<Long, String> keyGenerator;

    private static final Logger LOG = LoggerFactory.getLogger(TradeHistoryCacheListener.class);

    public TradeHistoryCacheListener(Region<AccountHistoryKey, AccountHistory> accountHistoryRegion,
            Region<AccountKey, AccountStatus> accountStatusRegion,
            Region<SecurityPriceHistoryKey, SecurityPriceHistory> priceHistoryRegion,
            ColocationKeyGenerator<Long, String> keyGenerator) {
        this.accountHistoryRegion = accountHistoryRegion;
        this.accountStatusRegion = accountStatusRegion;
        this.priceHistoryRegion = priceHistoryRegion;
        this.keyGenerator = keyGenerator;
    }

    @Override
    public void afterCreate(EntryEvent<TradeKey, Trade> event) {
        Trade tr = event.getNewValue();
        LOG.info("afterCreate: tr={}", tr);

        Date now = new Date();

        Date d = tr.getDate();
        double price = tr.getPrice();
        double total = price * tr.getQuantity();

        AccountKey ak = tr.getAccountKey();
        SecurityKey sk = tr.getSecurityKey();

        // update the account balance
        AccountStatus as = accountStatusRegion.get(ak);
        Assert.notNull(as, "Status for account " + ak.getId() + " not found");

        double balance = as.getBalance() - total;
        AccountStatus nas = new AccountStatus(ak, now, balance);

        if (!accountStatusRegion.replace(ak, as, nas)) {
            throw new IllegalArgumentException("Account status update failed");
        }

        // add account history
        AccountHistoryKey hk = keyGenerator.generate(AccountHistoryKey.class, ak.getId());
        AccountHistory ah = new AccountHistory(hk, ak, d, balance);
        accountHistoryRegion.put(hk, ah);

        // add price history
        SecurityPriceHistoryKey sphk = keyGenerator.generate(SecurityPriceHistoryKey.class, sk.getId());
        SecurityPriceHistory sph = new SecurityPriceHistory(sphk, d, sk, price);
        priceHistoryRegion.put(sphk, sph);
    }
}
