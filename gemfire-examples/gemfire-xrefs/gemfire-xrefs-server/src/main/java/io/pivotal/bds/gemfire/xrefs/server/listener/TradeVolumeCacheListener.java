package io.pivotal.bds.gemfire.xrefs.server.listener;

import java.util.function.Consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gemstone.gemfire.cache.EntryEvent;
import com.gemstone.gemfire.cache.Region;
import com.gemstone.gemfire.cache.util.CacheListenerAdapter;

import io.pivotal.bds.gemfire.data.securities.AccountKey;
import io.pivotal.bds.gemfire.data.securities.AccountNotification;
import io.pivotal.bds.gemfire.data.securities.AccountNotificationKey;
import io.pivotal.bds.gemfire.data.securities.ChangeAttributeType;
import io.pivotal.bds.gemfire.data.securities.ChangeRule;
import io.pivotal.bds.gemfire.data.securities.ChangeRuleKey;
import io.pivotal.bds.gemfire.data.securities.ChangeValueType;
import io.pivotal.bds.gemfire.data.securities.SecurityKey;
import io.pivotal.bds.gemfire.data.securities.Trade;
import io.pivotal.bds.gemfire.data.securities.TradeKey;
import io.pivotal.bds.gemfire.keyfw.generator.ColocationKeyGenerator;
import io.pivotal.bds.gemfire.xrefs.server.data.PDXConcurrentList;

public class TradeVolumeCacheListener extends CacheListenerAdapter<TradeKey, Trade> {

    private Region<SecurityKey, PDXConcurrentList<ChangeRuleKey>> xrefRegion;
    private Region<ChangeRuleKey, ChangeRule> changeRuleRegion;
    private Region<AccountNotificationKey, AccountNotification> notificationRegion;
    private ColocationKeyGenerator<Long, String> keyGenerator;

    private static final Logger LOG = LoggerFactory.getLogger(TradeVolumeCacheListener.class);

    public TradeVolumeCacheListener(Region<SecurityKey, PDXConcurrentList<ChangeRuleKey>> xrefRegion,
            Region<ChangeRuleKey, ChangeRule> changeRuleRegion,
            Region<AccountNotificationKey, AccountNotification> notificationRegion,
            ColocationKeyGenerator<Long, String> keyGenerator) {
        this.xrefRegion = xrefRegion;
        this.changeRuleRegion = changeRuleRegion;
        this.notificationRegion = notificationRegion;
        this.keyGenerator = keyGenerator;
    }

    @Override
    public void afterCreate(EntryEvent<TradeKey, Trade> event) {
        Trade tr = event.getNewValue();
        LOG.info("afterCreate: tr={}", tr);

        SecurityKey sk = tr.getSecurityKey();
        final int quan = tr.getQuantity();

        PDXConcurrentList<ChangeRuleKey> keys = xrefRegion.get(sk);

        keys.forEach(new Consumer<ChangeRuleKey>() {

            @Override
            public void accept(ChangeRuleKey t) {
                ChangeRule rule = changeRuleRegion.get(t);
                ChangeAttributeType attrType = rule.getAttributeType();

                if (attrType == ChangeAttributeType.volume) {
                    double max = rule.getMaximum();
                    double vol = quan;

                    if (vol >= max) {
                        AccountKey ak = rule.getAccountKey();
                        LOG.info("afterCreate: notif, tr={}, ak={}, vol={}, max={}", tr, ak, vol, max);

                        AccountNotificationKey ank = keyGenerator.generate(AccountNotificationKey.class, ak.getId());
                        AccountNotification an = new AccountNotification(ank, ak, ChangeValueType.absolute,
                                ChangeAttributeType.volume, vol, max);

                        notificationRegion.put(ank, an);
                    }
                }
            }
        });
    }
}
