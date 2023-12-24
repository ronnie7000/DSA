package Searching2;

public class SpecialInteger {

    public static int solve(int[] A, int B) {
        int n = A.length;
        int l = 1, r = n;
        int ans = 0;
        while (l <= r) {
            int m = (l + r) / 2;
            if (GetMaxSum(A, B, m)) {
                ans = m;
                l = m + 1;
            } else
                r = m - 1;
        }
        return ans;
    }

    public static boolean GetMaxSum(int[] A, int B, int m) {
        int r = m - 1;
        long maxSum = Long.MIN_VALUE, sum = 0;
        for (int i = 0; i < m; i++) {
            sum += A[i];
        }
        maxSum = sum;
        r++;
        while (r < A.length) {
            sum += A[r];
            sum -= A[r - m];
            maxSum = sum > maxSum ? sum : maxSum;
            r++;
        }
        if (maxSum <= B)
            return true;
        return false;
    }

    public static void main(String[] args) {
        int[] A = { 5, 17, 100, 11 };
        System.out.println(solve(A, 130));
    }
}
