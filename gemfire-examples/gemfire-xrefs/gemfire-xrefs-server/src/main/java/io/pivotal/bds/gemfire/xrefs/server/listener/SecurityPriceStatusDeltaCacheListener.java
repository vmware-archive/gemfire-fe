package io.pivotal.bds.gemfire.xrefs.server.listener;

import java.util.Set;
import java.util.function.Consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.geode.cache.EntryEvent;
import org.apache.geode.cache.Region;
import org.apache.geode.cache.util.CacheListenerAdapter;

import io.pivotal.bds.gemfire.data.securities.AccountKey;
import io.pivotal.bds.gemfire.data.securities.AccountNotification;
import io.pivotal.bds.gemfire.data.securities.AccountNotificationKey;
import io.pivotal.bds.gemfire.data.securities.ChangeAttributeType;
import io.pivotal.bds.gemfire.data.securities.ChangeRule;
import io.pivotal.bds.gemfire.data.securities.ChangeRuleKey;
import io.pivotal.bds.gemfire.data.securities.ChangeValueType;
import io.pivotal.bds.gemfire.data.securities.SecurityKey;
import io.pivotal.bds.gemfire.data.securities.SecurityPriceStatus;
import io.pivotal.bds.gemfire.keyfw.generator.ColocationKeyGenerator;

public class SecurityPriceStatusDeltaCacheListener extends CacheListenerAdapter<SecurityKey, SecurityPriceStatus> {

    private Region<SecurityKey, Set<ChangeRuleKey>> xrefRegion;
    private Region<ChangeRuleKey, ChangeRule> changeRuleRegion;
    private Region<AccountNotificationKey, AccountNotification> notificationRegion;
    private ColocationKeyGenerator<Long, String> keyGenerator;

    private static final Logger LOG = LoggerFactory.getLogger(SecurityPriceStatusDeltaCacheListener.class);

    public SecurityPriceStatusDeltaCacheListener(Region<SecurityKey, Set<ChangeRuleKey>> xrefRegion,
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
            
            Set<ChangeRuleKey> list = xrefRegion.get(sk);
            
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
