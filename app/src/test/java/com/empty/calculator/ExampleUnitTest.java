package com.empty.calculator;

import org.javia.arity.Symbols;
import org.javia.arity.SyntaxException;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }
    @Test
    public void testExpresion() throws SyntaxException {
        Symbols symbols = new Symbols();
        String expr;
        expr = "sin(9)";
        System.out.println(expr + " = " + symbols.eval(expr));
    }

}