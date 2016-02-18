package io.pivotal.bds.gemfire.r.server.util;

import java.util.ArrayList;
import java.util.List;

import com.gemstone.gemfire.cache.Region;
import com.gemstone.gemfire.cache.query.Struct;

import io.pivotal.bds.gemfire.r.common.VariableType;
import io.pivotal.bds.gemfire.util.RegionHelper;

public class Utils {

    public static void addVariableType(Object key, VariableType type) {
        Region<Object, VariableType> r = RegionHelper.getRegion("variableType");
        if (r.putIfAbsent(key, type) != null) {
            throw new IllegalArgumentException("Variable " + key + " already exists");
        }
    }

    public static void removeVariableType(Object key) {
        Region<Object, VariableType> r = RegionHelper.getRegion("variableType");
        r.remove(key);
    }

    public static Number[] extractIntY(List<Struct> list) {
        int nrows = list.size();
        Number[] y = new Number[nrows];

        int i = 0;
        for (Struct st : list) {
            int yt = getInt(st, "y");
            y[i++] = yt;
        }

        return y;
    }

    public static Number[] extractDoubleY(List<Struct> list) {
        int nrows = list.size();
        Number[] y = new Number[nrows];

        int i = 0;
        for (Struct st : list) {
            double yt = getDouble(st, "y");
            y[i++] = yt;
        }

        return y;
    }

    public static double[] convert(List<Double> list) {
        double[] d = new double[list.size()];
        for (int i = 0; i < d.length; ++i) {
            d[i] = list.get(i);
        }
        return d;
    }

    public static double[] extractX(Struct st) {
        List<Double> xlr = new ArrayList<>();

        for (String fn : st.getStructType().getFieldNames()) {
            if (fn.startsWith("x")) {
                double d = getDouble(st, fn);
                xlr.add(d);
            }
        }

        if (xlr.isEmpty()) {
            throw new IllegalArgumentException("No x values found");
        }

        return convert(xlr);
    }

    public static double[][] extractX(List<Struct> list) {
        int nrows = list.size();
        List<List<Double>> xl = new ArrayList<>();

        int i = 0;
        int ncols = 0;
        for (Struct st : list) {
            List<Double> xlr = new ArrayList<>();

            for (String fn : st.getStructType().getFieldNames()) {
                if (fn.startsWith("x")) {
                    double d = getDouble(st, fn);
                    xlr.add(d);
                }
            }

            if (xlr.isEmpty()) {
                throw new IllegalArgumentException("No x values found");
            }

            if (ncols == 0) {
                ncols = xlr.size();
            } else {
                if (ncols != xlr.size()) {
                    throw new IllegalArgumentException("Invalid number of x values: expected " + ncols + " actual " + xlr.size());
                }
            }

            xl.add(xlr);
        }

        double[][] x = new double[nrows][ncols];

        i = 0;
        for (List<Double> xlr : xl) {
            double[] dt = new double[ncols];

            for (int p = 0; p < ncols; ++p) {
                dt[p] = xlr.get(p);
            }

            x[i++] = dt;
        }

        return x;
    }

    public static Number convert(Object o) {
        if (o == null) {
            throw new NullPointerException("Number is missing");
        }

        if (!Number.class.isInstance(o)) {
            throw new IllegalArgumentException("Object is not a number: " + o);
        }

        return Number.class.cast(o);
    }

    public static double getDouble(Struct st, String fn) {
        Object o = st.get(fn);
        return convert(o).doubleValue();
    }

    public static int getInt(Struct st, String fn) {
        Object o = st.get(fn);
        return convert(o).intValue();
    }
}
