package io.pivotal.bds.gemfire.r.shell;

import java.io.PrintStream;
import java.util.Scanner;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;

import com.gemstone.gemfire.cache.Region;
import com.gemstone.gemfire.cache.client.ClientCache;
import com.gemstone.gemfire.cache.client.ClientCacheFactory;
import com.gemstone.gemfire.cache.client.ClientRegionFactory;
import com.gemstone.gemfire.cache.client.ClientRegionShortcut;
import com.gemstone.gemfire.cache.client.Pool;
import com.gemstone.gemfire.cache.query.QueryService;

import io.pivotal.bds.gemfire.r.common.EvaluateDef;
import io.pivotal.bds.gemfire.r.common.EvaluateKey;
import io.pivotal.bds.gemfire.r.common.ModelDef;
import io.pivotal.bds.gemfire.r.common.ModelKey;
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

        ShellListenerImpl list = new ShellListenerImpl(stdout, qs, queryLimit, pool, queryRegion, modelDefRegion, evalDefRegion);

        boolean cont = true;
        Scanner sc = new Scanner(System.in);

        try {
            do {
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
                        parser.cmd();
                    } catch (Exception x) {
                        stdout.println(x.getMessage());
                        x.printStackTrace();
                    }
                }
            } while (cont);
        } finally {
            sc.close();
        }
    }
}
