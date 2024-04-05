package Stacks;

import java.util.ArrayList;
import java.util.Stack;

public class EvaulateExpression {
    public static int evalRPN(ArrayList<String> A) {
        Stack<Integer> stack = new Stack<Integer>();

        for (String str : A) {
            if (isOperand(str)) {
                int op2 = stack.pop();
                int op1 = stack.pop();
                int val = getResults(op1, op2, str);
                stack.push(val);
            } else {
                stack.push(Integer.parseInt(str));
            }
        }
        return stack.peek();
    }

    public static boolean isOperand(String str) {
        if (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/"))
            return true;
        return false;
    }

    public static int getResults(int a, int b, String op) {
        if (op.equals("+"))
            return a + b;
        if (op.equals("-"))
            return a - b;
        if (op.equals("*"))
            return a * b;
        return a / b;
    }

    public static void main(String[] args) {
        ArrayList<String> inp = new ArrayList<>();
        inp.add("5");
        inp.add("1");
        inp.add("2");
        inp.add("+");
        inp.add("4");
        inp.add("*");
        inp.add("+");
        inp.add("3");
        inp.add("-");

        System.out.println(evalRPN(inp));
    }
}
