package io.pivotal.bds.gemfire.r.shell.antlr.test;

import java.util.BitSet;

import org.antlr.v4.runtime.ANTLRErrorListener;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;

import io.pivotal.bds.gemfire.r.shell.antlr.ShellBaseListener;
import io.pivotal.bds.gemfire.r.shell.antlr.ShellLexer;
import io.pivotal.bds.gemfire.r.shell.antlr.ShellParser;

public class Test {

    private static ShellBaseListener list = new ShellBaseListener();
    private static ErrorList errList = new ErrorList();

    public static void main(String[] args) throws Exception {
        test("x1=matrix(q1,[x],[100])");
        test("x1=matrix(q1,[x],[100.2])");
        test("y1=vect(q1,y,[100])");
        test("y1=vect(q1,y,[100.7])");
        test("predict(m1,100)");
        test("predict(m1,100.5)");
        test("m1=gp(x1,y1)");
    }

    private static void test(String line) {
        CharStream input = new ANTLRInputStream(line);
        ShellLexer lex = new ShellLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lex);
        ShellParser parser = new ShellParser(tokens);
        parser.addParseListener(list);
        parser.addErrorListener(errList);
        parser.cmd();

    }

    private static class ErrorList implements ANTLRErrorListener {

        @Override
        public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg,
                RecognitionException e) {
            System.err.println("syntaxError: offendingSymbol = " + offendingSymbol + ", line = " + line + ", msg = " + msg);
        }

        @Override
        public void reportAmbiguity(Parser recognizer, DFA dfa, int startIndex, int stopIndex, boolean exact, BitSet ambigAlts,
                ATNConfigSet configs) {
            System.err.println("reportAmbiguity: startIndex = " + startIndex + ", stopIndex = " + stopIndex + ", exact = " + exact);
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
