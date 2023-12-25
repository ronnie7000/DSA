package Searching2;

public class FoodPacketDistribution {
    public static int solve(int[] A, int B) {
        long ans = 0;
        int min = A[0];
        for (int pop : A) {
            min = min < pop ? min : pop;
        }
        long l = 1, r = min;
        while (l <= r) {
            long m = (l + r) / 2;
            int val = isPossible(A, m, B);
            if (val >= B) {
                ans = m;
                l = m + 1;
            } else
                r = m - 1;
        }
        return (int) ans;
    }

    public static int isPossible(int[] A, long m, int B) {
        long sum = 0;
        for (int people : A) {
            sum += (long) people / m;
        }
        return (int) sum;
    }

    public static void main(String[] arg) {
        int[] A = { 8, 7, 1, 5, 5, 10, 10, 1, 5, 3 };
        int B = 17;
        System.out.println(solve(A, B));
    }
}

// long time = 0;
// int painterCount = 1;
// for (int board : C) {
// time += board * (long) B;
// if (time > m) {
// time = board * (long) B;
// painterCount++;
// }
// }
// return painterCount;