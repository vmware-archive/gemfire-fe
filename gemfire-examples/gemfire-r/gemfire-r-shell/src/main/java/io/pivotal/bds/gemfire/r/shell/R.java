package io.pivotal.bds.gemfire.r.shell;

import java.io.PrintStream;
import java.util.BitSet;
import java.util.Scanner;

import org.antlr.v4.runtime.ANTLRErrorListener;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;

import com.gemstone.gemfire.cache.Region;
import com.gemstone.gemfire.cache.client.ClientCache;
import com.gemstone.gemfire.cache.client.ClientCacheFactory;
import com.gemstone.gemfire.cache.client.ClientRegionFactory;
import com.gemstone.gemfire.cache.client.ClientRegionShortcut;
import com.gemstone.gemfire.cache.client.Pool;
import com.gemstone.gemfire.cache.client.ServerOperationException;
import com.gemstone.gemfire.cache.query.QueryService;

import io.pivotal.bds.gemfire.r.common.PredictDef;
import io.pivotal.bds.gemfire.r.common.PredictDefKey;
import io.pivotal.bds.gemfire.r.common.TrainDef;
import io.pivotal.bds.gemfire.r.common.TrainDefKey;
import io.pivotal.bds.gemfire.r.common.DynamicTrainDef;
import io.pivotal.bds.gemfire.r.common.DynamicTrainDefKey;
import io.pivotal.bds.gemfire.r.common.HMMDef;
import io.pivotal.bds.gemfire.r.common.HMMKey;
import io.pivotal.bds.gemfire.r.common.KernelDef;
import io.pivotal.bds.gemfire.r.common.KernelKey;
import io.pivotal.bds.gemfire.r.common.Matrix;
import io.pivotal.bds.gemfire.r.common.MatrixDef;
import io.pivotal.bds.gemfire.r.common.MatrixKey;
import io.pivotal.bds.gemfire.r.common.ModelDef;
import io.pivotal.bds.gemfire.r.common.ModelDefKey;
import io.pivotal.bds.gemfire.r.common.PMMLData;
import io.pivotal.bds.gemfire.r.common.PMMLKey;
import io.pivotal.bds.gemfire.r.common.PMMLPredictDef;
import io.pivotal.bds.gemfire.r.common.PMMLPredictDefKey;
import io.pivotal.bds.gemfire.r.common.Vector;
import io.pivotal.bds.gemfire.r.common.VectorDef;
import io.pivotal.bds.gemfire.r.common.VectorKey;
import io.pivotal.bds.gemfire.r.shell.antlr.ShellLexer;
import io.pivotal.bds.gemfire.r.shell.antlr.ShellListenerImpl;
import io.pivotal.bds.gemfire.r.shell.antlr.ShellParser;
import io.pivotal.bds.gemfire.r.shell.antlr.ShellParser.CmdContext;

public class R {

