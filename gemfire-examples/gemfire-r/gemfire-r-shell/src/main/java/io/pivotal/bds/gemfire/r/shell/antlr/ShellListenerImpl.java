package io.pivotal.bds.gemfire.r.shell.antlr;

import java.io.File;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.antlr.v4.runtime.tree.TerminalNode;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import org.apache.geode.cache.Region;
import org.apache.geode.cache.client.Pool;
import org.apache.geode.cache.execute.FunctionService;
import org.apache.geode.cache.execute.ResultCollector;
import org.apache.geode.cache.query.Query;
import org.apache.geode.cache.query.QueryService;
import org.apache.geode.cache.query.SelectResults;
import org.apache.geode.cache.query.Struct;
import org.apache.geode.pdx.PdxInstance;

import io.pivotal.bds.gemfire.ml.KernelType;
import io.pivotal.bds.gemfire.ml.ModelName;
import io.pivotal.bds.gemfire.ml.ModelType;
import io.pivotal.bds.gemfire.r.common.AdhocPrediction;
import io.pivotal.bds.gemfire.r.common.AdhocPredictionRequest;
import io.pivotal.bds.gemfire.r.common.AdhocPredictionResponse;
import io.pivotal.bds.gemfire.r.common.CbindRequest;
import io.pivotal.bds.gemfire.r.common.CstatsRequest;
import io.pivotal.bds.gemfire.r.common.DynamicTrainDef;
import io.pivotal.bds.gemfire.r.common.DynamicTrainDefKey;
import io.pivotal.bds.gemfire.r.common.PredictDef;
import io.pivotal.bds.gemfire.r.common.PredictDefKey;
import io.pivotal.bds.gemfire.r.common.RstatsRequest;
import io.pivotal.bds.gemfire.r.common.StatsResponse;
import io.pivotal.bds.gemfire.r.common.TrainDef;
import io.pivotal.bds.gemfire.r.common.TrainDefKey;
import io.pivotal.bds.gemfire.r.common.TransposeRequest;
import io.pivotal.bds.gemfire.r.common.FFTRequest;
import io.pivotal.bds.gemfire.r.common.FFTResponse;
import io.pivotal.bds.gemfire.r.common.HMMDef;
import io.pivotal.bds.gemfire.r.common.HMMKey;
import io.pivotal.bds.gemfire.r.common.KernelDef;
import io.pivotal.bds.gemfire.r.common.KernelKey;
import io.pivotal.bds.gemfire.r.common.Matrix;
import io.pivotal.bds.gemfire.r.common.MatrixDef;
import io.pivotal.bds.gemfire.r.common.MatrixKey;
import io.pivotal.bds.gemfire.r.common.ModelDef;
import io.pivotal.bds.gemfire.r.common.ModelDefKey;
import io.pivotal.bds.gemfire.r.common.ModelKey;
import io.pivotal.bds.gemfire.r.common.PMMLData;
import io.pivotal.bds.gemfire.r.common.PMMLKey;
import io.pivotal.bds.gemfire.r.common.PMMLPredictDef;
import io.pivotal.bds.gemfire.r.common.PMMLPredictDefKey;
import io.pivotal.bds.gemfire.r.common.Vector;
import io.pivotal.bds.gemfire.r.common.VectorDef;
import io.pivotal.bds.gemfire.r.common.VectorKey;
import io.pivotal.bds.gemfire.r.common.VstatsRequest;
import io.pivotal.bds.gemfire.r.shell.antlr.ShellParser.BinarysparsegaussKernelContext;
import io.pivotal.bds.gemfire.r.shell.antlr.ShellParser.BinarysparsehypertangentKernelContext;
import io.pivotal.bds.gemfire.r.shell.antlr.ShellParser.BinarysparselaplaceKernelContext;
import io.pivotal.bds.gemfire.r.shell.antlr.ShellParser.BinarysparselinearKernelContext;
import io.pivotal.bds.gemfire.r.shell.antlr.ShellParser.BinarysparsepolyKernelContext;
import io.pivotal.bds.gemfire.r.shell.antlr.ShellParser.BinarysparsethinplatesplineKernelContext;
import io.pivotal.bds.gemfire.r.shell.antlr.ShellParser.CContext;
import io.pivotal.bds.gemfire.r.shell.antlr.ShellParser.CVarContext;
import io.pivotal.bds.gemfire.r.shell.antlr.ShellParser.CbindContext;
import io.pivotal.bds.gemfire.r.shell.antlr.ShellParser.CstatsContext;
import io.pivotal.bds.gemfire.r.shell.antlr.ShellParser.CvContext;
import io.pivotal.bds.gemfire.r.shell.antlr.ShellParser.DecisionTreeContext;
import io.pivotal.bds.gemfire.r.shell.antlr.ShellParser.DtrainModelContext;
import io.pivotal.bds.gemfire.r.shell.antlr.ShellParser.ExecuteContext;
import io.pivotal.bds.gemfire.r.shell.antlr.ShellParser.FftContext;
import io.pivotal.bds.gemfire.r.shell.antlr.ShellParser.FieldNameContext;
import io.pivotal.bds.gemfire.r.shell.antlr.ShellParser.FieldNamesContext;
import io.pivotal.bds.gemfire.r.shell.antlr.ShellParser.FldContext;
import io.pivotal.bds.gemfire.r.shell.antlr.ShellParser.GaussKernelContext;
import io.pivotal.bds.gemfire.r.shell.antlr.ShellParser.GaussianProcessContext;
import io.pivotal.bds.gemfire.r.shell.antlr.ShellParser.HellingerKernelContext;
import io.pivotal.bds.gemfire.r.shell.antlr.ShellParser.HmmContext;
import io.pivotal.bds.gemfire.r.shell.antlr.ShellParser.HypertangentKernelContext;
import io.pivotal.bds.gemfire.r.shell.antlr.ShellParser.KnnContext;
import io.pivotal.bds.gemfire.r.shell.antlr.ShellParser.LaplaceKernelContext;
import io.pivotal.bds.gemfire.r.shell.antlr.ShellParser.LdaContext;
import io.pivotal.bds.gemfire.r.shell.antlr.ShellParser.LinearKernelContext;
import io.pivotal.bds.gemfire.r.shell.antlr.ShellParser.LsContext;
import io.pivotal.bds.gemfire.r.shell.antlr.ShellParser.MContext;
import io.pivotal.bds.gemfire.r.shell.antlr.ShellParser.MatrixContext;
import io.pivotal.bds.gemfire.r.shell.antlr.ShellParser.PearsonKernelContext;
import io.pivotal.bds.gemfire.r.shell.antlr.ShellParser.PmmlLoadContext;
import io.pivotal.bds.gemfire.r.shell.antlr.ShellParser.PmmlPredictContext;
import io.pivotal.bds.gemfire.r.shell.antlr.ShellParser.PolyKernelContext;
import io.pivotal.bds.gemfire.r.shell.antlr.ShellParser.PredictContext;
import io.pivotal.bds.gemfire.r.shell.antlr.ShellParser.PrintContext;
import io.pivotal.bds.gemfire.r.shell.antlr.ShellParser.PrioriVarContext;
import io.pivotal.bds.gemfire.r.shell.antlr.ShellParser.QdaContext;
import io.pivotal.bds.gemfire.r.shell.antlr.ShellParser.QueryArgContext;
import io.pivotal.bds.gemfire.r.shell.antlr.ShellParser.QueryArgsContext;
import io.pivotal.bds.gemfire.r.shell.antlr.ShellParser.QueryContext;
import io.pivotal.bds.gemfire.r.shell.antlr.ShellParser.RandomForestClassificationContext;
import io.pivotal.bds.gemfire.r.shell.antlr.ShellParser.RandomForestRegressionContext;
import io.pivotal.bds.gemfire.r.shell.antlr.ShellParser.RbindContext;
import io.pivotal.bds.gemfire.r.shell.antlr.ShellParser.RdaContext;
import io.pivotal.bds.gemfire.r.shell.antlr.ShellParser.RegressionTreeContext;
import io.pivotal.bds.gemfire.r.shell.antlr.ShellParser.RidgeRegressionContext;
import io.pivotal.bds.gemfire.r.shell.antlr.ShellParser.RstatsContext;
import io.pivotal.bds.gemfire.r.shell.antlr.ShellParser.SparsegaussKernelContext;
import io.pivotal.bds.gemfire.r.shell.antlr.ShellParser.SparsehypertangentKernelContext;
import io.pivotal.bds.gemfire.r.shell.antlr.ShellParser.SparselaplaceKernelContext;
import io.pivotal.bds.gemfire.r.shell.antlr.ShellParser.SparselinearKernelContext;
import io.pivotal.bds.gemfire.r.shell.antlr.ShellParser.SparsepolyKernelContext;
import io.pivotal.bds.gemfire.r.shell.antlr.ShellParser.SparsethinplatesplineKernelContext;
import io.pivotal.bds.gemfire.r.shell.antlr.ShellParser.SvmContext;
import io.pivotal.bds.gemfire.r.shell.antlr.ShellParser.SvrContext;
import io.pivotal.bds.gemfire.r.shell.antlr.ShellParser.TContext;
import io.pivotal.bds.gemfire.r.shell.antlr.ShellParser.ThinplatesplineKernelContext;
import io.pivotal.bds.gemfire.r.shell.antlr.ShellParser.TrainModelContext;
import io.pivotal.bds.gemfire.r.shell.antlr.ShellParser.VectorContext;
import io.pivotal.bds.gemfire.r.shell.antlr.ShellParser.VstatsContext;
import io.pivotal.bds.gemfire.r.shell.antlr.ShellParser.XFieldNameContext;

