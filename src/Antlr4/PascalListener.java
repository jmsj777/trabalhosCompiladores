// Generated from Pascal.g4 by ANTLR 4.8

package Antlr4;
import Acoes.Acoes;

import java.lang.reflect.InvocationTargetException;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PascalParser}.
 */
public interface PascalListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link PascalParser#programa}.
	 * @param ctx the parse tree
	 */
	void enterPrograma(PascalParser.ProgramaContext ctx);
	/**
	 * Exit a parse tree produced by {@link PascalParser#programa}.
	 * @param ctx the parse tree
	 */
	void exitPrograma(PascalParser.ProgramaContext ctx);
	/**
	 * Enter a parse tree produced by {@link PascalParser#corpo}.
	 * @param ctx the parse tree
	 */
	void enterCorpo(PascalParser.CorpoContext ctx);
	/**
	 * Exit a parse tree produced by {@link PascalParser#corpo}.
	 * @param ctx the parse tree
	 */
	void exitCorpo(PascalParser.CorpoContext ctx);
	/**
	 * Enter a parse tree produced by {@link PascalParser#bloco}.
	 * @param ctx the parse tree
	 */
	void enterBloco(PascalParser.BlocoContext ctx);
	/**
	 * Exit a parse tree produced by {@link PascalParser#bloco}.
	 * @param ctx the parse tree
	 */
	void exitBloco(PascalParser.BlocoContext ctx);
	/**
	 * Enter a parse tree produced by {@link PascalParser#declara}.
	 * @param ctx the parse tree
	 */
	void enterDeclara(PascalParser.DeclaraContext ctx);
	/**
	 * Exit a parse tree produced by {@link PascalParser#declara}.
	 * @param ctx the parse tree
	 */
	void exitDeclara(PascalParser.DeclaraContext ctx);
	/**
	 * Enter a parse tree produced by {@link PascalParser#dvar}.
	 * @param ctx the parse tree
	 */
	void enterDvar(PascalParser.DvarContext ctx);
	/**
	 * Exit a parse tree produced by {@link PascalParser#dvar}.
	 * @param ctx the parse tree
	 */
	void exitDvar(PascalParser.DvarContext ctx);
	/**
	 * Enter a parse tree produced by {@link PascalParser#tipo}.
	 * @param ctx the parse tree
	 */
	void enterTipo(PascalParser.TipoContext ctx);
	/**
	 * Exit a parse tree produced by {@link PascalParser#tipo}.
	 * @param ctx the parse tree
	 */
	void exitTipo(PascalParser.TipoContext ctx);
	/**
	 * Enter a parse tree produced by {@link PascalParser#variaveis}.
	 * @param ctx the parse tree
	 */
	void enterVariaveis(PascalParser.VariaveisContext ctx);
	/**
	 * Exit a parse tree produced by {@link PascalParser#variaveis}.
	 * @param ctx the parse tree
	 */
	void exitVariaveis(PascalParser.VariaveisContext ctx);
	/**
	 * Enter a parse tree produced by {@link PascalParser#rotina}.
	 * @param ctx the parse tree
	 */
	void enterRotina(PascalParser.RotinaContext ctx);
	/**
	 * Exit a parse tree produced by {@link PascalParser#rotina}.
	 * @param ctx the parse tree
	 */
	void exitRotina(PascalParser.RotinaContext ctx);
	/**
	 * Enter a parse tree produced by {@link PascalParser#procedimento}.
	 * @param ctx the parse tree
	 */
	void enterProcedimento(PascalParser.ProcedimentoContext ctx);
	/**
	 * Exit a parse tree produced by {@link PascalParser#procedimento}.
	 * @param ctx the parse tree
	 */
	void exitProcedimento(PascalParser.ProcedimentoContext ctx);
	/**
	 * Enter a parse tree produced by {@link PascalParser#funcao}.
	 * @param ctx the parse tree
	 */
	void enterFuncao(PascalParser.FuncaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link PascalParser#funcao}.
	 * @param ctx the parse tree
	 */
	void exitFuncao(PascalParser.FuncaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link PascalParser#parametros}.
	 * @param ctx the parse tree
	 */
	void enterParametros(PascalParser.ParametrosContext ctx);
	/**
	 * Exit a parse tree produced by {@link PascalParser#parametros}.
	 * @param ctx the parse tree
	 */
	void exitParametros(PascalParser.ParametrosContext ctx);
	/**
	 * Enter a parse tree produced by {@link PascalParser#lista_parametros}.
	 * @param ctx the parse tree
	 */
	void enterLista_parametros(PascalParser.Lista_parametrosContext ctx);
	/**
	 * Exit a parse tree produced by {@link PascalParser#lista_parametros}.
	 * @param ctx the parse tree
	 */
	void exitLista_parametros(PascalParser.Lista_parametrosContext ctx);
	/**
	 * Enter a parse tree produced by {@link PascalParser#lista_id}.
	 * @param ctx the parse tree
	 */
	void enterLista_id(PascalParser.Lista_idContext ctx);
	/**
	 * Exit a parse tree produced by {@link PascalParser#lista_id}.
	 * @param ctx the parse tree
	 */
	void exitLista_id(PascalParser.Lista_idContext ctx);
	/**
	 * Enter a parse tree produced by {@link PascalParser#var_read}.
	 * @param ctx the parse tree
	 */
	void enterVar_read(PascalParser.Var_readContext ctx);
	/**
	 * Exit a parse tree produced by {@link PascalParser#var_read}.
	 * @param ctx the parse tree
	 */
	void exitVar_read(PascalParser.Var_readContext ctx);
	/**
	 * Enter a parse tree produced by {@link PascalParser#exp_write}.
	 * @param ctx the parse tree
	 */
	void enterExp_write(PascalParser.Exp_writeContext ctx);
	/**
	 * Exit a parse tree produced by {@link PascalParser#exp_write}.
	 * @param ctx the parse tree
	 */
	void exitExp_write(PascalParser.Exp_writeContext ctx);
	/**
	 * Enter a parse tree produced by {@link PascalParser#sentenca}.
	 * @param ctx the parse tree
	 */
	void enterSentenca(PascalParser.SentencaContext ctx);
	/**
	 * Exit a parse tree produced by {@link PascalParser#sentenca}.
	 * @param ctx the parse tree
	 */
	void exitSentenca(PascalParser.SentencaContext ctx);
	/**
	 * Enter a parse tree produced by {@link PascalParser#comando}.
	 * @param ctx the parse tree
	 */
	void enterComando(PascalParser.ComandoContext ctx);
	/**
	 * Exit a parse tree produced by {@link PascalParser#comando}.
	 * @param ctx the parse tree
	 */
	void exitComando(PascalParser.ComandoContext ctx);
	/**
	 * Enter a parse tree produced by {@link PascalParser#argumentos}.
	 * @param ctx the parse tree
	 */
	void enterArgumentos(PascalParser.ArgumentosContext ctx);
	/**
	 * Exit a parse tree produced by {@link PascalParser#argumentos}.
	 * @param ctx the parse tree
	 */
	void exitArgumentos(PascalParser.ArgumentosContext ctx);
	/**
	 * Enter a parse tree produced by {@link PascalParser#pfalsa}.
	 * @param ctx the parse tree
	 */
	void enterPfalsa(PascalParser.PfalsaContext ctx);
	/**
	 * Exit a parse tree produced by {@link PascalParser#pfalsa}.
	 * @param ctx the parse tree
	 */
	void exitPfalsa(PascalParser.PfalsaContext ctx);
	/**
	 * Enter a parse tree produced by {@link PascalParser#expressao_logica}.
	 * @param ctx the parse tree
	 */
	void enterExpressao_logica(PascalParser.Expressao_logicaContext ctx);
	/**
	 * Exit a parse tree produced by {@link PascalParser#expressao_logica}.
	 * @param ctx the parse tree
	 */
	void exitExpressao_logica(PascalParser.Expressao_logicaContext ctx);
	/**
	 * Enter a parse tree produced by {@link PascalParser#termo_logico}.
	 * @param ctx the parse tree
	 */
	void enterTermo_logico(PascalParser.Termo_logicoContext ctx);
	/**
	 * Exit a parse tree produced by {@link PascalParser#termo_logico}.
	 * @param ctx the parse tree
	 */
	void exitTermo_logico(PascalParser.Termo_logicoContext ctx);
	/**
	 * Enter a parse tree produced by {@link PascalParser#fator_logico}.
	 * @param ctx the parse tree
	 */
	void enterFator_logico(PascalParser.Fator_logicoContext ctx);
	/**
	 * Exit a parse tree produced by {@link PascalParser#fator_logico}.
	 * @param ctx the parse tree
	 */
	void exitFator_logico(PascalParser.Fator_logicoContext ctx);
	/**
	 * Enter a parse tree produced by {@link PascalParser#relacional}.
	 * @param ctx the parse tree
	 */
	void enterRelacional(PascalParser.RelacionalContext ctx);
	/**
	 * Exit a parse tree produced by {@link PascalParser#relacional}.
	 * @param ctx the parse tree
	 */
	void exitRelacional(PascalParser.RelacionalContext ctx);
	/**
	 * Enter a parse tree produced by {@link PascalParser#expressao}.
	 * @param ctx the parse tree
	 */
	void enterExpressao(PascalParser.ExpressaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link PascalParser#expressao}.
	 * @param ctx the parse tree
	 */
	void exitExpressao(PascalParser.ExpressaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link PascalParser#termo}.
	 * @param ctx the parse tree
	 */
	void enterTermo(PascalParser.TermoContext ctx);
	/**
	 * Exit a parse tree produced by {@link PascalParser#termo}.
	 * @param ctx the parse tree
	 */
	void exitTermo(PascalParser.TermoContext ctx);
	/**
	 * Enter a parse tree produced by {@link PascalParser#fator}.
	 * @param ctx the parse tree
	 */
	void enterFator(PascalParser.FatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link PascalParser#fator}.
	 * @param ctx the parse tree
	 */
	void exitFator(PascalParser.FatorContext ctx);
}