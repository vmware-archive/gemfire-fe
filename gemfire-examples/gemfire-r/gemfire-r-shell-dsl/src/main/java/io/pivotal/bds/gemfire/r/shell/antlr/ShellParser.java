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
		SVR=47, RSTATS=48, CSTATS=49, VSTATS=50, ENTROPY=51, GINI=52, DTRAIN=53, 
		TRAIN=54, FFT=55, FORWARD=56, INVERSE=57, STANDARD=58, UNITARY=59, MATRIX=60, 
		VECTOR=61, QUERYARGS=62, MODEL=63, FIELDS=64, REGION=65, RM=66, LS=67, 
		PRINT=68, PREDICT=69, K=70, LAMBDA=71, SVM=72, CP=73, CN=74, QUERY=75, 
		EXECUTE=76, LBRACKET=77, RBRACKET=78, LPAREN=79, RPAREN=80, LBRACE=81, 
		RBRACE=82, DBLQUOTES=83, COMMA=84, EQUALS=85, IDENTIFIER=86, FLOAT=87, 
		INTEGER=88, QUOTEDSTRING=89, WS=90;
	public static final int
		RULE_cmd = 0, RULE_rstats = 1, RULE_cstats = 2, RULE_vstats = 3, RULE_pmmlPredict = 4, 
		RULE_pmmlLoad = 5, RULE_rbind = 6, RULE_cbind = 7, RULE_t = 8, RULE_m = 9, 
		RULE_c = 10, RULE_cv = 11, RULE_hmm = 12, RULE_rda = 13, RULE_lda = 14, 
		RULE_qda = 15, RULE_fld = 16, RULE_randomForestClassification = 17, RULE_decisionTree = 18, 
		RULE_svm = 19, RULE_gaussianProcess = 20, RULE_regressionTree = 21, RULE_randomForestRegression = 22, 
		RULE_ridgeRegression = 23, RULE_svr = 24, RULE_knn = 25, RULE_query = 26, 
		RULE_execute = 27, RULE_trainModel = 28, RULE_dtrainModel = 29, RULE_predict = 30, 
		RULE_vector = 31, RULE_matrix = 32, RULE_fft = 33, RULE_print = 34, RULE_ls = 35, 
		RULE_rm = 36, RULE_dtreeSplitRuleVar = 37, RULE_kernel = 38, RULE_gaussKernel = 39, 
		RULE_laplaceKernel = 40, RULE_linearKernel = 41, RULE_pearsonKernel = 42, 
		RULE_polyKernel = 43, RULE_hypertangentKernel = 44, RULE_thinplatesplineKernel = 45, 
		RULE_hellingerKernel = 46, RULE_sparsegaussKernel = 47, RULE_sparselaplaceKernel = 48, 
		RULE_sparselinearKernel = 49, RULE_sparsepolyKernel = 50, RULE_sparsehypertangentKernel = 51, 
		RULE_sparsethinplatesplineKernel = 52, RULE_binarysparsegaussKernel = 53, 
		RULE_binarysparselaplaceKernel = 54, RULE_binarysparselinearKernel = 55, 
		RULE_binarysparsepolyKernel = 56, RULE_binarysparsehypertangentKernel = 57, 
		RULE_binarysparsethinplatesplineKernel = 58, RULE_numeric = 59, RULE_nrowsVar = 60, 
		RULE_ncolsVar = 61, RULE_tVar = 62, RULE_mVar = 63, RULE_sVar = 64, RULE_jVar = 65, 
		RULE_alphaVar = 66, RULE_prioriVar = 67, RULE_lVar = 68, RULE_mtryVar = 69, 
		RULE_ntreesVar = 70, RULE_maxNodesVar = 71, RULE_nodeSizeVar = 72, RULE_colVar = 73, 
		RULE_rowVar = 74, RULE_tolVar = 75, RULE_epsVar = 76, RULE_cVar = 77, 
		RULE_cpVar = 78, RULE_cnVar = 79, RULE_kVar = 80, RULE_sigmaVar = 81, 
		RULE_omegaVar = 82, RULE_lambdaVar = 83, RULE_degreeVar = 84, RULE_scaleVar = 85, 
		RULE_offsetVar = 86, RULE_filePathVar = 87, RULE_pmmlPredictId = 88, RULE_pmmlId = 89, 
		RULE_hmmId = 90, RULE_hmmPiVectorId = 91, RULE_hmmAMatrixId = 92, RULE_hmmBMatrixId = 93, 
		RULE_hmmSymbolsVectorId = 94, RULE_xFieldName = 95, RULE_yFieldName = 96, 
		RULE_sizeVar = 97, RULE_trainId = 98, RULE_fftInputId = 99, RULE_fftDir = 100, 
		RULE_fftNorm = 101, RULE_queryArg = 102, RULE_queryArgs = 103, RULE_fieldNames = 104, 
		RULE_var = 105, RULE_fieldName = 106, RULE_modelId = 107, RULE_queryId = 108, 
		RULE_regionName = 109, RULE_matrixId = 110, RULE_vectorId = 111, RULE_kernelId = 112, 
		RULE_queryString = 113;
	public static final String[] ruleNames = {
		"cmd", "rstats", "cstats", "vstats", "pmmlPredict", "pmmlLoad", "rbind", 
		"cbind", "t", "m", "c", "cv", "hmm", "rda", "lda", "qda", "fld", "randomForestClassification", 
		"decisionTree", "svm", "gaussianProcess", "regressionTree", "randomForestRegression", 
		"ridgeRegression", "svr", "knn", "query", "execute", "trainModel", "dtrainModel", 
		"predict", "vector", "matrix", "fft", "print", "ls", "rm", "dtreeSplitRuleVar", 
		"kernel", "gaussKernel", "laplaceKernel", "linearKernel", "pearsonKernel", 
		"polyKernel", "hypertangentKernel", "thinplatesplineKernel", "hellingerKernel", 
		"sparsegaussKernel", "sparselaplaceKernel", "sparselinearKernel", "sparsepolyKernel", 
		"sparsehypertangentKernel", "sparsethinplatesplineKernel", "binarysparsegaussKernel", 
		"binarysparselaplaceKernel", "binarysparselinearKernel", "binarysparsepolyKernel", 
		"binarysparsehypertangentKernel", "binarysparsethinplatesplineKernel", 
		"numeric", "nrowsVar", "ncolsVar", "tVar", "mVar", "sVar", "jVar", "alphaVar", 
		"prioriVar", "lVar", "mtryVar", "ntreesVar", "maxNodesVar", "nodeSizeVar", 
		"colVar", "rowVar", "tolVar", "epsVar", "cVar", "cpVar", "cnVar", "kVar", 
		"sigmaVar", "omegaVar", "lambdaVar", "degreeVar", "scaleVar", "offsetVar", 
		"filePathVar", "pmmlPredictId", "pmmlId", "hmmId", "hmmPiVectorId", "hmmAMatrixId", 
		"hmmBMatrixId", "hmmSymbolsVectorId", "xFieldName", "yFieldName", "sizeVar", 
		"trainId", "fftInputId", "fftDir", "fftNorm", "queryArg", "queryArgs", 
		"fieldNames", "var", "fieldName", "modelId", "queryId", "regionName", 
		"matrixId", "vectorId", "kernelId", "queryString"
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
		"'rtree'", "'rforestr'", "'ridger'", "'svr'", "'rstats'", "'cstats'", 
		"'vstats'", "'entropy'", "'gini'", "'dtrain'", "'train'", "'fft'", "'forward'", 
		"'inverse'", "'standard'", "'unitary'", "'matrix'", "'vect'", "'queryArgs'", 
		"'model'", "'fields'", "'region'", "'rm'", "'ls'", "'print'", "'predict'", 
		"'k'", "'lambda'", "'svm'", "'cp'", "'cn'", "'query'", "'execute'", "'['", 
		"']'", "'('", "')'", "'{'", "'}'", "'\"'", "','", "'='"
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
		"RSTATS", "CSTATS", "VSTATS", "ENTROPY", "GINI", "DTRAIN", "TRAIN", "FFT", 
		"FORWARD", "INVERSE", "STANDARD", "UNITARY", "MATRIX", "VECTOR", "QUERYARGS", 
		"MODEL", "FIELDS", "REGION", "RM", "LS", "PRINT", "PREDICT", "K", "LAMBDA", 
		"SVM", "CP", "CN", "QUERY", "EXECUTE", "LBRACKET", "RBRACKET", "LPAREN", 
		"RPAREN", "LBRACE", "RBRACE", "DBLQUOTES", "COMMA", "EQUALS", "IDENTIFIER", 
		"FLOAT", "INTEGER", "QUOTEDSTRING", "WS"
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
		public VstatsContext vstats() {
			return getRuleContext(VstatsContext.class,0);
		}
		public CstatsContext cstats() {
			return getRuleContext(CstatsContext.class,0);
		}
		public RstatsContext rstats() {
			return getRuleContext(RstatsContext.class,0);
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
			setState(263);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(228);
				query();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(229);
				execute();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(230);
				svm();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(231);
				fld();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(232);
				randomForestClassification();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(233);
				decisionTree();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(234);
				qda();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(235);
				lda();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(236);
				rda();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(237);
				gaussianProcess();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(238);
				regressionTree();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(239);
				randomForestRegression();
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(240);
				ridgeRegression();
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(241);
				svr();
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(242);
				kernel();
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 16);
				{
				setState(243);
				trainModel();
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 17);
				{
				setState(244);
				dtrainModel();
				}
				break;
			case 18:
				enterOuterAlt(_localctx, 18);
				{
				setState(245);
				predict();
				}
				break;
			case 19:
				enterOuterAlt(_localctx, 19);
				{
				setState(246);
				print();
				}
				break;
			case 20:
				enterOuterAlt(_localctx, 20);
				{
				setState(247);
				ls();
				}
				break;
			case 21:
				enterOuterAlt(_localctx, 21);
				{
				setState(248);
				rm();
				}
				break;
			case 22:
				enterOuterAlt(_localctx, 22);
				{
				setState(249);
				vector();
				}
				break;
			case 23:
				enterOuterAlt(_localctx, 23);
				{
				setState(250);
				matrix();
				}
				break;
			case 24:
				enterOuterAlt(_localctx, 24);
				{
				setState(251);
				fft();
				}
				break;
			case 25:
				enterOuterAlt(_localctx, 25);
				{
				setState(252);
				hmm();
				}
				break;
			case 26:
				enterOuterAlt(_localctx, 26);
				{
				setState(253);
				c();
				}
				break;
			case 27:
				enterOuterAlt(_localctx, 27);
				{
				setState(254);
				m();
				}
				break;
			case 28:
				enterOuterAlt(_localctx, 28);
				{
				setState(255);
				t();
				}
				break;
			case 29:
				enterOuterAlt(_localctx, 29);
				{
				setState(256);
				cbind();
				}
				break;
			case 30:
				enterOuterAlt(_localctx, 30);
				{
				setState(257);
				rbind();
				}
				break;
			case 31:
				enterOuterAlt(_localctx, 31);
				{
				setState(258);
				pmmlLoad();
				}
				break;
			case 32:
				enterOuterAlt(_localctx, 32);
				{
				setState(259);
				pmmlPredict();
				}
				break;
			case 33:
				enterOuterAlt(_localctx, 33);
				{
				setState(260);
				vstats();
				}
				break;
			case 34:
				enterOuterAlt(_localctx, 34);
				{
				setState(261);
				cstats();
				}
				break;
			case 35:
				enterOuterAlt(_localctx, 35);
				{
				setState(262);
				rstats();
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

	public static class RstatsContext extends ParserRuleContext {
		public TerminalNode RSTATS() { return getToken(ShellParser.RSTATS, 0); }
		public TerminalNode LPAREN() { return getToken(ShellParser.LPAREN, 0); }
		public MatrixIdContext matrixId() {
			return getRuleContext(MatrixIdContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(ShellParser.COMMA, 0); }
		public RowVarContext rowVar() {
			return getRuleContext(RowVarContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ShellParser.RPAREN, 0); }
		public RstatsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rstats; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).enterRstats(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).exitRstats(this);
		}
	}

	public final RstatsContext rstats() throws RecognitionException {
		RstatsContext _localctx = new RstatsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_rstats);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(265);
			match(RSTATS);
			setState(266);
			match(LPAREN);
			setState(267);
			matrixId();
			setState(268);
			match(COMMA);
			setState(269);
			rowVar();
			setState(270);
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

	public static class CstatsContext extends ParserRuleContext {
		public TerminalNode CSTATS() { return getToken(ShellParser.CSTATS, 0); }
		public TerminalNode LPAREN() { return getToken(ShellParser.LPAREN, 0); }
		public MatrixIdContext matrixId() {
			return getRuleContext(MatrixIdContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(ShellParser.COMMA, 0); }
		public ColVarContext colVar() {
			return getRuleContext(ColVarContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ShellParser.RPAREN, 0); }
		public CstatsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cstats; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).enterCstats(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).exitCstats(this);
		}
	}

	public final CstatsContext cstats() throws RecognitionException {
		CstatsContext _localctx = new CstatsContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_cstats);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(272);
			match(CSTATS);
			setState(273);
			match(LPAREN);
			setState(274);
			matrixId();
			setState(275);
			match(COMMA);
			setState(276);
			colVar();
			setState(277);
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

	public static class VstatsContext extends ParserRuleContext {
		public TerminalNode VSTATS() { return getToken(ShellParser.VSTATS, 0); }
		public TerminalNode LPAREN() { return getToken(ShellParser.LPAREN, 0); }
		public VectorIdContext vectorId() {
			return getRuleContext(VectorIdContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ShellParser.RPAREN, 0); }
		public VstatsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vstats; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).enterVstats(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).exitVstats(this);
		}
	}

	public final VstatsContext vstats() throws RecognitionException {
		VstatsContext _localctx = new VstatsContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_vstats);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(279);
			match(VSTATS);
			setState(280);
			match(LPAREN);
			setState(281);
			vectorId();
			setState(282);
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
		enterRule(_localctx, 8, RULE_pmmlPredict);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(284);
			pmmlPredictId();
			setState(285);
			match(EQUALS);
			setState(286);
			match(PMML_PREDICT);
			setState(287);
			match(LPAREN);
			setState(288);
			pmmlId();
			setState(289);
			match(COMMA);
			setState(290);
			regionName();
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
		enterRule(_localctx, 10, RULE_pmmlLoad);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(293);
			pmmlId();
			setState(294);
			match(EQUALS);
			setState(295);
			match(PMML_LOAD);
			setState(296);
			match(LPAREN);
			setState(297);
			filePathVar();
			setState(298);
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
		public VectorIdContext vectorId() {
			return getRuleContext(VectorIdContext.class,0);
		}
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
		enterRule(_localctx, 12, RULE_rbind);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(300);
			matrixId();
			setState(301);
			match(EQUALS);
			setState(302);
			match(RBIND);
			setState(303);
			match(LPAREN);
			setState(304);
			matrixId();
			setState(305);
			match(COMMA);
			setState(306);
			vectorId();
			setState(307);
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
		public VectorIdContext vectorId() {
			return getRuleContext(VectorIdContext.class,0);
		}
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
		enterRule(_localctx, 14, RULE_cbind);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(309);
			matrixId();
			setState(310);
			match(EQUALS);
			setState(311);
			match(CBIND);
			setState(312);
			match(LPAREN);
			setState(313);
			matrixId();
			setState(314);
			match(COMMA);
			setState(315);
			vectorId();
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
		enterRule(_localctx, 16, RULE_t);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(318);
			matrixId();
			setState(319);
			match(EQUALS);
			setState(320);
			match(T);
			setState(321);
			match(LPAREN);
			setState(322);
			matrixId();
			setState(323);
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
		public TerminalNode EQUALS() { return getToken(ShellParser.EQUALS, 0); }
		public TerminalNode M() { return getToken(ShellParser.M, 0); }
		public TerminalNode LPAREN() { return getToken(ShellParser.LPAREN, 0); }
		public CvContext cv() {
			return getRuleContext(CvContext.class,0);
		}
		public List<TerminalNode> COMMA() { return getTokens(ShellParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ShellParser.COMMA, i);
		}
		public NrowsVarContext nrowsVar() {
			return getRuleContext(NrowsVarContext.class,0);
		}
		public NcolsVarContext ncolsVar() {
			return getRuleContext(NcolsVarContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ShellParser.RPAREN, 0); }
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
		enterRule(_localctx, 18, RULE_m);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(325);
			matrixId();
			setState(326);
			match(EQUALS);
			setState(327);
			match(M);
			setState(328);
			match(LPAREN);
			setState(329);
			cv();
			setState(330);
			match(COMMA);
			setState(331);
			nrowsVar();
			setState(332);
			match(COMMA);
			setState(333);
			ncolsVar();
			setState(334);
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
		public CvContext cv() {
			return getRuleContext(CvContext.class,0);
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
		enterRule(_localctx, 20, RULE_c);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(336);
			vectorId();
			setState(337);
			match(EQUALS);
			setState(338);
			cv();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CvContext extends ParserRuleContext {
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
		public CvContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cv; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).enterCv(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).exitCv(this);
		}
	}

	public final CvContext cv() throws RecognitionException {
		CvContext _localctx = new CvContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_cv);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(340);
			match(C);
			setState(341);
			match(LPAREN);
			setState(342);
			cVar();
			setState(347);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(343);
				match(COMMA);
				setState(344);
				cVar();
				}
				}
				setState(349);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(350);
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
		enterRule(_localctx, 24, RULE_hmm);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(352);
			hmmId();
			setState(353);
			match(EQUALS);
			setState(354);
			match(HMM);
			setState(355);
			match(LPAREN);
			setState(356);
			hmmPiVectorId();
			setState(357);
			match(COMMA);
			setState(358);
			hmmAMatrixId();
			setState(359);
			match(COMMA);
			setState(360);
			hmmBMatrixId();
			setState(363);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(361);
				match(COMMA);
				setState(362);
				hmmSymbolsVectorId();
				}
			}

			setState(365);
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
		enterRule(_localctx, 26, RULE_rda);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(367);
			modelId();
			setState(368);
			match(EQUALS);
			setState(369);
			match(RDA);
			setState(370);
			match(LPAREN);
			setState(371);
			alphaVar();
			setState(372);
			match(COMMA);
			setState(373);
			tolVar();
			setState(376); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(374);
				match(COMMA);
				setState(375);
				prioriVar();
				}
				}
				setState(378); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==COMMA );
			setState(380);
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
		enterRule(_localctx, 28, RULE_lda);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(382);
			modelId();
			setState(383);
			match(EQUALS);
			setState(384);
			match(LDA);
			setState(385);
			match(LPAREN);
			setState(386);
			tolVar();
			setState(389); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(387);
				match(COMMA);
				setState(388);
				prioriVar();
				}
				}
				setState(391); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==COMMA );
			setState(393);
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
		enterRule(_localctx, 30, RULE_qda);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(395);
			modelId();
			setState(396);
			match(EQUALS);
			setState(397);
			match(QDA);
			setState(398);
			match(LPAREN);
			setState(399);
			tolVar();
			setState(402); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(400);
				match(COMMA);
				setState(401);
				prioriVar();
				}
				}
				setState(404); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==COMMA );
			setState(406);
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
		enterRule(_localctx, 32, RULE_fld);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(408);
			modelId();
			setState(409);
			match(EQUALS);
			setState(410);
			match(FLD);
			setState(411);
			match(LPAREN);
			setState(412);
			lVar();
			setState(413);
			match(COMMA);
			setState(414);
			tolVar();
			setState(415);
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
		enterRule(_localctx, 34, RULE_randomForestClassification);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(417);
			modelId();
			setState(418);
			match(EQUALS);
			setState(419);
			match(RANDOMFOREST_CLASSIFICATION);
			setState(420);
			match(LPAREN);
			setState(421);
			ntreesVar();
			setState(422);
			match(COMMA);
			setState(423);
			mtryVar();
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
		enterRule(_localctx, 36, RULE_decisionTree);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(426);
			modelId();
			setState(427);
			match(EQUALS);
			setState(428);
			match(DECISIONTREE);
			setState(429);
			match(LPAREN);
			setState(430);
			jVar();
			setState(431);
			match(COMMA);
			setState(432);
			dtreeSplitRuleVar();
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
		enterRule(_localctx, 38, RULE_svm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(435);
			modelId();
			setState(436);
			match(EQUALS);
			setState(437);
			match(SVM);
			setState(438);
			match(LPAREN);
			setState(439);
			cpVar();
			setState(440);
			match(COMMA);
			setState(441);
			cnVar();
			setState(442);
			match(COMMA);
			setState(443);
			kVar();
			setState(444);
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
		enterRule(_localctx, 40, RULE_gaussianProcess);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(446);
			modelId();
			setState(447);
			match(EQUALS);
			setState(448);
			match(GAUSSIANPROCESS);
			setState(449);
			match(LPAREN);
			setState(450);
			kernelId();
			setState(451);
			match(COMMA);
			setState(452);
			lambdaVar();
			setState(453);
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
		enterRule(_localctx, 42, RULE_regressionTree);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(455);
			modelId();
			setState(456);
			match(EQUALS);
			setState(457);
			match(REGRESSIONTREE);
			setState(458);
			match(LPAREN);
			setState(459);
			jVar();
			setState(460);
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
		enterRule(_localctx, 44, RULE_randomForestRegression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(462);
			modelId();
			setState(463);
			match(EQUALS);
			setState(464);
			match(RANDOMFORESTREGRESSION);
			setState(465);
			match(LPAREN);
			setState(466);
			tVar();
			setState(467);
			match(COMMA);
			setState(468);
			mVar();
			setState(469);
			match(COMMA);
			setState(470);
			sVar();
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
		enterRule(_localctx, 46, RULE_ridgeRegression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(473);
			modelId();
			setState(474);
			match(EQUALS);
			setState(475);
			match(RIDGEREGRESSION);
			setState(476);
			match(LPAREN);
			setState(477);
			lambdaVar();
			setState(478);
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
		enterRule(_localctx, 48, RULE_svr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(480);
			modelId();
			setState(481);
			match(EQUALS);
			setState(482);
			match(SVR);
			setState(483);
			match(LPAREN);
			setState(484);
			kernelId();
			setState(485);
			match(COMMA);
			setState(486);
			epsVar();
			setState(487);
			match(COMMA);
			setState(488);
			cVar();
			setState(489);
			match(COMMA);
			setState(490);
			tolVar();
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
		enterRule(_localctx, 50, RULE_knn);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(493);
			modelId();
			setState(494);
			match(EQUALS);
			setState(495);
			match(KNN);
			setState(496);
			match(LPAREN);
			setState(497);
			kernelId();
			setState(498);
			match(COMMA);
			setState(499);
			epsVar();
			setState(500);
			match(COMMA);
			setState(501);
			cVar();
			setState(502);
			match(COMMA);
			setState(503);
			tolVar();
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
		enterRule(_localctx, 52, RULE_query);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(506);
			queryId();
			setState(507);
			match(EQUALS);
			setState(508);
			match(QUERY);
			setState(509);
			match(LPAREN);
			setState(510);
			queryString();
			setState(511);
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
		enterRule(_localctx, 54, RULE_execute);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(513);
			match(EXECUTE);
			setState(514);
			match(LPAREN);
			setState(515);
			queryId();
			setState(520);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(516);
				match(COMMA);
				setState(517);
				queryArg();
				}
				}
				setState(522);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(523);
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
		enterRule(_localctx, 56, RULE_trainModel);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(525);
			trainId();
			setState(526);
			match(EQUALS);
			setState(527);
			match(TRAIN);
			setState(528);
			match(LPAREN);
			setState(529);
			modelId();
			setState(530);
			match(COMMA);
			setState(531);
			matrixId();
			setState(532);
			match(COMMA);
			setState(533);
			vectorId();
			setState(534);
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
		enterRule(_localctx, 58, RULE_dtrainModel);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(536);
			trainId();
			setState(537);
			match(EQUALS);
			setState(538);
			match(DTRAIN);
			setState(539);
			match(LPAREN);
			setState(540);
			modelId();
			setState(541);
			match(COMMA);
			setState(542);
			regionName();
			setState(543);
			match(COMMA);
			setState(544);
			sizeVar();
			setState(545);
			match(COMMA);
			setState(546);
			yFieldName();
			setState(549); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(547);
				match(COMMA);
				setState(548);
				xFieldName();
				}
				}
				setState(551); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==COMMA );
			setState(553);
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
		public NumericContext numeric() {
			return getRuleContext(NumericContext.class,0);
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
		enterRule(_localctx, 60, RULE_predict);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(555);
			match(PREDICT);
			setState(556);
			match(LPAREN);
			setState(557);
			modelId();
			setState(558);
			match(COMMA);
			setState(561);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				{
				setState(559);
				vectorId();
				}
				break;
			case FLOAT:
			case INTEGER:
				{
				setState(560);
				numeric();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(563);
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
		enterRule(_localctx, 62, RULE_vector);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(565);
			vectorId();
			setState(566);
			match(EQUALS);
			setState(567);
			match(VECTOR);
			setState(568);
			match(LPAREN);
			setState(569);
			queryId();
			setState(570);
			match(COMMA);
			setState(571);
			fieldName();
			setState(574);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(572);
				match(COMMA);
				setState(573);
				queryArgs();
				}
			}

			setState(576);
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
		enterRule(_localctx, 64, RULE_matrix);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(578);
			matrixId();
			setState(579);
			match(EQUALS);
			setState(580);
			match(MATRIX);
			setState(581);
			match(LPAREN);
			setState(582);
			queryId();
			setState(583);
			match(COMMA);
			setState(584);
			fieldNames();
			setState(587);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(585);
				match(COMMA);
				setState(586);
				queryArgs();
				}
			}

			setState(589);
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
		enterRule(_localctx, 66, RULE_fft);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(591);
			matrixId();
			setState(592);
			match(EQUALS);
			setState(593);
			match(FFT);
			setState(594);
			match(LPAREN);
			setState(595);
			fftInputId();
			setState(596);
			match(COMMA);
			setState(597);
			fftDir();
			setState(598);
			match(COMMA);
			setState(599);
			fftNorm();
			setState(600);
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
		enterRule(_localctx, 68, RULE_print);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(602);
			match(PRINT);
			setState(603);
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
		enterRule(_localctx, 70, RULE_ls);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(605);
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
		enterRule(_localctx, 72, RULE_rm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(607);
			match(RM);
			setState(608);
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
		enterRule(_localctx, 74, RULE_dtreeSplitRuleVar);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(610);
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
		enterRule(_localctx, 76, RULE_kernel);
		try {
			setState(632);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(612);
				gaussKernel();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(613);
				laplaceKernel();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(614);
				linearKernel();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(615);
				pearsonKernel();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(616);
				polyKernel();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(617);
				hypertangentKernel();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(618);
				thinplatesplineKernel();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(619);
				hellingerKernel();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(620);
				sparsegaussKernel();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(621);
				sparselaplaceKernel();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(622);
				sparselinearKernel();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(623);
				sparsepolyKernel();
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(624);
				sparsehypertangentKernel();
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(625);
				sparsethinplatesplineKernel();
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(626);
				binarysparsegaussKernel();
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 16);
				{
				setState(627);
				binarysparselaplaceKernel();
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 17);
				{
				setState(628);
				binarysparselinearKernel();
				}
				break;
			case 18:
				enterOuterAlt(_localctx, 18);
				{
				setState(629);
				binarysparsepolyKernel();
				}
				break;
			case 19:
				enterOuterAlt(_localctx, 19);
				{
				setState(630);
				binarysparsehypertangentKernel();
				}
				break;
			case 20:
				enterOuterAlt(_localctx, 20);
				{
				setState(631);
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
		enterRule(_localctx, 78, RULE_gaussKernel);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(634);
			kernelId();
			setState(635);
			match(EQUALS);
			setState(636);
			match(GAUSSIANKERNEL);
			setState(637);
			match(LPAREN);
			setState(638);
			sigmaVar();
			setState(639);
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
		enterRule(_localctx, 80, RULE_laplaceKernel);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(641);
			kernelId();
			setState(642);
			match(EQUALS);
			setState(643);
			match(LAPLACEKERNEL);
			setState(644);
			match(LPAREN);
			setState(645);
			sigmaVar();
			setState(646);
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
		enterRule(_localctx, 82, RULE_linearKernel);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(648);
			kernelId();
			setState(649);
			match(EQUALS);
			setState(650);
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
		enterRule(_localctx, 84, RULE_pearsonKernel);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(652);
			kernelId();
			setState(653);
			match(EQUALS);
			setState(654);
			match(PEARSONKERNEL);
			setState(655);
			match(LPAREN);
			setState(656);
			sigmaVar();
			setState(657);
			match(COMMA);
			setState(658);
			omegaVar();
			setState(659);
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
		enterRule(_localctx, 86, RULE_polyKernel);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(661);
			kernelId();
			setState(662);
			match(EQUALS);
			setState(663);
			match(POLYNOMIALKERNEL);
			setState(664);
			match(LPAREN);
			setState(665);
			degreeVar();
			setState(666);
			match(COMMA);
			setState(667);
			scaleVar();
			setState(668);
			match(COMMA);
			setState(669);
			offsetVar();
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
		enterRule(_localctx, 88, RULE_hypertangentKernel);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(672);
			kernelId();
			setState(673);
			match(EQUALS);
			setState(674);
			match(HYPERBOLICTANGENTKERNEL);
			setState(675);
			match(LPAREN);
			setState(676);
			scaleVar();
			setState(677);
			match(COMMA);
			setState(678);
			offsetVar();
			setState(679);
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
		enterRule(_localctx, 90, RULE_thinplatesplineKernel);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(681);
			kernelId();
			setState(682);
			match(EQUALS);
			setState(683);
			match(THINPLATEPLINEKERNEL);
			setState(684);
			match(LPAREN);
			setState(685);
			sigmaVar();
			setState(686);
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
		enterRule(_localctx, 92, RULE_hellingerKernel);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(688);
			kernelId();
			setState(689);
			match(EQUALS);
			setState(690);
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
		enterRule(_localctx, 94, RULE_sparsegaussKernel);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(692);
			kernelId();
			setState(693);
			match(EQUALS);
			setState(694);
			match(SPARSEGAUSSIANKERNEL);
			setState(695);
			match(LPAREN);
			setState(696);
			sigmaVar();
			setState(697);
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
		enterRule(_localctx, 96, RULE_sparselaplaceKernel);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(699);
			kernelId();
			setState(700);
			match(EQUALS);
			setState(701);
			match(SPARSELAPLACEKERNEL);
			setState(702);
			match(LPAREN);
			setState(703);
			sigmaVar();
			setState(704);
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
		enterRule(_localctx, 98, RULE_sparselinearKernel);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(706);
			kernelId();
			setState(707);
			match(EQUALS);
			setState(708);
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
		enterRule(_localctx, 100, RULE_sparsepolyKernel);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(710);
			kernelId();
			setState(711);
			match(EQUALS);
			setState(712);
			match(SPARSEPOLYNOMIALKERNEL);
			setState(713);
			match(LPAREN);
			setState(714);
			degreeVar();
			setState(715);
			match(COMMA);
			setState(716);
			scaleVar();
			setState(717);
			match(COMMA);
			setState(718);
			offsetVar();
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
		enterRule(_localctx, 102, RULE_sparsehypertangentKernel);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(721);
			kernelId();
			setState(722);
			match(EQUALS);
			setState(723);
			match(SPARSEHYPERBOLICTANGENTKERNEL);
			setState(724);
			match(LPAREN);
			setState(725);
			scaleVar();
			setState(726);
			match(COMMA);
			setState(727);
			offsetVar();
			setState(728);
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
		enterRule(_localctx, 104, RULE_sparsethinplatesplineKernel);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(730);
			kernelId();
			setState(731);
			match(EQUALS);
			setState(732);
			match(SPARSETHINPLATEPLINEKERNEL);
			setState(733);
			match(LPAREN);
			setState(734);
			sigmaVar();
			setState(735);
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
		enterRule(_localctx, 106, RULE_binarysparsegaussKernel);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(737);
			kernelId();
			setState(738);
			match(EQUALS);
			setState(739);
			match(BINARYSPARSEGAUSSIANKERNEL);
			setState(740);
			match(LPAREN);
			setState(741);
			sigmaVar();
			setState(742);
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
		enterRule(_localctx, 108, RULE_binarysparselaplaceKernel);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(744);
			kernelId();
			setState(745);
			match(EQUALS);
			setState(746);
			match(BINARYSPARSELAPLACEKERNEL);
			setState(747);
			match(LPAREN);
			setState(748);
			sigmaVar();
			setState(749);
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
		enterRule(_localctx, 110, RULE_binarysparselinearKernel);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(751);
			kernelId();
			setState(752);
			match(EQUALS);
			setState(753);
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
		enterRule(_localctx, 112, RULE_binarysparsepolyKernel);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(755);
			kernelId();
			setState(756);
			match(EQUALS);
			setState(757);
			match(BINARYSPARSEPOLYNOMIALKERNEL);
			setState(758);
			match(LPAREN);
			setState(759);
			degreeVar();
			setState(760);
			match(COMMA);
			setState(761);
			scaleVar();
			setState(762);
			match(COMMA);
			setState(763);
			offsetVar();
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
		enterRule(_localctx, 114, RULE_binarysparsehypertangentKernel);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(766);
			kernelId();
			setState(767);
			match(EQUALS);
			setState(768);
			match(BINARYSPARSEHYPERBOLICTANGENTKERNEL);
			setState(769);
			match(LPAREN);
			setState(770);
			scaleVar();
			setState(771);
			match(COMMA);
			setState(772);
			offsetVar();
			setState(773);
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
		enterRule(_localctx, 116, RULE_binarysparsethinplatesplineKernel);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(775);
			kernelId();
			setState(776);
			match(EQUALS);
			setState(777);
			match(BINARYSPARSETHINPLATEPLINEKERNEL);
			setState(778);
			match(LPAREN);
			setState(779);
			sigmaVar();
			setState(780);
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

	public static class NumericContext extends ParserRuleContext {
		public TerminalNode FLOAT() { return getToken(ShellParser.FLOAT, 0); }
		public TerminalNode INTEGER() { return getToken(ShellParser.INTEGER, 0); }
		public NumericContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numeric; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).enterNumeric(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).exitNumeric(this);
		}
	}

	public final NumericContext numeric() throws RecognitionException {
		NumericContext _localctx = new NumericContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_numeric);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(782);
			_la = _input.LA(1);
			if ( !(_la==FLOAT || _la==INTEGER) ) {
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

	public static class NrowsVarContext extends ParserRuleContext {
		public TerminalNode INTEGER() { return getToken(ShellParser.INTEGER, 0); }
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
		enterRule(_localctx, 120, RULE_nrowsVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(784);
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

	public static class NcolsVarContext extends ParserRuleContext {
		public TerminalNode INTEGER() { return getToken(ShellParser.INTEGER, 0); }
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
		enterRule(_localctx, 122, RULE_ncolsVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(786);
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

	public static class TVarContext extends ParserRuleContext {
		public NumericContext numeric() {
			return getRuleContext(NumericContext.class,0);
		}
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
		enterRule(_localctx, 124, RULE_tVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(788);
			numeric();
			}
		}
		catch (RecognitionException re) {
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
		public NumericContext numeric() {
			return getRuleContext(NumericContext.class,0);
		}
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
		enterRule(_localctx, 126, RULE_mVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(790);
			numeric();
			}
		}
		catch (RecognitionException re) {
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
		public NumericContext numeric() {
			return getRuleContext(NumericContext.class,0);
		}
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
		enterRule(_localctx, 128, RULE_sVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(792);
			numeric();
			}
		}
		catch (RecognitionException re) {
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
		public NumericContext numeric() {
			return getRuleContext(NumericContext.class,0);
		}
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
		enterRule(_localctx, 130, RULE_jVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(794);
			numeric();
			}
		}
		catch (RecognitionException re) {
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
		public NumericContext numeric() {
			return getRuleContext(NumericContext.class,0);
		}
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
		enterRule(_localctx, 132, RULE_alphaVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(796);
			numeric();
			}
		}
		catch (RecognitionException re) {
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
		public NumericContext numeric() {
			return getRuleContext(NumericContext.class,0);
		}
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
		enterRule(_localctx, 134, RULE_prioriVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(798);
			numeric();
			}
		}
		catch (RecognitionException re) {
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
		public NumericContext numeric() {
			return getRuleContext(NumericContext.class,0);
		}
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
		enterRule(_localctx, 136, RULE_lVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(800);
			numeric();
			}
		}
		catch (RecognitionException re) {
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
		public NumericContext numeric() {
			return getRuleContext(NumericContext.class,0);
		}
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
		enterRule(_localctx, 138, RULE_mtryVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(802);
			numeric();
			}
		}
		catch (RecognitionException re) {
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
		public NumericContext numeric() {
			return getRuleContext(NumericContext.class,0);
		}
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
		enterRule(_localctx, 140, RULE_ntreesVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(804);
			numeric();
			}
		}
		catch (RecognitionException re) {
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
		public NumericContext numeric() {
			return getRuleContext(NumericContext.class,0);
		}
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
		enterRule(_localctx, 142, RULE_maxNodesVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(806);
			numeric();
			}
		}
		catch (RecognitionException re) {
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
		public NumericContext numeric() {
			return getRuleContext(NumericContext.class,0);
		}
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
		enterRule(_localctx, 144, RULE_nodeSizeVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(808);
			numeric();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ColVarContext extends ParserRuleContext {
		public TerminalNode INTEGER() { return getToken(ShellParser.INTEGER, 0); }
		public ColVarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_colVar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).enterColVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).exitColVar(this);
		}
	}

	public final ColVarContext colVar() throws RecognitionException {
		ColVarContext _localctx = new ColVarContext(_ctx, getState());
		enterRule(_localctx, 146, RULE_colVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(810);
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

	public static class RowVarContext extends ParserRuleContext {
		public TerminalNode INTEGER() { return getToken(ShellParser.INTEGER, 0); }
		public RowVarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rowVar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).enterRowVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ShellListener ) ((ShellListener)listener).exitRowVar(this);
		}
	}

	public final RowVarContext rowVar() throws RecognitionException {
		RowVarContext _localctx = new RowVarContext(_ctx, getState());
		enterRule(_localctx, 148, RULE_rowVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(812);
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

	public static class TolVarContext extends ParserRuleContext {
		public NumericContext numeric() {
			return getRuleContext(NumericContext.class,0);
		}
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
		enterRule(_localctx, 150, RULE_tolVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(814);
			numeric();
			}
		}
		catch (RecognitionException re) {
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
		public NumericContext numeric() {
			return getRuleContext(NumericContext.class,0);
		}
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
		enterRule(_localctx, 152, RULE_epsVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(816);
			numeric();
			}
		}
		catch (RecognitionException re) {
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
		public TerminalNode QUOTEDSTRING() { return getToken(ShellParser.QUOTEDSTRING, 0); }
		public NumericContext numeric() {
			return getRuleContext(NumericContext.class,0);
		}
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
		enterRule(_localctx, 154, RULE_cVar);
		try {
			setState(820);
			switch (_input.LA(1)) {
			case QUOTEDSTRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(818);
				match(QUOTEDSTRING);
				}
				break;
			case FLOAT:
			case INTEGER:
				enterOuterAlt(_localctx, 2);
				{
				setState(819);
				numeric();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
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
		public NumericContext numeric() {
			return getRuleContext(NumericContext.class,0);
		}
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
		enterRule(_localctx, 156, RULE_cpVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(822);
			numeric();
			}
		}
		catch (RecognitionException re) {
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
		public NumericContext numeric() {
			return getRuleContext(NumericContext.class,0);
		}
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
		enterRule(_localctx, 158, RULE_cnVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(824);
			numeric();
			}
		}
		catch (RecognitionException re) {
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
		public NumericContext numeric() {
			return getRuleContext(NumericContext.class,0);
		}
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
		enterRule(_localctx, 160, RULE_kVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(826);
			numeric();
			}
		}
		catch (RecognitionException re) {
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
		public NumericContext numeric() {
			return getRuleContext(NumericContext.class,0);
		}
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
		enterRule(_localctx, 162, RULE_sigmaVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(828);
			numeric();
			}
		}
		catch (RecognitionException re) {
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
		public NumericContext numeric() {
			return getRuleContext(NumericContext.class,0);
		}
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
		enterRule(_localctx, 164, RULE_omegaVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(830);
			numeric();
			}
		}
		catch (RecognitionException re) {
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
		public NumericContext numeric() {
			return getRuleContext(NumericContext.class,0);
		}
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
		enterRule(_localctx, 166, RULE_lambdaVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(832);
			numeric();
			}
		}
		catch (RecognitionException re) {
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
		public NumericContext numeric() {
			return getRuleContext(NumericContext.class,0);
		}
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
		enterRule(_localctx, 168, RULE_degreeVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(834);
			numeric();
			}
		}
		catch (RecognitionException re) {
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
		public NumericContext numeric() {
			return getRuleContext(NumericContext.class,0);
		}
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
		enterRule(_localctx, 170, RULE_scaleVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(836);
			numeric();
			}
		}
		catch (RecognitionException re) {
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
		public NumericContext numeric() {
			return getRuleContext(NumericContext.class,0);
		}
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
		enterRule(_localctx, 172, RULE_offsetVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(838);
			numeric();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 174, RULE_filePathVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(840);
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
		enterRule(_localctx, 176, RULE_pmmlPredictId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(842);
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
		enterRule(_localctx, 178, RULE_pmmlId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(844);
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
		enterRule(_localctx, 180, RULE_hmmId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(846);
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
		enterRule(_localctx, 182, RULE_hmmPiVectorId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(848);
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
		enterRule(_localctx, 184, RULE_hmmAMatrixId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(850);
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
		enterRule(_localctx, 186, RULE_hmmBMatrixId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(852);
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
		enterRule(_localctx, 188, RULE_hmmSymbolsVectorId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(854);
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
		enterRule(_localctx, 190, RULE_xFieldName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(856);
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
		enterRule(_localctx, 192, RULE_yFieldName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(858);
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
		public NumericContext numeric() {
			return getRuleContext(NumericContext.class,0);
		}
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
		enterRule(_localctx, 194, RULE_sizeVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(860);
			numeric();
			}
		}
		catch (RecognitionException re) {
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
		enterRule(_localctx, 196, RULE_trainId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(862);
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
		enterRule(_localctx, 198, RULE_fftInputId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(864);
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
		enterRule(_localctx, 200, RULE_fftDir);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(866);
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
		enterRule(_localctx, 202, RULE_fftNorm);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(868);
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
		public TerminalNode FLOAT() { return getToken(ShellParser.FLOAT, 0); }
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
		enterRule(_localctx, 204, RULE_queryArg);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(870);
			_la = _input.LA(1);
			if ( !(((((_la - 87)) & ~0x3f) == 0 && ((1L << (_la - 87)) & ((1L << (FLOAT - 87)) | (1L << (INTEGER - 87)) | (1L << (QUOTEDSTRING - 87)))) != 0)) ) {
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
		enterRule(_localctx, 206, RULE_queryArgs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(872);
			match(LBRACKET);
			setState(873);
			queryArg();
			setState(878);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(874);
				match(COMMA);
				setState(875);
				queryArg();
				}
				}
				setState(880);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(881);
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
		enterRule(_localctx, 208, RULE_fieldNames);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(883);
			match(LBRACKET);
			setState(884);
			fieldName();
			setState(889);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(885);
				match(COMMA);
				setState(886);
				fieldName();
				}
				}
				setState(891);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(892);
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
		enterRule(_localctx, 210, RULE_var);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(894);
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
		enterRule(_localctx, 212, RULE_fieldName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(896);
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
		enterRule(_localctx, 214, RULE_modelId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(898);
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
		enterRule(_localctx, 216, RULE_queryId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(900);
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
		enterRule(_localctx, 218, RULE_regionName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(902);
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
		enterRule(_localctx, 220, RULE_matrixId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(904);
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
		enterRule(_localctx, 222, RULE_vectorId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(906);
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
		enterRule(_localctx, 224, RULE_kernelId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(908);
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
		enterRule(_localctx, 226, RULE_queryString);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(910);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\\\u0393\4\2\t\2\4"+
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
		"k\4l\tl\4m\tm\4n\tn\4o\to\4p\tp\4q\tq\4r\tr\4s\ts\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2\u010a\n\2\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\7\r\u015c\n\r\f\r\16\r"+
		"\u015f\13\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\5\16\u016e\n\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\6\17\u017b\n\17\r\17\16\17\u017c\3\17\3\17\3\20\3\20\3\20\3\20\3"+
		"\20\3\20\3\20\6\20\u0188\n\20\r\20\16\20\u0189\3\20\3\20\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\6\21\u0195\n\21\r\21\16\21\u0196\3\21\3\21\3\22\3"+
		"\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3"+
		"\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3"+
		"\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3"+
		"\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3"+
		"\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3"+
		"\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3"+
		"\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\34\3"+
		"\34\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\7\35\u0209\n\35"+
		"\f\35\16\35\u020c\13\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3"+
		"\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3"+
		"\37\3\37\3\37\6\37\u0228\n\37\r\37\16\37\u0229\3\37\3\37\3 \3 \3 \3 \3"+
		" \3 \5 \u0234\n \3 \3 \3!\3!\3!\3!\3!\3!\3!\3!\3!\5!\u0241\n!\3!\3!\3"+
		"\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\5\"\u024e\n\"\3\"\3\"\3#\3#\3#\3#\3"+
		"#\3#\3#\3#\3#\3#\3#\3$\3$\3$\3%\3%\3&\3&\3&\3\'\3\'\3(\3(\3(\3(\3(\3("+
		"\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\5(\u027b\n(\3)\3)\3)\3)\3)"+
		"\3)\3)\3*\3*\3*\3*\3*\3*\3*\3+\3+\3+\3+\3,\3,\3,\3,\3,\3,\3,\3,\3,\3-"+
		"\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3.\3.\3.\3.\3.\3.\3.\3.\3.\3/\3/\3/\3/"+
		"\3/\3/\3/\3\60\3\60\3\60\3\60\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\62"+
		"\3\62\3\62\3\62\3\62\3\62\3\62\3\63\3\63\3\63\3\63\3\64\3\64\3\64\3\64"+
		"\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\65\3\65\3\65\3\65\3\65\3\65\3\65"+
		"\3\65\3\65\3\66\3\66\3\66\3\66\3\66\3\66\3\66\3\67\3\67\3\67\3\67\3\67"+
		"\3\67\3\67\38\38\38\38\38\38\38\39\39\39\39\3:\3:\3:\3:\3:\3:\3:\3:\3"+
		":\3:\3:\3;\3;\3;\3;\3;\3;\3;\3;\3;\3<\3<\3<\3<\3<\3<\3<\3=\3=\3>\3>\3"+
		"?\3?\3@\3@\3A\3A\3B\3B\3C\3C\3D\3D\3E\3E\3F\3F\3G\3G\3H\3H\3I\3I\3J\3"+
		"J\3K\3K\3L\3L\3M\3M\3N\3N\3O\3O\5O\u0337\nO\3P\3P\3Q\3Q\3R\3R\3S\3S\3"+
		"T\3T\3U\3U\3V\3V\3W\3W\3X\3X\3Y\3Y\3Z\3Z\3[\3[\3\\\3\\\3]\3]\3^\3^\3_"+
		"\3_\3`\3`\3a\3a\3b\3b\3c\3c\3d\3d\3e\3e\3f\3f\3g\3g\3h\3h\3i\3i\3i\3i"+
		"\7i\u036f\ni\fi\16i\u0372\13i\3i\3i\3j\3j\3j\3j\7j\u037a\nj\fj\16j\u037d"+
		"\13j\3j\3j\3k\3k\3l\3l\3m\3m\3n\3n\3o\3o\3p\3p\3q\3q\3r\3r\3s\3s\3s\2"+
		"\2t\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@B"+
		"DFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082\u0084\u0086\u0088\u008a\u008c"+
		"\u008e\u0090\u0092\u0094\u0096\u0098\u009a\u009c\u009e\u00a0\u00a2\u00a4"+
		"\u00a6\u00a8\u00aa\u00ac\u00ae\u00b0\u00b2\u00b4\u00b6\u00b8\u00ba\u00bc"+
		"\u00be\u00c0\u00c2\u00c4\u00c6\u00c8\u00ca\u00cc\u00ce\u00d0\u00d2\u00d4"+
		"\u00d6\u00d8\u00da\u00dc\u00de\u00e0\u00e2\u00e4\2\7\4\2++\65\66\3\2Y"+
		"Z\3\2:;\3\2<=\3\2Y[\u0362\2\u0109\3\2\2\2\4\u010b\3\2\2\2\6\u0112\3\2"+
		"\2\2\b\u0119\3\2\2\2\n\u011e\3\2\2\2\f\u0127\3\2\2\2\16\u012e\3\2\2\2"+
		"\20\u0137\3\2\2\2\22\u0140\3\2\2\2\24\u0147\3\2\2\2\26\u0152\3\2\2\2\30"+
		"\u0156\3\2\2\2\32\u0162\3\2\2\2\34\u0171\3\2\2\2\36\u0180\3\2\2\2 \u018d"+
		"\3\2\2\2\"\u019a\3\2\2\2$\u01a3\3\2\2\2&\u01ac\3\2\2\2(\u01b5\3\2\2\2"+
		"*\u01c0\3\2\2\2,\u01c9\3\2\2\2.\u01d0\3\2\2\2\60\u01db\3\2\2\2\62\u01e2"+
		"\3\2\2\2\64\u01ef\3\2\2\2\66\u01fc\3\2\2\28\u0203\3\2\2\2:\u020f\3\2\2"+
		"\2<\u021a\3\2\2\2>\u022d\3\2\2\2@\u0237\3\2\2\2B\u0244\3\2\2\2D\u0251"+
		"\3\2\2\2F\u025c\3\2\2\2H\u025f\3\2\2\2J\u0261\3\2\2\2L\u0264\3\2\2\2N"+
		"\u027a\3\2\2\2P\u027c\3\2\2\2R\u0283\3\2\2\2T\u028a\3\2\2\2V\u028e\3\2"+
		"\2\2X\u0297\3\2\2\2Z\u02a2\3\2\2\2\\\u02ab\3\2\2\2^\u02b2\3\2\2\2`\u02b6"+
		"\3\2\2\2b\u02bd\3\2\2\2d\u02c4\3\2\2\2f\u02c8\3\2\2\2h\u02d3\3\2\2\2j"+
		"\u02dc\3\2\2\2l\u02e3\3\2\2\2n\u02ea\3\2\2\2p\u02f1\3\2\2\2r\u02f5\3\2"+
		"\2\2t\u0300\3\2\2\2v\u0309\3\2\2\2x\u0310\3\2\2\2z\u0312\3\2\2\2|\u0314"+
		"\3\2\2\2~\u0316\3\2\2\2\u0080\u0318\3\2\2\2\u0082\u031a\3\2\2\2\u0084"+
		"\u031c\3\2\2\2\u0086\u031e\3\2\2\2\u0088\u0320\3\2\2\2\u008a\u0322\3\2"+
		"\2\2\u008c\u0324\3\2\2\2\u008e\u0326\3\2\2\2\u0090\u0328\3\2\2\2\u0092"+
		"\u032a\3\2\2\2\u0094\u032c\3\2\2\2\u0096\u032e\3\2\2\2\u0098\u0330\3\2"+
		"\2\2\u009a\u0332\3\2\2\2\u009c\u0336\3\2\2\2\u009e\u0338\3\2\2\2\u00a0"+
		"\u033a\3\2\2\2\u00a2\u033c\3\2\2\2\u00a4\u033e\3\2\2\2\u00a6\u0340\3\2"+
		"\2\2\u00a8\u0342\3\2\2\2\u00aa\u0344\3\2\2\2\u00ac\u0346\3\2\2\2\u00ae"+
		"\u0348\3\2\2\2\u00b0\u034a\3\2\2\2\u00b2\u034c\3\2\2\2\u00b4\u034e\3\2"+
		"\2\2\u00b6\u0350\3\2\2\2\u00b8\u0352\3\2\2\2\u00ba\u0354\3\2\2\2\u00bc"+
		"\u0356\3\2\2\2\u00be\u0358\3\2\2\2\u00c0\u035a\3\2\2\2\u00c2\u035c\3\2"+
		"\2\2\u00c4\u035e\3\2\2\2\u00c6\u0360\3\2\2\2\u00c8\u0362\3\2\2\2\u00ca"+
		"\u0364\3\2\2\2\u00cc\u0366\3\2\2\2\u00ce\u0368\3\2\2\2\u00d0\u036a\3\2"+
		"\2\2\u00d2\u0375\3\2\2\2\u00d4\u0380\3\2\2\2\u00d6\u0382\3\2\2\2\u00d8"+
		"\u0384\3\2\2\2\u00da\u0386\3\2\2\2\u00dc\u0388\3\2\2\2\u00de\u038a\3\2"+
		"\2\2\u00e0\u038c\3\2\2\2\u00e2\u038e\3\2\2\2\u00e4\u0390\3\2\2\2\u00e6"+
		"\u010a\5\66\34\2\u00e7\u010a\58\35\2\u00e8\u010a\5(\25\2\u00e9\u010a\5"+
		"\"\22\2\u00ea\u010a\5$\23\2\u00eb\u010a\5&\24\2\u00ec\u010a\5 \21\2\u00ed"+
		"\u010a\5\36\20\2\u00ee\u010a\5\34\17\2\u00ef\u010a\5*\26\2\u00f0\u010a"+
		"\5,\27\2\u00f1\u010a\5.\30\2\u00f2\u010a\5\60\31\2\u00f3\u010a\5\62\32"+
		"\2\u00f4\u010a\5N(\2\u00f5\u010a\5:\36\2\u00f6\u010a\5<\37\2\u00f7\u010a"+
		"\5> \2\u00f8\u010a\5F$\2\u00f9\u010a\5H%\2\u00fa\u010a\5J&\2\u00fb\u010a"+
		"\5@!\2\u00fc\u010a\5B\"\2\u00fd\u010a\5D#\2\u00fe\u010a\5\32\16\2\u00ff"+
		"\u010a\5\26\f\2\u0100\u010a\5\24\13\2\u0101\u010a\5\22\n\2\u0102\u010a"+
		"\5\20\t\2\u0103\u010a\5\16\b\2\u0104\u010a\5\f\7\2\u0105\u010a\5\n\6\2"+
		"\u0106\u010a\5\b\5\2\u0107\u010a\5\6\4\2\u0108\u010a\5\4\3\2\u0109\u00e6"+
		"\3\2\2\2\u0109\u00e7\3\2\2\2\u0109\u00e8\3\2\2\2\u0109\u00e9\3\2\2\2\u0109"+
		"\u00ea\3\2\2\2\u0109\u00eb\3\2\2\2\u0109\u00ec\3\2\2\2\u0109\u00ed\3\2"+
		"\2\2\u0109\u00ee\3\2\2\2\u0109\u00ef\3\2\2\2\u0109\u00f0\3\2\2\2\u0109"+
		"\u00f1\3\2\2\2\u0109\u00f2\3\2\2\2\u0109\u00f3\3\2\2\2\u0109\u00f4\3\2"+
		"\2\2\u0109\u00f5\3\2\2\2\u0109\u00f6\3\2\2\2\u0109\u00f7\3\2\2\2\u0109"+
		"\u00f8\3\2\2\2\u0109\u00f9\3\2\2\2\u0109\u00fa\3\2\2\2\u0109\u00fb\3\2"+
		"\2\2\u0109\u00fc\3\2\2\2\u0109\u00fd\3\2\2\2\u0109\u00fe\3\2\2\2\u0109"+
		"\u00ff\3\2\2\2\u0109\u0100\3\2\2\2\u0109\u0101\3\2\2\2\u0109\u0102\3\2"+
		"\2\2\u0109\u0103\3\2\2\2\u0109\u0104\3\2\2\2\u0109\u0105\3\2\2\2\u0109"+
		"\u0106\3\2\2\2\u0109\u0107\3\2\2\2\u0109\u0108\3\2\2\2\u010a\3\3\2\2\2"+
		"\u010b\u010c\7\62\2\2\u010c\u010d\7Q\2\2\u010d\u010e\5\u00dep\2\u010e"+
		"\u010f\7V\2\2\u010f\u0110\5\u0096L\2\u0110\u0111\7R\2\2\u0111\5\3\2\2"+
		"\2\u0112\u0113\7\63\2\2\u0113\u0114\7Q\2\2\u0114\u0115\5\u00dep\2\u0115"+
		"\u0116\7V\2\2\u0116\u0117\5\u0094K\2\u0117\u0118\7R\2\2\u0118\7\3\2\2"+
		"\2\u0119\u011a\7\64\2\2\u011a\u011b\7Q\2\2\u011b\u011c\5\u00e0q\2\u011c"+
		"\u011d\7R\2\2\u011d\t\3\2\2\2\u011e\u011f\5\u00b2Z\2\u011f\u0120\7W\2"+
		"\2\u0120\u0121\7\4\2\2\u0121\u0122\7Q\2\2\u0122\u0123\5\u00b4[\2\u0123"+
		"\u0124\7V\2\2\u0124\u0125\5\u00dco\2\u0125\u0126\7R\2\2\u0126\13\3\2\2"+
		"\2\u0127\u0128\5\u00b4[\2\u0128\u0129\7W\2\2\u0129\u012a\7\3\2\2\u012a"+
		"\u012b\7Q\2\2\u012b\u012c\5\u00b0Y\2\u012c\u012d\7R\2\2\u012d\r\3\2\2"+
		"\2\u012e\u012f\5\u00dep\2\u012f\u0130\7W\2\2\u0130\u0131\7\6\2\2\u0131"+
		"\u0132\7Q\2\2\u0132\u0133\5\u00dep\2\u0133\u0134\7V\2\2\u0134\u0135\5"+
		"\u00e0q\2\u0135\u0136\7R\2\2\u0136\17\3\2\2\2\u0137\u0138\5\u00dep\2\u0138"+
		"\u0139\7W\2\2\u0139\u013a\7\5\2\2\u013a\u013b\7Q\2\2\u013b\u013c\5\u00de"+
		"p\2\u013c\u013d\7V\2\2\u013d\u013e\5\u00e0q\2\u013e\u013f\7R\2\2\u013f"+
		"\21\3\2\2\2\u0140\u0141\5\u00dep\2\u0141\u0142\7W\2\2\u0142\u0143\7\t"+
		"\2\2\u0143\u0144\7Q\2\2\u0144\u0145\5\u00dep\2\u0145\u0146\7R\2\2\u0146"+
		"\23\3\2\2\2\u0147\u0148\5\u00dep\2\u0148\u0149\7W\2\2\u0149\u014a\7\n"+
		"\2\2\u014a\u014b\7Q\2\2\u014b\u014c\5\30\r\2\u014c\u014d\7V\2\2\u014d"+
		"\u014e\5z>\2\u014e\u014f\7V\2\2\u014f\u0150\5|?\2\u0150\u0151\7R\2\2\u0151"+
		"\25\3\2\2\2\u0152\u0153\5\u00e0q\2\u0153\u0154\7W\2\2\u0154\u0155\5\30"+
		"\r\2\u0155\27\3\2\2\2\u0156\u0157\7\13\2\2\u0157\u0158\7Q\2\2\u0158\u015d"+
		"\5\u009cO\2\u0159\u015a\7V\2\2\u015a\u015c\5\u009cO\2\u015b\u0159\3\2"+
		"\2\2\u015c\u015f\3\2\2\2\u015d\u015b\3\2\2\2\u015d\u015e\3\2\2\2\u015e"+
		"\u0160\3\2\2\2\u015f\u015d\3\2\2\2\u0160\u0161\7R\2\2\u0161\31\3\2\2\2"+
		"\u0162\u0163\5\u00b6\\\2\u0163\u0164\7W\2\2\u0164\u0165\7\f\2\2\u0165"+
		"\u0166\7Q\2\2\u0166\u0167\5\u00b8]\2\u0167\u0168\7V\2\2\u0168\u0169\5"+
		"\u00ba^\2\u0169\u016a\7V\2\2\u016a\u016d\5\u00bc_\2\u016b\u016c\7V\2\2"+
		"\u016c\u016e\5\u00be`\2\u016d\u016b\3\2\2\2\u016d\u016e\3\2\2\2\u016e"+
		"\u016f\3\2\2\2\u016f\u0170\7R\2\2\u0170\33\3\2\2\2\u0171\u0172\5\u00d8"+
		"m\2\u0172\u0173\7W\2\2\u0173\u0174\7&\2\2\u0174\u0175\7Q\2\2\u0175\u0176"+
		"\5\u0086D\2\u0176\u0177\7V\2\2\u0177\u017a\5\u0098M\2\u0178\u0179\7V\2"+
		"\2\u0179\u017b\5\u0088E\2\u017a\u0178\3\2\2\2\u017b\u017c\3\2\2\2\u017c"+
		"\u017a\3\2\2\2\u017c\u017d\3\2\2\2\u017d\u017e\3\2\2\2\u017e\u017f\7R"+
		"\2\2\u017f\35\3\2\2\2\u0180\u0181\5\u00d8m\2\u0181\u0182\7W\2\2\u0182"+
		"\u0183\7%\2\2\u0183\u0184\7Q\2\2\u0184\u0187\5\u0098M\2\u0185\u0186\7"+
		"V\2\2\u0186\u0188\5\u0088E\2\u0187\u0185\3\2\2\2\u0188\u0189\3\2\2\2\u0189"+
		"\u0187\3\2\2\2\u0189\u018a\3\2\2\2\u018a\u018b\3\2\2\2\u018b\u018c\7R"+
		"\2\2\u018c\37\3\2\2\2\u018d\u018e\5\u00d8m\2\u018e\u018f\7W\2\2\u018f"+
		"\u0190\7$\2\2\u0190\u0191\7Q\2\2\u0191\u0194\5\u0098M\2\u0192\u0193\7"+
		"V\2\2\u0193\u0195\5\u0088E\2\u0194\u0192\3\2\2\2\u0195\u0196\3\2\2\2\u0196"+
		"\u0194\3\2\2\2\u0196\u0197\3\2\2\2\u0197\u0198\3\2\2\2\u0198\u0199\7R"+
		"\2\2\u0199!\3\2\2\2\u019a\u019b\5\u00d8m\2\u019b\u019c\7W\2\2\u019c\u019d"+
		"\7#\2\2\u019d\u019e\7Q\2\2\u019e\u019f\5\u008aF\2\u019f\u01a0\7V\2\2\u01a0"+
		"\u01a1\5\u0098M\2\u01a1\u01a2\7R\2\2\u01a2#\3\2\2\2\u01a3\u01a4\5\u00d8"+
		"m\2\u01a4\u01a5\7W\2\2\u01a5\u01a6\7\"\2\2\u01a6\u01a7\7Q\2\2\u01a7\u01a8"+
		"\5\u008eH\2\u01a8\u01a9\7V\2\2\u01a9\u01aa\5\u008cG\2\u01aa\u01ab\7R\2"+
		"\2\u01ab%\3\2\2\2\u01ac\u01ad\5\u00d8m\2\u01ad\u01ae\7W\2\2\u01ae\u01af"+
		"\7,\2\2\u01af\u01b0\7Q\2\2\u01b0\u01b1\5\u0084C\2\u01b1\u01b2\7V\2\2\u01b2"+
		"\u01b3\5L\'\2\u01b3\u01b4\7R\2\2\u01b4\'\3\2\2\2\u01b5\u01b6\5\u00d8m"+
		"\2\u01b6\u01b7\7W\2\2\u01b7\u01b8\7J\2\2\u01b8\u01b9\7Q\2\2\u01b9\u01ba"+
		"\5\u009eP\2\u01ba\u01bb\7V\2\2\u01bb\u01bc\5\u00a0Q\2\u01bc\u01bd\7V\2"+
		"\2\u01bd\u01be\5\u00a2R\2\u01be\u01bf\7R\2\2\u01bf)\3\2\2\2\u01c0\u01c1"+
		"\5\u00d8m\2\u01c1\u01c2\7W\2\2\u01c2\u01c3\7-\2\2\u01c3\u01c4\7Q\2\2\u01c4"+
		"\u01c5\5\u00e2r\2\u01c5\u01c6\7V\2\2\u01c6\u01c7\5\u00a8U\2\u01c7\u01c8"+
		"\7R\2\2\u01c8+\3\2\2\2\u01c9\u01ca\5\u00d8m\2\u01ca\u01cb\7W\2\2\u01cb"+
		"\u01cc\7.\2\2\u01cc\u01cd\7Q\2\2\u01cd\u01ce\5\u0084C\2\u01ce\u01cf\7"+
		"R\2\2\u01cf-\3\2\2\2\u01d0\u01d1\5\u00d8m\2\u01d1\u01d2\7W\2\2\u01d2\u01d3"+
		"\7/\2\2\u01d3\u01d4\7Q\2\2\u01d4\u01d5\5~@\2\u01d5\u01d6\7V\2\2\u01d6"+
		"\u01d7\5\u0080A\2\u01d7\u01d8\7V\2\2\u01d8\u01d9\5\u0082B\2\u01d9\u01da"+
		"\7R\2\2\u01da/\3\2\2\2\u01db\u01dc\5\u00d8m\2\u01dc\u01dd\7W\2\2\u01dd"+
		"\u01de\7\60\2\2\u01de\u01df\7Q\2\2\u01df\u01e0\5\u00a8U\2\u01e0\u01e1"+
		"\7R\2\2\u01e1\61\3\2\2\2\u01e2\u01e3\5\u00d8m\2\u01e3\u01e4\7W\2\2\u01e4"+
		"\u01e5\7\61\2\2\u01e5\u01e6\7Q\2\2\u01e6\u01e7\5\u00e2r\2\u01e7\u01e8"+
		"\7V\2\2\u01e8\u01e9\5\u009aN\2\u01e9\u01ea\7V\2\2\u01ea\u01eb\5\u009c"+
		"O\2\u01eb\u01ec\7V\2\2\u01ec\u01ed\5\u0098M\2\u01ed\u01ee\7R\2\2\u01ee"+
		"\63\3\2\2\2\u01ef\u01f0\5\u00d8m\2\u01f0\u01f1\7W\2\2\u01f1\u01f2\7*\2"+
		"\2\u01f2\u01f3\7Q\2\2\u01f3\u01f4\5\u00e2r\2\u01f4\u01f5\7V\2\2\u01f5"+
		"\u01f6\5\u009aN\2\u01f6\u01f7\7V\2\2\u01f7\u01f8\5\u009cO\2\u01f8\u01f9"+
		"\7V\2\2\u01f9\u01fa\5\u0098M\2\u01fa\u01fb\7R\2\2\u01fb\65\3\2\2\2\u01fc"+
		"\u01fd\5\u00dan\2\u01fd\u01fe\7W\2\2\u01fe\u01ff\7M\2\2\u01ff\u0200\7"+
		"Q\2\2\u0200\u0201\5\u00e4s\2\u0201\u0202\7R\2\2\u0202\67\3\2\2\2\u0203"+
		"\u0204\7N\2\2\u0204\u0205\7Q\2\2\u0205\u020a\5\u00dan\2\u0206\u0207\7"+
		"V\2\2\u0207\u0209\5\u00ceh\2\u0208\u0206\3\2\2\2\u0209\u020c\3\2\2\2\u020a"+
		"\u0208\3\2\2\2\u020a\u020b\3\2\2\2\u020b\u020d\3\2\2\2\u020c\u020a\3\2"+
		"\2\2\u020d\u020e\7R\2\2\u020e9\3\2\2\2\u020f\u0210\5\u00c6d\2\u0210\u0211"+
		"\7W\2\2\u0211\u0212\78\2\2\u0212\u0213\7Q\2\2\u0213\u0214\5\u00d8m\2\u0214"+
		"\u0215\7V\2\2\u0215\u0216\5\u00dep\2\u0216\u0217\7V\2\2\u0217\u0218\5"+
		"\u00e0q\2\u0218\u0219\7R\2\2\u0219;\3\2\2\2\u021a\u021b\5\u00c6d\2\u021b"+
		"\u021c\7W\2\2\u021c\u021d\7\67\2\2\u021d\u021e\7Q\2\2\u021e\u021f\5\u00d8"+
		"m\2\u021f\u0220\7V\2\2\u0220\u0221\5\u00dco\2\u0221\u0222\7V\2\2\u0222"+
		"\u0223\5\u00c4c\2\u0223\u0224\7V\2\2\u0224\u0227\5\u00c2b\2\u0225\u0226"+
		"\7V\2\2\u0226\u0228\5\u00c0a\2\u0227\u0225\3\2\2\2\u0228\u0229\3\2\2\2"+
		"\u0229\u0227\3\2\2\2\u0229\u022a\3\2\2\2\u022a\u022b\3\2\2\2\u022b\u022c"+
		"\7R\2\2\u022c=\3\2\2\2\u022d\u022e\7G\2\2\u022e\u022f\7Q\2\2\u022f\u0230"+
		"\5\u00d8m\2\u0230\u0233\7V\2\2\u0231\u0234\5\u00e0q\2\u0232\u0234\5x="+
		"\2\u0233\u0231\3\2\2\2\u0233\u0232\3\2\2\2\u0234\u0235\3\2\2\2\u0235\u0236"+
		"\7R\2\2\u0236?\3\2\2\2\u0237\u0238\5\u00e0q\2\u0238\u0239\7W\2\2\u0239"+
		"\u023a\7?\2\2\u023a\u023b\7Q\2\2\u023b\u023c\5\u00dan\2\u023c\u023d\7"+
		"V\2\2\u023d\u0240\5\u00d6l\2\u023e\u023f\7V\2\2\u023f\u0241\5\u00d0i\2"+
		"\u0240\u023e\3\2\2\2\u0240\u0241\3\2\2\2\u0241\u0242\3\2\2\2\u0242\u0243"+
		"\7R\2\2\u0243A\3\2\2\2\u0244\u0245\5\u00dep\2\u0245\u0246\7W\2\2\u0246"+
		"\u0247\7>\2\2\u0247\u0248\7Q\2\2\u0248\u0249\5\u00dan\2\u0249\u024a\7"+
		"V\2\2\u024a\u024d\5\u00d2j\2\u024b\u024c\7V\2\2\u024c\u024e\5\u00d0i\2"+
		"\u024d\u024b\3\2\2\2\u024d\u024e\3\2\2\2\u024e\u024f\3\2\2\2\u024f\u0250"+
		"\7R\2\2\u0250C\3\2\2\2\u0251\u0252\5\u00dep\2\u0252\u0253\7W\2\2\u0253"+
		"\u0254\79\2\2\u0254\u0255\7Q\2\2\u0255\u0256\5\u00c8e\2\u0256\u0257\7"+
		"V\2\2\u0257\u0258\5\u00caf\2\u0258\u0259\7V\2\2\u0259\u025a\5\u00ccg\2"+
		"\u025a\u025b\7R\2\2\u025bE\3\2\2\2\u025c\u025d\7F\2\2\u025d\u025e\5\u00d4"+
		"k\2\u025eG\3\2\2\2\u025f\u0260\7E\2\2\u0260I\3\2\2\2\u0261\u0262\7D\2"+
		"\2\u0262\u0263\5\u00d4k\2\u0263K\3\2\2\2\u0264\u0265\t\2\2\2\u0265M\3"+
		"\2\2\2\u0266\u027b\5P)\2\u0267\u027b\5R*\2\u0268\u027b\5T+\2\u0269\u027b"+
		"\5V,\2\u026a\u027b\5X-\2\u026b\u027b\5Z.\2\u026c\u027b\5\\/\2\u026d\u027b"+
		"\5^\60\2\u026e\u027b\5`\61\2\u026f\u027b\5b\62\2\u0270\u027b\5d\63\2\u0271"+
		"\u027b\5f\64\2\u0272\u027b\5h\65\2\u0273\u027b\5j\66\2\u0274\u027b\5l"+
		"\67\2\u0275\u027b\5n8\2\u0276\u027b\5p9\2\u0277\u027b\5r:\2\u0278\u027b"+
		"\5t;\2\u0279\u027b\5v<\2\u027a\u0266\3\2\2\2\u027a\u0267\3\2\2\2\u027a"+
		"\u0268\3\2\2\2\u027a\u0269\3\2\2\2\u027a\u026a\3\2\2\2\u027a\u026b\3\2"+
		"\2\2\u027a\u026c\3\2\2\2\u027a\u026d\3\2\2\2\u027a\u026e\3\2\2\2\u027a"+
		"\u026f\3\2\2\2\u027a\u0270\3\2\2\2\u027a\u0271\3\2\2\2\u027a\u0272\3\2"+
		"\2\2\u027a\u0273\3\2\2\2\u027a\u0274\3\2\2\2\u027a\u0275\3\2\2\2\u027a"+
		"\u0276\3\2\2\2\u027a\u0277\3\2\2\2\u027a\u0278\3\2\2\2\u027a\u0279\3\2"+
		"\2\2\u027bO\3\2\2\2\u027c\u027d\5\u00e2r\2\u027d\u027e\7W\2\2\u027e\u027f"+
		"\7\r\2\2\u027f\u0280\7Q\2\2\u0280\u0281\5\u00a4S\2\u0281\u0282\7R\2\2"+
		"\u0282Q\3\2\2\2\u0283\u0284\5\u00e2r\2\u0284\u0285\7W\2\2\u0285\u0286"+
		"\7\16\2\2\u0286\u0287\7Q\2\2\u0287\u0288\5\u00a4S\2\u0288\u0289\7R\2\2"+
		"\u0289S\3\2\2\2\u028a\u028b\5\u00e2r\2\u028b\u028c\7W\2\2\u028c\u028d"+
		"\7\17\2\2\u028dU\3\2\2\2\u028e\u028f\5\u00e2r\2\u028f\u0290\7W\2\2\u0290"+
		"\u0291\7\20\2\2\u0291\u0292\7Q\2\2\u0292\u0293\5\u00a4S\2\u0293\u0294"+
		"\7V\2\2\u0294\u0295\5\u00a6T\2\u0295\u0296\7R\2\2\u0296W\3\2\2\2\u0297"+
		"\u0298\5\u00e2r\2\u0298\u0299\7W\2\2\u0299\u029a\7\21\2\2\u029a\u029b"+
		"\7Q\2\2\u029b\u029c\5\u00aaV\2\u029c\u029d\7V\2\2\u029d\u029e\5\u00ac"+
		"W\2\u029e\u029f\7V\2\2\u029f\u02a0\5\u00aeX\2\u02a0\u02a1\7R\2\2\u02a1"+
		"Y\3\2\2\2\u02a2\u02a3\5\u00e2r\2\u02a3\u02a4\7W\2\2\u02a4\u02a5\7\22\2"+
		"\2\u02a5\u02a6\7Q\2\2\u02a6\u02a7\5\u00acW\2\u02a7\u02a8\7V\2\2\u02a8"+
		"\u02a9\5\u00aeX\2\u02a9\u02aa\7R\2\2\u02aa[\3\2\2\2\u02ab\u02ac\5\u00e2"+
		"r\2\u02ac\u02ad\7W\2\2\u02ad\u02ae\7\23\2\2\u02ae\u02af\7Q\2\2\u02af\u02b0"+
		"\5\u00a4S\2\u02b0\u02b1\7R\2\2\u02b1]\3\2\2\2\u02b2\u02b3\5\u00e2r\2\u02b3"+
		"\u02b4\7W\2\2\u02b4\u02b5\7\24\2\2\u02b5_\3\2\2\2\u02b6\u02b7\5\u00e2"+
		"r\2\u02b7\u02b8\7W\2\2\u02b8\u02b9\7\25\2\2\u02b9\u02ba\7Q\2\2\u02ba\u02bb"+
		"\5\u00a4S\2\u02bb\u02bc\7R\2\2\u02bca\3\2\2\2\u02bd\u02be\5\u00e2r\2\u02be"+
		"\u02bf\7W\2\2\u02bf\u02c0\7\26\2\2\u02c0\u02c1\7Q\2\2\u02c1\u02c2\5\u00a4"+
		"S\2\u02c2\u02c3\7R\2\2\u02c3c\3\2\2\2\u02c4\u02c5\5\u00e2r\2\u02c5\u02c6"+
		"\7W\2\2\u02c6\u02c7\7\27\2\2\u02c7e\3\2\2\2\u02c8\u02c9\5\u00e2r\2\u02c9"+
		"\u02ca\7W\2\2\u02ca\u02cb\7\30\2\2\u02cb\u02cc\7Q\2\2\u02cc\u02cd\5\u00aa"+
		"V\2\u02cd\u02ce\7V\2\2\u02ce\u02cf\5\u00acW\2\u02cf\u02d0\7V\2\2\u02d0"+
		"\u02d1\5\u00aeX\2\u02d1\u02d2\7R\2\2\u02d2g\3\2\2\2\u02d3\u02d4\5\u00e2"+
		"r\2\u02d4\u02d5\7W\2\2\u02d5\u02d6\7\31\2\2\u02d6\u02d7\7Q\2\2\u02d7\u02d8"+
		"\5\u00acW\2\u02d8\u02d9\7V\2\2\u02d9\u02da\5\u00aeX\2\u02da\u02db\7R\2"+
		"\2\u02dbi\3\2\2\2\u02dc\u02dd\5\u00e2r\2\u02dd\u02de\7W\2\2\u02de\u02df"+
		"\7\32\2\2\u02df\u02e0\7Q\2\2\u02e0\u02e1\5\u00a4S\2\u02e1\u02e2\7R\2\2"+
		"\u02e2k\3\2\2\2\u02e3\u02e4\5\u00e2r\2\u02e4\u02e5\7W\2\2\u02e5\u02e6"+
		"\7\33\2\2\u02e6\u02e7\7Q\2\2\u02e7\u02e8\5\u00a4S\2\u02e8\u02e9\7R\2\2"+
		"\u02e9m\3\2\2\2\u02ea\u02eb\5\u00e2r\2\u02eb\u02ec\7W\2\2\u02ec\u02ed"+
		"\7\34\2\2\u02ed\u02ee\7Q\2\2\u02ee\u02ef\5\u00a4S\2\u02ef\u02f0\7R\2\2"+
		"\u02f0o\3\2\2\2\u02f1\u02f2\5\u00e2r\2\u02f2\u02f3\7W\2\2\u02f3\u02f4"+
		"\7\35\2\2\u02f4q\3\2\2\2\u02f5\u02f6\5\u00e2r\2\u02f6\u02f7\7W\2\2\u02f7"+
		"\u02f8\7\36\2\2\u02f8\u02f9\7Q\2\2\u02f9\u02fa\5\u00aaV\2\u02fa\u02fb"+
		"\7V\2\2\u02fb\u02fc\5\u00acW\2\u02fc\u02fd\7V\2\2\u02fd\u02fe\5\u00ae"+
		"X\2\u02fe\u02ff\7R\2\2\u02ffs\3\2\2\2\u0300\u0301\5\u00e2r\2\u0301\u0302"+
		"\7W\2\2\u0302\u0303\7\37\2\2\u0303\u0304\7Q\2\2\u0304\u0305\5\u00acW\2"+
		"\u0305\u0306\7V\2\2\u0306\u0307\5\u00aeX\2\u0307\u0308\7R\2\2\u0308u\3"+
		"\2\2\2\u0309\u030a\5\u00e2r\2\u030a\u030b\7W\2\2\u030b\u030c\7 \2\2\u030c"+
		"\u030d\7Q\2\2\u030d\u030e\5\u00a4S\2\u030e\u030f\7R\2\2\u030fw\3\2\2\2"+
		"\u0310\u0311\t\3\2\2\u0311y\3\2\2\2\u0312\u0313\7Z\2\2\u0313{\3\2\2\2"+
		"\u0314\u0315\7Z\2\2\u0315}\3\2\2\2\u0316\u0317\5x=\2\u0317\177\3\2\2\2"+
		"\u0318\u0319\5x=\2\u0319\u0081\3\2\2\2\u031a\u031b\5x=\2\u031b\u0083\3"+
		"\2\2\2\u031c\u031d\5x=\2\u031d\u0085\3\2\2\2\u031e\u031f\5x=\2\u031f\u0087"+
		"\3\2\2\2\u0320\u0321\5x=\2\u0321\u0089\3\2\2\2\u0322\u0323\5x=\2\u0323"+
		"\u008b\3\2\2\2\u0324\u0325\5x=\2\u0325\u008d\3\2\2\2\u0326\u0327\5x=\2"+
		"\u0327\u008f\3\2\2\2\u0328\u0329\5x=\2\u0329\u0091\3\2\2\2\u032a\u032b"+
		"\5x=\2\u032b\u0093\3\2\2\2\u032c\u032d\7Z\2\2\u032d\u0095\3\2\2\2\u032e"+
		"\u032f\7Z\2\2\u032f\u0097\3\2\2\2\u0330\u0331\5x=\2\u0331\u0099\3\2\2"+
		"\2\u0332\u0333\5x=\2\u0333\u009b\3\2\2\2\u0334\u0337\7[\2\2\u0335\u0337"+
		"\5x=\2\u0336\u0334\3\2\2\2\u0336\u0335\3\2\2\2\u0337\u009d\3\2\2\2\u0338"+
		"\u0339\5x=\2\u0339\u009f\3\2\2\2\u033a\u033b\5x=\2\u033b\u00a1\3\2\2\2"+
		"\u033c\u033d\5x=\2\u033d\u00a3\3\2\2\2\u033e\u033f\5x=\2\u033f\u00a5\3"+
		"\2\2\2\u0340\u0341\5x=\2\u0341\u00a7\3\2\2\2\u0342\u0343\5x=\2\u0343\u00a9"+
		"\3\2\2\2\u0344\u0345\5x=\2\u0345\u00ab\3\2\2\2\u0346\u0347\5x=\2\u0347"+
		"\u00ad\3\2\2\2\u0348\u0349\5x=\2\u0349\u00af\3\2\2\2\u034a\u034b\7[\2"+
		"\2\u034b\u00b1\3\2\2\2\u034c\u034d\7X\2\2\u034d\u00b3\3\2\2\2\u034e\u034f"+
		"\7X\2\2\u034f\u00b5\3\2\2\2\u0350\u0351\7X\2\2\u0351\u00b7\3\2\2\2\u0352"+
		"\u0353\7X\2\2\u0353\u00b9\3\2\2\2\u0354\u0355\7X\2\2\u0355\u00bb\3\2\2"+
		"\2\u0356\u0357\7X\2\2\u0357\u00bd\3\2\2\2\u0358\u0359\7X\2\2\u0359\u00bf"+
		"\3\2\2\2\u035a\u035b\7X\2\2\u035b\u00c1\3\2\2\2\u035c\u035d\7X\2\2\u035d"+
		"\u00c3\3\2\2\2\u035e\u035f\5x=\2\u035f\u00c5\3\2\2\2\u0360\u0361\7X\2"+
		"\2\u0361\u00c7\3\2\2\2\u0362\u0363\7X\2\2\u0363\u00c9\3\2\2\2\u0364\u0365"+
		"\t\4\2\2\u0365\u00cb\3\2\2\2\u0366\u0367\t\5\2\2\u0367\u00cd\3\2\2\2\u0368"+
		"\u0369\t\6\2\2\u0369\u00cf\3\2\2\2\u036a\u036b\7O\2\2\u036b\u0370\5\u00ce"+
		"h\2\u036c\u036d\7V\2\2\u036d\u036f\5\u00ceh\2\u036e\u036c\3\2\2\2\u036f"+
		"\u0372\3\2\2\2\u0370\u036e\3\2\2\2\u0370\u0371\3\2\2\2\u0371\u0373\3\2"+
		"\2\2\u0372\u0370\3\2\2\2\u0373\u0374\7P\2\2\u0374\u00d1\3\2\2\2\u0375"+
		"\u0376\7O\2\2\u0376\u037b\5\u00d6l\2\u0377\u0378\7V\2\2\u0378\u037a\5"+
		"\u00d6l\2\u0379\u0377\3\2\2\2\u037a\u037d\3\2\2\2\u037b\u0379\3\2\2\2"+
		"\u037b\u037c\3\2\2\2\u037c\u037e\3\2\2\2\u037d\u037b\3\2\2\2\u037e\u037f"+
		"\7P\2\2\u037f\u00d3\3\2\2\2\u0380\u0381\7X\2\2\u0381\u00d5\3\2\2\2\u0382"+
		"\u0383\7X\2\2\u0383\u00d7\3\2\2\2\u0384\u0385\7X\2\2\u0385\u00d9\3\2\2"+
		"\2\u0386\u0387\7X\2\2\u0387\u00db\3\2\2\2\u0388\u0389\7X\2\2\u0389\u00dd"+
		"\3\2\2\2\u038a\u038b\7X\2\2\u038b\u00df\3\2\2\2\u038c\u038d\7X\2\2\u038d"+
		"\u00e1\3\2\2\2\u038e\u038f\7X\2\2\u038f\u00e3\3\2\2\2\u0390\u0391\7[\2"+
		"\2\u0391\u00e5\3\2\2\2\21\u0109\u015d\u016d\u017c\u0189\u0196\u020a\u0229"+
		"\u0233\u0240\u024d\u027a\u0336\u0370\u037b";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}