// Generated from io/pivotal/bds/gemfire/r/shell/antlr/Shell.g4 by ANTLR 4.5.2
package io.pivotal.bds.gemfire.r.shell.antlr;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ShellParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		EVALUATE=1, QUERYARGS=2, MODEL=3, FIELDS=4, REGION=5, RM=6, LS=7, PRINT=8, 
		PREDICT=9, K=10, LAMBDA=11, GP=12, SVM=13, KERNEL=14, CP=15, CN=16, QUERY=17, 
		EXECUTE=18, LBRACKET=19, RBRACKET=20, LPAREN=21, RPAREN=22, LBRACE=23, 
		RBRACE=24, DBLQUOTES=25, COMMA=26, EQUALS=27, IDENTIFIER=28, INTEGER=29, 
		DECIMAL=30, NUMBER=31, QUOTEDSTRING=32, WS=33;
	public static final int
		RULE_cmd = 0, RULE_query = 1, RULE_execute = 2, RULE_svm = 3, RULE_gp = 4, 
		RULE_predict = 5, RULE_evaluate = 6, RULE_print = 7, RULE_ls = 8, RULE_rm = 9, 
		RULE_kernels = 10, RULE_queryArg = 11, RULE_queryArgs = 12, RULE_cpVar = 13, 
		RULE_cnVar = 14, RULE_kVar = 15, RULE_lambdaVar = 16, RULE_var = 17, RULE_evaluateVar = 18, 
		RULE_fieldVar = 19, RULE_modelVar = 20, RULE_queryVar = 21, RULE_regionVar = 22, 
		RULE_queryString = 23;
	public static final String[] ruleNames = {
		"cmd", "query", "execute", "svm", "gp", "predict", "evaluate", "print", 
		"ls", "rm", "kernels", "queryArg", "queryArgs", "cpVar", "cnVar", "kVar", 
		"lambdaVar", "var", "evaluateVar", "fieldVar", "modelVar", "queryVar", 
		"regionVar", "queryString"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'evaluate'", "'queryArgs'", "'model'", "'fields'", "'region'", 
		"'rm'", "'ls'", "'print'", "'predict'", "'k'", "'lambda'", "'gp'", "'svm'", 
		"'kernel'", "'cp'", "'cn'", "'query'", "'execute'", "'['", "']'", "'('", 
		"')'", "'{'", "'}'", "'\"'", "','", "'='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "EVALUATE", "QUERYARGS", "MODEL", "FIELDS", "REGION", "RM", "LS", 
		"PRINT", "PREDICT", "K", "LAMBDA", "GP", "SVM", "KERNEL", "CP", "CN", 
		"QUERY", "EXECUTE", "LBRACKET", "RBRACKET", "LPAREN", "RPAREN", "LBRACE", 
		"RBRACE", "DBLQUOTES", "COMMA", "EQUALS", "IDENTIFIER", "INTEGER", "DECIMAL", 
		"NUMBER", "QUOTEDSTRING", "WS"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Shell.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ShellParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class CmdContext extends ParserRuleContext {
		public QueryContext query() {
			return getRuleContext(QueryContext.class,0);
		}
		public ExecuteContext execute() {
			return getRuleContext(ExecuteContext.class,0);
		}
		public SvmContext svm() {
			return getRuleContext(SvmContext.class,0);
		}
		public GpContext gp() {
			return getRuleContext(GpContext.class,0);
		}
		public PredictContext predict() {
			return getRuleContext(PredictContext.class,0);
		}
		public PrintContext print() {
			return getRuleContext(PrintContext.class,0);
		}
		public LsContext ls() {
			return getRuleContext(LsContext.class,0);
		}
		public RmContext rm() {
			return getRuleContext(RmContext.class,0);
		}
		public EvaluateContext evaluate() {
			return getRuleContext(EvaluateContext.class,0);
		}
		public CmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).enterCmd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).exitCmd(this);
		}
	}

	public final CmdContext cmd() throws RecognitionException {
		CmdContext _localctx = new CmdContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_cmd);
		try {
			setState(57);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(48);
				query();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(49);
				execute();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(50);
				svm();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(51);
				gp();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(52);
				predict();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(53);
				print();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(54);
				ls();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(55);
				rm();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(56);
				evaluate();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QueryContext extends ParserRuleContext {
		public QueryVarContext queryVar() {
			return getRuleContext(QueryVarContext.class,0);
		}
		public TerminalNode EQUALS() { return getToken(ShellParser.EQUALS, 0); }
		public TerminalNode QUERY() { return getToken(ShellParser.QUERY, 0); }
		public TerminalNode LPAREN() { return getToken(ShellParser.LPAREN, 0); }
		public QueryStringContext queryString() {
			return getRuleContext(QueryStringContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ShellParser.RPAREN, 0); }
		public QueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_query; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).enterQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).exitQuery(this);
		}
	}

	public final QueryContext query() throws RecognitionException {
		QueryContext _localctx = new QueryContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_query);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
			queryVar();
			setState(60);
			match(EQUALS);
			setState(61);
			match(QUERY);
			setState(62);
			match(LPAREN);
			setState(63);
			queryString();
			setState(64);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExecuteContext extends ParserRuleContext {
		public TerminalNode EXECUTE() { return getToken(ShellParser.EXECUTE, 0); }
		public TerminalNode LPAREN() { return getToken(ShellParser.LPAREN, 0); }
		public QueryVarContext queryVar() {
			return getRuleContext(QueryVarContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ShellParser.RPAREN, 0); }
		public List<TerminalNode> COMMA() { return getTokens(ShellParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ShellParser.COMMA, i);
		}
		public List<QueryArgContext> queryArg() {
			return getRuleContexts(QueryArgContext.class);
		}
		public QueryArgContext queryArg(int i) {
			return getRuleContext(QueryArgContext.class,i);
		}
		public ExecuteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_execute; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).enterExecute(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).exitExecute(this);
		}
	}

	public final ExecuteContext execute() throws RecognitionException {
		ExecuteContext _localctx = new ExecuteContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_execute);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			match(EXECUTE);
			setState(67);
			match(LPAREN);
			setState(68);
			queryVar();
			setState(73);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(69);
				match(COMMA);
				setState(70);
				queryArg();
				}
				}
				setState(75);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(76);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SvmContext extends ParserRuleContext {
		public ModelVarContext modelVar() {
			return getRuleContext(ModelVarContext.class,0);
		}
		public List<TerminalNode> EQUALS() { return getTokens(ShellParser.EQUALS); }
		public TerminalNode EQUALS(int i) {
			return getToken(ShellParser.EQUALS, i);
		}
		public TerminalNode SVM() { return getToken(ShellParser.SVM, 0); }
		public TerminalNode LPAREN() { return getToken(ShellParser.LPAREN, 0); }
		public TerminalNode QUERY() { return getToken(ShellParser.QUERY, 0); }
		public QueryVarContext queryVar() {
			return getRuleContext(QueryVarContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ShellParser.RPAREN, 0); }
		public List<TerminalNode> COMMA() { return getTokens(ShellParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ShellParser.COMMA, i);
		}
		public TerminalNode KERNEL() { return getToken(ShellParser.KERNEL, 0); }
		public KernelsContext kernels() {
			return getRuleContext(KernelsContext.class,0);
		}
		public TerminalNode CP() { return getToken(ShellParser.CP, 0); }
		public CpVarContext cpVar() {
			return getRuleContext(CpVarContext.class,0);
		}
		public TerminalNode CN() { return getToken(ShellParser.CN, 0); }
		public CnVarContext cnVar() {
			return getRuleContext(CnVarContext.class,0);
		}
		public TerminalNode K() { return getToken(ShellParser.K, 0); }
		public KVarContext kVar() {
			return getRuleContext(KVarContext.class,0);
		}
		public TerminalNode QUERYARGS() { return getToken(ShellParser.QUERYARGS, 0); }
		public QueryArgsContext queryArgs() {
			return getRuleContext(QueryArgsContext.class,0);
		}
		public SvmContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_svm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).enterSvm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).exitSvm(this);
		}
	}

	public final SvmContext svm() throws RecognitionException {
		SvmContext _localctx = new SvmContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_svm);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			modelVar();
			setState(79);
			match(EQUALS);
			setState(80);
			match(SVM);
			setState(81);
			match(LPAREN);
			setState(82);
			match(QUERY);
			setState(83);
			match(EQUALS);
			setState(84);
			queryVar();
			setState(89);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(85);
				match(COMMA);
				setState(86);
				match(KERNEL);
				setState(87);
				match(EQUALS);
				setState(88);
				kernels();
				}
				break;
			}
			setState(95);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				setState(91);
				match(COMMA);
				setState(92);
				match(CP);
				setState(93);
				match(EQUALS);
				setState(94);
				cpVar();
				}
				break;
			}
			setState(101);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				setState(97);
				match(COMMA);
				setState(98);
				match(CN);
				setState(99);
				match(EQUALS);
				setState(100);
				cnVar();
				}
				break;
			}
			setState(107);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				setState(103);
				match(COMMA);
				setState(104);
				match(K);
				setState(105);
				match(EQUALS);
				setState(106);
				kVar();
				}
				break;
			}
			setState(113);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(109);
				match(COMMA);
				setState(110);
				match(QUERYARGS);
				setState(111);
				match(EQUALS);
				setState(112);
				queryArgs();
				}
			}

			setState(115);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GpContext extends ParserRuleContext {
		public ModelVarContext modelVar() {
			return getRuleContext(ModelVarContext.class,0);
		}
		public List<TerminalNode> EQUALS() { return getTokens(ShellParser.EQUALS); }
		public TerminalNode EQUALS(int i) {
			return getToken(ShellParser.EQUALS, i);
		}
		public TerminalNode GP() { return getToken(ShellParser.GP, 0); }
		public TerminalNode LPAREN() { return getToken(ShellParser.LPAREN, 0); }
		public TerminalNode QUERY() { return getToken(ShellParser.QUERY, 0); }
		public QueryVarContext queryVar() {
			return getRuleContext(QueryVarContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ShellParser.RPAREN, 0); }
		public List<TerminalNode> COMMA() { return getTokens(ShellParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ShellParser.COMMA, i);
		}
		public TerminalNode LAMBDA() { return getToken(ShellParser.LAMBDA, 0); }
		public LambdaVarContext lambdaVar() {
			return getRuleContext(LambdaVarContext.class,0);
		}
		public TerminalNode QUERYARGS() { return getToken(ShellParser.QUERYARGS, 0); }
		public QueryArgsContext queryArgs() {
			return getRuleContext(QueryArgsContext.class,0);
		}
		public GpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_gp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).enterGp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).exitGp(this);
		}
	}

	public final GpContext gp() throws RecognitionException {
		GpContext _localctx = new GpContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_gp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(117);
			modelVar();
			setState(118);
			match(EQUALS);
			setState(119);
			match(GP);
			setState(120);
			match(LPAREN);
			setState(121);
			match(QUERY);
			setState(122);
			match(EQUALS);
			setState(123);
			queryVar();
			setState(128);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				setState(124);
				match(COMMA);
				setState(125);
				match(LAMBDA);
				setState(126);
				match(EQUALS);
				setState(127);
				lambdaVar();
				}
				break;
			}
			setState(134);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(130);
				match(COMMA);
				setState(131);
				match(QUERYARGS);
				setState(132);
				match(EQUALS);
				setState(133);
				queryArgs();
				}
			}

			setState(136);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PredictContext extends ParserRuleContext {
		public TerminalNode PREDICT() { return getToken(ShellParser.PREDICT, 0); }
		public TerminalNode LPAREN() { return getToken(ShellParser.LPAREN, 0); }
		public ModelVarContext modelVar() {
			return getRuleContext(ModelVarContext.class,0);
		}
		public List<TerminalNode> COMMA() { return getTokens(ShellParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ShellParser.COMMA, i);
		}
		public QueryVarContext queryVar() {
			return getRuleContext(QueryVarContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ShellParser.RPAREN, 0); }
		public List<QueryArgContext> queryArg() {
			return getRuleContexts(QueryArgContext.class);
		}
		public QueryArgContext queryArg(int i) {
			return getRuleContext(QueryArgContext.class,i);
		}
		public PredictContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predict; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).enterPredict(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).exitPredict(this);
		}
	}

	public final PredictContext predict() throws RecognitionException {
		PredictContext _localctx = new PredictContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_predict);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			match(PREDICT);
			setState(139);
			match(LPAREN);
			setState(140);
			modelVar();
			setState(141);
			match(COMMA);
			setState(142);
			queryVar();
			setState(147);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(143);
				match(COMMA);
				setState(144);
				queryArg();
				}
				}
				setState(149);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(150);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EvaluateContext extends ParserRuleContext {
		public EvaluateVarContext evaluateVar() {
			return getRuleContext(EvaluateVarContext.class,0);
		}
		public TerminalNode EQUALS() { return getToken(ShellParser.EQUALS, 0); }
		public TerminalNode EVALUATE() { return getToken(ShellParser.EVALUATE, 0); }
		public TerminalNode LPAREN() { return getToken(ShellParser.LPAREN, 0); }
		public ModelVarContext modelVar() {
			return getRuleContext(ModelVarContext.class,0);
		}
		public List<TerminalNode> COMMA() { return getTokens(ShellParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ShellParser.COMMA, i);
		}
		public RegionVarContext regionVar() {
			return getRuleContext(RegionVarContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ShellParser.RPAREN, 0); }
		public List<FieldVarContext> fieldVar() {
			return getRuleContexts(FieldVarContext.class);
		}
		public FieldVarContext fieldVar(int i) {
			return getRuleContext(FieldVarContext.class,i);
		}
		public EvaluateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_evaluate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).enterEvaluate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).exitEvaluate(this);
		}
	}

	public final EvaluateContext evaluate() throws RecognitionException {
		EvaluateContext _localctx = new EvaluateContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_evaluate);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(152);
			evaluateVar();
			setState(153);
			match(EQUALS);
			setState(154);
			match(EVALUATE);
			setState(155);
			match(LPAREN);
			setState(156);
			modelVar();
			setState(157);
			match(COMMA);
			setState(158);
			regionVar();
			setState(161); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(159);
				match(COMMA);
				setState(160);
				fieldVar();
				}
				}
				setState(163); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==COMMA );
			setState(165);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrintContext extends ParserRuleContext {
		public TerminalNode PRINT() { return getToken(ShellParser.PRINT, 0); }
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public PrintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_print; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).enterPrint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).exitPrint(this);
		}
	}

	public final PrintContext print() throws RecognitionException {
		PrintContext _localctx = new PrintContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_print);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(167);
			match(PRINT);
			setState(168);
			var();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LsContext extends ParserRuleContext {
		public TerminalNode LS() { return getToken(ShellParser.LS, 0); }
		public LsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ls; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).enterLs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).exitLs(this);
		}
	}

	public final LsContext ls() throws RecognitionException {
		LsContext _localctx = new LsContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_ls);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(170);
			match(LS);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RmContext extends ParserRuleContext {
		public TerminalNode RM() { return getToken(ShellParser.RM, 0); }
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public RmContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).enterRm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).exitRm(this);
		}
	}

	public final RmContext rm() throws RecognitionException {
		RmContext _localctx = new RmContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_rm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
			match(RM);
			setState(173);
			var();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class KernelsContext extends ParserRuleContext {
		public KernelsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_kernels; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).enterKernels(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).exitKernels(this);
		}
	}

	public final KernelsContext kernels() throws RecognitionException {
		KernelsContext _localctx = new KernelsContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_kernels);
		try {
			enterOuterAlt(_localctx, 1);
			{
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QueryArgContext extends ParserRuleContext {
		public TerminalNode QUOTEDSTRING() { return getToken(ShellParser.QUOTEDSTRING, 0); }
		public TerminalNode DECIMAL() { return getToken(ShellParser.DECIMAL, 0); }
		public TerminalNode INTEGER() { return getToken(ShellParser.INTEGER, 0); }
		public QueryArgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_queryArg; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).enterQueryArg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).exitQueryArg(this);
		}
	}

	public final QueryArgContext queryArg() throws RecognitionException {
		QueryArgContext _localctx = new QueryArgContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_queryArg);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(177);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INTEGER) | (1L << DECIMAL) | (1L << QUOTEDSTRING))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QueryArgsContext extends ParserRuleContext {
		public TerminalNode LBRACKET() { return getToken(ShellParser.LBRACKET, 0); }
		public List<QueryArgContext> queryArg() {
			return getRuleContexts(QueryArgContext.class);
		}
		public QueryArgContext queryArg(int i) {
			return getRuleContext(QueryArgContext.class,i);
		}
		public TerminalNode RBRACKET() { return getToken(ShellParser.RBRACKET, 0); }
		public List<TerminalNode> COMMA() { return getTokens(ShellParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ShellParser.COMMA, i);
		}
		public QueryArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_queryArgs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).enterQueryArgs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).exitQueryArgs(this);
		}
	}

	public final QueryArgsContext queryArgs() throws RecognitionException {
		QueryArgsContext _localctx = new QueryArgsContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_queryArgs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(179);
			match(LBRACKET);
			setState(180);
			queryArg();
			setState(185);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(181);
				match(COMMA);
				setState(182);
				queryArg();
				}
				}
				setState(187);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(188);
			match(RBRACKET);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CpVarContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(ShellParser.NUMBER, 0); }
		public CpVarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cpVar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).enterCpVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).exitCpVar(this);
		}
	}

	public final CpVarContext cpVar() throws RecognitionException {
		CpVarContext _localctx = new CpVarContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_cpVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(190);
			match(NUMBER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CnVarContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(ShellParser.NUMBER, 0); }
		public CnVarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cnVar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).enterCnVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).exitCnVar(this);
		}
	}

	public final CnVarContext cnVar() throws RecognitionException {
		CnVarContext _localctx = new CnVarContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_cnVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(192);
			match(NUMBER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class KVarContext extends ParserRuleContext {
		public TerminalNode INTEGER() { return getToken(ShellParser.INTEGER, 0); }
		public KVarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_kVar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).enterKVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).exitKVar(this);
		}
	}

	public final KVarContext kVar() throws RecognitionException {
		KVarContext _localctx = new KVarContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_kVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(194);
			match(INTEGER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LambdaVarContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(ShellParser.NUMBER, 0); }
		public LambdaVarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambdaVar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).enterLambdaVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).exitLambdaVar(this);
		}
	}

	public final LambdaVarContext lambdaVar() throws RecognitionException {
		LambdaVarContext _localctx = new LambdaVarContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_lambdaVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(196);
			match(NUMBER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(ShellParser.IDENTIFIER, 0); }
		public VarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).enterVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).exitVar(this);
		}
	}

	public final VarContext var() throws RecognitionException {
		VarContext _localctx = new VarContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_var);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(198);
			match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EvaluateVarContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(ShellParser.IDENTIFIER, 0); }
		public EvaluateVarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_evaluateVar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).enterEvaluateVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).exitEvaluateVar(this);
		}
	}

	public final EvaluateVarContext evaluateVar() throws RecognitionException {
		EvaluateVarContext _localctx = new EvaluateVarContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_evaluateVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(200);
			match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FieldVarContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(ShellParser.IDENTIFIER, 0); }
		public FieldVarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldVar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).enterFieldVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).exitFieldVar(this);
		}
	}

	public final FieldVarContext fieldVar() throws RecognitionException {
		FieldVarContext _localctx = new FieldVarContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_fieldVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(202);
			match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ModelVarContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(ShellParser.IDENTIFIER, 0); }
		public ModelVarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_modelVar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).enterModelVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).exitModelVar(this);
		}
	}

	public final ModelVarContext modelVar() throws RecognitionException {
		ModelVarContext _localctx = new ModelVarContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_modelVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(204);
			match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QueryVarContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(ShellParser.IDENTIFIER, 0); }
		public QueryVarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_queryVar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).enterQueryVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).exitQueryVar(this);
		}
	}

	public final QueryVarContext queryVar() throws RecognitionException {
		QueryVarContext _localctx = new QueryVarContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_queryVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(206);
			match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RegionVarContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(ShellParser.IDENTIFIER, 0); }
		public RegionVarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_regionVar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).enterRegionVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).exitRegionVar(this);
		}
	}

	public final RegionVarContext regionVar() throws RecognitionException {
		RegionVarContext _localctx = new RegionVarContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_regionVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(208);
			match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QueryStringContext extends ParserRuleContext {
		public TerminalNode QUOTEDSTRING() { return getToken(ShellParser.QUOTEDSTRING, 0); }
		public QueryStringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_queryString; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).enterQueryString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).exitQueryString(this);
		}
	}

	public final QueryStringContext queryString() throws RecognitionException {
		QueryStringContext _localctx = new QueryStringContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_queryString);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(210);
			match(QUOTEDSTRING);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3#\u00d7\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2<\n\2\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\4\3\4\3\4\3\4\3\4\7\4J\n\4\f\4\16\4M\13\4\3\4\3\4\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5\\\n\5\3\5\3\5\3\5\3\5\5\5b\n\5\3\5"+
		"\3\5\3\5\3\5\5\5h\n\5\3\5\3\5\3\5\3\5\5\5n\n\5\3\5\3\5\3\5\3\5\5\5t\n"+
		"\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6\u0083\n\6\3"+
		"\6\3\6\3\6\3\6\5\6\u0089\n\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\7\7\u0094"+
		"\n\7\f\7\16\7\u0097\13\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\6"+
		"\b\u00a4\n\b\r\b\16\b\u00a5\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3\13"+
		"\3\f\3\f\3\r\3\r\3\16\3\16\3\16\3\16\7\16\u00ba\n\16\f\16\16\16\u00bd"+
		"\13\16\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24"+
		"\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\31\2\2\32\2"+
		"\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\2\3\4\2\37 \"\"\u00d1"+
		"\2;\3\2\2\2\4=\3\2\2\2\6D\3\2\2\2\bP\3\2\2\2\nw\3\2\2\2\f\u008c\3\2\2"+
		"\2\16\u009a\3\2\2\2\20\u00a9\3\2\2\2\22\u00ac\3\2\2\2\24\u00ae\3\2\2\2"+
		"\26\u00b1\3\2\2\2\30\u00b3\3\2\2\2\32\u00b5\3\2\2\2\34\u00c0\3\2\2\2\36"+
		"\u00c2\3\2\2\2 \u00c4\3\2\2\2\"\u00c6\3\2\2\2$\u00c8\3\2\2\2&\u00ca\3"+
		"\2\2\2(\u00cc\3\2\2\2*\u00ce\3\2\2\2,\u00d0\3\2\2\2.\u00d2\3\2\2\2\60"+
		"\u00d4\3\2\2\2\62<\5\4\3\2\63<\5\6\4\2\64<\5\b\5\2\65<\5\n\6\2\66<\5\f"+
		"\7\2\67<\5\20\t\28<\5\22\n\29<\5\24\13\2:<\5\16\b\2;\62\3\2\2\2;\63\3"+
		"\2\2\2;\64\3\2\2\2;\65\3\2\2\2;\66\3\2\2\2;\67\3\2\2\2;8\3\2\2\2;9\3\2"+
		"\2\2;:\3\2\2\2<\3\3\2\2\2=>\5,\27\2>?\7\35\2\2?@\7\23\2\2@A\7\27\2\2A"+
		"B\5\60\31\2BC\7\30\2\2C\5\3\2\2\2DE\7\24\2\2EF\7\27\2\2FK\5,\27\2GH\7"+
		"\34\2\2HJ\5\30\r\2IG\3\2\2\2JM\3\2\2\2KI\3\2\2\2KL\3\2\2\2LN\3\2\2\2M"+
		"K\3\2\2\2NO\7\30\2\2O\7\3\2\2\2PQ\5*\26\2QR\7\35\2\2RS\7\17\2\2ST\7\27"+
		"\2\2TU\7\23\2\2UV\7\35\2\2V[\5,\27\2WX\7\34\2\2XY\7\20\2\2YZ\7\35\2\2"+
		"Z\\\5\26\f\2[W\3\2\2\2[\\\3\2\2\2\\a\3\2\2\2]^\7\34\2\2^_\7\21\2\2_`\7"+
		"\35\2\2`b\5\34\17\2a]\3\2\2\2ab\3\2\2\2bg\3\2\2\2cd\7\34\2\2de\7\22\2"+
		"\2ef\7\35\2\2fh\5\36\20\2gc\3\2\2\2gh\3\2\2\2hm\3\2\2\2ij\7\34\2\2jk\7"+
		"\f\2\2kl\7\35\2\2ln\5 \21\2mi\3\2\2\2mn\3\2\2\2ns\3\2\2\2op\7\34\2\2p"+
		"q\7\4\2\2qr\7\35\2\2rt\5\32\16\2so\3\2\2\2st\3\2\2\2tu\3\2\2\2uv\7\30"+
		"\2\2v\t\3\2\2\2wx\5*\26\2xy\7\35\2\2yz\7\16\2\2z{\7\27\2\2{|\7\23\2\2"+
		"|}\7\35\2\2}\u0082\5,\27\2~\177\7\34\2\2\177\u0080\7\r\2\2\u0080\u0081"+
		"\7\35\2\2\u0081\u0083\5\"\22\2\u0082~\3\2\2\2\u0082\u0083\3\2\2\2\u0083"+
		"\u0088\3\2\2\2\u0084\u0085\7\34\2\2\u0085\u0086\7\4\2\2\u0086\u0087\7"+
		"\35\2\2\u0087\u0089\5\32\16\2\u0088\u0084\3\2\2\2\u0088\u0089\3\2\2\2"+
		"\u0089\u008a\3\2\2\2\u008a\u008b\7\30\2\2\u008b\13\3\2\2\2\u008c\u008d"+
		"\7\13\2\2\u008d\u008e\7\27\2\2\u008e\u008f\5*\26\2\u008f\u0090\7\34\2"+
		"\2\u0090\u0095\5,\27\2\u0091\u0092\7\34\2\2\u0092\u0094\5\30\r\2\u0093"+
		"\u0091\3\2\2\2\u0094\u0097\3\2\2\2\u0095\u0093\3\2\2\2\u0095\u0096\3\2"+
		"\2\2\u0096\u0098\3\2\2\2\u0097\u0095\3\2\2\2\u0098\u0099\7\30\2\2\u0099"+
		"\r\3\2\2\2\u009a\u009b\5&\24\2\u009b\u009c\7\35\2\2\u009c\u009d\7\3\2"+
		"\2\u009d\u009e\7\27\2\2\u009e\u009f\5*\26\2\u009f\u00a0\7\34\2\2\u00a0"+
		"\u00a3\5.\30\2\u00a1\u00a2\7\34\2\2\u00a2\u00a4\5(\25\2\u00a3\u00a1\3"+
		"\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\u00a3\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6"+
		"\u00a7\3\2\2\2\u00a7\u00a8\7\30\2\2\u00a8\17\3\2\2\2\u00a9\u00aa\7\n\2"+
		"\2\u00aa\u00ab\5$\23\2\u00ab\21\3\2\2\2\u00ac\u00ad\7\t\2\2\u00ad\23\3"+
		"\2\2\2\u00ae\u00af\7\b\2\2\u00af\u00b0\5$\23\2\u00b0\25\3\2\2\2\u00b1"+
		"\u00b2\3\2\2\2\u00b2\27\3\2\2\2\u00b3\u00b4\t\2\2\2\u00b4\31\3\2\2\2\u00b5"+
		"\u00b6\7\25\2\2\u00b6\u00bb\5\30\r\2\u00b7\u00b8\7\34\2\2\u00b8\u00ba"+
		"\5\30\r\2\u00b9\u00b7\3\2\2\2\u00ba\u00bd\3\2\2\2\u00bb\u00b9\3\2\2\2"+
		"\u00bb\u00bc\3\2\2\2\u00bc\u00be\3\2\2\2\u00bd\u00bb\3\2\2\2\u00be\u00bf"+
		"\7\26\2\2\u00bf\33\3\2\2\2\u00c0\u00c1\7!\2\2\u00c1\35\3\2\2\2\u00c2\u00c3"+
		"\7!\2\2\u00c3\37\3\2\2\2\u00c4\u00c5\7\37\2\2\u00c5!\3\2\2\2\u00c6\u00c7"+
		"\7!\2\2\u00c7#\3\2\2\2\u00c8\u00c9\7\36\2\2\u00c9%\3\2\2\2\u00ca\u00cb"+
		"\7\36\2\2\u00cb\'\3\2\2\2\u00cc\u00cd\7\36\2\2\u00cd)\3\2\2\2\u00ce\u00cf"+
		"\7\36\2\2\u00cf+\3\2\2\2\u00d0\u00d1\7\36\2\2\u00d1-\3\2\2\2\u00d2\u00d3"+
		"\7\36\2\2\u00d3/\3\2\2\2\u00d4\u00d5\7\"\2\2\u00d5\61\3\2\2\2\16;K[ag"+
		"ms\u0082\u0088\u0095\u00a5\u00bb";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}