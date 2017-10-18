package io.pivotal.bds.gemfire.r.server.function;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.math3.complex.Complex;
import org.apache.commons.math3.transform.DftNormalization;
import org.apache.commons.math3.transform.FastFourierTransformer;
import org.apache.commons.math3.transform.TransformType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import org.apache.geode.cache.Declarable;
import org.apache.geode.cache.Region;
import org.apache.geode.cache.execute.Function;
import org.apache.geode.cache.execute.FunctionContext;
import org.apache.geode.cache.execute.FunctionException;
import org.apache.geode.cache.execute.RegionFunctionContext;
import org.apache.geode.cache.execute.ResultSender;

import io.pivotal.bds.gemfire.r.common.FFTRequest;
import io.pivotal.bds.gemfire.r.common.FFTResponse;
import io.pivotal.bds.gemfire.r.common.Matrix;
import io.pivotal.bds.gemfire.r.common.MatrixKey;
import io.pivotal.bds.gemfire.r.common.Vector;
import io.pivotal.bds.gemfire.r.common.VectorKey;
import io.pivotal.bds.gemfire.util.RegionHelper;

@SuppressWarnings("serial")
public class FFTFunction implements Function, Declarable {

    private static final Logger LOG = LoggerFactory.getLogger(FFTFunction.class);

    @SuppressWarnings("unchecked")
    @Override
    public void execute(FunctionContext ctx) {
        try {
            ResultSender<FFTResponse> sender = ctx.getResultSender();
            RegionFunctionContext rctx = (RegionFunctionContext) ctx;

            Set<?> filter = rctx.getFilter();
            LOG.debug("execute: filter={}", filter);
            List<FFTResponse> results = new ArrayList<>();

            for (Object of : filter) {
                FFTRequest req = (FFTRequest) of;
                LOG.debug("execute: req={}", req);

                try {
                    DftNormalization norm = DftNormalization.valueOf(req.getNormalization());
                    TransformType type = TransformType.valueOf(req.getType());
                    Object input = req.getInput();

                    Complex[] x = null;

                    if (input instanceof VectorKey) {
                        VectorKey vectorKey = (VectorKey) input;
                        Region<VectorKey, Vector<Number>> vectorRegion = RegionHelper.getRegion("vector");
                        Vector<Number> vector = vectorRegion.get(vectorKey);
                        Assert.notNull(vector, "Vector " + vectorKey + " not found");
                        x = convert(vector);
                    } else if (input instanceof MatrixKey) {
                        MatrixKey matrixKey = (MatrixKey) input;
                        Region<MatrixKey, Matrix<Number>> matrixRegion = RegionHelper.getRegion("matrix");
                        Matrix<Number> matrix = matrixRegion.get(matrixKey);
                        Assert.notNull(matrix, "Matrix " + matrixKey + " not found");
                        x = convert(matrix);
                    } else if (input instanceof Vector) {
                        Vector<Number> v = (Vector<Number>) input;
                        x = convert(v);
                    } else if (input instanceof Matrix) {
                        Matrix<Number> m = (Matrix<Number>) input;
                        x = convert(m);
                    }

                    FastFourierTransformer fft = new FastFourierTransformer(norm);
                    Complex[] y = fft.transform(x, type);

                    List<Vector<Number>> rows = new ArrayList<>();

                    for (Complex c : y) {
                        List<Number> lrow = new ArrayList<>();

                        lrow.add(c.getReal());
                        lrow.add(c.getImaginary());

                        Vector<Number> row = new Vector<>(lrow);
                        rows.add(row);
                    }

                    Matrix<Number> matrix = new Matrix<>(rows);
                    MatrixKey matrixKey = req.getMatrixKey();

                    Region<MatrixKey, Matrix<Number>> matrixRegion = RegionHelper.getRegion("matrix");
                    matrixRegion.put(matrixKey, matrix);

                    FFTResponse resp = new FFTResponse(req, matrixKey);
                    LOG.debug("execute: resp={}", resp);

                    results.add(resp);
                } catch (Exception x) {
                    LOG.error("execute: req={}, x={}", req, x.toString(), x);
                    FFTResponse resp = new FFTResponse(req, x.getMessage());
                    results.add(resp);
                }
            }

            Iterator<FFTResponse> iter = results.iterator();

            while (iter.hasNext()) {
                FFTResponse res = iter.next();

                if (iter.hasNext()) {
                    sender.sendResult(res);
                } else {
                    sender.lastResult(res);
                }
            }
        } catch (Exception x) {
            LOG.error("execute: x={}", x.toString(), x);
            throw new FunctionException(x.toString(), x);
        }
    }

    private static Complex[] convert(Matrix<Number> m) {
        List<Vector<Number>> rows = m.getRows();
        int nrows = calcPow2(rows.size());

        Complex[] c = new Complex[nrows];

        for (int i = 0; i < nrows; ++i) {
            List<Number> row = rows.get(i).getVector();
            if (row.size() > 1) {
                c[i] = new Complex(row.get(0).doubleValue(), row.get(1).doubleValue());
            } else {
                c[i] = new Complex(row.get(0).doubleValue());
            }
        }

        return c;
    }

    private static int calcPow2(int x) {
        Double e = Math.log(x) / Math.log(2);
        e = Math.pow(2, e.intValue());
        return e.intValue();
    }

    private static Complex[] convert(Vector<Number> v) {
        List<Number> rows = v.getVector();
        int nrows = calcPow2(rows.size());

        Complex[] c = new Complex[nrows];

        for (int i = 0; i < nrows; ++i) {
            c[i] = new Complex(rows.get(i).doubleValue());
        }

        return c;
    }

    @Override
    public void init(Properties props) {
    }

    @Override
    public String getId() {
        return getClass().getSimpleName();
    }

    @Override
    public boolean hasResult() {
        return true;
    }

    @Override
    public boolean isHA() {
        return false;
    }

    @Override
    public boolean optimizeForWrite() {
        return true;
    }
}
