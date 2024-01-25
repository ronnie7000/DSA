package Math2;

public class SumPair {

    public static int solve(int[] A, int m) {
        int ans = 0;
        int[] freq = new int[m];
        for (int i = 0; i < A.length; i++) {
            int val = A[i] % m;
            if (val == 0) {
                ans += freq[0];
            } else {
                ans += freq[m - val];
            }
            freq[val]++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A = { 2, 3, 4, 8, 6, 15, 5, 12, 17, 7, 18 };
        System.out.println(solve(A, 6));
    }
}
