public class FirstTwoMissingNumbers {
    public static int[] solve(int[] A) {
        int n = A.length;
        int xor = 0;
        for (int i = 1; i <= n + 2; i++) {
            xor ^= i;
        }
        for (int i = 0; i < n; i++) {
            xor ^= A[i];
        }
        int pos = 0;
        for (int i = 0; i < 32; i++) {
            if (((xor >> i) & 1) == 1) {
                pos = i;
                break;
            }
        }
        int even = 0, odd = 0;
        for (int i = 1; i <= n + 2; i++) {
            if (((i >> pos) & 1) == 1)
                odd ^= i;
            else
                even ^= i;
        }
        for (int i = 0; i < n; i++) {
            if (((A[i] >> pos) & 1) == 1)
                odd ^= A[i];
            else
                even ^= A[i];
        }
        int a = Math.min(even, odd);
        int b = Math.max(even, odd);
        return new int[] { a, b };
    }

    public static void main(String[] args) {
        int[] A = { 3, 2, 4 };
        int[] ans = solve(A);
        for (int i : ans) {
            System.out.println(i);
        }
    }
}
