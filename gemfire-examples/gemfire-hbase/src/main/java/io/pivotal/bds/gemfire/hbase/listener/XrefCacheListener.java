package io.pivotal.bds.gemfire.hbase.listener;

import java.util.Properties;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import org.apache.geode.cache.Declarable;
import org.apache.geode.cache.EntryEvent;
import org.apache.geode.cache.Operation;
import org.apache.geode.cache.Region;
import org.apache.geode.cache.util.CacheListenerAdapter;
import org.apache.geode.pdx.PdxInstance;

import io.pivotal.bds.gemfire.hbase.util.DSLockingHashSetFactory;
import io.pivotal.bds.gemfire.util.RegionHelper;

public class XrefCacheListener<K> extends CacheListenerAdapter<K, PdxInstance>implements Declarable {

    private String xrefRegionName;
    private String fieldName;

    private DSLockingHashSetFactory<K> factory = new DSLockingHashSetFactory<K>();

    private static final Logger LOG = LoggerFactory.getLogger(XrefCacheListener.class);

    @Override
    public void init(Properties props) {
        xrefRegionName = props.getProperty("xrefRegionName");
        fieldName = props.getProperty("fieldName");
        LOG.info("init: xrefRegionName={}, fieldName={}", xrefRegionName, fieldName);

        Assert.notNull(xrefRegionName, "Property 'xrefRegionName' not found");
        Assert.notNull(fieldName, "Property 'fieldName' not found");
    }

    @Override
    public void afterCreate(EntryEvent<K, PdxInstance> event) {
        Operation op = event.getOperation();

        if (!op.isLoad()) {
            K key = event.getKey();
            PdxInstance inst = event.getNewValue();
            Object fieldValue = inst.getField(fieldName);

            if (fieldValue == null) {
                LOG.debug("afterCreate: field value is null: key={}, fieldName={}, inst={}", key, fieldName, inst);
            } else {
                LOG.debug("afterCreate: key={}, fieldValue={}, fieldName={}", key, fieldValue, fieldName);
                Region<Object, Set<K>> xrefRegion = RegionHelper.getRegion(xrefRegionName);
                Set<K> set = xrefRegion.get(fieldValue, factory);
                set.add(key);
                xrefRegion.put(fieldValue, set);
            }
        } else {
            LOG.debug("afterCreate: operation is a load: event={}", event);
        }
    }

    @Override
    public void afterDestroy(EntryEvent<K, PdxInstance> event) {
        Operation op = event.getOperation();

        if (!op.isEviction() && !op.isExpiration()) {
            K key = event.getKey();
            PdxInstance inst = event.getOldValue();
            Object fieldValue = inst.getField(fieldName);

            if (fieldValue == null) {
                LOG.debug("afterDestroy: field value is null: key={}, fieldName={}, inst={}", key, fieldName, inst);
            } else {
                LOG.debug("afterDestroy: key={}, fieldValue={}, fieldName={}", key, fieldValue, fieldName);
                Region<Object, Set<K>> xrefRegion = RegionHelper.getRegion(xrefRegionName);
                Set<K> set = xrefRegion.get(fieldValue, factory);
                set.remove(key);
                xrefRegion.put(fieldValue, set);
            }
        } else {
            LOG.debug("afterDestroy: operation is a expire or evict: event={}", event);
        }
    }

    @Override
    public void afterUpdate(EntryEvent<K, PdxInstance> event) {
        K key = event.getKey();
        PdxInstance newInst = event.getNewValue();
        PdxInstance oldInst = event.getOldValue();

        Object newFieldValue = newInst == null ? null : newInst.getField(fieldName);
        Object oldFieldValue = oldInst == null ? null : oldInst.getField(fieldName);

        LOG.debug("afterUpdate: key={}, fieldName={}, oldFieldValue={}, newFieldValue={}", key, fieldName, oldFieldValue,
                newFieldValue);

        Region<Object, Set<K>> xrefRegion = RegionHelper.getRegion(xrefRegionName);

        if (oldFieldValue != null && newFieldValue != null) {
            if (!newFieldValue.equals(oldFieldValue)) {
                LOG.debug("afterUpdate: xref changed: key={}, oldFieldValue={}, newFieldValue={}", key, oldFieldValue,
                        newFieldValue);

                Set<K> oldSet = xrefRegion.get(oldFieldValue, factory);
                oldSet.remove(key);
                xrefRegion.put(oldFieldValue, oldSet);

                Set<K> newSet = xrefRegion.get(newFieldValue, factory);
                newSet.add(key);
                xrefRegion.put(newFieldValue, newSet);
            } else {
                LOG.debug("afterUpdate: xref field is the same: key={}, oldFieldValue={}, newFieldValue={}", key, oldFieldValue,
                        newFieldValue);
            }
        } else if (oldFieldValue != null) {
            LOG.debug("afterUpdate: xref removed: key={}, oldFieldValue={}", key, oldFieldValue);

            Set<K> oldSet = xrefRegion.get(oldFieldValue, factory);
            oldSet.remove(key);
            xrefRegion.put(oldFieldValue, oldSet);
        } else if (newFieldValue != null) {
            LOG.debug("afterUpdate: xref added: key={}, newFieldValue={}", key, newFieldValue);

            Set<K> newSet = xrefRegion.get(newFieldValue, factory);
            newSet.add(key);
            xrefRegion.put(newFieldValue, newSet);
        } else {
            LOG.debug("afterUpdate: xref field remains null: key={}", key);
        }
    }
}
