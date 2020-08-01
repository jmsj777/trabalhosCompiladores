/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ANTLR;
/*import antlr4.PascalAssembly;
import antlr4.PascalLexer;
import antlr4.PascalParser;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;*/
/**
 *
 * @author Rafhael
 */
public class pascal {
    public String processarCodigo(String code) throws Exception {
        // Cria um CharStream que lê a partir da entrada padrão
     /*   ANTLRInputStream input = new ANTLRInputStream(code);
        // Cria um lexer para processar a entrada
        PascalLexer lexer = new PascalLexer(input);
        // Cria um buffer de tokens gerados pelo lexer
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        // Cria um parser para processar os tokens
        PascalParser parser = new PascalParser(tokens);
        // Chame a regra principal, expr, para a qual gerará
        //uma árvore sintática
        ParseTree tree = parser.programa();

        // Cria um parse tree walker para gerenciar as chamadas
        // dos callbacks
        ParseTreeWalker walker = new ParseTreeWalker();
        // Caminha na árvore criada durante a análise sintática e
        // chama os callbacks
        walker.walk(new PascalAssembly(), tree);
        
        parser.getAcoes().posPrograma();*/
        return code;//TODO 01: SUBSTITUIR CODE PELO RETORNO QUE DEVEREMOS DAR
    }
}
