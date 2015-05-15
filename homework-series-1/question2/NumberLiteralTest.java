package question2;

import org.junit.Test;

public class NumberLiteralTest {

    LexerTester tester = new LexerTester(NumberLiteral.class);

    @Test
    public void testIntBinary() {
        tester.yields("0b0000", NumberLiteral.INT_BINARY);
        tester.yields("0b1000", NumberLiteral.INT_BINARY);
    }

    @Test
    public void testLongBinary() {
        tester.yields("0b0000L", NumberLiteral.LONG_BINARY);
        tester.yields("0b1000L", NumberLiteral.LONG_BINARY);
    }

    @Test
    public void testIntOctal() {
        tester.yields("00", NumberLiteral.INT_OCTAL);
        tester.yields("01234", NumberLiteral.INT_OCTAL);
        tester.yields("04231", NumberLiteral.INT_OCTAL);
    }

    @Test
    public void testLongOctal() {
        tester.yields("00L", NumberLiteral.LONG_OCTAL);
        tester.yields("001234L", NumberLiteral.LONG_OCTAL);
        tester.yields("042310L", NumberLiteral.LONG_OCTAL);
    }

    @Test
    public void testIntDecimal() {
        tester.yields("0", NumberLiteral.INT_DECIMAL);
        tester.yields("1234", NumberLiteral.INT_DECIMAL);
    }

    @Test
    public void testLongDecimal() {
        tester.yields("0L", NumberLiteral.LONG_DECIMAL);
        tester.yields("1234L", NumberLiteral.LONG_DECIMAL);
    }


    @Test
    public void testIntHexadecimal() {
        tester.yields("0x0", NumberLiteral.INT_HEXADECIMAL);
        tester.yields("0x00", NumberLiteral.INT_HEXADECIMAL);
        tester.yields("0xabcd", NumberLiteral.INT_HEXADECIMAL);
    }

    @Test
    public void testLongHexadecimal() {
        tester.yields("0x0L", NumberLiteral.LONG_HEXADECIMAL);
        tester.yields("0x00L", NumberLiteral.LONG_HEXADECIMAL);
        tester.yields("0xabcdL", NumberLiteral.LONG_HEXADECIMAL);
    }
}
