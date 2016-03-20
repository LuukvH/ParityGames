// Generated from D:/GitHub/ParityGames\PGSolver.g4 by ANTLR 4.5.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link PGSolverParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface PGSolverVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link PGSolverParser#parityGame}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParityGame(PGSolverParser.ParityGameContext ctx);
	/**
	 * Visit a parse tree produced by {@link PGSolverParser#header}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHeader(PGSolverParser.HeaderContext ctx);
	/**
	 * Visit a parse tree produced by {@link PGSolverParser#nodeSpec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNodeSpec(PGSolverParser.NodeSpecContext ctx);
	/**
	 * Visit a parse tree produced by {@link PGSolverParser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(PGSolverParser.IdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link PGSolverParser#priority}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPriority(PGSolverParser.PriorityContext ctx);
	/**
	 * Visit a parse tree produced by {@link PGSolverParser#owner}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOwner(PGSolverParser.OwnerContext ctx);
	/**
	 * Visit a parse tree produced by {@link PGSolverParser#successors}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSuccessors(PGSolverParser.SuccessorsContext ctx);
	/**
	 * Visit a parse tree produced by {@link PGSolverParser#name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitName(PGSolverParser.NameContext ctx);
}