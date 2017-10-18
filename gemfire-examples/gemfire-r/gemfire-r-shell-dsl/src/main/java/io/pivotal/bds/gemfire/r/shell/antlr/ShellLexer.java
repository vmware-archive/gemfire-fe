// Generated from io/pivotal/bds/gemfire/r/shell/antlr/Shell.g4 by ANTLR 4.5.2
package io.pivotal.bds.gemfire.r.shell.antlr;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ShellLexer extends Lexer {
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
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"PMML_LOAD", "PMML_PREDICT", "CBIND", "RBIND", "NROWS", "NCOLS", "T", 
		"M", "C", "HMM", "GAUSSIANKERNEL", "LAPLACEKERNEL", "LINEARKERNEL", "PEARSONKERNEL", 
		"POLYNOMIALKERNEL", "HYPERBOLICTANGENTKERNEL", "THINPLATEPLINEKERNEL", 
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
		"FLOAT", "INTEGER", "DIGITS", "DIGIT", "QUOTEDSTRING", "WS"
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


	public ShellLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Shell.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\\\u03e3\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\tT"+
		"\4U\tU\4V\tV\4W\tW\4X\tX\4Y\tY\4Z\tZ\4[\t[\4\\\t\\\4]\t]\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3"+
		"\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3"+
		"\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3"+
		"\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3"+
		"\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3"+
		"\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3"+
		"\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3"+
		"\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3"+
		"\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3"+
		"\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3"+
		"\26\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3"+
		"\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3"+
		"\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3"+
		"\30\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3"+
		"\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3"+
		"\31\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3"+
		"\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3"+
		"\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3"+
		"\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3"+
		"\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3"+
		"\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3"+
		"\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3"+
		"\35\3\35\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3"+
		"\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3"+
		"\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3"+
		"\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3"+
		"\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3"+
		"\37\3\37\3 \3 \3 \3 \3 \3 \3 \3!\3!\3!\3!\3!\3!\3!\3!\3!\3\"\3\"\3\"\3"+
		"\"\3#\3#\3#\3#\3$\3$\3$\3$\3%\3%\3%\3%\3&\3&\3&\3&\3&\3&\3&\3&\3&\3\'"+
		"\3\'\3\'\3\'\3\'\3\'\3\'\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\3)\3)\3)\3)\3*"+
		"\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3+\3+\3+\3+\3+\3+\3,\3,\3,\3-\3-\3-\3-"+
		"\3-\3-\3.\3.\3.\3.\3.\3.\3.\3.\3.\3/\3/\3/\3/\3/\3/\3/\3\60\3\60\3\60"+
		"\3\60\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\62\3\62\3\62\3\62\3\62\3\62"+
		"\3\62\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\64\3\64\3\64\3\64\3\64\3\64"+
		"\3\64\3\64\3\65\3\65\3\65\3\65\3\65\3\66\3\66\3\66\3\66\3\66\3\66\3\66"+
		"\3\67\3\67\3\67\3\67\3\67\3\67\38\38\38\38\39\39\39\39\39\39\39\39\3:"+
		"\3:\3:\3:\3:\3:\3:\3:\3;\3;\3;\3;\3;\3;\3;\3;\3;\3<\3<\3<\3<\3<\3<\3<"+
		"\3<\3=\3=\3=\3=\3=\3=\3=\3>\3>\3>\3>\3>\3?\3?\3?\3?\3?\3?\3?\3?\3?\3?"+
		"\3@\3@\3@\3@\3@\3@\3A\3A\3A\3A\3A\3A\3A\3B\3B\3B\3B\3B\3B\3B\3C\3C\3C"+
		"\3D\3D\3D\3E\3E\3E\3E\3E\3E\3F\3F\3F\3F\3F\3F\3F\3F\3G\3G\3H\3H\3H\3H"+
		"\3H\3H\3H\3I\3I\3I\3I\3J\3J\3J\3K\3K\3K\3L\3L\3L\3L\3L\3L\3M\3M\3M\3M"+
		"\3M\3M\3M\3M\3N\3N\3O\3O\3P\3P\3Q\3Q\3R\3R\3S\3S\3T\3T\3U\3U\3V\3V\3W"+
		"\3W\7W\u03c3\nW\fW\16W\u03c6\13W\3X\3X\3X\3X\3Y\3Y\3Z\6Z\u03cf\nZ\rZ\16"+
		"Z\u03d0\3[\3[\3\\\3\\\6\\\u03d7\n\\\r\\\16\\\u03d8\3\\\3\\\3]\6]\u03de"+
		"\n]\r]\16]\u03df\3]\3]\3\u03d8\2^\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23"+
		"\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31"+
		"\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60"+
		"_\61a\62c\63e\64g\65i\66k\67m8o9q:s;u<w=y>{?}@\177A\u0081B\u0083C\u0085"+
		"D\u0087E\u0089F\u008bG\u008dH\u008fI\u0091J\u0093K\u0095L\u0097M\u0099"+
		"N\u009bO\u009dP\u009fQ\u00a1R\u00a3S\u00a5T\u00a7U\u00a9V\u00abW\u00ad"+
		"X\u00afY\u00b1Z\u00b3\2\u00b5\2\u00b7[\u00b9\\\3\2\6\4\2C\\c|\7\2\60\60"+
		"\62;C\\aac|\3\2$$\5\2\13\f\16\17\"\"\u03e4\2\3\3\2\2\2\2\5\3\2\2\2\2\7"+
		"\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2"+
		"\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2"+
		"\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2"+
		"\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2"+
		"\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2"+
		"\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M"+
		"\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2"+
		"\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2"+
		"\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s"+
		"\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2{\3\2\2\2\2}\3\2\2\2\2\177"+
		"\3\2\2\2\2\u0081\3\2\2\2\2\u0083\3\2\2\2\2\u0085\3\2\2\2\2\u0087\3\2\2"+
		"\2\2\u0089\3\2\2\2\2\u008b\3\2\2\2\2\u008d\3\2\2\2\2\u008f\3\2\2\2\2\u0091"+
		"\3\2\2\2\2\u0093\3\2\2\2\2\u0095\3\2\2\2\2\u0097\3\2\2\2\2\u0099\3\2\2"+
		"\2\2\u009b\3\2\2\2\2\u009d\3\2\2\2\2\u009f\3\2\2\2\2\u00a1\3\2\2\2\2\u00a3"+
		"\3\2\2\2\2\u00a5\3\2\2\2\2\u00a7\3\2\2\2\2\u00a9\3\2\2\2\2\u00ab\3\2\2"+
		"\2\2\u00ad\3\2\2\2\2\u00af\3\2\2\2\2\u00b1\3\2\2\2\2\u00b7\3\2\2\2\2\u00b9"+
		"\3\2\2\2\3\u00bb\3\2\2\2\5\u00c5\3\2\2\2\7\u00d2\3\2\2\2\t\u00d8\3\2\2"+
		"\2\13\u00de\3\2\2\2\r\u00e4\3\2\2\2\17\u00ea\3\2\2\2\21\u00ec\3\2\2\2"+
		"\23\u00ee\3\2\2\2\25\u00f0\3\2\2\2\27\u00f4\3\2\2\2\31\u0100\3\2\2\2\33"+
		"\u010e\3\2\2\2\35\u011b\3\2\2\2\37\u0129\3\2\2\2!\u0134\3\2\2\2#\u0147"+
		"\3\2\2\2%\u015d\3\2\2\2\'\u016d\3\2\2\2)\u017f\3\2\2\2+\u0193\3\2\2\2"+
		"-\u01a6\3\2\2\2/\u01b7\3\2\2\2\61\u01d0\3\2\2\2\63\u01ec\3\2\2\2\65\u0204"+
		"\3\2\2\2\67\u021e\3\2\2\29\u0237\3\2\2\2;\u024e\3\2\2\2=\u026d\3\2\2\2"+
		"?\u028f\3\2\2\2A\u0296\3\2\2\2C\u029f\3\2\2\2E\u02a3\3\2\2\2G\u02a7\3"+
		"\2\2\2I\u02ab\3\2\2\2K\u02af\3\2\2\2M\u02b8\3\2\2\2O\u02bf\3\2\2\2Q\u02c9"+
		"\3\2\2\2S\u02cd\3\2\2\2U\u02d8\3\2\2\2W\u02de\3\2\2\2Y\u02e1\3\2\2\2["+
		"\u02e7\3\2\2\2]\u02f0\3\2\2\2_\u02f7\3\2\2\2a\u02fb\3\2\2\2c\u0302\3\2"+
		"\2\2e\u0309\3\2\2\2g\u0310\3\2\2\2i\u0318\3\2\2\2k\u031d\3\2\2\2m\u0324"+
		"\3\2\2\2o\u032a\3\2\2\2q\u032e\3\2\2\2s\u0336\3\2\2\2u\u033e\3\2\2\2w"+
		"\u0347\3\2\2\2y\u034f\3\2\2\2{\u0356\3\2\2\2}\u035b\3\2\2\2\177\u0365"+
		"\3\2\2\2\u0081\u036b\3\2\2\2\u0083\u0372\3\2\2\2\u0085\u0379\3\2\2\2\u0087"+
		"\u037c\3\2\2\2\u0089\u037f\3\2\2\2\u008b\u0385\3\2\2\2\u008d\u038d\3\2"+
		"\2\2\u008f\u038f\3\2\2\2\u0091\u0396\3\2\2\2\u0093\u039a\3\2\2\2\u0095"+
		"\u039d\3\2\2\2\u0097\u03a0\3\2\2\2\u0099\u03a6\3\2\2\2\u009b\u03ae\3\2"+
		"\2\2\u009d\u03b0\3\2\2\2\u009f\u03b2\3\2\2\2\u00a1\u03b4\3\2\2\2\u00a3"+
		"\u03b6\3\2\2\2\u00a5\u03b8\3\2\2\2\u00a7\u03ba\3\2\2\2\u00a9\u03bc\3\2"+
		"\2\2\u00ab\u03be\3\2\2\2\u00ad\u03c0\3\2\2\2\u00af\u03c7\3\2\2\2\u00b1"+
		"\u03cb\3\2\2\2\u00b3\u03ce\3\2\2\2\u00b5\u03d2\3\2\2\2\u00b7\u03d4\3\2"+
		"\2\2\u00b9\u03dd\3\2\2\2\u00bb\u00bc\7r\2\2\u00bc\u00bd\7o\2\2\u00bd\u00be"+
		"\7o\2\2\u00be\u00bf\7n\2\2\u00bf\u00c0\7\60\2\2\u00c0\u00c1\7n\2\2\u00c1"+
		"\u00c2\7q\2\2\u00c2\u00c3\7c\2\2\u00c3\u00c4\7f\2\2\u00c4\4\3\2\2\2\u00c5"+
		"\u00c6\7r\2\2\u00c6\u00c7\7o\2\2\u00c7\u00c8\7o\2\2\u00c8\u00c9\7n\2\2"+
		"\u00c9\u00ca\7\60\2\2\u00ca\u00cb\7r\2\2\u00cb\u00cc\7t\2\2\u00cc\u00cd"+
		"\7g\2\2\u00cd\u00ce\7f\2\2\u00ce\u00cf\7k\2\2\u00cf\u00d0\7e\2\2\u00d0"+
		"\u00d1\7v\2\2\u00d1\6\3\2\2\2\u00d2\u00d3\7e\2\2\u00d3\u00d4\7d\2\2\u00d4"+
		"\u00d5\7k\2\2\u00d5\u00d6\7p\2\2\u00d6\u00d7\7f\2\2\u00d7\b\3\2\2\2\u00d8"+
		"\u00d9\7t\2\2\u00d9\u00da\7d\2\2\u00da\u00db\7k\2\2\u00db\u00dc\7p\2\2"+
		"\u00dc\u00dd\7f\2\2\u00dd\n\3\2\2\2\u00de\u00df\7p\2\2\u00df\u00e0\7t"+
		"\2\2\u00e0\u00e1\7q\2\2\u00e1\u00e2\7y\2\2\u00e2\u00e3\7u\2\2\u00e3\f"+
		"\3\2\2\2\u00e4\u00e5\7p\2\2\u00e5\u00e6\7e\2\2\u00e6\u00e7\7q\2\2\u00e7"+
		"\u00e8\7n\2\2\u00e8\u00e9\7u\2\2\u00e9\16\3\2\2\2\u00ea\u00eb\7v\2\2\u00eb"+
		"\20\3\2\2\2\u00ec\u00ed\7o\2\2\u00ed\22\3\2\2\2\u00ee\u00ef\7e\2\2\u00ef"+
		"\24\3\2\2\2\u00f0\u00f1\7j\2\2\u00f1\u00f2\7o\2\2\u00f2\u00f3\7o\2\2\u00f3"+
		"\26\3\2\2\2\u00f4\u00f5\7i\2\2\u00f5\u00f6\7c\2\2\u00f6\u00f7\7w\2\2\u00f7"+
		"\u00f8\7u\2\2\u00f8\u00f9\7u\2\2\u00f9\u00fa\7m\2\2\u00fa\u00fb\7g\2\2"+
		"\u00fb\u00fc\7t\2\2\u00fc\u00fd\7p\2\2\u00fd\u00fe\7g\2\2\u00fe\u00ff"+
		"\7n\2\2\u00ff\30\3\2\2\2\u0100\u0101\7n\2\2\u0101\u0102\7c\2\2\u0102\u0103"+
		"\7r\2\2\u0103\u0104\7n\2\2\u0104\u0105\7c\2\2\u0105\u0106\7e\2\2\u0106"+
		"\u0107\7g\2\2\u0107\u0108\7m\2\2\u0108\u0109\7g\2\2\u0109\u010a\7t\2\2"+
		"\u010a\u010b\7p\2\2\u010b\u010c\7g\2\2\u010c\u010d\7n\2\2\u010d\32\3\2"+
		"\2\2\u010e\u010f\7n\2\2\u010f\u0110\7k\2\2\u0110\u0111\7p\2\2\u0111\u0112"+
		"\7g\2\2\u0112\u0113\7c\2\2\u0113\u0114\7t\2\2\u0114\u0115\7m\2\2\u0115"+
		"\u0116\7g\2\2\u0116\u0117\7t\2\2\u0117\u0118\7p\2\2\u0118\u0119\7g\2\2"+
		"\u0119\u011a\7n\2\2\u011a\34\3\2\2\2\u011b\u011c\7r\2\2\u011c\u011d\7"+
		"g\2\2\u011d\u011e\7c\2\2\u011e\u011f\7t\2\2\u011f\u0120\7u\2\2\u0120\u0121"+
		"\7q\2\2\u0121\u0122\7p\2\2\u0122\u0123\7m\2\2\u0123\u0124\7g\2\2\u0124"+
		"\u0125\7t\2\2\u0125\u0126\7p\2\2\u0126\u0127\7g\2\2\u0127\u0128\7n\2\2"+
		"\u0128\36\3\2\2\2\u0129\u012a\7r\2\2\u012a\u012b\7q\2\2\u012b\u012c\7"+
		"n\2\2\u012c\u012d\7{\2\2\u012d\u012e\7m\2\2\u012e\u012f\7g\2\2\u012f\u0130"+
		"\7t\2\2\u0130\u0131\7p\2\2\u0131\u0132\7g\2\2\u0132\u0133\7n\2\2\u0133"+
		" \3\2\2\2\u0134\u0135\7j\2\2\u0135\u0136\7{\2\2\u0136\u0137\7r\2\2\u0137"+
		"\u0138\7g\2\2\u0138\u0139\7t\2\2\u0139\u013a\7v\2\2\u013a\u013b\7c\2\2"+
		"\u013b\u013c\7p\2\2\u013c\u013d\7i\2\2\u013d\u013e\7g\2\2\u013e\u013f"+
		"\7p\2\2\u013f\u0140\7v\2\2\u0140\u0141\7m\2\2\u0141\u0142\7g\2\2\u0142"+
		"\u0143\7t\2\2\u0143\u0144\7p\2\2\u0144\u0145\7g\2\2\u0145\u0146\7n\2\2"+
		"\u0146\"\3\2\2\2\u0147\u0148\7v\2\2\u0148\u0149\7j\2\2\u0149\u014a\7k"+
		"\2\2\u014a\u014b\7p\2\2\u014b\u014c\7r\2\2\u014c\u014d\7n\2\2\u014d\u014e"+
		"\7c\2\2\u014e\u014f\7v\2\2\u014f\u0150\7g\2\2\u0150\u0151\7u\2\2\u0151"+
		"\u0152\7r\2\2\u0152\u0153\7n\2\2\u0153\u0154\7k\2\2\u0154\u0155\7p\2\2"+
		"\u0155\u0156\7g\2\2\u0156\u0157\7m\2\2\u0157\u0158\7g\2\2\u0158\u0159"+
		"\7t\2\2\u0159\u015a\7p\2\2\u015a\u015b\7g\2\2\u015b\u015c\7n\2\2\u015c"+
		"$\3\2\2\2\u015d\u015e\7j\2\2\u015e\u015f\7g\2\2\u015f\u0160\7n\2\2\u0160"+
		"\u0161\7n\2\2\u0161\u0162\7k\2\2\u0162\u0163\7p\2\2\u0163\u0164\7i\2\2"+
		"\u0164\u0165\7g\2\2\u0165\u0166\7t\2\2\u0166\u0167\7m\2\2\u0167\u0168"+
		"\7g\2\2\u0168\u0169\7t\2\2\u0169\u016a\7p\2\2\u016a\u016b\7g\2\2\u016b"+
		"\u016c\7n\2\2\u016c&\3\2\2\2\u016d\u016e\7u\2\2\u016e\u016f\7r\2\2\u016f"+
		"\u0170\7c\2\2\u0170\u0171\7t\2\2\u0171\u0172\7u\2\2\u0172\u0173\7g\2\2"+
		"\u0173\u0174\7i\2\2\u0174\u0175\7c\2\2\u0175\u0176\7w\2\2\u0176\u0177"+
		"\7u\2\2\u0177\u0178\7u\2\2\u0178\u0179\7m\2\2\u0179\u017a\7g\2\2\u017a"+
		"\u017b\7t\2\2\u017b\u017c\7p\2\2\u017c\u017d\7g\2\2\u017d\u017e\7n\2\2"+
		"\u017e(\3\2\2\2\u017f\u0180\7u\2\2\u0180\u0181\7r\2\2\u0181\u0182\7c\2"+
		"\2\u0182\u0183\7t\2\2\u0183\u0184\7u\2\2\u0184\u0185\7g\2\2\u0185\u0186"+
		"\7n\2\2\u0186\u0187\7c\2\2\u0187\u0188\7r\2\2\u0188\u0189\7n\2\2\u0189"+
		"\u018a\7c\2\2\u018a\u018b\7e\2\2\u018b\u018c\7g\2\2\u018c\u018d\7m\2\2"+
		"\u018d\u018e\7g\2\2\u018e\u018f\7t\2\2\u018f\u0190\7p\2\2\u0190\u0191"+
		"\7g\2\2\u0191\u0192\7n\2\2\u0192*\3\2\2\2\u0193\u0194\7u\2\2\u0194\u0195"+
		"\7r\2\2\u0195\u0196\7c\2\2\u0196\u0197\7t\2\2\u0197\u0198\7u\2\2\u0198"+
		"\u0199\7g\2\2\u0199\u019a\7n\2\2\u019a\u019b\7k\2\2\u019b\u019c\7p\2\2"+
		"\u019c\u019d\7g\2\2\u019d\u019e\7c\2\2\u019e\u019f\7t\2\2\u019f\u01a0"+
		"\7m\2\2\u01a0\u01a1\7g\2\2\u01a1\u01a2\7t\2\2\u01a2\u01a3\7p\2\2\u01a3"+
		"\u01a4\7g\2\2\u01a4\u01a5\7n\2\2\u01a5,\3\2\2\2\u01a6\u01a7\7u\2\2\u01a7"+
		"\u01a8\7r\2\2\u01a8\u01a9\7c\2\2\u01a9\u01aa\7t\2\2\u01aa\u01ab\7u\2\2"+
		"\u01ab\u01ac\7g\2\2\u01ac\u01ad\7r\2\2\u01ad\u01ae\7q\2\2\u01ae\u01af"+
		"\7n\2\2\u01af\u01b0\7{\2\2\u01b0\u01b1\7m\2\2\u01b1\u01b2\7g\2\2\u01b2"+
		"\u01b3\7t\2\2\u01b3\u01b4\7p\2\2\u01b4\u01b5\7g\2\2\u01b5\u01b6\7n\2\2"+
		"\u01b6.\3\2\2\2\u01b7\u01b8\7u\2\2\u01b8\u01b9\7r\2\2\u01b9\u01ba\7c\2"+
		"\2\u01ba\u01bb\7t\2\2\u01bb\u01bc\7u\2\2\u01bc\u01bd\7g\2\2\u01bd\u01be"+
		"\7j\2\2\u01be\u01bf\7{\2\2\u01bf\u01c0\7r\2\2\u01c0\u01c1\7g\2\2\u01c1"+
		"\u01c2\7t\2\2\u01c2\u01c3\7v\2\2\u01c3\u01c4\7c\2\2\u01c4\u01c5\7p\2\2"+
		"\u01c5\u01c6\7i\2\2\u01c6\u01c7\7g\2\2\u01c7\u01c8\7p\2\2\u01c8\u01c9"+
		"\7v\2\2\u01c9\u01ca\7m\2\2\u01ca\u01cb\7g\2\2\u01cb\u01cc\7t\2\2\u01cc"+
		"\u01cd\7p\2\2\u01cd\u01ce\7g\2\2\u01ce\u01cf\7n\2\2\u01cf\60\3\2\2\2\u01d0"+
		"\u01d1\7u\2\2\u01d1\u01d2\7r\2\2\u01d2\u01d3\7c\2\2\u01d3\u01d4\7t\2\2"+
		"\u01d4\u01d5\7u\2\2\u01d5\u01d6\7g\2\2\u01d6\u01d7\7v\2\2\u01d7\u01d8"+
		"\7j\2\2\u01d8\u01d9\7k\2\2\u01d9\u01da\7p\2\2\u01da\u01db\7r\2\2\u01db"+
		"\u01dc\7n\2\2\u01dc\u01dd\7c\2\2\u01dd\u01de\7v\2\2\u01de\u01df\7g\2\2"+
		"\u01df\u01e0\7u\2\2\u01e0\u01e1\7r\2\2\u01e1\u01e2\7n\2\2\u01e2\u01e3"+
		"\7k\2\2\u01e3\u01e4\7p\2\2\u01e4\u01e5\7g\2\2\u01e5\u01e6\7m\2\2\u01e6"+
		"\u01e7\7g\2\2\u01e7\u01e8\7t\2\2\u01e8\u01e9\7p\2\2\u01e9\u01ea\7g\2\2"+
		"\u01ea\u01eb\7n\2\2\u01eb\62\3\2\2\2\u01ec\u01ed\7d\2\2\u01ed\u01ee\7"+
		"k\2\2\u01ee\u01ef\7p\2\2\u01ef\u01f0\7c\2\2\u01f0\u01f1\7t\2\2\u01f1\u01f2"+
		"\7{\2\2\u01f2\u01f3\7u\2\2\u01f3\u01f4\7r\2\2\u01f4\u01f5\7c\2\2\u01f5"+
		"\u01f6\7t\2\2\u01f6\u01f7\7u\2\2\u01f7\u01f8\7g\2\2\u01f8\u01f9\7i\2\2"+
		"\u01f9\u01fa\7c\2\2\u01fa\u01fb\7w\2\2\u01fb\u01fc\7u\2\2\u01fc\u01fd"+
		"\7u\2\2\u01fd\u01fe\7m\2\2\u01fe\u01ff\7g\2\2\u01ff\u0200\7t\2\2\u0200"+
		"\u0201\7p\2\2\u0201\u0202\7g\2\2\u0202\u0203\7n\2\2\u0203\64\3\2\2\2\u0204"+
		"\u0205\7d\2\2\u0205\u0206\7k\2\2\u0206\u0207\7p\2\2\u0207\u0208\7c\2\2"+
		"\u0208\u0209\7t\2\2\u0209\u020a\7{\2\2\u020a\u020b\7u\2\2\u020b\u020c"+
		"\7r\2\2\u020c\u020d\7c\2\2\u020d\u020e\7t\2\2\u020e\u020f\7u\2\2\u020f"+
		"\u0210\7g\2\2\u0210\u0211\7n\2\2\u0211\u0212\7c\2\2\u0212\u0213\7r\2\2"+
		"\u0213\u0214\7n\2\2\u0214\u0215\7c\2\2\u0215\u0216\7e\2\2\u0216\u0217"+
		"\7g\2\2\u0217\u0218\7m\2\2\u0218\u0219\7g\2\2\u0219\u021a\7t\2\2\u021a"+
		"\u021b\7p\2\2\u021b\u021c\7g\2\2\u021c\u021d\7n\2\2\u021d\66\3\2\2\2\u021e"+
		"\u021f\7d\2\2\u021f\u0220\7k\2\2\u0220\u0221\7p\2\2\u0221\u0222\7c\2\2"+
		"\u0222\u0223\7t\2\2\u0223\u0224\7{\2\2\u0224\u0225\7u\2\2\u0225\u0226"+
		"\7r\2\2\u0226\u0227\7c\2\2\u0227\u0228\7t\2\2\u0228\u0229\7u\2\2\u0229"+
		"\u022a\7g\2\2\u022a\u022b\7n\2\2\u022b\u022c\7k\2\2\u022c\u022d\7p\2\2"+
		"\u022d\u022e\7g\2\2\u022e\u022f\7c\2\2\u022f\u0230\7t\2\2\u0230\u0231"+
		"\7m\2\2\u0231\u0232\7g\2\2\u0232\u0233\7t\2\2\u0233\u0234\7p\2\2\u0234"+
		"\u0235\7g\2\2\u0235\u0236\7n\2\2\u02368\3\2\2\2\u0237\u0238\7d\2\2\u0238"+
		"\u0239\7k\2\2\u0239\u023a\7p\2\2\u023a\u023b\7c\2\2\u023b\u023c\7t\2\2"+
		"\u023c\u023d\7{\2\2\u023d\u023e\7u\2\2\u023e\u023f\7r\2\2\u023f\u0240"+
		"\7c\2\2\u0240\u0241\7t\2\2\u0241\u0242\7u\2\2\u0242\u0243\7g\2\2\u0243"+
		"\u0244\7r\2\2\u0244\u0245\7q\2\2\u0245\u0246\7n\2\2\u0246\u0247\7{\2\2"+
		"\u0247\u0248\7m\2\2\u0248\u0249\7g\2\2\u0249\u024a\7t\2\2\u024a\u024b"+
		"\7p\2\2\u024b\u024c\7g\2\2\u024c\u024d\7n\2\2\u024d:\3\2\2\2\u024e\u024f"+
		"\7d\2\2\u024f\u0250\7k\2\2\u0250\u0251\7p\2\2\u0251\u0252\7c\2\2\u0252"+
		"\u0253\7t\2\2\u0253\u0254\7{\2\2\u0254\u0255\7u\2\2\u0255\u0256\7r\2\2"+
		"\u0256\u0257\7c\2\2\u0257\u0258\7t\2\2\u0258\u0259\7u\2\2\u0259\u025a"+
		"\7g\2\2\u025a\u025b\7j\2\2\u025b\u025c\7{\2\2\u025c\u025d\7r\2\2\u025d"+
		"\u025e\7g\2\2\u025e\u025f\7t\2\2\u025f\u0260\7v\2\2\u0260\u0261\7c\2\2"+
		"\u0261\u0262\7p\2\2\u0262\u0263\7i\2\2\u0263\u0264\7g\2\2\u0264\u0265"+
		"\7p\2\2\u0265\u0266\7v\2\2\u0266\u0267\7m\2\2\u0267\u0268\7g\2\2\u0268"+
		"\u0269\7t\2\2\u0269\u026a\7p\2\2\u026a\u026b\7g\2\2\u026b\u026c\7n\2\2"+
		"\u026c<\3\2\2\2\u026d\u026e\7d\2\2\u026e\u026f\7k\2\2\u026f\u0270\7p\2"+
		"\2\u0270\u0271\7c\2\2\u0271\u0272\7t\2\2\u0272\u0273\7{\2\2\u0273\u0274"+
		"\7u\2\2\u0274\u0275\7r\2\2\u0275\u0276\7c\2\2\u0276\u0277\7t\2\2\u0277"+
		"\u0278\7u\2\2\u0278\u0279\7g\2\2\u0279\u027a\7v\2\2\u027a\u027b\7j\2\2"+
		"\u027b\u027c\7k\2\2\u027c\u027d\7p\2\2\u027d\u027e\7r\2\2\u027e\u027f"+
		"\7n\2\2\u027f\u0280\7c\2\2\u0280\u0281\7v\2\2\u0281\u0282\7g\2\2\u0282"+
		"\u0283\7u\2\2\u0283\u0284\7r\2\2\u0284\u0285\7n\2\2\u0285\u0286\7k\2\2"+
		"\u0286\u0287\7p\2\2\u0287\u0288\7g\2\2\u0288\u0289\7m\2\2\u0289\u028a"+
		"\7g\2\2\u028a\u028b\7t\2\2\u028b\u028c\7p\2\2\u028c\u028d\7g\2\2\u028d"+
		"\u028e\7n\2\2\u028e>\3\2\2\2\u028f\u0290\7t\2\2\u0290\u0291\7d\2\2\u0291"+
		"\u0292\7h\2\2\u0292\u0293\7p\2\2\u0293\u0294\7g\2\2\u0294\u0295\7v\2\2"+
		"\u0295@\3\2\2\2\u0296\u0297\7t\2\2\u0297\u0298\7h\2\2\u0298\u0299\7q\2"+
		"\2\u0299\u029a\7t\2\2\u029a\u029b\7g\2\2\u029b\u029c\7u\2\2\u029c\u029d"+
		"\7v\2\2\u029d\u029e\7e\2\2\u029eB\3\2\2\2\u029f\u02a0\7h\2\2\u02a0\u02a1"+
		"\7n\2\2\u02a1\u02a2\7f\2\2\u02a2D\3\2\2\2\u02a3\u02a4\7s\2\2\u02a4\u02a5"+
		"\7f\2\2\u02a5\u02a6\7c\2\2\u02a6F\3\2\2\2\u02a7\u02a8\7n\2\2\u02a8\u02a9"+
		"\7f\2\2\u02a9\u02aa\7c\2\2\u02aaH\3\2\2\2\u02ab\u02ac\7t\2\2\u02ac\u02ad"+
		"\7f\2\2\u02ad\u02ae\7c\2\2\u02aeJ\3\2\2\2\u02af\u02b0\7n\2\2\u02b0\u02b1"+
		"\7t\2\2\u02b1\u02b2\7g\2\2\u02b2\u02b3\7i\2\2\u02b3\u02b4\7t\2\2\u02b4"+
		"\u02b5\7g\2\2\u02b5\u02b6\7u\2\2\u02b6\u02b7\7u\2\2\u02b7L\3\2\2\2\u02b8"+
		"\u02b9\7p\2\2\u02b9\u02ba\7d\2\2\u02ba\u02bb\7c\2\2\u02bb\u02bc\7{\2\2"+
		"\u02bc\u02bd\7g\2\2\u02bd\u02be\7u\2\2\u02beN\3\2\2\2\u02bf\u02c0\7p\2"+
		"\2\u02c0\u02c1\7g\2\2\u02c1\u02c2\7w\2\2\u02c2\u02c3\7t\2\2\u02c3\u02c4"+
		"\7c\2\2\u02c4\u02c5\7n\2\2\u02c5\u02c6\7p\2\2\u02c6\u02c7\7g\2\2\u02c7"+
		"\u02c8\7v\2\2\u02c8P\3\2\2\2\u02c9\u02ca\7m\2\2\u02ca\u02cb\7p\2\2\u02cb"+
		"\u02cc\7p\2\2\u02ccR\3\2\2\2\u02cd\u02ce\7e\2\2\u02ce\u02cf\7n\2\2\u02cf"+
		"\u02d0\7c\2\2\u02d0\u02d1\7u\2\2\u02d1\u02d2\7u\2\2\u02d2\u02d3\7g\2\2"+
		"\u02d3\u02d4\7t\2\2\u02d4\u02d5\7t\2\2\u02d5\u02d6\7q\2\2\u02d6\u02d7"+
		"\7t\2\2\u02d7T\3\2\2\2\u02d8\u02d9\7f\2\2\u02d9\u02da\7v\2\2\u02da\u02db"+
		"\7t\2\2\u02db\u02dc\7g\2\2\u02dc\u02dd\7g\2\2\u02ddV\3\2\2\2\u02de\u02df"+
		"\7i\2\2\u02df\u02e0\7r\2\2\u02e0X\3\2\2\2\u02e1\u02e2\7t\2\2\u02e2\u02e3"+
		"\7v\2\2\u02e3\u02e4\7t\2\2\u02e4\u02e5\7g\2\2\u02e5\u02e6\7g\2\2\u02e6"+
		"Z\3\2\2\2\u02e7\u02e8\7t\2\2\u02e8\u02e9\7h\2\2\u02e9\u02ea\7q\2\2\u02ea"+
		"\u02eb\7t\2\2\u02eb\u02ec\7g\2\2\u02ec\u02ed\7u\2\2\u02ed\u02ee\7v\2\2"+
		"\u02ee\u02ef\7t\2\2\u02ef\\\3\2\2\2\u02f0\u02f1\7t\2\2\u02f1\u02f2\7k"+
		"\2\2\u02f2\u02f3\7f\2\2\u02f3\u02f4\7i\2\2\u02f4\u02f5\7g\2\2\u02f5\u02f6"+
		"\7t\2\2\u02f6^\3\2\2\2\u02f7\u02f8\7u\2\2\u02f8\u02f9\7x\2\2\u02f9\u02fa"+
		"\7t\2\2\u02fa`\3\2\2\2\u02fb\u02fc\7t\2\2\u02fc\u02fd\7u\2\2\u02fd\u02fe"+
		"\7v\2\2\u02fe\u02ff\7c\2\2\u02ff\u0300\7v\2\2\u0300\u0301\7u\2\2\u0301"+
		"b\3\2\2\2\u0302\u0303\7e\2\2\u0303\u0304\7u\2\2\u0304\u0305\7v\2\2\u0305"+
		"\u0306\7c\2\2\u0306\u0307\7v\2\2\u0307\u0308\7u\2\2\u0308d\3\2\2\2\u0309"+
		"\u030a\7x\2\2\u030a\u030b\7u\2\2\u030b\u030c\7v\2\2\u030c\u030d\7c\2\2"+
		"\u030d\u030e\7v\2\2\u030e\u030f\7u\2\2\u030ff\3\2\2\2\u0310\u0311\7g\2"+
		"\2\u0311\u0312\7p\2\2\u0312\u0313\7v\2\2\u0313\u0314\7t\2\2\u0314\u0315"+
		"\7q\2\2\u0315\u0316\7r\2\2\u0316\u0317\7{\2\2\u0317h\3\2\2\2\u0318\u0319"+
		"\7i\2\2\u0319\u031a\7k\2\2\u031a\u031b\7p\2\2\u031b\u031c\7k\2\2\u031c"+
		"j\3\2\2\2\u031d\u031e\7f\2\2\u031e\u031f\7v\2\2\u031f\u0320\7t\2\2\u0320"+
		"\u0321\7c\2\2\u0321\u0322\7k\2\2\u0322\u0323\7p\2\2\u0323l\3\2\2\2\u0324"+
		"\u0325\7v\2\2\u0325\u0326\7t\2\2\u0326\u0327\7c\2\2\u0327\u0328\7k\2\2"+
		"\u0328\u0329\7p\2\2\u0329n\3\2\2\2\u032a\u032b\7h\2\2\u032b\u032c\7h\2"+
		"\2\u032c\u032d\7v\2\2\u032dp\3\2\2\2\u032e\u032f\7h\2\2\u032f\u0330\7"+
		"q\2\2\u0330\u0331\7t\2\2\u0331\u0332\7y\2\2\u0332\u0333\7c\2\2\u0333\u0334"+
		"\7t\2\2\u0334\u0335\7f\2\2\u0335r\3\2\2\2\u0336\u0337\7k\2\2\u0337\u0338"+
		"\7p\2\2\u0338\u0339\7x\2\2\u0339\u033a\7g\2\2\u033a\u033b\7t\2\2\u033b"+
		"\u033c\7u\2\2\u033c\u033d\7g\2\2\u033dt\3\2\2\2\u033e\u033f\7u\2\2\u033f"+
		"\u0340\7v\2\2\u0340\u0341\7c\2\2\u0341\u0342\7p\2\2\u0342\u0343\7f\2\2"+
		"\u0343\u0344\7c\2\2\u0344\u0345\7t\2\2\u0345\u0346\7f\2\2\u0346v\3\2\2"+
		"\2\u0347\u0348\7w\2\2\u0348\u0349\7p\2\2\u0349\u034a\7k\2\2\u034a\u034b"+
		"\7v\2\2\u034b\u034c\7c\2\2\u034c\u034d\7t\2\2\u034d\u034e\7{\2\2\u034e"+
		"x\3\2\2\2\u034f\u0350\7o\2\2\u0350\u0351\7c\2\2\u0351\u0352\7v\2\2\u0352"+
		"\u0353\7t\2\2\u0353\u0354\7k\2\2\u0354\u0355\7z\2\2\u0355z\3\2\2\2\u0356"+
		"\u0357\7x\2\2\u0357\u0358\7g\2\2\u0358\u0359\7e\2\2\u0359\u035a\7v\2\2"+
		"\u035a|\3\2\2\2\u035b\u035c\7s\2\2\u035c\u035d\7w\2\2\u035d\u035e\7g\2"+
		"\2\u035e\u035f\7t\2\2\u035f\u0360\7{\2\2\u0360\u0361\7C\2\2\u0361\u0362"+
		"\7t\2\2\u0362\u0363\7i\2\2\u0363\u0364\7u\2\2\u0364~\3\2\2\2\u0365\u0366"+
		"\7o\2\2\u0366\u0367\7q\2\2\u0367\u0368\7f\2\2\u0368\u0369\7g\2\2\u0369"+
		"\u036a\7n\2\2\u036a\u0080\3\2\2\2\u036b\u036c\7h\2\2\u036c\u036d\7k\2"+
		"\2\u036d\u036e\7g\2\2\u036e\u036f\7n\2\2\u036f\u0370\7f\2\2\u0370\u0371"+
		"\7u\2\2\u0371\u0082\3\2\2\2\u0372\u0373\7t\2\2\u0373\u0374\7g\2\2\u0374"+
		"\u0375\7i\2\2\u0375\u0376\7k\2\2\u0376\u0377\7q\2\2\u0377\u0378\7p\2\2"+
		"\u0378\u0084\3\2\2\2\u0379\u037a\7t\2\2\u037a\u037b\7o\2\2\u037b\u0086"+
		"\3\2\2\2\u037c\u037d\7n\2\2\u037d\u037e\7u\2\2\u037e\u0088\3\2\2\2\u037f"+
		"\u0380\7r\2\2\u0380\u0381\7t\2\2\u0381\u0382\7k\2\2\u0382\u0383\7p\2\2"+
		"\u0383\u0384\7v\2\2\u0384\u008a\3\2\2\2\u0385\u0386\7r\2\2\u0386\u0387"+
		"\7t\2\2\u0387\u0388\7g\2\2\u0388\u0389\7f\2\2\u0389\u038a\7k\2\2\u038a"+
		"\u038b\7e\2\2\u038b\u038c\7v\2\2\u038c\u008c\3\2\2\2\u038d\u038e\7m\2"+
		"\2\u038e\u008e\3\2\2\2\u038f\u0390\7n\2\2\u0390\u0391\7c\2\2\u0391\u0392"+
		"\7o\2\2\u0392\u0393\7d\2\2\u0393\u0394\7f\2\2\u0394\u0395\7c\2\2\u0395"+
		"\u0090\3\2\2\2\u0396\u0397\7u\2\2\u0397\u0398\7x\2\2\u0398\u0399\7o\2"+
		"\2\u0399\u0092\3\2\2\2\u039a\u039b\7e\2\2\u039b\u039c\7r\2\2\u039c\u0094"+
		"\3\2\2\2\u039d\u039e\7e\2\2\u039e\u039f\7p\2\2\u039f\u0096\3\2\2\2\u03a0"+
		"\u03a1\7s\2\2\u03a1\u03a2\7w\2\2\u03a2\u03a3\7g\2\2\u03a3\u03a4\7t\2\2"+
		"\u03a4\u03a5\7{\2\2\u03a5\u0098\3\2\2\2\u03a6\u03a7\7g\2\2\u03a7\u03a8"+
		"\7z\2\2\u03a8\u03a9\7g\2\2\u03a9\u03aa\7e\2\2\u03aa\u03ab\7w\2\2\u03ab"+
		"\u03ac\7v\2\2\u03ac\u03ad\7g\2\2\u03ad\u009a\3\2\2\2\u03ae\u03af\7]\2"+
		"\2\u03af\u009c\3\2\2\2\u03b0\u03b1\7_\2\2\u03b1\u009e\3\2\2\2\u03b2\u03b3"+
		"\7*\2\2\u03b3\u00a0\3\2\2\2\u03b4\u03b5\7+\2\2\u03b5\u00a2\3\2\2\2\u03b6"+
		"\u03b7\7}\2\2\u03b7\u00a4\3\2\2\2\u03b8\u03b9\7\177\2\2\u03b9\u00a6\3"+
		"\2\2\2\u03ba\u03bb\7$\2\2\u03bb\u00a8\3\2\2\2\u03bc\u03bd\7.\2\2\u03bd"+
		"\u00aa\3\2\2\2\u03be\u03bf\7?\2\2\u03bf\u00ac\3\2\2\2\u03c0\u03c4\t\2"+
		"\2\2\u03c1\u03c3\t\3\2\2\u03c2\u03c1\3\2\2\2\u03c3\u03c6\3\2\2\2\u03c4"+
		"\u03c2\3\2\2\2\u03c4\u03c5\3\2\2\2\u03c5\u00ae\3\2\2\2\u03c6\u03c4\3\2"+
		"\2\2\u03c7\u03c8\5\u00b3Z\2\u03c8\u03c9\7\60\2\2\u03c9\u03ca\5\u00b3Z"+
		"\2\u03ca\u00b0\3\2\2\2\u03cb\u03cc\5\u00b3Z\2\u03cc\u00b2\3\2\2\2\u03cd"+
		"\u03cf\5\u00b5[\2\u03ce\u03cd\3\2\2\2\u03cf\u03d0\3\2\2\2\u03d0\u03ce"+
		"\3\2\2\2\u03d0\u03d1\3\2\2\2\u03d1\u00b4\3\2\2\2\u03d2\u03d3\4\62;\2\u03d3"+
		"\u00b6\3\2\2\2\u03d4\u03d6\5\u00a7T\2\u03d5\u03d7\n\4\2\2\u03d6\u03d5"+
		"\3\2\2\2\u03d7\u03d8\3\2\2\2\u03d8\u03d9\3\2\2\2\u03d8\u03d6\3\2\2\2\u03d9"+
		"\u03da\3\2\2\2\u03da\u03db\5\u00a7T\2\u03db\u00b8\3\2\2\2\u03dc\u03de"+
		"\t\5\2\2\u03dd\u03dc\3\2\2\2\u03de\u03df\3\2\2\2\u03df\u03dd\3\2\2\2\u03df"+
		"\u03e0\3\2\2\2\u03e0\u03e1\3\2\2\2\u03e1\u03e2\b]\2\2\u03e2\u00ba\3\2"+
		"\2\2\7\2\u03c4\u03d0\u03d8\u03df\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
