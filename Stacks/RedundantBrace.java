package Stacks;

import java.util.Stack;

public class RedundantBrace {
    public static int braces(String s) {
        Stack<Character> brackets = new Stack<Character>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '*'
                    || s.charAt(i) == '/') {
                brackets.push(s.charAt(i));
            } else if (s.charAt(i) == ')') {
                boolean isRedundant = true;
                while (brackets.peek() != '(') {
                    if (brackets.peek() == '+' || brackets.peek() == '-' || brackets.peek() == '*'
                            || brackets.peek() == '/') {
                        isRedundant = false;
                    }
                    brackets.pop();
                }
                brackets.pop();
                if (isRedundant == true) {
                    return 1;
                }
            }
        }
        return 0;
    }

    public static boolean isBrace(char str) {
        if (str == '(' || str == ')')
            return true;
        return false;
    }

    public static void main(String[] args) {
        String str = "(a+(a+b))";
        System.out.println(braces(str));
    }
}
