public class HammingDistance {
    public static int solve(int[] A) {
        long ans = 0;
        int mod = (1000*1000*1000) + 7;
        for (int i = 0; i < 31; i++) {
            long count = 0;
            for (int j = 0; j < A.length; j++) {
                int temp = A[j] >> i;
                if ((temp & 1) == 0) {
                    count++;
                }
            }
            ans += (2 * count * (A.length - count));
        }
        ans=ans%mod;
        return (int)ans;
    }

    public static void main(String[] args) {
        int[] A = { 1, 3, 5 };
        System.out.println(solve(A));
    }

}
