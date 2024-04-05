package TwoPointers;

public class PairDifference {
    public static int solve(int[] A, int B) {
        long ans = 0;
        int l = 0, r = 1;
        while (l < A.length && r < A.length) {
            long diff = A[r] - A[l];
            if (diff == B) {
                ans++;
                l++;
                r++;
            } else if (diff > B) {
                l++;
            } else {
                r++;
            }
        }
        return (int) ans;
    }

    public static void main(String[] args) {
        int[] A = { -5, -2, 1, 8, 10, 12, 15 };
        System.out.println(solve(A, 11));
    }
}
