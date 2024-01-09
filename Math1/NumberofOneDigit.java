package Math1;

public class NumberofOneDigit {

    public static int solve(int num) {
        int ans = 0;
        int i = 1;
        while (i <= num) {
            ans += ((num / (i * 10)) * i) + Math.min(Math.max((num % (i * 10)) - (i - 1), 0), i);
            i *= 10;
        }
        return ans;
    }

    public static void main(String[] args) {
        int A = 926; // 293
        System.out.println(solve(A));
    }
}