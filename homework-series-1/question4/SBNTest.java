package question4;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SBNTest {
    @Test
    public void testPositive() {
        test(1, "+1");
        test(2, "+10");
        test(3, "+11");
        test(35, "+100011");
    }

    @Test
    public void testNegative() {
        test(-1, "-1");
        test(-2, "-10");
        test(-3, "-11");
        test(-35, "-100011");
    }

    private void test(int expected, String expr) {
        testSBN(expected, expr);
//        testSBNAttr(expected, expr);
    }

    private void testSBN(int expected, String expr) {
        ParseTreeWalker walker = new ParseTreeWalker();
        SBNulator sbn = new SBNulator();

        ParseTree tree = parseCalc(expr);
        walker.walk(sbn, tree);
        assertEquals(expected, sbn.getValue(tree));
    }

    private ParseTree parseCalc(String text) {
        CharStream chars = new ANTLRInputStream(text);
        Lexer lexer = new SBNLexer(chars);
        TokenStream tokens = new CommonTokenStream(lexer);
        SBNParser parser = new SBNParser(tokens);
        return parser.number();
    }

//    private void testSBNAttr(int expected, String expr) {
//        assertEquals(expected, parseSBNAttr(expr).value);
//    }

//    private SBNAttrParser.NumberContext parseSBNAttr(String text) {
//        CharStream chars = new ANTLRInputStream(text);
//        Lexer lexer = new SBNAttrLexer(chars);
//        TokenStream tokens = new CommonTokenStream(lexer);
//        SBNAttrParser parser = new SBNAttrParser(tokens);
//        return parser.number();
//    }
}
