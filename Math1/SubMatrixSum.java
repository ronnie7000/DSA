package Math1;
public class SubMatrixSum {

    public static int[] solve(int[][] A, int[] B, int[] C, int[] D, int[] E) {

        int[] ans = new int[B.length];
        int queryLength = B.length;
        int n = A.length;
        int m = A[0].length;
        long[][] sumMatrix = new long[n + 1][m + 1];
        long mod = (long) Math.pow(10, 9) + 7;

        for (int i = 0; i <= n; i++) {
            sumMatrix[i][0] = 0;
        }
        for (int i = 1; i <= m; i++) {
            sumMatrix[0][i] = 0;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sumMatrix[i + 1][j + 1] = A[i][j] + sumMatrix[i][j + 1] + sumMatrix[i + 1][j] - sumMatrix[i][j];
            }
        }

        for (int i = 0; i < queryLength; i++) {
            int r1 = B[i], c1 = C[i], r2 = D[i], c2 = E[i];
            long val = sumMatrix[r2][c2] - sumMatrix[r1 - 1][c2] - sumMatrix[r2][c1 - 1] + sumMatrix[r1 - 1][c1 - 1];

            while (val < 0) {
                val += mod;
            }
            ans[i] = (int) val;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] A = { { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };
        int[] B = { 1, 2 };
        int[] C = { 1, 2 };
        int[] D = { 2, 3 };
        int[] E = { 2, 3 };

        int[] ans = solve(A, B, C, D, E);

        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }

    }
}
