package Searching2;

public class AthMagicalNumber {

    public static long gcd(long x, long y) {
        if (x > y) {
            long temp = x;
            x = y;
            y = temp;
        }
        while (x > 0) {
            y = y % x;
            if (x > y) {
                long temp = x;
                x = y;
                y = temp;
            }
        }
        return y;
    }

    public static long getCount(long m, long b, long c) {
        long lcm = b * c / gcd(b, c);
        long val = m / b + m / c - m / lcm;
        return val;
    }

    public static int solve(int A, int B, int C) {
        long ans = -1;
        long a = A, b = B, c = C;
        int mod = 1000 * 1000 * 1000 + 7;
        long top = 0, end = a * Math.min(b, c);
        while (top <= end) {
            long mid = (top + end) / 2;
            long count = getCount(mid, b, c);
            if (count >= a) {
                ans = mid;
                end = mid - 1;
            } else
                top = mid + 1;
        }
        ans = ans % mod;
        return (int) ans;
    }

    public static void main(String[] args) {
        System.out.println(solve(1, 2, 3));
    }
}
