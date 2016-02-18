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
		EVALUATE=1, QUERYARGS=2, MODEL=3, FIELDS=4, REGION=5, RM=6, LS=7, PRINT=8, 
		PREDICT=9, K=10, LAMBDA=11, GP=12, SVM=13, KERNEL=14, CP=15, CN=16, QUERY=17, 
		EXECUTE=18, LBRACKET=19, RBRACKET=20, LPAREN=21, RPAREN=22, LBRACE=23, 
		RBRACE=24, DBLQUOTES=25, COMMA=26, EQUALS=27, IDENTIFIER=28, INTEGER=29, 
		DECIMAL=30, NUMBER=31, QUOTEDSTRING=32, WS=33;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"EVALUATE", "QUERYARGS", "MODEL", "FIELDS", "REGION", "RM", "LS", "PRINT", 
		"PREDICT", "K", "LAMBDA", "GP", "SVM", "KERNEL", "CP", "CN", "QUERY", 
		"EXECUTE", "LBRACKET", "RBRACKET", "LPAREN", "RPAREN", "LBRACE", "RBRACE", 
		"DBLQUOTES", "COMMA", "EQUALS", "IDENTIFIER", "INTEGER", "DECIMAL", "NUMBER", 
		"QUOTEDSTRING", "WS"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2#\u00e9\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3"+
		"\17\3\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3"+
		"\23\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3"+
		"\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\7\35\u00c0"+
		"\n\35\f\35\16\35\u00c3\13\35\3\36\3\36\7\36\u00c7\n\36\f\36\16\36\u00ca"+
		"\13\36\3\37\6\37\u00cd\n\37\r\37\16\37\u00ce\3\37\3\37\6\37\u00d3\n\37"+
		"\r\37\16\37\u00d4\3 \3 \5 \u00d9\n \3!\3!\6!\u00dd\n!\r!\16!\u00de\3!"+
		"\3!\3\"\6\"\u00e4\n\"\r\"\16\"\u00e5\3\"\3\"\3\u00de\2#\3\3\5\4\7\5\t"+
		"\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23"+
		"%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#\3\2"+
		"\b\4\2C\\c|\7\2\60\60\62;C\\aac|\3\2\63;\3\2\62;\3\2$$\5\2\13\f\16\17"+
		"\"\"\u00ef\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2"+
		"\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27"+
		"\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2"+
		"\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2"+
		"\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2"+
		"\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\3E\3\2\2\2"+
		"\5N\3\2\2\2\7X\3\2\2\2\t^\3\2\2\2\13e\3\2\2\2\rl\3\2\2\2\17o\3\2\2\2\21"+
		"r\3\2\2\2\23x\3\2\2\2\25\u0080\3\2\2\2\27\u0082\3\2\2\2\31\u0089\3\2\2"+
		"\2\33\u008c\3\2\2\2\35\u0090\3\2\2\2\37\u0097\3\2\2\2!\u009a\3\2\2\2#"+
		"\u009d\3\2\2\2%\u00a3\3\2\2\2\'\u00ab\3\2\2\2)\u00ad\3\2\2\2+\u00af\3"+
		"\2\2\2-\u00b1\3\2\2\2/\u00b3\3\2\2\2\61\u00b5\3\2\2\2\63\u00b7\3\2\2\2"+
		"\65\u00b9\3\2\2\2\67\u00bb\3\2\2\29\u00bd\3\2\2\2;\u00c4\3\2\2\2=\u00cc"+
		"\3\2\2\2?\u00d8\3\2\2\2A\u00da\3\2\2\2C\u00e3\3\2\2\2EF\7g\2\2FG\7x\2"+
		"\2GH\7c\2\2HI\7n\2\2IJ\7w\2\2JK\7c\2\2KL\7v\2\2LM\7g\2\2M\4\3\2\2\2NO"+
		"\7s\2\2OP\7w\2\2PQ\7g\2\2QR\7t\2\2RS\7{\2\2ST\7C\2\2TU\7t\2\2UV\7i\2\2"+
		"VW\7u\2\2W\6\3\2\2\2XY\7o\2\2YZ\7q\2\2Z[\7f\2\2[\\\7g\2\2\\]\7n\2\2]\b"+
		"\3\2\2\2^_\7h\2\2_`\7k\2\2`a\7g\2\2ab\7n\2\2bc\7f\2\2cd\7u\2\2d\n\3\2"+
		"\2\2ef\7t\2\2fg\7g\2\2gh\7i\2\2hi\7k\2\2ij\7q\2\2jk\7p\2\2k\f\3\2\2\2"+
		"lm\7t\2\2mn\7o\2\2n\16\3\2\2\2op\7n\2\2pq\7u\2\2q\20\3\2\2\2rs\7r\2\2"+
		"st\7t\2\2tu\7k\2\2uv\7p\2\2vw\7v\2\2w\22\3\2\2\2xy\7r\2\2yz\7t\2\2z{\7"+
		"g\2\2{|\7f\2\2|}\7k\2\2}~\7e\2\2~\177\7v\2\2\177\24\3\2\2\2\u0080\u0081"+
		"\7m\2\2\u0081\26\3\2\2\2\u0082\u0083\7n\2\2\u0083\u0084\7c\2\2\u0084\u0085"+
		"\7o\2\2\u0085\u0086\7d\2\2\u0086\u0087\7f\2\2\u0087\u0088\7c\2\2\u0088"+
		"\30\3\2\2\2\u0089\u008a\7i\2\2\u008a\u008b\7r\2\2\u008b\32\3\2\2\2\u008c"+
		"\u008d\7u\2\2\u008d\u008e\7x\2\2\u008e\u008f\7o\2\2\u008f\34\3\2\2\2\u0090"+
		"\u0091\7m\2\2\u0091\u0092\7g\2\2\u0092\u0093\7t\2\2\u0093\u0094\7p\2\2"+
		"\u0094\u0095\7g\2\2\u0095\u0096\7n\2\2\u0096\36\3\2\2\2\u0097\u0098\7"+
		"e\2\2\u0098\u0099\7r\2\2\u0099 \3\2\2\2\u009a\u009b\7e\2\2\u009b\u009c"+
		"\7p\2\2\u009c\"\3\2\2\2\u009d\u009e\7s\2\2\u009e\u009f\7w\2\2\u009f\u00a0"+
		"\7g\2\2\u00a0\u00a1\7t\2\2\u00a1\u00a2\7{\2\2\u00a2$\3\2\2\2\u00a3\u00a4"+
		"\7g\2\2\u00a4\u00a5\7z\2\2\u00a5\u00a6\7g\2\2\u00a6\u00a7\7e\2\2\u00a7"+
		"\u00a8\7w\2\2\u00a8\u00a9\7v\2\2\u00a9\u00aa\7g\2\2\u00aa&\3\2\2\2\u00ab"+
		"\u00ac\7]\2\2\u00ac(\3\2\2\2\u00ad\u00ae\7_\2\2\u00ae*\3\2\2\2\u00af\u00b0"+
		"\7*\2\2\u00b0,\3\2\2\2\u00b1\u00b2\7+\2\2\u00b2.\3\2\2\2\u00b3\u00b4\7"+
		"}\2\2\u00b4\60\3\2\2\2\u00b5\u00b6\7\177\2\2\u00b6\62\3\2\2\2\u00b7\u00b8"+
		"\7$\2\2\u00b8\64\3\2\2\2\u00b9\u00ba\7.\2\2\u00ba\66\3\2\2\2\u00bb\u00bc"+
		"\7?\2\2\u00bc8\3\2\2\2\u00bd\u00c1\t\2\2\2\u00be\u00c0\t\3\2\2\u00bf\u00be"+
		"\3\2\2\2\u00c0\u00c3\3\2\2\2\u00c1\u00bf\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2"+
		":\3\2\2\2\u00c3\u00c1\3\2\2\2\u00c4\u00c8\t\4\2\2\u00c5\u00c7\t\5\2\2"+
		"\u00c6\u00c5\3\2\2\2\u00c7\u00ca\3\2\2\2\u00c8\u00c6\3\2\2\2\u00c8\u00c9"+
		"\3\2\2\2\u00c9<\3\2\2\2\u00ca\u00c8\3\2\2\2\u00cb\u00cd\t\5\2\2\u00cc"+
		"\u00cb\3\2\2\2\u00cd\u00ce\3\2\2\2\u00ce\u00cc\3\2\2\2\u00ce\u00cf\3\2"+
		"\2\2\u00cf\u00d0\3\2\2\2\u00d0\u00d2\7\60\2\2\u00d1\u00d3\t\5\2\2\u00d2"+
		"\u00d1\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4\u00d2\3\2\2\2\u00d4\u00d5\3\2"+
		"\2\2\u00d5>\3\2\2\2\u00d6\u00d9\5=\37\2\u00d7\u00d9\5;\36\2\u00d8\u00d6"+
		"\3\2\2\2\u00d8\u00d7\3\2\2\2\u00d9@\3\2\2\2\u00da\u00dc\5\63\32\2\u00db"+
		"\u00dd\n\6\2\2\u00dc\u00db\3\2\2\2\u00dd\u00de\3\2\2\2\u00de\u00df\3\2"+
		"\2\2\u00de\u00dc\3\2\2\2\u00df\u00e0\3\2\2\2\u00e0\u00e1\5\63\32\2\u00e1"+
		"B\3\2\2\2\u00e2\u00e4\t\7\2\2\u00e3\u00e2\3\2\2\2\u00e4\u00e5\3\2\2\2"+
		"\u00e5\u00e3\3\2\2\2\u00e5\u00e6\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e7\u00e8"+
		"\b\"\2\2\u00e8D\3\2\2\2\n\2\u00c1\u00c8\u00ce\u00d4\u00d8\u00de\u00e5"+
		"\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}