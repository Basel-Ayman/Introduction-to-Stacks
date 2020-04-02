package eg.edu.alexu.csd.datastructure.stack.cs18;

import java.util.Scanner;

public class UIApplication {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        ExpressionEvaluator evaluator = new ExpressionEvaluator();
        char choice;
        boolean flag=true;
        String infix = "", postfix = "";
        while (flag) {
            System.out.println("Please choose an action\n" +
                    "----------------------\n" +
                    "1: Enter an expression\n" +
                    "2: Convert the expression to postfix\n" +
                    "3: Evaluate the expression\n" +
                    "4: Exit\n" +
                    "====================================================================");
            choice = scanner.next().charAt(0);
            switch (choice) {
                case '1':
                    System.out.println("Write your expression.");
                    scanner.nextLine();
                    infix = scanner.nextLine();
                    break;
                case '2':
                    postfix = evaluator.infixToPostfix(infix);
                    System.out.println("Your postfix expression is : " + postfix);
                    break;
                case '3':
                    boolean varFound = false;
                    int result;
                    try {
                        for (int i=0; i<infix.length(); i++) {
                            if (evaluator.isSymbol(infix.charAt(i))) {
                                varFound = true;
                                break;
                            }
                        }
                        if (varFound) {
                            System.out.println("Expression has variables.\nEnter digits in expression to evaluate.");
                        }else {
                            result = evaluator.evaluate(postfix);
                            System.out.println("The result is : " + result);
                        }
                        break;
                    }catch (Exception e) {
                        System.out.println("Enter an expression to evaluate.");
                        break;
                    }
                case '4':
                    flag = false;
                    break;
                default:
                    System.out.println("Please insert a valid number.");
            }
        }
    }
}
