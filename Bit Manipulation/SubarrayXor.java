public class SubarrayXor {

    public static int solve(int[] A) {
        long ans = 0;
        long size = A.length;
        for (int pos = 0; pos < 32; pos++) {
            long zeroCount = 0, streak = 0;
            for (int i = 0; i < size; i++) {
                if (((A[i] >> pos) & 1) == 0) {
                    streak++;
                } else {
                    zeroCount += (streak * (streak + 1)) / 2;
                    streak = 0;
                }
            }
            zeroCount += (streak * (streak + 1)) / 2;
            long totalCount = (size * (size + 1)) / 2;
            ans += (totalCount - zeroCount) * (1 << pos);
        }
        ans = ans % 1000000007;
        return (int)ans;
    }

    public static void main(String[] args) {
        int[] A = { 1, 0, 1 };
        System.out.println(solve(A));
    }
}
