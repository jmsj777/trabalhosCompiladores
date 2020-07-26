// Generated from PASCAL.g4 by ANTLR 4.8
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PASCALParser}.
 */
public interface PASCALListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link PASCALParser#programa}.
	 * @param ctx the parse tree
	 */
	void enterPrograma(PASCALParser.ProgramaContext ctx);
	/**
	 * Exit a parse tree produced by {@link PASCALParser#programa}.
	 * @param ctx the parse tree
	 */
	void exitPrograma(PASCALParser.ProgramaContext ctx);
	/**
	 * Enter a parse tree produced by {@link PASCALParser#corpo}.
	 * @param ctx the parse tree
	 */
	void enterCorpo(PASCALParser.CorpoContext ctx);
	/**
	 * Exit a parse tree produced by {@link PASCALParser#corpo}.
	 * @param ctx the parse tree
	 */
	void exitCorpo(PASCALParser.CorpoContext ctx);
	/**
	 * Enter a parse tree produced by {@link PASCALParser#bloco}.
	 * @param ctx the parse tree
	 */
	void enterBloco(PASCALParser.BlocoContext ctx);
	/**
	 * Exit a parse tree produced by {@link PASCALParser#bloco}.
	 * @param ctx the parse tree
	 */
	void exitBloco(PASCALParser.BlocoContext ctx);
	/**
	 * Enter a parse tree produced by {@link PASCALParser#declara}.
	 * @param ctx the parse tree
	 */
	void enterDeclara(PASCALParser.DeclaraContext ctx);
	/**
	 * Exit a parse tree produced by {@link PASCALParser#declara}.
	 * @param ctx the parse tree
	 */
	void exitDeclara(PASCALParser.DeclaraContext ctx);
	/**
	 * Enter a parse tree produced by {@link PASCALParser#dvar}.
	 * @param ctx the parse tree
	 */
	void enterDvar(PASCALParser.DvarContext ctx);
	/**
	 * Exit a parse tree produced by {@link PASCALParser#dvar}.
	 * @param ctx the parse tree
	 */
	void exitDvar(PASCALParser.DvarContext ctx);
	/**
	 * Enter a parse tree produced by {@link PASCALParser#tipo}.
	 * @param ctx the parse tree
	 */
	void enterTipo(PASCALParser.TipoContext ctx);
	/**
	 * Exit a parse tree produced by {@link PASCALParser#tipo}.
	 * @param ctx the parse tree
	 */
	void exitTipo(PASCALParser.TipoContext ctx);
	/**
	 * Enter a parse tree produced by {@link PASCALParser#variaveis}.
	 * @param ctx the parse tree
	 */
	void enterVariaveis(PASCALParser.VariaveisContext ctx);
	/**
	 * Exit a parse tree produced by {@link PASCALParser#variaveis}.
	 * @param ctx the parse tree
	 */
	void exitVariaveis(PASCALParser.VariaveisContext ctx);
	/**
	 * Enter a parse tree produced by {@link PASCALParser#rotina}.
	 * @param ctx the parse tree
	 */
	void enterRotina(PASCALParser.RotinaContext ctx);
	/**
	 * Exit a parse tree produced by {@link PASCALParser#rotina}.
	 * @param ctx the parse tree
	 */
	void exitRotina(PASCALParser.RotinaContext ctx);
	/**
	 * Enter a parse tree produced by {@link PASCALParser#procedimento}.
	 * @param ctx the parse tree
	 */
	void enterProcedimento(PASCALParser.ProcedimentoContext ctx);
	/**
	 * Exit a parse tree produced by {@link PASCALParser#procedimento}.
	 * @param ctx the parse tree
	 */
	void exitProcedimento(PASCALParser.ProcedimentoContext ctx);
	/**
	 * Enter a parse tree produced by {@link PASCALParser#funcao}.
	 * @param ctx the parse tree
	 */
	void enterFuncao(PASCALParser.FuncaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link PASCALParser#funcao}.
	 * @param ctx the parse tree
	 */
	void exitFuncao(PASCALParser.FuncaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link PASCALParser#parametros}.
	 * @param ctx the parse tree
	 */
	void enterParametros(PASCALParser.ParametrosContext ctx);
	/**
	 * Exit a parse tree produced by {@link PASCALParser#parametros}.
	 * @param ctx the parse tree
	 */
	void exitParametros(PASCALParser.ParametrosContext ctx);
	/**
	 * Enter a parse tree produced by {@link PASCALParser#lista_parametros}.
	 * @param ctx the parse tree
	 */
	void enterLista_parametros(PASCALParser.Lista_parametrosContext ctx);
	/**
	 * Exit a parse tree produced by {@link PASCALParser#lista_parametros}.
	 * @param ctx the parse tree
	 */
	void exitLista_parametros(PASCALParser.Lista_parametrosContext ctx);
	/**
	 * Enter a parse tree produced by {@link PASCALParser#lista_id}.
	 * @param ctx the parse tree
	 */
	void enterLista_id(PASCALParser.Lista_idContext ctx);
	/**
	 * Exit a parse tree produced by {@link PASCALParser#lista_id}.
	 * @param ctx the parse tree
	 */
	void exitLista_id(PASCALParser.Lista_idContext ctx);
	/**
	 * Enter a parse tree produced by {@link PASCALParser#var_read}.
	 * @param ctx the parse tree
	 */
	void enterVar_read(PASCALParser.Var_readContext ctx);
	/**
	 * Exit a parse tree produced by {@link PASCALParser#var_read}.
	 * @param ctx the parse tree
	 */
	void exitVar_read(PASCALParser.Var_readContext ctx);
	/**
	 * Enter a parse tree produced by {@link PASCALParser#exp_write}.
	 * @param ctx the parse tree
	 */
	void enterExp_write(PASCALParser.Exp_writeContext ctx);
	/**
	 * Exit a parse tree produced by {@link PASCALParser#exp_write}.
	 * @param ctx the parse tree
	 */
	void exitExp_write(PASCALParser.Exp_writeContext ctx);
	/**
	 * Enter a parse tree produced by {@link PASCALParser#sentenca}.
	 * @param ctx the parse tree
	 */
	void enterSentenca(PASCALParser.SentencaContext ctx);
	/**
	 * Exit a parse tree produced by {@link PASCALParser#sentenca}.
	 * @param ctx the parse tree
	 */
	void exitSentenca(PASCALParser.SentencaContext ctx);
	/**
	 * Enter a parse tree produced by {@link PASCALParser#comando}.
	 * @param ctx the parse tree
	 */
	void enterComando(PASCALParser.ComandoContext ctx);
	/**
	 * Exit a parse tree produced by {@link PASCALParser#comando}.
	 * @param ctx the parse tree
	 */
	void exitComando(PASCALParser.ComandoContext ctx);
	/**
	 * Enter a parse tree produced by {@link PASCALParser#argumentos}.
	 * @param ctx the parse tree
	 */
	void enterArgumentos(PASCALParser.ArgumentosContext ctx);
	/**
	 * Exit a parse tree produced by {@link PASCALParser#argumentos}.
	 * @param ctx the parse tree
	 */
	void exitArgumentos(PASCALParser.ArgumentosContext ctx);
	/**
	 * Enter a parse tree produced by {@link PASCALParser#pfalsa}.
	 * @param ctx the parse tree
	 */
	void enterPfalsa(PASCALParser.PfalsaContext ctx);
	/**
	 * Exit a parse tree produced by {@link PASCALParser#pfalsa}.
	 * @param ctx the parse tree
	 */
	void exitPfalsa(PASCALParser.PfalsaContext ctx);
	/**
	 * Enter a parse tree produced by {@link PASCALParser#expressao_logica}.
	 * @param ctx the parse tree
	 */
	void enterExpressao_logica(PASCALParser.Expressao_logicaContext ctx);
	/**
	 * Exit a parse tree produced by {@link PASCALParser#expressao_logica}.
	 * @param ctx the parse tree
	 */
	void exitExpressao_logica(PASCALParser.Expressao_logicaContext ctx);
	/**
	 * Enter a parse tree produced by {@link PASCALParser#termo_logico}.
	 * @param ctx the parse tree
	 */
	void enterTermo_logico(PASCALParser.Termo_logicoContext ctx);
	/**
	 * Exit a parse tree produced by {@link PASCALParser#termo_logico}.
	 * @param ctx the parse tree
	 */
	void exitTermo_logico(PASCALParser.Termo_logicoContext ctx);
	/**
	 * Enter a parse tree produced by {@link PASCALParser#fator_logico}.
	 * @param ctx the parse tree
	 */
	void enterFator_logico(PASCALParser.Fator_logicoContext ctx);
	/**
	 * Exit a parse tree produced by {@link PASCALParser#fator_logico}.
	 * @param ctx the parse tree
	 */
	void exitFator_logico(PASCALParser.Fator_logicoContext ctx);
	/**
	 * Enter a parse tree produced by {@link PASCALParser#relacional}.
	 * @param ctx the parse tree
	 */
	void enterRelacional(PASCALParser.RelacionalContext ctx);
	/**
	 * Exit a parse tree produced by {@link PASCALParser#relacional}.
	 * @param ctx the parse tree
	 */
	void exitRelacional(PASCALParser.RelacionalContext ctx);
	/**
	 * Enter a parse tree produced by {@link PASCALParser#expressao}.
	 * @param ctx the parse tree
	 */
	void enterExpressao(PASCALParser.ExpressaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link PASCALParser#expressao}.
	 * @param ctx the parse tree
	 */
	void exitExpressao(PASCALParser.ExpressaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link PASCALParser#termo}.
	 * @param ctx the parse tree
	 */
	void enterTermo(PASCALParser.TermoContext ctx);
	/**
	 * Exit a parse tree produced by {@link PASCALParser#termo}.
	 * @param ctx the parse tree
	 */
	void exitTermo(PASCALParser.TermoContext ctx);
	/**
	 * Enter a parse tree produced by {@link PASCALParser#fator}.
	 * @param ctx the parse tree
	 */
	void enterFator(PASCALParser.FatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link PASCALParser#fator}.
	 * @param ctx the parse tree
	 */
	void exitFator(PASCALParser.FatorContext ctx);
}