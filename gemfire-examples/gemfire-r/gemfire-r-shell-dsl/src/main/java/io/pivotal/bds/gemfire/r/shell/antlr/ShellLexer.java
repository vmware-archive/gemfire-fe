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
		FFT=1, FORWARD=2, INVERSE=3, STANDARD=4, UNITARY=5, GAUSS=6, MATRIX=7, 
		VECTOR=8, EVALUATE=9, QUERYARGS=10, MODEL=11, FIELDS=12, REGION=13, RM=14, 
		LS=15, PRINT=16, PREDICT=17, K=18, LAMBDA=19, GP=20, SVM=21, KERNEL=22, 
		CP=23, CN=24, QUERY=25, EXECUTE=26, LBRACKET=27, RBRACKET=28, LPAREN=29, 
		RPAREN=30, LBRACE=31, RBRACE=32, DBLQUOTES=33, COMMA=34, EQUALS=35, IDENTIFIER=36, 
		DIGIT=37, NUMBER=38, QUOTEDSTRING=39, WS=40;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"FFT", "FORWARD", "INVERSE", "STANDARD", "UNITARY", "GAUSS", "MATRIX", 
		"VECTOR", "EVALUATE", "QUERYARGS", "MODEL", "FIELDS", "REGION", "RM", 
		"LS", "PRINT", "PREDICT", "K", "LAMBDA", "GP", "SVM", "KERNEL", "CP", 
		"CN", "QUERY", "EXECUTE", "LBRACKET", "RBRACKET", "LPAREN", "RPAREN", 
		"LBRACE", "RBRACE", "DBLQUOTES", "COMMA", "EQUALS", "IDENTIFIER", "DIGIT", 
		"NUMBER", "QUOTEDSTRING", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'fft'", "'forward'", "'inverse'", "'standard'", "'unitary'", "'gauss'", 
		"'matrix'", "'vect'", "'evaluate'", "'queryArgs'", "'model'", "'fields'", 
		"'region'", "'rm'", "'ls'", "'print'", "'predict'", "'k'", "'lambda'", 
		"'gp'", "'svm'", "'kernel'", "'cp'", "'cn'", "'query'", "'execute'", "'['", 
		"']'", "'('", "')'", "'{'", "'}'", "'\"'", "','", "'='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "FFT", "FORWARD", "INVERSE", "STANDARD", "UNITARY", "GAUSS", "MATRIX", 
		"VECTOR", "EVALUATE", "QUERYARGS", "MODEL", "FIELDS", "REGION", "RM", 
		"LS", "PRINT", "PREDICT", "K", "LAMBDA", "GP", "SVM", "KERNEL", "CP", 
		"CN", "QUERY", "EXECUTE", "LBRACKET", "RBRACKET", "LPAREN", "RPAREN", 
		"LBRACE", "RBRACE", "DBLQUOTES", "COMMA", "EQUALS", "IDENTIFIER", "DIGIT", 
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2*\u0127\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\3\2\3\2\3\2\3"+
		"\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\20\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\26\3\26"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\31\3\32"+
		"\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\34"+
		"\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3"+
		"%\3%\7%\u0105\n%\f%\16%\u0108\13%\3&\3&\3\'\6\'\u010d\n\'\r\'\16\'\u010e"+
		"\3\'\3\'\6\'\u0113\n\'\r\'\16\'\u0114\5\'\u0117\n\'\3(\3(\6(\u011b\n("+
		"\r(\16(\u011c\3(\3(\3)\6)\u0122\n)\r)\16)\u0123\3)\3)\3\u011c\2*\3\3\5"+
		"\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21"+
		"!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!"+
		"A\"C#E$G%I&K\'M(O)Q*\3\2\7\4\2C\\c|\7\2\60\60\62;C\\aac|\3\2\62;\3\2$"+
		"$\5\2\13\f\16\17\"\"\u012c\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2"+
		"\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2"+
		"\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3"+
		"\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2"+
		"\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67"+
		"\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2"+
		"\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2"+
		"\2Q\3\2\2\2\3S\3\2\2\2\5W\3\2\2\2\7_\3\2\2\2\tg\3\2\2\2\13p\3\2\2\2\r"+
		"x\3\2\2\2\17~\3\2\2\2\21\u0085\3\2\2\2\23\u008a\3\2\2\2\25\u0093\3\2\2"+
		"\2\27\u009d\3\2\2\2\31\u00a3\3\2\2\2\33\u00aa\3\2\2\2\35\u00b1\3\2\2\2"+
		"\37\u00b4\3\2\2\2!\u00b7\3\2\2\2#\u00bd\3\2\2\2%\u00c5\3\2\2\2\'\u00c7"+
		"\3\2\2\2)\u00ce\3\2\2\2+\u00d1\3\2\2\2-\u00d5\3\2\2\2/\u00dc\3\2\2\2\61"+
		"\u00df\3\2\2\2\63\u00e2\3\2\2\2\65\u00e8\3\2\2\2\67\u00f0\3\2\2\29\u00f2"+
		"\3\2\2\2;\u00f4\3\2\2\2=\u00f6\3\2\2\2?\u00f8\3\2\2\2A\u00fa\3\2\2\2C"+
		"\u00fc\3\2\2\2E\u00fe\3\2\2\2G\u0100\3\2\2\2I\u0102\3\2\2\2K\u0109\3\2"+
		"\2\2M\u010c\3\2\2\2O\u0118\3\2\2\2Q\u0121\3\2\2\2ST\7h\2\2TU\7h\2\2UV"+
		"\7v\2\2V\4\3\2\2\2WX\7h\2\2XY\7q\2\2YZ\7t\2\2Z[\7y\2\2[\\\7c\2\2\\]\7"+
		"t\2\2]^\7f\2\2^\6\3\2\2\2_`\7k\2\2`a\7p\2\2ab\7x\2\2bc\7g\2\2cd\7t\2\2"+
		"de\7u\2\2ef\7g\2\2f\b\3\2\2\2gh\7u\2\2hi\7v\2\2ij\7c\2\2jk\7p\2\2kl\7"+
		"f\2\2lm\7c\2\2mn\7t\2\2no\7f\2\2o\n\3\2\2\2pq\7w\2\2qr\7p\2\2rs\7k\2\2"+
		"st\7v\2\2tu\7c\2\2uv\7t\2\2vw\7{\2\2w\f\3\2\2\2xy\7i\2\2yz\7c\2\2z{\7"+
		"w\2\2{|\7u\2\2|}\7u\2\2}\16\3\2\2\2~\177\7o\2\2\177\u0080\7c\2\2\u0080"+
		"\u0081\7v\2\2\u0081\u0082\7t\2\2\u0082\u0083\7k\2\2\u0083\u0084\7z\2\2"+
		"\u0084\20\3\2\2\2\u0085\u0086\7x\2\2\u0086\u0087\7g\2\2\u0087\u0088\7"+
		"e\2\2\u0088\u0089\7v\2\2\u0089\22\3\2\2\2\u008a\u008b\7g\2\2\u008b\u008c"+
		"\7x\2\2\u008c\u008d\7c\2\2\u008d\u008e\7n\2\2\u008e\u008f\7w\2\2\u008f"+
		"\u0090\7c\2\2\u0090\u0091\7v\2\2\u0091\u0092\7g\2\2\u0092\24\3\2\2\2\u0093"+
		"\u0094\7s\2\2\u0094\u0095\7w\2\2\u0095\u0096\7g\2\2\u0096\u0097\7t\2\2"+
		"\u0097\u0098\7{\2\2\u0098\u0099\7C\2\2\u0099\u009a\7t\2\2\u009a\u009b"+
		"\7i\2\2\u009b\u009c\7u\2\2\u009c\26\3\2\2\2\u009d\u009e\7o\2\2\u009e\u009f"+
		"\7q\2\2\u009f\u00a0\7f\2\2\u00a0\u00a1\7g\2\2\u00a1\u00a2\7n\2\2\u00a2"+
		"\30\3\2\2\2\u00a3\u00a4\7h\2\2\u00a4\u00a5\7k\2\2\u00a5\u00a6\7g\2\2\u00a6"+
		"\u00a7\7n\2\2\u00a7\u00a8\7f\2\2\u00a8\u00a9\7u\2\2\u00a9\32\3\2\2\2\u00aa"+
		"\u00ab\7t\2\2\u00ab\u00ac\7g\2\2\u00ac\u00ad\7i\2\2\u00ad\u00ae\7k\2\2"+
		"\u00ae\u00af\7q\2\2\u00af\u00b0\7p\2\2\u00b0\34\3\2\2\2\u00b1\u00b2\7"+
		"t\2\2\u00b2\u00b3\7o\2\2\u00b3\36\3\2\2\2\u00b4\u00b5\7n\2\2\u00b5\u00b6"+
		"\7u\2\2\u00b6 \3\2\2\2\u00b7\u00b8\7r\2\2\u00b8\u00b9\7t\2\2\u00b9\u00ba"+
		"\7k\2\2\u00ba\u00bb\7p\2\2\u00bb\u00bc\7v\2\2\u00bc\"\3\2\2\2\u00bd\u00be"+
		"\7r\2\2\u00be\u00bf\7t\2\2\u00bf\u00c0\7g\2\2\u00c0\u00c1\7f\2\2\u00c1"+
		"\u00c2\7k\2\2\u00c2\u00c3\7e\2\2\u00c3\u00c4\7v\2\2\u00c4$\3\2\2\2\u00c5"+
		"\u00c6\7m\2\2\u00c6&\3\2\2\2\u00c7\u00c8\7n\2\2\u00c8\u00c9\7c\2\2\u00c9"+
		"\u00ca\7o\2\2\u00ca\u00cb\7d\2\2\u00cb\u00cc\7f\2\2\u00cc\u00cd\7c\2\2"+
		"\u00cd(\3\2\2\2\u00ce\u00cf\7i\2\2\u00cf\u00d0\7r\2\2\u00d0*\3\2\2\2\u00d1"+
		"\u00d2\7u\2\2\u00d2\u00d3\7x\2\2\u00d3\u00d4\7o\2\2\u00d4,\3\2\2\2\u00d5"+
		"\u00d6\7m\2\2\u00d6\u00d7\7g\2\2\u00d7\u00d8\7t\2\2\u00d8\u00d9\7p\2\2"+
		"\u00d9\u00da\7g\2\2\u00da\u00db\7n\2\2\u00db.\3\2\2\2\u00dc\u00dd\7e\2"+
		"\2\u00dd\u00de\7r\2\2\u00de\60\3\2\2\2\u00df\u00e0\7e\2\2\u00e0\u00e1"+
		"\7p\2\2\u00e1\62\3\2\2\2\u00e2\u00e3\7s\2\2\u00e3\u00e4\7w\2\2\u00e4\u00e5"+
		"\7g\2\2\u00e5\u00e6\7t\2\2\u00e6\u00e7\7{\2\2\u00e7\64\3\2\2\2\u00e8\u00e9"+
		"\7g\2\2\u00e9\u00ea\7z\2\2\u00ea\u00eb\7g\2\2\u00eb\u00ec\7e\2\2\u00ec"+
		"\u00ed\7w\2\2\u00ed\u00ee\7v\2\2\u00ee\u00ef\7g\2\2\u00ef\66\3\2\2\2\u00f0"+
		"\u00f1\7]\2\2\u00f18\3\2\2\2\u00f2\u00f3\7_\2\2\u00f3:\3\2\2\2\u00f4\u00f5"+
		"\7*\2\2\u00f5<\3\2\2\2\u00f6\u00f7\7+\2\2\u00f7>\3\2\2\2\u00f8\u00f9\7"+
		"}\2\2\u00f9@\3\2\2\2\u00fa\u00fb\7\177\2\2\u00fbB\3\2\2\2\u00fc\u00fd"+
		"\7$\2\2\u00fdD\3\2\2\2\u00fe\u00ff\7.\2\2\u00ffF\3\2\2\2\u0100\u0101\7"+
		"?\2\2\u0101H\3\2\2\2\u0102\u0106\t\2\2\2\u0103\u0105\t\3\2\2\u0104\u0103"+
		"\3\2\2\2\u0105\u0108\3\2\2\2\u0106\u0104\3\2\2\2\u0106\u0107\3\2\2\2\u0107"+
		"J\3\2\2\2\u0108\u0106\3\2\2\2\u0109\u010a\t\4\2\2\u010aL\3\2\2\2\u010b"+
		"\u010d\5K&\2\u010c\u010b\3\2\2\2\u010d\u010e\3\2\2\2\u010e\u010c\3\2\2"+
		"\2\u010e\u010f\3\2\2\2\u010f\u0116\3\2\2\2\u0110\u0112\7\60\2\2\u0111"+
		"\u0113\5K&\2\u0112\u0111\3\2\2\2\u0113\u0114\3\2\2\2\u0114\u0112\3\2\2"+
		"\2\u0114\u0115\3\2\2\2\u0115\u0117\3\2\2\2\u0116\u0110\3\2\2\2\u0116\u0117"+
		"\3\2\2\2\u0117N\3\2\2\2\u0118\u011a\5C\"\2\u0119\u011b\n\5\2\2\u011a\u0119"+
		"\3\2\2\2\u011b\u011c\3\2\2\2\u011c\u011d\3\2\2\2\u011c\u011a\3\2\2\2\u011d"+
		"\u011e\3\2\2\2\u011e\u011f\5C\"\2\u011fP\3\2\2\2\u0120\u0122\t\6\2\2\u0121"+
		"\u0120\3\2\2\2\u0122\u0123\3\2\2\2\u0123\u0121\3\2\2\2\u0123\u0124\3\2"+
		"\2\2\u0124\u0125\3\2\2\2\u0125\u0126\b)\2\2\u0126R\3\2\2\2\t\2\u0106\u010e"+
		"\u0114\u0116\u011c\u0123\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}