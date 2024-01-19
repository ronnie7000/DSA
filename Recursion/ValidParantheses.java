package Recursion;

public class ValidParantheses {
    public static void solve(int n, String str, int open, int close) {

        // Base Conditions to backtrack if not valid string is found
        if (open > n || close > open)
            return;

        // Base Condition for valid string then print and return
        if (str.length() == 2 * n) {
            System.out.println(str);
            return;
        }

        //Add open paranthesis
        String openStr = str + '(';
        solve(n, openStr, open + 1, close);

        //Add close paranthesis
        String closeStr = str + ')';
        solve(n, closeStr, open, close + 1);
    }

    public static void main(String[] args) {
        solve(2, "", 0, 0);
    }
}
