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
		GAUSSIANKERNEL=1, LAPLACEKERNEL=2, LINEARKERNEL=3, PEARSONKERNEL=4, POLYNOMIALKERNEL=5, 
		HYPERBOLICTANGENTKERNEL=6, THINPLATEPLINEKERNEL=7, HELLINGERKERNEL=8, 
		SPARSEGAUSSIANKERNEL=9, SPARSELAPLACEKERNEL=10, SPARSELINEARKERNEL=11, 
		SPARSEPOLYNOMIALKERNEL=12, SPARSEHYPERBOLICTANGENTKERNEL=13, SPARSETHINPLATEPLINEKERNEL=14, 
		BINARYSPARSEGAUSSIANKERNEL=15, BINARYSPARSELAPLACEKERNEL=16, BINARYSPARSELINEARKERNEL=17, 
		BINARYSPARSEPOLYNOMIALKERNEL=18, BINARYSPARSEHYPERBOLICTANGENTKERNEL=19, 
		BINARYSPARSETHINPLATEPLINEKERNEL=20, GAUSSIANPROCESS=21, REGRESSIONTREE=22, 
		RANDOMFORESTREGRESSION=23, RIDGEREGRESSION=24, SVR=25, KNN=26, DTRAIN=27, 
		TRAIN=28, FFT=29, FORWARD=30, INVERSE=31, STANDARD=32, UNITARY=33, MATRIX=34, 
		VECTOR=35, QUERYARGS=36, MODEL=37, FIELDS=38, REGION=39, RM=40, LS=41, 
		PRINT=42, PREDICT=43, K=44, LAMBDA=45, SVM=46, CP=47, CN=48, QUERY=49, 
		EXECUTE=50, LBRACKET=51, RBRACKET=52, LPAREN=53, RPAREN=54, LBRACE=55, 
		RBRACE=56, DBLQUOTES=57, COMMA=58, EQUALS=59, IDENTIFIER=60, DIGIT=61, 
		NUMBER=62, QUOTEDSTRING=63, WS=64;
	public static final int
		RULE_cmd = 0, RULE_svm = 1, RULE_gaussianProcess = 2, RULE_regressionTree = 3, 
		RULE_randomForestRegression = 4, RULE_ridgeRegression = 5, RULE_svr = 6, 
		RULE_knn = 7, RULE_query = 8, RULE_execute = 9, RULE_trainModel = 10, 
		RULE_dtrainModel = 11, RULE_predict = 12, RULE_vector = 13, RULE_matrix = 14, 
		RULE_fft = 15, RULE_print = 16, RULE_ls = 17, RULE_rm = 18, RULE_kernel = 19, 
		RULE_mercerkernel = 20, RULE_gaussKernel = 21, RULE_laplaceKernel = 22, 
		RULE_linearKernel = 23, RULE_pearsonKernel = 24, RULE_polyKernel = 25, 
		RULE_hypertangentKernel = 26, RULE_thinplatesplineKernel = 27, RULE_hellingerKernel = 28, 
		RULE_sparsegaussKernel = 29, RULE_sparselaplaceKernel = 30, RULE_sparselinearKernel = 31, 
		RULE_sparsepolyKernel = 32, RULE_sparsehypertangentKernel = 33, RULE_sparsethinplatesplineKernel = 34, 
		RULE_binarysparsegaussKernel = 35, RULE_binarysparselaplaceKernel = 36, 
		RULE_binarysparselinearKernel = 37, RULE_binarysparsepolyKernel = 38, 
		RULE_binarysparsehypertangentKernel = 39, RULE_binarysparsethinplatesplineKernel = 40, 
		RULE_ntreesVar = 41, RULE_maxNodesVar = 42, RULE_nodeSizeVar = 43, RULE_tolVar = 44, 
		RULE_epsVar = 45, RULE_cVar = 46, RULE_cpVar = 47, RULE_cnVar = 48, RULE_kVar = 49, 
		RULE_sigmaVar = 50, RULE_omegaVar = 51, RULE_lambdaVar = 52, RULE_degreeVar = 53, 
		RULE_scaleVar = 54, RULE_offsetVar = 55, RULE_xFieldName = 56, RULE_yFieldName = 57, 
		RULE_sizeVar = 58, RULE_trainId = 59, RULE_fftInputId = 60, RULE_fftDir = 61, 
		RULE_fftNorm = 62, RULE_queryArg = 63, RULE_queryArgs = 64, RULE_fieldNames = 65, 
		RULE_var = 66, RULE_fieldName = 67, RULE_modelId = 68, RULE_queryId = 69, 
		RULE_regionName = 70, RULE_matrixId = 71, RULE_vectorId = 72, RULE_kernelId = 73, 
		RULE_queryString = 74, RULE_number = 75;
	public static final String[] ruleNames = {
		"cmd", "svm", "gaussianProcess", "regressionTree", "randomForestRegression", 
		"ridgeRegression", "svr", "knn", "query", "execute", "trainModel", "dtrainModel", 
		"predict", "vector", "matrix", "fft", "print", "ls", "rm", "kernel", "mercerkernel", 
		"gaussKernel", "laplaceKernel", "linearKernel", "pearsonKernel", "polyKernel", 
		"hypertangentKernel", "thinplatesplineKernel", "hellingerKernel", "sparsegaussKernel", 
		"sparselaplaceKernel", "sparselinearKernel", "sparsepolyKernel", "sparsehypertangentKernel", 
		"sparsethinplatesplineKernel", "binarysparsegaussKernel", "binarysparselaplaceKernel", 
		"binarysparselinearKernel", "binarysparsepolyKernel", "binarysparsehypertangentKernel", 
		"binarysparsethinplatesplineKernel", "ntreesVar", "maxNodesVar", "nodeSizeVar", 
		"tolVar", "epsVar", "cVar", "cpVar", "cnVar", "kVar", "sigmaVar", "omegaVar", 
		"lambdaVar", "degreeVar", "scaleVar", "offsetVar", "xFieldName", "yFieldName", 
		"sizeVar", "trainId", "fftInputId", "fftDir", "fftNorm", "queryArg", "queryArgs", 
		"fieldNames", "var", "fieldName", "modelId", "queryId", "regionName", 
		"matrixId", "vectorId", "kernelId", "queryString", "number"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'gausskernel'", "'laplacekernel'", "'linearkernel'", "'pearsonkernel'", 
		"'polykernel'", "'hypertangentkernel'", "'thinplatesplinekernel'", "'hellingerkernel'", 
		"'sparsegausskernel'", "'sparselaplacekernel'", "'sparselinearkernel'", 
		"'sparsepolykernel'", "'sparsehypertangentkernel'", "'sparsethinplatesplinekernel'", 
		"'binarysparsegausskernel'", "'binarysparselaplacekernel'", "'binarysparselinearkernel'", 
		"'binarysparsepolykernel'", "'binarysparsehypertangentkernel'", "'binarysparsethinplatesplinekernel'", 
		"'gp'", "'rtree'", "'rforestr'", "'ridger'", "'svr'", "'knn'", "'dtrain'", 
		"'train'", "'fft'", "'forward'", "'inverse'", "'standard'", "'unitary'", 
		"'matrix'", "'vect'", "'queryArgs'", "'model'", "'fields'", "'region'", 
		"'rm'", "'ls'", "'print'", "'predict'", "'k'", "'lambda'", "'svm'", "'cp'", 
		"'cn'", "'query'", "'execute'", "'['", "']'", "'('", "')'", "'{'", "'}'", 
		"'\"'", "','", "'='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "GAUSSIANKERNEL", "LAPLACEKERNEL", "LINEARKERNEL", "PEARSONKERNEL", 
		"POLYNOMIALKERNEL", "HYPERBOLICTANGENTKERNEL", "THINPLATEPLINEKERNEL", 
		"HELLINGERKERNEL", "SPARSEGAUSSIANKERNEL", "SPARSELAPLACEKERNEL", "SPARSELINEARKERNEL", 
		"SPARSEPOLYNOMIALKERNEL", "SPARSEHYPERBOLICTANGENTKERNEL", "SPARSETHINPLATEPLINEKERNEL", 
		"BINARYSPARSEGAUSSIANKERNEL", "BINARYSPARSELAPLACEKERNEL", "BINARYSPARSELINEARKERNEL", 
		"BINARYSPARSEPOLYNOMIALKERNEL", "BINARYSPARSEHYPERBOLICTANGENTKERNEL", 
		"BINARYSPARSETHINPLATEPLINEKERNEL", "GAUSSIANPROCESS", "REGRESSIONTREE", 
		"RANDOMFORESTREGRESSION", "RIDGEREGRESSION", "SVR", "KNN", "DTRAIN", "TRAIN", 
		"FFT", "FORWARD", "INVERSE", "STANDARD", "UNITARY", "MATRIX", "VECTOR", 
		"QUERYARGS", "MODEL", "FIELDS", "REGION", "RM", "LS", "PRINT", "PREDICT", 
		"K", "LAMBDA", "SVM", "CP", "CN", "QUERY", "EXECUTE", "LBRACKET", "RBRACKET", 
		"LPAREN", "RPAREN", "LBRACE", "RBRACE", "DBLQUOTES", "COMMA", "EQUALS", 
		"IDENTIFIER", "DIGIT", "NUMBER", "QUOTEDSTRING", "WS"
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
		public GaussianProcessContext gaussianProcess() {
			return getRuleContext(GaussianProcessContext.class,0);
		}
		public RegressionTreeContext regressionTree() {
			return getRuleContext(RegressionTreeContext.class,0);
		}
		public RandomForestRegressionContext randomForestRegression() {
			return getRuleContext(RandomForestRegressionContext.class,0);
		}
		public RidgeRegressionContext ridgeRegression() {
			return getRuleContext(RidgeRegressionContext.class,0);
		}
		public SvrContext svr() {
			return getRuleContext(SvrContext.class,0);
		}
		public KernelContext kernel() {
			return getRuleContext(KernelContext.class,0);
		}
		public TrainModelContext trainModel() {
			return getRuleContext(TrainModelContext.class,0);
		}
		public DtrainModelContext dtrainModel() {
			return getRuleContext(DtrainModelContext.class,0);
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
		public VectorContext vector() {
			return getRuleContext(VectorContext.class,0);
		}
		public MatrixContext matrix() {
			return getRuleContext(MatrixContext.class,0);
		}
		public FftContext fft() {
			return getRuleContext(FftContext.class,0);
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
			setState(170);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(152);
				query();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(153);
				execute();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(154);
				svm();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(155);
				gaussianProcess();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(156);
				regressionTree();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(157);
				randomForestRegression();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(158);
				ridgeRegression();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(159);
				svr();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(160);
				kernel();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(161);
				trainModel();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(162);
				dtrainModel();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(163);
				predict();
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(164);
				print();
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(165);
				ls();
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(166);
				rm();
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 16);
				{
				setState(167);
				vector();
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 17);
				{
				setState(168);
				matrix();
				}
				break;
			case 18:
				enterOuterAlt(_localctx, 18);
				{
				setState(169);
				fft();
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

	public static class SvmContext extends ParserRuleContext {
		public ModelIdContext modelId() {
			return getRuleContext(ModelIdContext.class,0);
		}
		public TerminalNode EQUALS() { return getToken(ShellParser.EQUALS, 0); }
		public TerminalNode SVM() { return getToken(ShellParser.SVM, 0); }
		public TerminalNode LPAREN() { return getToken(ShellParser.LPAREN, 0); }
		public CpVarContext cpVar() {
			return getRuleContext(CpVarContext.class,0);
		}
		public List<TerminalNode> COMMA() { return getTokens(ShellParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ShellParser.COMMA, i);
		}
		public CnVarContext cnVar() {
			return getRuleContext(CnVarContext.class,0);
		}
		public KVarContext kVar() {
			return getRuleContext(KVarContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ShellParser.RPAREN, 0); }
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
		enterRule(_localctx, 2, RULE_svm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
			modelId();
			setState(173);
			match(EQUALS);
			setState(174);
			match(SVM);
			setState(175);
			match(LPAREN);
			setState(176);
			cpVar();
			setState(177);
			match(COMMA);
			setState(178);
			cnVar();
			setState(179);
			match(COMMA);
			setState(180);
			kVar();
			setState(181);
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

	public static class GaussianProcessContext extends ParserRuleContext {
		public ModelIdContext modelId() {
			return getRuleContext(ModelIdContext.class,0);
		}
		public TerminalNode EQUALS() { return getToken(ShellParser.EQUALS, 0); }
		public TerminalNode GAUSSIANPROCESS() { return getToken(ShellParser.GAUSSIANPROCESS, 0); }
		public TerminalNode LPAREN() { return getToken(ShellParser.LPAREN, 0); }
		public KernelIdContext kernelId() {
			return getRuleContext(KernelIdContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(ShellParser.COMMA, 0); }
		public LambdaVarContext lambdaVar() {
			return getRuleContext(LambdaVarContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ShellParser.RPAREN, 0); }
		public GaussianProcessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_gaussianProcess; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).enterGaussianProcess(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).exitGaussianProcess(this);
		}
	}

	public final GaussianProcessContext gaussianProcess() throws RecognitionException {
		GaussianProcessContext _localctx = new GaussianProcessContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_gaussianProcess);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(183);
			modelId();
			setState(184);
			match(EQUALS);
			setState(185);
			match(GAUSSIANPROCESS);
			setState(186);
			match(LPAREN);
			setState(187);
			kernelId();
			setState(188);
			match(COMMA);
			setState(189);
			lambdaVar();
			setState(190);
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

	public static class RegressionTreeContext extends ParserRuleContext {
		public ModelIdContext modelId() {
			return getRuleContext(ModelIdContext.class,0);
		}
		public TerminalNode EQUALS() { return getToken(ShellParser.EQUALS, 0); }
		public TerminalNode REGRESSIONTREE() { return getToken(ShellParser.REGRESSIONTREE, 0); }
		public TerminalNode LPAREN() { return getToken(ShellParser.LPAREN, 0); }
		public MaxNodesVarContext maxNodesVar() {
			return getRuleContext(MaxNodesVarContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(ShellParser.COMMA, 0); }
		public NodeSizeVarContext nodeSizeVar() {
			return getRuleContext(NodeSizeVarContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ShellParser.RPAREN, 0); }
		public RegressionTreeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_regressionTree; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).enterRegressionTree(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).exitRegressionTree(this);
		}
	}

	public final RegressionTreeContext regressionTree() throws RecognitionException {
		RegressionTreeContext _localctx = new RegressionTreeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_regressionTree);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(192);
			modelId();
			setState(193);
			match(EQUALS);
			setState(194);
			match(REGRESSIONTREE);
			setState(195);
			match(LPAREN);
			setState(196);
			maxNodesVar();
			setState(197);
			match(COMMA);
			setState(198);
			nodeSizeVar();
			setState(199);
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

	public static class RandomForestRegressionContext extends ParserRuleContext {
		public ModelIdContext modelId() {
			return getRuleContext(ModelIdContext.class,0);
		}
		public TerminalNode EQUALS() { return getToken(ShellParser.EQUALS, 0); }
		public TerminalNode RANDOMFORESTREGRESSION() { return getToken(ShellParser.RANDOMFORESTREGRESSION, 0); }
		public TerminalNode LPAREN() { return getToken(ShellParser.LPAREN, 0); }
		public NtreesVarContext ntreesVar() {
			return getRuleContext(NtreesVarContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(ShellParser.COMMA, 0); }
		public NodeSizeVarContext nodeSizeVar() {
			return getRuleContext(NodeSizeVarContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ShellParser.RPAREN, 0); }
		public RandomForestRegressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_randomForestRegression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).enterRandomForestRegression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).exitRandomForestRegression(this);
		}
	}

	public final RandomForestRegressionContext randomForestRegression() throws RecognitionException {
		RandomForestRegressionContext _localctx = new RandomForestRegressionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_randomForestRegression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(201);
			modelId();
			setState(202);
			match(EQUALS);
			setState(203);
			match(RANDOMFORESTREGRESSION);
			setState(204);
			match(LPAREN);
			setState(205);
			ntreesVar();
			setState(206);
			match(COMMA);
			setState(207);
			nodeSizeVar();
			setState(208);
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

	public static class RidgeRegressionContext extends ParserRuleContext {
		public ModelIdContext modelId() {
			return getRuleContext(ModelIdContext.class,0);
		}
		public TerminalNode EQUALS() { return getToken(ShellParser.EQUALS, 0); }
		public TerminalNode RIDGEREGRESSION() { return getToken(ShellParser.RIDGEREGRESSION, 0); }
		public TerminalNode LPAREN() { return getToken(ShellParser.LPAREN, 0); }
		public LambdaVarContext lambdaVar() {
			return getRuleContext(LambdaVarContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ShellParser.RPAREN, 0); }
		public RidgeRegressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ridgeRegression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).enterRidgeRegression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).exitRidgeRegression(this);
		}
	}

	public final RidgeRegressionContext ridgeRegression() throws RecognitionException {
		RidgeRegressionContext _localctx = new RidgeRegressionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_ridgeRegression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(210);
			modelId();
			setState(211);
			match(EQUALS);
			setState(212);
			match(RIDGEREGRESSION);
			setState(213);
			match(LPAREN);
			setState(214);
			lambdaVar();
			setState(215);
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

	public static class SvrContext extends ParserRuleContext {
		public ModelIdContext modelId() {
			return getRuleContext(ModelIdContext.class,0);
		}
		public TerminalNode EQUALS() { return getToken(ShellParser.EQUALS, 0); }
		public TerminalNode SVR() { return getToken(ShellParser.SVR, 0); }
		public TerminalNode LPAREN() { return getToken(ShellParser.LPAREN, 0); }
		public KernelIdContext kernelId() {
			return getRuleContext(KernelIdContext.class,0);
		}
		public List<TerminalNode> COMMA() { return getTokens(ShellParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ShellParser.COMMA, i);
		}
		public EpsVarContext epsVar() {
			return getRuleContext(EpsVarContext.class,0);
		}
		public CVarContext cVar() {
			return getRuleContext(CVarContext.class,0);
		}
		public TolVarContext tolVar() {
			return getRuleContext(TolVarContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ShellParser.RPAREN, 0); }
		public SvrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_svr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).enterSvr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).exitSvr(this);
		}
	}

	public final SvrContext svr() throws RecognitionException {
		SvrContext _localctx = new SvrContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_svr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(217);
			modelId();
			setState(218);
			match(EQUALS);
			setState(219);
			match(SVR);
			setState(220);
			match(LPAREN);
			setState(221);
			kernelId();
			setState(222);
			match(COMMA);
			setState(223);
			epsVar();
			setState(224);
			match(COMMA);
			setState(225);
			cVar();
			setState(226);
			match(COMMA);
			setState(227);
			tolVar();
			setState(228);
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

	public static class KnnContext extends ParserRuleContext {
		public ModelIdContext modelId() {
			return getRuleContext(ModelIdContext.class,0);
		}
		public TerminalNode EQUALS() { return getToken(ShellParser.EQUALS, 0); }
		public TerminalNode KNN() { return getToken(ShellParser.KNN, 0); }
		public TerminalNode LPAREN() { return getToken(ShellParser.LPAREN, 0); }
		public KernelIdContext kernelId() {
			return getRuleContext(KernelIdContext.class,0);
		}
		public List<TerminalNode> COMMA() { return getTokens(ShellParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ShellParser.COMMA, i);
		}
		public EpsVarContext epsVar() {
			return getRuleContext(EpsVarContext.class,0);
		}
		public CVarContext cVar() {
			return getRuleContext(CVarContext.class,0);
		}
		public TolVarContext tolVar() {
			return getRuleContext(TolVarContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ShellParser.RPAREN, 0); }
		public KnnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_knn; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).enterKnn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).exitKnn(this);
		}
	}

	public final KnnContext knn() throws RecognitionException {
		KnnContext _localctx = new KnnContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_knn);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(230);
			modelId();
			setState(231);
			match(EQUALS);
			setState(232);
			match(KNN);
			setState(233);
			match(LPAREN);
			setState(234);
			kernelId();
			setState(235);
			match(COMMA);
			setState(236);
			epsVar();
			setState(237);
			match(COMMA);
			setState(238);
			cVar();
			setState(239);
			match(COMMA);
			setState(240);
			tolVar();
			setState(241);
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

	public static class QueryContext extends ParserRuleContext {
		public QueryIdContext queryId() {
			return getRuleContext(QueryIdContext.class,0);
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
		enterRule(_localctx, 16, RULE_query);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(243);
			queryId();
			setState(244);
			match(EQUALS);
			setState(245);
			match(QUERY);
			setState(246);
			match(LPAREN);
			setState(247);
			queryString();
			setState(248);
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
		public QueryIdContext queryId() {
			return getRuleContext(QueryIdContext.class,0);
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
		enterRule(_localctx, 18, RULE_execute);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(250);
			match(EXECUTE);
			setState(251);
			match(LPAREN);
			setState(252);
			queryId();
			setState(257);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(253);
				match(COMMA);
				setState(254);
				queryArg();
				}
				}
				setState(259);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(260);
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

	public static class TrainModelContext extends ParserRuleContext {
		public TrainIdContext trainId() {
			return getRuleContext(TrainIdContext.class,0);
		}
		public TerminalNode EQUALS() { return getToken(ShellParser.EQUALS, 0); }
		public TerminalNode TRAIN() { return getToken(ShellParser.TRAIN, 0); }
		public TerminalNode LPAREN() { return getToken(ShellParser.LPAREN, 0); }
		public ModelIdContext modelId() {
			return getRuleContext(ModelIdContext.class,0);
		}
		public List<TerminalNode> COMMA() { return getTokens(ShellParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ShellParser.COMMA, i);
		}
		public MatrixIdContext matrixId() {
			return getRuleContext(MatrixIdContext.class,0);
		}
		public VectorIdContext vectorId() {
			return getRuleContext(VectorIdContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ShellParser.RPAREN, 0); }
		public TrainModelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_trainModel; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).enterTrainModel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).exitTrainModel(this);
		}
	}

	public final TrainModelContext trainModel() throws RecognitionException {
		TrainModelContext _localctx = new TrainModelContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_trainModel);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(262);
			trainId();
			setState(263);
			match(EQUALS);
			setState(264);
			match(TRAIN);
			setState(265);
			match(LPAREN);
			setState(266);
			modelId();
			setState(267);
			match(COMMA);
			setState(268);
			matrixId();
			setState(269);
			match(COMMA);
			setState(270);
			vectorId();
			setState(271);
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

	public static class DtrainModelContext extends ParserRuleContext {
		public TrainIdContext trainId() {
			return getRuleContext(TrainIdContext.class,0);
		}
		public TerminalNode EQUALS() { return getToken(ShellParser.EQUALS, 0); }
		public TerminalNode DTRAIN() { return getToken(ShellParser.DTRAIN, 0); }
		public TerminalNode LPAREN() { return getToken(ShellParser.LPAREN, 0); }
		public ModelIdContext modelId() {
			return getRuleContext(ModelIdContext.class,0);
		}
		public List<TerminalNode> COMMA() { return getTokens(ShellParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ShellParser.COMMA, i);
		}
		public RegionNameContext regionName() {
			return getRuleContext(RegionNameContext.class,0);
		}
		public SizeVarContext sizeVar() {
			return getRuleContext(SizeVarContext.class,0);
		}
		public YFieldNameContext yFieldName() {
			return getRuleContext(YFieldNameContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ShellParser.RPAREN, 0); }
		public List<XFieldNameContext> xFieldName() {
			return getRuleContexts(XFieldNameContext.class);
		}
		public XFieldNameContext xFieldName(int i) {
			return getRuleContext(XFieldNameContext.class,i);
		}
		public DtrainModelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dtrainModel; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).enterDtrainModel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).exitDtrainModel(this);
		}
	}

	public final DtrainModelContext dtrainModel() throws RecognitionException {
		DtrainModelContext _localctx = new DtrainModelContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_dtrainModel);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(273);
			trainId();
			setState(274);
			match(EQUALS);
			setState(275);
			match(DTRAIN);
			setState(276);
			match(LPAREN);
			setState(277);
			modelId();
			setState(278);
			match(COMMA);
			setState(279);
			regionName();
			setState(280);
			match(COMMA);
			setState(281);
			sizeVar();
			setState(282);
			match(COMMA);
			setState(283);
			yFieldName();
			setState(286); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(284);
				match(COMMA);
				setState(285);
				xFieldName();
				}
				}
				setState(288); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==COMMA );
			setState(290);
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
		public ModelIdContext modelId() {
			return getRuleContext(ModelIdContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(ShellParser.COMMA, 0); }
		public TerminalNode RPAREN() { return getToken(ShellParser.RPAREN, 0); }
		public VectorIdContext vectorId() {
			return getRuleContext(VectorIdContext.class,0);
		}
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
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
		enterRule(_localctx, 24, RULE_predict);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(292);
			match(PREDICT);
			setState(293);
			match(LPAREN);
			setState(294);
			modelId();
			setState(295);
			match(COMMA);
			setState(298);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				{
				setState(296);
				vectorId();
				}
				break;
			case NUMBER:
				{
				setState(297);
				number();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(300);
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

	public static class VectorContext extends ParserRuleContext {
		public VectorIdContext vectorId() {
			return getRuleContext(VectorIdContext.class,0);
		}
		public TerminalNode EQUALS() { return getToken(ShellParser.EQUALS, 0); }
		public TerminalNode VECTOR() { return getToken(ShellParser.VECTOR, 0); }
		public TerminalNode LPAREN() { return getToken(ShellParser.LPAREN, 0); }
		public QueryIdContext queryId() {
			return getRuleContext(QueryIdContext.class,0);
		}
		public List<TerminalNode> COMMA() { return getTokens(ShellParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ShellParser.COMMA, i);
		}
		public FieldNameContext fieldName() {
			return getRuleContext(FieldNameContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ShellParser.RPAREN, 0); }
		public QueryArgsContext queryArgs() {
			return getRuleContext(QueryArgsContext.class,0);
		}
		public VectorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vector; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).enterVector(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).exitVector(this);
		}
	}

	public final VectorContext vector() throws RecognitionException {
		VectorContext _localctx = new VectorContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_vector);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(302);
			vectorId();
			setState(303);
			match(EQUALS);
			setState(304);
			match(VECTOR);
			setState(305);
			match(LPAREN);
			setState(306);
			queryId();
			setState(307);
			match(COMMA);
			setState(308);
			fieldName();
			setState(311);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(309);
				match(COMMA);
				setState(310);
				queryArgs();
				}
			}

			setState(313);
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

	public static class MatrixContext extends ParserRuleContext {
		public MatrixIdContext matrixId() {
			return getRuleContext(MatrixIdContext.class,0);
		}
		public TerminalNode EQUALS() { return getToken(ShellParser.EQUALS, 0); }
		public TerminalNode MATRIX() { return getToken(ShellParser.MATRIX, 0); }
		public TerminalNode LPAREN() { return getToken(ShellParser.LPAREN, 0); }
		public QueryIdContext queryId() {
			return getRuleContext(QueryIdContext.class,0);
		}
		public List<TerminalNode> COMMA() { return getTokens(ShellParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ShellParser.COMMA, i);
		}
		public FieldNamesContext fieldNames() {
			return getRuleContext(FieldNamesContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ShellParser.RPAREN, 0); }
		public QueryArgsContext queryArgs() {
			return getRuleContext(QueryArgsContext.class,0);
		}
		public MatrixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_matrix; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).enterMatrix(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).exitMatrix(this);
		}
	}

	public final MatrixContext matrix() throws RecognitionException {
		MatrixContext _localctx = new MatrixContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_matrix);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(315);
			matrixId();
			setState(316);
			match(EQUALS);
			setState(317);
			match(MATRIX);
			setState(318);
			match(LPAREN);
			setState(319);
			queryId();
			setState(320);
			match(COMMA);
			setState(321);
			fieldNames();
			setState(324);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(322);
				match(COMMA);
				setState(323);
				queryArgs();
				}
			}

			setState(326);
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

	public static class FftContext extends ParserRuleContext {
		public MatrixIdContext matrixId() {
			return getRuleContext(MatrixIdContext.class,0);
		}
		public TerminalNode EQUALS() { return getToken(ShellParser.EQUALS, 0); }
		public TerminalNode FFT() { return getToken(ShellParser.FFT, 0); }
		public TerminalNode LPAREN() { return getToken(ShellParser.LPAREN, 0); }
		public FftInputIdContext fftInputId() {
			return getRuleContext(FftInputIdContext.class,0);
		}
		public List<TerminalNode> COMMA() { return getTokens(ShellParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ShellParser.COMMA, i);
		}
		public FftDirContext fftDir() {
			return getRuleContext(FftDirContext.class,0);
		}
		public FftNormContext fftNorm() {
			return getRuleContext(FftNormContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ShellParser.RPAREN, 0); }
		public FftContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fft; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).enterFft(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).exitFft(this);
		}
	}

	public final FftContext fft() throws RecognitionException {
		FftContext _localctx = new FftContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_fft);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(328);
			matrixId();
			setState(329);
			match(EQUALS);
			setState(330);
			match(FFT);
			setState(331);
			match(LPAREN);
			setState(332);
			fftInputId();
			setState(333);
			match(COMMA);
			setState(334);
			fftDir();
			setState(335);
			match(COMMA);
			setState(336);
			fftNorm();
			setState(337);
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
		enterRule(_localctx, 32, RULE_print);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(339);
			match(PRINT);
			setState(340);
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
		enterRule(_localctx, 34, RULE_ls);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(342);
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
		enterRule(_localctx, 36, RULE_rm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(344);
			match(RM);
			setState(345);
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

	public static class KernelContext extends ParserRuleContext {
		public KernelIdContext kernelId() {
			return getRuleContext(KernelIdContext.class,0);
		}
		public TerminalNode EQUALS() { return getToken(ShellParser.EQUALS, 0); }
		public MercerkernelContext mercerkernel() {
			return getRuleContext(MercerkernelContext.class,0);
		}
		public KernelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_kernel; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).enterKernel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).exitKernel(this);
		}
	}

	public final KernelContext kernel() throws RecognitionException {
		KernelContext _localctx = new KernelContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_kernel);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(347);
			kernelId();
			setState(348);
			match(EQUALS);
			setState(349);
			mercerkernel();
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

	public static class MercerkernelContext extends ParserRuleContext {
		public GaussKernelContext gaussKernel() {
			return getRuleContext(GaussKernelContext.class,0);
		}
		public LaplaceKernelContext laplaceKernel() {
			return getRuleContext(LaplaceKernelContext.class,0);
		}
		public LinearKernelContext linearKernel() {
			return getRuleContext(LinearKernelContext.class,0);
		}
		public PearsonKernelContext pearsonKernel() {
			return getRuleContext(PearsonKernelContext.class,0);
		}
		public PolyKernelContext polyKernel() {
			return getRuleContext(PolyKernelContext.class,0);
		}
		public HypertangentKernelContext hypertangentKernel() {
			return getRuleContext(HypertangentKernelContext.class,0);
		}
		public ThinplatesplineKernelContext thinplatesplineKernel() {
			return getRuleContext(ThinplatesplineKernelContext.class,0);
		}
		public HellingerKernelContext hellingerKernel() {
			return getRuleContext(HellingerKernelContext.class,0);
		}
		public SparsegaussKernelContext sparsegaussKernel() {
			return getRuleContext(SparsegaussKernelContext.class,0);
		}
		public SparselaplaceKernelContext sparselaplaceKernel() {
			return getRuleContext(SparselaplaceKernelContext.class,0);
		}
		public SparselinearKernelContext sparselinearKernel() {
			return getRuleContext(SparselinearKernelContext.class,0);
		}
		public SparsepolyKernelContext sparsepolyKernel() {
			return getRuleContext(SparsepolyKernelContext.class,0);
		}
		public SparsehypertangentKernelContext sparsehypertangentKernel() {
			return getRuleContext(SparsehypertangentKernelContext.class,0);
		}
		public SparsethinplatesplineKernelContext sparsethinplatesplineKernel() {
			return getRuleContext(SparsethinplatesplineKernelContext.class,0);
		}
		public BinarysparsegaussKernelContext binarysparsegaussKernel() {
			return getRuleContext(BinarysparsegaussKernelContext.class,0);
		}
		public BinarysparselaplaceKernelContext binarysparselaplaceKernel() {
			return getRuleContext(BinarysparselaplaceKernelContext.class,0);
		}
		public BinarysparselinearKernelContext binarysparselinearKernel() {
			return getRuleContext(BinarysparselinearKernelContext.class,0);
		}
		public BinarysparsepolyKernelContext binarysparsepolyKernel() {
			return getRuleContext(BinarysparsepolyKernelContext.class,0);
		}
		public BinarysparsehypertangentKernelContext binarysparsehypertangentKernel() {
			return getRuleContext(BinarysparsehypertangentKernelContext.class,0);
		}
		public BinarysparsethinplatesplineKernelContext binarysparsethinplatesplineKernel() {
			return getRuleContext(BinarysparsethinplatesplineKernelContext.class,0);
		}
		public MercerkernelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mercerkernel; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).enterMercerkernel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).exitMercerkernel(this);
		}
	}

	public final MercerkernelContext mercerkernel() throws RecognitionException {
		MercerkernelContext _localctx = new MercerkernelContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_mercerkernel);
		try {
			setState(371);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(351);
				gaussKernel();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(352);
				laplaceKernel();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(353);
				linearKernel();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(354);
				pearsonKernel();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(355);
				polyKernel();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(356);
				hypertangentKernel();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(357);
				thinplatesplineKernel();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(358);
				hellingerKernel();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(359);
				sparsegaussKernel();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(360);
				sparselaplaceKernel();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(361);
				sparselinearKernel();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(362);
				sparsepolyKernel();
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(363);
				sparsehypertangentKernel();
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(364);
				sparsethinplatesplineKernel();
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(365);
				binarysparsegaussKernel();
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 16);
				{
				setState(366);
				binarysparselaplaceKernel();
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 17);
				{
				setState(367);
				binarysparselinearKernel();
				}
				break;
			case 18:
				enterOuterAlt(_localctx, 18);
				{
				setState(368);
				binarysparsepolyKernel();
				}
				break;
			case 19:
				enterOuterAlt(_localctx, 19);
				{
				setState(369);
				binarysparsehypertangentKernel();
				}
				break;
			case 20:
				enterOuterAlt(_localctx, 20);
				{
				setState(370);
				binarysparsethinplatesplineKernel();
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

	public static class GaussKernelContext extends ParserRuleContext {
		public KernelIdContext kernelId() {
			return getRuleContext(KernelIdContext.class,0);
		}
		public TerminalNode EQUALS() { return getToken(ShellParser.EQUALS, 0); }
		public TerminalNode GAUSSIANKERNEL() { return getToken(ShellParser.GAUSSIANKERNEL, 0); }
		public TerminalNode LPAREN() { return getToken(ShellParser.LPAREN, 0); }
		public SigmaVarContext sigmaVar() {
			return getRuleContext(SigmaVarContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ShellParser.RPAREN, 0); }
		public GaussKernelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_gaussKernel; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).enterGaussKernel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).exitGaussKernel(this);
		}
	}

	public final GaussKernelContext gaussKernel() throws RecognitionException {
		GaussKernelContext _localctx = new GaussKernelContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_gaussKernel);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(373);
			kernelId();
			setState(374);
			match(EQUALS);
			setState(375);
			match(GAUSSIANKERNEL);
			setState(376);
			match(LPAREN);
			setState(377);
			sigmaVar();
			setState(378);
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

	public static class LaplaceKernelContext extends ParserRuleContext {
		public KernelIdContext kernelId() {
			return getRuleContext(KernelIdContext.class,0);
		}
		public TerminalNode EQUALS() { return getToken(ShellParser.EQUALS, 0); }
		public TerminalNode LAPLACEKERNEL() { return getToken(ShellParser.LAPLACEKERNEL, 0); }
		public TerminalNode LPAREN() { return getToken(ShellParser.LPAREN, 0); }
		public SigmaVarContext sigmaVar() {
			return getRuleContext(SigmaVarContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ShellParser.RPAREN, 0); }
		public LaplaceKernelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_laplaceKernel; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).enterLaplaceKernel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).exitLaplaceKernel(this);
		}
	}

	public final LaplaceKernelContext laplaceKernel() throws RecognitionException {
		LaplaceKernelContext _localctx = new LaplaceKernelContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_laplaceKernel);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(380);
			kernelId();
			setState(381);
			match(EQUALS);
			setState(382);
			match(LAPLACEKERNEL);
			setState(383);
			match(LPAREN);
			setState(384);
			sigmaVar();
			setState(385);
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

	public static class LinearKernelContext extends ParserRuleContext {
		public KernelIdContext kernelId() {
			return getRuleContext(KernelIdContext.class,0);
		}
		public TerminalNode EQUALS() { return getToken(ShellParser.EQUALS, 0); }
		public TerminalNode LINEARKERNEL() { return getToken(ShellParser.LINEARKERNEL, 0); }
		public LinearKernelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_linearKernel; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).enterLinearKernel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).exitLinearKernel(this);
		}
	}

	public final LinearKernelContext linearKernel() throws RecognitionException {
		LinearKernelContext _localctx = new LinearKernelContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_linearKernel);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(387);
			kernelId();
			setState(388);
			match(EQUALS);
			setState(389);
			match(LINEARKERNEL);
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

	public static class PearsonKernelContext extends ParserRuleContext {
		public KernelIdContext kernelId() {
			return getRuleContext(KernelIdContext.class,0);
		}
		public TerminalNode EQUALS() { return getToken(ShellParser.EQUALS, 0); }
		public TerminalNode PEARSONKERNEL() { return getToken(ShellParser.PEARSONKERNEL, 0); }
		public TerminalNode LPAREN() { return getToken(ShellParser.LPAREN, 0); }
		public SigmaVarContext sigmaVar() {
			return getRuleContext(SigmaVarContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(ShellParser.COMMA, 0); }
		public OmegaVarContext omegaVar() {
			return getRuleContext(OmegaVarContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ShellParser.RPAREN, 0); }
		public PearsonKernelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pearsonKernel; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).enterPearsonKernel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).exitPearsonKernel(this);
		}
	}

	public final PearsonKernelContext pearsonKernel() throws RecognitionException {
		PearsonKernelContext _localctx = new PearsonKernelContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_pearsonKernel);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(391);
			kernelId();
			setState(392);
			match(EQUALS);
			setState(393);
			match(PEARSONKERNEL);
			setState(394);
			match(LPAREN);
			setState(395);
			sigmaVar();
			setState(396);
			match(COMMA);
			setState(397);
			omegaVar();
			setState(398);
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

	public static class PolyKernelContext extends ParserRuleContext {
		public KernelIdContext kernelId() {
			return getRuleContext(KernelIdContext.class,0);
		}
		public TerminalNode EQUALS() { return getToken(ShellParser.EQUALS, 0); }
		public TerminalNode POLYNOMIALKERNEL() { return getToken(ShellParser.POLYNOMIALKERNEL, 0); }
		public TerminalNode LPAREN() { return getToken(ShellParser.LPAREN, 0); }
		public DegreeVarContext degreeVar() {
			return getRuleContext(DegreeVarContext.class,0);
		}
		public List<TerminalNode> COMMA() { return getTokens(ShellParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ShellParser.COMMA, i);
		}
		public ScaleVarContext scaleVar() {
			return getRuleContext(ScaleVarContext.class,0);
		}
		public OffsetVarContext offsetVar() {
			return getRuleContext(OffsetVarContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ShellParser.RPAREN, 0); }
		public PolyKernelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_polyKernel; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).enterPolyKernel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).exitPolyKernel(this);
		}
	}

	public final PolyKernelContext polyKernel() throws RecognitionException {
		PolyKernelContext _localctx = new PolyKernelContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_polyKernel);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(400);
			kernelId();
			setState(401);
			match(EQUALS);
			setState(402);
			match(POLYNOMIALKERNEL);
			setState(403);
			match(LPAREN);
			setState(404);
			degreeVar();
			setState(405);
			match(COMMA);
			setState(406);
			scaleVar();
			setState(407);
			match(COMMA);
			setState(408);
			offsetVar();
			setState(409);
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

	public static class HypertangentKernelContext extends ParserRuleContext {
		public KernelIdContext kernelId() {
			return getRuleContext(KernelIdContext.class,0);
		}
		public TerminalNode EQUALS() { return getToken(ShellParser.EQUALS, 0); }
		public TerminalNode HYPERBOLICTANGENTKERNEL() { return getToken(ShellParser.HYPERBOLICTANGENTKERNEL, 0); }
		public TerminalNode LPAREN() { return getToken(ShellParser.LPAREN, 0); }
		public ScaleVarContext scaleVar() {
			return getRuleContext(ScaleVarContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(ShellParser.COMMA, 0); }
		public OffsetVarContext offsetVar() {
			return getRuleContext(OffsetVarContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ShellParser.RPAREN, 0); }
		public HypertangentKernelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_hypertangentKernel; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).enterHypertangentKernel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).exitHypertangentKernel(this);
		}
	}

	public final HypertangentKernelContext hypertangentKernel() throws RecognitionException {
		HypertangentKernelContext _localctx = new HypertangentKernelContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_hypertangentKernel);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(411);
			kernelId();
			setState(412);
			match(EQUALS);
			setState(413);
			match(HYPERBOLICTANGENTKERNEL);
			setState(414);
			match(LPAREN);
			setState(415);
			scaleVar();
			setState(416);
			match(COMMA);
			setState(417);
			offsetVar();
			setState(418);
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

	public static class ThinplatesplineKernelContext extends ParserRuleContext {
		public KernelIdContext kernelId() {
			return getRuleContext(KernelIdContext.class,0);
		}
		public TerminalNode EQUALS() { return getToken(ShellParser.EQUALS, 0); }
		public TerminalNode THINPLATEPLINEKERNEL() { return getToken(ShellParser.THINPLATEPLINEKERNEL, 0); }
		public TerminalNode LPAREN() { return getToken(ShellParser.LPAREN, 0); }
		public SigmaVarContext sigmaVar() {
			return getRuleContext(SigmaVarContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ShellParser.RPAREN, 0); }
		public ThinplatesplineKernelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_thinplatesplineKernel; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).enterThinplatesplineKernel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).exitThinplatesplineKernel(this);
		}
	}

	public final ThinplatesplineKernelContext thinplatesplineKernel() throws RecognitionException {
		ThinplatesplineKernelContext _localctx = new ThinplatesplineKernelContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_thinplatesplineKernel);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(420);
			kernelId();
			setState(421);
			match(EQUALS);
			setState(422);
			match(THINPLATEPLINEKERNEL);
			setState(423);
			match(LPAREN);
			setState(424);
			sigmaVar();
			setState(425);
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

	public static class HellingerKernelContext extends ParserRuleContext {
		public KernelIdContext kernelId() {
			return getRuleContext(KernelIdContext.class,0);
		}
		public TerminalNode EQUALS() { return getToken(ShellParser.EQUALS, 0); }
		public TerminalNode HELLINGERKERNEL() { return getToken(ShellParser.HELLINGERKERNEL, 0); }
		public HellingerKernelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_hellingerKernel; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).enterHellingerKernel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).exitHellingerKernel(this);
		}
	}

	public final HellingerKernelContext hellingerKernel() throws RecognitionException {
		HellingerKernelContext _localctx = new HellingerKernelContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_hellingerKernel);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(427);
			kernelId();
			setState(428);
			match(EQUALS);
			setState(429);
			match(HELLINGERKERNEL);
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

	public static class SparsegaussKernelContext extends ParserRuleContext {
		public KernelIdContext kernelId() {
			return getRuleContext(KernelIdContext.class,0);
		}
		public TerminalNode EQUALS() { return getToken(ShellParser.EQUALS, 0); }
		public TerminalNode SPARSEGAUSSIANKERNEL() { return getToken(ShellParser.SPARSEGAUSSIANKERNEL, 0); }
		public TerminalNode LPAREN() { return getToken(ShellParser.LPAREN, 0); }
		public SigmaVarContext sigmaVar() {
			return getRuleContext(SigmaVarContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ShellParser.RPAREN, 0); }
		public SparsegaussKernelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sparsegaussKernel; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).enterSparsegaussKernel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).exitSparsegaussKernel(this);
		}
	}

	public final SparsegaussKernelContext sparsegaussKernel() throws RecognitionException {
		SparsegaussKernelContext _localctx = new SparsegaussKernelContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_sparsegaussKernel);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(431);
			kernelId();
			setState(432);
			match(EQUALS);
			setState(433);
			match(SPARSEGAUSSIANKERNEL);
			setState(434);
			match(LPAREN);
			setState(435);
			sigmaVar();
			setState(436);
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

	public static class SparselaplaceKernelContext extends ParserRuleContext {
		public KernelIdContext kernelId() {
			return getRuleContext(KernelIdContext.class,0);
		}
		public TerminalNode EQUALS() { return getToken(ShellParser.EQUALS, 0); }
		public TerminalNode SPARSELAPLACEKERNEL() { return getToken(ShellParser.SPARSELAPLACEKERNEL, 0); }
		public TerminalNode LPAREN() { return getToken(ShellParser.LPAREN, 0); }
		public SigmaVarContext sigmaVar() {
			return getRuleContext(SigmaVarContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ShellParser.RPAREN, 0); }
		public SparselaplaceKernelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sparselaplaceKernel; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).enterSparselaplaceKernel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).exitSparselaplaceKernel(this);
		}
	}

	public final SparselaplaceKernelContext sparselaplaceKernel() throws RecognitionException {
		SparselaplaceKernelContext _localctx = new SparselaplaceKernelContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_sparselaplaceKernel);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(438);
			kernelId();
			setState(439);
			match(EQUALS);
			setState(440);
			match(SPARSELAPLACEKERNEL);
			setState(441);
			match(LPAREN);
			setState(442);
			sigmaVar();
			setState(443);
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

	public static class SparselinearKernelContext extends ParserRuleContext {
		public KernelIdContext kernelId() {
			return getRuleContext(KernelIdContext.class,0);
		}
		public TerminalNode EQUALS() { return getToken(ShellParser.EQUALS, 0); }
		public TerminalNode SPARSELINEARKERNEL() { return getToken(ShellParser.SPARSELINEARKERNEL, 0); }
		public SparselinearKernelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sparselinearKernel; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).enterSparselinearKernel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).exitSparselinearKernel(this);
		}
	}

	public final SparselinearKernelContext sparselinearKernel() throws RecognitionException {
		SparselinearKernelContext _localctx = new SparselinearKernelContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_sparselinearKernel);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(445);
			kernelId();
			setState(446);
			match(EQUALS);
			setState(447);
			match(SPARSELINEARKERNEL);
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

	public static class SparsepolyKernelContext extends ParserRuleContext {
		public KernelIdContext kernelId() {
			return getRuleContext(KernelIdContext.class,0);
		}
		public TerminalNode EQUALS() { return getToken(ShellParser.EQUALS, 0); }
		public TerminalNode SPARSEPOLYNOMIALKERNEL() { return getToken(ShellParser.SPARSEPOLYNOMIALKERNEL, 0); }
		public TerminalNode LPAREN() { return getToken(ShellParser.LPAREN, 0); }
		public DegreeVarContext degreeVar() {
			return getRuleContext(DegreeVarContext.class,0);
		}
		public List<TerminalNode> COMMA() { return getTokens(ShellParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ShellParser.COMMA, i);
		}
		public ScaleVarContext scaleVar() {
			return getRuleContext(ScaleVarContext.class,0);
		}
		public OffsetVarContext offsetVar() {
			return getRuleContext(OffsetVarContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ShellParser.RPAREN, 0); }
		public SparsepolyKernelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sparsepolyKernel; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).enterSparsepolyKernel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).exitSparsepolyKernel(this);
		}
	}

	public final SparsepolyKernelContext sparsepolyKernel() throws RecognitionException {
		SparsepolyKernelContext _localctx = new SparsepolyKernelContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_sparsepolyKernel);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(449);
			kernelId();
			setState(450);
			match(EQUALS);
			setState(451);
			match(SPARSEPOLYNOMIALKERNEL);
			setState(452);
			match(LPAREN);
			setState(453);
			degreeVar();
			setState(454);
			match(COMMA);
			setState(455);
			scaleVar();
			setState(456);
			match(COMMA);
			setState(457);
			offsetVar();
			setState(458);
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

	public static class SparsehypertangentKernelContext extends ParserRuleContext {
		public KernelIdContext kernelId() {
			return getRuleContext(KernelIdContext.class,0);
		}
		public TerminalNode EQUALS() { return getToken(ShellParser.EQUALS, 0); }
		public TerminalNode SPARSEHYPERBOLICTANGENTKERNEL() { return getToken(ShellParser.SPARSEHYPERBOLICTANGENTKERNEL, 0); }
		public TerminalNode LPAREN() { return getToken(ShellParser.LPAREN, 0); }
		public ScaleVarContext scaleVar() {
			return getRuleContext(ScaleVarContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(ShellParser.COMMA, 0); }
		public OffsetVarContext offsetVar() {
			return getRuleContext(OffsetVarContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ShellParser.RPAREN, 0); }
		public SparsehypertangentKernelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sparsehypertangentKernel; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).enterSparsehypertangentKernel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).exitSparsehypertangentKernel(this);
		}
	}

	public final SparsehypertangentKernelContext sparsehypertangentKernel() throws RecognitionException {
		SparsehypertangentKernelContext _localctx = new SparsehypertangentKernelContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_sparsehypertangentKernel);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(460);
			kernelId();
			setState(461);
			match(EQUALS);
			setState(462);
			match(SPARSEHYPERBOLICTANGENTKERNEL);
			setState(463);
			match(LPAREN);
			setState(464);
			scaleVar();
			setState(465);
			match(COMMA);
			setState(466);
			offsetVar();
			setState(467);
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

	public static class SparsethinplatesplineKernelContext extends ParserRuleContext {
		public KernelIdContext kernelId() {
			return getRuleContext(KernelIdContext.class,0);
		}
		public TerminalNode EQUALS() { return getToken(ShellParser.EQUALS, 0); }
		public TerminalNode SPARSETHINPLATEPLINEKERNEL() { return getToken(ShellParser.SPARSETHINPLATEPLINEKERNEL, 0); }
		public TerminalNode LPAREN() { return getToken(ShellParser.LPAREN, 0); }
		public SigmaVarContext sigmaVar() {
			return getRuleContext(SigmaVarContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ShellParser.RPAREN, 0); }
		public SparsethinplatesplineKernelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sparsethinplatesplineKernel; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).enterSparsethinplatesplineKernel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).exitSparsethinplatesplineKernel(this);
		}
	}

	public final SparsethinplatesplineKernelContext sparsethinplatesplineKernel() throws RecognitionException {
		SparsethinplatesplineKernelContext _localctx = new SparsethinplatesplineKernelContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_sparsethinplatesplineKernel);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(469);
			kernelId();
			setState(470);
			match(EQUALS);
			setState(471);
			match(SPARSETHINPLATEPLINEKERNEL);
			setState(472);
			match(LPAREN);
			setState(473);
			sigmaVar();
			setState(474);
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

	public static class BinarysparsegaussKernelContext extends ParserRuleContext {
		public KernelIdContext kernelId() {
			return getRuleContext(KernelIdContext.class,0);
		}
		public TerminalNode EQUALS() { return getToken(ShellParser.EQUALS, 0); }
		public TerminalNode BINARYSPARSEGAUSSIANKERNEL() { return getToken(ShellParser.BINARYSPARSEGAUSSIANKERNEL, 0); }
		public TerminalNode LPAREN() { return getToken(ShellParser.LPAREN, 0); }
		public SigmaVarContext sigmaVar() {
			return getRuleContext(SigmaVarContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ShellParser.RPAREN, 0); }
		public BinarysparsegaussKernelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binarysparsegaussKernel; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).enterBinarysparsegaussKernel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).exitBinarysparsegaussKernel(this);
		}
	}

	public final BinarysparsegaussKernelContext binarysparsegaussKernel() throws RecognitionException {
		BinarysparsegaussKernelContext _localctx = new BinarysparsegaussKernelContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_binarysparsegaussKernel);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(476);
			kernelId();
			setState(477);
			match(EQUALS);
			setState(478);
			match(BINARYSPARSEGAUSSIANKERNEL);
			setState(479);
			match(LPAREN);
			setState(480);
			sigmaVar();
			setState(481);
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

	public static class BinarysparselaplaceKernelContext extends ParserRuleContext {
		public KernelIdContext kernelId() {
			return getRuleContext(KernelIdContext.class,0);
		}
		public TerminalNode EQUALS() { return getToken(ShellParser.EQUALS, 0); }
		public TerminalNode BINARYSPARSELAPLACEKERNEL() { return getToken(ShellParser.BINARYSPARSELAPLACEKERNEL, 0); }
		public TerminalNode LPAREN() { return getToken(ShellParser.LPAREN, 0); }
		public SigmaVarContext sigmaVar() {
			return getRuleContext(SigmaVarContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ShellParser.RPAREN, 0); }
		public BinarysparselaplaceKernelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binarysparselaplaceKernel; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).enterBinarysparselaplaceKernel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).exitBinarysparselaplaceKernel(this);
		}
	}

	public final BinarysparselaplaceKernelContext binarysparselaplaceKernel() throws RecognitionException {
		BinarysparselaplaceKernelContext _localctx = new BinarysparselaplaceKernelContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_binarysparselaplaceKernel);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(483);
			kernelId();
			setState(484);
			match(EQUALS);
			setState(485);
			match(BINARYSPARSELAPLACEKERNEL);
			setState(486);
			match(LPAREN);
			setState(487);
			sigmaVar();
			setState(488);
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

	public static class BinarysparselinearKernelContext extends ParserRuleContext {
		public KernelIdContext kernelId() {
			return getRuleContext(KernelIdContext.class,0);
		}
		public TerminalNode EQUALS() { return getToken(ShellParser.EQUALS, 0); }
		public TerminalNode BINARYSPARSELINEARKERNEL() { return getToken(ShellParser.BINARYSPARSELINEARKERNEL, 0); }
		public BinarysparselinearKernelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binarysparselinearKernel; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).enterBinarysparselinearKernel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).exitBinarysparselinearKernel(this);
		}
	}

	public final BinarysparselinearKernelContext binarysparselinearKernel() throws RecognitionException {
		BinarysparselinearKernelContext _localctx = new BinarysparselinearKernelContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_binarysparselinearKernel);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(490);
			kernelId();
			setState(491);
			match(EQUALS);
			setState(492);
			match(BINARYSPARSELINEARKERNEL);
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

	public static class BinarysparsepolyKernelContext extends ParserRuleContext {
		public KernelIdContext kernelId() {
			return getRuleContext(KernelIdContext.class,0);
		}
		public TerminalNode EQUALS() { return getToken(ShellParser.EQUALS, 0); }
		public TerminalNode BINARYSPARSEPOLYNOMIALKERNEL() { return getToken(ShellParser.BINARYSPARSEPOLYNOMIALKERNEL, 0); }
		public TerminalNode LPAREN() { return getToken(ShellParser.LPAREN, 0); }
		public DegreeVarContext degreeVar() {
			return getRuleContext(DegreeVarContext.class,0);
		}
		public List<TerminalNode> COMMA() { return getTokens(ShellParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ShellParser.COMMA, i);
		}
		public ScaleVarContext scaleVar() {
			return getRuleContext(ScaleVarContext.class,0);
		}
		public OffsetVarContext offsetVar() {
			return getRuleContext(OffsetVarContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ShellParser.RPAREN, 0); }
		public BinarysparsepolyKernelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binarysparsepolyKernel; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).enterBinarysparsepolyKernel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).exitBinarysparsepolyKernel(this);
		}
	}

	public final BinarysparsepolyKernelContext binarysparsepolyKernel() throws RecognitionException {
		BinarysparsepolyKernelContext _localctx = new BinarysparsepolyKernelContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_binarysparsepolyKernel);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(494);
			kernelId();
			setState(495);
			match(EQUALS);
			setState(496);
			match(BINARYSPARSEPOLYNOMIALKERNEL);
			setState(497);
			match(LPAREN);
			setState(498);
			degreeVar();
			setState(499);
			match(COMMA);
			setState(500);
			scaleVar();
			setState(501);
			match(COMMA);
			setState(502);
			offsetVar();
			setState(503);
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

	public static class BinarysparsehypertangentKernelContext extends ParserRuleContext {
		public KernelIdContext kernelId() {
			return getRuleContext(KernelIdContext.class,0);
		}
		public TerminalNode EQUALS() { return getToken(ShellParser.EQUALS, 0); }
		public TerminalNode BINARYSPARSEHYPERBOLICTANGENTKERNEL() { return getToken(ShellParser.BINARYSPARSEHYPERBOLICTANGENTKERNEL, 0); }
		public TerminalNode LPAREN() { return getToken(ShellParser.LPAREN, 0); }
		public ScaleVarContext scaleVar() {
			return getRuleContext(ScaleVarContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(ShellParser.COMMA, 0); }
		public OffsetVarContext offsetVar() {
			return getRuleContext(OffsetVarContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ShellParser.RPAREN, 0); }
		public BinarysparsehypertangentKernelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binarysparsehypertangentKernel; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).enterBinarysparsehypertangentKernel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).exitBinarysparsehypertangentKernel(this);
		}
	}

	public final BinarysparsehypertangentKernelContext binarysparsehypertangentKernel() throws RecognitionException {
		BinarysparsehypertangentKernelContext _localctx = new BinarysparsehypertangentKernelContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_binarysparsehypertangentKernel);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(505);
			kernelId();
			setState(506);
			match(EQUALS);
			setState(507);
			match(BINARYSPARSEHYPERBOLICTANGENTKERNEL);
			setState(508);
			match(LPAREN);
			setState(509);
			scaleVar();
			setState(510);
			match(COMMA);
			setState(511);
			offsetVar();
			setState(512);
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

	public static class BinarysparsethinplatesplineKernelContext extends ParserRuleContext {
		public KernelIdContext kernelId() {
			return getRuleContext(KernelIdContext.class,0);
		}
		public TerminalNode EQUALS() { return getToken(ShellParser.EQUALS, 0); }
		public TerminalNode BINARYSPARSETHINPLATEPLINEKERNEL() { return getToken(ShellParser.BINARYSPARSETHINPLATEPLINEKERNEL, 0); }
		public TerminalNode LPAREN() { return getToken(ShellParser.LPAREN, 0); }
		public SigmaVarContext sigmaVar() {
			return getRuleContext(SigmaVarContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ShellParser.RPAREN, 0); }
		public BinarysparsethinplatesplineKernelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binarysparsethinplatesplineKernel; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).enterBinarysparsethinplatesplineKernel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).exitBinarysparsethinplatesplineKernel(this);
		}
	}

	public final BinarysparsethinplatesplineKernelContext binarysparsethinplatesplineKernel() throws RecognitionException {
		BinarysparsethinplatesplineKernelContext _localctx = new BinarysparsethinplatesplineKernelContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_binarysparsethinplatesplineKernel);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(514);
			kernelId();
			setState(515);
			match(EQUALS);
			setState(516);
			match(BINARYSPARSETHINPLATEPLINEKERNEL);
			setState(517);
			match(LPAREN);
			setState(518);
			sigmaVar();
			setState(519);
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

	public static class NtreesVarContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(ShellParser.NUMBER, 0); }
		public NtreesVarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ntreesVar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).enterNtreesVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).exitNtreesVar(this);
		}
	}

	public final NtreesVarContext ntreesVar() throws RecognitionException {
		NtreesVarContext _localctx = new NtreesVarContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_ntreesVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(521);
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

	public static class MaxNodesVarContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(ShellParser.NUMBER, 0); }
		public MaxNodesVarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_maxNodesVar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).enterMaxNodesVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).exitMaxNodesVar(this);
		}
	}

	public final MaxNodesVarContext maxNodesVar() throws RecognitionException {
		MaxNodesVarContext _localctx = new MaxNodesVarContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_maxNodesVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(523);
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

	public static class NodeSizeVarContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(ShellParser.NUMBER, 0); }
		public NodeSizeVarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nodeSizeVar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).enterNodeSizeVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).exitNodeSizeVar(this);
		}
	}

	public final NodeSizeVarContext nodeSizeVar() throws RecognitionException {
		NodeSizeVarContext _localctx = new NodeSizeVarContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_nodeSizeVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(525);
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

	public static class TolVarContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(ShellParser.NUMBER, 0); }
		public TolVarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tolVar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).enterTolVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).exitTolVar(this);
		}
	}

	public final TolVarContext tolVar() throws RecognitionException {
		TolVarContext _localctx = new TolVarContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_tolVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(527);
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

	public static class EpsVarContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(ShellParser.NUMBER, 0); }
		public EpsVarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_epsVar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).enterEpsVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).exitEpsVar(this);
		}
	}

	public final EpsVarContext epsVar() throws RecognitionException {
		EpsVarContext _localctx = new EpsVarContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_epsVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(529);
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

	public static class CVarContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(ShellParser.NUMBER, 0); }
		public CVarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cVar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).enterCVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).exitCVar(this);
		}
	}

	public final CVarContext cVar() throws RecognitionException {
		CVarContext _localctx = new CVarContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_cVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(531);
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
		enterRule(_localctx, 94, RULE_cpVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(533);
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
		enterRule(_localctx, 96, RULE_cnVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(535);
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
		public TerminalNode NUMBER() { return getToken(ShellParser.NUMBER, 0); }
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
		enterRule(_localctx, 98, RULE_kVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(537);
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

	public static class SigmaVarContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(ShellParser.NUMBER, 0); }
		public SigmaVarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sigmaVar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).enterSigmaVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).exitSigmaVar(this);
		}
	}

	public final SigmaVarContext sigmaVar() throws RecognitionException {
		SigmaVarContext _localctx = new SigmaVarContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_sigmaVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(539);
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

	public static class OmegaVarContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(ShellParser.NUMBER, 0); }
		public OmegaVarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_omegaVar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).enterOmegaVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).exitOmegaVar(this);
		}
	}

	public final OmegaVarContext omegaVar() throws RecognitionException {
		OmegaVarContext _localctx = new OmegaVarContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_omegaVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(541);
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
		enterRule(_localctx, 104, RULE_lambdaVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(543);
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

	public static class DegreeVarContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(ShellParser.NUMBER, 0); }
		public DegreeVarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_degreeVar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).enterDegreeVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).exitDegreeVar(this);
		}
	}

	public final DegreeVarContext degreeVar() throws RecognitionException {
		DegreeVarContext _localctx = new DegreeVarContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_degreeVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(545);
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

	public static class ScaleVarContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(ShellParser.NUMBER, 0); }
		public ScaleVarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_scaleVar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).enterScaleVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).exitScaleVar(this);
		}
	}

	public final ScaleVarContext scaleVar() throws RecognitionException {
		ScaleVarContext _localctx = new ScaleVarContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_scaleVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(547);
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

	public static class OffsetVarContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(ShellParser.NUMBER, 0); }
		public OffsetVarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_offsetVar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).enterOffsetVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).exitOffsetVar(this);
		}
	}

	public final OffsetVarContext offsetVar() throws RecognitionException {
		OffsetVarContext _localctx = new OffsetVarContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_offsetVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(549);
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

	public static class XFieldNameContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(ShellParser.IDENTIFIER, 0); }
		public XFieldNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_xFieldName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).enterXFieldName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).exitXFieldName(this);
		}
	}

	public final XFieldNameContext xFieldName() throws RecognitionException {
		XFieldNameContext _localctx = new XFieldNameContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_xFieldName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(551);
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

	public static class YFieldNameContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(ShellParser.IDENTIFIER, 0); }
		public YFieldNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_yFieldName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).enterYFieldName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).exitYFieldName(this);
		}
	}

	public final YFieldNameContext yFieldName() throws RecognitionException {
		YFieldNameContext _localctx = new YFieldNameContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_yFieldName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(553);
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

	public static class SizeVarContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(ShellParser.NUMBER, 0); }
		public SizeVarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sizeVar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).enterSizeVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).exitSizeVar(this);
		}
	}

	public final SizeVarContext sizeVar() throws RecognitionException {
		SizeVarContext _localctx = new SizeVarContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_sizeVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(555);
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

	public static class TrainIdContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(ShellParser.IDENTIFIER, 0); }
		public TrainIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_trainId; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).enterTrainId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).exitTrainId(this);
		}
	}

	public final TrainIdContext trainId() throws RecognitionException {
		TrainIdContext _localctx = new TrainIdContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_trainId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(557);
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

	public static class FftInputIdContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(ShellParser.IDENTIFIER, 0); }
		public FftInputIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fftInputId; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).enterFftInputId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).exitFftInputId(this);
		}
	}

	public final FftInputIdContext fftInputId() throws RecognitionException {
		FftInputIdContext _localctx = new FftInputIdContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_fftInputId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(559);
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

	public static class FftDirContext extends ParserRuleContext {
		public TerminalNode FORWARD() { return getToken(ShellParser.FORWARD, 0); }
		public TerminalNode INVERSE() { return getToken(ShellParser.INVERSE, 0); }
		public FftDirContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fftDir; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).enterFftDir(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).exitFftDir(this);
		}
	}

	public final FftDirContext fftDir() throws RecognitionException {
		FftDirContext _localctx = new FftDirContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_fftDir);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(561);
			_la = _input.LA(1);
			if ( !(_la==FORWARD || _la==INVERSE) ) {
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

	public static class FftNormContext extends ParserRuleContext {
		public TerminalNode STANDARD() { return getToken(ShellParser.STANDARD, 0); }
		public TerminalNode UNITARY() { return getToken(ShellParser.UNITARY, 0); }
		public FftNormContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fftNorm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).enterFftNorm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).exitFftNorm(this);
		}
	}

	public final FftNormContext fftNorm() throws RecognitionException {
		FftNormContext _localctx = new FftNormContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_fftNorm);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(563);
			_la = _input.LA(1);
			if ( !(_la==STANDARD || _la==UNITARY) ) {
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

	public static class QueryArgContext extends ParserRuleContext {
		public TerminalNode QUOTEDSTRING() { return getToken(ShellParser.QUOTEDSTRING, 0); }
		public TerminalNode NUMBER() { return getToken(ShellParser.NUMBER, 0); }
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
		enterRule(_localctx, 126, RULE_queryArg);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(565);
			_la = _input.LA(1);
			if ( !(_la==NUMBER || _la==QUOTEDSTRING) ) {
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
		enterRule(_localctx, 128, RULE_queryArgs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(567);
			match(LBRACKET);
			setState(568);
			queryArg();
			setState(573);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(569);
				match(COMMA);
				setState(570);
				queryArg();
				}
				}
				setState(575);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(576);
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

	public static class FieldNamesContext extends ParserRuleContext {
		public TerminalNode LBRACKET() { return getToken(ShellParser.LBRACKET, 0); }
		public List<FieldNameContext> fieldName() {
			return getRuleContexts(FieldNameContext.class);
		}
		public FieldNameContext fieldName(int i) {
			return getRuleContext(FieldNameContext.class,i);
		}
		public TerminalNode RBRACKET() { return getToken(ShellParser.RBRACKET, 0); }
		public List<TerminalNode> COMMA() { return getTokens(ShellParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ShellParser.COMMA, i);
		}
		public FieldNamesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldNames; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).enterFieldNames(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).exitFieldNames(this);
		}
	}

	public final FieldNamesContext fieldNames() throws RecognitionException {
		FieldNamesContext _localctx = new FieldNamesContext(_ctx, getState());
		enterRule(_localctx, 130, RULE_fieldNames);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(578);
			match(LBRACKET);
			setState(579);
			fieldName();
			setState(584);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(580);
				match(COMMA);
				setState(581);
				fieldName();
				}
				}
				setState(586);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(587);
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
		enterRule(_localctx, 132, RULE_var);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(589);
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

	public static class FieldNameContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(ShellParser.IDENTIFIER, 0); }
		public FieldNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).enterFieldName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).exitFieldName(this);
		}
	}

	public final FieldNameContext fieldName() throws RecognitionException {
		FieldNameContext _localctx = new FieldNameContext(_ctx, getState());
		enterRule(_localctx, 134, RULE_fieldName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(591);
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

	public static class ModelIdContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(ShellParser.IDENTIFIER, 0); }
		public ModelIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_modelId; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).enterModelId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).exitModelId(this);
		}
	}

	public final ModelIdContext modelId() throws RecognitionException {
		ModelIdContext _localctx = new ModelIdContext(_ctx, getState());
		enterRule(_localctx, 136, RULE_modelId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(593);
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

	public static class QueryIdContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(ShellParser.IDENTIFIER, 0); }
		public QueryIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_queryId; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).enterQueryId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).exitQueryId(this);
		}
	}

	public final QueryIdContext queryId() throws RecognitionException {
		QueryIdContext _localctx = new QueryIdContext(_ctx, getState());
		enterRule(_localctx, 138, RULE_queryId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(595);
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

	public static class RegionNameContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(ShellParser.IDENTIFIER, 0); }
		public RegionNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_regionName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).enterRegionName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).exitRegionName(this);
		}
	}

	public final RegionNameContext regionName() throws RecognitionException {
		RegionNameContext _localctx = new RegionNameContext(_ctx, getState());
		enterRule(_localctx, 140, RULE_regionName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(597);
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

	public static class MatrixIdContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(ShellParser.IDENTIFIER, 0); }
		public MatrixIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_matrixId; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).enterMatrixId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).exitMatrixId(this);
		}
	}

	public final MatrixIdContext matrixId() throws RecognitionException {
		MatrixIdContext _localctx = new MatrixIdContext(_ctx, getState());
		enterRule(_localctx, 142, RULE_matrixId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(599);
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

	public static class VectorIdContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(ShellParser.IDENTIFIER, 0); }
		public VectorIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vectorId; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).enterVectorId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).exitVectorId(this);
		}
	}

	public final VectorIdContext vectorId() throws RecognitionException {
		VectorIdContext _localctx = new VectorIdContext(_ctx, getState());
		enterRule(_localctx, 144, RULE_vectorId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(601);
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

	public static class KernelIdContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(ShellParser.IDENTIFIER, 0); }
		public KernelIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_kernelId; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).enterKernelId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).exitKernelId(this);
		}
	}

	public final KernelIdContext kernelId() throws RecognitionException {
		KernelIdContext _localctx = new KernelIdContext(_ctx, getState());
		enterRule(_localctx, 146, RULE_kernelId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(603);
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
		enterRule(_localctx, 148, RULE_queryString);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(605);
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

	public static class NumberContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(ShellParser.NUMBER, 0); }
		public NumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).enterNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).exitNumber(this);
		}
	}

	public final NumberContext number() throws RecognitionException {
		NumberContext _localctx = new NumberContext(_ctx, getState());
		enterRule(_localctx, 150, RULE_number);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(607);
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

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3B\u0264\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2\u00ad\n\2\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\13\3\13\3\13\3\13\3\13\7\13\u0102\n\13\f\13\16\13\u0105\13\13"+
		"\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\6\r\u0121\n\r\r\r\16\r\u0122\3\r"+
		"\3\r\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u012d\n\16\3\16\3\16\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u013a\n\17\3\17\3\17\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u0147\n\20\3\20\3\20\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\23\3\23"+
		"\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\5\26"+
		"\u0176\n\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32"+
		"\3\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\34\3\34"+
		"\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35"+
		"\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3"+
		" \3 \3 \3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3#\3#"+
		"\3#\3#\3#\3#\3#\3#\3#\3$\3$\3$\3$\3$\3$\3$\3%\3%\3%\3%\3%\3%\3%\3&\3&"+
		"\3&\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3)\3"+
		")\3)\3)\3)\3)\3)\3)\3)\3*\3*\3*\3*\3*\3*\3*\3+\3+\3,\3,\3-\3-\3.\3.\3"+
		"/\3/\3\60\3\60\3\61\3\61\3\62\3\62\3\63\3\63\3\64\3\64\3\65\3\65\3\66"+
		"\3\66\3\67\3\67\38\38\39\39\3:\3:\3;\3;\3<\3<\3=\3=\3>\3>\3?\3?\3@\3@"+
		"\3A\3A\3B\3B\3B\3B\7B\u023e\nB\fB\16B\u0241\13B\3B\3B\3C\3C\3C\3C\7C\u0249"+
		"\nC\fC\16C\u024c\13C\3C\3C\3D\3D\3E\3E\3F\3F\3G\3G\3H\3H\3I\3I\3J\3J\3"+
		"K\3K\3L\3L\3M\3M\3M\2\2N\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&("+
		"*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082\u0084"+
		"\u0086\u0088\u008a\u008c\u008e\u0090\u0092\u0094\u0096\u0098\2\5\3\2 "+
		"!\3\2\"#\3\2@A\u0242\2\u00ac\3\2\2\2\4\u00ae\3\2\2\2\6\u00b9\3\2\2\2\b"+
		"\u00c2\3\2\2\2\n\u00cb\3\2\2\2\f\u00d4\3\2\2\2\16\u00db\3\2\2\2\20\u00e8"+
		"\3\2\2\2\22\u00f5\3\2\2\2\24\u00fc\3\2\2\2\26\u0108\3\2\2\2\30\u0113\3"+
		"\2\2\2\32\u0126\3\2\2\2\34\u0130\3\2\2\2\36\u013d\3\2\2\2 \u014a\3\2\2"+
		"\2\"\u0155\3\2\2\2$\u0158\3\2\2\2&\u015a\3\2\2\2(\u015d\3\2\2\2*\u0175"+
		"\3\2\2\2,\u0177\3\2\2\2.\u017e\3\2\2\2\60\u0185\3\2\2\2\62\u0189\3\2\2"+
		"\2\64\u0192\3\2\2\2\66\u019d\3\2\2\28\u01a6\3\2\2\2:\u01ad\3\2\2\2<\u01b1"+
		"\3\2\2\2>\u01b8\3\2\2\2@\u01bf\3\2\2\2B\u01c3\3\2\2\2D\u01ce\3\2\2\2F"+
		"\u01d7\3\2\2\2H\u01de\3\2\2\2J\u01e5\3\2\2\2L\u01ec\3\2\2\2N\u01f0\3\2"+
		"\2\2P\u01fb\3\2\2\2R\u0204\3\2\2\2T\u020b\3\2\2\2V\u020d\3\2\2\2X\u020f"+
		"\3\2\2\2Z\u0211\3\2\2\2\\\u0213\3\2\2\2^\u0215\3\2\2\2`\u0217\3\2\2\2"+
		"b\u0219\3\2\2\2d\u021b\3\2\2\2f\u021d\3\2\2\2h\u021f\3\2\2\2j\u0221\3"+
		"\2\2\2l\u0223\3\2\2\2n\u0225\3\2\2\2p\u0227\3\2\2\2r\u0229\3\2\2\2t\u022b"+
		"\3\2\2\2v\u022d\3\2\2\2x\u022f\3\2\2\2z\u0231\3\2\2\2|\u0233\3\2\2\2~"+
		"\u0235\3\2\2\2\u0080\u0237\3\2\2\2\u0082\u0239\3\2\2\2\u0084\u0244\3\2"+
		"\2\2\u0086\u024f\3\2\2\2\u0088\u0251\3\2\2\2\u008a\u0253\3\2\2\2\u008c"+
		"\u0255\3\2\2\2\u008e\u0257\3\2\2\2\u0090\u0259\3\2\2\2\u0092\u025b\3\2"+
		"\2\2\u0094\u025d\3\2\2\2\u0096\u025f\3\2\2\2\u0098\u0261\3\2\2\2\u009a"+
		"\u00ad\5\22\n\2\u009b\u00ad\5\24\13\2\u009c\u00ad\5\4\3\2\u009d\u00ad"+
		"\5\6\4\2\u009e\u00ad\5\b\5\2\u009f\u00ad\5\n\6\2\u00a0\u00ad\5\f\7\2\u00a1"+
		"\u00ad\5\16\b\2\u00a2\u00ad\5(\25\2\u00a3\u00ad\5\26\f\2\u00a4\u00ad\5"+
		"\30\r\2\u00a5\u00ad\5\32\16\2\u00a6\u00ad\5\"\22\2\u00a7\u00ad\5$\23\2"+
		"\u00a8\u00ad\5&\24\2\u00a9\u00ad\5\34\17\2\u00aa\u00ad\5\36\20\2\u00ab"+
		"\u00ad\5 \21\2\u00ac\u009a\3\2\2\2\u00ac\u009b\3\2\2\2\u00ac\u009c\3\2"+
		"\2\2\u00ac\u009d\3\2\2\2\u00ac\u009e\3\2\2\2\u00ac\u009f\3\2\2\2\u00ac"+
		"\u00a0\3\2\2\2\u00ac\u00a1\3\2\2\2\u00ac\u00a2\3\2\2\2\u00ac\u00a3\3\2"+
		"\2\2\u00ac\u00a4\3\2\2\2\u00ac\u00a5\3\2\2\2\u00ac\u00a6\3\2\2\2\u00ac"+
		"\u00a7\3\2\2\2\u00ac\u00a8\3\2\2\2\u00ac\u00a9\3\2\2\2\u00ac\u00aa\3\2"+
		"\2\2\u00ac\u00ab\3\2\2\2\u00ad\3\3\2\2\2\u00ae\u00af\5\u008aF\2\u00af"+
		"\u00b0\7=\2\2\u00b0\u00b1\7\60\2\2\u00b1\u00b2\7\67\2\2\u00b2\u00b3\5"+
		"`\61\2\u00b3\u00b4\7<\2\2\u00b4\u00b5\5b\62\2\u00b5\u00b6\7<\2\2\u00b6"+
		"\u00b7\5d\63\2\u00b7\u00b8\78\2\2\u00b8\5\3\2\2\2\u00b9\u00ba\5\u008a"+
		"F\2\u00ba\u00bb\7=\2\2\u00bb\u00bc\7\27\2\2\u00bc\u00bd\7\67\2\2\u00bd"+
		"\u00be\5\u0094K\2\u00be\u00bf\7<\2\2\u00bf\u00c0\5j\66\2\u00c0\u00c1\7"+
		"8\2\2\u00c1\7\3\2\2\2\u00c2\u00c3\5\u008aF\2\u00c3\u00c4\7=\2\2\u00c4"+
		"\u00c5\7\30\2\2\u00c5\u00c6\7\67\2\2\u00c6\u00c7\5V,\2\u00c7\u00c8\7<"+
		"\2\2\u00c8\u00c9\5X-\2\u00c9\u00ca\78\2\2\u00ca\t\3\2\2\2\u00cb\u00cc"+
		"\5\u008aF\2\u00cc\u00cd\7=\2\2\u00cd\u00ce\7\31\2\2\u00ce\u00cf\7\67\2"+
		"\2\u00cf\u00d0\5T+\2\u00d0\u00d1\7<\2\2\u00d1\u00d2\5X-\2\u00d2\u00d3"+
		"\78\2\2\u00d3\13\3\2\2\2\u00d4\u00d5\5\u008aF\2\u00d5\u00d6\7=\2\2\u00d6"+
		"\u00d7\7\32\2\2\u00d7\u00d8\7\67\2\2\u00d8\u00d9\5j\66\2\u00d9\u00da\7"+
		"8\2\2\u00da\r\3\2\2\2\u00db\u00dc\5\u008aF\2\u00dc\u00dd\7=\2\2\u00dd"+
		"\u00de\7\33\2\2\u00de\u00df\7\67\2\2\u00df\u00e0\5\u0094K\2\u00e0\u00e1"+
		"\7<\2\2\u00e1\u00e2\5\\/\2\u00e2\u00e3\7<\2\2\u00e3\u00e4\5^\60\2\u00e4"+
		"\u00e5\7<\2\2\u00e5\u00e6\5Z.\2\u00e6\u00e7\78\2\2\u00e7\17\3\2\2\2\u00e8"+
		"\u00e9\5\u008aF\2\u00e9\u00ea\7=\2\2\u00ea\u00eb\7\34\2\2\u00eb\u00ec"+
		"\7\67\2\2\u00ec\u00ed\5\u0094K\2\u00ed\u00ee\7<\2\2\u00ee\u00ef\5\\/\2"+
		"\u00ef\u00f0\7<\2\2\u00f0\u00f1\5^\60\2\u00f1\u00f2\7<\2\2\u00f2\u00f3"+
		"\5Z.\2\u00f3\u00f4\78\2\2\u00f4\21\3\2\2\2\u00f5\u00f6\5\u008cG\2\u00f6"+
		"\u00f7\7=\2\2\u00f7\u00f8\7\63\2\2\u00f8\u00f9\7\67\2\2\u00f9\u00fa\5"+
		"\u0096L\2\u00fa\u00fb\78\2\2\u00fb\23\3\2\2\2\u00fc\u00fd\7\64\2\2\u00fd"+
		"\u00fe\7\67\2\2\u00fe\u0103\5\u008cG\2\u00ff\u0100\7<\2\2\u0100\u0102"+
		"\5\u0080A\2\u0101\u00ff\3\2\2\2\u0102\u0105\3\2\2\2\u0103\u0101\3\2\2"+
		"\2\u0103\u0104\3\2\2\2\u0104\u0106\3\2\2\2\u0105\u0103\3\2\2\2\u0106\u0107"+
		"\78\2\2\u0107\25\3\2\2\2\u0108\u0109\5x=\2\u0109\u010a\7=\2\2\u010a\u010b"+
		"\7\36\2\2\u010b\u010c\7\67\2\2\u010c\u010d\5\u008aF\2\u010d\u010e\7<\2"+
		"\2\u010e\u010f\5\u0090I\2\u010f\u0110\7<\2\2\u0110\u0111\5\u0092J\2\u0111"+
		"\u0112\78\2\2\u0112\27\3\2\2\2\u0113\u0114\5x=\2\u0114\u0115\7=\2\2\u0115"+
		"\u0116\7\35\2\2\u0116\u0117\7\67\2\2\u0117\u0118\5\u008aF\2\u0118\u0119"+
		"\7<\2\2\u0119\u011a\5\u008eH\2\u011a\u011b\7<\2\2\u011b\u011c\5v<\2\u011c"+
		"\u011d\7<\2\2\u011d\u0120\5t;\2\u011e\u011f\7<\2\2\u011f\u0121\5r:\2\u0120"+
		"\u011e\3\2\2\2\u0121\u0122\3\2\2\2\u0122\u0120\3\2\2\2\u0122\u0123\3\2"+
		"\2\2\u0123\u0124\3\2\2\2\u0124\u0125\78\2\2\u0125\31\3\2\2\2\u0126\u0127"+
		"\7-\2\2\u0127\u0128\7\67\2\2\u0128\u0129\5\u008aF\2\u0129\u012c\7<\2\2"+
		"\u012a\u012d\5\u0092J\2\u012b\u012d\5\u0098M\2\u012c\u012a\3\2\2\2\u012c"+
		"\u012b\3\2\2\2\u012d\u012e\3\2\2\2\u012e\u012f\78\2\2\u012f\33\3\2\2\2"+
		"\u0130\u0131\5\u0092J\2\u0131\u0132\7=\2\2\u0132\u0133\7%\2\2\u0133\u0134"+
		"\7\67\2\2\u0134\u0135\5\u008cG\2\u0135\u0136\7<\2\2\u0136\u0139\5\u0088"+
		"E\2\u0137\u0138\7<\2\2\u0138\u013a\5\u0082B\2\u0139\u0137\3\2\2\2\u0139"+
		"\u013a\3\2\2\2\u013a\u013b\3\2\2\2\u013b\u013c\78\2\2\u013c\35\3\2\2\2"+
		"\u013d\u013e\5\u0090I\2\u013e\u013f\7=\2\2\u013f\u0140\7$\2\2\u0140\u0141"+
		"\7\67\2\2\u0141\u0142\5\u008cG\2\u0142\u0143\7<\2\2\u0143\u0146\5\u0084"+
		"C\2\u0144\u0145\7<\2\2\u0145\u0147\5\u0082B\2\u0146\u0144\3\2\2\2\u0146"+
		"\u0147\3\2\2\2\u0147\u0148\3\2\2\2\u0148\u0149\78\2\2\u0149\37\3\2\2\2"+
		"\u014a\u014b\5\u0090I\2\u014b\u014c\7=\2\2\u014c\u014d\7\37\2\2\u014d"+
		"\u014e\7\67\2\2\u014e\u014f\5z>\2\u014f\u0150\7<\2\2\u0150\u0151\5|?\2"+
		"\u0151\u0152\7<\2\2\u0152\u0153\5~@\2\u0153\u0154\78\2\2\u0154!\3\2\2"+
		"\2\u0155\u0156\7,\2\2\u0156\u0157\5\u0086D\2\u0157#\3\2\2\2\u0158\u0159"+
		"\7+\2\2\u0159%\3\2\2\2\u015a\u015b\7*\2\2\u015b\u015c\5\u0086D\2\u015c"+
		"\'\3\2\2\2\u015d\u015e\5\u0094K\2\u015e\u015f\7=\2\2\u015f\u0160\5*\26"+
		"\2\u0160)\3\2\2\2\u0161\u0176\5,\27\2\u0162\u0176\5.\30\2\u0163\u0176"+
		"\5\60\31\2\u0164\u0176\5\62\32\2\u0165\u0176\5\64\33\2\u0166\u0176\5\66"+
		"\34\2\u0167\u0176\58\35\2\u0168\u0176\5:\36\2\u0169\u0176\5<\37\2\u016a"+
		"\u0176\5> \2\u016b\u0176\5@!\2\u016c\u0176\5B\"\2\u016d\u0176\5D#\2\u016e"+
		"\u0176\5F$\2\u016f\u0176\5H%\2\u0170\u0176\5J&\2\u0171\u0176\5L\'\2\u0172"+
		"\u0176\5N(\2\u0173\u0176\5P)\2\u0174\u0176\5R*\2\u0175\u0161\3\2\2\2\u0175"+
		"\u0162\3\2\2\2\u0175\u0163\3\2\2\2\u0175\u0164\3\2\2\2\u0175\u0165\3\2"+
		"\2\2\u0175\u0166\3\2\2\2\u0175\u0167\3\2\2\2\u0175\u0168\3\2\2\2\u0175"+
		"\u0169\3\2\2\2\u0175\u016a\3\2\2\2\u0175\u016b\3\2\2\2\u0175\u016c\3\2"+
		"\2\2\u0175\u016d\3\2\2\2\u0175\u016e\3\2\2\2\u0175\u016f\3\2\2\2\u0175"+
		"\u0170\3\2\2\2\u0175\u0171\3\2\2\2\u0175\u0172\3\2\2\2\u0175\u0173\3\2"+
		"\2\2\u0175\u0174\3\2\2\2\u0176+\3\2\2\2\u0177\u0178\5\u0094K\2\u0178\u0179"+
		"\7=\2\2\u0179\u017a\7\3\2\2\u017a\u017b\7\67\2\2\u017b\u017c\5f\64\2\u017c"+
		"\u017d\78\2\2\u017d-\3\2\2\2\u017e\u017f\5\u0094K\2\u017f\u0180\7=\2\2"+
		"\u0180\u0181\7\4\2\2\u0181\u0182\7\67\2\2\u0182\u0183\5f\64\2\u0183\u0184"+
		"\78\2\2\u0184/\3\2\2\2\u0185\u0186\5\u0094K\2\u0186\u0187\7=\2\2\u0187"+
		"\u0188\7\5\2\2\u0188\61\3\2\2\2\u0189\u018a\5\u0094K\2\u018a\u018b\7="+
		"\2\2\u018b\u018c\7\6\2\2\u018c\u018d\7\67\2\2\u018d\u018e\5f\64\2\u018e"+
		"\u018f\7<\2\2\u018f\u0190\5h\65\2\u0190\u0191\78\2\2\u0191\63\3\2\2\2"+
		"\u0192\u0193\5\u0094K\2\u0193\u0194\7=\2\2\u0194\u0195\7\7\2\2\u0195\u0196"+
		"\7\67\2\2\u0196\u0197\5l\67\2\u0197\u0198\7<\2\2\u0198\u0199\5n8\2\u0199"+
		"\u019a\7<\2\2\u019a\u019b\5p9\2\u019b\u019c\78\2\2\u019c\65\3\2\2\2\u019d"+
		"\u019e\5\u0094K\2\u019e\u019f\7=\2\2\u019f\u01a0\7\b\2\2\u01a0\u01a1\7"+
		"\67\2\2\u01a1\u01a2\5n8\2\u01a2\u01a3\7<\2\2\u01a3\u01a4\5p9\2\u01a4\u01a5"+
		"\78\2\2\u01a5\67\3\2\2\2\u01a6\u01a7\5\u0094K\2\u01a7\u01a8\7=\2\2\u01a8"+
		"\u01a9\7\t\2\2\u01a9\u01aa\7\67\2\2\u01aa\u01ab\5f\64\2\u01ab\u01ac\7"+
		"8\2\2\u01ac9\3\2\2\2\u01ad\u01ae\5\u0094K\2\u01ae\u01af\7=\2\2\u01af\u01b0"+
		"\7\n\2\2\u01b0;\3\2\2\2\u01b1\u01b2\5\u0094K\2\u01b2\u01b3\7=\2\2\u01b3"+
		"\u01b4\7\13\2\2\u01b4\u01b5\7\67\2\2\u01b5\u01b6\5f\64\2\u01b6\u01b7\7"+
		"8\2\2\u01b7=\3\2\2\2\u01b8\u01b9\5\u0094K\2\u01b9\u01ba\7=\2\2\u01ba\u01bb"+
		"\7\f\2\2\u01bb\u01bc\7\67\2\2\u01bc\u01bd\5f\64\2\u01bd\u01be\78\2\2\u01be"+
		"?\3\2\2\2\u01bf\u01c0\5\u0094K\2\u01c0\u01c1\7=\2\2\u01c1\u01c2\7\r\2"+
		"\2\u01c2A\3\2\2\2\u01c3\u01c4\5\u0094K\2\u01c4\u01c5\7=\2\2\u01c5\u01c6"+
		"\7\16\2\2\u01c6\u01c7\7\67\2\2\u01c7\u01c8\5l\67\2\u01c8\u01c9\7<\2\2"+
		"\u01c9\u01ca\5n8\2\u01ca\u01cb\7<\2\2\u01cb\u01cc\5p9\2\u01cc\u01cd\7"+
		"8\2\2\u01cdC\3\2\2\2\u01ce\u01cf\5\u0094K\2\u01cf\u01d0\7=\2\2\u01d0\u01d1"+
		"\7\17\2\2\u01d1\u01d2\7\67\2\2\u01d2\u01d3\5n8\2\u01d3\u01d4\7<\2\2\u01d4"+
		"\u01d5\5p9\2\u01d5\u01d6\78\2\2\u01d6E\3\2\2\2\u01d7\u01d8\5\u0094K\2"+
		"\u01d8\u01d9\7=\2\2\u01d9\u01da\7\20\2\2\u01da\u01db\7\67\2\2\u01db\u01dc"+
		"\5f\64\2\u01dc\u01dd\78\2\2\u01ddG\3\2\2\2\u01de\u01df\5\u0094K\2\u01df"+
		"\u01e0\7=\2\2\u01e0\u01e1\7\21\2\2\u01e1\u01e2\7\67\2\2\u01e2\u01e3\5"+
		"f\64\2\u01e3\u01e4\78\2\2\u01e4I\3\2\2\2\u01e5\u01e6\5\u0094K\2\u01e6"+
		"\u01e7\7=\2\2\u01e7\u01e8\7\22\2\2\u01e8\u01e9\7\67\2\2\u01e9\u01ea\5"+
		"f\64\2\u01ea\u01eb\78\2\2\u01ebK\3\2\2\2\u01ec\u01ed\5\u0094K\2\u01ed"+
		"\u01ee\7=\2\2\u01ee\u01ef\7\23\2\2\u01efM\3\2\2\2\u01f0\u01f1\5\u0094"+
		"K\2\u01f1\u01f2\7=\2\2\u01f2\u01f3\7\24\2\2\u01f3\u01f4\7\67\2\2\u01f4"+
		"\u01f5\5l\67\2\u01f5\u01f6\7<\2\2\u01f6\u01f7\5n8\2\u01f7\u01f8\7<\2\2"+
		"\u01f8\u01f9\5p9\2\u01f9\u01fa\78\2\2\u01faO\3\2\2\2\u01fb\u01fc\5\u0094"+
		"K\2\u01fc\u01fd\7=\2\2\u01fd\u01fe\7\25\2\2\u01fe\u01ff\7\67\2\2\u01ff"+
		"\u0200\5n8\2\u0200\u0201\7<\2\2\u0201\u0202\5p9\2\u0202\u0203\78\2\2\u0203"+
		"Q\3\2\2\2\u0204\u0205\5\u0094K\2\u0205\u0206\7=\2\2\u0206\u0207\7\26\2"+
		"\2\u0207\u0208\7\67\2\2\u0208\u0209\5f\64\2\u0209\u020a\78\2\2\u020aS"+
		"\3\2\2\2\u020b\u020c\7@\2\2\u020cU\3\2\2\2\u020d\u020e\7@\2\2\u020eW\3"+
		"\2\2\2\u020f\u0210\7@\2\2\u0210Y\3\2\2\2\u0211\u0212\7@\2\2\u0212[\3\2"+
		"\2\2\u0213\u0214\7@\2\2\u0214]\3\2\2\2\u0215\u0216\7@\2\2\u0216_\3\2\2"+
		"\2\u0217\u0218\7@\2\2\u0218a\3\2\2\2\u0219\u021a\7@\2\2\u021ac\3\2\2\2"+
		"\u021b\u021c\7@\2\2\u021ce\3\2\2\2\u021d\u021e\7@\2\2\u021eg\3\2\2\2\u021f"+
		"\u0220\7@\2\2\u0220i\3\2\2\2\u0221\u0222\7@\2\2\u0222k\3\2\2\2\u0223\u0224"+
		"\7@\2\2\u0224m\3\2\2\2\u0225\u0226\7@\2\2\u0226o\3\2\2\2\u0227\u0228\7"+
		"@\2\2\u0228q\3\2\2\2\u0229\u022a\7>\2\2\u022as\3\2\2\2\u022b\u022c\7>"+
		"\2\2\u022cu\3\2\2\2\u022d\u022e\7@\2\2\u022ew\3\2\2\2\u022f\u0230\7>\2"+
		"\2\u0230y\3\2\2\2\u0231\u0232\7>\2\2\u0232{\3\2\2\2\u0233\u0234\t\2\2"+
		"\2\u0234}\3\2\2\2\u0235\u0236\t\3\2\2\u0236\177\3\2\2\2\u0237\u0238\t"+
		"\4\2\2\u0238\u0081\3\2\2\2\u0239\u023a\7\65\2\2\u023a\u023f\5\u0080A\2"+
		"\u023b\u023c\7<\2\2\u023c\u023e\5\u0080A\2\u023d\u023b\3\2\2\2\u023e\u0241"+
		"\3\2\2\2\u023f\u023d\3\2\2\2\u023f\u0240\3\2\2\2\u0240\u0242\3\2\2\2\u0241"+
		"\u023f\3\2\2\2\u0242\u0243\7\66\2\2\u0243\u0083\3\2\2\2\u0244\u0245\7"+
		"\65\2\2\u0245\u024a\5\u0088E\2\u0246\u0247\7<\2\2\u0247\u0249\5\u0088"+
		"E\2\u0248\u0246\3\2\2\2\u0249\u024c\3\2\2\2\u024a\u0248\3\2\2\2\u024a"+
		"\u024b\3\2\2\2\u024b\u024d\3\2\2\2\u024c\u024a\3\2\2\2\u024d\u024e\7\66"+
		"\2\2\u024e\u0085\3\2\2\2\u024f\u0250\7>\2\2\u0250\u0087\3\2\2\2\u0251"+
		"\u0252\7>\2\2\u0252\u0089\3\2\2\2\u0253\u0254\7>\2\2\u0254\u008b\3\2\2"+
		"\2\u0255\u0256\7>\2\2\u0256\u008d\3\2\2\2\u0257\u0258\7>\2\2\u0258\u008f"+
		"\3\2\2\2\u0259\u025a\7>\2\2\u025a\u0091\3\2\2\2\u025b\u025c\7>\2\2\u025c"+
		"\u0093\3\2\2\2\u025d\u025e\7>\2\2\u025e\u0095\3\2\2\2\u025f\u0260\7A\2"+
		"\2\u0260\u0097\3\2\2\2\u0261\u0262\7@\2\2\u0262\u0099\3\2\2\2\13\u00ac"+
		"\u0103\u0122\u012c\u0139\u0146\u0175\u023f\u024a";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}