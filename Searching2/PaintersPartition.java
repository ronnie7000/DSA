package Searching2;

public class PaintersPartition {
    public static int solve(int A, int B, int[] C) {
        if (A == 0 || B == 0)
            return 0;
        int max = C[0];
        long sum = C[0];
        for (int i = 1; i < C.length; i++) {
            max = max < C[i] ? C[i] : max;
            sum += C[i];
        }
        long ans = 0;
        long l = max * B, r = sum * B;
        while (l <= r) {
            long m = (l + r) / 2;
            int painterCount = isPossible(A, B, C, m);
            if (painterCount <= A) {
                ans = m;
                r = m - 1;
            } else
                l = m + 1;
        }
        ans = ans % 10000003;
        return (int) ans;
    }

    public static int isPossible(int A, int B, int[] C, long m) {
        long time = 0;
        int painterCount = 1;
        for (int board : C) {
            time += board * (long) B;
            if (time > m) {
                time = board * (long) B;
                painterCount++;
            }
        }
        return painterCount;
    }

    public static void main(String[] args) {
        int[] C = { 884, 228, 442, 889 };
        int B = 10, A = 4;
        System.out.println(solve(A, B, C));

    }
}
