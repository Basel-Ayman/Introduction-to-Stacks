package eg.edu.alexu.csd.datastructure.stack.cs18;

import org.junit.Test;
import static org.junit.Assert.*;

class StackTest {

    @Test
    public void Test() {
        Stack stack = new Stack();
        //Pushing
        stack.push('1');
        stack.push('2');
        stack.push('3');
        stack.push('4');
        //Test_push , pop & size
        assertEquals(4, stack.size());
        assertEquals('4', stack.pop());
        assertEquals('3', stack.pop());
        assertEquals('2', stack.pop());
        assertEquals('1', stack.pop());
        //Changing top
        stack.push('1');
        stack.push('8');
        stack.push("2000");
        stack.pop();
        stack.push("Basel");
        //Test_peek & size
        assertEquals("Basel", stack.peek());
        assertEquals(3, stack.size());
        //Clearing
        stack.pop();
        stack.pop();
        stack.pop();
        //Test_empty
        assertTrue(stack.isEmpty());
    }

}