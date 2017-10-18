package io.pivotal.bds.gemfire.r.server.function;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import org.apache.geode.cache.Declarable;
import org.apache.geode.cache.Region;
import org.apache.geode.cache.execute.Function;
import org.apache.geode.cache.execute.FunctionContext;
import org.apache.geode.cache.execute.FunctionException;

import io.pivotal.bds.gemfire.r.common.CbindRequest;
import io.pivotal.bds.gemfire.r.common.Matrix;
import io.pivotal.bds.gemfire.r.common.MatrixKey;
import io.pivotal.bds.gemfire.r.common.Vector;
import io.pivotal.bds.gemfire.r.common.VectorKey;
import io.pivotal.bds.gemfire.util.RegionHelper;

@SuppressWarnings("serial")
public class CbindFunction implements Function, Declarable {

    private static final Logger LOG = LoggerFactory.getLogger(CbindFunction.class);

    @Override
    public void execute(FunctionContext ctx) {
        try {
            CbindRequest req = (CbindRequest) ctx.getArguments();
            LOG.debug("execute: req={}", req);

            MatrixKey srcMatrixKey = req.getSrcMatrixKey();
            MatrixKey destMatrixKey = req.getDestMatrixKey();
            VectorKey vectorKey = req.getVectorKey();

            Region<MatrixKey, Matrix<Object>> matrixRegion = RegionHelper.getRegion("matrix");
            Region<VectorKey, Vector<Object>> vectorRegion = RegionHelper.getRegion("vector");

            Matrix<Object> srcMatrix = matrixRegion.get(srcMatrixKey);
            Assert.notNull(srcMatrix, "Source matrix " + srcMatrixKey.getId() + " not found");

            Vector<Object> vector = vectorRegion.get(vectorKey);
            Assert.notNull(vector, "Vector " + vectorKey.getId() + " not found");

            List<Vector<Object>> srcRows = srcMatrix.getRows();

            if (vector.getVector().size() != srcRows.size()) {
                throw new IllegalArgumentException("Length of vector the number of rows of matrix does not match");
            }

            List<Vector<Object>> destRows = new ArrayList<>();

            for (int i = 0; i < srcRows.size(); ++i) {
                Object o = vector.getVector().get(i);

                List<Object> srcRow = srcRows.get(i).getVector();
                List<Object> destRow = new ArrayList<>();

                for (Object p : srcRow) {
                    destRow.add(p);
                }

                destRow.add(o);
                destRows.add(new Vector<>(destRow));
            }

            Matrix<Object> destMatrix = new Matrix<>(destRows);
            matrixRegion.put(destMatrixKey, destMatrix);

            ctx.getResultSender().lastResult("success");
        } catch (Exception x) {
            LOG.error(x.toString(), x);
            throw new FunctionException(x.toString(), x);
        }
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

    @Override
    public void init(Properties props) {
    }

}
