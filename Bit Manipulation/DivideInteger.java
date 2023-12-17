public class DivideInteger {
    public static int solve(int a, int b) {
        long A = (int) a;
        long B = (int) b;
        boolean sign = false;
        if (A < 0)
            sign = !sign;
        if (B < 0)
            sign = !sign;
        A = Math.abs(A);
        B = Math.abs(B);
        long ans = 0, t = 0;
        for (int i = 31; i >= 0; i--) {
            if (t + (B << i) <= A) {
                t += B << i;
                ans |= (long) 1 << i;
            }
        }
        if (sign)
            ans = -1 * ans;
        if (ans > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        return (int) ans;
    }

    public static void main(String[] args) {
        System.out.println(solve(-2147483648, 1));
    }
}
