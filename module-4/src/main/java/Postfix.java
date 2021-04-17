import java.util.Scanner;
import java.util.Stack;

public class Postfix {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] items = in.nextLine().split(" ");
        Stack<Integer> stack = new Stack<>();
        for (String item : items) {
            switch (item) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    int right = stack.pop();
                    int left = stack.pop();
                    stack.push(left - right);
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                default:
                    stack.push(Integer.parseInt(item));
            }
        }

        System.out.println(stack.pop());
    }
}