public class ShellListenerImpl extends ShellBaseListener {

    private PrintStream stdout;
    private PrintStream log;
    private QueryService queryService;
    private int queryLimit;
    private Pool pool;

    private Region<String, String> queryRegion;
    private Region<ModelDefKey, ModelDef> modelDefRegion;
    private Region<PredictDefKey, PredictDef> predictDefRegion;
    private Region<VectorKey, VectorDef> vectorDefRegion;
    private Region<MatrixKey, MatrixDef> matrixDefRegion;
    private Region<VectorKey, Vector<Object>> vectorRegion;
    private Region<MatrixKey, Matrix<Object>> matrixRegion;
    private Region<TrainDefKey, TrainDef> trainDefRegion;
    private Region<DynamicTrainDefKey, DynamicTrainDef> dynamicTrainDefRegion;
    private Region<KernelKey, KernelDef> kernelDefRegion;
    private Region<HMMKey, HMMDef> hmmDefRegion;
    private Region<PMMLKey, PMMLData> pmmlDataRegion;
    private Region<PMMLPredictDefKey, PMMLPredictDef> pmmlPredictDefRegion;

    public ShellListenerImpl(PrintStream stdout, PrintStream log, QueryService queryService, int queryLimit, Pool pool,
            Region<String, String> queryRegion, Region<ModelDefKey, ModelDef> modelDefRegion,
            Region<PredictDefKey, PredictDef> predictDefRegion, Region<VectorKey, VectorDef> vectorDefRegion,
            Region<MatrixKey, MatrixDef> matrixDefRegion, Region<VectorKey, Vector<Object>> vectorRegion,
            Region<MatrixKey, Matrix<Object>> matrixRegion, Region<TrainDefKey, TrainDef> trainDefRegion,
            Region<DynamicTrainDefKey, DynamicTrainDef> dynamicTrainDefRegion, Region<KernelKey, KernelDef> kernelDefRegion,
            Region<HMMKey, HMMDef> hmmDefRegion, Region<PMMLKey, PMMLData> pmmlDataRegion,
            Region<PMMLPredictDefKey, PMMLPredictDef> pmmlPredictDefRegion) {
        this.stdout = stdout;
        this.log = log;
        this.queryService = queryService;
        this.queryLimit = queryLimit;
        this.pool = pool;
        this.queryRegion = queryRegion;
        this.modelDefRegion = modelDefRegion;
        this.predictDefRegion = predictDefRegion;
        this.vectorDefRegion = vectorDefRegion;
        this.matrixDefRegion = matrixDefRegion;
        this.vectorRegion = vectorRegion;
        this.matrixRegion = matrixRegion;
        this.trainDefRegion = trainDefRegion;
        this.dynamicTrainDefRegion = dynamicTrainDefRegion;
        this.kernelDefRegion = kernelDefRegion;
        this.hmmDefRegion = hmmDefRegion;
        this.pmmlPredictDefRegion = pmmlPredictDefRegion;
        this.pmmlDataRegion = pmmlDataRegion;
    }

    @Override
    public void exitRstats(RstatsContext ctx) {
        String matrixId = ctx.matrixId().getText();
        MatrixKey matrixKey = new MatrixKey(matrixId);
        Assert.isTrue(matrixRegion.containsKeyOnServer(matrixKey), "Matrix " + matrixId + " not found");

        int row = Integer.parseInt(ctx.rowVar().getText());
        RstatsRequest req = new RstatsRequest(matrixKey, row);

        @SuppressWarnings("unchecked")
        List<StatsResponse> resp = (List<StatsResponse>) FunctionService.onServer(pool).setArguments(req).execute("RstatsFunction")
                .getResult();
        StatsResponse sr = resp.get(0);
        stdout.println(sr);
    }

    @Override
    public void exitCstats(CstatsContext ctx) {
        String matrixId = ctx.matrixId().getText();
        MatrixKey matrixKey = new MatrixKey(matrixId);
        Assert.isTrue(matrixRegion.containsKeyOnServer(matrixKey), "Matrix " + matrixId + " not found");

        int col = Integer.parseInt(ctx.colVar().getText());
        CstatsRequest req = new CstatsRequest(matrixKey, col);

        @SuppressWarnings("unchecked")
        List<StatsResponse> resp = (List<StatsResponse>) FunctionService.onServer(pool).setArguments(req).execute("CstatsFunction")
                .getResult();
        StatsResponse sr = resp.get(0);
        stdout.println(sr);
    }

