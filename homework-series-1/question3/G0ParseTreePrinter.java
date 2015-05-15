package question3;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

public class G0ParseTreePrinter {
    public static void main(String[] args) {
        parse("a[i+1]+b.field");
        parse("((Type)x).i-10+y");
    }

    public static void parse(String text) {
        // Convert the input text to a character stream
        CharStream stream = new ANTLRInputStream(text);
        // Build a lexer on top of the character stream
        Lexer lexer = new G0Lexer(stream);
        // Extract a token stream from the lexer
        TokenStream tokens = new CommonTokenStream(lexer);
        // Build a parser instance on top of the token stream
        G0Parser parser = new G0Parser(tokens);
        // Get the parse tree by calling the start rule
        ParseTree tree = parser.e();
        // Print the (formatted) parse tree
        System.out.println(tree.toStringTree(parser));
    }
}
