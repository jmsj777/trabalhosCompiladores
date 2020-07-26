// Generated from Pascal.g4 by ANTLR 4.8
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PascalParser extends Parser {
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
	public static final int
		RULE_programa = 0, RULE_corpo = 1, RULE_bloco = 2, RULE_declara = 3, RULE_dvar = 4, 
		RULE_tipo = 5, RULE_variaveis = 6, RULE_rotina = 7, RULE_procedimento = 8, 
		RULE_funcao = 9, RULE_parametros = 10, RULE_lista_parametros = 11, RULE_lista_id = 12, 
		RULE_var_read = 13, RULE_exp_write = 14, RULE_sentenca = 15, RULE_comando = 16, 
		RULE_argumentos = 17, RULE_pfalsa = 18, RULE_expressao_logica = 19, RULE_termo_logico = 20, 
		RULE_fator_logico = 21, RULE_relacional = 22, RULE_expressao = 23, RULE_termo = 24, 
		RULE_fator = 25;
	private static String[] makeRuleNames() {
		return new String[] {
			"programa", "corpo", "bloco", "declara", "dvar", "tipo", "variaveis", 
			"rotina", "procedimento", "funcao", "parametros", "lista_parametros", 
			"lista_id", "var_read", "exp_write", "sentenca", "comando", "argumentos", 
			"pfalsa", "expressao_logica", "termo_logico", "fator_logico", "relacional", 
			"expressao", "termo", "fator"
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

	@Override
	public String getGrammarFileName() { return "Pascal.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public PascalParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramaContext extends ParserRuleContext {
		public TerminalNode PROGRAM() { return getToken(PascalParser.PROGRAM, 0); }
		public TerminalNode ID() { return getToken(PascalParser.ID, 0); }
		public CorpoContext corpo() {
			return getRuleContext(CorpoContext.class,0);
		}
		public ProgramaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programa; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterPrograma(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitPrograma(this);
		}
	}

	public final ProgramaContext programa() throws RecognitionException {
		ProgramaContext _localctx = new ProgramaContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_programa);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(52);
			match(PROGRAM);
			setState(53);
			match(ID);
			A01
			setState(55);
			match(T__0);
			setState(56);
			corpo();
			setState(57);
			match(T__1);
			A45
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CorpoContext extends ParserRuleContext {
		public BlocoContext bloco() {
			return getRuleContext(BlocoContext.class,0);
		}
		public DeclaraContext declara() {
			return getRuleContext(DeclaraContext.class,0);
		}
		public List<RotinaContext> rotina() {
			return getRuleContexts(RotinaContext.class);
		}
		public RotinaContext rotina(int i) {
			return getRuleContext(RotinaContext.class,i);
		}
		public CorpoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_corpo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterCorpo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitCorpo(this);
		}
	}

	public final CorpoContext corpo() throws RecognitionException {
		CorpoContext _localctx = new CorpoContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_corpo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(61);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==VAR) {
				{
				setState(60);
				declara();
				}
			}

			setState(66);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PROCEDURE || _la==FUNCTION) {
				{
				{
				setState(63);
				rotina();
				}
				}
				setState(68);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			A44
			setState(70);
			bloco();
			A46
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlocoContext extends ParserRuleContext {
		public TerminalNode BEGIN() { return getToken(PascalParser.BEGIN, 0); }
		public TerminalNode END() { return getToken(PascalParser.END, 0); }
		public List<SentencaContext> sentenca() {
			return getRuleContexts(SentencaContext.class);
		}
		public SentencaContext sentenca(int i) {
			return getRuleContext(SentencaContext.class,i);
		}
		public BlocoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bloco; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterBloco(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitBloco(this);
		}
	}

	public final BlocoContext bloco() throws RecognitionException {
		BlocoContext _localctx = new BlocoContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_bloco);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			match(BEGIN);
			setState(77);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << READ) | (1L << WRITE) | (1L << WRITELN) | (1L << FOR) | (1L << REPEAT) | (1L << WHILE) | (1L << IF) | (1L << ID))) != 0)) {
				{
				{
				setState(74);
				sentenca();
				}
				}
				setState(79);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(80);
			match(END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclaraContext extends ParserRuleContext {
		public TerminalNode VAR() { return getToken(PascalParser.VAR, 0); }
		public List<DvarContext> dvar() {
			return getRuleContexts(DvarContext.class);
		}
		public DvarContext dvar(int i) {
			return getRuleContext(DvarContext.class,i);
		}
		public DeclaraContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declara; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterDeclara(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitDeclara(this);
		}
	}

	public final DeclaraContext declara() throws RecognitionException {
		DeclaraContext _localctx = new DeclaraContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_declara);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			match(VAR);
			setState(84); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(83);
				dvar();
				}
				}
				setState(86); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ID );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DvarContext extends ParserRuleContext {
		public VariaveisContext variaveis() {
			return getRuleContext(VariaveisContext.class,0);
		}
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public DvarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dvar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterDvar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitDvar(this);
		}
	}

	public final DvarContext dvar() throws RecognitionException {
		DvarContext _localctx = new DvarContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_dvar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			variaveis(0);
			setState(89);
			match(T__2);
			setState(90);
			tipo();
			A02
			setState(92);
			match(T__0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TipoContext extends ParserRuleContext {
		public TerminalNode INTEGER() { return getToken(PascalParser.INTEGER, 0); }
		public TipoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterTipo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitTipo(this);
		}
	}

	public final TipoContext tipo() throws RecognitionException {
		TipoContext _localctx = new TipoContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_tipo);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
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

	public static class VariaveisContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(PascalParser.ID, 0); }
		public VariaveisContext variaveis() {
			return getRuleContext(VariaveisContext.class,0);
		}
		public VariaveisContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variaveis; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterVariaveis(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitVariaveis(this);
		}
	}

	public final VariaveisContext variaveis() throws RecognitionException {
		return variaveis(0);
	}

	private VariaveisContext variaveis(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		VariaveisContext _localctx = new VariaveisContext(_ctx, _parentState);
		VariaveisContext _prevctx = _localctx;
		int _startState = 12;
		enterRecursionRule(_localctx, 12, RULE_variaveis, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(97);
			match(ID);
			A03
			}
			_ctx.stop = _input.LT(-1);
			setState(106);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new VariaveisContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_variaveis);
					setState(100);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(101);
					match(T__3);
					setState(102);
					match(ID);
					A03
					}
					} 
				}
				setState(108);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class RotinaContext extends ParserRuleContext {
		public ProcedimentoContext procedimento() {
			return getRuleContext(ProcedimentoContext.class,0);
		}
		public FuncaoContext funcao() {
			return getRuleContext(FuncaoContext.class,0);
		}
		public RotinaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rotina; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterRotina(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitRotina(this);
		}
	}

	public final RotinaContext rotina() throws RecognitionException {
		RotinaContext _localctx = new RotinaContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_rotina);
		try {
			setState(111);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PROCEDURE:
				enterOuterAlt(_localctx, 1);
				{
				setState(109);
				procedimento();
				}
				break;
			case FUNCTION:
				enterOuterAlt(_localctx, 2);
				{
				setState(110);
				funcao();
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

	public static class ProcedimentoContext extends ParserRuleContext {
		public TerminalNode PROCEDURE() { return getToken(PascalParser.PROCEDURE, 0); }
		public TerminalNode ID() { return getToken(PascalParser.ID, 0); }
		public CorpoContext corpo() {
			return getRuleContext(CorpoContext.class,0);
		}
		public ParametrosContext parametros() {
			return getRuleContext(ParametrosContext.class,0);
		}
		public ProcedimentoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_procedimento; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterProcedimento(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitProcedimento(this);
		}
	}

	public final ProcedimentoContext procedimento() throws RecognitionException {
		ProcedimentoContext _localctx = new ProcedimentoContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_procedimento);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
			match(PROCEDURE);
			setState(114);
			match(ID);
			A04
			setState(117);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(116);
				parametros();
				}
			}

			A48
			setState(120);
			match(T__0);
			setState(121);
			corpo();
			A56
			setState(123);
			match(T__0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FuncaoContext extends ParserRuleContext {
		public TerminalNode FUNCTION() { return getToken(PascalParser.FUNCTION, 0); }
		public TerminalNode ID() { return getToken(PascalParser.ID, 0); }
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public CorpoContext corpo() {
			return getRuleContext(CorpoContext.class,0);
		}
		public ParametrosContext parametros() {
			return getRuleContext(ParametrosContext.class,0);
		}
		public FuncaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterFuncao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitFuncao(this);
		}
	}

	public final FuncaoContext funcao() throws RecognitionException {
		FuncaoContext _localctx = new FuncaoContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_funcao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			match(FUNCTION);
			setState(126);
			match(ID);
			A05
			setState(129);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(128);
				parametros();
				}
			}

			A48
			setState(132);
			match(T__2);
			setState(133);
			tipo();
			A47
			setState(135);
			match(T__0);
			setState(136);
			corpo();
			A56
			setState(138);
			match(T__0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParametrosContext extends ParserRuleContext {
		public List<Lista_parametrosContext> lista_parametros() {
			return getRuleContexts(Lista_parametrosContext.class);
		}
		public Lista_parametrosContext lista_parametros(int i) {
			return getRuleContext(Lista_parametrosContext.class,i);
		}
		public ParametrosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parametros; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterParametros(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitParametros(this);
		}
	}

	public final ParametrosContext parametros() throws RecognitionException {
		ParametrosContext _localctx = new ParametrosContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_parametros);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(140);
			match(T__4);
			setState(142); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(141);
				lista_parametros();
				}
				}
				setState(144); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ID );
			setState(146);
			match(T__5);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Lista_parametrosContext extends ParserRuleContext {
		public Lista_idContext lista_id() {
			return getRuleContext(Lista_idContext.class,0);
		}
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public Lista_parametrosContext lista_parametros() {
			return getRuleContext(Lista_parametrosContext.class,0);
		}
		public Lista_parametrosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lista_parametros; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterLista_parametros(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitLista_parametros(this);
		}
	}

	public final Lista_parametrosContext lista_parametros() throws RecognitionException {
		Lista_parametrosContext _localctx = new Lista_parametrosContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_lista_parametros);
		try {
			setState(160);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(148);
				lista_id(0);
				setState(149);
				match(T__2);
				setState(150);
				tipo();
				A06
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(153);
				lista_id(0);
				setState(154);
				match(T__2);
				setState(155);
				tipo();
				A06
				setState(157);
				match(T__0);
				setState(158);
				lista_parametros();
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

	public static class Lista_idContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(PascalParser.ID, 0); }
		public Lista_idContext lista_id() {
			return getRuleContext(Lista_idContext.class,0);
		}
		public Lista_idContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lista_id; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterLista_id(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitLista_id(this);
		}
	}

	public final Lista_idContext lista_id() throws RecognitionException {
		return lista_id(0);
	}

	private Lista_idContext lista_id(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Lista_idContext _localctx = new Lista_idContext(_ctx, _parentState);
		Lista_idContext _prevctx = _localctx;
		int _startState = 24;
		enterRecursionRule(_localctx, 24, RULE_lista_id, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(163);
			match(ID);
			A07
			}
			_ctx.stop = _input.LT(-1);
			setState(172);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Lista_idContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_lista_id);
					setState(166);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(167);
					match(T__3);
					setState(168);
					match(ID);
					A07
					}
					} 
				}
				setState(174);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Var_readContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(PascalParser.ID, 0); }
		public Var_readContext var_read() {
			return getRuleContext(Var_readContext.class,0);
		}
		public Var_readContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_read; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterVar_read(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitVar_read(this);
		}
	}

	public final Var_readContext var_read() throws RecognitionException {
		return var_read(0);
	}

	private Var_readContext var_read(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Var_readContext _localctx = new Var_readContext(_ctx, _parentState);
		Var_readContext _prevctx = _localctx;
		int _startState = 26;
		enterRecursionRule(_localctx, 26, RULE_var_read, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(176);
			match(ID);
			A08
			}
			_ctx.stop = _input.LT(-1);
			setState(185);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Var_readContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_var_read);
					setState(179);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(180);
					match(T__3);
					setState(181);
					match(ID);
					A08
					}
					} 
				}
				setState(187);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Exp_writeContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(PascalParser.STRING, 0); }
		public TerminalNode ID() { return getToken(PascalParser.ID, 0); }
		public Exp_writeContext exp_write() {
			return getRuleContext(Exp_writeContext.class,0);
		}
		public Exp_writeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp_write; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterExp_write(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitExp_write(this);
		}
	}

	public final Exp_writeContext exp_write() throws RecognitionException {
		return exp_write(0);
	}

	private Exp_writeContext exp_write(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Exp_writeContext _localctx = new Exp_writeContext(_ctx, _parentState);
		Exp_writeContext _prevctx = _localctx;
		int _startState = 28;
		enterRecursionRule(_localctx, 28, RULE_exp_write, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(193);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING:
				{
				setState(189);
				match(STRING);
				A59
				}
				break;
			case ID:
				{
				setState(191);
				match(ID);
				A09
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(205);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(203);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
					case 1:
						{
						_localctx = new Exp_writeContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp_write);
						setState(195);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(196);
						match(T__3);
						setState(197);
						match(STRING);
						A59
						}
						break;
					case 2:
						{
						_localctx = new Exp_writeContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_exp_write);
						setState(199);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(200);
						match(T__3);
						setState(201);
						match(ID);
						A09
						}
						break;
					}
					} 
				}
				setState(207);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class SentencaContext extends ParserRuleContext {
		public ComandoContext comando() {
			return getRuleContext(ComandoContext.class,0);
		}
		public SentencaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentenca; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterSentenca(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitSentenca(this);
		}
	}

	public final SentencaContext sentenca() throws RecognitionException {
		SentencaContext _localctx = new SentencaContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_sentenca);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(208);
			comando();
			setState(209);
			match(T__0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ComandoContext extends ParserRuleContext {
		public TerminalNode READ() { return getToken(PascalParser.READ, 0); }
		public Var_readContext var_read() {
			return getRuleContext(Var_readContext.class,0);
		}
		public TerminalNode WRITE() { return getToken(PascalParser.WRITE, 0); }
		public Exp_writeContext exp_write() {
			return getRuleContext(Exp_writeContext.class,0);
		}
		public TerminalNode WRITELN() { return getToken(PascalParser.WRITELN, 0); }
		public TerminalNode FOR() { return getToken(PascalParser.FOR, 0); }
		public TerminalNode ID() { return getToken(PascalParser.ID, 0); }
		public List<ExpressaoContext> expressao() {
			return getRuleContexts(ExpressaoContext.class);
		}
		public ExpressaoContext expressao(int i) {
			return getRuleContext(ExpressaoContext.class,i);
		}
		public TerminalNode TO() { return getToken(PascalParser.TO, 0); }
		public TerminalNode DO() { return getToken(PascalParser.DO, 0); }
		public BlocoContext bloco() {
			return getRuleContext(BlocoContext.class,0);
		}
		public TerminalNode REPEAT() { return getToken(PascalParser.REPEAT, 0); }
		public SentencaContext sentenca() {
			return getRuleContext(SentencaContext.class,0);
		}
		public TerminalNode UNTIL() { return getToken(PascalParser.UNTIL, 0); }
		public Expressao_logicaContext expressao_logica() {
			return getRuleContext(Expressao_logicaContext.class,0);
		}
		public TerminalNode WHILE() { return getToken(PascalParser.WHILE, 0); }
		public TerminalNode IF() { return getToken(PascalParser.IF, 0); }
		public TerminalNode THEN() { return getToken(PascalParser.THEN, 0); }
		public PfalsaContext pfalsa() {
			return getRuleContext(PfalsaContext.class,0);
		}
		public ArgumentosContext argumentos() {
			return getRuleContext(ArgumentosContext.class,0);
		}
		public ComandoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comando; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterComando(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitComando(this);
		}
	}

	public final ComandoContext comando() throws RecognitionException {
		ComandoContext _localctx = new ComandoContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_comando);
		int _la;
		try {
			setState(278);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(211);
				match(READ);
				setState(212);
				match(T__4);
				setState(213);
				var_read(0);
				setState(214);
				match(T__5);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(216);
				match(WRITE);
				setState(217);
				match(T__4);
				setState(218);
				exp_write(0);
				setState(219);
				match(T__5);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(221);
				match(WRITELN);
				setState(222);
				match(T__4);
				setState(223);
				exp_write(0);
				setState(224);
				match(T__5);
				A61
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(227);
				match(FOR);
				setState(228);
				match(ID);
				A57
				setState(230);
				match(T__6);
				setState(231);
				expressao(0);
				A11
				setState(233);
				match(TO);
				setState(234);
				expressao(0);
				A12
				setState(236);
				match(DO);
				setState(237);
				bloco();
				A13
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(240);
				match(REPEAT);
				A14
				setState(242);
				sentenca();
				setState(243);
				match(UNTIL);
				setState(244);
				expressao_logica(0);
				A15
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(247);
				match(WHILE);
				A16
				setState(249);
				expressao_logica(0);
				A17
				setState(251);
				match(DO);
				setState(252);
				bloco();
				A18
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(255);
				match(IF);
				setState(256);
				expressao_logica(0);
				A19
				setState(258);
				match(THEN);
				setState(259);
				bloco();
				A20
				setState(262);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ELSE) {
					{
					setState(261);
					pfalsa();
					}
				}

				A21
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(266);
				match(ID);
				A49
				setState(268);
				match(T__6);
				setState(269);
				expressao(0);
				A22
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(272);
				match(ID);
				A50
				setState(275);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__4) {
					{
					setState(274);
					argumentos();
					}
				}

				A23
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

	public static class ArgumentosContext extends ParserRuleContext {
		public List<ExpressaoContext> expressao() {
			return getRuleContexts(ExpressaoContext.class);
		}
		public ExpressaoContext expressao(int i) {
			return getRuleContext(ExpressaoContext.class,i);
		}
		public ArgumentosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argumentos; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterArgumentos(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitArgumentos(this);
		}
	}

	public final ArgumentosContext argumentos() throws RecognitionException {
		ArgumentosContext _localctx = new ArgumentosContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_argumentos);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(280);
			match(T__4);
			setState(289);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << ID) | (1L << INT))) != 0)) {
				{
				setState(281);
				expressao(0);
				setState(286);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__3) {
					{
					{
					setState(282);
					match(T__3);
					setState(283);
					expressao(0);
					}
					}
					setState(288);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(291);
			match(T__5);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PfalsaContext extends ParserRuleContext {
		public TerminalNode ELSE() { return getToken(PascalParser.ELSE, 0); }
		public BlocoContext bloco() {
			return getRuleContext(BlocoContext.class,0);
		}
		public PfalsaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pfalsa; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterPfalsa(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitPfalsa(this);
		}
	}

	public final PfalsaContext pfalsa() throws RecognitionException {
		PfalsaContext _localctx = new PfalsaContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_pfalsa);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(293);
			match(ELSE);
			A25
			setState(295);
			bloco();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Expressao_logicaContext extends ParserRuleContext {
		public Termo_logicoContext termo_logico() {
			return getRuleContext(Termo_logicoContext.class,0);
		}
		public Expressao_logicaContext expressao_logica() {
			return getRuleContext(Expressao_logicaContext.class,0);
		}
		public TerminalNode OR() { return getToken(PascalParser.OR, 0); }
		public Expressao_logicaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressao_logica; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterExpressao_logica(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitExpressao_logica(this);
		}
	}

	public final Expressao_logicaContext expressao_logica() throws RecognitionException {
		return expressao_logica(0);
	}

	private Expressao_logicaContext expressao_logica(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Expressao_logicaContext _localctx = new Expressao_logicaContext(_ctx, _parentState);
		Expressao_logicaContext _prevctx = _localctx;
		int _startState = 38;
		enterRecursionRule(_localctx, 38, RULE_expressao_logica, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(298);
			termo_logico(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(307);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Expressao_logicaContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_expressao_logica);
					setState(300);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(301);
					match(OR);
					setState(302);
					termo_logico(0);
					A26
					}
					} 
				}
				setState(309);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Termo_logicoContext extends ParserRuleContext {
		public Fator_logicoContext fator_logico() {
			return getRuleContext(Fator_logicoContext.class,0);
		}
		public Termo_logicoContext termo_logico() {
			return getRuleContext(Termo_logicoContext.class,0);
		}
		public TerminalNode AND() { return getToken(PascalParser.AND, 0); }
		public Termo_logicoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termo_logico; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterTermo_logico(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitTermo_logico(this);
		}
	}

	public final Termo_logicoContext termo_logico() throws RecognitionException {
		return termo_logico(0);
	}

	private Termo_logicoContext termo_logico(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Termo_logicoContext _localctx = new Termo_logicoContext(_ctx, _parentState);
		Termo_logicoContext _prevctx = _localctx;
		int _startState = 40;
		enterRecursionRule(_localctx, 40, RULE_termo_logico, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(311);
			fator_logico();
			}
			_ctx.stop = _input.LT(-1);
			setState(320);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Termo_logicoContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_termo_logico);
					setState(313);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(314);
					match(AND);
					setState(315);
					fator_logico();
					A27
					}
					} 
				}
				setState(322);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Fator_logicoContext extends ParserRuleContext {
		public RelacionalContext relacional() {
			return getRuleContext(RelacionalContext.class,0);
		}
		public Expressao_logicaContext expressao_logica() {
			return getRuleContext(Expressao_logicaContext.class,0);
		}
		public TerminalNode NOT() { return getToken(PascalParser.NOT, 0); }
		public Fator_logicoContext fator_logico() {
			return getRuleContext(Fator_logicoContext.class,0);
		}
		public TerminalNode TRUE() { return getToken(PascalParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(PascalParser.FALSE, 0); }
		public Fator_logicoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fator_logico; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterFator_logico(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitFator_logico(this);
		}
	}

	public final Fator_logicoContext fator_logico() throws RecognitionException {
		Fator_logicoContext _localctx = new Fator_logicoContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_fator_logico);
		try {
			setState(336);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(323);
				relacional();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(324);
				match(T__4);
				setState(325);
				expressao_logica(0);
				setState(326);
				match(T__5);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(328);
				match(NOT);
				setState(329);
				fator_logico();
				A28
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(332);
				match(TRUE);
				A29
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(334);
				match(FALSE);
				A30
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

	public static class RelacionalContext extends ParserRuleContext {
		public List<ExpressaoContext> expressao() {
			return getRuleContexts(ExpressaoContext.class);
		}
		public ExpressaoContext expressao(int i) {
			return getRuleContext(ExpressaoContext.class,i);
		}
		public TerminalNode EQ() { return getToken(PascalParser.EQ, 0); }
		public TerminalNode GT() { return getToken(PascalParser.GT, 0); }
		public TerminalNode GE() { return getToken(PascalParser.GE, 0); }
		public TerminalNode LT() { return getToken(PascalParser.LT, 0); }
		public TerminalNode LE() { return getToken(PascalParser.LE, 0); }
		public TerminalNode NE() { return getToken(PascalParser.NE, 0); }
		public RelacionalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relacional; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterRelacional(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitRelacional(this);
		}
	}

	public final RelacionalContext relacional() throws RecognitionException {
		RelacionalContext _localctx = new RelacionalContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_relacional);
		try {
			setState(368);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(338);
				expressao(0);
				setState(339);
				match(EQ);
				setState(340);
				expressao(0);
				A31
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(343);
				expressao(0);
				setState(344);
				match(GT);
				setState(345);
				expressao(0);
				A32
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(348);
				expressao(0);
				setState(349);
				match(GE);
				setState(350);
				expressao(0);
				A33
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(353);
				expressao(0);
				setState(354);
				match(LT);
				setState(355);
				expressao(0);
				A34
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(358);
				expressao(0);
				setState(359);
				match(LE);
				setState(360);
				expressao(0);
				A35
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(363);
				expressao(0);
				setState(364);
				match(NE);
				setState(365);
				expressao(0);
				A36
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

	public static class ExpressaoContext extends ParserRuleContext {
		public TermoContext termo() {
			return getRuleContext(TermoContext.class,0);
		}
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public TerminalNode ADD() { return getToken(PascalParser.ADD, 0); }
		public TerminalNode SUB() { return getToken(PascalParser.SUB, 0); }
		public ExpressaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterExpressao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitExpressao(this);
		}
	}

	public final ExpressaoContext expressao() throws RecognitionException {
		return expressao(0);
	}

	private ExpressaoContext expressao(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressaoContext _localctx = new ExpressaoContext(_ctx, _parentState);
		ExpressaoContext _prevctx = _localctx;
		int _startState = 46;
		enterRecursionRule(_localctx, 46, RULE_expressao, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(371);
			termo(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(385);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(383);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressaoContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expressao);
						setState(373);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(374);
						match(ADD);
						setState(375);
						termo(0);
						A37
						}
						break;
					case 2:
						{
						_localctx = new ExpressaoContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expressao);
						setState(378);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(379);
						match(SUB);
						setState(380);
						termo(0);
						A38
						}
						break;
					}
					} 
				}
				setState(387);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class TermoContext extends ParserRuleContext {
		public FatorContext fator() {
			return getRuleContext(FatorContext.class,0);
		}
		public TermoContext termo() {
			return getRuleContext(TermoContext.class,0);
		}
		public TerminalNode MUL() { return getToken(PascalParser.MUL, 0); }
		public TerminalNode DIV() { return getToken(PascalParser.DIV, 0); }
		public TermoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterTermo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitTermo(this);
		}
	}

	public final TermoContext termo() throws RecognitionException {
		return termo(0);
	}

	private TermoContext termo(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TermoContext _localctx = new TermoContext(_ctx, _parentState);
		TermoContext _prevctx = _localctx;
		int _startState = 48;
		enterRecursionRule(_localctx, 48, RULE_termo, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(389);
			fator();
			}
			_ctx.stop = _input.LT(-1);
			setState(403);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(401);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
					case 1:
						{
						_localctx = new TermoContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_termo);
						setState(391);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(392);
						match(MUL);
						setState(393);
						fator();
						A39
						}
						break;
					case 2:
						{
						_localctx = new TermoContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_termo);
						setState(396);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(397);
						match(DIV);
						setState(398);
						fator();
						A40
						}
						break;
					}
					} 
				}
				setState(405);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class FatorContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(PascalParser.ID, 0); }
		public ArgumentosContext argumentos() {
			return getRuleContext(ArgumentosContext.class,0);
		}
		public TerminalNode INT() { return getToken(PascalParser.INT, 0); }
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public FatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).enterFator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PascalListener ) ((PascalListener)listener).exitFator(this);
		}
	}

	public final FatorContext fator() throws RecognitionException {
		FatorContext _localctx = new FatorContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_fator);
		try {
			setState(419);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(406);
				match(ID);
				A55
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(408);
				match(ID);
				A60
				setState(410);
				argumentos();
				A42
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(413);
				match(INT);
				A41
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(415);
				match(T__4);
				setState(416);
				expressao(0);
				setState(417);
				match(T__5);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 6:
			return variaveis_sempred((VariaveisContext)_localctx, predIndex);
		case 12:
			return lista_id_sempred((Lista_idContext)_localctx, predIndex);
		case 13:
			return var_read_sempred((Var_readContext)_localctx, predIndex);
		case 14:
			return exp_write_sempred((Exp_writeContext)_localctx, predIndex);
		case 19:
			return expressao_logica_sempred((Expressao_logicaContext)_localctx, predIndex);
		case 20:
			return termo_logico_sempred((Termo_logicoContext)_localctx, predIndex);
		case 23:
			return expressao_sempred((ExpressaoContext)_localctx, predIndex);
		case 24:
			return termo_sempred((TermoContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean variaveis_sempred(VariaveisContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean lista_id_sempred(Lista_idContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean var_read_sempred(Var_readContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean exp_write_sempred(Exp_writeContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return precpred(_ctx, 4);
		case 4:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean expressao_logica_sempred(Expressao_logicaContext _localctx, int predIndex) {
		switch (predIndex) {
		case 5:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean termo_logico_sempred(Termo_logicoContext _localctx, int predIndex) {
		switch (predIndex) {
		case 6:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean expressao_sempred(ExpressaoContext _localctx, int predIndex) {
		switch (predIndex) {
		case 7:
			return precpred(_ctx, 3);
		case 8:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean termo_sempred(TermoContext _localctx, int predIndex) {
		switch (predIndex) {
		case 9:
			return precpred(_ctx, 3);
		case 10:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\61\u01a8\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\5\3@\n\3\3\3"+
		"\7\3C\n\3\f\3\16\3F\13\3\3\3\3\3\3\3\3\3\3\4\3\4\7\4N\n\4\f\4\16\4Q\13"+
		"\4\3\4\3\4\3\5\3\5\6\5W\n\5\r\5\16\5X\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\7\bk\n\b\f\b\16\bn\13\b\3\t\3\t\5\tr"+
		"\n\t\3\n\3\n\3\n\3\n\5\nx\n\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3"+
		"\13\5\13\u0084\n\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3"+
		"\f\6\f\u0091\n\f\r\f\16\f\u0092\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\5\r\u00a3\n\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\7\16\u00ad\n\16\f\16\16\16\u00b0\13\16\3\17\3\17\3\17\3\17\3\17\3"+
		"\17\3\17\3\17\7\17\u00ba\n\17\f\17\16\17\u00bd\13\17\3\20\3\20\3\20\3"+
		"\20\3\20\5\20\u00c4\n\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\7\20"+
		"\u00ce\n\20\f\20\16\20\u00d1\13\20\3\21\3\21\3\21\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\5\22\u0109\n\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\5\22\u0116\n\22\3\22\5\22\u0119\n\22\3\23\3"+
		"\23\3\23\3\23\7\23\u011f\n\23\f\23\16\23\u0122\13\23\5\23\u0124\n\23\3"+
		"\23\3\23\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\7"+
		"\25\u0134\n\25\f\25\16\25\u0137\13\25\3\26\3\26\3\26\3\26\3\26\3\26\3"+
		"\26\3\26\7\26\u0141\n\26\f\26\16\26\u0144\13\26\3\27\3\27\3\27\3\27\3"+
		"\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\5\27\u0153\n\27\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\5\30\u0173\n\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\7\31\u0182\n\31\f\31\16\31\u0185\13\31\3\32\3\32\3\32\3\32"+
		"\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\7\32\u0194\n\32\f\32\16"+
		"\32\u0197\13\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33"+
		"\3\33\3\33\5\33\u01a6\n\33\3\33\2\n\16\32\34\36(*\60\62\34\2\4\6\b\n\f"+
		"\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\2\2\2\u01ba\2\66\3\2\2\2"+
		"\4?\3\2\2\2\6K\3\2\2\2\bT\3\2\2\2\nZ\3\2\2\2\f`\3\2\2\2\16b\3\2\2\2\20"+
		"q\3\2\2\2\22s\3\2\2\2\24\177\3\2\2\2\26\u008e\3\2\2\2\30\u00a2\3\2\2\2"+
		"\32\u00a4\3\2\2\2\34\u00b1\3\2\2\2\36\u00c3\3\2\2\2 \u00d2\3\2\2\2\"\u0118"+
		"\3\2\2\2$\u011a\3\2\2\2&\u0127\3\2\2\2(\u012b\3\2\2\2*\u0138\3\2\2\2,"+
		"\u0152\3\2\2\2.\u0172\3\2\2\2\60\u0174\3\2\2\2\62\u0186\3\2\2\2\64\u01a5"+
		"\3\2\2\2\66\67\7\n\2\2\678\7,\2\289\b\2\1\29:\7\3\2\2:;\5\4\3\2;<\7\4"+
		"\2\2<=\b\2\1\2=\3\3\2\2\2>@\5\b\5\2?>\3\2\2\2?@\3\2\2\2@D\3\2\2\2AC\5"+
		"\20\t\2BA\3\2\2\2CF\3\2\2\2DB\3\2\2\2DE\3\2\2\2EG\3\2\2\2FD\3\2\2\2GH"+
		"\b\3\1\2HI\5\6\4\2IJ\b\3\1\2J\5\3\2\2\2KO\7\13\2\2LN\5 \21\2ML\3\2\2\2"+
		"NQ\3\2\2\2OM\3\2\2\2OP\3\2\2\2PR\3\2\2\2QO\3\2\2\2RS\7\f\2\2S\7\3\2\2"+
		"\2TV\7\r\2\2UW\5\n\6\2VU\3\2\2\2WX\3\2\2\2XV\3\2\2\2XY\3\2\2\2Y\t\3\2"+
		"\2\2Z[\5\16\b\2[\\\7\5\2\2\\]\5\f\7\2]^\b\6\1\2^_\7\3\2\2_\13\3\2\2\2"+
		"`a\7\16\2\2a\r\3\2\2\2bc\b\b\1\2cd\7,\2\2de\b\b\1\2el\3\2\2\2fg\f\4\2"+
		"\2gh\7\6\2\2hi\7,\2\2ik\b\b\1\2jf\3\2\2\2kn\3\2\2\2lj\3\2\2\2lm\3\2\2"+
		"\2m\17\3\2\2\2nl\3\2\2\2or\5\22\n\2pr\5\24\13\2qo\3\2\2\2qp\3\2\2\2r\21"+
		"\3\2\2\2st\7\17\2\2tu\7,\2\2uw\b\n\1\2vx\5\26\f\2wv\3\2\2\2wx\3\2\2\2"+
		"xy\3\2\2\2yz\b\n\1\2z{\7\3\2\2{|\5\4\3\2|}\b\n\1\2}~\7\3\2\2~\23\3\2\2"+
		"\2\177\u0080\7\20\2\2\u0080\u0081\7,\2\2\u0081\u0083\b\13\1\2\u0082\u0084"+
		"\5\26\f\2\u0083\u0082\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u0085\3\2\2\2"+
		"\u0085\u0086\b\13\1\2\u0086\u0087\7\5\2\2\u0087\u0088\5\f\7\2\u0088\u0089"+
		"\b\13\1\2\u0089\u008a\7\3\2\2\u008a\u008b\5\4\3\2\u008b\u008c\b\13\1\2"+
		"\u008c\u008d\7\3\2\2\u008d\25\3\2\2\2\u008e\u0090\7\7\2\2\u008f\u0091"+
		"\5\30\r\2\u0090\u008f\3\2\2\2\u0091\u0092\3\2\2\2\u0092\u0090\3\2\2\2"+
		"\u0092\u0093\3\2\2\2\u0093\u0094\3\2\2\2\u0094\u0095\7\b\2\2\u0095\27"+
		"\3\2\2\2\u0096\u0097\5\32\16\2\u0097\u0098\7\5\2\2\u0098\u0099\5\f\7\2"+
		"\u0099\u009a\b\r\1\2\u009a\u00a3\3\2\2\2\u009b\u009c\5\32\16\2\u009c\u009d"+
		"\7\5\2\2\u009d\u009e\5\f\7\2\u009e\u009f\b\r\1\2\u009f\u00a0\7\3\2\2\u00a0"+
		"\u00a1\5\30\r\2\u00a1\u00a3\3\2\2\2\u00a2\u0096\3\2\2\2\u00a2\u009b\3"+
		"\2\2\2\u00a3\31\3\2\2\2\u00a4\u00a5\b\16\1\2\u00a5\u00a6\7,\2\2\u00a6"+
		"\u00a7\b\16\1\2\u00a7\u00ae\3\2\2\2\u00a8\u00a9\f\4\2\2\u00a9\u00aa\7"+
		"\6\2\2\u00aa\u00ab\7,\2\2\u00ab\u00ad\b\16\1\2\u00ac\u00a8\3\2\2\2\u00ad"+
		"\u00b0\3\2\2\2\u00ae\u00ac\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\33\3\2\2"+
		"\2\u00b0\u00ae\3\2\2\2\u00b1\u00b2\b\17\1\2\u00b2\u00b3\7,\2\2\u00b3\u00b4"+
		"\b\17\1\2\u00b4\u00bb\3\2\2\2\u00b5\u00b6\f\4\2\2\u00b6\u00b7\7\6\2\2"+
		"\u00b7\u00b8\7,\2\2\u00b8\u00ba\b\17\1\2\u00b9\u00b5\3\2\2\2\u00ba\u00bd"+
		"\3\2\2\2\u00bb\u00b9\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bc\35\3\2\2\2\u00bd"+
		"\u00bb\3\2\2\2\u00be\u00bf\b\20\1\2\u00bf\u00c0\7.\2\2\u00c0\u00c4\b\20"+
		"\1\2\u00c1\u00c2\7,\2\2\u00c2\u00c4\b\20\1\2\u00c3\u00be\3\2\2\2\u00c3"+
		"\u00c1\3\2\2\2\u00c4\u00cf\3\2\2\2\u00c5\u00c6\f\6\2\2\u00c6\u00c7\7\6"+
		"\2\2\u00c7\u00c8\7.\2\2\u00c8\u00ce\b\20\1\2\u00c9\u00ca\f\4\2\2\u00ca"+
		"\u00cb\7\6\2\2\u00cb\u00cc\7,\2\2\u00cc\u00ce\b\20\1\2\u00cd\u00c5\3\2"+
		"\2\2\u00cd\u00c9\3\2\2\2\u00ce\u00d1\3\2\2\2\u00cf\u00cd\3\2\2\2\u00cf"+
		"\u00d0\3\2\2\2\u00d0\37\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d2\u00d3\5\"\22"+
		"\2\u00d3\u00d4\7\3\2\2\u00d4!\3\2\2\2\u00d5\u00d6\7\21\2\2\u00d6\u00d7"+
		"\7\7\2\2\u00d7\u00d8\5\34\17\2\u00d8\u00d9\7\b\2\2\u00d9\u0119\3\2\2\2"+
		"\u00da\u00db\7\22\2\2\u00db\u00dc\7\7\2\2\u00dc\u00dd\5\36\20\2\u00dd"+
		"\u00de\7\b\2\2\u00de\u0119\3\2\2\2\u00df\u00e0\7\23\2\2\u00e0\u00e1\7"+
		"\7\2\2\u00e1\u00e2\5\36\20\2\u00e2\u00e3\7\b\2\2\u00e3\u00e4\b\22\1\2"+
		"\u00e4\u0119\3\2\2\2\u00e5\u00e6\7\24\2\2\u00e6\u00e7\7,\2\2\u00e7\u00e8"+
		"\b\22\1\2\u00e8\u00e9\7\t\2\2\u00e9\u00ea\5\60\31\2\u00ea\u00eb\b\22\1"+
		"\2\u00eb\u00ec\7\25\2\2\u00ec\u00ed\5\60\31\2\u00ed\u00ee\b\22\1\2\u00ee"+
		"\u00ef\7\26\2\2\u00ef\u00f0\5\6\4\2\u00f0\u00f1\b\22\1\2\u00f1\u0119\3"+
		"\2\2\2\u00f2\u00f3\7\27\2\2\u00f3\u00f4\b\22\1\2\u00f4\u00f5\5 \21\2\u00f5"+
		"\u00f6\7\30\2\2\u00f6\u00f7\5(\25\2\u00f7\u00f8\b\22\1\2\u00f8\u0119\3"+
		"\2\2\2\u00f9\u00fa\7\31\2\2\u00fa\u00fb\b\22\1\2\u00fb\u00fc\5(\25\2\u00fc"+
		"\u00fd\b\22\1\2\u00fd\u00fe\7\26\2\2\u00fe\u00ff\5\6\4\2\u00ff\u0100\b"+
		"\22\1\2\u0100\u0119\3\2\2\2\u0101\u0102\7\32\2\2\u0102\u0103\5(\25\2\u0103"+
		"\u0104\b\22\1\2\u0104\u0105\7\33\2\2\u0105\u0106\5\6\4\2\u0106\u0108\b"+
		"\22\1\2\u0107\u0109\5&\24\2\u0108\u0107\3\2\2\2\u0108\u0109\3\2\2\2\u0109"+
		"\u010a\3\2\2\2\u010a\u010b\b\22\1\2\u010b\u0119\3\2\2\2\u010c\u010d\7"+
		",\2\2\u010d\u010e\b\22\1\2\u010e\u010f\7\t\2\2\u010f\u0110\5\60\31\2\u0110"+
		"\u0111\b\22\1\2\u0111\u0119\3\2\2\2\u0112\u0113\7,\2\2\u0113\u0115\b\22"+
		"\1\2\u0114\u0116\5$\23\2\u0115\u0114\3\2\2\2\u0115\u0116\3\2\2\2\u0116"+
		"\u0117\3\2\2\2\u0117\u0119\b\22\1\2\u0118\u00d5\3\2\2\2\u0118\u00da\3"+
		"\2\2\2\u0118\u00df\3\2\2\2\u0118\u00e5\3\2\2\2\u0118\u00f2\3\2\2\2\u0118"+
		"\u00f9\3\2\2\2\u0118\u0101\3\2\2\2\u0118\u010c\3\2\2\2\u0118\u0112\3\2"+
		"\2\2\u0119#\3\2\2\2\u011a\u0123\7\7\2\2\u011b\u0120\5\60\31\2\u011c\u011d"+
		"\7\6\2\2\u011d\u011f\5\60\31\2\u011e\u011c\3\2\2\2\u011f\u0122\3\2\2\2"+
		"\u0120\u011e\3\2\2\2\u0120\u0121\3\2\2\2\u0121\u0124\3\2\2\2\u0122\u0120"+
		"\3\2\2\2\u0123\u011b\3\2\2\2\u0123\u0124\3\2\2\2\u0124\u0125\3\2\2\2\u0125"+
		"\u0126\7\b\2\2\u0126%\3\2\2\2\u0127\u0128\7\34\2\2\u0128\u0129\b\24\1"+
		"\2\u0129\u012a\5\6\4\2\u012a\'\3\2\2\2\u012b\u012c\b\25\1\2\u012c\u012d"+
		"\5*\26\2\u012d\u0135\3\2\2\2\u012e\u012f\f\4\2\2\u012f\u0130\7!\2\2\u0130"+
		"\u0131\5*\26\2\u0131\u0132\b\25\1\2\u0132\u0134\3\2\2\2\u0133\u012e\3"+
		"\2\2\2\u0134\u0137\3\2\2\2\u0135\u0133\3\2\2\2\u0135\u0136\3\2\2\2\u0136"+
		")\3\2\2\2\u0137\u0135\3\2\2\2\u0138\u0139\b\26\1\2\u0139\u013a\5,\27\2"+
		"\u013a\u0142\3\2\2\2\u013b\u013c\f\4\2\2\u013c\u013d\7 \2\2\u013d\u013e"+
		"\5,\27\2\u013e\u013f\b\26\1\2\u013f\u0141\3\2\2\2\u0140\u013b\3\2\2\2"+
		"\u0141\u0144\3\2\2\2\u0142\u0140\3\2\2\2\u0142\u0143\3\2\2\2\u0143+\3"+
		"\2\2\2\u0144\u0142\3\2\2\2\u0145\u0153\5.\30\2\u0146\u0147\7\7\2\2\u0147"+
		"\u0148\5(\25\2\u0148\u0149\7\b\2\2\u0149\u0153\3\2\2\2\u014a\u014b\7\35"+
		"\2\2\u014b\u014c\5,\27\2\u014c\u014d\b\27\1\2\u014d\u0153\3\2\2\2\u014e"+
		"\u014f\7\36\2\2\u014f\u0153\b\27\1\2\u0150\u0151\7\37\2\2\u0151\u0153"+
		"\b\27\1\2\u0152\u0145\3\2\2\2\u0152\u0146\3\2\2\2\u0152\u014a\3\2\2\2"+
		"\u0152\u014e\3\2\2\2\u0152\u0150\3\2\2\2\u0153-\3\2\2\2\u0154\u0155\5"+
		"\60\31\2\u0155\u0156\7\"\2\2\u0156\u0157\5\60\31\2\u0157\u0158\b\30\1"+
		"\2\u0158\u0173\3\2\2\2\u0159\u015a\5\60\31\2\u015a\u015b\7#\2\2\u015b"+
		"\u015c\5\60\31\2\u015c\u015d\b\30\1\2\u015d\u0173\3\2\2\2\u015e\u015f"+
		"\5\60\31\2\u015f\u0160\7$\2\2\u0160\u0161\5\60\31\2\u0161\u0162\b\30\1"+
		"\2\u0162\u0173\3\2\2\2\u0163\u0164\5\60\31\2\u0164\u0165\7%\2\2\u0165"+
		"\u0166\5\60\31\2\u0166\u0167\b\30\1\2\u0167\u0173\3\2\2\2\u0168\u0169"+
		"\5\60\31\2\u0169\u016a\7&\2\2\u016a\u016b\5\60\31\2\u016b\u016c\b\30\1"+
		"\2\u016c\u0173\3\2\2\2\u016d\u016e\5\60\31\2\u016e\u016f\7\'\2\2\u016f"+
		"\u0170\5\60\31\2\u0170\u0171\b\30\1\2\u0171\u0173\3\2\2\2\u0172\u0154"+
		"\3\2\2\2\u0172\u0159\3\2\2\2\u0172\u015e\3\2\2\2\u0172\u0163\3\2\2\2\u0172"+
		"\u0168\3\2\2\2\u0172\u016d\3\2\2\2\u0173/\3\2\2\2\u0174\u0175\b\31\1\2"+
		"\u0175\u0176\5\62\32\2\u0176\u0183\3\2\2\2\u0177\u0178\f\5\2\2\u0178\u0179"+
		"\7*\2\2\u0179\u017a\5\62\32\2\u017a\u017b\b\31\1\2\u017b\u0182\3\2\2\2"+
		"\u017c\u017d\f\4\2\2\u017d\u017e\7+\2\2\u017e\u017f\5\62\32\2\u017f\u0180"+
		"\b\31\1\2\u0180\u0182\3\2\2\2\u0181\u0177\3\2\2\2\u0181\u017c\3\2\2\2"+
		"\u0182\u0185\3\2\2\2\u0183\u0181\3\2\2\2\u0183\u0184\3\2\2\2\u0184\61"+
		"\3\2\2\2\u0185\u0183\3\2\2\2\u0186\u0187\b\32\1\2\u0187\u0188\5\64\33"+
		"\2\u0188\u0195\3\2\2\2\u0189\u018a\f\5\2\2\u018a\u018b\7(\2\2\u018b\u018c"+
		"\5\64\33\2\u018c\u018d\b\32\1\2\u018d\u0194\3\2\2\2\u018e\u018f\f\4\2"+
		"\2\u018f\u0190\7)\2\2\u0190\u0191\5\64\33\2\u0191\u0192\b\32\1\2\u0192"+
		"\u0194\3\2\2\2\u0193\u0189\3\2\2\2\u0193\u018e\3\2\2\2\u0194\u0197\3\2"+
		"\2\2\u0195\u0193\3\2\2\2\u0195\u0196\3\2\2\2\u0196\63\3\2\2\2\u0197\u0195"+
		"\3\2\2\2\u0198\u0199\7,\2\2\u0199\u01a6\b\33\1\2\u019a\u019b\7,\2\2\u019b"+
		"\u019c\b\33\1\2\u019c\u019d\5$\23\2\u019d\u019e\b\33\1\2\u019e\u01a6\3"+
		"\2\2\2\u019f\u01a0\7-\2\2\u01a0\u01a6\b\33\1\2\u01a1\u01a2\7\7\2\2\u01a2"+
		"\u01a3\5\60\31\2\u01a3\u01a4\7\b\2\2\u01a4\u01a6\3\2\2\2\u01a5\u0198\3"+
		"\2\2\2\u01a5\u019a\3\2\2\2\u01a5\u019f\3\2\2\2\u01a5\u01a1\3\2\2\2\u01a6"+
		"\65\3\2\2\2\37?DOXlqw\u0083\u0092\u00a2\u00ae\u00bb\u00c3\u00cd\u00cf"+
		"\u0108\u0115\u0118\u0120\u0123\u0135\u0142\u0152\u0172\u0181\u0183\u0193"+
		"\u0195\u01a5";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}