    public static void main(String[] args) throws Exception {
        // swap stdout and stderr for file output
        PrintStream stdout = System.out;

        PrintStream fout = new PrintStream("gfr.log");
        System.setOut(fout);
        System.setErr(fout);

        String locatorHost = "localhost";
        int locatorPort = 10334;

        if (args.length == 1) {
            locatorHost = args[0];
        }

        ClientCacheFactory ccf = new ClientCacheFactory();

        ccf.addPoolLocator(locatorHost, locatorPort);
        ccf.setPdxReadSerialized(true);

        ClientCache cc = ccf.create();
        QueryService qs = cc.getQueryService();
        Pool pool = cc.getDefaultPool();

        int queryLimit = 100;

        ClientRegionFactory<String, String> queryCRF = cc.createClientRegionFactory(ClientRegionShortcut.PROXY);
        Region<String, String> queryRegion = queryCRF.create("queries");

        ClientRegionFactory<ModelDefKey, ModelDef> modelDefCRF = cc.createClientRegionFactory(ClientRegionShortcut.PROXY);
        Region<ModelDefKey, ModelDef> modelDefRegion = modelDefCRF.create("modelDef");

        ClientRegionFactory<PredictDefKey, PredictDef> predictDefCRF = cc
                .createClientRegionFactory(ClientRegionShortcut.PROXY);
        Region<PredictDefKey, PredictDef> predictDefRegion = predictDefCRF.create("predictDef");

        ClientRegionFactory<VectorKey, VectorDef> vectorDefCRF = cc.createClientRegionFactory(ClientRegionShortcut.PROXY);
        Region<VectorKey, VectorDef> vectorDefRegion = vectorDefCRF.create("vectorDef");

        ClientRegionFactory<MatrixKey, MatrixDef> matrixDefCRF = cc.createClientRegionFactory(ClientRegionShortcut.PROXY);
        Region<MatrixKey, MatrixDef> matrixDefRegion = matrixDefCRF.create("matrixDef");

        ClientRegionFactory<VectorKey, Vector<Object>> vectorCRF = cc.createClientRegionFactory(ClientRegionShortcut.PROXY);
        Region<VectorKey, Vector<Object>> vectorRegion = vectorCRF.create("vector");

        ClientRegionFactory<MatrixKey, Matrix<Object>> matrixCRF = cc.createClientRegionFactory(ClientRegionShortcut.PROXY);
        Region<MatrixKey, Matrix<Object>> matrixRegion = matrixCRF.create("matrix");

        ClientRegionFactory<TrainDefKey, TrainDef> trainDefCRF = cc.createClientRegionFactory(ClientRegionShortcut.PROXY);
        Region<TrainDefKey, TrainDef> trainDefRegion = trainDefCRF.create("trainDef");

        ClientRegionFactory<DynamicTrainDefKey, DynamicTrainDef> dynamicTrainDefCRF = cc
                .createClientRegionFactory(ClientRegionShortcut.PROXY);
        Region<DynamicTrainDefKey, DynamicTrainDef> dynamicTrainDefRegion = dynamicTrainDefCRF.create("dynamicTrainDef");

        ClientRegionFactory<KernelKey, KernelDef> kernelDefCRF = cc.createClientRegionFactory(ClientRegionShortcut.PROXY);
        Region<KernelKey, KernelDef> kernelDefRegion = kernelDefCRF.create("kernelDef");

        ClientRegionFactory<HMMKey, HMMDef> hmmDefCRF = cc.createClientRegionFactory(ClientRegionShortcut.PROXY);
        Region<HMMKey, HMMDef> hmmDefRegion = hmmDefCRF.create("hmmDef");

        ClientRegionFactory<PMMLKey, PMMLData> pmmlDataCRF = cc.createClientRegionFactory(ClientRegionShortcut.PROXY);
        Region<PMMLKey, PMMLData> pmmlDataRegion = pmmlDataCRF.create("pmmlData");

        ClientRegionFactory<PMMLPredictDefKey, PMMLPredictDef> pmmlPredictDefCRF = cc
                .createClientRegionFactory(ClientRegionShortcut.PROXY);
        Region<PMMLPredictDefKey, PMMLPredictDef> pmmlPredictDefRegion = pmmlPredictDefCRF.create("pmmlPredictDef");

        ShellListenerImpl list = new ShellListenerImpl(stdout, fout, qs, queryLimit, pool, queryRegion, modelDefRegion,
                predictDefRegion, vectorDefRegion, matrixDefRegion, vectorRegion, matrixRegion, trainDefRegion,
                dynamicTrainDefRegion, kernelDefRegion, hmmDefRegion, pmmlDataRegion, pmmlPredictDefRegion);

        ErrorList errorList = new ErrorList(fout);
        boolean cont = true;
        Scanner sc = new Scanner(System.in);

        try {
            do {
                stdout.println();
                stdout.print("gfr> ");
                String line = sc.nextLine();
                fout.println("cmd: " + line);

                if ("exit".equalsIgnoreCase(line)) {
                    cont = false;
                } else {
                    try {
                        CharStream input = new ANTLRInputStream(line);
                        ShellLexer lex = new ShellLexer(input);
                        CommonTokenStream tokens = new CommonTokenStream(lex);
                        ShellParser parser = new ShellParser(tokens);
                        parser.addParseListener(list);
                        parser.addErrorListener(errorList);
                        parser.setTrace(true);
                        CmdContext cctx = parser.cmd();
                        fout.println("CmdContext: " + cctx);
                    } catch (ServerOperationException x) {
                        stdout.println(x.getCause().getMessage());
                        stdout.println(x.getRootCause().getMessage());
                        x.printStackTrace(fout);
                    } catch (Exception x) {
                        stdout.println(x.getMessage());
                        x.printStackTrace(fout);
                    }
                }
            } while (cont);
        } finally {
            sc.close();
        }
    }

    private static class ErrorList implements ANTLRErrorListener {

        private PrintStream log;

        public ErrorList(PrintStream log) {
            this.log = log;
        }

        @Override
        public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg,
                RecognitionException e) {
            log.println("syntaxError: " + charPositionInLine + " near " + offendingSymbol + ": " + msg);
            throw new IllegalArgumentException("Syntax error at " + charPositionInLine + " near " + offendingSymbol + ": " + msg);
        }

        @Override
        public void reportAmbiguity(Parser recognizer, DFA dfa, int startIndex, int stopIndex, boolean exact, BitSet ambigAlts,
                ATNConfigSet configs) {
            log.println("reportAmbiguity: startIndex=" + startIndex + ", stopIndex=" + stopIndex + ", exact=" + exact);
        }

        @Override
        public void reportAttemptingFullContext(Parser recognizer, DFA dfa, int startIndex, int stopIndex, BitSet conflictingAlts,
                ATNConfigSet configs) {
            log.println("reportAttemptingFullContext: startIndex=" + startIndex + ", stopIndex=" + stopIndex);
        }

        @Override
        public void reportContextSensitivity(Parser recognizer, DFA dfa, int startIndex, int stopIndex, int prediction,
                ATNConfigSet configs) {
            log.println("reportContextSensitivity: startIndex=" + startIndex + ", stopIndex=" + stopIndex + ", prediction="
                    + prediction);
        }

    }
}
