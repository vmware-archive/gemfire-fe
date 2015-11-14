package io.pivotal.bds.gemfire.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.util.Assert;

import com.gemstone.gemfire.cache.CacheFactory;
import com.gemstone.gemfire.cache.Region;

public class RegionHelper {

    private static final Map<String, Region<?, ?>> regions = new HashMap<>();

    private RegionHelper() {
    }

    public static synchronized <K, V> Region<K, V> getRegion(String name) {
        @SuppressWarnings("unchecked")
        Region<K, V> r = (Region<K, V>) regions.get(name);

        if (r == null) {
            r = CacheFactory.getAnyInstance().getRegion(name);
            Assert.notNull(r, "Region " + name + " not found");
            regions.put(name, r);
        }

        return r;
    }
}
