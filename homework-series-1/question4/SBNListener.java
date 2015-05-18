// Generated from /Users/twancoenraad/Code/compiler-construction-homework-series/homework-series-1/question4/SBN.g4 by ANTLR 4.5
package question4;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SBNParser}.
 */
public interface SBNListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SBNParser#number}.
	 * @param ctx the parse tree
	 */
	void enterNumber(@NotNull SBNParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link SBNParser#number}.
	 * @param ctx the parse tree
	 */
	void exitNumber(@NotNull SBNParser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code pos}
	 * labeled alternative in {@link SBNParser#sign}.
	 * @param ctx the parse tree
	 */
	void enterPos(@NotNull SBNParser.PosContext ctx);
	/**
	 * Exit a parse tree produced by the {@code pos}
	 * labeled alternative in {@link SBNParser#sign}.
	 * @param ctx the parse tree
	 */
	void exitPos(@NotNull SBNParser.PosContext ctx);
	/**
	 * Enter a parse tree produced by the {@code neg}
	 * labeled alternative in {@link SBNParser#sign}.
	 * @param ctx the parse tree
	 */
	void enterNeg(@NotNull SBNParser.NegContext ctx);
	/**
	 * Exit a parse tree produced by the {@code neg}
	 * labeled alternative in {@link SBNParser#sign}.
	 * @param ctx the parse tree
	 */
	void exitNeg(@NotNull SBNParser.NegContext ctx);
	/**
	 * Enter a parse tree produced by the {@code listListBit}
	 * labeled alternative in {@link SBNParser#list}.
	 * @param ctx the parse tree
	 */
	void enterListListBit(@NotNull SBNParser.ListListBitContext ctx);
	/**
	 * Exit a parse tree produced by the {@code listListBit}
	 * labeled alternative in {@link SBNParser#list}.
	 * @param ctx the parse tree
	 */
	void exitListListBit(@NotNull SBNParser.ListListBitContext ctx);
	/**
	 * Enter a parse tree produced by the {@code listBit}
	 * labeled alternative in {@link SBNParser#list}.
	 * @param ctx the parse tree
	 */
	void enterListBit(@NotNull SBNParser.ListBitContext ctx);
	/**
	 * Exit a parse tree produced by the {@code listBit}
	 * labeled alternative in {@link SBNParser#list}.
	 * @param ctx the parse tree
	 */
	void exitListBit(@NotNull SBNParser.ListBitContext ctx);
	/**
	 * Enter a parse tree produced by the {@code zero}
	 * labeled alternative in {@link SBNParser#bit}.
	 * @param ctx the parse tree
	 */
	void enterZero(@NotNull SBNParser.ZeroContext ctx);
	/**
	 * Exit a parse tree produced by the {@code zero}
	 * labeled alternative in {@link SBNParser#bit}.
	 * @param ctx the parse tree
	 */
	void exitZero(@NotNull SBNParser.ZeroContext ctx);
	/**
	 * Enter a parse tree produced by the {@code one}
	 * labeled alternative in {@link SBNParser#bit}.
	 * @param ctx the parse tree
	 */
	void enterOne(@NotNull SBNParser.OneContext ctx);
	/**
	 * Exit a parse tree produced by the {@code one}
	 * labeled alternative in {@link SBNParser#bit}.
	 * @param ctx the parse tree
	 */
	void exitOne(@NotNull SBNParser.OneContext ctx);
}