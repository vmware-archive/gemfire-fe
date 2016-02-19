package io.pivotal.bds.gemfire.r.shell.antlr;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import com.gemstone.gemfire.cache.Region;
import com.gemstone.gemfire.cache.client.Pool;
import com.gemstone.gemfire.cache.execute.FunctionService;
import com.gemstone.gemfire.cache.execute.ResultCollector;
import com.gemstone.gemfire.cache.query.Query;
import com.gemstone.gemfire.cache.query.QueryService;
import com.gemstone.gemfire.cache.query.SelectResults;
import com.gemstone.gemfire.cache.query.Struct;
import com.gemstone.gemfire.pdx.PdxInstance;

import io.pivotal.bds.gemfire.ml.ModelName;
import io.pivotal.bds.gemfire.ml.ModelType;
import io.pivotal.bds.gemfire.r.common.AdhocPrediction;
import io.pivotal.bds.gemfire.r.common.AdhocPredictionRequest;
import io.pivotal.bds.gemfire.r.common.AdhocPredictionResponse;
import io.pivotal.bds.gemfire.r.common.EvaluateDef;
import io.pivotal.bds.gemfire.r.common.EvaluateKey;
import io.pivotal.bds.gemfire.r.common.FFTRequest;
import io.pivotal.bds.gemfire.r.common.FFTResponse;
import io.pivotal.bds.gemfire.r.common.Matrix;
import io.pivotal.bds.gemfire.r.common.MatrixDef;
import io.pivotal.bds.gemfire.r.common.MatrixKey;
import io.pivotal.bds.gemfire.r.common.ModelDef;
import io.pivotal.bds.gemfire.r.common.ModelKey;
import io.pivotal.bds.gemfire.r.common.Vector;
import io.pivotal.bds.gemfire.r.common.VectorDef;
import io.pivotal.bds.gemfire.r.common.VectorKey;
import io.pivotal.bds.gemfire.r.shell.antlr.ShellParser.EvaluateContext;
import io.pivotal.bds.gemfire.r.shell.antlr.ShellParser.ExecuteContext;
import io.pivotal.bds.gemfire.r.shell.antlr.ShellParser.FftContext;
import io.pivotal.bds.gemfire.r.shell.antlr.ShellParser.FieldNameContext;
import io.pivotal.bds.gemfire.r.shell.antlr.ShellParser.FieldNamesContext;
import io.pivotal.bds.gemfire.r.shell.antlr.ShellParser.GpContext;
import io.pivotal.bds.gemfire.r.shell.antlr.ShellParser.LsContext;
import io.pivotal.bds.gemfire.r.shell.antlr.ShellParser.MatrixContext;
import io.pivotal.bds.gemfire.r.shell.antlr.ShellParser.PredictContext;
import io.pivotal.bds.gemfire.r.shell.antlr.ShellParser.PrintContext;
import io.pivotal.bds.gemfire.r.shell.antlr.ShellParser.QueryArgContext;
import io.pivotal.bds.gemfire.r.shell.antlr.ShellParser.QueryArgsContext;
import io.pivotal.bds.gemfire.r.shell.antlr.ShellParser.QueryContext;
import io.pivotal.bds.gemfire.r.shell.antlr.ShellParser.SvmContext;
import io.pivotal.bds.gemfire.r.shell.antlr.ShellParser.VectorContext;

public class ShellListenerImpl extends ShellBaseListener {

    private PrintStream stdout;
    private QueryService queryService;
    private int queryLimit;
    private Pool pool;

    private Region<String, String> queryRegion;
    private Region<ModelKey, ModelDef> modelDefRegion;
    private Region<EvaluateKey, EvaluateDef> evaluateDefRegion;
    private Region<VectorKey, VectorDef> vectorDefRegion;
    private Region<MatrixKey, MatrixDef> matrixDefRegion;
    private Region<VectorKey, Vector<Object>> vectorRegion;
    private Region<MatrixKey, Matrix<Object>> matrixRegion;

    public ShellListenerImpl(PrintStream stdout, QueryService queryService, int queryLimit, Pool pool,
            Region<String, String> queryRegion, Region<ModelKey, ModelDef> modelDefRegion,
            Region<EvaluateKey, EvaluateDef> evaluateDefRegion, Region<VectorKey, VectorDef> vectorDefRegion,
            Region<MatrixKey, MatrixDef> matrixDefRegion, Region<VectorKey, Vector<Object>> vectorRegion,
            Region<MatrixKey, Matrix<Object>> matrixRegion) {
        this.stdout = stdout;
        this.queryService = queryService;
        this.queryLimit = queryLimit;
        this.pool = pool;
        this.queryRegion = queryRegion;
        this.modelDefRegion = modelDefRegion;
        this.evaluateDefRegion = evaluateDefRegion;
        this.vectorDefRegion = vectorDefRegion;
        this.matrixDefRegion = matrixDefRegion;
        this.vectorRegion = vectorRegion;
        this.matrixRegion = matrixRegion;
    }

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

        @SuppressWarnings("unchecked")
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

