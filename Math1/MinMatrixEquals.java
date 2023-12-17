package Math1;
import java.util.Arrays;

public class MinMatrixEquals {

    public static int solve(int[][] A, int B) {
        int ans = -1;
        int n = A.length;
        int m = A[0].length;
        int mod = (A[0][0] % B + B) % B;

        int[] modRes = new int[n * m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ((A[i][j] % B + B) % B != mod) {
                    return -1;
                }
                modRes[i * m + j] = A[i][j];
            }
        }

        Arrays.sort(modRes);
        int mid = (n * m) / 2;
        int sum = 0;

        for (int x : modRes) {
            sum += Math.abs(x - modRes[mid]);
        }

        ans = sum;

        if ((n * m) % 2 == 0) {
            int sum2 = 0;
            mid--;
            for (int y : modRes) {
                sum2 += Math.abs(y - modRes[mid]);
            }
            ans = Math.min(sum, sum2);
        }

        return ans / B;
    }

    public static void main(String[] args) {
    
        int[][] A = {
            {-10,2,8},
            {8,2,0},
            {0,2,8}
        };

        int ans = solve(A, 2);
        System.out.println(ans);
    }
}
