package emuladorprocesadorz80;

// Generated from comp.g4 by ANTLR 4.7.2

    import java.util.Map;
    import java.util.HashMap;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class compParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		PROGRAMA=1, VAR=2, VEC=3, SUMA=4, RESTA=5, MULT=6, DIVI=7, AND=8, OR=9, 
		NOT=10, IF=11, ELSE=12, FOR=13, WHILE=14, MAYORI=15, MAYORQ=16, MENORI=17, 
		MENORQ=18, EQUIVA=19, NOEQUIVA=20, ASIGNAR=21, LLAVE_ABRE=22, LLAVE_CIERRA=23, 
		PAR_ABRE=24, PAR_CIERRA=25, SEMICOLON=26, ID=27, NUMERO=28, ESPACIOS=29;
	public static final int
		RULE_program = 0, RULE_sentencia = 1, RULE_expresion = 2, RULE_ciclofor = 3, 
		RULE_ifelse = 4, RULE_sentbooleana = 5, RULE_sentboolenanawhile = 6, RULE_ciclowhile = 7, 
		RULE_var_decl = 8, RULE_vec_decl = 9, RULE_var_asign_n = 10, RULE_var_asign_v = 11, 
		RULE_suma = 12, RULE_resta = 13, RULE_multiplicacion = 14, RULE_division = 15;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "sentencia", "expresion", "ciclofor", "ifelse", "sentbooleana", 
			"sentboolenanawhile", "ciclowhile", "var_decl", "vec_decl", "var_asign_n", 
			"var_asign_v", "suma", "resta", "multiplicacion", "division"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'programa'", "'var'", "'vec'", "'+'", "'-'", "'*'", "'/'", "'&&'", 
			"'||'", "'!'", "'if'", "'else'", "'for'", "'while'", "'>='", "'>'", "'<='", 
			"'<'", "'=='", "'!='", "'='", "'{'", "'}'", "'('", "')'", "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "PROGRAMA", "VAR", "VEC", "SUMA", "RESTA", "MULT", "DIVI", "AND", 
			"OR", "NOT", "IF", "ELSE", "FOR", "WHILE", "MAYORI", "MAYORQ", "MENORI", 
			"MENORQ", "EQUIVA", "NOEQUIVA", "ASIGNAR", "LLAVE_ABRE", "LLAVE_CIERRA", 
			"PAR_ABRE", "PAR_CIERRA", "SEMICOLON", "ID", "NUMERO", "ESPACIOS"
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
	public String getGrammarFileName() { return "comp.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	    Map<String, Object> symbolTable = new HashMap<String,Object>();
	    String assembler = "";
	    String subf = "1";
	    int dirvar=32768;
	    int ifcount = 1;
	    int whilecount = 1;

	public compParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode PROGRAMA() { return getToken(compParser.PROGRAMA, 0); }
		public TerminalNode ID() { return getToken(compParser.ID, 0); }
		public TerminalNode LLAVE_ABRE() { return getToken(compParser.LLAVE_ABRE, 0); }
		public TerminalNode LLAVE_CIERRA() { return getToken(compParser.LLAVE_CIERRA, 0); }
		public List<SentenciaContext> sentencia() {
			return getRuleContexts(SentenciaContext.class);
		}
		public SentenciaContext sentencia(int i) {
			return getRuleContext(SentenciaContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof compListener ) ((compListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof compListener ) ((compListener)listener).exitProgram(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(32);
			match(PROGRAMA);
			setState(33);
			match(ID);
			setState(34);
			match(LLAVE_ABRE);
			setState(38);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << VAR) | (1L << VEC) | (1L << IF) | (1L << FOR) | (1L << WHILE) | (1L << ID))) != 0)) {
				{
				{
				setState(35);
				sentencia();
				}
				}
				setState(40);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(41);
			match(LLAVE_CIERRA);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SentenciaContext extends ParserRuleContext {
		public Var_declContext var_decl() {
			return getRuleContext(Var_declContext.class,0);
		}
		public Vec_declContext vec_decl() {
			return getRuleContext(Vec_declContext.class,0);
		}
		public Var_asign_nContext var_asign_n() {
			return getRuleContext(Var_asign_nContext.class,0);
		}
		public Var_asign_vContext var_asign_v() {
			return getRuleContext(Var_asign_vContext.class,0);
		}
		public SumaContext suma() {
			return getRuleContext(SumaContext.class,0);
		}
		public RestaContext resta() {
			return getRuleContext(RestaContext.class,0);
		}
		public MultiplicacionContext multiplicacion() {
			return getRuleContext(MultiplicacionContext.class,0);
		}
		public DivisionContext division() {
			return getRuleContext(DivisionContext.class,0);
		}
		public IfelseContext ifelse() {
			return getRuleContext(IfelseContext.class,0);
		}
		public CicloforContext ciclofor() {
			return getRuleContext(CicloforContext.class,0);
		}
		public CiclowhileContext ciclowhile() {
			return getRuleContext(CiclowhileContext.class,0);
		}
		public SentenciaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentencia; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof compListener ) ((compListener)listener).enterSentencia(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof compListener ) ((compListener)listener).exitSentencia(this);
		}
	}

	public final SentenciaContext sentencia() throws RecognitionException {
		SentenciaContext _localctx = new SentenciaContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_sentencia);
		try {
			setState(54);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(43);
				var_decl();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(44);
				vec_decl();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(45);
				var_asign_n();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(46);
				var_asign_v();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(47);
				suma();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(48);
				resta();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(49);
				multiplicacion();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(50);
				division();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(51);
				ifelse();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(52);
				ciclofor();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(53);
				ciclowhile();
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

	public static class ExpresionContext extends ParserRuleContext {
		public String value;
		public Token NUMERO;
		public Token ID;
		public TerminalNode NUMERO() { return getToken(compParser.NUMERO, 0); }
		public TerminalNode ID() { return getToken(compParser.ID, 0); }
		public ExpresionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expresion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof compListener ) ((compListener)listener).enterExpresion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof compListener ) ((compListener)listener).exitExpresion(this);
		}
	}

	public final ExpresionContext expresion() throws RecognitionException {
		ExpresionContext _localctx = new ExpresionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_expresion);
		try {
			setState(60);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMERO:
				enterOuterAlt(_localctx, 1);
				{
				setState(56);
				((ExpresionContext)_localctx).NUMERO = match(NUMERO);
				((ExpresionContext)_localctx).value =  (((ExpresionContext)_localctx).NUMERO!=null?((ExpresionContext)_localctx).NUMERO.getText():null);
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(58);
				((ExpresionContext)_localctx).ID = match(ID);
				 ((ExpresionContext)_localctx).value =  "(" + (((ExpresionContext)_localctx).ID!=null?((ExpresionContext)_localctx).ID.getText():null) + subf + ")" ;
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

	public static class CicloforContext extends ParserRuleContext {
		public ExpresionContext expresion;
		public TerminalNode FOR() { return getToken(compParser.FOR, 0); }
		public TerminalNode PAR_ABRE() { return getToken(compParser.PAR_ABRE, 0); }
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public List<TerminalNode> SEMICOLON() { return getTokens(compParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(compParser.SEMICOLON, i);
		}
		public TerminalNode PAR_CIERRA() { return getToken(compParser.PAR_CIERRA, 0); }
		public TerminalNode LLAVE_ABRE() { return getToken(compParser.LLAVE_ABRE, 0); }
		public TerminalNode LLAVE_CIERRA() { return getToken(compParser.LLAVE_CIERRA, 0); }
		public List<SentenciaContext> sentencia() {
			return getRuleContexts(SentenciaContext.class);
		}
		public SentenciaContext sentencia(int i) {
			return getRuleContext(SentenciaContext.class,i);
		}
		public CicloforContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ciclofor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof compListener ) ((compListener)listener).enterCiclofor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof compListener ) ((compListener)listener).exitCiclofor(this);
		}
	}

	public final CicloforContext ciclofor() throws RecognitionException {
		CicloforContext _localctx = new CicloforContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_ciclofor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			match(FOR);
			setState(63);
			match(PAR_ABRE);
			setState(64);
			((CicloforContext)_localctx).expresion = expresion();

			                String temp1 = ((CicloforContext)_localctx).expresion.value;
			                assembler += "\n loop_init:";
			                assembler += "\n LD H, "+temp1;
			            
			setState(66);
			match(SEMICOLON);
			setState(67);
			((CicloforContext)_localctx).expresion = expresion();

			                assembler += "\n loop_cond:";
			                String temp2 = ((CicloforContext)_localctx).expresion.value;
			                assembler += "\n LD A, "+temp2;
			                assembler += "\n CP H";
			                assembler += "\n JP Z, loop_end";
			            
			setState(69);
			match(SEMICOLON);
			setState(70);
			((CicloforContext)_localctx).expresion = expresion();

			                String temp3 = ((CicloforContext)_localctx).expresion.value;
			            
			setState(72);
			match(PAR_CIERRA);
			setState(73);
			match(LLAVE_ABRE);

			                assembler += "\n loop_body:";
			            
			setState(78);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << VAR) | (1L << VEC) | (1L << IF) | (1L << FOR) | (1L << WHILE) | (1L << ID))) != 0)) {
				{
				{
				setState(75);
				sentencia();
				}
				}
				setState(80);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}

			               assembler += "\n loop_next:";
			               assembler += "\n INC H";
			               assembler += "\n JP loop_cond";
			            
			setState(82);
			match(LLAVE_CIERRA);

			               assembler += "\n loop_end:";
			            
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfelseContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(compParser.IF, 0); }
		public TerminalNode PAR_ABRE() { return getToken(compParser.PAR_ABRE, 0); }
		public SentbooleanaContext sentbooleana() {
			return getRuleContext(SentbooleanaContext.class,0);
		}
		public TerminalNode PAR_CIERRA() { return getToken(compParser.PAR_CIERRA, 0); }
		public List<TerminalNode> LLAVE_ABRE() { return getTokens(compParser.LLAVE_ABRE); }
		public TerminalNode LLAVE_ABRE(int i) {
			return getToken(compParser.LLAVE_ABRE, i);
		}
		public List<TerminalNode> LLAVE_CIERRA() { return getTokens(compParser.LLAVE_CIERRA); }
		public TerminalNode LLAVE_CIERRA(int i) {
			return getToken(compParser.LLAVE_CIERRA, i);
		}
		public TerminalNode ELSE() { return getToken(compParser.ELSE, 0); }
		public List<SentenciaContext> sentencia() {
			return getRuleContexts(SentenciaContext.class);
		}
		public SentenciaContext sentencia(int i) {
			return getRuleContext(SentenciaContext.class,i);
		}
		public IfelseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifelse; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof compListener ) ((compListener)listener).enterIfelse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof compListener ) ((compListener)listener).exitIfelse(this);
		}
	}

	public final IfelseContext ifelse() throws RecognitionException {
		IfelseContext _localctx = new IfelseContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_ifelse);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			match(IF);

			                int actual = ifcount;
			                ifcount = ifcount+1;
			                assembler += "\n If"+actual+":";
			            
			setState(87);
			match(PAR_ABRE);
			setState(88);
			sentbooleana(actual);
			setState(89);
			match(PAR_CIERRA);

			                assembler += "\n Then"+actual+":";
			            
			setState(91);
			match(LLAVE_ABRE);
			setState(95);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << VAR) | (1L << VEC) | (1L << IF) | (1L << FOR) | (1L << WHILE) | (1L << ID))) != 0)) {
				{
				{
				setState(92);
				sentencia();
				}
				}
				setState(97);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(98);
			match(LLAVE_CIERRA);

			                assembler += "\n jp Endif"+actual;
			            
			setState(100);
			match(ELSE);

			                assembler += "\n Else"+actual+":";
			            
			setState(102);
			match(LLAVE_ABRE);
			setState(106);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << VAR) | (1L << VEC) | (1L << IF) | (1L << FOR) | (1L << WHILE) | (1L << ID))) != 0)) {
				{
				{
				setState(103);
				sentencia();
				}
				}
				setState(108);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(109);
			match(LLAVE_CIERRA);

			                assembler += "\n Endif"+actual+":";
			            
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SentbooleanaContext extends ParserRuleContext {
		public int actual;
		public ExpresionContext expresion;
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public TerminalNode MAYORQ() { return getToken(compParser.MAYORQ, 0); }
		public TerminalNode MENORQ() { return getToken(compParser.MENORQ, 0); }
		public TerminalNode MENORI() { return getToken(compParser.MENORI, 0); }
		public TerminalNode MAYORI() { return getToken(compParser.MAYORI, 0); }
		public TerminalNode EQUIVA() { return getToken(compParser.EQUIVA, 0); }
		public TerminalNode NOEQUIVA() { return getToken(compParser.NOEQUIVA, 0); }
		public SentbooleanaContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public SentbooleanaContext(ParserRuleContext parent, int invokingState, int actual) {
			super(parent, invokingState);
			this.actual = actual;
		}
		@Override public int getRuleIndex() { return RULE_sentbooleana; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof compListener ) ((compListener)listener).enterSentbooleana(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof compListener ) ((compListener)listener).exitSentbooleana(this);
		}
	}

	public final SentbooleanaContext sentbooleana(int actual) throws RecognitionException {
		SentbooleanaContext _localctx = new SentbooleanaContext(_ctx, getState(), actual);
		enterRule(_localctx, 10, RULE_sentbooleana);
		try {
			setState(154);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(112);
				((SentbooleanaContext)_localctx).expresion = expresion();
				String temp1 = ((SentbooleanaContext)_localctx).expresion.value;
				setState(114);
				match(MAYORQ);
				setState(115);
				((SentbooleanaContext)_localctx).expresion = expresion();
				String temp2 = ((SentbooleanaContext)_localctx).expresion.value;

				                assembler += "\n LD A,"+temp1;
				                assembler += "\n LD B,A";
				                assembler += "\n LD A,"+temp2;
				                assembler += "\n SUB B";
				                assembler += "\n JP NC, Else"+actual;
				              
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(119);
				((SentbooleanaContext)_localctx).expresion = expresion();
				String temp1 = ((SentbooleanaContext)_localctx).expresion.value;
				setState(121);
				match(MENORQ);
				setState(122);
				((SentbooleanaContext)_localctx).expresion = expresion();
				String temp2 = ((SentbooleanaContext)_localctx).expresion.value;

				                assembler += "\n LD A,"+temp2;
				                assembler += "\n LD B,A";
				                assembler += "\n LD A,"+temp1;
				                assembler += "\n SUB B";
				                assembler += "\n JP NC, Else"+actual;
				              
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(126);
				((SentbooleanaContext)_localctx).expresion = expresion();
				String temp1 = ((SentbooleanaContext)_localctx).expresion.value;
				setState(128);
				match(MENORI);
				setState(129);
				((SentbooleanaContext)_localctx).expresion = expresion();
				String temp2 = ((SentbooleanaContext)_localctx).expresion.value;

				                assembler += "\n LD A,"+temp1;
				                assembler += "\n LD B,A";
				                assembler += "\n LD A,"+temp2;
				                assembler += "\n SUB B";
				                assembler += "\n JP C, Else"+actual;
				              
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(133);
				((SentbooleanaContext)_localctx).expresion = expresion();
				String temp1 = ((SentbooleanaContext)_localctx).expresion.value;
				setState(135);
				match(MAYORI);
				setState(136);
				((SentbooleanaContext)_localctx).expresion = expresion();
				String temp2 = ((SentbooleanaContext)_localctx).expresion.value;

				                assembler += "\n LD A,"+temp2;
				                assembler += "\n LD B,A";
				                assembler += "\n LD A,"+temp1;
				                assembler += "\n SUB B";
				                assembler += "\n JP C, Else"+actual;
				              
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(140);
				((SentbooleanaContext)_localctx).expresion = expresion();
				String temp1 = ((SentbooleanaContext)_localctx).expresion.value;
				setState(142);
				match(EQUIVA);
				setState(143);
				((SentbooleanaContext)_localctx).expresion = expresion();
				String temp2 = ((SentbooleanaContext)_localctx).expresion.value;

				                assembler += "\n LD A,"+temp2;
				                assembler += "\n LD B,A";
				                assembler += "\n LD A,"+temp1;
				                assembler += "\n SUB B";
				                assembler += "\n JP NZ, Else"+actual;
				              
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(147);
				((SentbooleanaContext)_localctx).expresion = expresion();
				String temp1 = ((SentbooleanaContext)_localctx).expresion.value;
				setState(149);
				match(NOEQUIVA);
				setState(150);
				((SentbooleanaContext)_localctx).expresion = expresion();
				String temp2 = ((SentbooleanaContext)_localctx).expresion.value;

				                assembler += "\n LD A,"+temp2;
				                assembler += "\n LD B,A";
				                assembler += "\n LD A,"+temp1;
				                assembler += "\n SUB B";
				                assembler += "\n JP Z, Else"+actual;
				              
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

	public static class SentboolenanawhileContext extends ParserRuleContext {
		public int actual;
		public ExpresionContext expresion;
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public TerminalNode MAYORQ() { return getToken(compParser.MAYORQ, 0); }
		public TerminalNode MENORQ() { return getToken(compParser.MENORQ, 0); }
		public TerminalNode MENORI() { return getToken(compParser.MENORI, 0); }
		public TerminalNode MAYORI() { return getToken(compParser.MAYORI, 0); }
		public TerminalNode EQUIVA() { return getToken(compParser.EQUIVA, 0); }
		public TerminalNode NOEQUIVA() { return getToken(compParser.NOEQUIVA, 0); }
		public SentboolenanawhileContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public SentboolenanawhileContext(ParserRuleContext parent, int invokingState, int actual) {
			super(parent, invokingState);
			this.actual = actual;
		}
		@Override public int getRuleIndex() { return RULE_sentboolenanawhile; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof compListener ) ((compListener)listener).enterSentboolenanawhile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof compListener ) ((compListener)listener).exitSentboolenanawhile(this);
		}
	}

	public final SentboolenanawhileContext sentboolenanawhile(int actual) throws RecognitionException {
		SentboolenanawhileContext _localctx = new SentboolenanawhileContext(_ctx, getState(), actual);
		enterRule(_localctx, 12, RULE_sentboolenanawhile);
		try {
			setState(198);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(156);
				((SentboolenanawhileContext)_localctx).expresion = expresion();
				String temp1 = ((SentboolenanawhileContext)_localctx).expresion.value;
				setState(158);
				match(MAYORQ);
				setState(159);
				((SentboolenanawhileContext)_localctx).expresion = expresion();
				String temp2 = ((SentboolenanawhileContext)_localctx).expresion.value;

				                assembler += "\n LD A,"+temp1;
				                assembler += "\n LD B,A";
				                assembler += "\n LD A,"+temp2;
				                assembler += "\n SUB B";
				                assembler += "\n JP NC, EndWhile"+actual;
				              
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(163);
				((SentboolenanawhileContext)_localctx).expresion = expresion();
				String temp1 = ((SentboolenanawhileContext)_localctx).expresion.value;
				setState(165);
				match(MENORQ);
				setState(166);
				((SentboolenanawhileContext)_localctx).expresion = expresion();
				String temp2 = ((SentboolenanawhileContext)_localctx).expresion.value;

				                assembler += "\n LD A,"+temp2;
				                assembler += "\n LD B,A";
				                assembler += "\n LD A,"+temp1;
				                assembler += "\n SUB B";
				                assembler += "\n JP NC, EndWhile"+actual;
				              
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(170);
				((SentboolenanawhileContext)_localctx).expresion = expresion();
				String temp1 = ((SentboolenanawhileContext)_localctx).expresion.value;
				setState(172);
				match(MENORI);
				setState(173);
				((SentboolenanawhileContext)_localctx).expresion = expresion();
				String temp2 = ((SentboolenanawhileContext)_localctx).expresion.value;

				                assembler += "\n LD A,"+temp1;
				                assembler += "\n LD B,A";
				                assembler += "\n LD A,"+temp2;
				                assembler += "\n SUB B";
				                assembler += "\n JP C, EndWhile"+actual;
				              
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(177);
				((SentboolenanawhileContext)_localctx).expresion = expresion();
				String temp1 = ((SentboolenanawhileContext)_localctx).expresion.value;
				setState(179);
				match(MAYORI);
				setState(180);
				((SentboolenanawhileContext)_localctx).expresion = expresion();
				String temp2 = ((SentboolenanawhileContext)_localctx).expresion.value;

				                assembler += "\n LD A,"+temp2;
				                assembler += "\n LD B,A";
				                assembler += "\n LD A,"+temp1;
				                assembler += "\n SUB B";
				                assembler += "\n JP C, EndWhile"+actual;
				              
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(184);
				((SentboolenanawhileContext)_localctx).expresion = expresion();
				String temp1 = ((SentboolenanawhileContext)_localctx).expresion.value;
				setState(186);
				match(EQUIVA);
				setState(187);
				((SentboolenanawhileContext)_localctx).expresion = expresion();
				String temp2 = ((SentboolenanawhileContext)_localctx).expresion.value;

				                assembler += "\n LD A,"+temp2;
				                assembler += "\n LD B,A";
				                assembler += "\n LD A,"+temp1;
				                assembler += "\n SUB B";
				                assembler += "\n JP NZ, EndWhile"+actual;
				              
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(191);
				((SentboolenanawhileContext)_localctx).expresion = expresion();
				String temp1 = ((SentboolenanawhileContext)_localctx).expresion.value;
				setState(193);
				match(NOEQUIVA);
				setState(194);
				((SentboolenanawhileContext)_localctx).expresion = expresion();
				String temp2 = ((SentboolenanawhileContext)_localctx).expresion.value;

				                assembler += "\n LD A,"+temp2;
				                assembler += "\n LD B,A";
				                assembler += "\n LD A,"+temp1;
				                assembler += "\n SUB B";
				                assembler += "\n JP Z, EndWhile"+actual;
				              
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

	public static class CiclowhileContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(compParser.WHILE, 0); }
		public TerminalNode PAR_ABRE() { return getToken(compParser.PAR_ABRE, 0); }
		public SentboolenanawhileContext sentboolenanawhile() {
			return getRuleContext(SentboolenanawhileContext.class,0);
		}
		public TerminalNode PAR_CIERRA() { return getToken(compParser.PAR_CIERRA, 0); }
		public TerminalNode LLAVE_ABRE() { return getToken(compParser.LLAVE_ABRE, 0); }
		public TerminalNode LLAVE_CIERRA() { return getToken(compParser.LLAVE_CIERRA, 0); }
		public List<SentenciaContext> sentencia() {
			return getRuleContexts(SentenciaContext.class);
		}
		public SentenciaContext sentencia(int i) {
			return getRuleContext(SentenciaContext.class,i);
		}
		public CiclowhileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ciclowhile; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof compListener ) ((compListener)listener).enterCiclowhile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof compListener ) ((compListener)listener).exitCiclowhile(this);
		}
	}

	public final CiclowhileContext ciclowhile() throws RecognitionException {
		CiclowhileContext _localctx = new CiclowhileContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_ciclowhile);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(200);
			match(WHILE);

			                int actual = whilecount;
			                whilecount = whilecount+1;
			                assembler += "\n While"+actual+":";
			            
			setState(202);
			match(PAR_ABRE);
			setState(203);
			sentboolenanawhile(actual);
			setState(204);
			match(PAR_CIERRA);
			setState(205);
			match(LLAVE_ABRE);
			setState(209);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << VAR) | (1L << VEC) | (1L << IF) | (1L << FOR) | (1L << WHILE) | (1L << ID))) != 0)) {
				{
				{
				setState(206);
				sentencia();
				}
				}
				setState(211);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(212);
			match(LLAVE_CIERRA);

			                assembler += "\n JP While"+actual;
			                assembler += "\n EndWhile"+actual+":";
			            
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Var_declContext extends ParserRuleContext {
		public Token ID;
		public TerminalNode VAR() { return getToken(compParser.VAR, 0); }
		public TerminalNode ID() { return getToken(compParser.ID, 0); }
		public TerminalNode SEMICOLON() { return getToken(compParser.SEMICOLON, 0); }
		public Var_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof compListener ) ((compListener)listener).enterVar_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof compListener ) ((compListener)listener).exitVar_decl(this);
		}
	}

	public final Var_declContext var_decl() throws RecognitionException {
		Var_declContext _localctx = new Var_declContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_var_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(215);
			match(VAR);
			setState(216);
			((Var_declContext)_localctx).ID = match(ID);
			setState(217);
			match(SEMICOLON);

			            String varname = (((Var_declContext)_localctx).ID!=null?((Var_declContext)_localctx).ID.getText():null) + subf;
			            symbolTable.put(varname,dirvar);
			            assembler += "\n ;declaracion de variable ";
			            assembler += "\n "+varname+": equ "+ dirvar;
			            dirvar = dirvar + 2;
			        
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Vec_declContext extends ParserRuleContext {
		public Token ID;
		public Token NUMERO;
		public TerminalNode VEC() { return getToken(compParser.VEC, 0); }
		public TerminalNode ID() { return getToken(compParser.ID, 0); }
		public TerminalNode NUMERO() { return getToken(compParser.NUMERO, 0); }
		public TerminalNode SEMICOLON() { return getToken(compParser.SEMICOLON, 0); }
		public Vec_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vec_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof compListener ) ((compListener)listener).enterVec_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof compListener ) ((compListener)listener).exitVec_decl(this);
		}
	}

	public final Vec_declContext vec_decl() throws RecognitionException {
		Vec_declContext _localctx = new Vec_declContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_vec_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(220);
			match(VEC);
			setState(221);
			((Vec_declContext)_localctx).ID = match(ID);
			setState(222);
			((Vec_declContext)_localctx).NUMERO = match(NUMERO);
			setState(223);
			match(SEMICOLON);

			            int tamano = Integer.parseInt((((Vec_declContext)_localctx).NUMERO!=null?((Vec_declContext)_localctx).NUMERO.getText():null));
			            assembler += "\n ;declaracion de vector ";
			            for(int i = 1; i<=tamano ; i++){
			                String varname = (((Vec_declContext)_localctx).ID!=null?((Vec_declContext)_localctx).ID.getText():null) + "_" + i + subf;
			                symbolTable.put(varname,dirvar);
			                assembler += "\n "+varname+": equ "+ dirvar;
			                dirvar = dirvar + 2;
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

	public static class Var_asign_nContext extends ParserRuleContext {
		public Token ID;
		public Token NUMERO;
		public TerminalNode ID() { return getToken(compParser.ID, 0); }
		public TerminalNode ASIGNAR() { return getToken(compParser.ASIGNAR, 0); }
		public TerminalNode NUMERO() { return getToken(compParser.NUMERO, 0); }
		public TerminalNode SEMICOLON() { return getToken(compParser.SEMICOLON, 0); }
		public Var_asign_nContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_asign_n; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof compListener ) ((compListener)listener).enterVar_asign_n(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof compListener ) ((compListener)listener).exitVar_asign_n(this);
		}
	}

	public final Var_asign_nContext var_asign_n() throws RecognitionException {
		Var_asign_nContext _localctx = new Var_asign_nContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_var_asign_n);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(226);
			((Var_asign_nContext)_localctx).ID = match(ID);
			setState(227);
			match(ASIGNAR);
			setState(228);
			((Var_asign_nContext)_localctx).NUMERO = match(NUMERO);
			setState(229);
			match(SEMICOLON);

			            String varname = (((Var_asign_nContext)_localctx).ID!=null?((Var_asign_nContext)_localctx).ID.getText():null) + subf;
			            assembler += "\n ;asignar valor a variable";
			            assembler += "\n LD " + "A" + "," + (((Var_asign_nContext)_localctx).NUMERO!=null?((Var_asign_nContext)_localctx).NUMERO.getText():null);
			            assembler += "\n LD " + "(" + varname+ ")" + ",A";
			        
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Var_asign_vContext extends ParserRuleContext {
		public Token ID;
		public List<TerminalNode> ID() { return getTokens(compParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(compParser.ID, i);
		}
		public TerminalNode ASIGNAR() { return getToken(compParser.ASIGNAR, 0); }
		public TerminalNode SEMICOLON() { return getToken(compParser.SEMICOLON, 0); }
		public Var_asign_vContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_asign_v; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof compListener ) ((compListener)listener).enterVar_asign_v(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof compListener ) ((compListener)listener).exitVar_asign_v(this);
		}
	}

	public final Var_asign_vContext var_asign_v() throws RecognitionException {
		Var_asign_vContext _localctx = new Var_asign_vContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_var_asign_v);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(232);
			((Var_asign_vContext)_localctx).ID = match(ID);
			String temp1 = (((Var_asign_vContext)_localctx).ID!=null?((Var_asign_vContext)_localctx).ID.getText():null) + subf;
			setState(234);
			match(ASIGNAR);
			setState(235);
			((Var_asign_vContext)_localctx).ID = match(ID);
			String temp2 = (((Var_asign_vContext)_localctx).ID!=null?((Var_asign_vContext)_localctx).ID.getText():null) + subf;
			setState(237);
			match(SEMICOLON);

			            assembler += "\n ;asignar variable a otra variable";
			            assembler += "\n LD " + "A" + "," +"("+ temp2 + ")";
			            assembler += "\n LD " + "(" + temp1 + ")" + ",A";
			        
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SumaContext extends ParserRuleContext {
		public Token ID;
		public ExpresionContext expresion;
		public TerminalNode ID() { return getToken(compParser.ID, 0); }
		public TerminalNode ASIGNAR() { return getToken(compParser.ASIGNAR, 0); }
		public TerminalNode PAR_ABRE() { return getToken(compParser.PAR_ABRE, 0); }
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public TerminalNode SUMA() { return getToken(compParser.SUMA, 0); }
		public TerminalNode PAR_CIERRA() { return getToken(compParser.PAR_CIERRA, 0); }
		public TerminalNode SEMICOLON() { return getToken(compParser.SEMICOLON, 0); }
		public SumaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_suma; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof compListener ) ((compListener)listener).enterSuma(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof compListener ) ((compListener)listener).exitSuma(this);
		}
	}

	public final SumaContext suma() throws RecognitionException {
		SumaContext _localctx = new SumaContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_suma);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(240);
			((SumaContext)_localctx).ID = match(ID);
			setState(241);
			match(ASIGNAR);
			setState(242);
			match(PAR_ABRE);
			setState(243);
			((SumaContext)_localctx).expresion = expresion();
			String temp1 = ((SumaContext)_localctx).expresion.value;
			setState(245);
			match(SUMA);
			setState(246);
			((SumaContext)_localctx).expresion = expresion();
			 String temp2 = ((SumaContext)_localctx).expresion.value;
			setState(248);
			match(PAR_CIERRA);
			setState(249);
			match(SEMICOLON);

			            assembler += "\n ;sumar "+temp1+"+"+temp2;
			            assembler += "\n LD A," + temp2;
			            assembler += "\n LD B,A";
			            assembler += "\n LD A," + temp1;
			            assembler += "\n ADD A,B";
			            assembler += "\n LD " + "(" + (((SumaContext)_localctx).ID!=null?((SumaContext)_localctx).ID.getText():null) + subf + ")" + ",A";
			        
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RestaContext extends ParserRuleContext {
		public Token ID;
		public ExpresionContext expresion;
		public TerminalNode ID() { return getToken(compParser.ID, 0); }
		public TerminalNode ASIGNAR() { return getToken(compParser.ASIGNAR, 0); }
		public TerminalNode PAR_ABRE() { return getToken(compParser.PAR_ABRE, 0); }
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public TerminalNode RESTA() { return getToken(compParser.RESTA, 0); }
		public TerminalNode PAR_CIERRA() { return getToken(compParser.PAR_CIERRA, 0); }
		public TerminalNode SEMICOLON() { return getToken(compParser.SEMICOLON, 0); }
		public RestaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_resta; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof compListener ) ((compListener)listener).enterResta(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof compListener ) ((compListener)listener).exitResta(this);
		}
	}

	public final RestaContext resta() throws RecognitionException {
		RestaContext _localctx = new RestaContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_resta);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(252);
			((RestaContext)_localctx).ID = match(ID);
			setState(253);
			match(ASIGNAR);
			setState(254);
			match(PAR_ABRE);
			setState(255);
			((RestaContext)_localctx).expresion = expresion();
			String temp1 = ((RestaContext)_localctx).expresion.value;
			setState(257);
			match(RESTA);
			setState(258);
			((RestaContext)_localctx).expresion = expresion();
			 String temp2 = ((RestaContext)_localctx).expresion.value;
			setState(260);
			match(PAR_CIERRA);
			setState(261);
			match(SEMICOLON);

			            assembler += "\n ;restar "+temp1+"-"+temp2;
			            assembler += "\n LD A," + temp2;
			            assembler += "\n LD B,A";
			            assembler += "\n LD A," + temp1;
			            assembler += "\n SUB B";
			            assembler += "\n LD " + "(" + (((RestaContext)_localctx).ID!=null?((RestaContext)_localctx).ID.getText():null) + subf + ")" + ",A";
			        
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MultiplicacionContext extends ParserRuleContext {
		public Token ID;
		public ExpresionContext expresion;
		public TerminalNode ID() { return getToken(compParser.ID, 0); }
		public TerminalNode ASIGNAR() { return getToken(compParser.ASIGNAR, 0); }
		public TerminalNode PAR_ABRE() { return getToken(compParser.PAR_ABRE, 0); }
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public TerminalNode MULT() { return getToken(compParser.MULT, 0); }
		public TerminalNode PAR_CIERRA() { return getToken(compParser.PAR_CIERRA, 0); }
		public TerminalNode SEMICOLON() { return getToken(compParser.SEMICOLON, 0); }
		public MultiplicacionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiplicacion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof compListener ) ((compListener)listener).enterMultiplicacion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof compListener ) ((compListener)listener).exitMultiplicacion(this);
		}
	}

	public final MultiplicacionContext multiplicacion() throws RecognitionException {
		MultiplicacionContext _localctx = new MultiplicacionContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_multiplicacion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(264);
			((MultiplicacionContext)_localctx).ID = match(ID);
			setState(265);
			match(ASIGNAR);
			setState(266);
			match(PAR_ABRE);
			setState(267);
			((MultiplicacionContext)_localctx).expresion = expresion();
			String temp1 = ((MultiplicacionContext)_localctx).expresion.value;
			setState(269);
			match(MULT);
			setState(270);
			((MultiplicacionContext)_localctx).expresion = expresion();
			 String temp2 = ((MultiplicacionContext)_localctx).expresion.value;
			setState(272);
			match(PAR_CIERRA);
			setState(273);
			match(SEMICOLON);

			            assembler += "\n ;multiplicar "+temp1+"*"+temp2;
			            assembler += "\n LD A," + temp2;
			            assembler += "\n LD C,A";
			            assembler += "\n LD A," + temp1;
			            assembler += "\n LD B,A";
			            assembler += "\n LD A,0";
			            assembler += "\n ADD A,C";
			            assembler += "\n DJNZ $-1";
			            assembler += "\n LD " + "(" + (((MultiplicacionContext)_localctx).ID!=null?((MultiplicacionContext)_localctx).ID.getText():null) + subf + ")" + ",A";
			        
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DivisionContext extends ParserRuleContext {
		public Token ID;
		public ExpresionContext expresion;
		public TerminalNode ID() { return getToken(compParser.ID, 0); }
		public TerminalNode ASIGNAR() { return getToken(compParser.ASIGNAR, 0); }
		public TerminalNode PAR_ABRE() { return getToken(compParser.PAR_ABRE, 0); }
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public TerminalNode DIVI() { return getToken(compParser.DIVI, 0); }
		public TerminalNode PAR_CIERRA() { return getToken(compParser.PAR_CIERRA, 0); }
		public TerminalNode SEMICOLON() { return getToken(compParser.SEMICOLON, 0); }
		public DivisionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_division; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof compListener ) ((compListener)listener).enterDivision(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof compListener ) ((compListener)listener).exitDivision(this);
		}
	}

	public final DivisionContext division() throws RecognitionException {
		DivisionContext _localctx = new DivisionContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_division);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(276);
			((DivisionContext)_localctx).ID = match(ID);
			setState(277);
			match(ASIGNAR);
			setState(278);
			match(PAR_ABRE);
			setState(279);
			((DivisionContext)_localctx).expresion = expresion();
			String temp1 = ((DivisionContext)_localctx).expresion.value;
			setState(281);
			match(DIVI);
			setState(282);
			((DivisionContext)_localctx).expresion = expresion();
			 String temp2 = ((DivisionContext)_localctx).expresion.value;
			setState(284);
			match(PAR_CIERRA);
			setState(285);
			match(SEMICOLON);

			            assembler += "\n ;dividir "+temp1+"/"+temp2;
			            assembler += "\n LD A," + temp1;
			            assembler += "\n LD C,A";
			            assembler += "\n LD A," + temp2;
			            assembler += "\n LD D,A";
			            assembler += "\n LD B,8";
			            assembler += "\n XOR A";
			            assembler += "\n SLA C";
			            assembler += "\n RLA";
			            assembler += "\n CP D";
			            assembler += "\n JR C,$+4";
			            assembler += "\n INC C";
			            assembler += "\n SUB D";
			            assembler += "\n DJNZ $-8";
			            assembler += "\n LD E,A";
			            assembler += "\n LD A,C";
			            assembler += "\n LD " + "(" + (((DivisionContext)_localctx).ID!=null?((DivisionContext)_localctx).ID.getText():null) + subf + ")" + ",A";
			        
			}
		}
		catch (RecognitionException re) {
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\37\u0123\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\3\2"+
		"\3\2\3\2\7\2\'\n\2\f\2\16\2*\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\5\39\n\3\3\4\3\4\3\4\3\4\5\4?\n\4\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5O\n\5\f\5\16\5R\13\5\3\5\3\5\3"+
		"\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6`\n\6\f\6\16\6c\13\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\7\6k\n\6\f\6\16\6n\13\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\5\7\u009d\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u00c9\n\b\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\7\t\u00d2\n\t\f\t\16\t\u00d5\13\t\3\t\3\t\3\t"+
		"\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\2\2\22\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \2\2\2\u012c\2\"\3\2\2"+
		"\2\48\3\2\2\2\6>\3\2\2\2\b@\3\2\2\2\nW\3\2\2\2\f\u009c\3\2\2\2\16\u00c8"+
		"\3\2\2\2\20\u00ca\3\2\2\2\22\u00d9\3\2\2\2\24\u00de\3\2\2\2\26\u00e4\3"+
		"\2\2\2\30\u00ea\3\2\2\2\32\u00f2\3\2\2\2\34\u00fe\3\2\2\2\36\u010a\3\2"+
		"\2\2 \u0116\3\2\2\2\"#\7\3\2\2#$\7\35\2\2$(\7\30\2\2%\'\5\4\3\2&%\3\2"+
		"\2\2\'*\3\2\2\2(&\3\2\2\2()\3\2\2\2)+\3\2\2\2*(\3\2\2\2+,\7\31\2\2,\3"+
		"\3\2\2\2-9\5\22\n\2.9\5\24\13\2/9\5\26\f\2\609\5\30\r\2\619\5\32\16\2"+
		"\629\5\34\17\2\639\5\36\20\2\649\5 \21\2\659\5\n\6\2\669\5\b\5\2\679\5"+
		"\20\t\28-\3\2\2\28.\3\2\2\28/\3\2\2\28\60\3\2\2\28\61\3\2\2\28\62\3\2"+
		"\2\28\63\3\2\2\28\64\3\2\2\28\65\3\2\2\28\66\3\2\2\28\67\3\2\2\29\5\3"+
		"\2\2\2:;\7\36\2\2;?\b\4\1\2<=\7\35\2\2=?\b\4\1\2>:\3\2\2\2><\3\2\2\2?"+
		"\7\3\2\2\2@A\7\17\2\2AB\7\32\2\2BC\5\6\4\2CD\b\5\1\2DE\7\34\2\2EF\5\6"+
		"\4\2FG\b\5\1\2GH\7\34\2\2HI\5\6\4\2IJ\b\5\1\2JK\7\33\2\2KL\7\30\2\2LP"+
		"\b\5\1\2MO\5\4\3\2NM\3\2\2\2OR\3\2\2\2PN\3\2\2\2PQ\3\2\2\2QS\3\2\2\2R"+
		"P\3\2\2\2ST\b\5\1\2TU\7\31\2\2UV\b\5\1\2V\t\3\2\2\2WX\7\r\2\2XY\b\6\1"+
		"\2YZ\7\32\2\2Z[\5\f\7\2[\\\7\33\2\2\\]\b\6\1\2]a\7\30\2\2^`\5\4\3\2_^"+
		"\3\2\2\2`c\3\2\2\2a_\3\2\2\2ab\3\2\2\2bd\3\2\2\2ca\3\2\2\2de\7\31\2\2"+
		"ef\b\6\1\2fg\7\16\2\2gh\b\6\1\2hl\7\30\2\2ik\5\4\3\2ji\3\2\2\2kn\3\2\2"+
		"\2lj\3\2\2\2lm\3\2\2\2mo\3\2\2\2nl\3\2\2\2op\7\31\2\2pq\b\6\1\2q\13\3"+
		"\2\2\2rs\5\6\4\2st\b\7\1\2tu\7\22\2\2uv\5\6\4\2vw\b\7\1\2wx\b\7\1\2x\u009d"+
		"\3\2\2\2yz\5\6\4\2z{\b\7\1\2{|\7\24\2\2|}\5\6\4\2}~\b\7\1\2~\177\b\7\1"+
		"\2\177\u009d\3\2\2\2\u0080\u0081\5\6\4\2\u0081\u0082\b\7\1\2\u0082\u0083"+
		"\7\23\2\2\u0083\u0084\5\6\4\2\u0084\u0085\b\7\1\2\u0085\u0086\b\7\1\2"+
		"\u0086\u009d\3\2\2\2\u0087\u0088\5\6\4\2\u0088\u0089\b\7\1\2\u0089\u008a"+
		"\7\21\2\2\u008a\u008b\5\6\4\2\u008b\u008c\b\7\1\2\u008c\u008d\b\7\1\2"+
		"\u008d\u009d\3\2\2\2\u008e\u008f\5\6\4\2\u008f\u0090\b\7\1\2\u0090\u0091"+
		"\7\25\2\2\u0091\u0092\5\6\4\2\u0092\u0093\b\7\1\2\u0093\u0094\b\7\1\2"+
		"\u0094\u009d\3\2\2\2\u0095\u0096\5\6\4\2\u0096\u0097\b\7\1\2\u0097\u0098"+
		"\7\26\2\2\u0098\u0099\5\6\4\2\u0099\u009a\b\7\1\2\u009a\u009b\b\7\1\2"+
		"\u009b\u009d\3\2\2\2\u009cr\3\2\2\2\u009cy\3\2\2\2\u009c\u0080\3\2\2\2"+
		"\u009c\u0087\3\2\2\2\u009c\u008e\3\2\2\2\u009c\u0095\3\2\2\2\u009d\r\3"+
		"\2\2\2\u009e\u009f\5\6\4\2\u009f\u00a0\b\b\1\2\u00a0\u00a1\7\22\2\2\u00a1"+
		"\u00a2\5\6\4\2\u00a2\u00a3\b\b\1\2\u00a3\u00a4\b\b\1\2\u00a4\u00c9\3\2"+
		"\2\2\u00a5\u00a6\5\6\4\2\u00a6\u00a7\b\b\1\2\u00a7\u00a8\7\24\2\2\u00a8"+
		"\u00a9\5\6\4\2\u00a9\u00aa\b\b\1\2\u00aa\u00ab\b\b\1\2\u00ab\u00c9\3\2"+
		"\2\2\u00ac\u00ad\5\6\4\2\u00ad\u00ae\b\b\1\2\u00ae\u00af\7\23\2\2\u00af"+
		"\u00b0\5\6\4\2\u00b0\u00b1\b\b\1\2\u00b1\u00b2\b\b\1\2\u00b2\u00c9\3\2"+
		"\2\2\u00b3\u00b4\5\6\4\2\u00b4\u00b5\b\b\1\2\u00b5\u00b6\7\21\2\2\u00b6"+
		"\u00b7\5\6\4\2\u00b7\u00b8\b\b\1\2\u00b8\u00b9\b\b\1\2\u00b9\u00c9\3\2"+
		"\2\2\u00ba\u00bb\5\6\4\2\u00bb\u00bc\b\b\1\2\u00bc\u00bd\7\25\2\2\u00bd"+
		"\u00be\5\6\4\2\u00be\u00bf\b\b\1\2\u00bf\u00c0\b\b\1\2\u00c0\u00c9\3\2"+
		"\2\2\u00c1\u00c2\5\6\4\2\u00c2\u00c3\b\b\1\2\u00c3\u00c4\7\26\2\2\u00c4"+
		"\u00c5\5\6\4\2\u00c5\u00c6\b\b\1\2\u00c6\u00c7\b\b\1\2\u00c7\u00c9\3\2"+
		"\2\2\u00c8\u009e\3\2\2\2\u00c8\u00a5\3\2\2\2\u00c8\u00ac\3\2\2\2\u00c8"+
		"\u00b3\3\2\2\2\u00c8\u00ba\3\2\2\2\u00c8\u00c1\3\2\2\2\u00c9\17\3\2\2"+
		"\2\u00ca\u00cb\7\20\2\2\u00cb\u00cc\b\t\1\2\u00cc\u00cd\7\32\2\2\u00cd"+
		"\u00ce\5\16\b\2\u00ce\u00cf\7\33\2\2\u00cf\u00d3\7\30\2\2\u00d0\u00d2"+
		"\5\4\3\2\u00d1\u00d0\3\2\2\2\u00d2\u00d5\3\2\2\2\u00d3\u00d1\3\2\2\2\u00d3"+
		"\u00d4\3\2\2\2\u00d4\u00d6\3\2\2\2\u00d5\u00d3\3\2\2\2\u00d6\u00d7\7\31"+
		"\2\2\u00d7\u00d8\b\t\1\2\u00d8\21\3\2\2\2\u00d9\u00da\7\4\2\2\u00da\u00db"+
		"\7\35\2\2\u00db\u00dc\7\34\2\2\u00dc\u00dd\b\n\1\2\u00dd\23\3\2\2\2\u00de"+
		"\u00df\7\5\2\2\u00df\u00e0\7\35\2\2\u00e0\u00e1\7\36\2\2\u00e1\u00e2\7"+
		"\34\2\2\u00e2\u00e3\b\13\1\2\u00e3\25\3\2\2\2\u00e4\u00e5\7\35\2\2\u00e5"+
		"\u00e6\7\27\2\2\u00e6\u00e7\7\36\2\2\u00e7\u00e8\7\34\2\2\u00e8\u00e9"+
		"\b\f\1\2\u00e9\27\3\2\2\2\u00ea\u00eb\7\35\2\2\u00eb\u00ec\b\r\1\2\u00ec"+
		"\u00ed\7\27\2\2\u00ed\u00ee\7\35\2\2\u00ee\u00ef\b\r\1\2\u00ef\u00f0\7"+
		"\34\2\2\u00f0\u00f1\b\r\1\2\u00f1\31\3\2\2\2\u00f2\u00f3\7\35\2\2\u00f3"+
		"\u00f4\7\27\2\2\u00f4\u00f5\7\32\2\2\u00f5\u00f6\5\6\4\2\u00f6\u00f7\b"+
		"\16\1\2\u00f7\u00f8\7\6\2\2\u00f8\u00f9\5\6\4\2\u00f9\u00fa\b\16\1\2\u00fa"+
		"\u00fb\7\33\2\2\u00fb\u00fc\7\34\2\2\u00fc\u00fd\b\16\1\2\u00fd\33\3\2"+
		"\2\2\u00fe\u00ff\7\35\2\2\u00ff\u0100\7\27\2\2\u0100\u0101\7\32\2\2\u0101"+
		"\u0102\5\6\4\2\u0102\u0103\b\17\1\2\u0103\u0104\7\7\2\2\u0104\u0105\5"+
		"\6\4\2\u0105\u0106\b\17\1\2\u0106\u0107\7\33\2\2\u0107\u0108\7\34\2\2"+
		"\u0108\u0109\b\17\1\2\u0109\35\3\2\2\2\u010a\u010b\7\35\2\2\u010b\u010c"+
		"\7\27\2\2\u010c\u010d\7\32\2\2\u010d\u010e\5\6\4\2\u010e\u010f\b\20\1"+
		"\2\u010f\u0110\7\b\2\2\u0110\u0111\5\6\4\2\u0111\u0112\b\20\1\2\u0112"+
		"\u0113\7\33\2\2\u0113\u0114\7\34\2\2\u0114\u0115\b\20\1\2\u0115\37\3\2"+
		"\2\2\u0116\u0117\7\35\2\2\u0117\u0118\7\27\2\2\u0118\u0119\7\32\2\2\u0119"+
		"\u011a\5\6\4\2\u011a\u011b\b\21\1\2\u011b\u011c\7\t\2\2\u011c\u011d\5"+
		"\6\4\2\u011d\u011e\b\21\1\2\u011e\u011f\7\33\2\2\u011f\u0120\7\34\2\2"+
		"\u0120\u0121\b\21\1\2\u0121!\3\2\2\2\13(8>Pal\u009c\u00c8\u00d3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}