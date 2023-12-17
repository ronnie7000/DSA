package Math1;
import java.util.Arrays;

public class WaveArray {
    public static int[] solve(int[] A) {
        int n = A.length - 1;
        int ptr = 0;
        int[] ans = new int[A.length];
        Arrays.sort(A);
        while (ptr <= n) {
            if (ptr < n) {
                ans[ptr] = A[ptr + 1];
                ans[ptr + 1] = A[ptr];
            } else {
                ans[n] = A[n];
            }
            ptr += 2;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A = { 1, 2, 3, 4, 5, 6 };
        int[] ans = solve(A);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
    }
}