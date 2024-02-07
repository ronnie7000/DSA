package Math2;

public class PascalTriangle {

    public static void solve(int N) {
        int[][] mat = new int[N + 1][N + 1];
        for (int n = 0; n <= N; n++) {
            for (int r = 0; r <= n; r++) {
                if (r == 0 || r == n) {
                    mat[n][r] = 1;
                } else {
                    mat[n][r] = mat[n - 1][r] + mat[n - 1][r - 1];
                }
            }
        }
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= N; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        solve(5);
    }
}
