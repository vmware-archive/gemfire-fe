package io.pivotal.bds.gemfire.hbase.loader;

import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import com.gemstone.gemfire.cache.CacheLoader;
import com.gemstone.gemfire.cache.CacheLoaderException;
import com.gemstone.gemfire.cache.Declarable;
import com.gemstone.gemfire.cache.LoaderHelper;

import io.pivotal.bds.gemfire.hbase.util.Factory;
import io.pivotal.bds.gemfire.hbase.util.HBaseHelper;
import io.pivotal.bds.gemfire.util.DSLockingHashSet;
import io.pivotal.bds.metrics.timer.Timer;

public class HBaseXrefCacheLoader<K, V> implements CacheLoader<K, Set<V>>, Declarable {

    private int xrefFieldLength;
    private int keyFieldLength;

    private static final Timer timer = new Timer("HBaseCacheLoader");
    private static final Logger LOG = LoggerFactory.getLogger(HBaseXrefCacheLoader.class);

    @Override
    public void init(Properties props) {
        String xfl = props.getProperty("xrefFieldLength");
        String kfl = props.getProperty("keyFieldLength");
        LOG.info("init: xrefFieldLength={}, keyFieldLength={}", xfl, kfl);

        Assert.hasText(xfl, "Missing property 'xrefFieldLength'");
        Assert.hasText(kfl, "Missing property 'keyFieldLength'");

        xrefFieldLength = Integer.parseInt(xfl);
        keyFieldLength = Integer.parseInt(kfl);
    }

    @Override
    public void close() {
    }

    @Override
    public Set<V> load(LoaderHelper<K, Set<V>> helper) throws CacheLoaderException {
        LOG.debug("load: helper={}", helper);

        @SuppressWarnings("unchecked")
        Factory<Set<V>> factory = (Factory<Set<V>>) helper.getArgument();

        if (factory != null) {
            LOG.debug("load: using factory");
            return factory.create();
        }

        try {
            String rn = helper.getRegion().getName();
            K key = helper.getKey();
            LOG.debug("load: rn={}, key={}", rn, key);

            byte[] bx = HBaseHelper.serialize(key);

            if (bx.length > xrefFieldLength) {
                throw new CacheLoaderException("Xref field too long: max=" + xrefFieldLength + ", actual=" + bx.length);
            }

            byte[] start = new byte[xrefFieldLength + keyFieldLength];
            Arrays.fill(start, (byte) 0);

            System.arraycopy(bx, 0, start, 0, bx.length);

            byte[] end = new byte[xrefFieldLength + keyFieldLength];
            Arrays.fill(end, (byte) 0);
            Arrays.fill(end, xrefFieldLength, end.length, (byte) 0xff);

            System.arraycopy(bx, 0, end, 0, bx.length);

            if (LOG.isDebugEnabled()) {
                LOG.debug("load: rn={}, key={}, start={}, end={}", rn, key, Arrays.toString(start), Arrays.toString(end));
            }

            timer.start();
            List<V> list = HBaseHelper.scan(start, end, rn);
            timer.end();

            LOG.debug("load: rn={}, key={}, list={}", rn, key, list);

            return list.isEmpty() ? null : new DSLockingHashSet<>(list);
        } catch (CacheLoaderException x) {
            LOG.error("load: x={}", x.toString(), x);
            throw x;
        } catch (Exception x) {
            LOG.error("load: x={}", x.toString(), x);
            throw new CacheLoaderException(x.toString(), x);
        }
    }

}
