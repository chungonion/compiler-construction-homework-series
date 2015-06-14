package question3;

import org.junit.Test;
import pp.iloc.Simulator;

import java.io.ByteArrayOutputStream;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class CalcCompilerTest {

    @Test
    public void testNakedExpr() {
        assertEquals(35, calc("35"));
        assertEquals(-35, calc("-35"));
        assertEquals(35, calc("34+1"));
        assertEquals(35, calc("36+-1"));
        assertEquals(35, calc("7*5"));
    }

    @Test
    public void testNestedExpr() {
        assertEquals(35, calc("(35)"));
        assertEquals(-35, calc("(-35)"));
        assertEquals(35, calc("(17*2)+1"));
        assertEquals(35, calc("(6*6)+-1"));
        assertEquals(35, calc("(3+4)*5"));
    }

    public int calc(String expr) {
        CalcCompiler compiler = new CalcCompiler();
        Simulator simulator = new Simulator(compiler.compile(expr));
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        simulator.setOut(output);
        simulator.run();

        Scanner scanner = new Scanner(output.toString());

        return Integer.parseInt(scanner.findInLine("-?[\\d]+"));
    }
}
