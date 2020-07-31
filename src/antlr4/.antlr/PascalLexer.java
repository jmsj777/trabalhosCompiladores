// Generated from /home/ze/Desktop/git-repos/trabalhosCompiladores/src/antlr4/Pascal.g4 by ANTLR 4.8

package antlr4;


import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PascalLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, PROGRAM=8, BEGIN=9, 
		END=10, VAR=11, INTEGER=12, PROCEDURE=13, FUNCTION=14, READ=15, WRITE=16, 
		WRITELN=17, FOR=18, TO=19, DO=20, REPEAT=21, UNTIL=22, WHILE=23, IF=24, 
		THEN=25, ELSE=26, NOT=27, TRUE=28, FALSE=29, AND=30, OR=31, EQ=32, GT=33, 
		GE=34, LT=35, LE=36, NE=37, MUL=38, DIV=39, ADD=40, SUB=41, ID=42, INT=43, 
		STRING=44, WS=45, COMMENT=46, LCOMMENT=47;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "PROGRAM", "BEGIN", 
			"END", "VAR", "INTEGER", "PROCEDURE", "FUNCTION", "READ", "WRITE", "WRITELN", 
			"FOR", "TO", "DO", "REPEAT", "UNTIL", "WHILE", "IF", "THEN", "ELSE", 
			"NOT", "TRUE", "FALSE", "AND", "OR", "EQ", "GT", "GE", "LT", "LE", "NE", 
			"MUL", "DIV", "ADD", "SUB", "ID", "INT", "STRING", "WS", "COMMENT", "LCOMMENT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "'.'", "':'", "','", "'('", "')'", "':='", "'program'", 
			"'begin'", "'end'", "'var'", "'integer'", "'procedure'", "'function'", 
			"'read'", "'write'", "'writeln'", "'for'", "'to'", "'do'", "'repeat'", 
			"'until'", "'while'", "'if'", "'then'", "'else'", "'not'", "'true'", 
			"'false'", "'and'", "'or'", "'='", "'>'", "'>='", "'<'", "'<='", "'<>'", 
			"'*'", "'/'", "'+'", "'-'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, "PROGRAM", "BEGIN", "END", 
			"VAR", "INTEGER", "PROCEDURE", "FUNCTION", "READ", "WRITE", "WRITELN", 
			"FOR", "TO", "DO", "REPEAT", "UNTIL", "WHILE", "IF", "THEN", "ELSE", 
			"NOT", "TRUE", "FALSE", "AND", "OR", "EQ", "GT", "GE", "LT", "LE", "NE", 
			"MUL", "DIV", "ADD", "SUB", "ID", "INT", "STRING", "WS", "COMMENT", "LCOMMENT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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


	public PascalLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Pascal.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\61\u0142\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3"+
		"\6\3\6\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23"+
		"\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\31"+
		"\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\34\3\34"+
		"\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3\37"+
		"\3\37\3\37\3\37\3 \3 \3 \3!\3!\3\"\3\"\3#\3#\3#\3$\3$\3%\3%\3%\3&\3&\3"+
		"&\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3+\7+\u010e\n+\f+\16+\u0111\13+\3,\6,\u0114"+
		"\n,\r,\16,\u0115\3-\3-\7-\u011a\n-\f-\16-\u011d\13-\3-\3-\3.\6.\u0122"+
		"\n.\r.\16.\u0123\3.\3.\3/\3/\7/\u012a\n/\f/\16/\u012d\13/\3/\3/\3/\3/"+
		"\3\60\3\60\3\60\3\60\7\60\u0137\n\60\f\60\16\60\u013a\13\60\3\60\5\60"+
		"\u013d\n\60\3\60\3\60\3\60\3\60\5\u011b\u012b\u0138\2\61\3\3\5\4\7\5\t"+
		"\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23"+
		"%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G"+
		"%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61\3\2\6\4\2C\\c|\5\2\62;C\\c|\3\2\62;\5\2"+
		"\13\f\17\17\"\"\2\u0148\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2"+
		"\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25"+
		"\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2"+
		"\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2"+
		"\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3"+
		"\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2"+
		"\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2"+
		"Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3"+
		"\2\2\2\2_\3\2\2\2\3a\3\2\2\2\5c\3\2\2\2\7e\3\2\2\2\tg\3\2\2\2\13i\3\2"+
		"\2\2\rk\3\2\2\2\17m\3\2\2\2\21p\3\2\2\2\23x\3\2\2\2\25~\3\2\2\2\27\u0082"+
		"\3\2\2\2\31\u0086\3\2\2\2\33\u008e\3\2\2\2\35\u0098\3\2\2\2\37\u00a1\3"+
		"\2\2\2!\u00a6\3\2\2\2#\u00ac\3\2\2\2%\u00b4\3\2\2\2\'\u00b8\3\2\2\2)\u00bb"+
		"\3\2\2\2+\u00be\3\2\2\2-\u00c5\3\2\2\2/\u00cb\3\2\2\2\61\u00d1\3\2\2\2"+
		"\63\u00d4\3\2\2\2\65\u00d9\3\2\2\2\67\u00de\3\2\2\29\u00e2\3\2\2\2;\u00e7"+
		"\3\2\2\2=\u00ed\3\2\2\2?\u00f1\3\2\2\2A\u00f4\3\2\2\2C\u00f6\3\2\2\2E"+
		"\u00f8\3\2\2\2G\u00fb\3\2\2\2I\u00fd\3\2\2\2K\u0100\3\2\2\2M\u0103\3\2"+
		"\2\2O\u0105\3\2\2\2Q\u0107\3\2\2\2S\u0109\3\2\2\2U\u010b\3\2\2\2W\u0113"+
		"\3\2\2\2Y\u0117\3\2\2\2[\u0121\3\2\2\2]\u0127\3\2\2\2_\u0132\3\2\2\2a"+
		"b\7=\2\2b\4\3\2\2\2cd\7\60\2\2d\6\3\2\2\2ef\7<\2\2f\b\3\2\2\2gh\7.\2\2"+
		"h\n\3\2\2\2ij\7*\2\2j\f\3\2\2\2kl\7+\2\2l\16\3\2\2\2mn\7<\2\2no\7?\2\2"+
		"o\20\3\2\2\2pq\7r\2\2qr\7t\2\2rs\7q\2\2st\7i\2\2tu\7t\2\2uv\7c\2\2vw\7"+
		"o\2\2w\22\3\2\2\2xy\7d\2\2yz\7g\2\2z{\7i\2\2{|\7k\2\2|}\7p\2\2}\24\3\2"+
		"\2\2~\177\7g\2\2\177\u0080\7p\2\2\u0080\u0081\7f\2\2\u0081\26\3\2\2\2"+
		"\u0082\u0083\7x\2\2\u0083\u0084\7c\2\2\u0084\u0085\7t\2\2\u0085\30\3\2"+
		"\2\2\u0086\u0087\7k\2\2\u0087\u0088\7p\2\2\u0088\u0089\7v\2\2\u0089\u008a"+
		"\7g\2\2\u008a\u008b\7i\2\2\u008b\u008c\7g\2\2\u008c\u008d\7t\2\2\u008d"+
		"\32\3\2\2\2\u008e\u008f\7r\2\2\u008f\u0090\7t\2\2\u0090\u0091\7q\2\2\u0091"+
		"\u0092\7e\2\2\u0092\u0093\7g\2\2\u0093\u0094\7f\2\2\u0094\u0095\7w\2\2"+
		"\u0095\u0096\7t\2\2\u0096\u0097\7g\2\2\u0097\34\3\2\2\2\u0098\u0099\7"+
		"h\2\2\u0099\u009a\7w\2\2\u009a\u009b\7p\2\2\u009b\u009c\7e\2\2\u009c\u009d"+
		"\7v\2\2\u009d\u009e\7k\2\2\u009e\u009f\7q\2\2\u009f\u00a0\7p\2\2\u00a0"+
		"\36\3\2\2\2\u00a1\u00a2\7t\2\2\u00a2\u00a3\7g\2\2\u00a3\u00a4\7c\2\2\u00a4"+
		"\u00a5\7f\2\2\u00a5 \3\2\2\2\u00a6\u00a7\7y\2\2\u00a7\u00a8\7t\2\2\u00a8"+
		"\u00a9\7k\2\2\u00a9\u00aa\7v\2\2\u00aa\u00ab\7g\2\2\u00ab\"\3\2\2\2\u00ac"+
		"\u00ad\7y\2\2\u00ad\u00ae\7t\2\2\u00ae\u00af\7k\2\2\u00af\u00b0\7v\2\2"+
		"\u00b0\u00b1\7g\2\2\u00b1\u00b2\7n\2\2\u00b2\u00b3\7p\2\2\u00b3$\3\2\2"+
		"\2\u00b4\u00b5\7h\2\2\u00b5\u00b6\7q\2\2\u00b6\u00b7\7t\2\2\u00b7&\3\2"+
		"\2\2\u00b8\u00b9\7v\2\2\u00b9\u00ba\7q\2\2\u00ba(\3\2\2\2\u00bb\u00bc"+
		"\7f\2\2\u00bc\u00bd\7q\2\2\u00bd*\3\2\2\2\u00be\u00bf\7t\2\2\u00bf\u00c0"+
		"\7g\2\2\u00c0\u00c1\7r\2\2\u00c1\u00c2\7g\2\2\u00c2\u00c3\7c\2\2\u00c3"+
		"\u00c4\7v\2\2\u00c4,\3\2\2\2\u00c5\u00c6\7w\2\2\u00c6\u00c7\7p\2\2\u00c7"+
		"\u00c8\7v\2\2\u00c8\u00c9\7k\2\2\u00c9\u00ca\7n\2\2\u00ca.\3\2\2\2\u00cb"+
		"\u00cc\7y\2\2\u00cc\u00cd\7j\2\2\u00cd\u00ce\7k\2\2\u00ce\u00cf\7n\2\2"+
		"\u00cf\u00d0\7g\2\2\u00d0\60\3\2\2\2\u00d1\u00d2\7k\2\2\u00d2\u00d3\7"+
		"h\2\2\u00d3\62\3\2\2\2\u00d4\u00d5\7v\2\2\u00d5\u00d6\7j\2\2\u00d6\u00d7"+
		"\7g\2\2\u00d7\u00d8\7p\2\2\u00d8\64\3\2\2\2\u00d9\u00da\7g\2\2\u00da\u00db"+
		"\7n\2\2\u00db\u00dc\7u\2\2\u00dc\u00dd\7g\2\2\u00dd\66\3\2\2\2\u00de\u00df"+
		"\7p\2\2\u00df\u00e0\7q\2\2\u00e0\u00e1\7v\2\2\u00e18\3\2\2\2\u00e2\u00e3"+
		"\7v\2\2\u00e3\u00e4\7t\2\2\u00e4\u00e5\7w\2\2\u00e5\u00e6\7g\2\2\u00e6"+
		":\3\2\2\2\u00e7\u00e8\7h\2\2\u00e8\u00e9\7c\2\2\u00e9\u00ea\7n\2\2\u00ea"+
		"\u00eb\7u\2\2\u00eb\u00ec\7g\2\2\u00ec<\3\2\2\2\u00ed\u00ee\7c\2\2\u00ee"+
		"\u00ef\7p\2\2\u00ef\u00f0\7f\2\2\u00f0>\3\2\2\2\u00f1\u00f2\7q\2\2\u00f2"+
		"\u00f3\7t\2\2\u00f3@\3\2\2\2\u00f4\u00f5\7?\2\2\u00f5B\3\2\2\2\u00f6\u00f7"+
		"\7@\2\2\u00f7D\3\2\2\2\u00f8\u00f9\7@\2\2\u00f9\u00fa\7?\2\2\u00faF\3"+
		"\2\2\2\u00fb\u00fc\7>\2\2\u00fcH\3\2\2\2\u00fd\u00fe\7>\2\2\u00fe\u00ff"+
		"\7?\2\2\u00ffJ\3\2\2\2\u0100\u0101\7>\2\2\u0101\u0102\7@\2\2\u0102L\3"+
		"\2\2\2\u0103\u0104\7,\2\2\u0104N\3\2\2\2\u0105\u0106\7\61\2\2\u0106P\3"+
		"\2\2\2\u0107\u0108\7-\2\2\u0108R\3\2\2\2\u0109\u010a\7/\2\2\u010aT\3\2"+
		"\2\2\u010b\u010f\t\2\2\2\u010c\u010e\t\3\2\2\u010d\u010c\3\2\2\2\u010e"+
		"\u0111\3\2\2\2\u010f\u010d\3\2\2\2\u010f\u0110\3\2\2\2\u0110V\3\2\2\2"+
		"\u0111\u010f\3\2\2\2\u0112\u0114\t\4\2\2\u0113\u0112\3\2\2\2\u0114\u0115"+
		"\3\2\2\2\u0115\u0113\3\2\2\2\u0115\u0116\3\2\2\2\u0116X\3\2\2\2\u0117"+
		"\u011b\7)\2\2\u0118\u011a\13\2\2\2\u0119\u0118\3\2\2\2\u011a\u011d\3\2"+
		"\2\2\u011b\u011c\3\2\2\2\u011b\u0119\3\2\2\2\u011c\u011e\3\2\2\2\u011d"+
		"\u011b\3\2\2\2\u011e\u011f\7)\2\2\u011fZ\3\2\2\2\u0120\u0122\t\5\2\2\u0121"+
		"\u0120\3\2\2\2\u0122\u0123\3\2\2\2\u0123\u0121\3\2\2\2\u0123\u0124\3\2"+
		"\2\2\u0124\u0125\3\2\2\2\u0125\u0126\b.\2\2\u0126\\\3\2\2\2\u0127\u012b"+
		"\7}\2\2\u0128\u012a\13\2\2\2\u0129\u0128\3\2\2\2\u012a\u012d\3\2\2\2\u012b"+
		"\u012c\3\2\2\2\u012b\u0129\3\2\2\2\u012c\u012e\3\2\2\2\u012d\u012b\3\2"+
		"\2\2\u012e\u012f\7\177\2\2\u012f\u0130\3\2\2\2\u0130\u0131\b/\2\2\u0131"+
		"^\3\2\2\2\u0132\u0133\7\61\2\2\u0133\u0134\7\61\2\2\u0134\u0138\3\2\2"+
		"\2\u0135\u0137\13\2\2\2\u0136\u0135\3\2\2\2\u0137\u013a\3\2\2\2\u0138"+
		"\u0139\3\2\2\2\u0138\u0136\3\2\2\2\u0139\u013c\3\2\2\2\u013a\u0138\3\2"+
		"\2\2\u013b\u013d\7\17\2\2\u013c\u013b\3\2\2\2\u013c\u013d\3\2\2\2\u013d"+
		"\u013e\3\2\2\2\u013e\u013f\7\f\2\2\u013f\u0140\3\2\2\2\u0140\u0141\b\60"+
		"\2\2\u0141`\3\2\2\2\13\2\u010d\u010f\u0115\u011b\u0123\u012b\u0138\u013c"+
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