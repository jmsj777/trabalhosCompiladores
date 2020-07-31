
/** *
 * Exemplo de integração com o ANTLR
 ** */
// import das bibliotecas de runtime do ANTLR
import antlr4.PascalAssembly;
import antlr4.PascalLexer;
import antlr4.PascalParser;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class TestPascal {

    public static void main(String[] args) throws Exception {
        // Cria um CharStream que lê a partir da entrada padrão
        ANTLRInputStream input = new ANTLRInputStream("program somar;\n" +
                                                        "var\n" +
                                                        "	n1, n2, soma, subtracao, multiplicacao, divisao:integer;\n" +
                                                        "begin\n" +
                                                        "	n1:=10;\n" +
                                                        "	n2:=2;\n" +
                                                        "	soma := n1+n2;\n" +
                                                        "	write(soma);\n" +
                                                        "	subtracao := n1-n2;\n" +
                                                        "	write(subtracao);\n" +
                                                        "	multiplicacao := n1*n2;\n" +
                                                        "	write(multiplicacao);\n" +
                                                        "	divisao := n1/n2;\n" +
                                                        "	write(divisao);\n" +
                                                        "end.");
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
        
        parser.getAcoes().posPrograma();
    }
}
