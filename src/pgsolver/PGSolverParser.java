// Generated from D:/GitHub/ParityGames\PGSolver.g4 by ANTLR 4.5.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PGSolverParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, NUMBER=6, STRING=7;
	public static final int
		RULE_parityGame = 0, RULE_header = 1, RULE_nodeSpec = 2, RULE_identifier = 3, 
		RULE_priority = 4, RULE_owner = 5, RULE_successors = 6, RULE_name = 7;
	public static final String[] ruleNames = {
		"parityGame", "header", "nodeSpec", "identifier", "priority", "owner", 
		"successors", "name"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'parity'", "';'", "'0'", "'1'", "','"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, "NUMBER", "STRING"
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
	public String getGrammarFileName() { return "PGSolver.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public PGSolverParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ParityGameContext extends ParserRuleContext {
		public HeaderContext header() {
			return getRuleContext(HeaderContext.class,0);
		}
		public List<NodeSpecContext> nodeSpec() {
			return getRuleContexts(NodeSpecContext.class);
		}
		public NodeSpecContext nodeSpec(int i) {
			return getRuleContext(NodeSpecContext.class,i);
		}
		public ParityGameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parityGame; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PGSolverListener ) ((PGSolverListener)listener).enterParityGame(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PGSolverListener ) ((PGSolverListener)listener).exitParityGame(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PGSolverVisitor ) return ((PGSolverVisitor<? extends T>)visitor).visitParityGame(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParityGameContext parityGame() throws RecognitionException {
		ParityGameContext _localctx = new ParityGameContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_parityGame);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(17);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(16);
				header();
				}
			}

			setState(22);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NUMBER) {
				{
				{
				setState(19);
				nodeSpec();
				}
				}
				setState(24);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class HeaderContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public HeaderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_header; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PGSolverListener ) ((PGSolverListener)listener).enterHeader(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PGSolverListener ) ((PGSolverListener)listener).exitHeader(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PGSolverVisitor ) return ((PGSolverVisitor<? extends T>)visitor).visitHeader(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HeaderContext header() throws RecognitionException {
		HeaderContext _localctx = new HeaderContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_header);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(25);
			match(T__0);
			setState(26);
			identifier();
			setState(27);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NodeSpecContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public PriorityContext priority() {
			return getRuleContext(PriorityContext.class,0);
		}
		public OwnerContext owner() {
			return getRuleContext(OwnerContext.class,0);
		}
		public SuccessorsContext successors() {
			return getRuleContext(SuccessorsContext.class,0);
		}
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public NodeSpecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nodeSpec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PGSolverListener ) ((PGSolverListener)listener).enterNodeSpec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PGSolverListener ) ((PGSolverListener)listener).exitNodeSpec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PGSolverVisitor ) return ((PGSolverVisitor<? extends T>)visitor).visitNodeSpec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NodeSpecContext nodeSpec() throws RecognitionException {
		NodeSpecContext _localctx = new NodeSpecContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_nodeSpec);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(29);
			identifier();
			setState(30);
			priority();
			setState(31);
			owner();
			setState(32);
			successors();
			setState(34);
			_la = _input.LA(1);
			if (_la==STRING) {
				{
				setState(33);
				name();
				}
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

	public static class IdentifierContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(PGSolverParser.NUMBER, 0); }
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PGSolverListener ) ((PGSolverListener)listener).enterIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PGSolverListener ) ((PGSolverListener)listener).exitIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PGSolverVisitor ) return ((PGSolverVisitor<? extends T>)visitor).visitIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_identifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(36);
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

	public static class PriorityContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(PGSolverParser.NUMBER, 0); }
		public PriorityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_priority; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PGSolverListener ) ((PGSolverListener)listener).enterPriority(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PGSolverListener ) ((PGSolverListener)listener).exitPriority(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PGSolverVisitor ) return ((PGSolverVisitor<? extends T>)visitor).visitPriority(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PriorityContext priority() throws RecognitionException {
		PriorityContext _localctx = new PriorityContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_priority);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(38);
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

	public static class OwnerContext extends ParserRuleContext {
		public OwnerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_owner; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PGSolverListener ) ((PGSolverListener)listener).enterOwner(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PGSolverListener ) ((PGSolverListener)listener).exitOwner(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PGSolverVisitor ) return ((PGSolverVisitor<? extends T>)visitor).visitOwner(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OwnerContext owner() throws RecognitionException {
		OwnerContext _localctx = new OwnerContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_owner);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(40);
			_la = _input.LA(1);
			if ( !(_la==T__2 || _la==T__3) ) {
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

	public static class SuccessorsContext extends ParserRuleContext {
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public SuccessorsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_successors; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PGSolverListener ) ((PGSolverListener)listener).enterSuccessors(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PGSolverListener ) ((PGSolverListener)listener).exitSuccessors(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PGSolverVisitor ) return ((PGSolverVisitor<? extends T>)visitor).visitSuccessors(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SuccessorsContext successors() throws RecognitionException {
		SuccessorsContext _localctx = new SuccessorsContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_successors);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(42);
			identifier();
			setState(47);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(43);
				match(T__4);
				setState(44);
				identifier();
				}
				}
				setState(49);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class NameContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(PGSolverParser.STRING, 0); }
		public NameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PGSolverListener ) ((PGSolverListener)listener).enterName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PGSolverListener ) ((PGSolverListener)listener).exitName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PGSolverVisitor ) return ((PGSolverVisitor<? extends T>)visitor).visitName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NameContext name() throws RecognitionException {
		NameContext _localctx = new NameContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			match(STRING);
			}
		}
		catch (RecognitionException re) {
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\t\67\4\2\t\2\4\3"+
		"\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\5\2\24\n\2\3"+
		"\2\7\2\27\n\2\f\2\16\2\32\13\2\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\5\4"+
		"%\n\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\b\7\b\60\n\b\f\b\16\b\63\13\b"+
		"\3\t\3\t\3\t\2\2\n\2\4\6\b\n\f\16\20\2\3\3\2\5\6\62\2\23\3\2\2\2\4\33"+
		"\3\2\2\2\6\37\3\2\2\2\b&\3\2\2\2\n(\3\2\2\2\f*\3\2\2\2\16,\3\2\2\2\20"+
		"\64\3\2\2\2\22\24\5\4\3\2\23\22\3\2\2\2\23\24\3\2\2\2\24\30\3\2\2\2\25"+
		"\27\5\6\4\2\26\25\3\2\2\2\27\32\3\2\2\2\30\26\3\2\2\2\30\31\3\2\2\2\31"+
		"\3\3\2\2\2\32\30\3\2\2\2\33\34\7\3\2\2\34\35\5\b\5\2\35\36\7\4\2\2\36"+
		"\5\3\2\2\2\37 \5\b\5\2 !\5\n\6\2!\"\5\f\7\2\"$\5\16\b\2#%\5\20\t\2$#\3"+
		"\2\2\2$%\3\2\2\2%\7\3\2\2\2&\'\7\b\2\2\'\t\3\2\2\2()\7\b\2\2)\13\3\2\2"+
		"\2*+\t\2\2\2+\r\3\2\2\2,\61\5\b\5\2-.\7\7\2\2.\60\5\b\5\2/-\3\2\2\2\60"+
		"\63\3\2\2\2\61/\3\2\2\2\61\62\3\2\2\2\62\17\3\2\2\2\63\61\3\2\2\2\64\65"+
		"\7\t\2\2\65\21\3\2\2\2\6\23\30$\61";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}