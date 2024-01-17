package Recursion;

public class Palindrome {

    public static int solve(String A) {
        int len = A.length();
        int ans = 0;
        if (len <= 1)
            return 1;
        if (A.charAt(0) != A.charAt(len - 1)) {
            return 0;
        }
        if (A.charAt(0) == A.charAt(len - 1)) {
            String str = A.substring(1, len - 1);
            ans = solve(str);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(solve("aaba"));
    }
}
