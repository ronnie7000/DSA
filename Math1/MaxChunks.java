package Math1;

public class MaxChunks {
    public static int solve(int[] A) {
        int ans = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            max = A[i] > max ? A[i] : max;
            if (max == i)
                ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A = { 4, 3, 2, 1, 0 };

        int ans = solve(A);
        System.out.println(ans);
    }
}
