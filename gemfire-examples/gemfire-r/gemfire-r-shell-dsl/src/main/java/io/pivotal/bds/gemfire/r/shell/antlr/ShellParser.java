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
		BINARYSPARSETHINPLATEPLINEKERNEL=20, RBF_NETWORK=21, RANDOMFOREST_CLASSIFICATION=22, 
		FLD=23, QDA=24, LDA=25, RDA=26, LOGISTIC_REGRESSION=27, NAIVE_BAYES=28, 
		NEUTRAL_NETWORK=29, KNN=30, DECISIONTREE_CLASSIFICATIONERROR=31, DECISIONTREE=32, 
		GAUSSIANPROCESS=33, REGRESSIONTREE=34, RANDOMFORESTREGRESSION=35, RIDGEREGRESSION=36, 
		SVR=37, ENTROPY=38, GINI=39, DTRAIN=40, TRAIN=41, FFT=42, FORWARD=43, 
		INVERSE=44, STANDARD=45, UNITARY=46, MATRIX=47, VECTOR=48, QUERYARGS=49, 
		MODEL=50, FIELDS=51, REGION=52, RM=53, LS=54, PRINT=55, PREDICT=56, K=57, 
		LAMBDA=58, SVM=59, CP=60, CN=61, QUERY=62, EXECUTE=63, LBRACKET=64, RBRACKET=65, 
		LPAREN=66, RPAREN=67, LBRACE=68, RBRACE=69, DBLQUOTES=70, COMMA=71, EQUALS=72, 
		IDENTIFIER=73, DIGIT=74, NUMBER=75, QUOTEDSTRING=76, WS=77;
	public static final int
		RULE_cmd = 0, RULE_rda = 1, RULE_lda = 2, RULE_qda = 3, RULE_fld = 4, 
		RULE_randomForestClassification = 5, RULE_decisionTree = 6, RULE_svm = 7, 
		RULE_gaussianProcess = 8, RULE_regressionTree = 9, RULE_randomForestRegression = 10, 
		RULE_ridgeRegression = 11, RULE_svr = 12, RULE_knn = 13, RULE_query = 14, 
		RULE_execute = 15, RULE_trainModel = 16, RULE_dtrainModel = 17, RULE_predict = 18, 
		RULE_vector = 19, RULE_matrix = 20, RULE_fft = 21, RULE_print = 22, RULE_ls = 23, 
		RULE_rm = 24, RULE_dtreeSplitRuleVar = 25, RULE_kernel = 26, RULE_mercerkernel = 27, 
		RULE_gaussKernel = 28, RULE_laplaceKernel = 29, RULE_linearKernel = 30, 
		RULE_pearsonKernel = 31, RULE_polyKernel = 32, RULE_hypertangentKernel = 33, 
		RULE_thinplatesplineKernel = 34, RULE_hellingerKernel = 35, RULE_sparsegaussKernel = 36, 
		RULE_sparselaplaceKernel = 37, RULE_sparselinearKernel = 38, RULE_sparsepolyKernel = 39, 
		RULE_sparsehypertangentKernel = 40, RULE_sparsethinplatesplineKernel = 41, 
		RULE_binarysparsegaussKernel = 42, RULE_binarysparselaplaceKernel = 43, 
		RULE_binarysparselinearKernel = 44, RULE_binarysparsepolyKernel = 45, 
		RULE_binarysparsehypertangentKernel = 46, RULE_binarysparsethinplatesplineKernel = 47, 
		RULE_tVar = 48, RULE_mVar = 49, RULE_sVar = 50, RULE_jVar = 51, RULE_alphaVar = 52, 
		RULE_prioriVar = 53, RULE_lVar = 54, RULE_mtryVar = 55, RULE_ntreesVar = 56, 
		RULE_maxNodesVar = 57, RULE_nodeSizeVar = 58, RULE_tolVar = 59, RULE_epsVar = 60, 
		RULE_cVar = 61, RULE_cpVar = 62, RULE_cnVar = 63, RULE_kVar = 64, RULE_sigmaVar = 65, 
		RULE_omegaVar = 66, RULE_lambdaVar = 67, RULE_degreeVar = 68, RULE_scaleVar = 69, 
		RULE_offsetVar = 70, RULE_xFieldName = 71, RULE_yFieldName = 72, RULE_sizeVar = 73, 
		RULE_trainId = 74, RULE_fftInputId = 75, RULE_fftDir = 76, RULE_fftNorm = 77, 
		RULE_queryArg = 78, RULE_queryArgs = 79, RULE_fieldNames = 80, RULE_var = 81, 
		RULE_fieldName = 82, RULE_modelId = 83, RULE_queryId = 84, RULE_regionName = 85, 
		RULE_matrixId = 86, RULE_vectorId = 87, RULE_kernelId = 88, RULE_queryString = 89, 
		RULE_number = 90;
	public static final String[] ruleNames = {
		"cmd", "rda", "lda", "qda", "fld", "randomForestClassification", "decisionTree", 
		"svm", "gaussianProcess", "regressionTree", "randomForestRegression", 
		"ridgeRegression", "svr", "knn", "query", "execute", "trainModel", "dtrainModel", 
		"predict", "vector", "matrix", "fft", "print", "ls", "rm", "dtreeSplitRuleVar", 
		"kernel", "mercerkernel", "gaussKernel", "laplaceKernel", "linearKernel", 
		"pearsonKernel", "polyKernel", "hypertangentKernel", "thinplatesplineKernel", 
		"hellingerKernel", "sparsegaussKernel", "sparselaplaceKernel", "sparselinearKernel", 
		"sparsepolyKernel", "sparsehypertangentKernel", "sparsethinplatesplineKernel", 
		"binarysparsegaussKernel", "binarysparselaplaceKernel", "binarysparselinearKernel", 
		"binarysparsepolyKernel", "binarysparsehypertangentKernel", "binarysparsethinplatesplineKernel", 
		"tVar", "mVar", "sVar", "jVar", "alphaVar", "prioriVar", "lVar", "mtryVar", 
		"ntreesVar", "maxNodesVar", "nodeSizeVar", "tolVar", "epsVar", "cVar", 
		"cpVar", "cnVar", "kVar", "sigmaVar", "omegaVar", "lambdaVar", "degreeVar", 
		"scaleVar", "offsetVar", "xFieldName", "yFieldName", "sizeVar", "trainId", 
		"fftInputId", "fftDir", "fftNorm", "queryArg", "queryArgs", "fieldNames", 
		"var", "fieldName", "modelId", "queryId", "regionName", "matrixId", "vectorId", 
		"kernelId", "queryString", "number"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'gausskernel'", "'laplacekernel'", "'linearkernel'", "'pearsonkernel'", 
		"'polykernel'", "'hypertangentkernel'", "'thinplatesplinekernel'", "'hellingerkernel'", 
		"'sparsegausskernel'", "'sparselaplacekernel'", "'sparselinearkernel'", 
		"'sparsepolykernel'", "'sparsehypertangentkernel'", "'sparsethinplatesplinekernel'", 
		"'binarysparsegausskernel'", "'binarysparselaplacekernel'", "'binarysparselinearkernel'", 
		"'binarysparsepolykernel'", "'binarysparsehypertangentkernel'", "'binarysparsethinplatesplinekernel'", 
		"'rbfnet'", "'rforestc'", "'fld'", "'qda'", "'lda'", "'rda'", "'lregress'", 
		"'nbayes'", "'neuralnet'", "'knn'", "'classerror'", "'dtree'", "'gp'", 
		"'rtree'", "'rforestr'", "'ridger'", "'svr'", "'entropy'", "'gini'", "'dtrain'", 
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
		"BINARYSPARSETHINPLATEPLINEKERNEL", "RBF_NETWORK", "RANDOMFOREST_CLASSIFICATION", 
		"FLD", "QDA", "LDA", "RDA", "LOGISTIC_REGRESSION", "NAIVE_BAYES", "NEUTRAL_NETWORK", 
		"KNN", "DECISIONTREE_CLASSIFICATIONERROR", "DECISIONTREE", "GAUSSIANPROCESS", 
		"REGRESSIONTREE", "RANDOMFORESTREGRESSION", "RIDGEREGRESSION", "SVR", 
		"ENTROPY", "GINI", "DTRAIN", "TRAIN", "FFT", "FORWARD", "INVERSE", "STANDARD", 
		"UNITARY", "MATRIX", "VECTOR", "QUERYARGS", "MODEL", "FIELDS", "REGION", 
		"RM", "LS", "PRINT", "PREDICT", "K", "LAMBDA", "SVM", "CP", "CN", "QUERY", 
		"EXECUTE", "LBRACKET", "RBRACKET", "LPAREN", "RPAREN", "LBRACE", "RBRACE", 
		"DBLQUOTES", "COMMA", "EQUALS", "IDENTIFIER", "DIGIT", "NUMBER", "QUOTEDSTRING", 
		"WS"
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
		public FldContext fld() {
			return getRuleContext(FldContext.class,0);
		}
		public RandomForestClassificationContext randomForestClassification() {
			return getRuleContext(RandomForestClassificationContext.class,0);
		}
		public DecisionTreeContext decisionTree() {
			return getRuleContext(DecisionTreeContext.class,0);
		}
		public QdaContext qda() {
			return getRuleContext(QdaContext.class,0);
		}
		public LdaContext lda() {
			return getRuleContext(LdaContext.class,0);
		}
		public RdaContext rda() {
			return getRuleContext(RdaContext.class,0);
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
			setState(206);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(182);
				query();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(183);
				execute();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(184);
				svm();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(185);
				fld();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(186);
				randomForestClassification();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(187);
				decisionTree();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(188);
				qda();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(189);
				lda();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(190);
				rda();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(191);
				gaussianProcess();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(192);
				regressionTree();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(193);
				randomForestRegression();
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(194);
				ridgeRegression();
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(195);
				svr();
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(196);
				kernel();
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 16);
				{
				setState(197);
				trainModel();
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 17);
				{
				setState(198);
				dtrainModel();
				}
				break;
			case 18:
				enterOuterAlt(_localctx, 18);
				{
				setState(199);
				predict();
				}
				break;
			case 19:
				enterOuterAlt(_localctx, 19);
				{
				setState(200);
				print();
				}
				break;
			case 20:
				enterOuterAlt(_localctx, 20);
				{
				setState(201);
				ls();
				}
				break;
			case 21:
				enterOuterAlt(_localctx, 21);
				{
				setState(202);
				rm();
				}
				break;
			case 22:
				enterOuterAlt(_localctx, 22);
				{
				setState(203);
				vector();
				}
				break;
			case 23:
				enterOuterAlt(_localctx, 23);
				{
				setState(204);
				matrix();
				}
				break;
			case 24:
				enterOuterAlt(_localctx, 24);
				{
				setState(205);
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

	public static class RdaContext extends ParserRuleContext {
		public ModelIdContext modelId() {
			return getRuleContext(ModelIdContext.class,0);
		}
		public TerminalNode EQUALS() { return getToken(ShellParser.EQUALS, 0); }
		public TerminalNode RDA() { return getToken(ShellParser.RDA, 0); }
		public TerminalNode LPAREN() { return getToken(ShellParser.LPAREN, 0); }
		public AlphaVarContext alphaVar() {
			return getRuleContext(AlphaVarContext.class,0);
		}
		public List<TerminalNode> COMMA() { return getTokens(ShellParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ShellParser.COMMA, i);
		}
		public TolVarContext tolVar() {
			return getRuleContext(TolVarContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ShellParser.RPAREN, 0); }
		public List<PrioriVarContext> prioriVar() {
			return getRuleContexts(PrioriVarContext.class);
		}
		public PrioriVarContext prioriVar(int i) {
			return getRuleContext(PrioriVarContext.class,i);
		}
		public RdaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rda; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).enterRda(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).exitRda(this);
		}
	}

	public final RdaContext rda() throws RecognitionException {
		RdaContext _localctx = new RdaContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_rda);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(208);
			modelId();
			setState(209);
			match(EQUALS);
			setState(210);
			match(RDA);
			setState(211);
			match(LPAREN);
			setState(212);
			alphaVar();
			setState(213);
			match(COMMA);
			setState(214);
			tolVar();
			setState(217); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(215);
				match(COMMA);
				setState(216);
				prioriVar();
				}
				}
				setState(219); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==COMMA );
			setState(221);
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

	public static class LdaContext extends ParserRuleContext {
		public ModelIdContext modelId() {
			return getRuleContext(ModelIdContext.class,0);
		}
		public TerminalNode EQUALS() { return getToken(ShellParser.EQUALS, 0); }
		public TerminalNode LDA() { return getToken(ShellParser.LDA, 0); }
		public TerminalNode LPAREN() { return getToken(ShellParser.LPAREN, 0); }
		public TolVarContext tolVar() {
			return getRuleContext(TolVarContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ShellParser.RPAREN, 0); }
		public List<TerminalNode> COMMA() { return getTokens(ShellParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ShellParser.COMMA, i);
		}
		public List<PrioriVarContext> prioriVar() {
			return getRuleContexts(PrioriVarContext.class);
		}
		public PrioriVarContext prioriVar(int i) {
			return getRuleContext(PrioriVarContext.class,i);
		}
		public LdaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lda; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).enterLda(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).exitLda(this);
		}
	}

	public final LdaContext lda() throws RecognitionException {
		LdaContext _localctx = new LdaContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_lda);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(223);
			modelId();
			setState(224);
			match(EQUALS);
			setState(225);
			match(LDA);
			setState(226);
			match(LPAREN);
			setState(227);
			tolVar();
			setState(230); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(228);
				match(COMMA);
				setState(229);
				prioriVar();
				}
				}
				setState(232); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==COMMA );
			setState(234);
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

	public static class QdaContext extends ParserRuleContext {
		public ModelIdContext modelId() {
			return getRuleContext(ModelIdContext.class,0);
		}
		public TerminalNode EQUALS() { return getToken(ShellParser.EQUALS, 0); }
		public TerminalNode QDA() { return getToken(ShellParser.QDA, 0); }
		public TerminalNode LPAREN() { return getToken(ShellParser.LPAREN, 0); }
		public TolVarContext tolVar() {
			return getRuleContext(TolVarContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ShellParser.RPAREN, 0); }
		public List<TerminalNode> COMMA() { return getTokens(ShellParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ShellParser.COMMA, i);
		}
		public List<PrioriVarContext> prioriVar() {
			return getRuleContexts(PrioriVarContext.class);
		}
		public PrioriVarContext prioriVar(int i) {
			return getRuleContext(PrioriVarContext.class,i);
		}
		public QdaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qda; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).enterQda(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).exitQda(this);
		}
	}

	public final QdaContext qda() throws RecognitionException {
		QdaContext _localctx = new QdaContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_qda);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(236);
			modelId();
			setState(237);
			match(EQUALS);
			setState(238);
			match(QDA);
			setState(239);
			match(LPAREN);
			setState(240);
			tolVar();
			setState(243); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(241);
				match(COMMA);
				setState(242);
				prioriVar();
				}
				}
				setState(245); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==COMMA );
			setState(247);
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

	public static class FldContext extends ParserRuleContext {
		public ModelIdContext modelId() {
			return getRuleContext(ModelIdContext.class,0);
		}
		public TerminalNode EQUALS() { return getToken(ShellParser.EQUALS, 0); }
		public TerminalNode FLD() { return getToken(ShellParser.FLD, 0); }
		public TerminalNode LPAREN() { return getToken(ShellParser.LPAREN, 0); }
		public LVarContext lVar() {
			return getRuleContext(LVarContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(ShellParser.COMMA, 0); }
		public TolVarContext tolVar() {
			return getRuleContext(TolVarContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ShellParser.RPAREN, 0); }
		public FldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fld; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).enterFld(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).exitFld(this);
		}
	}

	public final FldContext fld() throws RecognitionException {
		FldContext _localctx = new FldContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_fld);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(249);
			modelId();
			setState(250);
			match(EQUALS);
			setState(251);
			match(FLD);
			setState(252);
			match(LPAREN);
			setState(253);
			lVar();
			setState(254);
			match(COMMA);
			setState(255);
			tolVar();
			setState(256);
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

	public static class RandomForestClassificationContext extends ParserRuleContext {
		public ModelIdContext modelId() {
			return getRuleContext(ModelIdContext.class,0);
		}
		public TerminalNode EQUALS() { return getToken(ShellParser.EQUALS, 0); }
		public TerminalNode RANDOMFOREST_CLASSIFICATION() { return getToken(ShellParser.RANDOMFOREST_CLASSIFICATION, 0); }
		public TerminalNode LPAREN() { return getToken(ShellParser.LPAREN, 0); }
		public NtreesVarContext ntreesVar() {
			return getRuleContext(NtreesVarContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(ShellParser.COMMA, 0); }
		public MtryVarContext mtryVar() {
			return getRuleContext(MtryVarContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ShellParser.RPAREN, 0); }
		public RandomForestClassificationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_randomForestClassification; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).enterRandomForestClassification(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).exitRandomForestClassification(this);
		}
	}

	public final RandomForestClassificationContext randomForestClassification() throws RecognitionException {
		RandomForestClassificationContext _localctx = new RandomForestClassificationContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_randomForestClassification);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(258);
			modelId();
			setState(259);
			match(EQUALS);
			setState(260);
			match(RANDOMFOREST_CLASSIFICATION);
			setState(261);
			match(LPAREN);
			setState(262);
			ntreesVar();
			setState(263);
			match(COMMA);
			setState(264);
			mtryVar();
			setState(265);
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

	public static class DecisionTreeContext extends ParserRuleContext {
		public ModelIdContext modelId() {
			return getRuleContext(ModelIdContext.class,0);
		}
		public TerminalNode EQUALS() { return getToken(ShellParser.EQUALS, 0); }
		public TerminalNode DECISIONTREE() { return getToken(ShellParser.DECISIONTREE, 0); }
		public TerminalNode LPAREN() { return getToken(ShellParser.LPAREN, 0); }
		public JVarContext jVar() {
			return getRuleContext(JVarContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(ShellParser.COMMA, 0); }
		public DtreeSplitRuleVarContext dtreeSplitRuleVar() {
			return getRuleContext(DtreeSplitRuleVarContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ShellParser.RPAREN, 0); }
		public DecisionTreeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decisionTree; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).enterDecisionTree(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).exitDecisionTree(this);
		}
	}

	public final DecisionTreeContext decisionTree() throws RecognitionException {
		DecisionTreeContext _localctx = new DecisionTreeContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_decisionTree);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(267);
			modelId();
			setState(268);
			match(EQUALS);
			setState(269);
			match(DECISIONTREE);
			setState(270);
			match(LPAREN);
			setState(271);
			jVar();
			setState(272);
			match(COMMA);
			setState(273);
			dtreeSplitRuleVar();
			setState(274);
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
		enterRule(_localctx, 14, RULE_svm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(276);
			modelId();
			setState(277);
			match(EQUALS);
			setState(278);
			match(SVM);
			setState(279);
			match(LPAREN);
			setState(280);
			cpVar();
			setState(281);
			match(COMMA);
			setState(282);
			cnVar();
			setState(283);
			match(COMMA);
			setState(284);
			kVar();
			setState(285);
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
		enterRule(_localctx, 16, RULE_gaussianProcess);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(287);
			modelId();
			setState(288);
			match(EQUALS);
			setState(289);
			match(GAUSSIANPROCESS);
			setState(290);
			match(LPAREN);
			setState(291);
			kernelId();
			setState(292);
			match(COMMA);
			setState(293);
			lambdaVar();
			setState(294);
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
		public JVarContext jVar() {
			return getRuleContext(JVarContext.class,0);
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
		enterRule(_localctx, 18, RULE_regressionTree);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(296);
			modelId();
			setState(297);
			match(EQUALS);
			setState(298);
			match(REGRESSIONTREE);
			setState(299);
			match(LPAREN);
			setState(300);
			jVar();
			setState(301);
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
		public TVarContext tVar() {
			return getRuleContext(TVarContext.class,0);
		}
		public List<TerminalNode> COMMA() { return getTokens(ShellParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ShellParser.COMMA, i);
		}
		public MVarContext mVar() {
			return getRuleContext(MVarContext.class,0);
		}
		public SVarContext sVar() {
			return getRuleContext(SVarContext.class,0);
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
		enterRule(_localctx, 20, RULE_randomForestRegression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(303);
			modelId();
			setState(304);
			match(EQUALS);
			setState(305);
			match(RANDOMFORESTREGRESSION);
			setState(306);
			match(LPAREN);
			setState(307);
			tVar();
			setState(308);
			match(COMMA);
			setState(309);
			mVar();
			setState(310);
			match(COMMA);
			setState(311);
			sVar();
			setState(312);
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
		enterRule(_localctx, 22, RULE_ridgeRegression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(314);
			modelId();
			setState(315);
			match(EQUALS);
			setState(316);
			match(RIDGEREGRESSION);
			setState(317);
			match(LPAREN);
			setState(318);
			lambdaVar();
			setState(319);
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
		enterRule(_localctx, 24, RULE_svr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(321);
			modelId();
			setState(322);
			match(EQUALS);
			setState(323);
			match(SVR);
			setState(324);
			match(LPAREN);
			setState(325);
			kernelId();
			setState(326);
			match(COMMA);
			setState(327);
			epsVar();
			setState(328);
			match(COMMA);
			setState(329);
			cVar();
			setState(330);
			match(COMMA);
			setState(331);
			tolVar();
			setState(332);
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
		enterRule(_localctx, 26, RULE_knn);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(334);
			modelId();
			setState(335);
			match(EQUALS);
			setState(336);
			match(KNN);
			setState(337);
			match(LPAREN);
			setState(338);
			kernelId();
			setState(339);
			match(COMMA);
			setState(340);
			epsVar();
			setState(341);
			match(COMMA);
			setState(342);
			cVar();
			setState(343);
			match(COMMA);
			setState(344);
			tolVar();
			setState(345);
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
		enterRule(_localctx, 28, RULE_query);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(347);
			queryId();
			setState(348);
			match(EQUALS);
			setState(349);
			match(QUERY);
			setState(350);
			match(LPAREN);
			setState(351);
			queryString();
			setState(352);
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
		enterRule(_localctx, 30, RULE_execute);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(354);
			match(EXECUTE);
			setState(355);
			match(LPAREN);
			setState(356);
			queryId();
			setState(361);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(357);
				match(COMMA);
				setState(358);
				queryArg();
				}
				}
				setState(363);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(364);
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
		enterRule(_localctx, 32, RULE_trainModel);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(366);
			trainId();
			setState(367);
			match(EQUALS);
			setState(368);
			match(TRAIN);
			setState(369);
			match(LPAREN);
			setState(370);
			modelId();
			setState(371);
			match(COMMA);
			setState(372);
			matrixId();
			setState(373);
			match(COMMA);
			setState(374);
			vectorId();
			setState(375);
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
		enterRule(_localctx, 34, RULE_dtrainModel);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(377);
			trainId();
			setState(378);
			match(EQUALS);
			setState(379);
			match(DTRAIN);
			setState(380);
			match(LPAREN);
			setState(381);
			modelId();
			setState(382);
			match(COMMA);
			setState(383);
			regionName();
			setState(384);
			match(COMMA);
			setState(385);
			sizeVar();
			setState(386);
			match(COMMA);
			setState(387);
			yFieldName();
			setState(390); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(388);
				match(COMMA);
				setState(389);
				xFieldName();
				}
				}
				setState(392); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==COMMA );
			setState(394);
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
		enterRule(_localctx, 36, RULE_predict);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(396);
			match(PREDICT);
			setState(397);
			match(LPAREN);
			setState(398);
			modelId();
			setState(399);
			match(COMMA);
			setState(402);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				{
				setState(400);
				vectorId();
				}
				break;
			case NUMBER:
				{
				setState(401);
				number();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(404);
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
		enterRule(_localctx, 38, RULE_vector);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(406);
			vectorId();
			setState(407);
			match(EQUALS);
			setState(408);
			match(VECTOR);
			setState(409);
			match(LPAREN);
			setState(410);
			queryId();
			setState(411);
			match(COMMA);
			setState(412);
			fieldName();
			setState(415);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(413);
				match(COMMA);
				setState(414);
				queryArgs();
				}
			}

			setState(417);
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
		enterRule(_localctx, 40, RULE_matrix);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(419);
			matrixId();
			setState(420);
			match(EQUALS);
			setState(421);
			match(MATRIX);
			setState(422);
			match(LPAREN);
			setState(423);
			queryId();
			setState(424);
			match(COMMA);
			setState(425);
			fieldNames();
			setState(428);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(426);
				match(COMMA);
				setState(427);
				queryArgs();
				}
			}

			setState(430);
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
		enterRule(_localctx, 42, RULE_fft);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(432);
			matrixId();
			setState(433);
			match(EQUALS);
			setState(434);
			match(FFT);
			setState(435);
			match(LPAREN);
			setState(436);
			fftInputId();
			setState(437);
			match(COMMA);
			setState(438);
			fftDir();
			setState(439);
			match(COMMA);
			setState(440);
			fftNorm();
			setState(441);
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
		enterRule(_localctx, 44, RULE_print);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(443);
			match(PRINT);
			setState(444);
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
		enterRule(_localctx, 46, RULE_ls);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(446);
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
		enterRule(_localctx, 48, RULE_rm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(448);
			match(RM);
			setState(449);
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

	public static class DtreeSplitRuleVarContext extends ParserRuleContext {
		public TerminalNode DECISIONTREE_CLASSIFICATIONERROR() { return getToken(ShellParser.DECISIONTREE_CLASSIFICATIONERROR, 0); }
		public TerminalNode ENTROPY() { return getToken(ShellParser.ENTROPY, 0); }
		public TerminalNode GINI() { return getToken(ShellParser.GINI, 0); }
		public DtreeSplitRuleVarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dtreeSplitRuleVar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).enterDtreeSplitRuleVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).exitDtreeSplitRuleVar(this);
		}
	}

	public final DtreeSplitRuleVarContext dtreeSplitRuleVar() throws RecognitionException {
		DtreeSplitRuleVarContext _localctx = new DtreeSplitRuleVarContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_dtreeSplitRuleVar);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(451);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DECISIONTREE_CLASSIFICATIONERROR) | (1L << ENTROPY) | (1L << GINI))) != 0)) ) {
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
		enterRule(_localctx, 52, RULE_kernel);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(453);
			kernelId();
			setState(454);
			match(EQUALS);
			setState(455);
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
		enterRule(_localctx, 54, RULE_mercerkernel);
		try {
			setState(477);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(457);
				gaussKernel();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(458);
				laplaceKernel();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(459);
				linearKernel();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(460);
				pearsonKernel();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(461);
				polyKernel();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(462);
				hypertangentKernel();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(463);
				thinplatesplineKernel();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(464);
				hellingerKernel();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(465);
				sparsegaussKernel();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(466);
				sparselaplaceKernel();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(467);
				sparselinearKernel();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(468);
				sparsepolyKernel();
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(469);
				sparsehypertangentKernel();
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(470);
				sparsethinplatesplineKernel();
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(471);
				binarysparsegaussKernel();
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 16);
				{
				setState(472);
				binarysparselaplaceKernel();
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 17);
				{
				setState(473);
				binarysparselinearKernel();
				}
				break;
			case 18:
				enterOuterAlt(_localctx, 18);
				{
				setState(474);
				binarysparsepolyKernel();
				}
				break;
			case 19:
				enterOuterAlt(_localctx, 19);
				{
				setState(475);
				binarysparsehypertangentKernel();
				}
				break;
			case 20:
				enterOuterAlt(_localctx, 20);
				{
				setState(476);
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
		enterRule(_localctx, 56, RULE_gaussKernel);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(479);
			kernelId();
			setState(480);
			match(EQUALS);
			setState(481);
			match(GAUSSIANKERNEL);
			setState(482);
			match(LPAREN);
			setState(483);
			sigmaVar();
			setState(484);
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
		enterRule(_localctx, 58, RULE_laplaceKernel);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(486);
			kernelId();
			setState(487);
			match(EQUALS);
			setState(488);
			match(LAPLACEKERNEL);
			setState(489);
			match(LPAREN);
			setState(490);
			sigmaVar();
			setState(491);
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
		enterRule(_localctx, 60, RULE_linearKernel);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(493);
			kernelId();
			setState(494);
			match(EQUALS);
			setState(495);
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
		enterRule(_localctx, 62, RULE_pearsonKernel);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(497);
			kernelId();
			setState(498);
			match(EQUALS);
			setState(499);
			match(PEARSONKERNEL);
			setState(500);
			match(LPAREN);
			setState(501);
			sigmaVar();
			setState(502);
			match(COMMA);
			setState(503);
			omegaVar();
			setState(504);
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
		enterRule(_localctx, 64, RULE_polyKernel);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(506);
			kernelId();
			setState(507);
			match(EQUALS);
			setState(508);
			match(POLYNOMIALKERNEL);
			setState(509);
			match(LPAREN);
			setState(510);
			degreeVar();
			setState(511);
			match(COMMA);
			setState(512);
			scaleVar();
			setState(513);
			match(COMMA);
			setState(514);
			offsetVar();
			setState(515);
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
		enterRule(_localctx, 66, RULE_hypertangentKernel);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(517);
			kernelId();
			setState(518);
			match(EQUALS);
			setState(519);
			match(HYPERBOLICTANGENTKERNEL);
			setState(520);
			match(LPAREN);
			setState(521);
			scaleVar();
			setState(522);
			match(COMMA);
			setState(523);
			offsetVar();
			setState(524);
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
		enterRule(_localctx, 68, RULE_thinplatesplineKernel);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(526);
			kernelId();
			setState(527);
			match(EQUALS);
			setState(528);
			match(THINPLATEPLINEKERNEL);
			setState(529);
			match(LPAREN);
			setState(530);
			sigmaVar();
			setState(531);
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
		enterRule(_localctx, 70, RULE_hellingerKernel);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(533);
			kernelId();
			setState(534);
			match(EQUALS);
			setState(535);
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
		enterRule(_localctx, 72, RULE_sparsegaussKernel);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(537);
			kernelId();
			setState(538);
			match(EQUALS);
			setState(539);
			match(SPARSEGAUSSIANKERNEL);
			setState(540);
			match(LPAREN);
			setState(541);
			sigmaVar();
			setState(542);
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
		enterRule(_localctx, 74, RULE_sparselaplaceKernel);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(544);
			kernelId();
			setState(545);
			match(EQUALS);
			setState(546);
			match(SPARSELAPLACEKERNEL);
			setState(547);
			match(LPAREN);
			setState(548);
			sigmaVar();
			setState(549);
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
		enterRule(_localctx, 76, RULE_sparselinearKernel);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(551);
			kernelId();
			setState(552);
			match(EQUALS);
			setState(553);
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
		enterRule(_localctx, 78, RULE_sparsepolyKernel);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(555);
			kernelId();
			setState(556);
			match(EQUALS);
			setState(557);
			match(SPARSEPOLYNOMIALKERNEL);
			setState(558);
			match(LPAREN);
			setState(559);
			degreeVar();
			setState(560);
			match(COMMA);
			setState(561);
			scaleVar();
			setState(562);
			match(COMMA);
			setState(563);
			offsetVar();
			setState(564);
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
		enterRule(_localctx, 80, RULE_sparsehypertangentKernel);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(566);
			kernelId();
			setState(567);
			match(EQUALS);
			setState(568);
			match(SPARSEHYPERBOLICTANGENTKERNEL);
			setState(569);
			match(LPAREN);
			setState(570);
			scaleVar();
			setState(571);
			match(COMMA);
			setState(572);
			offsetVar();
			setState(573);
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
		enterRule(_localctx, 82, RULE_sparsethinplatesplineKernel);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(575);
			kernelId();
			setState(576);
			match(EQUALS);
			setState(577);
			match(SPARSETHINPLATEPLINEKERNEL);
			setState(578);
			match(LPAREN);
			setState(579);
			sigmaVar();
			setState(580);
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
		enterRule(_localctx, 84, RULE_binarysparsegaussKernel);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(582);
			kernelId();
			setState(583);
			match(EQUALS);
			setState(584);
			match(BINARYSPARSEGAUSSIANKERNEL);
			setState(585);
			match(LPAREN);
			setState(586);
			sigmaVar();
			setState(587);
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
		enterRule(_localctx, 86, RULE_binarysparselaplaceKernel);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(589);
			kernelId();
			setState(590);
			match(EQUALS);
			setState(591);
			match(BINARYSPARSELAPLACEKERNEL);
			setState(592);
			match(LPAREN);
			setState(593);
			sigmaVar();
			setState(594);
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
		enterRule(_localctx, 88, RULE_binarysparselinearKernel);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(596);
			kernelId();
			setState(597);
			match(EQUALS);
			setState(598);
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
		enterRule(_localctx, 90, RULE_binarysparsepolyKernel);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(600);
			kernelId();
			setState(601);
			match(EQUALS);
			setState(602);
			match(BINARYSPARSEPOLYNOMIALKERNEL);
			setState(603);
			match(LPAREN);
			setState(604);
			degreeVar();
			setState(605);
			match(COMMA);
			setState(606);
			scaleVar();
			setState(607);
			match(COMMA);
			setState(608);
			offsetVar();
			setState(609);
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
		enterRule(_localctx, 92, RULE_binarysparsehypertangentKernel);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(611);
			kernelId();
			setState(612);
			match(EQUALS);
			setState(613);
			match(BINARYSPARSEHYPERBOLICTANGENTKERNEL);
			setState(614);
			match(LPAREN);
			setState(615);
			scaleVar();
			setState(616);
			match(COMMA);
			setState(617);
			offsetVar();
			setState(618);
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
		enterRule(_localctx, 94, RULE_binarysparsethinplatesplineKernel);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(620);
			kernelId();
			setState(621);
			match(EQUALS);
			setState(622);
			match(BINARYSPARSETHINPLATEPLINEKERNEL);
			setState(623);
			match(LPAREN);
			setState(624);
			sigmaVar();
			setState(625);
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

	public static class TVarContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(ShellParser.NUMBER, 0); }
		public TVarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tVar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).enterTVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).exitTVar(this);
		}
	}

	public final TVarContext tVar() throws RecognitionException {
		TVarContext _localctx = new TVarContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_tVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(627);
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

	public static class MVarContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(ShellParser.NUMBER, 0); }
		public MVarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mVar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).enterMVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).exitMVar(this);
		}
	}

	public final MVarContext mVar() throws RecognitionException {
		MVarContext _localctx = new MVarContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_mVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(629);
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

	public static class SVarContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(ShellParser.NUMBER, 0); }
		public SVarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sVar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).enterSVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).exitSVar(this);
		}
	}

	public final SVarContext sVar() throws RecognitionException {
		SVarContext _localctx = new SVarContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_sVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(631);
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

	public static class JVarContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(ShellParser.NUMBER, 0); }
		public JVarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jVar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).enterJVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).exitJVar(this);
		}
	}

	public final JVarContext jVar() throws RecognitionException {
		JVarContext _localctx = new JVarContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_jVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(633);
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

	public static class AlphaVarContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(ShellParser.NUMBER, 0); }
		public AlphaVarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_alphaVar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).enterAlphaVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).exitAlphaVar(this);
		}
	}

	public final AlphaVarContext alphaVar() throws RecognitionException {
		AlphaVarContext _localctx = new AlphaVarContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_alphaVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(635);
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

	public static class PrioriVarContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(ShellParser.NUMBER, 0); }
		public PrioriVarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prioriVar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).enterPrioriVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).exitPrioriVar(this);
		}
	}

	public final PrioriVarContext prioriVar() throws RecognitionException {
		PrioriVarContext _localctx = new PrioriVarContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_prioriVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(637);
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

	public static class LVarContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(ShellParser.NUMBER, 0); }
		public LVarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lVar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).enterLVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).exitLVar(this);
		}
	}

	public final LVarContext lVar() throws RecognitionException {
		LVarContext _localctx = new LVarContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_lVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(639);
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

	public static class MtryVarContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(ShellParser.NUMBER, 0); }
		public MtryVarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mtryVar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).enterMtryVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).exitMtryVar(this);
		}
	}

	public final MtryVarContext mtryVar() throws RecognitionException {
		MtryVarContext _localctx = new MtryVarContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_mtryVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(641);
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
		enterRule(_localctx, 112, RULE_ntreesVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(643);
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
		enterRule(_localctx, 114, RULE_maxNodesVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(645);
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
		enterRule(_localctx, 116, RULE_nodeSizeVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(647);
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
		enterRule(_localctx, 118, RULE_tolVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(649);
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
		enterRule(_localctx, 120, RULE_epsVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(651);
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
		enterRule(_localctx, 122, RULE_cVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(653);
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
		enterRule(_localctx, 124, RULE_cpVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(655);
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
		enterRule(_localctx, 126, RULE_cnVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(657);
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
		enterRule(_localctx, 128, RULE_kVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(659);
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
		enterRule(_localctx, 130, RULE_sigmaVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(661);
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
		enterRule(_localctx, 132, RULE_omegaVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(663);
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
		enterRule(_localctx, 134, RULE_lambdaVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(665);
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
		enterRule(_localctx, 136, RULE_degreeVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(667);
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
		enterRule(_localctx, 138, RULE_scaleVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(669);
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
		enterRule(_localctx, 140, RULE_offsetVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(671);
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
		enterRule(_localctx, 142, RULE_xFieldName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(673);
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
		enterRule(_localctx, 144, RULE_yFieldName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(675);
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
		enterRule(_localctx, 146, RULE_sizeVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(677);
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
		enterRule(_localctx, 148, RULE_trainId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(679);
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
		enterRule(_localctx, 150, RULE_fftInputId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(681);
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
		enterRule(_localctx, 152, RULE_fftDir);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(683);
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
		enterRule(_localctx, 154, RULE_fftNorm);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(685);
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
		enterRule(_localctx, 156, RULE_queryArg);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(687);
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
		enterRule(_localctx, 158, RULE_queryArgs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(689);
			match(LBRACKET);
			setState(690);
			queryArg();
			setState(695);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(691);
				match(COMMA);
				setState(692);
				queryArg();
				}
				}
				setState(697);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(698);
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
		enterRule(_localctx, 160, RULE_fieldNames);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(700);
			match(LBRACKET);
			setState(701);
			fieldName();
			setState(706);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(702);
				match(COMMA);
				setState(703);
				fieldName();
				}
				}
				setState(708);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(709);
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
		enterRule(_localctx, 162, RULE_var);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(711);
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
		enterRule(_localctx, 164, RULE_fieldName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(713);
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
		enterRule(_localctx, 166, RULE_modelId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(715);
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
		enterRule(_localctx, 168, RULE_queryId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(717);
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
		enterRule(_localctx, 170, RULE_regionName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(719);
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
		enterRule(_localctx, 172, RULE_matrixId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(721);
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
		enterRule(_localctx, 174, RULE_vectorId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(723);
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
		enterRule(_localctx, 176, RULE_kernelId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(725);
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
		enterRule(_localctx, 178, RULE_queryString);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(727);
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
		enterRule(_localctx, 180, RULE_number);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(729);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3O\u02de\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\tT"+
		"\4U\tU\4V\tV\4W\tW\4X\tX\4Y\tY\4Z\tZ\4[\t[\4\\\t\\\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\5\2\u00d1\n\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\6\3\u00dc\n\3"+
		"\r\3\16\3\u00dd\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\6\4\u00e9\n\4\r\4"+
		"\16\4\u00ea\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\6\5\u00f6\n\5\r\5\16\5"+
		"\u00f7\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21"+
		"\3\21\3\21\7\21\u016a\n\21\f\21\16\21\u016d\13\21\3\21\3\21\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\6\23\u0189\n\23\r\23\16\23\u018a"+
		"\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u0195\n\24\3\24\3\24\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u01a2\n\25\3\25\3\25\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\5\26\u01af\n\26\3\26\3\26\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\31"+
		"\3\31\3\32\3\32\3\32\3\33\3\33\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35"+
		"\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35"+
		"\3\35\3\35\5\35\u01e0\n\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\37\3\37"+
		"\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3!\3!\3!\3!\3!\3!\3!\3!\3!\3\"\3"+
		"\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3#\3#\3#\3#\3#\3$\3"+
		"$\3$\3$\3$\3$\3$\3%\3%\3%\3%\3&\3&\3&\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3\'"+
		"\3\'\3\'\3(\3(\3(\3(\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3*\3*\3*\3*\3*\3"+
		"*\3*\3*\3*\3+\3+\3+\3+\3+\3+\3+\3,\3,\3,\3,\3,\3,\3,\3-\3-\3-\3-\3-\3"+
		"-\3-\3.\3.\3.\3.\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3\60\3\60\3\60\3\60"+
		"\3\60\3\60\3\60\3\60\3\60\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\62\3\62"+
		"\3\63\3\63\3\64\3\64\3\65\3\65\3\66\3\66\3\67\3\67\38\38\39\39\3:\3:\3"+
		";\3;\3<\3<\3=\3=\3>\3>\3?\3?\3@\3@\3A\3A\3B\3B\3C\3C\3D\3D\3E\3E\3F\3"+
		"F\3G\3G\3H\3H\3I\3I\3J\3J\3K\3K\3L\3L\3M\3M\3N\3N\3O\3O\3P\3P\3Q\3Q\3"+
		"Q\3Q\7Q\u02b8\nQ\fQ\16Q\u02bb\13Q\3Q\3Q\3R\3R\3R\3R\7R\u02c3\nR\fR\16"+
		"R\u02c6\13R\3R\3R\3S\3S\3T\3T\3U\3U\3V\3V\3W\3W\3X\3X\3Y\3Y\3Z\3Z\3[\3"+
		"[\3\\\3\\\3\\\2\2]\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60"+
		"\62\64\668:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082\u0084\u0086"+
		"\u0088\u008a\u008c\u008e\u0090\u0092\u0094\u0096\u0098\u009a\u009c\u009e"+
		"\u00a0\u00a2\u00a4\u00a6\u00a8\u00aa\u00ac\u00ae\u00b0\u00b2\u00b4\u00b6"+
		"\2\6\4\2!!()\3\2-.\3\2/\60\3\2MN\u02b6\2\u00d0\3\2\2\2\4\u00d2\3\2\2\2"+
		"\6\u00e1\3\2\2\2\b\u00ee\3\2\2\2\n\u00fb\3\2\2\2\f\u0104\3\2\2\2\16\u010d"+
		"\3\2\2\2\20\u0116\3\2\2\2\22\u0121\3\2\2\2\24\u012a\3\2\2\2\26\u0131\3"+
		"\2\2\2\30\u013c\3\2\2\2\32\u0143\3\2\2\2\34\u0150\3\2\2\2\36\u015d\3\2"+
		"\2\2 \u0164\3\2\2\2\"\u0170\3\2\2\2$\u017b\3\2\2\2&\u018e\3\2\2\2(\u0198"+
		"\3\2\2\2*\u01a5\3\2\2\2,\u01b2\3\2\2\2.\u01bd\3\2\2\2\60\u01c0\3\2\2\2"+
		"\62\u01c2\3\2\2\2\64\u01c5\3\2\2\2\66\u01c7\3\2\2\28\u01df\3\2\2\2:\u01e1"+
		"\3\2\2\2<\u01e8\3\2\2\2>\u01ef\3\2\2\2@\u01f3\3\2\2\2B\u01fc\3\2\2\2D"+
		"\u0207\3\2\2\2F\u0210\3\2\2\2H\u0217\3\2\2\2J\u021b\3\2\2\2L\u0222\3\2"+
		"\2\2N\u0229\3\2\2\2P\u022d\3\2\2\2R\u0238\3\2\2\2T\u0241\3\2\2\2V\u0248"+
		"\3\2\2\2X\u024f\3\2\2\2Z\u0256\3\2\2\2\\\u025a\3\2\2\2^\u0265\3\2\2\2"+
		"`\u026e\3\2\2\2b\u0275\3\2\2\2d\u0277\3\2\2\2f\u0279\3\2\2\2h\u027b\3"+
		"\2\2\2j\u027d\3\2\2\2l\u027f\3\2\2\2n\u0281\3\2\2\2p\u0283\3\2\2\2r\u0285"+
		"\3\2\2\2t\u0287\3\2\2\2v\u0289\3\2\2\2x\u028b\3\2\2\2z\u028d\3\2\2\2|"+
		"\u028f\3\2\2\2~\u0291\3\2\2\2\u0080\u0293\3\2\2\2\u0082\u0295\3\2\2\2"+
		"\u0084\u0297\3\2\2\2\u0086\u0299\3\2\2\2\u0088\u029b\3\2\2\2\u008a\u029d"+
		"\3\2\2\2\u008c\u029f\3\2\2\2\u008e\u02a1\3\2\2\2\u0090\u02a3\3\2\2\2\u0092"+
		"\u02a5\3\2\2\2\u0094\u02a7\3\2\2\2\u0096\u02a9\3\2\2\2\u0098\u02ab\3\2"+
		"\2\2\u009a\u02ad\3\2\2\2\u009c\u02af\3\2\2\2\u009e\u02b1\3\2\2\2\u00a0"+
		"\u02b3\3\2\2\2\u00a2\u02be\3\2\2\2\u00a4\u02c9\3\2\2\2\u00a6\u02cb\3\2"+
		"\2\2\u00a8\u02cd\3\2\2\2\u00aa\u02cf\3\2\2\2\u00ac\u02d1\3\2\2\2\u00ae"+
		"\u02d3\3\2\2\2\u00b0\u02d5\3\2\2\2\u00b2\u02d7\3\2\2\2\u00b4\u02d9\3\2"+
		"\2\2\u00b6\u02db\3\2\2\2\u00b8\u00d1\5\36\20\2\u00b9\u00d1\5 \21\2\u00ba"+
		"\u00d1\5\20\t\2\u00bb\u00d1\5\n\6\2\u00bc\u00d1\5\f\7\2\u00bd\u00d1\5"+
		"\16\b\2\u00be\u00d1\5\b\5\2\u00bf\u00d1\5\6\4\2\u00c0\u00d1\5\4\3\2\u00c1"+
		"\u00d1\5\22\n\2\u00c2\u00d1\5\24\13\2\u00c3\u00d1\5\26\f\2\u00c4\u00d1"+
		"\5\30\r\2\u00c5\u00d1\5\32\16\2\u00c6\u00d1\5\66\34\2\u00c7\u00d1\5\""+
		"\22\2\u00c8\u00d1\5$\23\2\u00c9\u00d1\5&\24\2\u00ca\u00d1\5.\30\2\u00cb"+
		"\u00d1\5\60\31\2\u00cc\u00d1\5\62\32\2\u00cd\u00d1\5(\25\2\u00ce\u00d1"+
		"\5*\26\2\u00cf\u00d1\5,\27\2\u00d0\u00b8\3\2\2\2\u00d0\u00b9\3\2\2\2\u00d0"+
		"\u00ba\3\2\2\2\u00d0\u00bb\3\2\2\2\u00d0\u00bc\3\2\2\2\u00d0\u00bd\3\2"+
		"\2\2\u00d0\u00be\3\2\2\2\u00d0\u00bf\3\2\2\2\u00d0\u00c0\3\2\2\2\u00d0"+
		"\u00c1\3\2\2\2\u00d0\u00c2\3\2\2\2\u00d0\u00c3\3\2\2\2\u00d0\u00c4\3\2"+
		"\2\2\u00d0\u00c5\3\2\2\2\u00d0\u00c6\3\2\2\2\u00d0\u00c7\3\2\2\2\u00d0"+
		"\u00c8\3\2\2\2\u00d0\u00c9\3\2\2\2\u00d0\u00ca\3\2\2\2\u00d0\u00cb\3\2"+
		"\2\2\u00d0\u00cc\3\2\2\2\u00d0\u00cd\3\2\2\2\u00d0\u00ce\3\2\2\2\u00d0"+
		"\u00cf\3\2\2\2\u00d1\3\3\2\2\2\u00d2\u00d3\5\u00a8U\2\u00d3\u00d4\7J\2"+
		"\2\u00d4\u00d5\7\34\2\2\u00d5\u00d6\7D\2\2\u00d6\u00d7\5j\66\2\u00d7\u00d8"+
		"\7I\2\2\u00d8\u00db\5x=\2\u00d9\u00da\7I\2\2\u00da\u00dc\5l\67\2\u00db"+
		"\u00d9\3\2\2\2\u00dc\u00dd\3\2\2\2\u00dd\u00db\3\2\2\2\u00dd\u00de\3\2"+
		"\2\2\u00de\u00df\3\2\2\2\u00df\u00e0\7E\2\2\u00e0\5\3\2\2\2\u00e1\u00e2"+
		"\5\u00a8U\2\u00e2\u00e3\7J\2\2\u00e3\u00e4\7\33\2\2\u00e4\u00e5\7D\2\2"+
		"\u00e5\u00e8\5x=\2\u00e6\u00e7\7I\2\2\u00e7\u00e9\5l\67\2\u00e8\u00e6"+
		"\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea\u00e8\3\2\2\2\u00ea\u00eb\3\2\2\2\u00eb"+
		"\u00ec\3\2\2\2\u00ec\u00ed\7E\2\2\u00ed\7\3\2\2\2\u00ee\u00ef\5\u00a8"+
		"U\2\u00ef\u00f0\7J\2\2\u00f0\u00f1\7\32\2\2\u00f1\u00f2\7D\2\2\u00f2\u00f5"+
		"\5x=\2\u00f3\u00f4\7I\2\2\u00f4\u00f6\5l\67\2\u00f5\u00f3\3\2\2\2\u00f6"+
		"\u00f7\3\2\2\2\u00f7\u00f5\3\2\2\2\u00f7\u00f8\3\2\2\2\u00f8\u00f9\3\2"+
		"\2\2\u00f9\u00fa\7E\2\2\u00fa\t\3\2\2\2\u00fb\u00fc\5\u00a8U\2\u00fc\u00fd"+
		"\7J\2\2\u00fd\u00fe\7\31\2\2\u00fe\u00ff\7D\2\2\u00ff\u0100\5n8\2\u0100"+
		"\u0101\7I\2\2\u0101\u0102\5x=\2\u0102\u0103\7E\2\2\u0103\13\3\2\2\2\u0104"+
		"\u0105\5\u00a8U\2\u0105\u0106\7J\2\2\u0106\u0107\7\30\2\2\u0107\u0108"+
		"\7D\2\2\u0108\u0109\5r:\2\u0109\u010a\7I\2\2\u010a\u010b\5p9\2\u010b\u010c"+
		"\7E\2\2\u010c\r\3\2\2\2\u010d\u010e\5\u00a8U\2\u010e\u010f\7J\2\2\u010f"+
		"\u0110\7\"\2\2\u0110\u0111\7D\2\2\u0111\u0112\5h\65\2\u0112\u0113\7I\2"+
		"\2\u0113\u0114\5\64\33\2\u0114\u0115\7E\2\2\u0115\17\3\2\2\2\u0116\u0117"+
		"\5\u00a8U\2\u0117\u0118\7J\2\2\u0118\u0119\7=\2\2\u0119\u011a\7D\2\2\u011a"+
		"\u011b\5~@\2\u011b\u011c\7I\2\2\u011c\u011d\5\u0080A\2\u011d\u011e\7I"+
		"\2\2\u011e\u011f\5\u0082B\2\u011f\u0120\7E\2\2\u0120\21\3\2\2\2\u0121"+
		"\u0122\5\u00a8U\2\u0122\u0123\7J\2\2\u0123\u0124\7#\2\2\u0124\u0125\7"+
		"D\2\2\u0125\u0126\5\u00b2Z\2\u0126\u0127\7I\2\2\u0127\u0128\5\u0088E\2"+
		"\u0128\u0129\7E\2\2\u0129\23\3\2\2\2\u012a\u012b\5\u00a8U\2\u012b\u012c"+
		"\7J\2\2\u012c\u012d\7$\2\2\u012d\u012e\7D\2\2\u012e\u012f\5h\65\2\u012f"+
		"\u0130\7E\2\2\u0130\25\3\2\2\2\u0131\u0132\5\u00a8U\2\u0132\u0133\7J\2"+
		"\2\u0133\u0134\7%\2\2\u0134\u0135\7D\2\2\u0135\u0136\5b\62\2\u0136\u0137"+
		"\7I\2\2\u0137\u0138\5d\63\2\u0138\u0139\7I\2\2\u0139\u013a\5f\64\2\u013a"+
		"\u013b\7E\2\2\u013b\27\3\2\2\2\u013c\u013d\5\u00a8U\2\u013d\u013e\7J\2"+
		"\2\u013e\u013f\7&\2\2\u013f\u0140\7D\2\2\u0140\u0141\5\u0088E\2\u0141"+
		"\u0142\7E\2\2\u0142\31\3\2\2\2\u0143\u0144\5\u00a8U\2\u0144\u0145\7J\2"+
		"\2\u0145\u0146\7\'\2\2\u0146\u0147\7D\2\2\u0147\u0148\5\u00b2Z\2\u0148"+
		"\u0149\7I\2\2\u0149\u014a\5z>\2\u014a\u014b\7I\2\2\u014b\u014c\5|?\2\u014c"+
		"\u014d\7I\2\2\u014d\u014e\5x=\2\u014e\u014f\7E\2\2\u014f\33\3\2\2\2\u0150"+
		"\u0151\5\u00a8U\2\u0151\u0152\7J\2\2\u0152\u0153\7 \2\2\u0153\u0154\7"+
		"D\2\2\u0154\u0155\5\u00b2Z\2\u0155\u0156\7I\2\2\u0156\u0157\5z>\2\u0157"+
		"\u0158\7I\2\2\u0158\u0159\5|?\2\u0159\u015a\7I\2\2\u015a\u015b\5x=\2\u015b"+
		"\u015c\7E\2\2\u015c\35\3\2\2\2\u015d\u015e\5\u00aaV\2\u015e\u015f\7J\2"+
		"\2\u015f\u0160\7@\2\2\u0160\u0161\7D\2\2\u0161\u0162\5\u00b4[\2\u0162"+
		"\u0163\7E\2\2\u0163\37\3\2\2\2\u0164\u0165\7A\2\2\u0165\u0166\7D\2\2\u0166"+
		"\u016b\5\u00aaV\2\u0167\u0168\7I\2\2\u0168\u016a\5\u009eP\2\u0169\u0167"+
		"\3\2\2\2\u016a\u016d\3\2\2\2\u016b\u0169\3\2\2\2\u016b\u016c\3\2\2\2\u016c"+
		"\u016e\3\2\2\2\u016d\u016b\3\2\2\2\u016e\u016f\7E\2\2\u016f!\3\2\2\2\u0170"+
		"\u0171\5\u0096L\2\u0171\u0172\7J\2\2\u0172\u0173\7+\2\2\u0173\u0174\7"+
		"D\2\2\u0174\u0175\5\u00a8U\2\u0175\u0176\7I\2\2\u0176\u0177\5\u00aeX\2"+
		"\u0177\u0178\7I\2\2\u0178\u0179\5\u00b0Y\2\u0179\u017a\7E\2\2\u017a#\3"+
		"\2\2\2\u017b\u017c\5\u0096L\2\u017c\u017d\7J\2\2\u017d\u017e\7*\2\2\u017e"+
		"\u017f\7D\2\2\u017f\u0180\5\u00a8U\2\u0180\u0181\7I\2\2\u0181\u0182\5"+
		"\u00acW\2\u0182\u0183\7I\2\2\u0183\u0184\5\u0094K\2\u0184\u0185\7I\2\2"+
		"\u0185\u0188\5\u0092J\2\u0186\u0187\7I\2\2\u0187\u0189\5\u0090I\2\u0188"+
		"\u0186\3\2\2\2\u0189\u018a\3\2\2\2\u018a\u0188\3\2\2\2\u018a\u018b\3\2"+
		"\2\2\u018b\u018c\3\2\2\2\u018c\u018d\7E\2\2\u018d%\3\2\2\2\u018e\u018f"+
		"\7:\2\2\u018f\u0190\7D\2\2\u0190\u0191\5\u00a8U\2\u0191\u0194\7I\2\2\u0192"+
		"\u0195\5\u00b0Y\2\u0193\u0195\5\u00b6\\\2\u0194\u0192\3\2\2\2\u0194\u0193"+
		"\3\2\2\2\u0195\u0196\3\2\2\2\u0196\u0197\7E\2\2\u0197\'\3\2\2\2\u0198"+
		"\u0199\5\u00b0Y\2\u0199\u019a\7J\2\2\u019a\u019b\7\62\2\2\u019b\u019c"+
		"\7D\2\2\u019c\u019d\5\u00aaV\2\u019d\u019e\7I\2\2\u019e\u01a1\5\u00a6"+
		"T\2\u019f\u01a0\7I\2\2\u01a0\u01a2\5\u00a0Q\2\u01a1\u019f\3\2\2\2\u01a1"+
		"\u01a2\3\2\2\2\u01a2\u01a3\3\2\2\2\u01a3\u01a4\7E\2\2\u01a4)\3\2\2\2\u01a5"+
		"\u01a6\5\u00aeX\2\u01a6\u01a7\7J\2\2\u01a7\u01a8\7\61\2\2\u01a8\u01a9"+
		"\7D\2\2\u01a9\u01aa\5\u00aaV\2\u01aa\u01ab\7I\2\2\u01ab\u01ae\5\u00a2"+
		"R\2\u01ac\u01ad\7I\2\2\u01ad\u01af\5\u00a0Q\2\u01ae\u01ac\3\2\2\2\u01ae"+
		"\u01af\3\2\2\2\u01af\u01b0\3\2\2\2\u01b0\u01b1\7E\2\2\u01b1+\3\2\2\2\u01b2"+
		"\u01b3\5\u00aeX\2\u01b3\u01b4\7J\2\2\u01b4\u01b5\7,\2\2\u01b5\u01b6\7"+
		"D\2\2\u01b6\u01b7\5\u0098M\2\u01b7\u01b8\7I\2\2\u01b8\u01b9\5\u009aN\2"+
		"\u01b9\u01ba\7I\2\2\u01ba\u01bb\5\u009cO\2\u01bb\u01bc\7E\2\2\u01bc-\3"+
		"\2\2\2\u01bd\u01be\79\2\2\u01be\u01bf\5\u00a4S\2\u01bf/\3\2\2\2\u01c0"+
		"\u01c1\78\2\2\u01c1\61\3\2\2\2\u01c2\u01c3\7\67\2\2\u01c3\u01c4\5\u00a4"+
		"S\2\u01c4\63\3\2\2\2\u01c5\u01c6\t\2\2\2\u01c6\65\3\2\2\2\u01c7\u01c8"+
		"\5\u00b2Z\2\u01c8\u01c9\7J\2\2\u01c9\u01ca\58\35\2\u01ca\67\3\2\2\2\u01cb"+
		"\u01e0\5:\36\2\u01cc\u01e0\5<\37\2\u01cd\u01e0\5> \2\u01ce\u01e0\5@!\2"+
		"\u01cf\u01e0\5B\"\2\u01d0\u01e0\5D#\2\u01d1\u01e0\5F$\2\u01d2\u01e0\5"+
		"H%\2\u01d3\u01e0\5J&\2\u01d4\u01e0\5L\'\2\u01d5\u01e0\5N(\2\u01d6\u01e0"+
		"\5P)\2\u01d7\u01e0\5R*\2\u01d8\u01e0\5T+\2\u01d9\u01e0\5V,\2\u01da\u01e0"+
		"\5X-\2\u01db\u01e0\5Z.\2\u01dc\u01e0\5\\/\2\u01dd\u01e0\5^\60\2\u01de"+
		"\u01e0\5`\61\2\u01df\u01cb\3\2\2\2\u01df\u01cc\3\2\2\2\u01df\u01cd\3\2"+
		"\2\2\u01df\u01ce\3\2\2\2\u01df\u01cf\3\2\2\2\u01df\u01d0\3\2\2\2\u01df"+
		"\u01d1\3\2\2\2\u01df\u01d2\3\2\2\2\u01df\u01d3\3\2\2\2\u01df\u01d4\3\2"+
		"\2\2\u01df\u01d5\3\2\2\2\u01df\u01d6\3\2\2\2\u01df\u01d7\3\2\2\2\u01df"+
		"\u01d8\3\2\2\2\u01df\u01d9\3\2\2\2\u01df\u01da\3\2\2\2\u01df\u01db\3\2"+
		"\2\2\u01df\u01dc\3\2\2\2\u01df\u01dd\3\2\2\2\u01df\u01de\3\2\2\2\u01e0"+
		"9\3\2\2\2\u01e1\u01e2\5\u00b2Z\2\u01e2\u01e3\7J\2\2\u01e3\u01e4\7\3\2"+
		"\2\u01e4\u01e5\7D\2\2\u01e5\u01e6\5\u0084C\2\u01e6\u01e7\7E\2\2\u01e7"+
		";\3\2\2\2\u01e8\u01e9\5\u00b2Z\2\u01e9\u01ea\7J\2\2\u01ea\u01eb\7\4\2"+
		"\2\u01eb\u01ec\7D\2\2\u01ec\u01ed\5\u0084C\2\u01ed\u01ee\7E\2\2\u01ee"+
		"=\3\2\2\2\u01ef\u01f0\5\u00b2Z\2\u01f0\u01f1\7J\2\2\u01f1\u01f2\7\5\2"+
		"\2\u01f2?\3\2\2\2\u01f3\u01f4\5\u00b2Z\2\u01f4\u01f5\7J\2\2\u01f5\u01f6"+
		"\7\6\2\2\u01f6\u01f7\7D\2\2\u01f7\u01f8\5\u0084C\2\u01f8\u01f9\7I\2\2"+
		"\u01f9\u01fa\5\u0086D\2\u01fa\u01fb\7E\2\2\u01fbA\3\2\2\2\u01fc\u01fd"+
		"\5\u00b2Z\2\u01fd\u01fe\7J\2\2\u01fe\u01ff\7\7\2\2\u01ff\u0200\7D\2\2"+
		"\u0200\u0201\5\u008aF\2\u0201\u0202\7I\2\2\u0202\u0203\5\u008cG\2\u0203"+
		"\u0204\7I\2\2\u0204\u0205\5\u008eH\2\u0205\u0206\7E\2\2\u0206C\3\2\2\2"+
		"\u0207\u0208\5\u00b2Z\2\u0208\u0209\7J\2\2\u0209\u020a\7\b\2\2\u020a\u020b"+
		"\7D\2\2\u020b\u020c\5\u008cG\2\u020c\u020d\7I\2\2\u020d\u020e\5\u008e"+
		"H\2\u020e\u020f\7E\2\2\u020fE\3\2\2\2\u0210\u0211\5\u00b2Z\2\u0211\u0212"+
		"\7J\2\2\u0212\u0213\7\t\2\2\u0213\u0214\7D\2\2\u0214\u0215\5\u0084C\2"+
		"\u0215\u0216\7E\2\2\u0216G\3\2\2\2\u0217\u0218\5\u00b2Z\2\u0218\u0219"+
		"\7J\2\2\u0219\u021a\7\n\2\2\u021aI\3\2\2\2\u021b\u021c\5\u00b2Z\2\u021c"+
		"\u021d\7J\2\2\u021d\u021e\7\13\2\2\u021e\u021f\7D\2\2\u021f\u0220\5\u0084"+
		"C\2\u0220\u0221\7E\2\2\u0221K\3\2\2\2\u0222\u0223\5\u00b2Z\2\u0223\u0224"+
		"\7J\2\2\u0224\u0225\7\f\2\2\u0225\u0226\7D\2\2\u0226\u0227\5\u0084C\2"+
		"\u0227\u0228\7E\2\2\u0228M\3\2\2\2\u0229\u022a\5\u00b2Z\2\u022a\u022b"+
		"\7J\2\2\u022b\u022c\7\r\2\2\u022cO\3\2\2\2\u022d\u022e\5\u00b2Z\2\u022e"+
		"\u022f\7J\2\2\u022f\u0230\7\16\2\2\u0230\u0231\7D\2\2\u0231\u0232\5\u008a"+
		"F\2\u0232\u0233\7I\2\2\u0233\u0234\5\u008cG\2\u0234\u0235\7I\2\2\u0235"+
		"\u0236\5\u008eH\2\u0236\u0237\7E\2\2\u0237Q\3\2\2\2\u0238\u0239\5\u00b2"+
		"Z\2\u0239\u023a\7J\2\2\u023a\u023b\7\17\2\2\u023b\u023c\7D\2\2\u023c\u023d"+
		"\5\u008cG\2\u023d\u023e\7I\2\2\u023e\u023f\5\u008eH\2\u023f\u0240\7E\2"+
		"\2\u0240S\3\2\2\2\u0241\u0242\5\u00b2Z\2\u0242\u0243\7J\2\2\u0243\u0244"+
		"\7\20\2\2\u0244\u0245\7D\2\2\u0245\u0246\5\u0084C\2\u0246\u0247\7E\2\2"+
		"\u0247U\3\2\2\2\u0248\u0249\5\u00b2Z\2\u0249\u024a\7J\2\2\u024a\u024b"+
		"\7\21\2\2\u024b\u024c\7D\2\2\u024c\u024d\5\u0084C\2\u024d\u024e\7E\2\2"+
		"\u024eW\3\2\2\2\u024f\u0250\5\u00b2Z\2\u0250\u0251\7J\2\2\u0251\u0252"+
		"\7\22\2\2\u0252\u0253\7D\2\2\u0253\u0254\5\u0084C\2\u0254\u0255\7E\2\2"+
		"\u0255Y\3\2\2\2\u0256\u0257\5\u00b2Z\2\u0257\u0258\7J\2\2\u0258\u0259"+
		"\7\23\2\2\u0259[\3\2\2\2\u025a\u025b\5\u00b2Z\2\u025b\u025c\7J\2\2\u025c"+
		"\u025d\7\24\2\2\u025d\u025e\7D\2\2\u025e\u025f\5\u008aF\2\u025f\u0260"+
		"\7I\2\2\u0260\u0261\5\u008cG\2\u0261\u0262\7I\2\2\u0262\u0263\5\u008e"+
		"H\2\u0263\u0264\7E\2\2\u0264]\3\2\2\2\u0265\u0266\5\u00b2Z\2\u0266\u0267"+
		"\7J\2\2\u0267\u0268\7\25\2\2\u0268\u0269\7D\2\2\u0269\u026a\5\u008cG\2"+
		"\u026a\u026b\7I\2\2\u026b\u026c\5\u008eH\2\u026c\u026d\7E\2\2\u026d_\3"+
		"\2\2\2\u026e\u026f\5\u00b2Z\2\u026f\u0270\7J\2\2\u0270\u0271\7\26\2\2"+
		"\u0271\u0272\7D\2\2\u0272\u0273\5\u0084C\2\u0273\u0274\7E\2\2\u0274a\3"+
		"\2\2\2\u0275\u0276\7M\2\2\u0276c\3\2\2\2\u0277\u0278\7M\2\2\u0278e\3\2"+
		"\2\2\u0279\u027a\7M\2\2\u027ag\3\2\2\2\u027b\u027c\7M\2\2\u027ci\3\2\2"+
		"\2\u027d\u027e\7M\2\2\u027ek\3\2\2\2\u027f\u0280\7M\2\2\u0280m\3\2\2\2"+
		"\u0281\u0282\7M\2\2\u0282o\3\2\2\2\u0283\u0284\7M\2\2\u0284q\3\2\2\2\u0285"+
		"\u0286\7M\2\2\u0286s\3\2\2\2\u0287\u0288\7M\2\2\u0288u\3\2\2\2\u0289\u028a"+
		"\7M\2\2\u028aw\3\2\2\2\u028b\u028c\7M\2\2\u028cy\3\2\2\2\u028d\u028e\7"+
		"M\2\2\u028e{\3\2\2\2\u028f\u0290\7M\2\2\u0290}\3\2\2\2\u0291\u0292\7M"+
		"\2\2\u0292\177\3\2\2\2\u0293\u0294\7M\2\2\u0294\u0081\3\2\2\2\u0295\u0296"+
		"\7M\2\2\u0296\u0083\3\2\2\2\u0297\u0298\7M\2\2\u0298\u0085\3\2\2\2\u0299"+
		"\u029a\7M\2\2\u029a\u0087\3\2\2\2\u029b\u029c\7M\2\2\u029c\u0089\3\2\2"+
		"\2\u029d\u029e\7M\2\2\u029e\u008b\3\2\2\2\u029f\u02a0\7M\2\2\u02a0\u008d"+
		"\3\2\2\2\u02a1\u02a2\7M\2\2\u02a2\u008f\3\2\2\2\u02a3\u02a4\7K\2\2\u02a4"+
		"\u0091\3\2\2\2\u02a5\u02a6\7K\2\2\u02a6\u0093\3\2\2\2\u02a7\u02a8\7M\2"+
		"\2\u02a8\u0095\3\2\2\2\u02a9\u02aa\7K\2\2\u02aa\u0097\3\2\2\2\u02ab\u02ac"+
		"\7K\2\2\u02ac\u0099\3\2\2\2\u02ad\u02ae\t\3\2\2\u02ae\u009b\3\2\2\2\u02af"+
		"\u02b0\t\4\2\2\u02b0\u009d\3\2\2\2\u02b1\u02b2\t\5\2\2\u02b2\u009f\3\2"+
		"\2\2\u02b3\u02b4\7B\2\2\u02b4\u02b9\5\u009eP\2\u02b5\u02b6\7I\2\2\u02b6"+
		"\u02b8\5\u009eP\2\u02b7\u02b5\3\2\2\2\u02b8\u02bb\3\2\2\2\u02b9\u02b7"+
		"\3\2\2\2\u02b9\u02ba\3\2\2\2\u02ba\u02bc\3\2\2\2\u02bb\u02b9\3\2\2\2\u02bc"+
		"\u02bd\7C\2\2\u02bd\u00a1\3\2\2\2\u02be\u02bf\7B\2\2\u02bf\u02c4\5\u00a6"+
		"T\2\u02c0\u02c1\7I\2\2\u02c1\u02c3\5\u00a6T\2\u02c2\u02c0\3\2\2\2\u02c3"+
		"\u02c6\3\2\2\2\u02c4\u02c2\3\2\2\2\u02c4\u02c5\3\2\2\2\u02c5\u02c7\3\2"+
		"\2\2\u02c6\u02c4\3\2\2\2\u02c7\u02c8\7C\2\2\u02c8\u00a3\3\2\2\2\u02c9"+
		"\u02ca\7K\2\2\u02ca\u00a5\3\2\2\2\u02cb\u02cc\7K\2\2\u02cc\u00a7\3\2\2"+
		"\2\u02cd\u02ce\7K\2\2\u02ce\u00a9\3\2\2\2\u02cf\u02d0\7K\2\2\u02d0\u00ab"+
		"\3\2\2\2\u02d1\u02d2\7K\2\2\u02d2\u00ad\3\2\2\2\u02d3\u02d4\7K\2\2\u02d4"+
		"\u00af\3\2\2\2\u02d5\u02d6\7K\2\2\u02d6\u00b1\3\2\2\2\u02d7\u02d8\7K\2"+
		"\2\u02d8\u00b3\3\2\2\2\u02d9\u02da\7N\2\2\u02da\u00b5\3\2\2\2\u02db\u02dc"+
		"\7M\2\2\u02dc\u00b7\3\2\2\2\16\u00d0\u00dd\u00ea\u00f7\u016b\u018a\u0194"+
		"\u01a1\u01ae\u01df\u02b9\u02c4";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}