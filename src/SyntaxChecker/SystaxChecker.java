package SyntaxChecker;

import Antlr4.PascalLexer;
import Antlr4.PascalParser;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.CommonTokenStream;

import java.util.List;
import org.antlr.v4.runtime.ANTLRErrorListener;

import static org.antlr.v4.runtime.CharStreams.fromString;

public class SystaxChecker
{
    /*
    public static List<SyntaxError> getSyntaxErrors(String sourceCode)
    {
        CodePointCharStream inputStream = fromString(sourceCode);
        PascalLexer lexer = new PascalLexer(inputStream);
        CommonTokenStream commonTokenStream = new CommonTokenStream(lexer);
        PascalParser parser = new PascalParser(commonTokenStream);
        SyntaxErrorListener listener = new SyntaxErrorListener();
        //parser.addErrorListener(ANTLRErrorListener(listener));
        parser.programa();

        //return listener.getSyntaxErrors();
        return new List<SyntaxError>();
    }*/
}