    @Override
    public void exitVstats(VstatsContext ctx) {
        String vectorId = ctx.vectorId().getText();
        VectorKey vectorKey = new VectorKey(vectorId);
        Assert.isTrue(vectorRegion.containsKeyOnServer(vectorKey), "Vector " + vectorId + " not found");

        VstatsRequest req = new VstatsRequest(vectorKey);

        @SuppressWarnings("unchecked")
        List<StatsResponse> resp = (List<StatsResponse>) FunctionService.onServer(pool).setArguments(req).execute("VstatsFunction")
                .getResult();
        StatsResponse sr = resp.get(0);
        stdout.println(sr);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void exitRbind(RbindContext ctx) {
        String srcMatrixId = ctx.matrixId().get(1).getText();
        MatrixKey srcMatrixKey = new MatrixKey(srcMatrixId);
        Assert.isTrue(matrixRegion.containsKeyOnServer(srcMatrixKey), "Source matrix " + srcMatrixId + " not found");

        String vectorId = ctx.vectorId().getText();
        VectorKey vectorKey = new VectorKey(vectorId);
        Assert.isTrue(vectorRegion.containsKey(vectorKey), "Vector " + vectorId + " not found");

        String destMatrixId = ctx.matrixId().get(0).getText();
        MatrixKey destMatrixKey = new MatrixKey(destMatrixId);

        CbindRequest req = new CbindRequest(srcMatrixKey, destMatrixKey, vectorKey);
        FunctionService.onServer(pool).setArguments(req).execute("RbindFunction").getResult();
    }

    @SuppressWarnings("unchecked")
    @Override
    public void exitCbind(CbindContext ctx) {
        String srcMatrixId = ctx.matrixId().get(1).getText();
        MatrixKey srcMatrixKey = new MatrixKey(srcMatrixId);
        Assert.isTrue(matrixRegion.containsKeyOnServer(srcMatrixKey), "Source matrix " + srcMatrixId + " not found");

        String vectorId = ctx.vectorId().getText();
        VectorKey vectorKey = new VectorKey(vectorId);
        Assert.isTrue(vectorRegion.containsKeyOnServer(vectorKey), "Vector " + vectorId + " not found");

        String destMatrixId = ctx.matrixId().get(0).getText();
        MatrixKey destMatrixKey = new MatrixKey(destMatrixId);

        CbindRequest req = new CbindRequest(srcMatrixKey, destMatrixKey, vectorKey);
        FunctionService.onServer(pool).setArguments(req).execute("CbindFunction").getResult();
    }

    @SuppressWarnings("unchecked")
    @Override
    public void exitT(TContext ctx) {
        String srcMatrixId = ctx.matrixId().get(1).getText();
        MatrixKey srcMatrixKey = new MatrixKey(srcMatrixId);
        Assert.isTrue(matrixRegion.containsKeyOnServer(srcMatrixKey), "Source matrix " + srcMatrixId + " not found");

        String destMatrixId = ctx.matrixId().get(0).getText();
        MatrixKey destMatrixKey = new MatrixKey(destMatrixId);

        TransposeRequest req = new TransposeRequest(srcMatrixKey, destMatrixKey);
        FunctionService.onServer(pool).setArguments(req).execute("TransposeFunction").getResult();
    }

    @Override
    public void exitM(MContext ctx) {
        Vector<Object> vector = createVector(ctx.cv());

        int nrows = Integer.parseInt(ctx.nrowsVar().INTEGER().getText());
        int ncols = Integer.parseInt(ctx.ncolsVar().INTEGER().getText());

        List<Object> list = vector.getVector();

        if (list.size() != nrows * ncols) {
            throw new IllegalArgumentException("Invalid number of entries");
        }

        List<Class<?>> colTypes = new ArrayList<>();
        List<Vector<Object>> rows = new ArrayList<>();
        int t = 0;

        for (int r = 0; r < nrows; ++r) {
            List<Object> rl = new ArrayList<>();

            for (int c = 0; c < ncols; ++c) {
                Object o = list.get(t++);

                if (r == 0) {
                    colTypes.add(o.getClass());
                } else {
                    if (colTypes.get(c) != o.getClass()) {
                        throw new IllegalArgumentException("Columns must be of the same type");
                    }
                }

                rl.add(o);
            }

            rows.add(new Vector<>(rl));
        }

        Matrix<Object> matrix = new Matrix<>(rows);
        String matrixId = ctx.matrixId().getText();
        MatrixKey matrixKey = new MatrixKey(matrixId);

        matrixRegion.put(matrixKey, matrix);
    }

    @Override
    public void exitC(CContext ctx) {
        Vector<Object> vector = createVector(ctx.cv());

        Class<?> ct = null;

        for (Object o : vector.getVector()) {
            if (ct == null) {
                ct = o.getClass();
            } else if (ct != o.getClass()) {
                throw new IllegalArgumentException("Type of elements of vector must be the same");
            }
        }

        String vectorId = ctx.vectorId().getText();
        VectorKey vectorKey = new VectorKey(vectorId);
        vectorRegion.put(vectorKey, vector);
    }

    private Vector<Object> createVector(CvContext ctx) {
        List<CVarContext> cvars = ctx.cVar();
        List<Object> vars = new ArrayList<>();

        for (CVarContext cvc : cvars) {
            Object val = null;

            if (cvc.QUOTEDSTRING() != null) {
                String s = cvc.QUOTEDSTRING().getText();
                s = s.substring(1, s.length() - 1);
                val = s;
            } else if (cvc.numeric() != null) {
                String s = cvc.numeric().INTEGER() != null ? cvc.numeric().INTEGER().getText() : cvc.numeric().FLOAT().getText();
                val = new Double(s);
            } else {
                throw new IllegalArgumentException("Didn't get string or number");
            }

            vars.add(val);
        }

        Vector<Object> vector = new Vector<>(vars);
        return vector;
    }

    @Override
    public void exitPmmlPredict(PmmlPredictContext ctx) {
        String pmmlId = ctx.pmmlId().getText();
        PMMLKey pmmlKey = new PMMLKey(pmmlId);
        Assert.isTrue(pmmlDataRegion.containsKeyOnServer(pmmlKey), "PMML model " + pmmlId + " not found");

        String pmmlPredictId = ctx.pmmlPredictId().getText();
        String regionName = ctx.regionName().getText();

        PMMLPredictDefKey pdk = new PMMLPredictDefKey(pmmlPredictId, pmmlId);
        PMMLPredictDef def = new PMMLPredictDef(pmmlKey, regionName);

        pmmlPredictDefRegion.put(pdk, def);
    }

    @Override
    public void exitPmmlLoad(PmmlLoadContext ctx) {
        String pmmlId = ctx.pmmlId().getText();

        String filePath = ctx.filePathVar().getText();
        filePath = filePath.substring(1, filePath.length() - 1); // strip quotes

        File file = new File(filePath);

        if (!file.exists()) {
            throw new IllegalArgumentException("File " + filePath + " does not exist");
        }

        if (!file.isFile()) {
            throw new IllegalArgumentException("File " + filePath + " is not a file");
        }

        if (!file.canRead()) {
            throw new IllegalArgumentException("File " + filePath + " is not readable");
        }

        StringBuilder buf = new StringBuilder();
        char[] c = new char[1024];
        int len = 0;
        String model = null;

        try {
            FileReader fr = new FileReader(file);

            try {
                while ((len = fr.read(c)) > 0) {
                    buf.append(c, 0, len);
                }

                model = buf.toString();
            } finally {
                fr.close();
            }
        } catch (Exception x) {
            throw new IllegalArgumentException(x.getMessage(), x);
        }

        PMMLKey key = new PMMLKey(pmmlId);
        PMMLData data = new PMMLData(model);

        pmmlDataRegion.put(key, data);
    }

    @Override
    public void exitHmm(HmmContext ctx) {
        String piId = ctx.hmmPiVectorId().getText();
        VectorKey piKey = new VectorKey(piId);
        Assert.isTrue(vectorRegion.containsKeyOnServer(piKey), "Vector " + piId + " not found");

        String aId = ctx.hmmAMatrixId().getText();
        MatrixKey aKey = new MatrixKey(aId);
        Assert.isTrue(matrixRegion.containsKeyOnServer(aKey), "Matrix " + aId + " not found");

        String bId = ctx.hmmAMatrixId().getText();
        MatrixKey bKey = new MatrixKey(bId);
        Assert.isTrue(matrixRegion.containsKeyOnServer(bKey), "Matrix " + bId + " not found");

        String sId = ctx.hmmSymbolsVectorId() == null ? null : ctx.hmmSymbolsVectorId().getText();

        VectorKey sKey = null;

        if (sId != null) {
            sKey = new VectorKey(sId);
            Assert.isTrue(vectorRegion.containsKeyOnServer(sKey), "Vector " + sId + " not found");
        }

        String hmmId = ctx.hmmId().getText();

        HMMKey hmmKey = new HMMKey(hmmId);
        HMMDef hmmDef = new HMMDef(piKey, aKey, bKey, sKey);
        hmmDefRegion.put(hmmKey, hmmDef);
    }

    @Override
    public void exitRda(RdaContext ctx) {
        String modelId = ctx.modelId().getText();

        Double alpha = new Double(ctx.alphaVar().getText());
        Double tol = new Double(ctx.tolVar().getText());

        List<PrioriVarContext> pvars = ctx.prioriVar();
        double[] priori = new double[pvars.size()];

        for (int i = 0; i < priori.length; ++i) {
            priori[i] = Double.parseDouble(pvars.get(i).getText());
        }

        Map<String, Object> params = new HashMap<>();

        params.put("alpha", alpha);
        params.put("priori", priori);
        params.put("tol", tol);

        ModelDefKey modelDefKey = new ModelDefKey(modelId);
        ModelDef modelDef = new ModelDef(modelDefKey, ModelType.classification, ModelName.RDA, params);

        modelDefRegion.put(modelDefKey, modelDef);
    }

    @Override
    public void exitLda(LdaContext ctx) {
        String modelId = ctx.modelId().getText();

        Double tol = new Double(ctx.tolVar().getText());

        List<PrioriVarContext> pvars = ctx.prioriVar();
        double[] priori = new double[pvars.size()];

        for (int i = 0; i < priori.length; ++i) {
            priori[i] = Double.parseDouble(pvars.get(i).getText());
        }

        Map<String, Object> params = new HashMap<>();

        params.put("priori", priori);
        params.put("tol", tol);

        ModelDefKey modelDefKey = new ModelDefKey(modelId);
        ModelDef modelDef = new ModelDef(modelDefKey, ModelType.classification, ModelName.LDA, params);

        modelDefRegion.put(modelDefKey, modelDef);
    }

    @Override
    public void exitQda(QdaContext ctx) {
        String modelId = ctx.modelId().getText();

        Double tol = new Double(ctx.tolVar().getText());

        List<PrioriVarContext> pvars = ctx.prioriVar();
        double[] priori = new double[pvars.size()];

        for (int i = 0; i < priori.length; ++i) {
            priori[i] = Double.parseDouble(pvars.get(i).getText());
        }

        Map<String, Object> params = new HashMap<>();

        params.put("priori", priori);
        params.put("tol", tol);

        ModelDefKey modelDefKey = new ModelDefKey(modelId);
        ModelDef modelDef = new ModelDef(modelDefKey, ModelType.classification, ModelName.QDA, params);

        modelDefRegion.put(modelDefKey, modelDef);
    }

    @Override
    public void exitFld(FldContext ctx) {
        String modelId = ctx.modelId().getText();

        Double l = new Double(ctx.lVar().getText());
        Double tol = new Double(ctx.tolVar().getText());

        Map<String, Object> params = new HashMap<>();

        params.put("L", l);
        params.put("tol", tol);

        ModelDefKey modelDefKey = new ModelDefKey(modelId);
        ModelDef modelDef = new ModelDef(modelDefKey, ModelType.classification, ModelName.FLD, params);

        modelDefRegion.put(modelDefKey, modelDef);
    }

    @Override
    public void exitRandomForestClassification(RandomForestClassificationContext ctx) {
        String modelId = ctx.modelId().getText();

        Double ntrees = new Double(ctx.ntreesVar().getText());
        Double mtry = new Double(ctx.mtryVar().getText());

        Map<String, Object> params = new HashMap<>();

        params.put("ntrees", ntrees);
        params.put("mtry", mtry);

        ModelDefKey modelDefKey = new ModelDefKey(modelId);
        ModelDef modelDef = new ModelDef(modelDefKey, ModelType.classification, ModelName.RandomForest, params);

        modelDefRegion.put(modelDefKey, modelDef);
    }

    @Override
    public void exitDecisionTree(DecisionTreeContext ctx) {
        String modelId = ctx.modelId().getText();

        Integer j = new Integer(ctx.jVar().getText());
        String splitRule = ctx.dtreeSplitRuleVar().getText();

        Map<String, Object> params = new HashMap<>();

        params.put("j", j);
        params.put("splitRule", splitRule);

        ModelDefKey modelDefKey = new ModelDefKey(modelId);
        ModelDef modelDef = new ModelDef(modelDefKey, ModelType.classification, ModelName.DecisionTree, params);

        modelDefRegion.put(modelDefKey, modelDef);
    }

    @Override
    public void exitRegressionTree(RegressionTreeContext ctx) {
        String modelId = ctx.modelId().getText();

        Integer j = new Integer(ctx.jVar().getText());

        Map<String, Object> params = new HashMap<>();

        params.put("j", j);

        ModelDefKey modelDefKey = new ModelDefKey(modelId);
        ModelDef modelDef = new ModelDef(modelDefKey, ModelType.classification, ModelName.RegressionTree, params);

        modelDefRegion.put(modelDefKey, modelDef);
    }

    @Override
    public void exitRandomForestRegression(RandomForestRegressionContext ctx) {
        String modelId = ctx.modelId().getText();

        Integer t = new Integer(ctx.tVar().getText());
        Integer m = new Integer(ctx.mVar().getText());
        Integer s = new Integer(ctx.sVar().getText());

        Map<String, Object> params = new HashMap<>();

        params.put("T", t);
        params.put("M", m);
        params.put("S", s);

        ModelDefKey modelDefKey = new ModelDefKey(modelId);
        ModelDef modelDef = new ModelDef(modelDefKey, ModelType.regression, ModelName.RandomForest, params);

        modelDefRegion.put(modelDefKey, modelDef);
    }

    @Override
    public void exitRidgeRegression(RidgeRegressionContext ctx) {
        String modelId = ctx.modelId().getText();

        Double lambda = new Double(ctx.lambdaVar().getText());

        Map<String, Object> params = new HashMap<>();

        params.put("lambda", lambda);

        ModelDefKey modelDefKey = new ModelDefKey(modelId);
        ModelDef modelDef = new ModelDef(modelDefKey, ModelType.regression, ModelName.RidgeRegression, params);

        modelDefRegion.put(modelDefKey, modelDef);
    }

    @Override
    public void exitSvr(SvrContext ctx) {
        String modelId = ctx.modelId().getText();

        Double eps = new Double(ctx.epsVar().getText());
        Double c = new Double(ctx.cVar().getText());
        Double tol = new Double(ctx.tolVar().getText());

        Map<String, Object> params = new HashMap<>();

        params.put("eps", eps);
        params.put("c", c);
        params.put("tol", tol);

        ModelDefKey modelDefKey = new ModelDefKey(modelId);
        ModelDef modelDef = new ModelDef(modelDefKey, ModelType.regression, ModelName.SVR, params);

        modelDefRegion.put(modelDefKey, modelDef);
    }

    @Override
    public void exitKnn(KnnContext ctx) {
    }

    @Override
    public void exitTrainModel(TrainModelContext ctx) {
        String modelDefId = ctx.modelId().getText();
        String matrixId = ctx.matrixId().getText();
        String vectorId = ctx.vectorId().getText();
        String trainId = ctx.trainId().getText();
        log.println("exitTrain: modelDefId=" + modelDefId + ", matrixId=" + matrixId + ", vectorId=" + vectorId + ", trainId="
                + trainId);

        ModelDefKey modelDefKey = new ModelDefKey(modelDefId);
        Assert.isTrue(modelDefRegion.containsKeyOnServer(modelDefKey), "Model " + modelDefKey.getId() + " not found");

        MatrixKey matrixKey = new MatrixKey(matrixId);
        Assert.isTrue(matrixDefRegion.containsKeyOnServer(matrixKey), "Matrix " + matrixKey.getId() + " not found");

        VectorKey vectorKey = new VectorKey(vectorId);
        Assert.isTrue(vectorDefRegion.containsKeyOnServer(vectorKey), "Vector " + vectorKey.getId() + " not found");

        ModelKey modelKey = new ModelKey(trainId);
        TrainDefKey trainDefKey = new TrainDefKey(trainId, modelDefId);
        TrainDef trainDef = new TrainDef(modelDefKey, modelKey, matrixKey, vectorKey);

        trainDefRegion.put(trainDefKey, trainDef);
    }

    @Override
    public void exitDtrainModel(DtrainModelContext ctx) {
        String modelDefId = ctx.modelId().getText();
        String trainId = ctx.trainId().getText();
        String regionName = ctx.regionName().getText();
        int size = Integer.parseInt(ctx.sizeVar().getText());
        String yFieldName = ctx.yFieldName().getText();

        List<XFieldNameContext> xlist = ctx.xFieldName();
        String[] xFieldNames = new String[xlist.size()];

        for (int i = 0; i < xFieldNames.length; ++i) {
            xFieldNames[i] = xlist.get(i).getText();
        }

        DynamicTrainDefKey trainDefKey = new DynamicTrainDefKey(trainId, modelDefId);
        ModelDefKey modelDefKey = new ModelDefKey(modelDefId);
        ModelKey modelKey = new ModelKey(trainId);

        DynamicTrainDef trainDef = new DynamicTrainDef(modelDefKey, modelKey, regionName, size, xFieldNames, yFieldName);

        dynamicTrainDefRegion.put(trainDefKey, trainDef);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void exitFft(FftContext ctx) {
        String inputId = ctx.fftInputId().getText();
        String matrixId = ctx.matrixId().getText();
        String dir = ctx.fftDir().getText().toUpperCase();
        String norm = ctx.fftNorm().getText().toUpperCase();

        Object input = null;
        Region<?, ?> routeRegion = null;
        VectorKey inputVectorKey = new VectorKey(inputId);
        MatrixKey inputMatrixKey = new MatrixKey(inputId);

        if (vectorRegion.get(inputVectorKey) != null) {
            input = inputVectorKey;
            routeRegion = vectorRegion;
        } else if (matrixRegion.get(inputMatrixKey) != null) {
            input = inputMatrixKey;
            routeRegion = matrixRegion;
        } else {
            throw new IllegalArgumentException("Input variable " + inputId + " not found");
        }

        MatrixKey matrixKey = new MatrixKey(matrixId);

        FFTRequest req = new FFTRequest(input, norm, dir, matrixKey, input);
        Set<FFTRequest> filter = new HashSet<>();
        filter.add(req);

        ResultCollector<?, ?> coll = FunctionService.onRegion(routeRegion).withFilter(filter).execute("FFTFunction");

        List<FFTResponse> lresp = (List<FFTResponse>) coll.getResult();
        FFTResponse resp = lresp.get(0);
        Object res = resp.getResult();

        if (res instanceof String) {
            stdout.println(res);
        }
    }

    @Override
    public void exitVector(VectorContext ctx) {
        String vectorId = ctx.vectorId().getText();
        String queryId = ctx.queryId().getText();
        String fieldName = ctx.fieldName().getText();
        List<Object> args = convert(ctx.queryArgs());

        VectorKey key = new VectorKey(vectorId);
        VectorDef def = new VectorDef(queryId, args.toArray(), fieldName);

        vectorDefRegion.put(key, def);
    }

    @Override
    public void exitMatrix(MatrixContext ctx) {
        String matrixId = ctx.matrixId().getText();
        String queryId = ctx.queryId().getText();
        List<String> fieldNames = convertFieldVar(ctx.fieldNames());
        List<Object> args = convert(ctx.queryArgs());

        MatrixKey key = new MatrixKey(matrixId);
        MatrixDef def = new MatrixDef(queryId, args.toArray(), fieldNames.toArray(new String[fieldNames.size()]));

        matrixDefRegion.put(key, def);
    }

    private List<String> convertFieldVar(FieldNamesContext fieldVar) {
        List<FieldNameContext> l = fieldVar == null ? null : fieldVar.fieldName();
        return convertFieldVar(l);
    }

    private List<String> convertFieldVar(List<FieldNameContext> fieldVar) {
        List<String> list = new ArrayList<>();

        if (fieldVar != null) {
            for (FieldNameContext fvc : fieldVar) {
                String s = fvc.getText();
                list.add(s);
            }
        }

        return list;
    }

    @Override
    public void exitQuery(QueryContext ctx) {
        String queryVar = ctx.queryId().getText();
        String query = ctx.queryString().getText();
        query = query.substring(1, query.length() - 1);
        queryRegion.put(queryVar, query);
    }

    @Override
    public void exitExecute(ExecuteContext ctx) {
        String queryVar = ctx.queryId().getText();
        String query = queryRegion.get(queryVar);
        Assert.hasText(query, "Query " + queryVar + " does not exist");

        List<QueryArgContext> argCtxs = ctx.queryArg();
        List<Object> args = new ArrayList<>();

        for (QueryArgContext ac : argCtxs) {
            TerminalNode fn = ac.FLOAT();
            String fs = fn == null ? null : fn.getText();

            if (StringUtils.hasText(fs)) {
                Double d = new Double(fs);
                args.add(d);
            }

            TerminalNode in = ac.INTEGER();
            String is = in == null ? null : in.getText();

            if (StringUtils.hasText(is)) {
                Integer i = new Integer(is);
                args.add(i);
            }

            String qs = ac.QUOTEDSTRING() == null ? null : ac.QUOTEDSTRING().getText();

            if (StringUtils.hasText(qs)) {
                qs = qs.substring(1, qs.length() - 1); // strip off quotes

                if (StringUtils.hasText(qs)) {
                    args.add(qs);
                }
            }
        }

        try {
            Query q = queryService.newQuery(query);
            Object o = args.isEmpty() ? q.execute() : q.execute(args.toArray());
            SelectResults<?> res = (SelectResults<?>) o;
            List<?> list = res == null || res.isEmpty() ? null : res.asList();

            if (list == null || list.isEmpty()) {
                stdout.println("<no results>");
            } else {
                Object oh = list.get(0);

                if (oh instanceof Struct) {
                    Struct st = (Struct) oh;
                    String[] fieldNames = st.getStructType().getFieldNames();

                    // print header
                    for (int i = 0; i < fieldNames.length; ++i) {
                        if (i > 0) {
                            stdout.print("\t");
                        }

                        stdout.print(fieldNames[i]);
                    }

                    stdout.println();
                    stdout.println("============================================================================================");

                    // print rows
                    for (int ir = 0; ir < queryLimit && ir < list.size(); ++ir) {
                        st = (Struct) list.get(ir);

                        for (int i = 0; i < fieldNames.length; ++i) {
                            if (i > 0) {
                                stdout.print("\t");
                            }

                            Object fo = st.get(fieldNames[i]);
                            stdout.print(fo);
                        }

                        stdout.println();
                    }
                } else if (oh instanceof PdxInstance) {
                    PdxInstance inst = (PdxInstance) oh;
                    List<String> fieldNames = inst.getFieldNames();

                    // print header
                    for (int i = 0; i < fieldNames.size(); ++i) {
                        if (i > 0) {
                            stdout.print("\t");
                        }

                        stdout.print(fieldNames.get(i));
                    }

                    stdout.println();
                    stdout.println("============================================================================================");

                    // print rows
                    for (int ir = 0; ir < queryLimit && ir < list.size(); ++ir) {
                        inst = (PdxInstance) list.get(ir);

                        for (int i = 0; i < fieldNames.size(); ++i) {
                            if (i > 0) {
                                stdout.print("\t");
                            }

                            Object fo = inst.getField(fieldNames.get(i));
                            stdout.print(fo);
                        }

                        stdout.println();
                    }
                } else {
                    for (Object ot : list) {
                        stdout.println(ot);
                    }
                }
            }
        } catch (Exception x) {
            throw new IllegalArgumentException("Exception when executing query: " + x.getMessage(), x);
        }
    }

    @Override
    public void exitSvm(SvmContext ctx) {
        String modelId = ctx.modelId().getText();

        Map<String, Object> params = new HashMap<>();

        String scp = ctx.cpVar() == null ? null : ctx.cpVar().getText();
        if (StringUtils.hasText(scp)) {
            params.put("cp", new Double(scp));
        }

        String scn = ctx.cnVar() == null ? null : ctx.cnVar().getText();
        if (StringUtils.hasText(scn)) {
            params.put("cn", new Double(scn));
        }

        ModelDefKey key = new ModelDefKey(modelId);
        ModelDef info = new ModelDef(key, ModelType.classification, ModelName.SVM, params);

        modelDefRegion.put(key, info);
    }

    @Override
    public void exitGaussianProcess(GaussianProcessContext ctx) {
        String kernelId = ctx.kernelId().getText();
        KernelKey kernelKey = new KernelKey(kernelId);
        Assert.isTrue(kernelDefRegion.containsKeyOnServer(kernelKey), "Kernel " + kernelId + " does not exist");

        String modelId = ctx.modelId().getText();

        Map<String, Object> params = new HashMap<>();
        params.put("kernelKey", kernelKey);

        String sl = ctx.lambdaVar() == null ? null : ctx.lambdaVar().getText();
        if (StringUtils.hasText(sl)) {
            params.put("lambda", new Double(sl));
        }

        ModelDefKey key = new ModelDefKey(modelId);
        ModelDef info = new ModelDef(key, ModelType.regression, ModelName.GaussianProcess, params);

        modelDefRegion.put(key, info);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void exitPredict(PredictContext ctx) {
        String modelId = ctx.modelId().getText();
        ModelKey modelKey = new ModelKey(modelId);

        Object arg = null;

        if (ctx.vectorId() != null) {
            arg = ctx.vectorId().getText();
        } else if (ctx.numeric() != null) {
            if (ctx.numeric().FLOAT() != null) {
                arg = new Double(ctx.numeric().FLOAT().getText());
            } else {
                arg = new Integer(ctx.numeric().INTEGER().getText());
            }
        } else {
            // TODO
        }

        AdhocPredictionRequest req = new AdhocPredictionRequest(modelKey, arg);

        ResultCollector<?, ?> coll = FunctionService.onServer(pool).setArguments(req).execute("AdhocPredictionFunction");

        List<AdhocPredictionResponse> lresp = (List<AdhocPredictionResponse>) coll.getResult();
        Assert.isTrue(!lresp.isEmpty(), "No response");

        AdhocPredictionResponse resp = lresp.get(0);

        for (AdhocPrediction pres : resp.getResults()) {
            stdout.println("x = " + Arrays.toString(pres.getX()) + " y = " + pres.getP());
        }
    }

    private List<Object> convert(List<QueryArgContext> queryArg) {
        List<Object> args = new ArrayList<>();

        if (queryArg != null) {
            for (QueryArgContext ac : queryArg) {
                TerminalNode fn = ac.FLOAT();
                String fs = fn == null ? null : fn.getText();

                if (StringUtils.hasText(fs)) {
                    Double d = new Double(fs);
                    args.add(d);
                }

                TerminalNode in = ac.INTEGER();
                String is = in == null ? null : in.getText();

                if (StringUtils.hasText(is)) {
                    Integer i = new Integer(is);
                    args.add(i);
                }

                String ss = ac.QUOTEDSTRING() == null ? null : ac.QUOTEDSTRING().getText();
                if (StringUtils.hasText(ss)) {
                    ss = ss.substring(1, ss.length() - 1);
                    if (StringUtils.hasText(ss)) {
                        args.add(ss);
                    }
                }
            }
        }

        return args;
    }

    private List<Object> convert(QueryArgsContext qac) {
        List<QueryArgContext> qargctx = qac == null ? null : qac.queryArg();
        return convert(qargctx);
    }

    @Override
    public void exitPrint(PrintContext ctx) {
        String var = ctx.var().getText();

        boolean found = printQueryVar(var);
        found = printModelVar(var) || found;
        found = printTrainVar(var) || found;
        found = printPredictVar(var) || found;
        found = printVectorVar(var) || found;
        found = printMatrixVar(var) || found;
        found = printHMMVar(var) || found;
        found = printKernelVar(var) || found;
        found = printPMMLVar(var) || found;
        found = printPMMLPredictVar(var) || found;

        if (!found) {
            stdout.println("<variable not found>");
        }
    }

    private boolean printPMMLPredictVar(String id) {
        try {
            SelectResults<PMMLPredictDef> res = pmmlPredictDefRegion
                    .query("select value from /pmmlPredictDef.entrySet where key.id='" + id + "'");
            List<PMMLPredictDef> list = res.asList();

            if (!list.isEmpty()) {
                PMMLPredictDef def = list.get(0);

                stdout.println("PMML Predict:");

                stdout.println("   pmml   = " + def.getPmmlKey().getId());
                stdout.println("   region = " + def.getRegionName());

                return true;
            }
        } catch (Exception x) {
            stdout.println(x.getMessage());
            x.printStackTrace(log);
        }

        return false;
    }

    private boolean printPMMLVar(String pmmlId) {
        PMMLKey key = new PMMLKey(pmmlId);
        PMMLData data = pmmlDataRegion.get(key);

        if (data != null) {
            stdout.println("PMML:");

            stdout.println("   model = ");
            stdout.println(data.getModel());
            return true;
        }

        return false;
    }

    private boolean printKernelVar(String kernelId) {
        KernelKey key = new KernelKey(kernelId);
        KernelDef def = kernelDefRegion.get(key);

        if (def != null) {
            stdout.println("Kernel:");

            stdout.println("   type  = " + def.getType());
            stdout.println("   props = " + def.getProperties());
            return true;
        }

        return false;
    }

    private boolean printTrainVar(String trainId) {
        try {
            SelectResults<TrainDef> res = trainDefRegion
                    .query("select value from /trainDef.entrySet where key.id='" + trainId + "'");
            List<TrainDef> list = res.asList();

            if (!list.isEmpty()) {
                TrainDef def = list.get(0);

                stdout.println("Train:");

                stdout.println("   model      = " + def.getModelKey().getId());
                stdout.println("   model def  = " + def.getModelDefKey().getId());
                stdout.println("   matrix     = " + def.getMatrixKey().getId());
                stdout.println("   vector     = " + def.getVectorKey().getId());
            }

            return true;
        } catch (Exception e) {
            stdout.println(e.getMessage());
            e.printStackTrace(this.log);
        }

        return false;
    }

    private boolean printHMMVar(String hmmId) {
        HMMKey key = new HMMKey(hmmId);
        HMMDef def = hmmDefRegion.get(key);

        if (def != null) {
            stdout.println("HMM:");

            stdout.println("   pi vector      = " + def.getPiKey().getId());
            stdout.println("   a matrix       = " + def.getaKey().getId());
            stdout.println("   b matrix       = " + def.getbKey().getId());
            stdout.println("   symbols vector = " + def.getSymbolsKey().getId());

            return true;
        } else {
            return false;
        }
    }

    private boolean printMatrixVar(String matrixId) {
        MatrixKey key = new MatrixKey(matrixId);
        MatrixDef def = matrixDefRegion.get(key);
        Matrix<Object> m = matrixRegion.get(key);

        if (def != null || m != null) {
            stdout.println("Matrix:");

            if (def != null) {
                stdout.println("   query = " + def.getQueryId());
                stdout.println("   fields = " + Arrays.toString(def.getFields()));
                stdout.println("   args  = " + Arrays.toString(def.getQueryArgs()));
            }

            if (m != null) {
                for (Vector<Object> v : m.getRows()) {
                    List<Object> l = v.getVector();
                    stdout.println("   " + l);
                }
            }

            return true;
        }

        return false;
    }

    private boolean printVectorVar(String vectorId) {
        VectorKey key = new VectorKey(vectorId);
        VectorDef def = vectorDefRegion.get(key);
        Vector<Object> v = vectorRegion.get(key);

        if (def != null || v != null) {
            stdout.println("Vector:");

            if (def != null) {
                stdout.println("   query = " + def.getQueryId());
                stdout.println("   field = " + def.getField());
                stdout.println("   args  = " + Arrays.toString(def.getQueryArgs()));
            }

            if (v != null) {
                for (Object o : v.getVector()) {
                    stdout.println("   " + o);
                }
            }

            return true;
        } else {
            return false;
        }
    }

    private boolean printPredictVar(String evalId) {
        PredictDefKey key = new PredictDefKey(evalId, "");
        PredictDef def = predictDefRegion.get(key);

        if (def == null) {
            return false;
        } else {
            stdout.println("Predict:");
            stdout.println("   model  = " + def.getModelKey().getId());
            stdout.println("   region = " + def.getRegionName());
            stdout.println("   fields = " + Arrays.toString(def.getFieldNames()));
            return true;
        }
    }

    private boolean printModelVar(String modelId) {
        ModelDefKey mk = new ModelDefKey(modelId);
        ModelDef info = modelDefRegion.get(mk);

        if (info == null) {
            return false;
        } else {
            stdout.println("Model:");
            stdout.println("   name   = " + info.getName());
            stdout.println("   type   = " + info.getType());

            Map<String, Object> params = info.getParameters();
            List<String> pnames = new ArrayList<>(params.keySet());
            Collections.sort(pnames);

            for (String pn : pnames) {
                Object pv = params.get(pn);
                stdout.println("   " + pn + " = " + pv);
            }

            return true;
        }
    }

    private boolean printQueryVar(String queryId) {
        String query = queryRegion.get(queryId);

        if (query == null) {
            return false;
        } else {
            stdout.println("Query:");
            stdout.println("   " + queryId + ": " + query);
            return true;
        }
    }

    @Override
    public void exitLs(LsContext ctx) {
        stdout.println("Query:");
        printQueryVars(queryRegion.keySetOnServer());

        stdout.println("Vector:");
        printVectorVars(vectorRegion.keySetOnServer());

        stdout.println("Matrix:");
        printMatrixVars(matrixRegion.keySetOnServer());

        stdout.println("Model:");
        printModelVars(modelDefRegion.keySetOnServer());

        stdout.println("Train:");
        printTrainVars(trainDefRegion.keySetOnServer());

        stdout.println("Predict:");
        printPredictVars(predictDefRegion.keySetOnServer());

        stdout.println("Kernel:");
        printKernelVars(kernelDefRegion.keySetOnServer());

        stdout.println("PMML:");
        printPMMLVars(pmmlDataRegion.keySetOnServer());

        stdout.println("PMML Predict:");
        printPMMLPredictVars(pmmlPredictDefRegion.keySetOnServer());

        stdout.println("HMM:");
        printHMMVars(hmmDefRegion.keySetOnServer());
    }

    private void printHMMVars(Set<HMMKey> c) {
        List<String> l = new ArrayList<>();
        for (HMMKey ek : c) {
            l.add(ek.getId());
        }
        Collections.sort(l);
        for (String s : l) {
            stdout.println("   " + s);
        }
    }

    private void printPMMLPredictVars(Set<PMMLPredictDefKey> c) {
        List<String> l = new ArrayList<>();
        for (PMMLPredictDefKey ek : c) {
            l.add(ek.getId());
        }
        Collections.sort(l);
        for (String s : l) {
            stdout.println("   " + s);
        }
    }

    private void printPMMLVars(Set<PMMLKey> c) {
        List<String> l = new ArrayList<>();
        for (PMMLKey ek : c) {
            l.add(ek.getId());
        }
        Collections.sort(l);
        for (String s : l) {
            stdout.println("   " + s);
        }
    }

    private void printTrainVars(Set<TrainDefKey> c) {
        List<String> l = new ArrayList<>();
        for (TrainDefKey ek : c) {
            l.add(ek.getId());
        }
        Collections.sort(l);
        for (String s : l) {
            stdout.println("   " + s);
        }
    }

    private void printKernelVars(Set<KernelKey> c) {
        List<String> l = new ArrayList<>();
        for (KernelKey ek : c) {
            l.add(ek.getId());
        }
        Collections.sort(l);
        for (String s : l) {
            stdout.println("   " + s);
        }
    }

    private void printVectorVars(Set<VectorKey> c) {
        List<String> l = new ArrayList<>();
        for (VectorKey ek : c) {
            l.add(ek.getId());
        }
        Collections.sort(l);
        for (String s : l) {
            stdout.println("   " + s);
        }
    }

    private void printMatrixVars(Set<MatrixKey> c) {
        List<String> l = new ArrayList<>();
        for (MatrixKey ek : c) {
            l.add(ek.getId());
        }
        Collections.sort(l);
        for (String s : l) {
            stdout.println("   " + s);
        }
    }

    private void printPredictVars(Set<PredictDefKey> c) {
        List<String> l = new ArrayList<>();
        for (PredictDefKey ek : c) {
            l.add(ek.getId());
        }
        Collections.sort(l);
        for (String s : l) {
            stdout.println("   " + s);
        }
    }

    private void printQueryVars(Set<String> c) {
        List<String> l = new ArrayList<>(c);
        Collections.sort(l);
        for (String s : l) {
            stdout.println("   " + s);
        }
    }

    private void printModelVars(Set<ModelDefKey> c) {
        List<String> l = new ArrayList<>();
        for (ModelDefKey k : c) {
            l.add(k.getId());
        }
        Collections.sort(l);
        for (String s : l) {
            stdout.println("   " + s);
        }
    }

    @Override
    public void exitGaussKernel(GaussKernelContext ctx) {
        String kernelId = ctx.kernelId().getText();
        Double sigma = new Double(ctx.sigmaVar().getText());

        Map<String, Number> props = new HashMap<>();
        props.put("sigma", sigma);

        KernelKey key = new KernelKey(kernelId);
        KernelDef def = new KernelDef(KernelType.Gaussian, props);
        kernelDefRegion.put(key, def);
    }

    @Override
    public void exitLaplaceKernel(LaplaceKernelContext ctx) {
        String kernelId = ctx.kernelId().getText();
        Double sigma = new Double(ctx.sigmaVar().getText());

        Map<String, Number> props = new HashMap<>();
        props.put("sigma", sigma);

        KernelKey key = new KernelKey(kernelId);
        KernelDef def = new KernelDef(KernelType.Laplacian, props);
        kernelDefRegion.put(key, def);
    }

    @Override
    public void exitLinearKernel(LinearKernelContext ctx) {
        String kernelId = ctx.kernelId().getText();

        Map<String, Number> props = new HashMap<>();

        KernelKey key = new KernelKey(kernelId);
        KernelDef def = new KernelDef(KernelType.Linear, props);
        kernelDefRegion.put(key, def);
    }

    @Override
    public void exitPearsonKernel(PearsonKernelContext ctx) {
        String kernelId = ctx.kernelId().getText();
        Double omega = new Double(ctx.omegaVar().getText());
        Double sigma = new Double(ctx.sigmaVar().getText());

        Map<String, Number> props = new HashMap<>();
        props.put("omega", omega);
        props.put("sigma", sigma);

        KernelKey key = new KernelKey(kernelId);
        KernelDef def = new KernelDef(KernelType.Pearson, props);
        kernelDefRegion.put(key, def);
    }

    @Override
    public void exitPolyKernel(PolyKernelContext ctx) {
        String kernelId = ctx.kernelId().getText();
        Double degree = new Double(ctx.degreeVar().getText());
        Double scale = new Double(ctx.scaleVar().getText());
        Double offset = new Double(ctx.offsetVar().getText());

        Map<String, Number> props = new HashMap<>();
        props.put("degree", degree);
        props.put("scale", scale);
        props.put("offset", offset);

        KernelKey key = new KernelKey(kernelId);
        KernelDef def = new KernelDef(KernelType.Polynomial, props);
        kernelDefRegion.put(key, def);
    }

    @Override
    public void exitHypertangentKernel(HypertangentKernelContext ctx) {
        String kernelId = ctx.kernelId().getText();
        Double scale = new Double(ctx.scaleVar().getText());
        Double offset = new Double(ctx.offsetVar().getText());

        Map<String, Number> props = new HashMap<>();
        props.put("scale", scale);
        props.put("offset", offset);

        KernelKey key = new KernelKey(kernelId);
        KernelDef def = new KernelDef(KernelType.HyperbolicTangent, props);
        kernelDefRegion.put(key, def);
    }

    @Override
    public void exitThinplatesplineKernel(ThinplatesplineKernelContext ctx) {
        String kernelId = ctx.kernelId().getText();
        Double sigma = new Double(ctx.sigmaVar().getText());

        Map<String, Number> props = new HashMap<>();
        props.put("sigma", sigma);

        KernelKey key = new KernelKey(kernelId);
        KernelDef def = new KernelDef(KernelType.ThinPlateSpline, props);
        kernelDefRegion.put(key, def);
    }

    @Override
    public void exitSparsegaussKernel(SparsegaussKernelContext ctx) {
        String kernelId = ctx.kernelId().getText();
        Double sigma = new Double(ctx.sigmaVar().getText());

        Map<String, Number> props = new HashMap<>();
        props.put("sigma", sigma);

        KernelKey key = new KernelKey(kernelId);
        KernelDef def = new KernelDef(KernelType.SparseGaussian, props);
        kernelDefRegion.put(key, def);
    }

    @Override
    public void exitSparselaplaceKernel(SparselaplaceKernelContext ctx) {
        String kernelId = ctx.kernelId().getText();
        Double sigma = new Double(ctx.sigmaVar().getText());

        Map<String, Number> props = new HashMap<>();
        props.put("sigma", sigma);

        KernelKey key = new KernelKey(kernelId);
        KernelDef def = new KernelDef(KernelType.SparseLaplacian, props);
        kernelDefRegion.put(key, def);
    }

    @Override
    public void exitSparselinearKernel(SparselinearKernelContext ctx) {
        String kernelId = ctx.kernelId().getText();

        Map<String, Number> props = new HashMap<>();

        KernelKey key = new KernelKey(kernelId);
        KernelDef def = new KernelDef(KernelType.SparseLinear, props);
        kernelDefRegion.put(key, def);
    }

    @Override
    public void exitSparsepolyKernel(SparsepolyKernelContext ctx) {
        String kernelId = ctx.kernelId().getText();
        Double degree = new Double(ctx.degreeVar().getText());
        Double scale = new Double(ctx.scaleVar().getText());
        Double offset = new Double(ctx.offsetVar().getText());

        Map<String, Number> props = new HashMap<>();
        props.put("degree", degree);
        props.put("scale", scale);
        props.put("offset", offset);

        KernelKey key = new KernelKey(kernelId);
        KernelDef def = new KernelDef(KernelType.SparsePolynomial, props);
        kernelDefRegion.put(key, def);
    }

    @Override
    public void exitSparsehypertangentKernel(SparsehypertangentKernelContext ctx) {
        String kernelId = ctx.kernelId().getText();
        Double scale = new Double(ctx.scaleVar().getText());
        Double offset = new Double(ctx.offsetVar().getText());

        Map<String, Number> props = new HashMap<>();
        props.put("scale", scale);
        props.put("offset", offset);

        KernelKey key = new KernelKey(kernelId);
        KernelDef def = new KernelDef(KernelType.SparseHyperbolicTangent, props);
        kernelDefRegion.put(key, def);
    }

    @Override
    public void exitSparsethinplatesplineKernel(SparsethinplatesplineKernelContext ctx) {
        String kernelId = ctx.kernelId().getText();
        Double sigma = new Double(ctx.sigmaVar().getText());

        Map<String, Number> props = new HashMap<>();
        props.put("sigma", sigma);

        KernelKey key = new KernelKey(kernelId);
        KernelDef def = new KernelDef(KernelType.SparseThinPlateSpline, props);
        kernelDefRegion.put(key, def);
    }

    @Override
    public void exitBinarysparsegaussKernel(BinarysparsegaussKernelContext ctx) {
        String kernelId = ctx.kernelId().getText();
        Double sigma = new Double(ctx.sigmaVar().getText());

        Map<String, Number> props = new HashMap<>();
        props.put("sigma", sigma);

        KernelKey key = new KernelKey(kernelId);
        KernelDef def = new KernelDef(KernelType.BinarySparseGaussian, props);
        kernelDefRegion.put(key, def);
    }

    @Override
    public void exitBinarysparselaplaceKernel(BinarysparselaplaceKernelContext ctx) {
        String kernelId = ctx.kernelId().getText();
        Double sigma = new Double(ctx.sigmaVar().getText());

        Map<String, Number> props = new HashMap<>();
        props.put("sigma", sigma);

        KernelKey key = new KernelKey(kernelId);
        KernelDef def = new KernelDef(KernelType.BinarySparseLaplacian, props);
        kernelDefRegion.put(key, def);
    }

    @Override
    public void exitBinarysparselinearKernel(BinarysparselinearKernelContext ctx) {
        String kernelId = ctx.kernelId().getText();

        Map<String, Number> props = new HashMap<>();

        KernelKey key = new KernelKey(kernelId);
        KernelDef def = new KernelDef(KernelType.BinarySparseLinear, props);
        kernelDefRegion.put(key, def);
    }

    @Override
    public void exitBinarysparsepolyKernel(BinarysparsepolyKernelContext ctx) {
        String kernelId = ctx.kernelId().getText();
        Double degree = new Double(ctx.degreeVar().getText());
        Double scale = new Double(ctx.scaleVar().getText());
        Double offset = new Double(ctx.offsetVar().getText());

        Map<String, Number> props = new HashMap<>();
        props.put("degree", degree);
        props.put("scale", scale);
        props.put("offset", offset);

        KernelKey key = new KernelKey(kernelId);
        KernelDef def = new KernelDef(KernelType.BinarySparsePolynomial, props);
        kernelDefRegion.put(key, def);
    }

    @Override
    public void exitBinarysparsehypertangentKernel(BinarysparsehypertangentKernelContext ctx) {
        String kernelId = ctx.kernelId().getText();
        Double scale = new Double(ctx.scaleVar().getText());
        Double offset = new Double(ctx.offsetVar().getText());

        Map<String, Number> props = new HashMap<>();
        props.put("scale", scale);
        props.put("offset", offset);

        KernelKey key = new KernelKey(kernelId);
        KernelDef def = new KernelDef(KernelType.BinarySparseHyperbolicTangent, props);
        kernelDefRegion.put(key, def);
    }

    @Override
    public void exitBinarysparsethinplatesplineKernel(BinarysparsethinplatesplineKernelContext ctx) {
        String kernelId = ctx.kernelId().getText();
        Double sigma = new Double(ctx.sigmaVar().getText());

        Map<String, Number> props = new HashMap<>();
        props.put("sigma", sigma);

        KernelKey key = new KernelKey(kernelId);
        KernelDef def = new KernelDef(KernelType.BinarySparseThinPlateSpline, props);
        kernelDefRegion.put(key, def);
    }

    @Override
    public void exitHellingerKernel(HellingerKernelContext ctx) {
        String kernelId = ctx.kernelId().getText();

        Map<String, Number> props = new HashMap<>();

        KernelKey key = new KernelKey(kernelId);
        KernelDef def = new KernelDef(KernelType.Hellinger, props);
        kernelDefRegion.put(key, def);
    }

}
