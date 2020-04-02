package eg.edu.alexu.csd.datastructure.stack.cs18;

import org.junit.Test;
import static org.junit.Assert.*;

class ExpressionEvaluatorTest {

    @Test
    public void infixToPostfixTest() {
        //Test_1(Digits)
        ExpressionEvaluator evaluator = new ExpressionEvaluator();
        String actual = evaluator.infixToPostfix("2 + 3 * 4");
        String expected = "2 3 4 * +";
        assertEquals(expected, actual);
        //Test_2(Symbols & Digits)
        String Actual = evaluator.infixToPostfix("a * b + 5");
        String Expected = "a b * 5 +";
        assertEquals(Expected, Actual);
        //Test_3(Parenthesis with digits)
        String actual1 = evaluator.infixToPostfix("(1 + 2) * 7");
        String expected1 = "1 2 + 7 *";
        assertEquals(expected1, actual1);
        //Test_4(Symbols_1)
        String Actual1 = evaluator.infixToPostfix("a * b / c");
        String Expected1 = "a b * c /";
        assertEquals(Expected1, Actual1);
        //Test_5(Parenthesis with symbols)
        String actual2 = evaluator.infixToPostfix("(a / (b - c + d)) * (e - a) * c");
        String expected2 = "a b c - d + / e a - * c *";
        assertEquals(expected2, actual2);
        //Test_6(Symbols_2)
        String Actual2 = evaluator.infixToPostfix("a / b - c + d * e - a * c");
        String Expected2 = "a b / c - d e * + a c * -";
        assertEquals(Expected2, Actual2);
        //Test_7(Negative with symbols_1)
        String actual3 = evaluator.infixToPostfix("-a / b - c + d * e - a * c");
        String expected3 = "0 a - b / c - d e * + a c * -";
        assertEquals(expected3, actual3);
        //Test_8(Negative with digits_1)
        String Actual3 = evaluator.infixToPostfix("-2 + 3 * 4");
        String Expected3 = "0 2 - 3 4 * +";
        assertEquals(Expected3, Actual3);
        //Test_9(Negative with symbols_2)
        String actual4 = evaluator.infixToPostfix("a * -b / -c");
        String expected4 = "a 0 b - * 0 c - /";
        assertEquals(expected4, actual4);
        //Test_10(Negative with digits_2)
        String Actual4 = evaluator.infixToPostfix("(1 + -2) * -7");
        String Expected4 = "1 0 2 - + 0 7 - *";
        assertEquals(Expected4, Actual4);
        //Test_11(Positive digit)
        String actual5 = evaluator.infixToPostfix("18");
        String expected5 = "18";
        assertEquals(expected5, actual5);
        //Test_12(Negative digit)
        String Actual5 = evaluator.infixToPostfix("-18");
        String Expected5 = "0 18 -";
        assertEquals(Expected5, Actual5);
        //Test_(Null)
        assertEquals("", evaluator.infixToPostfix(""));
    }

    @Test
    public void evaluateTest () {
        //Test_1
        ExpressionEvaluator evaluator = new ExpressionEvaluator();
        int actual = evaluator.evaluate(evaluator.infixToPostfix("2 + 3 * 4"));
        int expected = 14;
        assertEquals(expected, actual);
        //Test_2
        int actual1 = evaluator.evaluate(evaluator.infixToPostfix("(1 + 2) * 7"));
        int expected1 = 21;
        assertEquals(expected1, actual1);
        //Test_3
        int actual2 = evaluator.evaluate(evaluator.infixToPostfix("-2 + 3 * 4"));
        int expected2 = 10;
        assertEquals(expected2, actual2);
        //Test_4
        int actual3 = evaluator.evaluate(evaluator.infixToPostfix("(1 + -2) * -7"));
        int expected3 = 7;
        assertEquals(expected3, actual3);
    }

}