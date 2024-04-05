package TwoPointers;

public class SumPair {
    public static boolean solve(int[] A, int B) {
        int l = 0, r = A.length - 1;
        while (l < r) {
            int sum = A[l] + A[r];
            if (sum == B)
                return true;
            else if (sum < B)
                l++;
            else
                r--;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] A = { -3, 0, 1, 3, 6, 8, 11, 14, 18 };
        System.out.println(solve(A, 12));
    }
}