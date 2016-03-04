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
		PMML_LOAD=1, PMML_PREDICT=2, CBIND=3, RBIND=4, NROWS=5, NCOLS=6, T=7, 
		M=8, C=9, HMM=10, GAUSSIANKERNEL=11, LAPLACEKERNEL=12, LINEARKERNEL=13, 
		PEARSONKERNEL=14, POLYNOMIALKERNEL=15, HYPERBOLICTANGENTKERNEL=16, THINPLATEPLINEKERNEL=17, 
		HELLINGERKERNEL=18, SPARSEGAUSSIANKERNEL=19, SPARSELAPLACEKERNEL=20, SPARSELINEARKERNEL=21, 
		SPARSEPOLYNOMIALKERNEL=22, SPARSEHYPERBOLICTANGENTKERNEL=23, SPARSETHINPLATEPLINEKERNEL=24, 
		BINARYSPARSEGAUSSIANKERNEL=25, BINARYSPARSELAPLACEKERNEL=26, BINARYSPARSELINEARKERNEL=27, 
		BINARYSPARSEPOLYNOMIALKERNEL=28, BINARYSPARSEHYPERBOLICTANGENTKERNEL=29, 
		BINARYSPARSETHINPLATEPLINEKERNEL=30, RBF_NETWORK=31, RANDOMFOREST_CLASSIFICATION=32, 
		FLD=33, QDA=34, LDA=35, RDA=36, LOGISTIC_REGRESSION=37, NAIVE_BAYES=38, 
		NEUTRAL_NETWORK=39, KNN=40, DECISIONTREE_CLASSIFICATIONERROR=41, DECISIONTREE=42, 
		GAUSSIANPROCESS=43, REGRESSIONTREE=44, RANDOMFORESTREGRESSION=45, RIDGEREGRESSION=46, 
		SVR=47, ENTROPY=48, GINI=49, DTRAIN=50, TRAIN=51, FFT=52, FORWARD=53, 
		INVERSE=54, STANDARD=55, UNITARY=56, MATRIX=57, VECTOR=58, QUERYARGS=59, 
		MODEL=60, FIELDS=61, REGION=62, RM=63, LS=64, PRINT=65, PREDICT=66, K=67, 
		LAMBDA=68, SVM=69, CP=70, CN=71, QUERY=72, EXECUTE=73, LBRACKET=74, RBRACKET=75, 
		LPAREN=76, RPAREN=77, LBRACE=78, RBRACE=79, DBLQUOTES=80, COMMA=81, EQUALS=82, 
		IDENTIFIER=83, DIGIT=84, NUMBER=85, QUOTEDSTRING=86, WS=87;
	public static final int
		RULE_cmd = 0, RULE_pmmlPredict = 1, RULE_pmmlLoad = 2, RULE_rbind = 3, 
		RULE_cbind = 4, RULE_t = 5, RULE_m = 6, RULE_c = 7, RULE_hmm = 8, RULE_rda = 9, 
		RULE_lda = 10, RULE_qda = 11, RULE_fld = 12, RULE_randomForestClassification = 13, 
		RULE_decisionTree = 14, RULE_svm = 15, RULE_gaussianProcess = 16, RULE_regressionTree = 17, 
		RULE_randomForestRegression = 18, RULE_ridgeRegression = 19, RULE_svr = 20, 
		RULE_knn = 21, RULE_query = 22, RULE_execute = 23, RULE_trainModel = 24, 
		RULE_dtrainModel = 25, RULE_predict = 26, RULE_vector = 27, RULE_matrix = 28, 
		RULE_fft = 29, RULE_print = 30, RULE_ls = 31, RULE_rm = 32, RULE_dtreeSplitRuleVar = 33, 
		RULE_kernel = 34, RULE_mercerkernel = 35, RULE_gaussKernel = 36, RULE_laplaceKernel = 37, 
		RULE_linearKernel = 38, RULE_pearsonKernel = 39, RULE_polyKernel = 40, 
		RULE_hypertangentKernel = 41, RULE_thinplatesplineKernel = 42, RULE_hellingerKernel = 43, 
		RULE_sparsegaussKernel = 44, RULE_sparselaplaceKernel = 45, RULE_sparselinearKernel = 46, 
		RULE_sparsepolyKernel = 47, RULE_sparsehypertangentKernel = 48, RULE_sparsethinplatesplineKernel = 49, 
		RULE_binarysparsegaussKernel = 50, RULE_binarysparselaplaceKernel = 51, 
		RULE_binarysparselinearKernel = 52, RULE_binarysparsepolyKernel = 53, 
		RULE_binarysparsehypertangentKernel = 54, RULE_binarysparsethinplatesplineKernel = 55, 
		RULE_nrowsVar = 56, RULE_ncolsVar = 57, RULE_tVar = 58, RULE_mVar = 59, 
		RULE_sVar = 60, RULE_jVar = 61, RULE_alphaVar = 62, RULE_prioriVar = 63, 
		RULE_lVar = 64, RULE_mtryVar = 65, RULE_ntreesVar = 66, RULE_maxNodesVar = 67, 
		RULE_nodeSizeVar = 68, RULE_tolVar = 69, RULE_epsVar = 70, RULE_cVar = 71, 
		RULE_cpVar = 72, RULE_cnVar = 73, RULE_kVar = 74, RULE_sigmaVar = 75, 
		RULE_omegaVar = 76, RULE_lambdaVar = 77, RULE_degreeVar = 78, RULE_scaleVar = 79, 
		RULE_offsetVar = 80, RULE_filePathVar = 81, RULE_pmmlPredictId = 82, RULE_pmmlId = 83, 
		RULE_hmmId = 84, RULE_hmmPiVectorId = 85, RULE_hmmAMatrixId = 86, RULE_hmmBMatrixId = 87, 
		RULE_hmmSymbolsVectorId = 88, RULE_xFieldName = 89, RULE_yFieldName = 90, 
		RULE_sizeVar = 91, RULE_trainId = 92, RULE_fftInputId = 93, RULE_fftDir = 94, 
		RULE_fftNorm = 95, RULE_queryArg = 96, RULE_queryArgs = 97, RULE_fieldNames = 98, 
		RULE_var = 99, RULE_fieldName = 100, RULE_modelId = 101, RULE_queryId = 102, 
		RULE_regionName = 103, RULE_matrixId = 104, RULE_vectorId = 105, RULE_kernelId = 106, 
		RULE_queryString = 107, RULE_number = 108;
	public static final String[] ruleNames = {
		"cmd", "pmmlPredict", "pmmlLoad", "rbind", "cbind", "t", "m", "c", "hmm", 
		"rda", "lda", "qda", "fld", "randomForestClassification", "decisionTree", 
		"svm", "gaussianProcess", "regressionTree", "randomForestRegression", 
		"ridgeRegression", "svr", "knn", "query", "execute", "trainModel", "dtrainModel", 
		"predict", "vector", "matrix", "fft", "print", "ls", "rm", "dtreeSplitRuleVar", 
		"kernel", "mercerkernel", "gaussKernel", "laplaceKernel", "linearKernel", 
		"pearsonKernel", "polyKernel", "hypertangentKernel", "thinplatesplineKernel", 
		"hellingerKernel", "sparsegaussKernel", "sparselaplaceKernel", "sparselinearKernel", 
		"sparsepolyKernel", "sparsehypertangentKernel", "sparsethinplatesplineKernel", 
		"binarysparsegaussKernel", "binarysparselaplaceKernel", "binarysparselinearKernel", 
		"binarysparsepolyKernel", "binarysparsehypertangentKernel", "binarysparsethinplatesplineKernel", 
		"nrowsVar", "ncolsVar", "tVar", "mVar", "sVar", "jVar", "alphaVar", "prioriVar", 
		"lVar", "mtryVar", "ntreesVar", "maxNodesVar", "nodeSizeVar", "tolVar", 
		"epsVar", "cVar", "cpVar", "cnVar", "kVar", "sigmaVar", "omegaVar", "lambdaVar", 
		"degreeVar", "scaleVar", "offsetVar", "filePathVar", "pmmlPredictId", 
		"pmmlId", "hmmId", "hmmPiVectorId", "hmmAMatrixId", "hmmBMatrixId", "hmmSymbolsVectorId", 
		"xFieldName", "yFieldName", "sizeVar", "trainId", "fftInputId", "fftDir", 
		"fftNorm", "queryArg", "queryArgs", "fieldNames", "var", "fieldName", 
		"modelId", "queryId", "regionName", "matrixId", "vectorId", "kernelId", 
		"queryString", "number"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'pmml.load'", "'pmml.predict'", "'cbind'", "'rbind'", "'nrows'", 
		"'ncols'", "'t'", "'m'", "'c'", "'hmm'", "'gausskernel'", "'laplacekernel'", 
		"'linearkernel'", "'pearsonkernel'", "'polykernel'", "'hypertangentkernel'", 
		"'thinplatesplinekernel'", "'hellingerkernel'", "'sparsegausskernel'", 
		"'sparselaplacekernel'", "'sparselinearkernel'", "'sparsepolykernel'", 
		"'sparsehypertangentkernel'", "'sparsethinplatesplinekernel'", "'binarysparsegausskernel'", 
		"'binarysparselaplacekernel'", "'binarysparselinearkernel'", "'binarysparsepolykernel'", 
		"'binarysparsehypertangentkernel'", "'binarysparsethinplatesplinekernel'", 
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
		null, "PMML_LOAD", "PMML_PREDICT", "CBIND", "RBIND", "NROWS", "NCOLS", 
		"T", "M", "C", "HMM", "GAUSSIANKERNEL", "LAPLACEKERNEL", "LINEARKERNEL", 
		"PEARSONKERNEL", "POLYNOMIALKERNEL", "HYPERBOLICTANGENTKERNEL", "THINPLATEPLINEKERNEL", 
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
		public HmmContext hmm() {
			return getRuleContext(HmmContext.class,0);
		}
		public CContext c() {
			return getRuleContext(CContext.class,0);
		}
		public MContext m() {
			return getRuleContext(MContext.class,0);
		}
		public TContext t() {
			return getRuleContext(TContext.class,0);
		}
		public CbindContext cbind() {
			return getRuleContext(CbindContext.class,0);
		}
		public RbindContext rbind() {
			return getRuleContext(RbindContext.class,0);
		}
		public PmmlLoadContext pmmlLoad() {
			return getRuleContext(PmmlLoadContext.class,0);
		}
		public PmmlPredictContext pmmlPredict() {
			return getRuleContext(PmmlPredictContext.class,0);
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
			setState(250);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(218);
				query();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(219);
				execute();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(220);
				svm();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(221);
				fld();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(222);
				randomForestClassification();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(223);
				decisionTree();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(224);
				qda();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(225);
				lda();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(226);
				rda();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(227);
				gaussianProcess();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(228);
				regressionTree();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(229);
				randomForestRegression();
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(230);
				ridgeRegression();
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(231);
				svr();
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(232);
				kernel();
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 16);
				{
				setState(233);
				trainModel();
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 17);
				{
				setState(234);
				dtrainModel();
				}
				break;
			case 18:
				enterOuterAlt(_localctx, 18);
				{
				setState(235);
				predict();
				}
				break;
			case 19:
				enterOuterAlt(_localctx, 19);
				{
				setState(236);
				print();
				}
				break;
			case 20:
				enterOuterAlt(_localctx, 20);
				{
				setState(237);
				ls();
				}
				break;
			case 21:
				enterOuterAlt(_localctx, 21);
				{
				setState(238);
				rm();
				}
				break;
			case 22:
				enterOuterAlt(_localctx, 22);
				{
				setState(239);
				vector();
				}
				break;
			case 23:
				enterOuterAlt(_localctx, 23);
				{
				setState(240);
				matrix();
				}
				break;
			case 24:
				enterOuterAlt(_localctx, 24);
				{
				setState(241);
				fft();
				}
				break;
			case 25:
				enterOuterAlt(_localctx, 25);
				{
				setState(242);
				hmm();
				}
				break;
			case 26:
				enterOuterAlt(_localctx, 26);
				{
				setState(243);
				c();
				}
				break;
			case 27:
				enterOuterAlt(_localctx, 27);
				{
				setState(244);
				m();
				}
				break;
			case 28:
				enterOuterAlt(_localctx, 28);
				{
				setState(245);
				t();
				}
				break;
			case 29:
				enterOuterAlt(_localctx, 29);
				{
				setState(246);
				cbind();
				}
				break;
			case 30:
				enterOuterAlt(_localctx, 30);
				{
				setState(247);
				rbind();
				}
				break;
			case 31:
				enterOuterAlt(_localctx, 31);
				{
				setState(248);
				pmmlLoad();
				}
				break;
			case 32:
				enterOuterAlt(_localctx, 32);
				{
				setState(249);
				pmmlPredict();
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

	public static class PmmlPredictContext extends ParserRuleContext {
		public PmmlPredictIdContext pmmlPredictId() {
			return getRuleContext(PmmlPredictIdContext.class,0);
		}
		public TerminalNode EQUALS() { return getToken(ShellParser.EQUALS, 0); }
		public TerminalNode PMML_PREDICT() { return getToken(ShellParser.PMML_PREDICT, 0); }
		public TerminalNode LPAREN() { return getToken(ShellParser.LPAREN, 0); }
		public PmmlIdContext pmmlId() {
			return getRuleContext(PmmlIdContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(ShellParser.COMMA, 0); }
		public RegionNameContext regionName() {
			return getRuleContext(RegionNameContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ShellParser.RPAREN, 0); }
		public PmmlPredictContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pmmlPredict; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).enterPmmlPredict(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).exitPmmlPredict(this);
		}
	}

	public final PmmlPredictContext pmmlPredict() throws RecognitionException {
		PmmlPredictContext _localctx = new PmmlPredictContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_pmmlPredict);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(252);
			pmmlPredictId();
			setState(253);
			match(EQUALS);
			setState(254);
			match(PMML_PREDICT);
			setState(255);
			match(LPAREN);
			setState(256);
			pmmlId();
			setState(257);
			match(COMMA);
			setState(258);
			regionName();
			setState(259);
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

	public static class PmmlLoadContext extends ParserRuleContext {
		public PmmlIdContext pmmlId() {
			return getRuleContext(PmmlIdContext.class,0);
		}
		public TerminalNode EQUALS() { return getToken(ShellParser.EQUALS, 0); }
		public TerminalNode PMML_LOAD() { return getToken(ShellParser.PMML_LOAD, 0); }
		public TerminalNode LPAREN() { return getToken(ShellParser.LPAREN, 0); }
		public FilePathVarContext filePathVar() {
			return getRuleContext(FilePathVarContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ShellParser.RPAREN, 0); }
		public PmmlLoadContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pmmlLoad; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).enterPmmlLoad(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).exitPmmlLoad(this);
		}
	}

	public final PmmlLoadContext pmmlLoad() throws RecognitionException {
		PmmlLoadContext _localctx = new PmmlLoadContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_pmmlLoad);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(261);
			pmmlId();
			setState(262);
			match(EQUALS);
			setState(263);
			match(PMML_LOAD);
			setState(264);
			match(LPAREN);
			setState(265);
			filePathVar();
			setState(266);
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

	public static class RbindContext extends ParserRuleContext {
		public List<MatrixIdContext> matrixId() {
			return getRuleContexts(MatrixIdContext.class);
		}
		public MatrixIdContext matrixId(int i) {
			return getRuleContext(MatrixIdContext.class,i);
		}
		public TerminalNode EQUALS() { return getToken(ShellParser.EQUALS, 0); }
		public TerminalNode RBIND() { return getToken(ShellParser.RBIND, 0); }
		public TerminalNode LPAREN() { return getToken(ShellParser.LPAREN, 0); }
		public TerminalNode COMMA() { return getToken(ShellParser.COMMA, 0); }
		public TerminalNode RPAREN() { return getToken(ShellParser.RPAREN, 0); }
		public RbindContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rbind; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).enterRbind(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).exitRbind(this);
		}
	}

	public final RbindContext rbind() throws RecognitionException {
		RbindContext _localctx = new RbindContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_rbind);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(268);
			matrixId();
			setState(269);
			match(EQUALS);
			setState(270);
			match(RBIND);
			setState(271);
			match(LPAREN);
			setState(272);
			matrixId();
			setState(273);
			match(COMMA);
			setState(274);
			matrixId();
			setState(275);
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

	public static class CbindContext extends ParserRuleContext {
		public List<MatrixIdContext> matrixId() {
			return getRuleContexts(MatrixIdContext.class);
		}
		public MatrixIdContext matrixId(int i) {
			return getRuleContext(MatrixIdContext.class,i);
		}
		public TerminalNode EQUALS() { return getToken(ShellParser.EQUALS, 0); }
		public TerminalNode CBIND() { return getToken(ShellParser.CBIND, 0); }
		public TerminalNode LPAREN() { return getToken(ShellParser.LPAREN, 0); }
		public TerminalNode COMMA() { return getToken(ShellParser.COMMA, 0); }
		public TerminalNode RPAREN() { return getToken(ShellParser.RPAREN, 0); }
		public CbindContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cbind; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).enterCbind(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).exitCbind(this);
		}
	}

	public final CbindContext cbind() throws RecognitionException {
		CbindContext _localctx = new CbindContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_cbind);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(277);
			matrixId();
			setState(278);
			match(EQUALS);
			setState(279);
			match(CBIND);
			setState(280);
			match(LPAREN);
			setState(281);
			matrixId();
			setState(282);
			match(COMMA);
			setState(283);
			matrixId();
			setState(284);
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

	public static class TContext extends ParserRuleContext {
		public List<MatrixIdContext> matrixId() {
			return getRuleContexts(MatrixIdContext.class);
		}
		public MatrixIdContext matrixId(int i) {
			return getRuleContext(MatrixIdContext.class,i);
		}
		public TerminalNode EQUALS() { return getToken(ShellParser.EQUALS, 0); }
		public TerminalNode T() { return getToken(ShellParser.T, 0); }
		public TerminalNode LPAREN() { return getToken(ShellParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(ShellParser.RPAREN, 0); }
		public TContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_t; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).enterT(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).exitT(this);
		}
	}

	public final TContext t() throws RecognitionException {
		TContext _localctx = new TContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_t);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(286);
			matrixId();
			setState(287);
			match(EQUALS);
			setState(288);
			match(T);
			setState(289);
			match(LPAREN);
			setState(290);
			matrixId();
			setState(291);
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

	public static class MContext extends ParserRuleContext {
		public MatrixIdContext matrixId() {
			return getRuleContext(MatrixIdContext.class,0);
		}
		public List<TerminalNode> EQUALS() { return getTokens(ShellParser.EQUALS); }
		public TerminalNode EQUALS(int i) {
			return getToken(ShellParser.EQUALS, i);
		}
		public TerminalNode M() { return getToken(ShellParser.M, 0); }
		public List<TerminalNode> LPAREN() { return getTokens(ShellParser.LPAREN); }
		public TerminalNode LPAREN(int i) {
			return getToken(ShellParser.LPAREN, i);
		}
		public TerminalNode C() { return getToken(ShellParser.C, 0); }
		public List<CVarContext> cVar() {
			return getRuleContexts(CVarContext.class);
		}
		public CVarContext cVar(int i) {
			return getRuleContext(CVarContext.class,i);
		}
		public List<TerminalNode> RPAREN() { return getTokens(ShellParser.RPAREN); }
		public TerminalNode RPAREN(int i) {
			return getToken(ShellParser.RPAREN, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ShellParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ShellParser.COMMA, i);
		}
		public TerminalNode NROWS() { return getToken(ShellParser.NROWS, 0); }
		public NrowsVarContext nrowsVar() {
			return getRuleContext(NrowsVarContext.class,0);
		}
		public TerminalNode NCOLS() { return getToken(ShellParser.NCOLS, 0); }
		public NcolsVarContext ncolsVar() {
			return getRuleContext(NcolsVarContext.class,0);
		}
		public MContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_m; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).enterM(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).exitM(this);
		}
	}

	public final MContext m() throws RecognitionException {
		MContext _localctx = new MContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_m);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(293);
			matrixId();
			setState(294);
			match(EQUALS);
			setState(295);
			match(M);
			setState(296);
			match(LPAREN);
			setState(297);
			match(C);
			setState(298);
			match(LPAREN);
			setState(299);
			cVar();
			setState(304);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(300);
				match(COMMA);
				setState(301);
				cVar();
				}
				}
				setState(306);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(307);
			match(RPAREN);
			setState(308);
			match(COMMA);
			setState(309);
			match(NROWS);
			setState(310);
			match(EQUALS);
			setState(311);
			nrowsVar();
			setState(312);
			match(COMMA);
			setState(313);
			match(NCOLS);
			setState(314);
			match(EQUALS);
			setState(315);
			ncolsVar();
			setState(316);
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

	public static class CContext extends ParserRuleContext {
		public VectorIdContext vectorId() {
			return getRuleContext(VectorIdContext.class,0);
		}
		public TerminalNode EQUALS() { return getToken(ShellParser.EQUALS, 0); }
		public TerminalNode C() { return getToken(ShellParser.C, 0); }
		public TerminalNode LPAREN() { return getToken(ShellParser.LPAREN, 0); }
		public List<CVarContext> cVar() {
			return getRuleContexts(CVarContext.class);
		}
		public CVarContext cVar(int i) {
			return getRuleContext(CVarContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(ShellParser.RPAREN, 0); }
		public List<TerminalNode> COMMA() { return getTokens(ShellParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ShellParser.COMMA, i);
		}
		public CContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_c; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).enterC(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).exitC(this);
		}
	}

	public final CContext c() throws RecognitionException {
		CContext _localctx = new CContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_c);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(318);
			vectorId();
			setState(319);
			match(EQUALS);
			setState(320);
			match(C);
			setState(321);
			match(LPAREN);
			setState(322);
			cVar();
			setState(327);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(323);
				match(COMMA);
				setState(324);
				cVar();
				}
				}
				setState(329);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(330);
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

	public static class HmmContext extends ParserRuleContext {
		public HmmIdContext hmmId() {
			return getRuleContext(HmmIdContext.class,0);
		}
		public TerminalNode EQUALS() { return getToken(ShellParser.EQUALS, 0); }
		public TerminalNode HMM() { return getToken(ShellParser.HMM, 0); }
		public TerminalNode LPAREN() { return getToken(ShellParser.LPAREN, 0); }
		public HmmPiVectorIdContext hmmPiVectorId() {
			return getRuleContext(HmmPiVectorIdContext.class,0);
		}
		public List<TerminalNode> COMMA() { return getTokens(ShellParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ShellParser.COMMA, i);
		}
		public HmmAMatrixIdContext hmmAMatrixId() {
			return getRuleContext(HmmAMatrixIdContext.class,0);
		}
		public HmmBMatrixIdContext hmmBMatrixId() {
			return getRuleContext(HmmBMatrixIdContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ShellParser.RPAREN, 0); }
		public HmmSymbolsVectorIdContext hmmSymbolsVectorId() {
			return getRuleContext(HmmSymbolsVectorIdContext.class,0);
		}
		public HmmContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_hmm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).enterHmm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).exitHmm(this);
		}
	}

	public final HmmContext hmm() throws RecognitionException {
		HmmContext _localctx = new HmmContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_hmm);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(332);
			hmmId();
			setState(333);
			match(EQUALS);
			setState(334);
			match(HMM);
			setState(335);
			match(LPAREN);
			setState(336);
			hmmPiVectorId();
			setState(337);
			match(COMMA);
			setState(338);
			hmmAMatrixId();
			setState(339);
			match(COMMA);
			setState(340);
			hmmBMatrixId();
			setState(343);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(341);
				match(COMMA);
				setState(342);
				hmmSymbolsVectorId();
				}
			}

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
		enterRule(_localctx, 18, RULE_rda);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(347);
			modelId();
			setState(348);
			match(EQUALS);
			setState(349);
			match(RDA);
			setState(350);
			match(LPAREN);
			setState(351);
			alphaVar();
			setState(352);
			match(COMMA);
			setState(353);
			tolVar();
			setState(356); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(354);
				match(COMMA);
				setState(355);
				prioriVar();
				}
				}
				setState(358); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==COMMA );
			setState(360);
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
		enterRule(_localctx, 20, RULE_lda);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(362);
			modelId();
			setState(363);
			match(EQUALS);
			setState(364);
			match(LDA);
			setState(365);
			match(LPAREN);
			setState(366);
			tolVar();
			setState(369); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(367);
				match(COMMA);
				setState(368);
				prioriVar();
				}
				}
				setState(371); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==COMMA );
			setState(373);
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
		enterRule(_localctx, 22, RULE_qda);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(375);
			modelId();
			setState(376);
			match(EQUALS);
			setState(377);
			match(QDA);
			setState(378);
			match(LPAREN);
			setState(379);
			tolVar();
			setState(382); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(380);
				match(COMMA);
				setState(381);
				prioriVar();
				}
				}
				setState(384); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==COMMA );
			setState(386);
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
		enterRule(_localctx, 24, RULE_fld);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(388);
			modelId();
			setState(389);
			match(EQUALS);
			setState(390);
			match(FLD);
			setState(391);
			match(LPAREN);
			setState(392);
			lVar();
			setState(393);
			match(COMMA);
			setState(394);
			tolVar();
			setState(395);
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
		enterRule(_localctx, 26, RULE_randomForestClassification);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(397);
			modelId();
			setState(398);
			match(EQUALS);
			setState(399);
			match(RANDOMFOREST_CLASSIFICATION);
			setState(400);
			match(LPAREN);
			setState(401);
			ntreesVar();
			setState(402);
			match(COMMA);
			setState(403);
			mtryVar();
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
		enterRule(_localctx, 28, RULE_decisionTree);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(406);
			modelId();
			setState(407);
			match(EQUALS);
			setState(408);
			match(DECISIONTREE);
			setState(409);
			match(LPAREN);
			setState(410);
			jVar();
			setState(411);
			match(COMMA);
			setState(412);
			dtreeSplitRuleVar();
			setState(413);
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
		enterRule(_localctx, 30, RULE_svm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(415);
			modelId();
			setState(416);
			match(EQUALS);
			setState(417);
			match(SVM);
			setState(418);
			match(LPAREN);
			setState(419);
			cpVar();
			setState(420);
			match(COMMA);
			setState(421);
			cnVar();
			setState(422);
			match(COMMA);
			setState(423);
			kVar();
			setState(424);
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
		enterRule(_localctx, 32, RULE_gaussianProcess);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(426);
			modelId();
			setState(427);
			match(EQUALS);
			setState(428);
			match(GAUSSIANPROCESS);
			setState(429);
			match(LPAREN);
			setState(430);
			kernelId();
			setState(431);
			match(COMMA);
			setState(432);
			lambdaVar();
			setState(433);
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
		enterRule(_localctx, 34, RULE_regressionTree);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(435);
			modelId();
			setState(436);
			match(EQUALS);
			setState(437);
			match(REGRESSIONTREE);
			setState(438);
			match(LPAREN);
			setState(439);
			jVar();
			setState(440);
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
		enterRule(_localctx, 36, RULE_randomForestRegression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(442);
			modelId();
			setState(443);
			match(EQUALS);
			setState(444);
			match(RANDOMFORESTREGRESSION);
			setState(445);
			match(LPAREN);
			setState(446);
			tVar();
			setState(447);
			match(COMMA);
			setState(448);
			mVar();
			setState(449);
			match(COMMA);
			setState(450);
			sVar();
			setState(451);
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
		enterRule(_localctx, 38, RULE_ridgeRegression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(453);
			modelId();
			setState(454);
			match(EQUALS);
			setState(455);
			match(RIDGEREGRESSION);
			setState(456);
			match(LPAREN);
			setState(457);
			lambdaVar();
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
		enterRule(_localctx, 40, RULE_svr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(460);
			modelId();
			setState(461);
			match(EQUALS);
			setState(462);
			match(SVR);
			setState(463);
			match(LPAREN);
			setState(464);
			kernelId();
			setState(465);
			match(COMMA);
			setState(466);
			epsVar();
			setState(467);
			match(COMMA);
			setState(468);
			cVar();
			setState(469);
			match(COMMA);
			setState(470);
			tolVar();
			setState(471);
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
		enterRule(_localctx, 42, RULE_knn);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(473);
			modelId();
			setState(474);
			match(EQUALS);
			setState(475);
			match(KNN);
			setState(476);
			match(LPAREN);
			setState(477);
			kernelId();
			setState(478);
			match(COMMA);
			setState(479);
			epsVar();
			setState(480);
			match(COMMA);
			setState(481);
			cVar();
			setState(482);
			match(COMMA);
			setState(483);
			tolVar();
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
		enterRule(_localctx, 44, RULE_query);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(486);
			queryId();
			setState(487);
			match(EQUALS);
			setState(488);
			match(QUERY);
			setState(489);
			match(LPAREN);
			setState(490);
			queryString();
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
		enterRule(_localctx, 46, RULE_execute);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(493);
			match(EXECUTE);
			setState(494);
			match(LPAREN);
			setState(495);
			queryId();
			setState(500);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(496);
				match(COMMA);
				setState(497);
				queryArg();
				}
				}
				setState(502);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
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
		enterRule(_localctx, 48, RULE_trainModel);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(505);
			trainId();
			setState(506);
			match(EQUALS);
			setState(507);
			match(TRAIN);
			setState(508);
			match(LPAREN);
			setState(509);
			modelId();
			setState(510);
			match(COMMA);
			setState(511);
			matrixId();
			setState(512);
			match(COMMA);
			setState(513);
			vectorId();
			setState(514);
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
		enterRule(_localctx, 50, RULE_dtrainModel);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(516);
			trainId();
			setState(517);
			match(EQUALS);
			setState(518);
			match(DTRAIN);
			setState(519);
			match(LPAREN);
			setState(520);
			modelId();
			setState(521);
			match(COMMA);
			setState(522);
			regionName();
			setState(523);
			match(COMMA);
			setState(524);
			sizeVar();
			setState(525);
			match(COMMA);
			setState(526);
			yFieldName();
			setState(529); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(527);
				match(COMMA);
				setState(528);
				xFieldName();
				}
				}
				setState(531); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==COMMA );
			setState(533);
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
		enterRule(_localctx, 52, RULE_predict);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(535);
			match(PREDICT);
			setState(536);
			match(LPAREN);
			setState(537);
			modelId();
			setState(538);
			match(COMMA);
			setState(541);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				{
				setState(539);
				vectorId();
				}
				break;
			case NUMBER:
				{
				setState(540);
				number();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(543);
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
		enterRule(_localctx, 54, RULE_vector);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(545);
			vectorId();
			setState(546);
			match(EQUALS);
			setState(547);
			match(VECTOR);
			setState(548);
			match(LPAREN);
			setState(549);
			queryId();
			setState(550);
			match(COMMA);
			setState(551);
			fieldName();
			setState(554);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(552);
				match(COMMA);
				setState(553);
				queryArgs();
				}
			}

			setState(556);
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
		enterRule(_localctx, 56, RULE_matrix);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(558);
			matrixId();
			setState(559);
			match(EQUALS);
			setState(560);
			match(MATRIX);
			setState(561);
			match(LPAREN);
			setState(562);
			queryId();
			setState(563);
			match(COMMA);
			setState(564);
			fieldNames();
			setState(567);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(565);
				match(COMMA);
				setState(566);
				queryArgs();
				}
			}

			setState(569);
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
		enterRule(_localctx, 58, RULE_fft);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(571);
			matrixId();
			setState(572);
			match(EQUALS);
			setState(573);
			match(FFT);
			setState(574);
			match(LPAREN);
			setState(575);
			fftInputId();
			setState(576);
			match(COMMA);
			setState(577);
			fftDir();
			setState(578);
			match(COMMA);
			setState(579);
			fftNorm();
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
		enterRule(_localctx, 60, RULE_print);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(582);
			match(PRINT);
			setState(583);
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
		enterRule(_localctx, 62, RULE_ls);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(585);
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
		enterRule(_localctx, 64, RULE_rm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(587);
			match(RM);
			setState(588);
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
		enterRule(_localctx, 66, RULE_dtreeSplitRuleVar);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(590);
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
		enterRule(_localctx, 68, RULE_kernel);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(592);
			kernelId();
			setState(593);
			match(EQUALS);
			setState(594);
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
		enterRule(_localctx, 70, RULE_mercerkernel);
		try {
			setState(616);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(596);
				gaussKernel();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(597);
				laplaceKernel();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(598);
				linearKernel();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(599);
				pearsonKernel();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(600);
				polyKernel();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(601);
				hypertangentKernel();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(602);
				thinplatesplineKernel();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(603);
				hellingerKernel();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(604);
				sparsegaussKernel();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(605);
				sparselaplaceKernel();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(606);
				sparselinearKernel();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(607);
				sparsepolyKernel();
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(608);
				sparsehypertangentKernel();
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(609);
				sparsethinplatesplineKernel();
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(610);
				binarysparsegaussKernel();
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 16);
				{
				setState(611);
				binarysparselaplaceKernel();
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 17);
				{
				setState(612);
				binarysparselinearKernel();
				}
				break;
			case 18:
				enterOuterAlt(_localctx, 18);
				{
				setState(613);
				binarysparsepolyKernel();
				}
				break;
			case 19:
				enterOuterAlt(_localctx, 19);
				{
				setState(614);
				binarysparsehypertangentKernel();
				}
				break;
			case 20:
				enterOuterAlt(_localctx, 20);
				{
				setState(615);
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
		enterRule(_localctx, 72, RULE_gaussKernel);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(618);
			kernelId();
			setState(619);
			match(EQUALS);
			setState(620);
			match(GAUSSIANKERNEL);
			setState(621);
			match(LPAREN);
			setState(622);
			sigmaVar();
			setState(623);
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
		enterRule(_localctx, 74, RULE_laplaceKernel);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(625);
			kernelId();
			setState(626);
			match(EQUALS);
			setState(627);
			match(LAPLACEKERNEL);
			setState(628);
			match(LPAREN);
			setState(629);
			sigmaVar();
			setState(630);
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
		enterRule(_localctx, 76, RULE_linearKernel);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(632);
			kernelId();
			setState(633);
			match(EQUALS);
			setState(634);
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
		enterRule(_localctx, 78, RULE_pearsonKernel);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(636);
			kernelId();
			setState(637);
			match(EQUALS);
			setState(638);
			match(PEARSONKERNEL);
			setState(639);
			match(LPAREN);
			setState(640);
			sigmaVar();
			setState(641);
			match(COMMA);
			setState(642);
			omegaVar();
			setState(643);
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
		enterRule(_localctx, 80, RULE_polyKernel);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(645);
			kernelId();
			setState(646);
			match(EQUALS);
			setState(647);
			match(POLYNOMIALKERNEL);
			setState(648);
			match(LPAREN);
			setState(649);
			degreeVar();
			setState(650);
			match(COMMA);
			setState(651);
			scaleVar();
			setState(652);
			match(COMMA);
			setState(653);
			offsetVar();
			setState(654);
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
		enterRule(_localctx, 82, RULE_hypertangentKernel);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(656);
			kernelId();
			setState(657);
			match(EQUALS);
			setState(658);
			match(HYPERBOLICTANGENTKERNEL);
			setState(659);
			match(LPAREN);
			setState(660);
			scaleVar();
			setState(661);
			match(COMMA);
			setState(662);
			offsetVar();
			setState(663);
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
		enterRule(_localctx, 84, RULE_thinplatesplineKernel);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(665);
			kernelId();
			setState(666);
			match(EQUALS);
			setState(667);
			match(THINPLATEPLINEKERNEL);
			setState(668);
			match(LPAREN);
			setState(669);
			sigmaVar();
			setState(670);
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
		enterRule(_localctx, 86, RULE_hellingerKernel);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(672);
			kernelId();
			setState(673);
			match(EQUALS);
			setState(674);
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
		enterRule(_localctx, 88, RULE_sparsegaussKernel);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(676);
			kernelId();
			setState(677);
			match(EQUALS);
			setState(678);
			match(SPARSEGAUSSIANKERNEL);
			setState(679);
			match(LPAREN);
			setState(680);
			sigmaVar();
			setState(681);
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
		enterRule(_localctx, 90, RULE_sparselaplaceKernel);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(683);
			kernelId();
			setState(684);
			match(EQUALS);
			setState(685);
			match(SPARSELAPLACEKERNEL);
			setState(686);
			match(LPAREN);
			setState(687);
			sigmaVar();
			setState(688);
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
		enterRule(_localctx, 92, RULE_sparselinearKernel);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(690);
			kernelId();
			setState(691);
			match(EQUALS);
			setState(692);
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
		enterRule(_localctx, 94, RULE_sparsepolyKernel);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(694);
			kernelId();
			setState(695);
			match(EQUALS);
			setState(696);
			match(SPARSEPOLYNOMIALKERNEL);
			setState(697);
			match(LPAREN);
			setState(698);
			degreeVar();
			setState(699);
			match(COMMA);
			setState(700);
			scaleVar();
			setState(701);
			match(COMMA);
			setState(702);
			offsetVar();
			setState(703);
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
		enterRule(_localctx, 96, RULE_sparsehypertangentKernel);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(705);
			kernelId();
			setState(706);
			match(EQUALS);
			setState(707);
			match(SPARSEHYPERBOLICTANGENTKERNEL);
			setState(708);
			match(LPAREN);
			setState(709);
			scaleVar();
			setState(710);
			match(COMMA);
			setState(711);
			offsetVar();
			setState(712);
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
		enterRule(_localctx, 98, RULE_sparsethinplatesplineKernel);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(714);
			kernelId();
			setState(715);
			match(EQUALS);
			setState(716);
			match(SPARSETHINPLATEPLINEKERNEL);
			setState(717);
			match(LPAREN);
			setState(718);
			sigmaVar();
			setState(719);
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
		enterRule(_localctx, 100, RULE_binarysparsegaussKernel);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(721);
			kernelId();
			setState(722);
			match(EQUALS);
			setState(723);
			match(BINARYSPARSEGAUSSIANKERNEL);
			setState(724);
			match(LPAREN);
			setState(725);
			sigmaVar();
			setState(726);
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
		enterRule(_localctx, 102, RULE_binarysparselaplaceKernel);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(728);
			kernelId();
			setState(729);
			match(EQUALS);
			setState(730);
			match(BINARYSPARSELAPLACEKERNEL);
			setState(731);
			match(LPAREN);
			setState(732);
			sigmaVar();
			setState(733);
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
		enterRule(_localctx, 104, RULE_binarysparselinearKernel);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(735);
			kernelId();
			setState(736);
			match(EQUALS);
			setState(737);
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
		enterRule(_localctx, 106, RULE_binarysparsepolyKernel);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(739);
			kernelId();
			setState(740);
			match(EQUALS);
			setState(741);
			match(BINARYSPARSEPOLYNOMIALKERNEL);
			setState(742);
			match(LPAREN);
			setState(743);
			degreeVar();
			setState(744);
			match(COMMA);
			setState(745);
			scaleVar();
			setState(746);
			match(COMMA);
			setState(747);
			offsetVar();
			setState(748);
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
		enterRule(_localctx, 108, RULE_binarysparsehypertangentKernel);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(750);
			kernelId();
			setState(751);
			match(EQUALS);
			setState(752);
			match(BINARYSPARSEHYPERBOLICTANGENTKERNEL);
			setState(753);
			match(LPAREN);
			setState(754);
			scaleVar();
			setState(755);
			match(COMMA);
			setState(756);
			offsetVar();
			setState(757);
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
		enterRule(_localctx, 110, RULE_binarysparsethinplatesplineKernel);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(759);
			kernelId();
			setState(760);
			match(EQUALS);
			setState(761);
			match(BINARYSPARSETHINPLATEPLINEKERNEL);
			setState(762);
			match(LPAREN);
			setState(763);
			sigmaVar();
			setState(764);
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

	public static class NrowsVarContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(ShellParser.NUMBER, 0); }
		public NrowsVarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nrowsVar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).enterNrowsVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).exitNrowsVar(this);
		}
	}

	public final NrowsVarContext nrowsVar() throws RecognitionException {
		NrowsVarContext _localctx = new NrowsVarContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_nrowsVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(766);
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

	public static class NcolsVarContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(ShellParser.NUMBER, 0); }
		public NcolsVarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ncolsVar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).enterNcolsVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).exitNcolsVar(this);
		}
	}

	public final NcolsVarContext ncolsVar() throws RecognitionException {
		NcolsVarContext _localctx = new NcolsVarContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_ncolsVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(768);
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
		enterRule(_localctx, 116, RULE_tVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(770);
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
		enterRule(_localctx, 118, RULE_mVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(772);
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
		enterRule(_localctx, 120, RULE_sVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(774);
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
		enterRule(_localctx, 122, RULE_jVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(776);
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
		enterRule(_localctx, 124, RULE_alphaVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(778);
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
		enterRule(_localctx, 126, RULE_prioriVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(780);
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
		enterRule(_localctx, 128, RULE_lVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(782);
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
		enterRule(_localctx, 130, RULE_mtryVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(784);
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
		enterRule(_localctx, 132, RULE_ntreesVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(786);
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
		enterRule(_localctx, 134, RULE_maxNodesVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(788);
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
		enterRule(_localctx, 136, RULE_nodeSizeVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(790);
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
		enterRule(_localctx, 138, RULE_tolVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(792);
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
		enterRule(_localctx, 140, RULE_epsVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(794);
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
		enterRule(_localctx, 142, RULE_cVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(796);
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
		enterRule(_localctx, 144, RULE_cpVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(798);
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
		enterRule(_localctx, 146, RULE_cnVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(800);
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
		enterRule(_localctx, 148, RULE_kVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(802);
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
		enterRule(_localctx, 150, RULE_sigmaVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(804);
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
		enterRule(_localctx, 152, RULE_omegaVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(806);
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
		enterRule(_localctx, 154, RULE_lambdaVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(808);
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
		enterRule(_localctx, 156, RULE_degreeVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(810);
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
		enterRule(_localctx, 158, RULE_scaleVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(812);
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
		enterRule(_localctx, 160, RULE_offsetVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(814);
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

	public static class FilePathVarContext extends ParserRuleContext {
		public TerminalNode QUOTEDSTRING() { return getToken(ShellParser.QUOTEDSTRING, 0); }
		public FilePathVarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_filePathVar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).enterFilePathVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).exitFilePathVar(this);
		}
	}

	public final FilePathVarContext filePathVar() throws RecognitionException {
		FilePathVarContext _localctx = new FilePathVarContext(_ctx, getState());
		enterRule(_localctx, 162, RULE_filePathVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(816);
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

	public static class PmmlPredictIdContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(ShellParser.IDENTIFIER, 0); }
		public PmmlPredictIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pmmlPredictId; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).enterPmmlPredictId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).exitPmmlPredictId(this);
		}
	}

	public final PmmlPredictIdContext pmmlPredictId() throws RecognitionException {
		PmmlPredictIdContext _localctx = new PmmlPredictIdContext(_ctx, getState());
		enterRule(_localctx, 164, RULE_pmmlPredictId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(818);
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

	public static class PmmlIdContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(ShellParser.IDENTIFIER, 0); }
		public PmmlIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pmmlId; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).enterPmmlId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).exitPmmlId(this);
		}
	}

	public final PmmlIdContext pmmlId() throws RecognitionException {
		PmmlIdContext _localctx = new PmmlIdContext(_ctx, getState());
		enterRule(_localctx, 166, RULE_pmmlId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(820);
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

	public static class HmmIdContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(ShellParser.IDENTIFIER, 0); }
		public HmmIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_hmmId; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).enterHmmId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).exitHmmId(this);
		}
	}

	public final HmmIdContext hmmId() throws RecognitionException {
		HmmIdContext _localctx = new HmmIdContext(_ctx, getState());
		enterRule(_localctx, 168, RULE_hmmId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(822);
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

	public static class HmmPiVectorIdContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(ShellParser.IDENTIFIER, 0); }
		public HmmPiVectorIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_hmmPiVectorId; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).enterHmmPiVectorId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).exitHmmPiVectorId(this);
		}
	}

	public final HmmPiVectorIdContext hmmPiVectorId() throws RecognitionException {
		HmmPiVectorIdContext _localctx = new HmmPiVectorIdContext(_ctx, getState());
		enterRule(_localctx, 170, RULE_hmmPiVectorId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(824);
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

	public static class HmmAMatrixIdContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(ShellParser.IDENTIFIER, 0); }
		public HmmAMatrixIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_hmmAMatrixId; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).enterHmmAMatrixId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).exitHmmAMatrixId(this);
		}
	}

	public final HmmAMatrixIdContext hmmAMatrixId() throws RecognitionException {
		HmmAMatrixIdContext _localctx = new HmmAMatrixIdContext(_ctx, getState());
		enterRule(_localctx, 172, RULE_hmmAMatrixId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(826);
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

	public static class HmmBMatrixIdContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(ShellParser.IDENTIFIER, 0); }
		public HmmBMatrixIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_hmmBMatrixId; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).enterHmmBMatrixId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).exitHmmBMatrixId(this);
		}
	}

	public final HmmBMatrixIdContext hmmBMatrixId() throws RecognitionException {
		HmmBMatrixIdContext _localctx = new HmmBMatrixIdContext(_ctx, getState());
		enterRule(_localctx, 174, RULE_hmmBMatrixId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(828);
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

	public static class HmmSymbolsVectorIdContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(ShellParser.IDENTIFIER, 0); }
		public HmmSymbolsVectorIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_hmmSymbolsVectorId; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).enterHmmSymbolsVectorId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).exitHmmSymbolsVectorId(this);
		}
	}

	public final HmmSymbolsVectorIdContext hmmSymbolsVectorId() throws RecognitionException {
		HmmSymbolsVectorIdContext _localctx = new HmmSymbolsVectorIdContext(_ctx, getState());
		enterRule(_localctx, 176, RULE_hmmSymbolsVectorId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(830);
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
		enterRule(_localctx, 178, RULE_xFieldName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(832);
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
		enterRule(_localctx, 180, RULE_yFieldName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(834);
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
		enterRule(_localctx, 182, RULE_sizeVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(836);
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
		enterRule(_localctx, 184, RULE_trainId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(838);
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
		enterRule(_localctx, 186, RULE_fftInputId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(840);
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
		enterRule(_localctx, 188, RULE_fftDir);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(842);
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
		enterRule(_localctx, 190, RULE_fftNorm);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(844);
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
		enterRule(_localctx, 192, RULE_queryArg);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(846);
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
		enterRule(_localctx, 194, RULE_queryArgs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(848);
			match(LBRACKET);
			setState(849);
			queryArg();
			setState(854);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(850);
				match(COMMA);
				setState(851);
				queryArg();
				}
				}
				setState(856);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(857);
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
		enterRule(_localctx, 196, RULE_fieldNames);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(859);
			match(LBRACKET);
			setState(860);
			fieldName();
			setState(865);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(861);
				match(COMMA);
				setState(862);
				fieldName();
				}
				}
				setState(867);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(868);
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
		enterRule(_localctx, 198, RULE_var);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(870);
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
		enterRule(_localctx, 200, RULE_fieldName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(872);
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
		enterRule(_localctx, 202, RULE_modelId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(874);
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
		enterRule(_localctx, 204, RULE_queryId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(876);
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
		enterRule(_localctx, 206, RULE_regionName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(878);
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
		enterRule(_localctx, 208, RULE_matrixId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(880);
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
		enterRule(_localctx, 210, RULE_vectorId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(882);
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
		enterRule(_localctx, 212, RULE_kernelId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(884);
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
		enterRule(_localctx, 214, RULE_queryString);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(886);
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
		enterRule(_localctx, 216, RULE_number);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(888);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3Y\u037d\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\tT"+
		"\4U\tU\4V\tV\4W\tW\4X\tX\4Y\tY\4Z\tZ\4[\t[\4\\\t\\\4]\t]\4^\t^\4_\t_\4"+
		"`\t`\4a\ta\4b\tb\4c\tc\4d\td\4e\te\4f\tf\4g\tg\4h\th\4i\ti\4j\tj\4k\t"+
		"k\4l\tl\4m\tm\4n\tn\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\5\2\u00fd\n\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\7\b\u0131\n\b\f\b\16\b\u0134\13\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\7\t\u0148\n\t\f\t\16"+
		"\t\u014b\13\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n"+
		"\u015a\n\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\6\13\u0167"+
		"\n\13\r\13\16\13\u0168\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\6\f\u0174"+
		"\n\f\r\f\16\f\u0175\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\6\r\u0181\n\r"+
		"\r\r\16\r\u0182\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3"+
		"\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3"+
		"\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3"+
		"\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3"+
		"\25\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3"+
		"\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3"+
		"\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3"+
		"\31\3\31\3\31\7\31\u01f5\n\31\f\31\16\31\u01f8\13\31\3\31\3\31\3\32\3"+
		"\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3"+
		"\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\6\33\u0214\n\33\r\33\16\33"+
		"\u0215\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\5\34\u0220\n\34\3\34\3"+
		"\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\5\35\u022d\n\35\3\35"+
		"\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\5\36\u023a\n\36\3\36"+
		"\3\36\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3 \3 \3 "+
		"\3!\3!\3\"\3\"\3\"\3#\3#\3$\3$\3$\3$\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%"+
		"\3%\3%\3%\3%\3%\3%\3%\3%\3%\5%\u026b\n%\3&\3&\3&\3&\3&\3&\3&\3\'\3\'\3"+
		"\'\3\'\3\'\3\'\3\'\3(\3(\3(\3(\3)\3)\3)\3)\3)\3)\3)\3)\3)\3*\3*\3*\3*"+
		"\3*\3*\3*\3*\3*\3*\3*\3+\3+\3+\3+\3+\3+\3+\3+\3+\3,\3,\3,\3,\3,\3,\3,"+
		"\3-\3-\3-\3-\3.\3.\3.\3.\3.\3.\3.\3/\3/\3/\3/\3/\3/\3/\3\60\3\60\3\60"+
		"\3\60\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\62\3\62"+
		"\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\63\3\63\3\63\3\63\3\63\3\63\3\63"+
		"\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\65\3\65\3\65\3\65\3\65\3\65\3\65"+
		"\3\66\3\66\3\66\3\66\3\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67\3\67"+
		"\3\67\38\38\38\38\38\38\38\38\38\39\39\39\39\39\39\39\3:\3:\3;\3;\3<\3"+
		"<\3=\3=\3>\3>\3?\3?\3@\3@\3A\3A\3B\3B\3C\3C\3D\3D\3E\3E\3F\3F\3G\3G\3"+
		"H\3H\3I\3I\3J\3J\3K\3K\3L\3L\3M\3M\3N\3N\3O\3O\3P\3P\3Q\3Q\3R\3R\3S\3"+
		"S\3T\3T\3U\3U\3V\3V\3W\3W\3X\3X\3Y\3Y\3Z\3Z\3[\3[\3\\\3\\\3]\3]\3^\3^"+
		"\3_\3_\3`\3`\3a\3a\3b\3b\3c\3c\3c\3c\7c\u0357\nc\fc\16c\u035a\13c\3c\3"+
		"c\3d\3d\3d\3d\7d\u0362\nd\fd\16d\u0365\13d\3d\3d\3e\3e\3f\3f\3g\3g\3h"+
		"\3h\3i\3i\3j\3j\3k\3k\3l\3l\3m\3m\3n\3n\3n\2\2o\2\4\6\b\n\f\16\20\22\24"+
		"\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtv"+
		"xz|~\u0080\u0082\u0084\u0086\u0088\u008a\u008c\u008e\u0090\u0092\u0094"+
		"\u0096\u0098\u009a\u009c\u009e\u00a0\u00a2\u00a4\u00a6\u00a8\u00aa\u00ac"+
		"\u00ae\u00b0\u00b2\u00b4\u00b6\u00b8\u00ba\u00bc\u00be\u00c0\u00c2\u00c4"+
		"\u00c6\u00c8\u00ca\u00cc\u00ce\u00d0\u00d2\u00d4\u00d6\u00d8\u00da\2\6"+
		"\4\2++\62\63\3\2\678\3\29:\3\2WX\u034e\2\u00fc\3\2\2\2\4\u00fe\3\2\2\2"+
		"\6\u0107\3\2\2\2\b\u010e\3\2\2\2\n\u0117\3\2\2\2\f\u0120\3\2\2\2\16\u0127"+
		"\3\2\2\2\20\u0140\3\2\2\2\22\u014e\3\2\2\2\24\u015d\3\2\2\2\26\u016c\3"+
		"\2\2\2\30\u0179\3\2\2\2\32\u0186\3\2\2\2\34\u018f\3\2\2\2\36\u0198\3\2"+
		"\2\2 \u01a1\3\2\2\2\"\u01ac\3\2\2\2$\u01b5\3\2\2\2&\u01bc\3\2\2\2(\u01c7"+
		"\3\2\2\2*\u01ce\3\2\2\2,\u01db\3\2\2\2.\u01e8\3\2\2\2\60\u01ef\3\2\2\2"+
		"\62\u01fb\3\2\2\2\64\u0206\3\2\2\2\66\u0219\3\2\2\28\u0223\3\2\2\2:\u0230"+
		"\3\2\2\2<\u023d\3\2\2\2>\u0248\3\2\2\2@\u024b\3\2\2\2B\u024d\3\2\2\2D"+
		"\u0250\3\2\2\2F\u0252\3\2\2\2H\u026a\3\2\2\2J\u026c\3\2\2\2L\u0273\3\2"+
		"\2\2N\u027a\3\2\2\2P\u027e\3\2\2\2R\u0287\3\2\2\2T\u0292\3\2\2\2V\u029b"+
		"\3\2\2\2X\u02a2\3\2\2\2Z\u02a6\3\2\2\2\\\u02ad\3\2\2\2^\u02b4\3\2\2\2"+
		"`\u02b8\3\2\2\2b\u02c3\3\2\2\2d\u02cc\3\2\2\2f\u02d3\3\2\2\2h\u02da\3"+
		"\2\2\2j\u02e1\3\2\2\2l\u02e5\3\2\2\2n\u02f0\3\2\2\2p\u02f9\3\2\2\2r\u0300"+
		"\3\2\2\2t\u0302\3\2\2\2v\u0304\3\2\2\2x\u0306\3\2\2\2z\u0308\3\2\2\2|"+
		"\u030a\3\2\2\2~\u030c\3\2\2\2\u0080\u030e\3\2\2\2\u0082\u0310\3\2\2\2"+
		"\u0084\u0312\3\2\2\2\u0086\u0314\3\2\2\2\u0088\u0316\3\2\2\2\u008a\u0318"+
		"\3\2\2\2\u008c\u031a\3\2\2\2\u008e\u031c\3\2\2\2\u0090\u031e\3\2\2\2\u0092"+
		"\u0320\3\2\2\2\u0094\u0322\3\2\2\2\u0096\u0324\3\2\2\2\u0098\u0326\3\2"+
		"\2\2\u009a\u0328\3\2\2\2\u009c\u032a\3\2\2\2\u009e\u032c\3\2\2\2\u00a0"+
		"\u032e\3\2\2\2\u00a2\u0330\3\2\2\2\u00a4\u0332\3\2\2\2\u00a6\u0334\3\2"+
		"\2\2\u00a8\u0336\3\2\2\2\u00aa\u0338\3\2\2\2\u00ac\u033a\3\2\2\2\u00ae"+
		"\u033c\3\2\2\2\u00b0\u033e\3\2\2\2\u00b2\u0340\3\2\2\2\u00b4\u0342\3\2"+
		"\2\2\u00b6\u0344\3\2\2\2\u00b8\u0346\3\2\2\2\u00ba\u0348\3\2\2\2\u00bc"+
		"\u034a\3\2\2\2\u00be\u034c\3\2\2\2\u00c0\u034e\3\2\2\2\u00c2\u0350\3\2"+
		"\2\2\u00c4\u0352\3\2\2\2\u00c6\u035d\3\2\2\2\u00c8\u0368\3\2\2\2\u00ca"+
		"\u036a\3\2\2\2\u00cc\u036c\3\2\2\2\u00ce\u036e\3\2\2\2\u00d0\u0370\3\2"+
		"\2\2\u00d2\u0372\3\2\2\2\u00d4\u0374\3\2\2\2\u00d6\u0376\3\2\2\2\u00d8"+
		"\u0378\3\2\2\2\u00da\u037a\3\2\2\2\u00dc\u00fd\5.\30\2\u00dd\u00fd\5\60"+
		"\31\2\u00de\u00fd\5 \21\2\u00df\u00fd\5\32\16\2\u00e0\u00fd\5\34\17\2"+
		"\u00e1\u00fd\5\36\20\2\u00e2\u00fd\5\30\r\2\u00e3\u00fd\5\26\f\2\u00e4"+
		"\u00fd\5\24\13\2\u00e5\u00fd\5\"\22\2\u00e6\u00fd\5$\23\2\u00e7\u00fd"+
		"\5&\24\2\u00e8\u00fd\5(\25\2\u00e9\u00fd\5*\26\2\u00ea\u00fd\5F$\2\u00eb"+
		"\u00fd\5\62\32\2\u00ec\u00fd\5\64\33\2\u00ed\u00fd\5\66\34\2\u00ee\u00fd"+
		"\5> \2\u00ef\u00fd\5@!\2\u00f0\u00fd\5B\"\2\u00f1\u00fd\58\35\2\u00f2"+
		"\u00fd\5:\36\2\u00f3\u00fd\5<\37\2\u00f4\u00fd\5\22\n\2\u00f5\u00fd\5"+
		"\20\t\2\u00f6\u00fd\5\16\b\2\u00f7\u00fd\5\f\7\2\u00f8\u00fd\5\n\6\2\u00f9"+
		"\u00fd\5\b\5\2\u00fa\u00fd\5\6\4\2\u00fb\u00fd\5\4\3\2\u00fc\u00dc\3\2"+
		"\2\2\u00fc\u00dd\3\2\2\2\u00fc\u00de\3\2\2\2\u00fc\u00df\3\2\2\2\u00fc"+
		"\u00e0\3\2\2\2\u00fc\u00e1\3\2\2\2\u00fc\u00e2\3\2\2\2\u00fc\u00e3\3\2"+
		"\2\2\u00fc\u00e4\3\2\2\2\u00fc\u00e5\3\2\2\2\u00fc\u00e6\3\2\2\2\u00fc"+
		"\u00e7\3\2\2\2\u00fc\u00e8\3\2\2\2\u00fc\u00e9\3\2\2\2\u00fc\u00ea\3\2"+
		"\2\2\u00fc\u00eb\3\2\2\2\u00fc\u00ec\3\2\2\2\u00fc\u00ed\3\2\2\2\u00fc"+
		"\u00ee\3\2\2\2\u00fc\u00ef\3\2\2\2\u00fc\u00f0\3\2\2\2\u00fc\u00f1\3\2"+
		"\2\2\u00fc\u00f2\3\2\2\2\u00fc\u00f3\3\2\2\2\u00fc\u00f4\3\2\2\2\u00fc"+
		"\u00f5\3\2\2\2\u00fc\u00f6\3\2\2\2\u00fc\u00f7\3\2\2\2\u00fc\u00f8\3\2"+
		"\2\2\u00fc\u00f9\3\2\2\2\u00fc\u00fa\3\2\2\2\u00fc\u00fb\3\2\2\2\u00fd"+
		"\3\3\2\2\2\u00fe\u00ff\5\u00a6T\2\u00ff\u0100\7T\2\2\u0100\u0101\7\4\2"+
		"\2\u0101\u0102\7N\2\2\u0102\u0103\5\u00a8U\2\u0103\u0104\7S\2\2\u0104"+
		"\u0105\5\u00d0i\2\u0105\u0106\7O\2\2\u0106\5\3\2\2\2\u0107\u0108\5\u00a8"+
		"U\2\u0108\u0109\7T\2\2\u0109\u010a\7\3\2\2\u010a\u010b\7N\2\2\u010b\u010c"+
		"\5\u00a4S\2\u010c\u010d\7O\2\2\u010d\7\3\2\2\2\u010e\u010f\5\u00d2j\2"+
		"\u010f\u0110\7T\2\2\u0110\u0111\7\6\2\2\u0111\u0112\7N\2\2\u0112\u0113"+
		"\5\u00d2j\2\u0113\u0114\7S\2\2\u0114\u0115\5\u00d2j\2\u0115\u0116\7O\2"+
		"\2\u0116\t\3\2\2\2\u0117\u0118\5\u00d2j\2\u0118\u0119\7T\2\2\u0119\u011a"+
		"\7\5\2\2\u011a\u011b\7N\2\2\u011b\u011c\5\u00d2j\2\u011c\u011d\7S\2\2"+
		"\u011d\u011e\5\u00d2j\2\u011e\u011f\7O\2\2\u011f\13\3\2\2\2\u0120\u0121"+
		"\5\u00d2j\2\u0121\u0122\7T\2\2\u0122\u0123\7\t\2\2\u0123\u0124\7N\2\2"+
		"\u0124\u0125\5\u00d2j\2\u0125\u0126\7O\2\2\u0126\r\3\2\2\2\u0127\u0128"+
		"\5\u00d2j\2\u0128\u0129\7T\2\2\u0129\u012a\7\n\2\2\u012a\u012b\7N\2\2"+
		"\u012b\u012c\7\13\2\2\u012c\u012d\7N\2\2\u012d\u0132\5\u0090I\2\u012e"+
		"\u012f\7S\2\2\u012f\u0131\5\u0090I\2\u0130\u012e\3\2\2\2\u0131\u0134\3"+
		"\2\2\2\u0132\u0130\3\2\2\2\u0132\u0133\3\2\2\2\u0133\u0135\3\2\2\2\u0134"+
		"\u0132\3\2\2\2\u0135\u0136\7O\2\2\u0136\u0137\7S\2\2\u0137\u0138\7\7\2"+
		"\2\u0138\u0139\7T\2\2\u0139\u013a\5r:\2\u013a\u013b\7S\2\2\u013b\u013c"+
		"\7\b\2\2\u013c\u013d\7T\2\2\u013d\u013e\5t;\2\u013e\u013f\7O\2\2\u013f"+
		"\17\3\2\2\2\u0140\u0141\5\u00d4k\2\u0141\u0142\7T\2\2\u0142\u0143\7\13"+
		"\2\2\u0143\u0144\7N\2\2\u0144\u0149\5\u0090I\2\u0145\u0146\7S\2\2\u0146"+
		"\u0148\5\u0090I\2\u0147\u0145\3\2\2\2\u0148\u014b\3\2\2\2\u0149\u0147"+
		"\3\2\2\2\u0149\u014a\3\2\2\2\u014a\u014c\3\2\2\2\u014b\u0149\3\2\2\2\u014c"+
		"\u014d\7O\2\2\u014d\21\3\2\2\2\u014e\u014f\5\u00aaV\2\u014f\u0150\7T\2"+
		"\2\u0150\u0151\7\f\2\2\u0151\u0152\7N\2\2\u0152\u0153\5\u00acW\2\u0153"+
		"\u0154\7S\2\2\u0154\u0155\5\u00aeX\2\u0155\u0156\7S\2\2\u0156\u0159\5"+
		"\u00b0Y\2\u0157\u0158\7S\2\2\u0158\u015a\5\u00b2Z\2\u0159\u0157\3\2\2"+
		"\2\u0159\u015a\3\2\2\2\u015a\u015b\3\2\2\2\u015b\u015c\7O\2\2\u015c\23"+
		"\3\2\2\2\u015d\u015e\5\u00ccg\2\u015e\u015f\7T\2\2\u015f\u0160\7&\2\2"+
		"\u0160\u0161\7N\2\2\u0161\u0162\5~@\2\u0162\u0163\7S\2\2\u0163\u0166\5"+
		"\u008cG\2\u0164\u0165\7S\2\2\u0165\u0167\5\u0080A\2\u0166\u0164\3\2\2"+
		"\2\u0167\u0168\3\2\2\2\u0168\u0166\3\2\2\2\u0168\u0169\3\2\2\2\u0169\u016a"+
		"\3\2\2\2\u016a\u016b\7O\2\2\u016b\25\3\2\2\2\u016c\u016d\5\u00ccg\2\u016d"+
		"\u016e\7T\2\2\u016e\u016f\7%\2\2\u016f\u0170\7N\2\2\u0170\u0173\5\u008c"+
		"G\2\u0171\u0172\7S\2\2\u0172\u0174\5\u0080A\2\u0173\u0171\3\2\2\2\u0174"+
		"\u0175\3\2\2\2\u0175\u0173\3\2\2\2\u0175\u0176\3\2\2\2\u0176\u0177\3\2"+
		"\2\2\u0177\u0178\7O\2\2\u0178\27\3\2\2\2\u0179\u017a\5\u00ccg\2\u017a"+
		"\u017b\7T\2\2\u017b\u017c\7$\2\2\u017c\u017d\7N\2\2\u017d\u0180\5\u008c"+
		"G\2\u017e\u017f\7S\2\2\u017f\u0181\5\u0080A\2\u0180\u017e\3\2\2\2\u0181"+
		"\u0182\3\2\2\2\u0182\u0180\3\2\2\2\u0182\u0183\3\2\2\2\u0183\u0184\3\2"+
		"\2\2\u0184\u0185\7O\2\2\u0185\31\3\2\2\2\u0186\u0187\5\u00ccg\2\u0187"+
		"\u0188\7T\2\2\u0188\u0189\7#\2\2\u0189\u018a\7N\2\2\u018a\u018b\5\u0082"+
		"B\2\u018b\u018c\7S\2\2\u018c\u018d\5\u008cG\2\u018d\u018e\7O\2\2\u018e"+
		"\33\3\2\2\2\u018f\u0190\5\u00ccg\2\u0190\u0191\7T\2\2\u0191\u0192\7\""+
		"\2\2\u0192\u0193\7N\2\2\u0193\u0194\5\u0086D\2\u0194\u0195\7S\2\2\u0195"+
		"\u0196\5\u0084C\2\u0196\u0197\7O\2\2\u0197\35\3\2\2\2\u0198\u0199\5\u00cc"+
		"g\2\u0199\u019a\7T\2\2\u019a\u019b\7,\2\2\u019b\u019c\7N\2\2\u019c\u019d"+
		"\5|?\2\u019d\u019e\7S\2\2\u019e\u019f\5D#\2\u019f\u01a0\7O\2\2\u01a0\37"+
		"\3\2\2\2\u01a1\u01a2\5\u00ccg\2\u01a2\u01a3\7T\2\2\u01a3\u01a4\7G\2\2"+
		"\u01a4\u01a5\7N\2\2\u01a5\u01a6\5\u0092J\2\u01a6\u01a7\7S\2\2\u01a7\u01a8"+
		"\5\u0094K\2\u01a8\u01a9\7S\2\2\u01a9\u01aa\5\u0096L\2\u01aa\u01ab\7O\2"+
		"\2\u01ab!\3\2\2\2\u01ac\u01ad\5\u00ccg\2\u01ad\u01ae\7T\2\2\u01ae\u01af"+
		"\7-\2\2\u01af\u01b0\7N\2\2\u01b0\u01b1\5\u00d6l\2\u01b1\u01b2\7S\2\2\u01b2"+
		"\u01b3\5\u009cO\2\u01b3\u01b4\7O\2\2\u01b4#\3\2\2\2\u01b5\u01b6\5\u00cc"+
		"g\2\u01b6\u01b7\7T\2\2\u01b7\u01b8\7.\2\2\u01b8\u01b9\7N\2\2\u01b9\u01ba"+
		"\5|?\2\u01ba\u01bb\7O\2\2\u01bb%\3\2\2\2\u01bc\u01bd\5\u00ccg\2\u01bd"+
		"\u01be\7T\2\2\u01be\u01bf\7/\2\2\u01bf\u01c0\7N\2\2\u01c0\u01c1\5v<\2"+
		"\u01c1\u01c2\7S\2\2\u01c2\u01c3\5x=\2\u01c3\u01c4\7S\2\2\u01c4\u01c5\5"+
		"z>\2\u01c5\u01c6\7O\2\2\u01c6\'\3\2\2\2\u01c7\u01c8\5\u00ccg\2\u01c8\u01c9"+
		"\7T\2\2\u01c9\u01ca\7\60\2\2\u01ca\u01cb\7N\2\2\u01cb\u01cc\5\u009cO\2"+
		"\u01cc\u01cd\7O\2\2\u01cd)\3\2\2\2\u01ce\u01cf\5\u00ccg\2\u01cf\u01d0"+
		"\7T\2\2\u01d0\u01d1\7\61\2\2\u01d1\u01d2\7N\2\2\u01d2\u01d3\5\u00d6l\2"+
		"\u01d3\u01d4\7S\2\2\u01d4\u01d5\5\u008eH\2\u01d5\u01d6\7S\2\2\u01d6\u01d7"+
		"\5\u0090I\2\u01d7\u01d8\7S\2\2\u01d8\u01d9\5\u008cG\2\u01d9\u01da\7O\2"+
		"\2\u01da+\3\2\2\2\u01db\u01dc\5\u00ccg\2\u01dc\u01dd\7T\2\2\u01dd\u01de"+
		"\7*\2\2\u01de\u01df\7N\2\2\u01df\u01e0\5\u00d6l\2\u01e0\u01e1\7S\2\2\u01e1"+
		"\u01e2\5\u008eH\2\u01e2\u01e3\7S\2\2\u01e3\u01e4\5\u0090I\2\u01e4\u01e5"+
		"\7S\2\2\u01e5\u01e6\5\u008cG\2\u01e6\u01e7\7O\2\2\u01e7-\3\2\2\2\u01e8"+
		"\u01e9\5\u00ceh\2\u01e9\u01ea\7T\2\2\u01ea\u01eb\7J\2\2\u01eb\u01ec\7"+
		"N\2\2\u01ec\u01ed\5\u00d8m\2\u01ed\u01ee\7O\2\2\u01ee/\3\2\2\2\u01ef\u01f0"+
		"\7K\2\2\u01f0\u01f1\7N\2\2\u01f1\u01f6\5\u00ceh\2\u01f2\u01f3\7S\2\2\u01f3"+
		"\u01f5\5\u00c2b\2\u01f4\u01f2\3\2\2\2\u01f5\u01f8\3\2\2\2\u01f6\u01f4"+
		"\3\2\2\2\u01f6\u01f7\3\2\2\2\u01f7\u01f9\3\2\2\2\u01f8\u01f6\3\2\2\2\u01f9"+
		"\u01fa\7O\2\2\u01fa\61\3\2\2\2\u01fb\u01fc\5\u00ba^\2\u01fc\u01fd\7T\2"+
		"\2\u01fd\u01fe\7\65\2\2\u01fe\u01ff\7N\2\2\u01ff\u0200\5\u00ccg\2\u0200"+
		"\u0201\7S\2\2\u0201\u0202\5\u00d2j\2\u0202\u0203\7S\2\2\u0203\u0204\5"+
		"\u00d4k\2\u0204\u0205\7O\2\2\u0205\63\3\2\2\2\u0206\u0207\5\u00ba^\2\u0207"+
		"\u0208\7T\2\2\u0208\u0209\7\64\2\2\u0209\u020a\7N\2\2\u020a\u020b\5\u00cc"+
		"g\2\u020b\u020c\7S\2\2\u020c\u020d\5\u00d0i\2\u020d\u020e\7S\2\2\u020e"+
		"\u020f\5\u00b8]\2\u020f\u0210\7S\2\2\u0210\u0213\5\u00b6\\\2\u0211\u0212"+
		"\7S\2\2\u0212\u0214\5\u00b4[\2\u0213\u0211\3\2\2\2\u0214\u0215\3\2\2\2"+
		"\u0215\u0213\3\2\2\2\u0215\u0216\3\2\2\2\u0216\u0217\3\2\2\2\u0217\u0218"+
		"\7O\2\2\u0218\65\3\2\2\2\u0219\u021a\7D\2\2\u021a\u021b\7N\2\2\u021b\u021c"+
		"\5\u00ccg\2\u021c\u021f\7S\2\2\u021d\u0220\5\u00d4k\2\u021e\u0220\5\u00da"+
		"n\2\u021f\u021d\3\2\2\2\u021f\u021e\3\2\2\2\u0220\u0221\3\2\2\2\u0221"+
		"\u0222\7O\2\2\u0222\67\3\2\2\2\u0223\u0224\5\u00d4k\2\u0224\u0225\7T\2"+
		"\2\u0225\u0226\7<\2\2\u0226\u0227\7N\2\2\u0227\u0228\5\u00ceh\2\u0228"+
		"\u0229\7S\2\2\u0229\u022c\5\u00caf\2\u022a\u022b\7S\2\2\u022b\u022d\5"+
		"\u00c4c\2\u022c\u022a\3\2\2\2\u022c\u022d\3\2\2\2\u022d\u022e\3\2\2\2"+
		"\u022e\u022f\7O\2\2\u022f9\3\2\2\2\u0230\u0231\5\u00d2j\2\u0231\u0232"+
		"\7T\2\2\u0232\u0233\7;\2\2\u0233\u0234\7N\2\2\u0234\u0235\5\u00ceh\2\u0235"+
		"\u0236\7S\2\2\u0236\u0239\5\u00c6d\2\u0237\u0238\7S\2\2\u0238\u023a\5"+
		"\u00c4c\2\u0239\u0237\3\2\2\2\u0239\u023a\3\2\2\2\u023a\u023b\3\2\2\2"+
		"\u023b\u023c\7O\2\2\u023c;\3\2\2\2\u023d\u023e\5\u00d2j\2\u023e\u023f"+
		"\7T\2\2\u023f\u0240\7\66\2\2\u0240\u0241\7N\2\2\u0241\u0242\5\u00bc_\2"+
		"\u0242\u0243\7S\2\2\u0243\u0244\5\u00be`\2\u0244\u0245\7S\2\2\u0245\u0246"+
		"\5\u00c0a\2\u0246\u0247\7O\2\2\u0247=\3\2\2\2\u0248\u0249\7C\2\2\u0249"+
		"\u024a\5\u00c8e\2\u024a?\3\2\2\2\u024b\u024c\7B\2\2\u024cA\3\2\2\2\u024d"+
		"\u024e\7A\2\2\u024e\u024f\5\u00c8e\2\u024fC\3\2\2\2\u0250\u0251\t\2\2"+
		"\2\u0251E\3\2\2\2\u0252\u0253\5\u00d6l\2\u0253\u0254\7T\2\2\u0254\u0255"+
		"\5H%\2\u0255G\3\2\2\2\u0256\u026b\5J&\2\u0257\u026b\5L\'\2\u0258\u026b"+
		"\5N(\2\u0259\u026b\5P)\2\u025a\u026b\5R*\2\u025b\u026b\5T+\2\u025c\u026b"+
		"\5V,\2\u025d\u026b\5X-\2\u025e\u026b\5Z.\2\u025f\u026b\5\\/\2\u0260\u026b"+
		"\5^\60\2\u0261\u026b\5`\61\2\u0262\u026b\5b\62\2\u0263\u026b\5d\63\2\u0264"+
		"\u026b\5f\64\2\u0265\u026b\5h\65\2\u0266\u026b\5j\66\2\u0267\u026b\5l"+
		"\67\2\u0268\u026b\5n8\2\u0269\u026b\5p9\2\u026a\u0256\3\2\2\2\u026a\u0257"+
		"\3\2\2\2\u026a\u0258\3\2\2\2\u026a\u0259\3\2\2\2\u026a\u025a\3\2\2\2\u026a"+
		"\u025b\3\2\2\2\u026a\u025c\3\2\2\2\u026a\u025d\3\2\2\2\u026a\u025e\3\2"+
		"\2\2\u026a\u025f\3\2\2\2\u026a\u0260\3\2\2\2\u026a\u0261\3\2\2\2\u026a"+
		"\u0262\3\2\2\2\u026a\u0263\3\2\2\2\u026a\u0264\3\2\2\2\u026a\u0265\3\2"+
		"\2\2\u026a\u0266\3\2\2\2\u026a\u0267\3\2\2\2\u026a\u0268\3\2\2\2\u026a"+
		"\u0269\3\2\2\2\u026bI\3\2\2\2\u026c\u026d\5\u00d6l\2\u026d\u026e\7T\2"+
		"\2\u026e\u026f\7\r\2\2\u026f\u0270\7N\2\2\u0270\u0271\5\u0098M\2\u0271"+
		"\u0272\7O\2\2\u0272K\3\2\2\2\u0273\u0274\5\u00d6l\2\u0274\u0275\7T\2\2"+
		"\u0275\u0276\7\16\2\2\u0276\u0277\7N\2\2\u0277\u0278\5\u0098M\2\u0278"+
		"\u0279\7O\2\2\u0279M\3\2\2\2\u027a\u027b\5\u00d6l\2\u027b\u027c\7T\2\2"+
		"\u027c\u027d\7\17\2\2\u027dO\3\2\2\2\u027e\u027f\5\u00d6l\2\u027f\u0280"+
		"\7T\2\2\u0280\u0281\7\20\2\2\u0281\u0282\7N\2\2\u0282\u0283\5\u0098M\2"+
		"\u0283\u0284\7S\2\2\u0284\u0285\5\u009aN\2\u0285\u0286\7O\2\2\u0286Q\3"+
		"\2\2\2\u0287\u0288\5\u00d6l\2\u0288\u0289\7T\2\2\u0289\u028a\7\21\2\2"+
		"\u028a\u028b\7N\2\2\u028b\u028c\5\u009eP\2\u028c\u028d\7S\2\2\u028d\u028e"+
		"\5\u00a0Q\2\u028e\u028f\7S\2\2\u028f\u0290\5\u00a2R\2\u0290\u0291\7O\2"+
		"\2\u0291S\3\2\2\2\u0292\u0293\5\u00d6l\2\u0293\u0294\7T\2\2\u0294\u0295"+
		"\7\22\2\2\u0295\u0296\7N\2\2\u0296\u0297\5\u00a0Q\2\u0297\u0298\7S\2\2"+
		"\u0298\u0299\5\u00a2R\2\u0299\u029a\7O\2\2\u029aU\3\2\2\2\u029b\u029c"+
		"\5\u00d6l\2\u029c\u029d\7T\2\2\u029d\u029e\7\23\2\2\u029e\u029f\7N\2\2"+
		"\u029f\u02a0\5\u0098M\2\u02a0\u02a1\7O\2\2\u02a1W\3\2\2\2\u02a2\u02a3"+
		"\5\u00d6l\2\u02a3\u02a4\7T\2\2\u02a4\u02a5\7\24\2\2\u02a5Y\3\2\2\2\u02a6"+
		"\u02a7\5\u00d6l\2\u02a7\u02a8\7T\2\2\u02a8\u02a9\7\25\2\2\u02a9\u02aa"+
		"\7N\2\2\u02aa\u02ab\5\u0098M\2\u02ab\u02ac\7O\2\2\u02ac[\3\2\2\2\u02ad"+
		"\u02ae\5\u00d6l\2\u02ae\u02af\7T\2\2\u02af\u02b0\7\26\2\2\u02b0\u02b1"+
		"\7N\2\2\u02b1\u02b2\5\u0098M\2\u02b2\u02b3\7O\2\2\u02b3]\3\2\2\2\u02b4"+
		"\u02b5\5\u00d6l\2\u02b5\u02b6\7T\2\2\u02b6\u02b7\7\27\2\2\u02b7_\3\2\2"+
		"\2\u02b8\u02b9\5\u00d6l\2\u02b9\u02ba\7T\2\2\u02ba\u02bb\7\30\2\2\u02bb"+
		"\u02bc\7N\2\2\u02bc\u02bd\5\u009eP\2\u02bd\u02be\7S\2\2\u02be\u02bf\5"+
		"\u00a0Q\2\u02bf\u02c0\7S\2\2\u02c0\u02c1\5\u00a2R\2\u02c1\u02c2\7O\2\2"+
		"\u02c2a\3\2\2\2\u02c3\u02c4\5\u00d6l\2\u02c4\u02c5\7T\2\2\u02c5\u02c6"+
		"\7\31\2\2\u02c6\u02c7\7N\2\2\u02c7\u02c8\5\u00a0Q\2\u02c8\u02c9\7S\2\2"+
		"\u02c9\u02ca\5\u00a2R\2\u02ca\u02cb\7O\2\2\u02cbc\3\2\2\2\u02cc\u02cd"+
		"\5\u00d6l\2\u02cd\u02ce\7T\2\2\u02ce\u02cf\7\32\2\2\u02cf\u02d0\7N\2\2"+
		"\u02d0\u02d1\5\u0098M\2\u02d1\u02d2\7O\2\2\u02d2e\3\2\2\2\u02d3\u02d4"+
		"\5\u00d6l\2\u02d4\u02d5\7T\2\2\u02d5\u02d6\7\33\2\2\u02d6\u02d7\7N\2\2"+
		"\u02d7\u02d8\5\u0098M\2\u02d8\u02d9\7O\2\2\u02d9g\3\2\2\2\u02da\u02db"+
		"\5\u00d6l\2\u02db\u02dc\7T\2\2\u02dc\u02dd\7\34\2\2\u02dd\u02de\7N\2\2"+
		"\u02de\u02df\5\u0098M\2\u02df\u02e0\7O\2\2\u02e0i\3\2\2\2\u02e1\u02e2"+
		"\5\u00d6l\2\u02e2\u02e3\7T\2\2\u02e3\u02e4\7\35\2\2\u02e4k\3\2\2\2\u02e5"+
		"\u02e6\5\u00d6l\2\u02e6\u02e7\7T\2\2\u02e7\u02e8\7\36\2\2\u02e8\u02e9"+
		"\7N\2\2\u02e9\u02ea\5\u009eP\2\u02ea\u02eb\7S\2\2\u02eb\u02ec\5\u00a0"+
		"Q\2\u02ec\u02ed\7S\2\2\u02ed\u02ee\5\u00a2R\2\u02ee\u02ef\7O\2\2\u02ef"+
		"m\3\2\2\2\u02f0\u02f1\5\u00d6l\2\u02f1\u02f2\7T\2\2\u02f2\u02f3\7\37\2"+
		"\2\u02f3\u02f4\7N\2\2\u02f4\u02f5\5\u00a0Q\2\u02f5\u02f6\7S\2\2\u02f6"+
		"\u02f7\5\u00a2R\2\u02f7\u02f8\7O\2\2\u02f8o\3\2\2\2\u02f9\u02fa\5\u00d6"+
		"l\2\u02fa\u02fb\7T\2\2\u02fb\u02fc\7 \2\2\u02fc\u02fd\7N\2\2\u02fd\u02fe"+
		"\5\u0098M\2\u02fe\u02ff\7O\2\2\u02ffq\3\2\2\2\u0300\u0301\7W\2\2\u0301"+
		"s\3\2\2\2\u0302\u0303\7W\2\2\u0303u\3\2\2\2\u0304\u0305\7W\2\2\u0305w"+
		"\3\2\2\2\u0306\u0307\7W\2\2\u0307y\3\2\2\2\u0308\u0309\7W\2\2\u0309{\3"+
		"\2\2\2\u030a\u030b\7W\2\2\u030b}\3\2\2\2\u030c\u030d\7W\2\2\u030d\177"+
		"\3\2\2\2\u030e\u030f\7W\2\2\u030f\u0081\3\2\2\2\u0310\u0311\7W\2\2\u0311"+
		"\u0083\3\2\2\2\u0312\u0313\7W\2\2\u0313\u0085\3\2\2\2\u0314\u0315\7W\2"+
		"\2\u0315\u0087\3\2\2\2\u0316\u0317\7W\2\2\u0317\u0089\3\2\2\2\u0318\u0319"+
		"\7W\2\2\u0319\u008b\3\2\2\2\u031a\u031b\7W\2\2\u031b\u008d\3\2\2\2\u031c"+
		"\u031d\7W\2\2\u031d\u008f\3\2\2\2\u031e\u031f\7W\2\2\u031f\u0091\3\2\2"+
		"\2\u0320\u0321\7W\2\2\u0321\u0093\3\2\2\2\u0322\u0323\7W\2\2\u0323\u0095"+
		"\3\2\2\2\u0324\u0325\7W\2\2\u0325\u0097\3\2\2\2\u0326\u0327\7W\2\2\u0327"+
		"\u0099\3\2\2\2\u0328\u0329\7W\2\2\u0329\u009b\3\2\2\2\u032a\u032b\7W\2"+
		"\2\u032b\u009d\3\2\2\2\u032c\u032d\7W\2\2\u032d\u009f\3\2\2\2\u032e\u032f"+
		"\7W\2\2\u032f\u00a1\3\2\2\2\u0330\u0331\7W\2\2\u0331\u00a3\3\2\2\2\u0332"+
		"\u0333\7X\2\2\u0333\u00a5\3\2\2\2\u0334\u0335\7U\2\2\u0335\u00a7\3\2\2"+
		"\2\u0336\u0337\7U\2\2\u0337\u00a9\3\2\2\2\u0338\u0339\7U\2\2\u0339\u00ab"+
		"\3\2\2\2\u033a\u033b\7U\2\2\u033b\u00ad\3\2\2\2\u033c\u033d\7U\2\2\u033d"+
		"\u00af\3\2\2\2\u033e\u033f\7U\2\2\u033f\u00b1\3\2\2\2\u0340\u0341\7U\2"+
		"\2\u0341\u00b3\3\2\2\2\u0342\u0343\7U\2\2\u0343\u00b5\3\2\2\2\u0344\u0345"+
		"\7U\2\2\u0345\u00b7\3\2\2\2\u0346\u0347\7W\2\2\u0347\u00b9\3\2\2\2\u0348"+
		"\u0349\7U\2\2\u0349\u00bb\3\2\2\2\u034a\u034b\7U\2\2\u034b\u00bd\3\2\2"+
		"\2\u034c\u034d\t\3\2\2\u034d\u00bf\3\2\2\2\u034e\u034f\t\4\2\2\u034f\u00c1"+
		"\3\2\2\2\u0350\u0351\t\5\2\2\u0351\u00c3\3\2\2\2\u0352\u0353\7L\2\2\u0353"+
		"\u0358\5\u00c2b\2\u0354\u0355\7S\2\2\u0355\u0357\5\u00c2b\2\u0356\u0354"+
		"\3\2\2\2\u0357\u035a\3\2\2\2\u0358\u0356\3\2\2\2\u0358\u0359\3\2\2\2\u0359"+
		"\u035b\3\2\2\2\u035a\u0358\3\2\2\2\u035b\u035c\7M\2\2\u035c\u00c5\3\2"+
		"\2\2\u035d\u035e\7L\2\2\u035e\u0363\5\u00caf\2\u035f\u0360\7S\2\2\u0360"+
		"\u0362\5\u00caf\2\u0361\u035f\3\2\2\2\u0362\u0365\3\2\2\2\u0363\u0361"+
		"\3\2\2\2\u0363\u0364\3\2\2\2\u0364\u0366\3\2\2\2\u0365\u0363\3\2\2\2\u0366"+
		"\u0367\7M\2\2\u0367\u00c7\3\2\2\2\u0368\u0369\7U\2\2\u0369\u00c9\3\2\2"+
		"\2\u036a\u036b\7U\2\2\u036b\u00cb\3\2\2\2\u036c\u036d\7U\2\2\u036d\u00cd"+
		"\3\2\2\2\u036e\u036f\7U\2\2\u036f\u00cf\3\2\2\2\u0370\u0371\7U\2\2\u0371"+
		"\u00d1\3\2\2\2\u0372\u0373\7U\2\2\u0373\u00d3\3\2\2\2\u0374\u0375\7U\2"+
		"\2\u0375\u00d5\3\2\2\2\u0376\u0377\7U\2\2\u0377\u00d7\3\2\2\2\u0378\u0379"+
		"\7X\2\2\u0379\u00d9\3\2\2\2\u037a\u037b\7W\2\2\u037b\u00db\3\2\2\2\21"+
		"\u00fc\u0132\u0149\u0159\u0168\u0175\u0182\u01f6\u0215\u021f\u022c\u0239"+
		"\u026a\u0358\u0363";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}