package io.pivotal.bds.gemfire.r.server.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import org.apache.geode.cache.CacheFactory;
import org.apache.geode.cache.Region;
import org.apache.geode.cache.query.Query;
import org.apache.geode.cache.query.QueryService;
import org.apache.geode.cache.query.SelectResults;
import org.apache.geode.cache.query.Struct;

import io.pivotal.bds.gemfire.r.common.Matrix;
import io.pivotal.bds.gemfire.r.common.VariableType;
import io.pivotal.bds.gemfire.r.common.Vector;
import io.pivotal.bds.gemfire.util.RegionHelper;

public class Utils {

    private static final Logger LOG = LoggerFactory.getLogger(Utils.class);

    public static int[] convertToIntArray(Vector<Object> v) {
        List<Object> l = v.getVector();

        if (l.isEmpty()) {
            return null;
        }

        int[] t = new int[l.size()];

        for (int i = 0; i < t.length; ++i) {
            Object o = l.get(i);

            if (Number.class.isInstance(o)) {
                Number n = Number.class.cast(o);
                t[i] = n.intValue();
            } else {
                throw new IllegalArgumentException("Expecting a number, got " + o.getClass().getName());
            }
        }

        return t;
    }

    public static Number[] convertToNumberArray(Vector<Object> v) {
        List<Object> l = v.getVector();

        if (l.isEmpty()) {
            return null;
        }

        Number[] t = new Number[l.size()];

        for (int i = 0; i < t.length; ++i) {
            Object o = l.get(i);

            if (Number.class.isInstance(o)) {
                Number n = Number.class.cast(o);
                t[i] = n;
            } else {
                throw new IllegalArgumentException("Expecting a number, got " + o.getClass().getName());
            }
        }

        return t;
    }

    public static double[] convertNumberVectorToDoubleArray(Vector<Number> v) {
        List<Number> l = v.getVector();

        if (l.isEmpty()) {
            return null;
        }

        double[] t = new double[l.size()];

        return t;
    }

    public static double[] convertObjectVectorToDoubleArray(Vector<Object> v) {
        List<Object> l = v.getVector();

        if (l.isEmpty()) {
            return null;
        }

        double[] t = new double[l.size()];

        for (int i = 0; i < t.length; ++i) {
            Object o = l.get(i);

            if (Number.class.isInstance(o)) {
                Number n = Number.class.cast(o);
                t[i] = n.doubleValue();
            } else {
                throw new IllegalArgumentException("Expecting a number, got " + o.getClass().getName());
            }
        }

        return t;
    }

    public static double[][] convertNumberMatrixToDoubleArray(Matrix<Number> m) {
        List<Vector<Number>> rows = m.getRows();

        if (rows.isEmpty()) {
            return null;
        }

        int nrows = rows.size();
        Vector<Number> v = rows.get(0);
        List<Number> row = v.getVector();
        int ncols = row.size();

        double[][] d = new double[nrows][ncols];

        for (int ir = 0; ir < nrows; ++ir) {
            for (int ic = 0; ic < ncols; ++ic) {
                Number n = rows.get(ir).getVector().get(ic);
                d[ir][ic] = n.doubleValue();
            }
        }

        return d;
    }

    public static double[][] convertObjectMatrixToDoubleArray(Matrix<Object> m) {
        List<Vector<Object>> rows = m.getRows();

        if (rows.isEmpty()) {
            return null;
        }

        int nrows = rows.size();
        Vector<Object> v = rows.get(0);
        List<Object> row = v.getVector();
        int ncols = row.size();

        double[][] d = new double[nrows][ncols];

        for (int ir = 0; ir < nrows; ++ir) {
            for (int ic = 0; ic < ncols; ++ic) {
                Object o = rows.get(ir).getVector().get(ic);

                if (Number.class.isInstance(o)) {
                    Number n = Number.class.cast(o);
                    d[ir][ic] = n.doubleValue();
                } else {
                    throw new IllegalArgumentException("Expecting a number, got " + o.getClass().getName());
                }
            }
        }

        return d;
    }

    public static Vector<Object> getVectorFromQuery(String queryId, Object[] args, String fld) {
        List<Struct> list = doQueryFromId(queryId, args);

        List<Object> rows = new ArrayList<>();
        Vector<Object> v = new Vector<>(rows);

        if (!list.isEmpty()) {
            for (Struct st : list) {
                Object fv = st.get(fld);
                rows.add(fv);
            }
        }

        return v;
    }

    public static Matrix<Object> getMatrixFromQuery(String queryId, Object[] args, String[] flds) {
        List<Struct> list = doQueryFromId(queryId, args);

        Matrix<Object> m = new Matrix<>();
        List<Vector<Object>> lrows = new ArrayList<>();
        m.setRows(lrows);

        if (!list.isEmpty()) {

            for (int ir = 0; ir < list.size(); ++ir) {
                Struct st = list.get(ir);
                List<Object> lrow = new ArrayList<>();
                Vector<Object> row = new Vector<>(lrow);
                lrows.add(row);

                if (flds == null || flds.length == 0) {
                    Object[] fvs = st.getFieldValues();

                    for (int ic = 0; ic < fvs.length; ++ic) {
                        Object fv = fvs[ic];
                        lrow.add(fv);
                    }
                } else {
                    for (int ic = 0; ic < flds.length; ++ic) {
                        Object fv = st.get(flds[ic]);
                        lrow.add(fv);
                    }
                }
            }

            m.setRows(lrows);
        }

        return m;
    }

    public static List<Struct> doQueryFromId(String queryId, List<Object> args) {
        return doQueryFromId(queryId, args == null ? null : args.toArray());
    }

    public static List<Struct> doQueryFromId(String queryId, Object[] args) {
        Region<String, String> r = RegionHelper.getRegion("queries");
        String query = r.get(queryId);
        Assert.hasText(queryId, "Query " + queryId + " does not exist");
        return doQuery(query, args);
    }

    public static List<Struct> doQuery(String query, List<Object> args) {
        return doQuery(query, args == null ? null : args.toArray());
    }

    public static List<Struct> doQuery(String query, Object[] args) {
        try {
            LOG.debug("doQuery: query={}, args={}", query, Arrays.toString(args));

            // TODO check query for limit
            QueryService qs = CacheFactory.getAnyInstance().getQueryService();
            Query q = qs.newQuery(query);

            @SuppressWarnings("unchecked")
            SelectResults<Struct> res = (SelectResults<Struct>) (args == null || args.length == 0 ? q.execute() : q.execute(args));

            // TODO check for struct, x and y fields
            return res.asList();
        } catch (Exception x) {
            LOG.error("doQuery: x={}", x.toString(), x);
            throw new IllegalArgumentException(x.toString(), x);
        }
    }

    public static void addVariableType(Object key, VariableType type) {
        Region<Object, VariableType> r = RegionHelper.getRegion("variableType");
        r.put(key, type);
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
