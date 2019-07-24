package emuladorprocesadorz80;

// Generated from comp.g4 by ANTLR 4.7.2

    import java.util.Map;
    import java.util.HashMap;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link compParser}.
 */
public interface compListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link compParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(compParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link compParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(compParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link compParser#sentencia}.
	 * @param ctx the parse tree
	 */
	void enterSentencia(compParser.SentenciaContext ctx);
	/**
	 * Exit a parse tree produced by {@link compParser#sentencia}.
	 * @param ctx the parse tree
	 */
	void exitSentencia(compParser.SentenciaContext ctx);
	/**
	 * Enter a parse tree produced by {@link compParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExpresion(compParser.ExpresionContext ctx);
	/**
	 * Exit a parse tree produced by {@link compParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExpresion(compParser.ExpresionContext ctx);
	/**
	 * Enter a parse tree produced by {@link compParser#ciclofor}.
	 * @param ctx the parse tree
	 */
	void enterCiclofor(compParser.CicloforContext ctx);
	/**
	 * Exit a parse tree produced by {@link compParser#ciclofor}.
	 * @param ctx the parse tree
	 */
	void exitCiclofor(compParser.CicloforContext ctx);
	/**
	 * Enter a parse tree produced by {@link compParser#ifelse}.
	 * @param ctx the parse tree
	 */
	void enterIfelse(compParser.IfelseContext ctx);
	/**
	 * Exit a parse tree produced by {@link compParser#ifelse}.
	 * @param ctx the parse tree
	 */
	void exitIfelse(compParser.IfelseContext ctx);
	/**
	 * Enter a parse tree produced by {@link compParser#sentbooleana}.
	 * @param ctx the parse tree
	 */
	void enterSentbooleana(compParser.SentbooleanaContext ctx);
	/**
	 * Exit a parse tree produced by {@link compParser#sentbooleana}.
	 * @param ctx the parse tree
	 */
	void exitSentbooleana(compParser.SentbooleanaContext ctx);
	/**
	 * Enter a parse tree produced by {@link compParser#sentboolenanawhile}.
	 * @param ctx the parse tree
	 */
	void enterSentboolenanawhile(compParser.SentboolenanawhileContext ctx);
	/**
	 * Exit a parse tree produced by {@link compParser#sentboolenanawhile}.
	 * @param ctx the parse tree
	 */
	void exitSentboolenanawhile(compParser.SentboolenanawhileContext ctx);
	/**
	 * Enter a parse tree produced by {@link compParser#ciclowhile}.
	 * @param ctx the parse tree
	 */
	void enterCiclowhile(compParser.CiclowhileContext ctx);
	/**
	 * Exit a parse tree produced by {@link compParser#ciclowhile}.
	 * @param ctx the parse tree
	 */
	void exitCiclowhile(compParser.CiclowhileContext ctx);
	/**
	 * Enter a parse tree produced by {@link compParser#var_decl}.
	 * @param ctx the parse tree
	 */
	void enterVar_decl(compParser.Var_declContext ctx);
	/**
	 * Exit a parse tree produced by {@link compParser#var_decl}.
	 * @param ctx the parse tree
	 */
	void exitVar_decl(compParser.Var_declContext ctx);
	/**
	 * Enter a parse tree produced by {@link compParser#vec_decl}.
	 * @param ctx the parse tree
	 */
	void enterVec_decl(compParser.Vec_declContext ctx);
	/**
	 * Exit a parse tree produced by {@link compParser#vec_decl}.
	 * @param ctx the parse tree
	 */
	void exitVec_decl(compParser.Vec_declContext ctx);
	/**
	 * Enter a parse tree produced by {@link compParser#var_asign_n}.
	 * @param ctx the parse tree
	 */
	void enterVar_asign_n(compParser.Var_asign_nContext ctx);
	/**
	 * Exit a parse tree produced by {@link compParser#var_asign_n}.
	 * @param ctx the parse tree
	 */
	void exitVar_asign_n(compParser.Var_asign_nContext ctx);
	/**
	 * Enter a parse tree produced by {@link compParser#var_asign_v}.
	 * @param ctx the parse tree
	 */
	void enterVar_asign_v(compParser.Var_asign_vContext ctx);
	/**
	 * Exit a parse tree produced by {@link compParser#var_asign_v}.
	 * @param ctx the parse tree
	 */
	void exitVar_asign_v(compParser.Var_asign_vContext ctx);
	/**
	 * Enter a parse tree produced by {@link compParser#suma}.
	 * @param ctx the parse tree
	 */
	void enterSuma(compParser.SumaContext ctx);
	/**
	 * Exit a parse tree produced by {@link compParser#suma}.
	 * @param ctx the parse tree
	 */
	void exitSuma(compParser.SumaContext ctx);
	/**
	 * Enter a parse tree produced by {@link compParser#resta}.
	 * @param ctx the parse tree
	 */
	void enterResta(compParser.RestaContext ctx);
	/**
	 * Exit a parse tree produced by {@link compParser#resta}.
	 * @param ctx the parse tree
	 */
	void exitResta(compParser.RestaContext ctx);
	/**
	 * Enter a parse tree produced by {@link compParser#multiplicacion}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicacion(compParser.MultiplicacionContext ctx);
	/**
	 * Exit a parse tree produced by {@link compParser#multiplicacion}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicacion(compParser.MultiplicacionContext ctx);
	/**
	 * Enter a parse tree produced by {@link compParser#division}.
	 * @param ctx the parse tree
	 */
	void enterDivision(compParser.DivisionContext ctx);
	/**
	 * Exit a parse tree produced by {@link compParser#division}.
	 * @param ctx the parse tree
	 */
	void exitDivision(compParser.DivisionContext ctx);
}