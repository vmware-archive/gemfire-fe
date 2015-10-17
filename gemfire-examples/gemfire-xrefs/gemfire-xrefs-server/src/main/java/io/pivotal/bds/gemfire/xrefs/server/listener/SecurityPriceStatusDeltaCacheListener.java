package io.pivotal.bds.gemfire.xrefs.server.listener;

import java.util.function.Consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gemstone.gemfire.cache.EntryEvent;
import com.gemstone.gemfire.cache.Region;
import com.gemstone.gemfire.cache.util.CacheListenerAdapter;

import io.pivotal.bds.gemfire.keyfw.generator.ColocationKeyGenerator;
import io.pivotal.bds.gemfire.xrefs.common.AccountKey;
import io.pivotal.bds.gemfire.xrefs.common.AccountNotification;
import io.pivotal.bds.gemfire.xrefs.common.AccountNotificationKey;
import io.pivotal.bds.gemfire.xrefs.common.ChangeAttributeType;
import io.pivotal.bds.gemfire.xrefs.common.ChangeRule;
import io.pivotal.bds.gemfire.xrefs.common.ChangeRuleKey;
import io.pivotal.bds.gemfire.xrefs.common.ChangeValueType;
import io.pivotal.bds.gemfire.xrefs.common.SecurityKey;
import io.pivotal.bds.gemfire.xrefs.common.SecurityPriceStatus;
import io.pivotal.bds.gemfire.xrefs.server.data.PDXConcurrentList;

public class SecurityPriceStatusDeltaCacheListener extends CacheListenerAdapter<SecurityKey, SecurityPriceStatus> {

    private Region<SecurityKey, PDXConcurrentList<ChangeRuleKey>> xrefRegion;
    private Region<ChangeRuleKey, ChangeRule> changeRuleRegion;
    private Region<AccountNotificationKey, AccountNotification> notificationRegion;
    private ColocationKeyGenerator<Long, String> keyGenerator;

    private static final Logger LOG = LoggerFactory.getLogger(SecurityPriceStatusDeltaCacheListener.class);

    public SecurityPriceStatusDeltaCacheListener(Region<SecurityKey, PDXConcurrentList<ChangeRuleKey>> xrefRegion,
            Region<ChangeRuleKey, ChangeRule> changeRuleRegion,
            Region<AccountNotificationKey, AccountNotification> notificationRegion,
            ColocationKeyGenerator<Long, String> keyGenerator) {
        this.xrefRegion = xrefRegion;
        this.changeRuleRegion = changeRuleRegion;
        this.notificationRegion = notificationRegion;
        this.keyGenerator = keyGenerator;
    }

    @Override
    public void afterUpdate(EntryEvent<SecurityKey, SecurityPriceStatus> event) {
        SecurityKey sk = event.getKey();
        SecurityPriceStatus oldSps = event.getOldValue();
        SecurityPriceStatus newSps = event.getNewValue();

        double oldPrice = oldSps.getPrice();
        double newPrice = newSps.getPrice();
        double delta = newPrice - oldPrice;

        LOG.info("afterUpdate: sk={}, oldPrice={}, newPrice={}, delta={}", sk, oldPrice, newPrice, delta);

        if (Math.abs(delta) > 0.01) {
            double percent = delta / oldPrice;
            
            PDXConcurrentList<ChangeRuleKey> list = xrefRegion.get(sk);
            
            list.forEach(new Consumer<ChangeRuleKey>() {

                @Override
                public void accept(ChangeRuleKey t) {
                    ChangeRule rule = changeRuleRegion.get(t);
                    ChangeAttributeType attrType = rule.getAttributeType();

                    if (attrType == ChangeAttributeType.price) {
                        AccountKey ak = rule.getAccountKey();
                        ChangeValueType valueType = rule.getValueType();
                        double max = rule.getMaximum();

                        double val = 0.0;

                        switch (valueType) {
                            case absolute: {
                                val = delta;
                                break;
                            }
                            case percentage: {
                                val = percent;
                                break;
                            }
                            default: {
                                throw new IllegalArgumentException("Unknown change rule: " + valueType.name());
                            }
                        }

                        if (val < 0.0) {
                            if (val <= max) {
                                LOG.info("afterUpdate: notif, sk={}, ak={}, val={}, max={}", sk, ak, val, max);

                                AccountNotificationKey ank = keyGenerator.generate(AccountNotificationKey.class, ak.getId());
                                AccountNotification an = new AccountNotification(ank, ak, valueType, ChangeAttributeType.price, val,
                                        max);

                                notificationRegion.put(ank, an);
                            }
                        } else {
                            if (val >= max) {
                                LOG.info("afterUpdate: notif, sk={}, ak={}, val={}, max={}", sk, ak, val, max);

                                AccountNotificationKey ank = keyGenerator.generate(AccountNotificationKey.class, ak.getId());
                                AccountNotification an = new AccountNotification(ank, ak, valueType, ChangeAttributeType.price, val,
                                        max);

                                notificationRegion.put(ank, an);
                            }
                        }
                    }
                }
            });
        }
    }
}
