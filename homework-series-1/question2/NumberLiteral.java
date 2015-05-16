// Generated from /Users/twancoenraad/Code/compiler-construction-homework-series/homework-series-1/question2/NumberLiteral.g4 by ANTLR 4.5
package question2;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class NumberLiteral extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		INT_BINARY=1, LONG_BINARY=2, INT_OCTAL=3, LONG_OCTAL=4, INT_DECIMAL=5, 
		LONG_DECIMAL=6, INT_HEXADECIMAL=7, LONG_HEXADECIMAL=8;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"INT_BINARY", "LONG_BINARY", "INT_OCTAL", "LONG_OCTAL", "INT_DECIMAL", 
		"LONG_DECIMAL", "INT_HEXADECIMAL", "LONG_HEXADECIMAL", "LONG_SUFFIX"
	};

	private static final String[] _LITERAL_NAMES = {
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "INT_BINARY", "LONG_BINARY", "INT_OCTAL", "LONG_OCTAL", "INT_DECIMAL", 
		"LONG_DECIMAL", "INT_HEXADECIMAL", "LONG_HEXADECIMAL"
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
	@NotNull
	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public NumberLiteral(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "NumberLiteral.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\nC\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2\3\2"+
		"\3\2\3\2\6\2\32\n\2\r\2\16\2\33\3\3\3\3\3\3\3\4\3\4\6\4#\n\4\r\4\16\4"+
		"$\3\5\3\5\3\5\3\6\3\6\3\6\7\6-\n\6\f\6\16\6\60\13\6\5\6\62\n\6\3\7\3\7"+
		"\3\7\3\b\3\b\3\b\3\b\6\b;\n\b\r\b\16\b<\3\t\3\t\3\t\3\n\3\n\2\2\13\3\3"+
		"\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\2\3\2\b\3\2\62\63\3\2\629\3\2\63;\3"+
		"\2\62;\5\2\62;CHch\4\2NNnnF\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3"+
		"\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\3\25\3\2\2\2"+
		"\5\35\3\2\2\2\7 \3\2\2\2\t&\3\2\2\2\13\61\3\2\2\2\r\63\3\2\2\2\17\66\3"+
		"\2\2\2\21>\3\2\2\2\23A\3\2\2\2\25\26\7\62\2\2\26\27\7d\2\2\27\31\3\2\2"+
		"\2\30\32\t\2\2\2\31\30\3\2\2\2\32\33\3\2\2\2\33\31\3\2\2\2\33\34\3\2\2"+
		"\2\34\4\3\2\2\2\35\36\5\3\2\2\36\37\5\23\n\2\37\6\3\2\2\2 \"\7\62\2\2"+
		"!#\t\3\2\2\"!\3\2\2\2#$\3\2\2\2$\"\3\2\2\2$%\3\2\2\2%\b\3\2\2\2&\'\5\7"+
		"\4\2\'(\5\23\n\2(\n\3\2\2\2)\62\7\62\2\2*.\t\4\2\2+-\t\5\2\2,+\3\2\2\2"+
		"-\60\3\2\2\2.,\3\2\2\2./\3\2\2\2/\62\3\2\2\2\60.\3\2\2\2\61)\3\2\2\2\61"+
		"*\3\2\2\2\62\f\3\2\2\2\63\64\5\13\6\2\64\65\5\23\n\2\65\16\3\2\2\2\66"+
		"\67\7\62\2\2\678\7z\2\28:\3\2\2\29;\t\6\2\2:9\3\2\2\2;<\3\2\2\2<:\3\2"+
		"\2\2<=\3\2\2\2=\20\3\2\2\2>?\5\17\b\2?@\5\23\n\2@\22\3\2\2\2AB\t\7\2\2"+
		"B\24\3\2\2\2\b\2\33$.\61<\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}