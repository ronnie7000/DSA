public class SingleNumber2 {
    public static int solve(int[] A) {
        int ans = 0;
        for (int i = 0; i < 31; i++) {
            int count = 0;
            for (int j = 0; j < A.length; j++) {
                int temp = A[j] >> i;
                if ((temp & 1) == 1) {
                    count++;
                }
            }
            if (count % 3 != 0) {
                ans += 1 << i;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A = { 0, 0, 0, 1 };
        System.out.println(solve(A));
    }
}