    @Override
    public void exitEvaluate(EvaluateContext ctx) {
        String modelId = ctx.modelId().getText();
        ModelKey modelKey = new ModelKey(modelId);
        ModelDef modelDef = modelDefRegion.get(modelKey);
        Assert.notNull(modelDef, "Model " + modelId + " does not exist");

        String evalId = ctx.evaluateId().getText();
        String regionName = ctx.regionName().getText();

        List<String> fieldNames = convertFieldVar(ctx.fieldName());
        String[] fns = fieldNames.toArray(new String[fieldNames.size()]);

        EvaluateKey evalKey = new EvaluateKey(evalId, modelId);
        EvaluateDef evalDef = new EvaluateDef(modelKey, regionName, fns);
        evaluateDefRegion.put(evalKey, evalDef);
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
            String sd = ac.NUMBER() == null ? null : ac.NUMBER().getText();

            if (StringUtils.hasText(sd)) {
                Double d = new Double(sd);
                args.add(d);
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
        String matrixId = ctx.matrixId().getText();
        String vectorId = ctx.vectorId().getText();

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

        ModelKey key = new ModelKey(modelId);
        ModelDef info = new ModelDef(key, matrixId, vectorId, ModelType.classification, ModelName.SVM, params);

        modelDefRegion.put(key, info);
    }

    @Override
    public void exitGp(GpContext ctx) {
        String matrixId = ctx.matrixId().getText();
        String vectorId = ctx.vectorId().getText();

        String modelId = ctx.modelId().getText();

        Map<String, Object> params = new HashMap<>();

        String sl = ctx.lambdaVar() == null ? null : ctx.lambdaVar().getText();
        if (StringUtils.hasText(sl)) {
            params.put("lambda", new Double(sl));
        }

        ModelKey key = new ModelKey(modelId);
        ModelDef info = new ModelDef(key, matrixId, vectorId, ModelType.regression, ModelName.GaussianProcess, params);

        modelDefRegion.put(key, info);
    }

    @Override
    public void exitPredict(PredictContext ctx) {
        String modelId = ctx.modelId().getText();
        ModelKey modelKey = new ModelKey(modelId);
        ModelDef modelDef = modelDefRegion.get(modelKey);
        Assert.notNull(modelDef, "Model " + modelId + " does not exist");

        Object arg = null;

        if (ctx.vectorId() != null) {
            arg = ctx.vectorId().getText();
        } else if (ctx.number() != null) {
            arg = ctx.number() == null ? null : new Double(ctx.number().getText());
        } else {
            // TODO
        }

        AdhocPredictionRequest req = new AdhocPredictionRequest(modelKey, arg);

        ResultCollector<?, ?> coll = FunctionService.onServer(pool).withArgs(req).execute("AdhocPredictionFunction");

        @SuppressWarnings("unchecked")
        List<AdhocPredictionResponse> lresp = (List<AdhocPredictionResponse>) coll.getResult();
        Assert.isTrue(!lresp.isEmpty(), "No response");

        AdhocPredictionResponse resp = lresp.get(0);

        for (AdhocPrediction pres : resp.getResults()) {
            stdout.println("x = " + Arrays.toString(pres.getX()) + " y = " + pres.getP());
        }
    }

    private List<Object> convert(List<QueryArgContext> queryArg) {
        List<Object> queryArgs = new ArrayList<>();

        if (queryArg != null) {
            for (QueryArgContext qa : queryArg) {
                String sd = qa.NUMBER() == null ? null : qa.NUMBER().getText();
                if (StringUtils.hasText(sd)) {
                    queryArgs.add(new Double(sd));
                }

                String ss = qa.QUOTEDSTRING() == null ? null : qa.QUOTEDSTRING().getText();
                if (StringUtils.hasText(ss)) {
                    ss = ss.substring(1, ss.length() - 1);
                    if (StringUtils.hasText(ss)) {
                        queryArgs.add(ss);
                    }
                }
            }
        }

        return queryArgs;
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
        found = printEvalVar(var) || found;
        found = printVectorVar(var) || found;
        found = printMatrixVar(var) || found;

        if (!found) {
            stdout.println("<variable not found>");
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

    private boolean printEvalVar(String evalId) {
        EvaluateKey key = new EvaluateKey(evalId, "");
        EvaluateDef def = evaluateDefRegion.get(key);

        if (def == null) {
            return false;
        } else {
            stdout.println("Evaluate:");
            stdout.println("   model  = " + def.getModelKey().getModelId());
            stdout.println("   region = " + def.getRegionName());
            stdout.println("   fields = " + Arrays.toString(def.getFieldNames()));
            return true;
        }
    }

    private boolean printModelVar(String modelId) {
        ModelKey mk = new ModelKey(modelId);
        ModelDef info = modelDefRegion.get(mk);

        if (info == null) {
            return false;
        } else {
            stdout.println("Model:");
            stdout.println("   name   = " + info.getModelName());
            stdout.println("   type   = " + info.getModelType());
            stdout.println("   matrix = " + info.getMatrixId());
            stdout.println("   vector = " + info.getVectorId());

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

        stdout.println("Evaluate:");
        printEvalVars(evaluateDefRegion.keySetOnServer());
    }

    private void printVectorVars(Set<VectorKey> c) {
        List<String> l = new ArrayList<>();
        for (VectorKey ek : c) {
            l.add(ek.getVectorId());
        }
        Collections.sort(l);
        for (String s : l) {
            stdout.println("   " + s);
        }
    }

    private void printMatrixVars(Set<MatrixKey> c) {
        List<String> l = new ArrayList<>();
        for (MatrixKey ek : c) {
            l.add(ek.getMatrixId());
        }
        Collections.sort(l);
        for (String s : l) {
            stdout.println("   " + s);
        }
    }

    private void printEvalVars(Set<EvaluateKey> c) {
        List<String> l = new ArrayList<>();
        for (EvaluateKey ek : c) {
            l.add(ek.getEvaluateId());
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

    private void printModelVars(Set<ModelKey> c) {
        List<String> l = new ArrayList<>();
        for (ModelKey k : c) {
            l.add(k.getModelId());
        }
        Collections.sort(l);
        for (String s : l) {
            stdout.println("   " + s);
        }
    }

}
