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

import io.pivotal.bds.gemfire.r.common.Matrix;
import io.pivotal.bds.gemfire.r.common.MatrixKey;
import io.pivotal.bds.gemfire.r.common.TransposeRequest;
import io.pivotal.bds.gemfire.r.common.Vector;
import io.pivotal.bds.gemfire.util.RegionHelper;

@SuppressWarnings("serial")
public class TransposeFunction implements Function, Declarable {

    private static final Logger LOG = LoggerFactory.getLogger(TransposeFunction.class);

    @Override
    public void execute(FunctionContext ctx) {
        try {
            TransposeRequest req = (TransposeRequest) ctx.getArguments();
            LOG.debug("execute: req={}", req);

            MatrixKey srcMatrixKey = req.getSrcMatrixKey();
            MatrixKey destMatrixKey = req.getDestMatrixKey();

            Region<MatrixKey, Matrix<Object>> matrixRegion = RegionHelper.getRegion("matrix");

            Matrix<Object> srcMatrix = matrixRegion.get(srcMatrixKey);
            Assert.notNull(srcMatrix, "Source matrix " + srcMatrixKey.getId() + " not found");

            List<Vector<Object>> srcRows = srcMatrix.getRows();
            List<Vector<Object>> destRows = new ArrayList<>();

            for (int r = 0; r < srcRows.size(); ++r) {
                Vector<Object> srcRow = srcRows.get(r);

                for (int c = 0; c < srcRow.getVector().size(); ++c) {
                    Object o = srcRow.getVector().get(c);

                    Vector<Object> row = null;

                    if (destRows.size() <= c) {
                        row = new Vector<>(new ArrayList<>());
                        destRows.add(row);
                    } else {
                        row = destRows.get(c);
                    }

                    row.getVector().add(o);
                }
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
