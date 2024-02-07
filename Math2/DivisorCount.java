package Math2;
public class DivisorCount {

    public static int[] solve(int[] A) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            if (max < A[i]) {
                max = A[i];
            }
        }
        int[] S = new int[max + 1];
        for (int p = 1; p < S.length; p++) {
            S[p]++;
            for (int j = 2 * p; j < S.length; j += p) {
                S[j]++;
            }
        }
        int[] ans = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            ans[i] = S[A[i]];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A = { 2, 3, 4, 5, 100 };
        int[] ans = solve(A);

        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
    }
}
