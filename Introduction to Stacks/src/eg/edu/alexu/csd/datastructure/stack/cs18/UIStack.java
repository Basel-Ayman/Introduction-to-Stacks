package eg.edu.alexu.csd.datastructure.stack.cs18;

import java.util.Scanner;

public class UIStack {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)){
            Stack stack = new Stack();
            char choice;
            boolean flag=true;
            while (flag) {
                    System.out.println("Please choose an action\n" +
                            "----------------------\n" +
                            "1: Push\n" +
                            "2: Pop\n" +
                            "3: Peek\n" +
                            "4: Get size\n" +
                            "5: Check if empty\n" +
                            "6: Exit\n" +
                            "====================================================================");
                    choice = scanner.next().charAt(0);
                    switch (choice) {
                        case '1':
                            System.out.println("Insert the element.");
                            String s;
                            scanner.nextLine();
                            s = scanner.nextLine();
                            stack.push(s);
                            break;
                        case '2':
                            if (stack.isEmpty()) {
                                System.out.println("Stack is empty.");
                            }else {
                                System.out.println(stack.pop());
                            }
                            break;
                        case '3':
                            if (stack.isEmpty()) {
                                System.out.println("Stack is empty.");
                            }else {
                                System.out.println(stack.peek());
                            }
                            break;
                        case '4':
                            int size = stack.size();
                            System.out.println("Size of the stack = " + size);
                            break;
                        case '5':
                            if (stack.isEmpty()) {
                                System.out.println("Yes, Stack is empty.");
                            }else {
                                System.out.println("No, Stack isn't empty.");
                            }
                            break;
                        case '6':
                            flag = false;
                            break;
                        default:
                            System.out.println("Please insert a valid number.");
                    }
            }
        }
    }
}
