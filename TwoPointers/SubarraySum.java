package TwoPointers;

public class SubarraySum {
    public static boolean solve(int[] A, int B) {
        long sum = A[0];
        int l = 0, r = 0;
        while (l < A.length && r < A.length) {
            if (sum == B) {
                return true;
            } else if (sum < B) {
                r++;
                if (r == A.length)
                    return false;
                sum += A[r];
            } else {
                sum -= A[l];
                l++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] A = { 1, 3, 15, 10, 20, 3, 23 };
        System.out.println(solve(A, 33));
    }
}