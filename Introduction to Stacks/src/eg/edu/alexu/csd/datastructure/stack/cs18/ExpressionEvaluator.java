package eg.edu.alexu.csd.datastructure.stack.cs18;

public class ExpressionEvaluator implements IExpressionEvaluator {

    @Override
    public String infixToPostfix(String expression) {
        StringBuffer string = new StringBuffer(expression);
        for (int i=0; i<string.length(); i++) {
            if (string.charAt(i) == '-') {
                int j = i-1;
                while (j>=0 && string.charAt(j)==' ') {j--;}
                if ((j>=0 && !Character.isDigit(string.charAt(j)) && !isSymbol(string.charAt(j)) && string.charAt(j)!=')') || (i==0)) {
                    string.insert(i, "( 0 ");
                    i += 5;
                    string.insert(i, ' ');
                    i++;
                    while ((i<string.length()) && (Character.isDigit(string.charAt(i)) || isSymbol(string.charAt(i)))) {i++;}
                    string.insert(i, " ) ");
                    i += 3;
                }
            }
            if (i<string.length() && (string.charAt(i)==')' || isSymbol(string.charAt(i)))) {
                int j = i+1;
                while (j<string.length() && string.charAt(j)==' ') {j++;}
                if (j<string.length() && (string.charAt(j)=='(' || isSymbol(string.charAt(j)))) {
                    string.insert(j,'*');
                }
            }
        }
        String postFix = "";
        Stack ops = new Stack();
        Stack parenthesis = new Stack();
        for (int i=0; i<string.length(); i++) {
            if (Character.isDigit(string.charAt(i)) || isSymbol(string.charAt(i))) {
                postFix += string.charAt(i);
            }else if (string.charAt(i) == '(') {
                parenthesis.push('(');
                int temp = ++i;
                while (i<string.length() && !parenthesis.isEmpty()) {
                    if (string.charAt(i) == '(') {
                        parenthesis.push('(');
                    }else if (string.charAt(i) == ')') {
                        parenthesis.pop();
                    }
                    i++;
                }
                if (parenthesis.isEmpty()) {
                    postFix += infixToPostfix(string.substring(temp, --i));
                }else {
                    throw new RuntimeException("You must close the parenthesis.");
                }
            }else if (string.charAt(i)=='/' || string.charAt(i)=='*' || string.charAt(i)=='-' || string.charAt(i)=='+') {
                postFix += ' ';
                while (!ops.isEmpty() && precedence(string.charAt(i), (char) ops.peek())) {
                    postFix += ops.pop();
                    postFix += ' ';
                }
                ops.push(string.charAt(i));
            }else if(string.charAt(i) != ' '){
                throw new RuntimeException("You entered some invalid terms.");
            }
        }
        while (!ops.isEmpty()) {
            postFix += ' ';
            postFix += ops.pop();
        }
        return postFix;
    }

    @Override
    public int evaluate(String expression) {
        Stack values = new Stack();
        float num;
        for (int i=0; i<expression.length(); i++) {
            if (Character.isDigit(expression.charAt(i))) {
                num = expression.charAt(i)-'0';
                while (Character.isDigit(expression.charAt(i)) && Character.isDigit(expression.charAt(i+1))) {
                    num *= 10;
                    i++;
                    num += expression.charAt(i)-'0';
                }
                values.push(num);
            }else if (expression.charAt(i)=='/' || expression.charAt(i)=='*' || expression.charAt(i)=='-' || expression.charAt(i)=='+') {
                float op2 = (float)values.pop();
                float op1 = (float)values.pop();
                values.push(applyOp(expression.charAt(i), op1, op2));
            }else if (expression.charAt(i) != ' ') {
                throw new RuntimeException("Please enter digits and operators to evaluate.");
            }
        }
        if (values.size() != 1) {
            throw new RuntimeException("Error!\nCannot evaluate this postfix.");
        }
        return (int)((float)values.pop());
    }

    /**
     * Tests which operator should operate first
     *
     * @param op1
     * first operator
     * @param op2
     * second operator
     * @return true if operator has precedence
     */
    private boolean precedence (char op1, char op2) {
        return (op1 != '*' && op1 != '/') || (op2 != '+' && op2 != '-');
    }

    /**
     * Apply the operation
     *
     * @param op
     * operator
     * @param op1
     * first operand
     * @param op2
     * second operand
     * @return result of the operation
     */
    private float applyOp (char op, float op1, float op2) {
        switch (op) {
            case '+':
                return op1 + op2;
            case '-':
                return op1 - op2;
            case '*':
                return op1 * op2;
            case '/':
                if (op2 == 0) {
                    throw new UnsupportedOperationException("Cannot divide by zero");
                }
                return op1 / op2;
        }
        return 0;
    }

    /**
     * Tests if the element is a symbol
     *
     * @param b
     * element
     * @return true if element is symbol
     */
    public boolean isSymbol (char b) {
        return (b >= 'a' && b <= 'z') || (b >= 'A' && b <= 'Z');
    }

}