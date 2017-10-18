package io.pivotal.bds.gemfire.r.server.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.geode.cache.Operation;
import org.apache.geode.cache.Region;
import org.apache.geode.pdx.PdxInstance;

import io.pivotal.bds.gemfire.r.common.MatrixKey;
import io.pivotal.bds.gemfire.r.common.Vector;
import io.pivotal.bds.gemfire.r.common.VectorKey;
import io.pivotal.bds.gemfire.r.common.Window;
import io.pivotal.bds.gemfire.r.common.WindowDef;
import io.pivotal.bds.gemfire.r.common.WindowKey;
import io.pivotal.bds.gemfire.util.RegionHelper;

public class WindowHandler extends Handler {

    private WindowKey<String> windowKey;
    private String[] fieldNames;
    private int size;
    private Object targetKey;

    private static final Logger LOG = LoggerFactory.getLogger(WindowHandler.class);

    public WindowHandler(WindowKey<String> windowKey, WindowDef windowDef) {
        super(windowKey, windowDef.getRegionName());
        this.windowKey = windowKey;
        this.fieldNames = windowDef.getFieldNames();
        this.size = windowDef.getSize();
        this.targetKey = windowDef.getTargetKey();
    }

    @Override
    public void doHandle(String regionName, Operation op, Object key, Object value) {
        LOG.debug("doHandle: regionName={}, op={}, key={}, value={}", regionName, op, key, value);

        if (!op.isCreate() && !op.isUpdate()) {
            return;
        }

        PdxInstance inst = (PdxInstance) value;

        if (VectorKey.class.isInstance(targetKey)) {
            String fn = fieldNames[0];
            Object t = inst.getField(fn);
            Number n = convert(t);
            LOG.debug("doHandle: regionName={}, key={}, fn={}, n={}", regionName, key, fn, n);

            Region<WindowKey<String>, Window<Number>> r = RegionHelper.getRegion("window");

            Window<Number> window = r.get(windowKey, size);
            window.add(n);

            r.put(windowKey, window);
        } else if (MatrixKey.class.isInstance(targetKey)) {
            LOG.debug("doHandle: regionName={}, key={}, fieldNames={}", regionName, key, Arrays.toString(fieldNames));
            List<Number> fieldValues = new ArrayList<>();

            for (String fn : fieldNames) {
                Object t = inst.getField(fn);
                Number n = convert(t);
                fieldValues.add(n);
            }

            LOG.debug("doHandle: regionName={}, key={}, fieldValues={}", regionName, key, fieldValues);
            Vector<Number> vector = new Vector<>(fieldValues);
            Region<WindowKey<String>, Window<Vector<Number>>> r = RegionHelper.getRegion("window");

            Window<Vector<Number>> window = r.get(windowKey, size);
            window.add(vector);

            r.put(windowKey, window);
        } else {
            throw new IllegalArgumentException("Expected matrix or vector, got " + targetKey.getClass().getName());
        }
    }

    private static Number convert(Object t) {
        if (t == null) {
            throw new NullPointerException("Expected a number but was null");
        }

        if (Number.class.isInstance(t)) {
            return Number.class.cast(t);
        } else {
            throw new IllegalArgumentException("Field is not a number, but " + t.getClass().getName());
        }
    }

}
