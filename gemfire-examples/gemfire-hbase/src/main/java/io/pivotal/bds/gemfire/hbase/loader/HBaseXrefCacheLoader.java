package io.pivotal.bds.gemfire.hbase.loader;

import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import com.gemstone.gemfire.cache.CacheLoader;
import com.gemstone.gemfire.cache.CacheLoaderException;
import com.gemstone.gemfire.cache.Declarable;
import com.gemstone.gemfire.cache.LoaderHelper;

import io.pivotal.bds.gemfire.hbase.util.HBaseHelper;

public class HBaseXrefCacheLoader<K, V> implements CacheLoader<K, List<V>>, Declarable {

    private int xrefFieldLength;
    private int keyFieldLength;

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
    public List<V> load(LoaderHelper<K, List<V>> helper) throws CacheLoaderException {
        LOG.debug("load: helper={}", helper);

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

            List<V> list = HBaseHelper.scan(start, end, rn);
            LOG.debug("load: rn={}, key={}, list={}", rn, key, list);

            return list.isEmpty() ? null : list;
        } catch (CacheLoaderException x) {
            LOG.error("load: x={}", x.toString(), x);
            throw x;
        } catch (Exception x) {
            LOG.error("load: x={}", x.toString(), x);
            throw new CacheLoaderException(x.toString(), x);
        }
    }

}
