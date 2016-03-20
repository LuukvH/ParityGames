// Generated from D:/GitHub/ParityGames\PGSolver.g4 by ANTLR 4.5.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PGSolverParser}.
 */
public interface PGSolverListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link PGSolverParser#parityGame}.
	 * @param ctx the parse tree
	 */
	void enterParityGame(PGSolverParser.ParityGameContext ctx);
	/**
	 * Exit a parse tree produced by {@link PGSolverParser#parityGame}.
	 * @param ctx the parse tree
	 */
	void exitParityGame(PGSolverParser.ParityGameContext ctx);
	/**
	 * Enter a parse tree produced by {@link PGSolverParser#header}.
	 * @param ctx the parse tree
	 */
	void enterHeader(PGSolverParser.HeaderContext ctx);
	/**
	 * Exit a parse tree produced by {@link PGSolverParser#header}.
	 * @param ctx the parse tree
	 */
	void exitHeader(PGSolverParser.HeaderContext ctx);
	/**
	 * Enter a parse tree produced by {@link PGSolverParser#nodeSpec}.
	 * @param ctx the parse tree
	 */
	void enterNodeSpec(PGSolverParser.NodeSpecContext ctx);
	/**
	 * Exit a parse tree produced by {@link PGSolverParser#nodeSpec}.
	 * @param ctx the parse tree
	 */
	void exitNodeSpec(PGSolverParser.NodeSpecContext ctx);
	/**
	 * Enter a parse tree produced by {@link PGSolverParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(PGSolverParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link PGSolverParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(PGSolverParser.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link PGSolverParser#priority}.
	 * @param ctx the parse tree
	 */
	void enterPriority(PGSolverParser.PriorityContext ctx);
	/**
	 * Exit a parse tree produced by {@link PGSolverParser#priority}.
	 * @param ctx the parse tree
	 */
	void exitPriority(PGSolverParser.PriorityContext ctx);
	/**
	 * Enter a parse tree produced by {@link PGSolverParser#owner}.
	 * @param ctx the parse tree
	 */
	void enterOwner(PGSolverParser.OwnerContext ctx);
	/**
	 * Exit a parse tree produced by {@link PGSolverParser#owner}.
	 * @param ctx the parse tree
	 */
	void exitOwner(PGSolverParser.OwnerContext ctx);
	/**
	 * Enter a parse tree produced by {@link PGSolverParser#successors}.
	 * @param ctx the parse tree
	 */
	void enterSuccessors(PGSolverParser.SuccessorsContext ctx);
	/**
	 * Exit a parse tree produced by {@link PGSolverParser#successors}.
	 * @param ctx the parse tree
	 */
	void exitSuccessors(PGSolverParser.SuccessorsContext ctx);
	/**
	 * Enter a parse tree produced by {@link PGSolverParser#name}.
	 * @param ctx the parse tree
	 */
	void enterName(PGSolverParser.NameContext ctx);
	/**
	 * Exit a parse tree produced by {@link PGSolverParser#name}.
	 * @param ctx the parse tree
	 */
	void exitName(PGSolverParser.NameContext ctx);
}