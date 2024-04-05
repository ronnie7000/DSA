package TwoPointers;

public class MostWaterContainer {
    public static int solve(int[] A) {
        if (A.length == 1)
            return 0;
        long ans = Integer.MIN_VALUE;
        int l = 0, r = A.length - 1;
        while (l < r) {
            long water = (r - l) * Math.min(A[l], A[r]);
            ans = Math.max(ans, water);
            if (A[l] < A[r])
                l++;
            else
                r--;
        }
        return (int) ans;
    }

    public static void main(String[] args) {
        int[] A = { 4, 2, 10, 6, 8, 2, 6, 2 };
        System.out.println(solve(A));
    }
}
