package Searching1;

public class MaxPeak {

    public static int solve(int[] A) {
        int ans = 0;
        int l = 0, r = A.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (A[m] > A[m - 1] && A[m] > A[m + 1]) {
                ans = A[m];
                break;
            } else if (A[m] > A[m - 1]) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A = { 1, 3, 5, 10, 15, 12, 6 };
        System.out.println(solve(A));
    }
}
