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

import io.pivotal.bds.gemfire.r.common.EvaluateDef;
import io.pivotal.bds.gemfire.r.common.EvaluateKey;
import io.pivotal.bds.gemfire.r.common.MatrixDef;
import io.pivotal.bds.gemfire.r.common.MatrixKey;
import io.pivotal.bds.gemfire.r.common.ModelDef;
import io.pivotal.bds.gemfire.r.common.ModelKey;
import io.pivotal.bds.gemfire.r.common.VectorDef;
import io.pivotal.bds.gemfire.r.common.VectorKey;
import io.pivotal.bds.gemfire.r.shell.antlr.ShellLexer;
import io.pivotal.bds.gemfire.r.shell.antlr.ShellListenerImpl;
import io.pivotal.bds.gemfire.r.shell.antlr.ShellParser;

public class R {

    public static void main(String[] args) throws Exception {
        // swap stdout and stderr for file output
        PrintStream stdout = System.out;

        PrintStream fout = new PrintStream("gfr.log");
        System.setOut(fout);
        System.setErr(fout);

        String locatorHost = "localhost";
        int locatorPort = 10334;

        ClientCacheFactory ccf = new ClientCacheFactory();

        ccf.addPoolLocator(locatorHost, locatorPort);
        ccf.setPdxReadSerialized(true);

        ClientCache cc = ccf.create();
        QueryService qs = cc.getQueryService();
        Pool pool = cc.getDefaultPool();

        int queryLimit = 100;

        ClientRegionFactory<String, String> queryCRF = cc.createClientRegionFactory(ClientRegionShortcut.CACHING_PROXY);
        Region<String, String> queryRegion = queryCRF.create("queries");

        ClientRegionFactory<ModelKey, ModelDef> modelDefCRF = cc.createClientRegionFactory(ClientRegionShortcut.CACHING_PROXY);
        Region<ModelKey, ModelDef> modelDefRegion = modelDefCRF.create("modelDef");

        ClientRegionFactory<EvaluateKey, EvaluateDef> evalDefCRF = cc.createClientRegionFactory(ClientRegionShortcut.CACHING_PROXY);
        Region<EvaluateKey, EvaluateDef> evalDefRegion = evalDefCRF.create("evaluate");

        ClientRegionFactory<VectorKey, VectorDef> vectorDefCRF = cc.createClientRegionFactory(ClientRegionShortcut.CACHING_PROXY);
        Region<VectorKey, VectorDef> vectorDefRegion = vectorDefCRF.create("vectorDef");

        ClientRegionFactory<MatrixKey, MatrixDef> matrixDefCRF = cc.createClientRegionFactory(ClientRegionShortcut.CACHING_PROXY);
        Region<MatrixKey, MatrixDef> matrixDefRegion = matrixDefCRF.create("matrixDef");

        ShellListenerImpl list = new ShellListenerImpl(stdout, qs, queryLimit, pool, queryRegion, modelDefRegion, evalDefRegion,
                vectorDefRegion, matrixDefRegion);

        boolean cont = true;
        Scanner sc = new Scanner(System.in);

        try {
            do {
                stdout.println();
                stdout.print("gfr> ");
                String line = sc.nextLine();

                if ("exit".equalsIgnoreCase(line)) {
                    cont = false;
                } else {
                    try {
                        CharStream input = new ANTLRInputStream(line);
                        ShellLexer lex = new ShellLexer(input);
                        CommonTokenStream tokens = new CommonTokenStream(lex);
                        ShellParser parser = new ShellParser(tokens);
                        parser.addParseListener(list);
                        parser.addErrorListener(new ErrorList());
                        parser.cmd();
                    } catch (ServerOperationException x) {
                        stdout.println(x.getCause().getMessage());
                        stdout.println(x.getRootCause().getMessage());
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

        @Override
        public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg,
                RecognitionException e) {
            throw new IllegalArgumentException("Syntax error at " + charPositionInLine + " near " + offendingSymbol + ": " + msg);
        }

        @Override
        public void reportAmbiguity(Parser recognizer, DFA dfa, int startIndex, int stopIndex, boolean exact, BitSet ambigAlts,
                ATNConfigSet configs) {
        }

        @Override
        public void reportAttemptingFullContext(Parser recognizer, DFA dfa, int startIndex, int stopIndex, BitSet conflictingAlts,
                ATNConfigSet configs) {
        }

        @Override
        public void reportContextSensitivity(Parser recognizer, DFA dfa, int startIndex, int stopIndex, int prediction,
                ATNConfigSet configs) {
        }

    }
}
