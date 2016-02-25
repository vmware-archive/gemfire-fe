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
		GAUSSIANKERNEL=1, LAPLACEKERNEL=2, LINEARKERNEL=3, PEARSONKERNEL=4, POLYNOMIALKERNEL=5, 
		HYPERBOLICTANGENTKERNEL=6, THINPLATEPLINEKERNEL=7, SPARSEGAUSSIANKERNEL=8, 
		SPARSELAPLACEKERNEL=9, SPARSELINEARKERNEL=10, SPARSEPOLYNOMIALKERNEL=11, 
		SPARSEHYPERBOLICTANGENTKERNEL=12, SPARSETHINPLATEPLINEKERNEL=13, BINARYSPARSEGAUSSIANKERNEL=14, 
		BINARYSPARSELAPLACEKERNEL=15, BINARYSPARSELINEARKERNEL=16, BINARYSPARSEPOLYNOMIALKERNEL=17, 
		BINARYSPARSEHYPERBOLICTANGENTKERNEL=18, BINARYSPARSETHINPLATEPLINEKERNEL=19, 
		DTRAIN=20, TRAIN=21, FFT=22, FORWARD=23, INVERSE=24, STANDARD=25, UNITARY=26, 
		MATRIX=27, VECTOR=28, QUERYARGS=29, MODEL=30, FIELDS=31, REGION=32, RM=33, 
		LS=34, PRINT=35, PREDICT=36, K=37, LAMBDA=38, GP=39, SVM=40, CP=41, CN=42, 
		QUERY=43, EXECUTE=44, LBRACKET=45, RBRACKET=46, LPAREN=47, RPAREN=48, 
		LBRACE=49, RBRACE=50, DBLQUOTES=51, COMMA=52, EQUALS=53, IDENTIFIER=54, 
		DIGIT=55, NUMBER=56, QUOTEDSTRING=57, WS=58;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"GAUSSIANKERNEL", "LAPLACEKERNEL", "LINEARKERNEL", "PEARSONKERNEL", "POLYNOMIALKERNEL", 
		"HYPERBOLICTANGENTKERNEL", "THINPLATEPLINEKERNEL", "SPARSEGAUSSIANKERNEL", 
		"SPARSELAPLACEKERNEL", "SPARSELINEARKERNEL", "SPARSEPOLYNOMIALKERNEL", 
		"SPARSEHYPERBOLICTANGENTKERNEL", "SPARSETHINPLATEPLINEKERNEL", "BINARYSPARSEGAUSSIANKERNEL", 
		"BINARYSPARSELAPLACEKERNEL", "BINARYSPARSELINEARKERNEL", "BINARYSPARSEPOLYNOMIALKERNEL", 
		"BINARYSPARSEHYPERBOLICTANGENTKERNEL", "BINARYSPARSETHINPLATEPLINEKERNEL", 
		"DTRAIN", "TRAIN", "FFT", "FORWARD", "INVERSE", "STANDARD", "UNITARY", 
		"MATRIX", "VECTOR", "QUERYARGS", "MODEL", "FIELDS", "REGION", "RM", "LS", 
		"PRINT", "PREDICT", "K", "LAMBDA", "GP", "SVM", "CP", "CN", "QUERY", "EXECUTE", 
		"LBRACKET", "RBRACKET", "LPAREN", "RPAREN", "LBRACE", "RBRACE", "DBLQUOTES", 
		"COMMA", "EQUALS", "IDENTIFIER", "DIGIT", "NUMBER", "QUOTEDSTRING", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'gausskernel'", "'laplacekernel'", "'linearkernel'", "'pearsonkernel'", 
		"'polykernel'", "'hypertangentkernel'", "'thinplatesplinekernel'", "'sparsegausskernel'", 
		"'sparselaplacekernel'", "'sparselinearkernel'", "'sparsepolykernel'", 
		"'sparsehypertangentkernel'", "'sparsethinplatesplinekernel'", "'binarysparsegausskernel'", 
		"'binarysparselaplacekernel'", "'binarysparselinearkernel'", "'binarysparsepolykernel'", 
		"'binarysparsehypertangentkernel'", "'binarysparsethinplatesplinekernel'", 
		"'dtrain'", "'train'", "'fft'", "'forward'", "'inverse'", "'standard'", 
		"'unitary'", "'matrix'", "'vect'", "'queryArgs'", "'model'", "'fields'", 
		"'region'", "'rm'", "'ls'", "'print'", "'predict'", "'k'", "'lambda'", 
		"'gp'", "'svm'", "'cp'", "'cn'", "'query'", "'execute'", "'['", "']'", 
		"'('", "')'", "'{'", "'}'", "'\"'", "','", "'='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "GAUSSIANKERNEL", "LAPLACEKERNEL", "LINEARKERNEL", "PEARSONKERNEL", 
		"POLYNOMIALKERNEL", "HYPERBOLICTANGENTKERNEL", "THINPLATEPLINEKERNEL", 
		"SPARSEGAUSSIANKERNEL", "SPARSELAPLACEKERNEL", "SPARSELINEARKERNEL", "SPARSEPOLYNOMIALKERNEL", 
		"SPARSEHYPERBOLICTANGENTKERNEL", "SPARSETHINPLATEPLINEKERNEL", "BINARYSPARSEGAUSSIANKERNEL", 
		"BINARYSPARSELAPLACEKERNEL", "BINARYSPARSELINEARKERNEL", "BINARYSPARSEPOLYNOMIALKERNEL", 
		"BINARYSPARSEHYPERBOLICTANGENTKERNEL", "BINARYSPARSETHINPLATEPLINEKERNEL", 
		"DTRAIN", "TRAIN", "FFT", "FORWARD", "INVERSE", "STANDARD", "UNITARY", 
		"MATRIX", "VECTOR", "QUERYARGS", "MODEL", "FIELDS", "REGION", "RM", "LS", 
		"PRINT", "PREDICT", "K", "LAMBDA", "GP", "SVM", "CP", "CN", "QUERY", "EXECUTE", 
		"LBRACKET", "RBRACKET", "LPAREN", "RPAREN", "LBRACE", "RBRACE", "DBLQUOTES", 
		"COMMA", "EQUALS", "IDENTIFIER", "DIGIT", "NUMBER", "QUOTEDSTRING", "WS"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2<\u02cd\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32"+
		"\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33"+
		"\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\36\3\36"+
		"\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3\37"+
		"\3 \3 \3 \3 \3 \3 \3 \3!\3!\3!\3!\3!\3!\3!\3\"\3\"\3\"\3#\3#\3#\3$\3$"+
		"\3$\3$\3$\3$\3%\3%\3%\3%\3%\3%\3%\3%\3&\3&\3\'\3\'\3\'\3\'\3\'\3\'\3\'"+
		"\3(\3(\3(\3)\3)\3)\3)\3*\3*\3*\3+\3+\3+\3,\3,\3,\3,\3,\3,\3-\3-\3-\3-"+
		"\3-\3-\3-\3-\3.\3.\3/\3/\3\60\3\60\3\61\3\61\3\62\3\62\3\63\3\63\3\64"+
		"\3\64\3\65\3\65\3\66\3\66\3\67\3\67\7\67\u02ab\n\67\f\67\16\67\u02ae\13"+
		"\67\38\38\39\69\u02b3\n9\r9\169\u02b4\39\39\69\u02b9\n9\r9\169\u02ba\5"+
		"9\u02bd\n9\3:\3:\6:\u02c1\n:\r:\16:\u02c2\3:\3:\3;\6;\u02c8\n;\r;\16;"+
		"\u02c9\3;\3;\3\u02c2\2<\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f"+
		"\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63"+
		"\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62"+
		"c\63e\64g\65i\66k\67m8o9q:s;u<\3\2\7\4\2C\\c|\7\2\60\60\62;C\\aac|\3\2"+
		"\62;\3\2$$\5\2\13\f\16\17\"\"\u02d2\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2"+
		"\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23"+
		"\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2"+
		"\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2"+
		"\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3"+
		"\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2"+
		"\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2"+
		"\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2["+
		"\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2"+
		"\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2"+
		"\2u\3\2\2\2\3w\3\2\2\2\5\u0083\3\2\2\2\7\u0091\3\2\2\2\t\u009e\3\2\2\2"+
		"\13\u00ac\3\2\2\2\r\u00b7\3\2\2\2\17\u00ca\3\2\2\2\21\u00e0\3\2\2\2\23"+
		"\u00f2\3\2\2\2\25\u0106\3\2\2\2\27\u0119\3\2\2\2\31\u012a\3\2\2\2\33\u0143"+
		"\3\2\2\2\35\u015f\3\2\2\2\37\u0177\3\2\2\2!\u0191\3\2\2\2#\u01aa\3\2\2"+
		"\2%\u01c1\3\2\2\2\'\u01e0\3\2\2\2)\u0202\3\2\2\2+\u0209\3\2\2\2-\u020f"+
		"\3\2\2\2/\u0213\3\2\2\2\61\u021b\3\2\2\2\63\u0223\3\2\2\2\65\u022c\3\2"+
		"\2\2\67\u0234\3\2\2\29\u023b\3\2\2\2;\u0240\3\2\2\2=\u024a\3\2\2\2?\u0250"+
		"\3\2\2\2A\u0257\3\2\2\2C\u025e\3\2\2\2E\u0261\3\2\2\2G\u0264\3\2\2\2I"+
		"\u026a\3\2\2\2K\u0272\3\2\2\2M\u0274\3\2\2\2O\u027b\3\2\2\2Q\u027e\3\2"+
		"\2\2S\u0282\3\2\2\2U\u0285\3\2\2\2W\u0288\3\2\2\2Y\u028e\3\2\2\2[\u0296"+
		"\3\2\2\2]\u0298\3\2\2\2_\u029a\3\2\2\2a\u029c\3\2\2\2c\u029e\3\2\2\2e"+
		"\u02a0\3\2\2\2g\u02a2\3\2\2\2i\u02a4\3\2\2\2k\u02a6\3\2\2\2m\u02a8\3\2"+
		"\2\2o\u02af\3\2\2\2q\u02b2\3\2\2\2s\u02be\3\2\2\2u\u02c7\3\2\2\2wx\7i"+
		"\2\2xy\7c\2\2yz\7w\2\2z{\7u\2\2{|\7u\2\2|}\7m\2\2}~\7g\2\2~\177\7t\2\2"+
		"\177\u0080\7p\2\2\u0080\u0081\7g\2\2\u0081\u0082\7n\2\2\u0082\4\3\2\2"+
		"\2\u0083\u0084\7n\2\2\u0084\u0085\7c\2\2\u0085\u0086\7r\2\2\u0086\u0087"+
		"\7n\2\2\u0087\u0088\7c\2\2\u0088\u0089\7e\2\2\u0089\u008a\7g\2\2\u008a"+
		"\u008b\7m\2\2\u008b\u008c\7g\2\2\u008c\u008d\7t\2\2\u008d\u008e\7p\2\2"+
		"\u008e\u008f\7g\2\2\u008f\u0090\7n\2\2\u0090\6\3\2\2\2\u0091\u0092\7n"+
		"\2\2\u0092\u0093\7k\2\2\u0093\u0094\7p\2\2\u0094\u0095\7g\2\2\u0095\u0096"+
		"\7c\2\2\u0096\u0097\7t\2\2\u0097\u0098\7m\2\2\u0098\u0099\7g\2\2\u0099"+
		"\u009a\7t\2\2\u009a\u009b\7p\2\2\u009b\u009c\7g\2\2\u009c\u009d\7n\2\2"+
		"\u009d\b\3\2\2\2\u009e\u009f\7r\2\2\u009f\u00a0\7g\2\2\u00a0\u00a1\7c"+
		"\2\2\u00a1\u00a2\7t\2\2\u00a2\u00a3\7u\2\2\u00a3\u00a4\7q\2\2\u00a4\u00a5"+
		"\7p\2\2\u00a5\u00a6\7m\2\2\u00a6\u00a7\7g\2\2\u00a7\u00a8\7t\2\2\u00a8"+
		"\u00a9\7p\2\2\u00a9\u00aa\7g\2\2\u00aa\u00ab\7n\2\2\u00ab\n\3\2\2\2\u00ac"+
		"\u00ad\7r\2\2\u00ad\u00ae\7q\2\2\u00ae\u00af\7n\2\2\u00af\u00b0\7{\2\2"+
		"\u00b0\u00b1\7m\2\2\u00b1\u00b2\7g\2\2\u00b2\u00b3\7t\2\2\u00b3\u00b4"+
		"\7p\2\2\u00b4\u00b5\7g\2\2\u00b5\u00b6\7n\2\2\u00b6\f\3\2\2\2\u00b7\u00b8"+
		"\7j\2\2\u00b8\u00b9\7{\2\2\u00b9\u00ba\7r\2\2\u00ba\u00bb\7g\2\2\u00bb"+
		"\u00bc\7t\2\2\u00bc\u00bd\7v\2\2\u00bd\u00be\7c\2\2\u00be\u00bf\7p\2\2"+
		"\u00bf\u00c0\7i\2\2\u00c0\u00c1\7g\2\2\u00c1\u00c2\7p\2\2\u00c2\u00c3"+
		"\7v\2\2\u00c3\u00c4\7m\2\2\u00c4\u00c5\7g\2\2\u00c5\u00c6\7t\2\2\u00c6"+
		"\u00c7\7p\2\2\u00c7\u00c8\7g\2\2\u00c8\u00c9\7n\2\2\u00c9\16\3\2\2\2\u00ca"+
		"\u00cb\7v\2\2\u00cb\u00cc\7j\2\2\u00cc\u00cd\7k\2\2\u00cd\u00ce\7p\2\2"+
		"\u00ce\u00cf\7r\2\2\u00cf\u00d0\7n\2\2\u00d0\u00d1\7c\2\2\u00d1\u00d2"+
		"\7v\2\2\u00d2\u00d3\7g\2\2\u00d3\u00d4\7u\2\2\u00d4\u00d5\7r\2\2\u00d5"+
		"\u00d6\7n\2\2\u00d6\u00d7\7k\2\2\u00d7\u00d8\7p\2\2\u00d8\u00d9\7g\2\2"+
		"\u00d9\u00da\7m\2\2\u00da\u00db\7g\2\2\u00db\u00dc\7t\2\2\u00dc\u00dd"+
		"\7p\2\2\u00dd\u00de\7g\2\2\u00de\u00df\7n\2\2\u00df\20\3\2\2\2\u00e0\u00e1"+
		"\7u\2\2\u00e1\u00e2\7r\2\2\u00e2\u00e3\7c\2\2\u00e3\u00e4\7t\2\2\u00e4"+
		"\u00e5\7u\2\2\u00e5\u00e6\7g\2\2\u00e6\u00e7\7i\2\2\u00e7\u00e8\7c\2\2"+
		"\u00e8\u00e9\7w\2\2\u00e9\u00ea\7u\2\2\u00ea\u00eb\7u\2\2\u00eb\u00ec"+
		"\7m\2\2\u00ec\u00ed\7g\2\2\u00ed\u00ee\7t\2\2\u00ee\u00ef\7p\2\2\u00ef"+
		"\u00f0\7g\2\2\u00f0\u00f1\7n\2\2\u00f1\22\3\2\2\2\u00f2\u00f3\7u\2\2\u00f3"+
		"\u00f4\7r\2\2\u00f4\u00f5\7c\2\2\u00f5\u00f6\7t\2\2\u00f6\u00f7\7u\2\2"+
		"\u00f7\u00f8\7g\2\2\u00f8\u00f9\7n\2\2\u00f9\u00fa\7c\2\2\u00fa\u00fb"+
		"\7r\2\2\u00fb\u00fc\7n\2\2\u00fc\u00fd\7c\2\2\u00fd\u00fe\7e\2\2\u00fe"+
		"\u00ff\7g\2\2\u00ff\u0100\7m\2\2\u0100\u0101\7g\2\2\u0101\u0102\7t\2\2"+
		"\u0102\u0103\7p\2\2\u0103\u0104\7g\2\2\u0104\u0105\7n\2\2\u0105\24\3\2"+
		"\2\2\u0106\u0107\7u\2\2\u0107\u0108\7r\2\2\u0108\u0109\7c\2\2\u0109\u010a"+
		"\7t\2\2\u010a\u010b\7u\2\2\u010b\u010c\7g\2\2\u010c\u010d\7n\2\2\u010d"+
		"\u010e\7k\2\2\u010e\u010f\7p\2\2\u010f\u0110\7g\2\2\u0110\u0111\7c\2\2"+
		"\u0111\u0112\7t\2\2\u0112\u0113\7m\2\2\u0113\u0114\7g\2\2\u0114\u0115"+
		"\7t\2\2\u0115\u0116\7p\2\2\u0116\u0117\7g\2\2\u0117\u0118\7n\2\2\u0118"+
		"\26\3\2\2\2\u0119\u011a\7u\2\2\u011a\u011b\7r\2\2\u011b\u011c\7c\2\2\u011c"+
		"\u011d\7t\2\2\u011d\u011e\7u\2\2\u011e\u011f\7g\2\2\u011f\u0120\7r\2\2"+
		"\u0120\u0121\7q\2\2\u0121\u0122\7n\2\2\u0122\u0123\7{\2\2\u0123\u0124"+
		"\7m\2\2\u0124\u0125\7g\2\2\u0125\u0126\7t\2\2\u0126\u0127\7p\2\2\u0127"+
		"\u0128\7g\2\2\u0128\u0129\7n\2\2\u0129\30\3\2\2\2\u012a\u012b\7u\2\2\u012b"+
		"\u012c\7r\2\2\u012c\u012d\7c\2\2\u012d\u012e\7t\2\2\u012e\u012f\7u\2\2"+
		"\u012f\u0130\7g\2\2\u0130\u0131\7j\2\2\u0131\u0132\7{\2\2\u0132\u0133"+
		"\7r\2\2\u0133\u0134\7g\2\2\u0134\u0135\7t\2\2\u0135\u0136\7v\2\2\u0136"+
		"\u0137\7c\2\2\u0137\u0138\7p\2\2\u0138\u0139\7i\2\2\u0139\u013a\7g\2\2"+
		"\u013a\u013b\7p\2\2\u013b\u013c\7v\2\2\u013c\u013d\7m\2\2\u013d\u013e"+
		"\7g\2\2\u013e\u013f\7t\2\2\u013f\u0140\7p\2\2\u0140\u0141\7g\2\2\u0141"+
		"\u0142\7n\2\2\u0142\32\3\2\2\2\u0143\u0144\7u\2\2\u0144\u0145\7r\2\2\u0145"+
		"\u0146\7c\2\2\u0146\u0147\7t\2\2\u0147\u0148\7u\2\2\u0148\u0149\7g\2\2"+
		"\u0149\u014a\7v\2\2\u014a\u014b\7j\2\2\u014b\u014c\7k\2\2\u014c\u014d"+
		"\7p\2\2\u014d\u014e\7r\2\2\u014e\u014f\7n\2\2\u014f\u0150\7c\2\2\u0150"+
		"\u0151\7v\2\2\u0151\u0152\7g\2\2\u0152\u0153\7u\2\2\u0153\u0154\7r\2\2"+
		"\u0154\u0155\7n\2\2\u0155\u0156\7k\2\2\u0156\u0157\7p\2\2\u0157\u0158"+
		"\7g\2\2\u0158\u0159\7m\2\2\u0159\u015a\7g\2\2\u015a\u015b\7t\2\2\u015b"+
		"\u015c\7p\2\2\u015c\u015d\7g\2\2\u015d\u015e\7n\2\2\u015e\34\3\2\2\2\u015f"+
		"\u0160\7d\2\2\u0160\u0161\7k\2\2\u0161\u0162\7p\2\2\u0162\u0163\7c\2\2"+
		"\u0163\u0164\7t\2\2\u0164\u0165\7{\2\2\u0165\u0166\7u\2\2\u0166\u0167"+
		"\7r\2\2\u0167\u0168\7c\2\2\u0168\u0169\7t\2\2\u0169\u016a\7u\2\2\u016a"+
		"\u016b\7g\2\2\u016b\u016c\7i\2\2\u016c\u016d\7c\2\2\u016d\u016e\7w\2\2"+
		"\u016e\u016f\7u\2\2\u016f\u0170\7u\2\2\u0170\u0171\7m\2\2\u0171\u0172"+
		"\7g\2\2\u0172\u0173\7t\2\2\u0173\u0174\7p\2\2\u0174\u0175\7g\2\2\u0175"+
		"\u0176\7n\2\2\u0176\36\3\2\2\2\u0177\u0178\7d\2\2\u0178\u0179\7k\2\2\u0179"+
		"\u017a\7p\2\2\u017a\u017b\7c\2\2\u017b\u017c\7t\2\2\u017c\u017d\7{\2\2"+
		"\u017d\u017e\7u\2\2\u017e\u017f\7r\2\2\u017f\u0180\7c\2\2\u0180\u0181"+
		"\7t\2\2\u0181\u0182\7u\2\2\u0182\u0183\7g\2\2\u0183\u0184\7n\2\2\u0184"+
		"\u0185\7c\2\2\u0185\u0186\7r\2\2\u0186\u0187\7n\2\2\u0187\u0188\7c\2\2"+
		"\u0188\u0189\7e\2\2\u0189\u018a\7g\2\2\u018a\u018b\7m\2\2\u018b\u018c"+
		"\7g\2\2\u018c\u018d\7t\2\2\u018d\u018e\7p\2\2\u018e\u018f\7g\2\2\u018f"+
		"\u0190\7n\2\2\u0190 \3\2\2\2\u0191\u0192\7d\2\2\u0192\u0193\7k\2\2\u0193"+
		"\u0194\7p\2\2\u0194\u0195\7c\2\2\u0195\u0196\7t\2\2\u0196\u0197\7{\2\2"+
		"\u0197\u0198\7u\2\2\u0198\u0199\7r\2\2\u0199\u019a\7c\2\2\u019a\u019b"+
		"\7t\2\2\u019b\u019c\7u\2\2\u019c\u019d\7g\2\2\u019d\u019e\7n\2\2\u019e"+
		"\u019f\7k\2\2\u019f\u01a0\7p\2\2\u01a0\u01a1\7g\2\2\u01a1\u01a2\7c\2\2"+
		"\u01a2\u01a3\7t\2\2\u01a3\u01a4\7m\2\2\u01a4\u01a5\7g\2\2\u01a5\u01a6"+
		"\7t\2\2\u01a6\u01a7\7p\2\2\u01a7\u01a8\7g\2\2\u01a8\u01a9\7n\2\2\u01a9"+
		"\"\3\2\2\2\u01aa\u01ab\7d\2\2\u01ab\u01ac\7k\2\2\u01ac\u01ad\7p\2\2\u01ad"+
		"\u01ae\7c\2\2\u01ae\u01af\7t\2\2\u01af\u01b0\7{\2\2\u01b0\u01b1\7u\2\2"+
		"\u01b1\u01b2\7r\2\2\u01b2\u01b3\7c\2\2\u01b3\u01b4\7t\2\2\u01b4\u01b5"+
		"\7u\2\2\u01b5\u01b6\7g\2\2\u01b6\u01b7\7r\2\2\u01b7\u01b8\7q\2\2\u01b8"+
		"\u01b9\7n\2\2\u01b9\u01ba\7{\2\2\u01ba\u01bb\7m\2\2\u01bb\u01bc\7g\2\2"+
		"\u01bc\u01bd\7t\2\2\u01bd\u01be\7p\2\2\u01be\u01bf\7g\2\2\u01bf\u01c0"+
		"\7n\2\2\u01c0$\3\2\2\2\u01c1\u01c2\7d\2\2\u01c2\u01c3\7k\2\2\u01c3\u01c4"+
		"\7p\2\2\u01c4\u01c5\7c\2\2\u01c5\u01c6\7t\2\2\u01c6\u01c7\7{\2\2\u01c7"+
		"\u01c8\7u\2\2\u01c8\u01c9\7r\2\2\u01c9\u01ca\7c\2\2\u01ca\u01cb\7t\2\2"+
		"\u01cb\u01cc\7u\2\2\u01cc\u01cd\7g\2\2\u01cd\u01ce\7j\2\2\u01ce\u01cf"+
		"\7{\2\2\u01cf\u01d0\7r\2\2\u01d0\u01d1\7g\2\2\u01d1\u01d2\7t\2\2\u01d2"+
		"\u01d3\7v\2\2\u01d3\u01d4\7c\2\2\u01d4\u01d5\7p\2\2\u01d5\u01d6\7i\2\2"+
		"\u01d6\u01d7\7g\2\2\u01d7\u01d8\7p\2\2\u01d8\u01d9\7v\2\2\u01d9\u01da"+
		"\7m\2\2\u01da\u01db\7g\2\2\u01db\u01dc\7t\2\2\u01dc\u01dd\7p\2\2\u01dd"+
		"\u01de\7g\2\2\u01de\u01df\7n\2\2\u01df&\3\2\2\2\u01e0\u01e1\7d\2\2\u01e1"+
		"\u01e2\7k\2\2\u01e2\u01e3\7p\2\2\u01e3\u01e4\7c\2\2\u01e4\u01e5\7t\2\2"+
		"\u01e5\u01e6\7{\2\2\u01e6\u01e7\7u\2\2\u01e7\u01e8\7r\2\2\u01e8\u01e9"+
		"\7c\2\2\u01e9\u01ea\7t\2\2\u01ea\u01eb\7u\2\2\u01eb\u01ec\7g\2\2\u01ec"+
		"\u01ed\7v\2\2\u01ed\u01ee\7j\2\2\u01ee\u01ef\7k\2\2\u01ef\u01f0\7p\2\2"+
		"\u01f0\u01f1\7r\2\2\u01f1\u01f2\7n\2\2\u01f2\u01f3\7c\2\2\u01f3\u01f4"+
		"\7v\2\2\u01f4\u01f5\7g\2\2\u01f5\u01f6\7u\2\2\u01f6\u01f7\7r\2\2\u01f7"+
		"\u01f8\7n\2\2\u01f8\u01f9\7k\2\2\u01f9\u01fa\7p\2\2\u01fa\u01fb\7g\2\2"+
		"\u01fb\u01fc\7m\2\2\u01fc\u01fd\7g\2\2\u01fd\u01fe\7t\2\2\u01fe\u01ff"+
		"\7p\2\2\u01ff\u0200\7g\2\2\u0200\u0201\7n\2\2\u0201(\3\2\2\2\u0202\u0203"+
		"\7f\2\2\u0203\u0204\7v\2\2\u0204\u0205\7t\2\2\u0205\u0206\7c\2\2\u0206"+
		"\u0207\7k\2\2\u0207\u0208\7p\2\2\u0208*\3\2\2\2\u0209\u020a\7v\2\2\u020a"+
		"\u020b\7t\2\2\u020b\u020c\7c\2\2\u020c\u020d\7k\2\2\u020d\u020e\7p\2\2"+
		"\u020e,\3\2\2\2\u020f\u0210\7h\2\2\u0210\u0211\7h\2\2\u0211\u0212\7v\2"+
		"\2\u0212.\3\2\2\2\u0213\u0214\7h\2\2\u0214\u0215\7q\2\2\u0215\u0216\7"+
		"t\2\2\u0216\u0217\7y\2\2\u0217\u0218\7c\2\2\u0218\u0219\7t\2\2\u0219\u021a"+
		"\7f\2\2\u021a\60\3\2\2\2\u021b\u021c\7k\2\2\u021c\u021d\7p\2\2\u021d\u021e"+
		"\7x\2\2\u021e\u021f\7g\2\2\u021f\u0220\7t\2\2\u0220\u0221\7u\2\2\u0221"+
		"\u0222\7g\2\2\u0222\62\3\2\2\2\u0223\u0224\7u\2\2\u0224\u0225\7v\2\2\u0225"+
		"\u0226\7c\2\2\u0226\u0227\7p\2\2\u0227\u0228\7f\2\2\u0228\u0229\7c\2\2"+
		"\u0229\u022a\7t\2\2\u022a\u022b\7f\2\2\u022b\64\3\2\2\2\u022c\u022d\7"+
		"w\2\2\u022d\u022e\7p\2\2\u022e\u022f\7k\2\2\u022f\u0230\7v\2\2\u0230\u0231"+
		"\7c\2\2\u0231\u0232\7t\2\2\u0232\u0233\7{\2\2\u0233\66\3\2\2\2\u0234\u0235"+
		"\7o\2\2\u0235\u0236\7c\2\2\u0236\u0237\7v\2\2\u0237\u0238\7t\2\2\u0238"+
		"\u0239\7k\2\2\u0239\u023a\7z\2\2\u023a8\3\2\2\2\u023b\u023c\7x\2\2\u023c"+
		"\u023d\7g\2\2\u023d\u023e\7e\2\2\u023e\u023f\7v\2\2\u023f:\3\2\2\2\u0240"+
		"\u0241\7s\2\2\u0241\u0242\7w\2\2\u0242\u0243\7g\2\2\u0243\u0244\7t\2\2"+
		"\u0244\u0245\7{\2\2\u0245\u0246\7C\2\2\u0246\u0247\7t\2\2\u0247\u0248"+
		"\7i\2\2\u0248\u0249\7u\2\2\u0249<\3\2\2\2\u024a\u024b\7o\2\2\u024b\u024c"+
		"\7q\2\2\u024c\u024d\7f\2\2\u024d\u024e\7g\2\2\u024e\u024f\7n\2\2\u024f"+
		">\3\2\2\2\u0250\u0251\7h\2\2\u0251\u0252\7k\2\2\u0252\u0253\7g\2\2\u0253"+
		"\u0254\7n\2\2\u0254\u0255\7f\2\2\u0255\u0256\7u\2\2\u0256@\3\2\2\2\u0257"+
		"\u0258\7t\2\2\u0258\u0259\7g\2\2\u0259\u025a\7i\2\2\u025a\u025b\7k\2\2"+
		"\u025b\u025c\7q\2\2\u025c\u025d\7p\2\2\u025dB\3\2\2\2\u025e\u025f\7t\2"+
		"\2\u025f\u0260\7o\2\2\u0260D\3\2\2\2\u0261\u0262\7n\2\2\u0262\u0263\7"+
		"u\2\2\u0263F\3\2\2\2\u0264\u0265\7r\2\2\u0265\u0266\7t\2\2\u0266\u0267"+
		"\7k\2\2\u0267\u0268\7p\2\2\u0268\u0269\7v\2\2\u0269H\3\2\2\2\u026a\u026b"+
		"\7r\2\2\u026b\u026c\7t\2\2\u026c\u026d\7g\2\2\u026d\u026e\7f\2\2\u026e"+
		"\u026f\7k\2\2\u026f\u0270\7e\2\2\u0270\u0271\7v\2\2\u0271J\3\2\2\2\u0272"+
		"\u0273\7m\2\2\u0273L\3\2\2\2\u0274\u0275\7n\2\2\u0275\u0276\7c\2\2\u0276"+
		"\u0277\7o\2\2\u0277\u0278\7d\2\2\u0278\u0279\7f\2\2\u0279\u027a\7c\2\2"+
		"\u027aN\3\2\2\2\u027b\u027c\7i\2\2\u027c\u027d\7r\2\2\u027dP\3\2\2\2\u027e"+
		"\u027f\7u\2\2\u027f\u0280\7x\2\2\u0280\u0281\7o\2\2\u0281R\3\2\2\2\u0282"+
		"\u0283\7e\2\2\u0283\u0284\7r\2\2\u0284T\3\2\2\2\u0285\u0286\7e\2\2\u0286"+
		"\u0287\7p\2\2\u0287V\3\2\2\2\u0288\u0289\7s\2\2\u0289\u028a\7w\2\2\u028a"+
		"\u028b\7g\2\2\u028b\u028c\7t\2\2\u028c\u028d\7{\2\2\u028dX\3\2\2\2\u028e"+
		"\u028f\7g\2\2\u028f\u0290\7z\2\2\u0290\u0291\7g\2\2\u0291\u0292\7e\2\2"+
		"\u0292\u0293\7w\2\2\u0293\u0294\7v\2\2\u0294\u0295\7g\2\2\u0295Z\3\2\2"+
		"\2\u0296\u0297\7]\2\2\u0297\\\3\2\2\2\u0298\u0299\7_\2\2\u0299^\3\2\2"+
		"\2\u029a\u029b\7*\2\2\u029b`\3\2\2\2\u029c\u029d\7+\2\2\u029db\3\2\2\2"+
		"\u029e\u029f\7}\2\2\u029fd\3\2\2\2\u02a0\u02a1\7\177\2\2\u02a1f\3\2\2"+
		"\2\u02a2\u02a3\7$\2\2\u02a3h\3\2\2\2\u02a4\u02a5\7.\2\2\u02a5j\3\2\2\2"+
		"\u02a6\u02a7\7?\2\2\u02a7l\3\2\2\2\u02a8\u02ac\t\2\2\2\u02a9\u02ab\t\3"+
		"\2\2\u02aa\u02a9\3\2\2\2\u02ab\u02ae\3\2\2\2\u02ac\u02aa\3\2\2\2\u02ac"+
		"\u02ad\3\2\2\2\u02adn\3\2\2\2\u02ae\u02ac\3\2\2\2\u02af\u02b0\t\4\2\2"+
		"\u02b0p\3\2\2\2\u02b1\u02b3\5o8\2\u02b2\u02b1\3\2\2\2\u02b3\u02b4\3\2"+
		"\2\2\u02b4\u02b2\3\2\2\2\u02b4\u02b5\3\2\2\2\u02b5\u02bc\3\2\2\2\u02b6"+
		"\u02b8\7\60\2\2\u02b7\u02b9\5o8\2\u02b8\u02b7\3\2\2\2\u02b9\u02ba\3\2"+
		"\2\2\u02ba\u02b8\3\2\2\2\u02ba\u02bb\3\2\2\2\u02bb\u02bd\3\2\2\2\u02bc"+
		"\u02b6\3\2\2\2\u02bc\u02bd\3\2\2\2\u02bdr\3\2\2\2\u02be\u02c0\5g\64\2"+
		"\u02bf\u02c1\n\5\2\2\u02c0\u02bf\3\2\2\2\u02c1\u02c2\3\2\2\2\u02c2\u02c3"+
		"\3\2\2\2\u02c2\u02c0\3\2\2\2\u02c3\u02c4\3\2\2\2\u02c4\u02c5\5g\64\2\u02c5"+
		"t\3\2\2\2\u02c6\u02c8\t\6\2\2\u02c7\u02c6\3\2\2\2\u02c8\u02c9\3\2\2\2"+
		"\u02c9\u02c7\3\2\2\2\u02c9\u02ca\3\2\2\2\u02ca\u02cb\3\2\2\2\u02cb\u02cc"+
		"\b;\2\2\u02ccv\3\2\2\2\t\2\u02ac\u02b4\u02ba\u02bc\u02c2\u02c9\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}