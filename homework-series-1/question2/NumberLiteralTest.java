package question2;

import org.junit.Before;
import org.junit.Test;

public class NumberLiteralTest {
    LexerTester tester;

    @Before
    public void setUp() {
        tester = new LexerTester(NumberLiteral.class);
    }

    @Test
    public void testIntBinary() {
        tester.yields("0b0000", NumberLiteral.INT_BINARY);
        tester.yields("0b1000", NumberLiteral.INT_BINARY);

        tester.wrong("0b2");
    }

    @Test
    public void testLongBinary() {
        tester.yields("0b0000L", NumberLiteral.LONG_BINARY);
        tester.yields("0b1000L", NumberLiteral.LONG_BINARY);

        tester.yields("0b0000l", NumberLiteral.LONG_BINARY);
        tester.yields("0b1000l", NumberLiteral.LONG_BINARY);

        tester.wrong("0b0000LL");
        tester.wrong("0b2L");
    }

    @Test
    public void testIntOctal() {
        tester.yields("00", NumberLiteral.INT_OCTAL);
        tester.yields("01234", NumberLiteral.INT_OCTAL);
        tester.yields("04231", NumberLiteral.INT_OCTAL);

        tester.wrong("08");
    }

    @Test
    public void testLongOctal() {
        tester.yields("00L", NumberLiteral.LONG_OCTAL);
        tester.yields("001234L", NumberLiteral.LONG_OCTAL);
        tester.yields("042310L", NumberLiteral.LONG_OCTAL);

        tester.yields("00l", NumberLiteral.LONG_OCTAL);
        tester.yields("001234l", NumberLiteral.LONG_OCTAL);
        tester.yields("042310l", NumberLiteral.LONG_OCTAL);

        tester.wrong("00LL");
        tester.wrong("08L");
    }

    @Test
    public void testIntDecimal() {
        tester.yields("0", NumberLiteral.INT_DECIMAL);
        tester.yields("1234", NumberLiteral.INT_DECIMAL);

        tester.wrong("a");
    }

    @Test
    public void testLongDecimal() {
        tester.yields("0L", NumberLiteral.LONG_DECIMAL);
        tester.yields("1234L", NumberLiteral.LONG_DECIMAL);

        tester.wrong("0LL");
        tester.wrong("aL");
    }

    @Test
    public void testIntHexadecimal() {
        tester.yields("0x0", NumberLiteral.INT_HEXADECIMAL);
        tester.yields("0x00", NumberLiteral.INT_HEXADECIMAL);
        tester.yields("0xabcd", NumberLiteral.INT_HEXADECIMAL);
        tester.yields("0xABCD", NumberLiteral.INT_HEXADECIMAL);

        tester.wrong("0xg");
    }

    @Test
    public void testLongHexadecimal() {
        tester.yields("0x0L", NumberLiteral.LONG_HEXADECIMAL);
        tester.yields("0x00L", NumberLiteral.LONG_HEXADECIMAL);
        tester.yields("0xabcdL", NumberLiteral.LONG_HEXADECIMAL);
        tester.yields("0xABCDL", NumberLiteral.LONG_HEXADECIMAL);

        tester.yields("0x0l", NumberLiteral.LONG_HEXADECIMAL);
        tester.yields("0x00l", NumberLiteral.LONG_HEXADECIMAL);
        tester.yields("0xabcdl", NumberLiteral.LONG_HEXADECIMAL);
        tester.yields("0xABCDl", NumberLiteral.LONG_HEXADECIMAL);

        tester.wrong("0x0LL");
        tester.wrong("0xGL");
        tester.wrong("0xgL");
    }
}
