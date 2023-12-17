public class HammingDistance {
    public static int solve(int[] A) {
        int ans = 0;
        double mod = Math.pow(10, 9) + 7;

        for (int i = 0; i < 31; i++) {
            int count = 0;

            for (int j = 0; j < A.length; j++) {
                int temp = A[j] >> i;
                if ((temp & 1) == 0) {
                    count++;
                }
            }
            ans += (2 * count * (A.length - count));
        }
        return ans % (int) mod;
    }

    public static void main(String[] args) {
        int[] A = { 1, 3, 5 };
        System.out.println(solve(A));
    }

}
