package Arrays;

public class MinAverageSubarray {

    public static int solve(int[] A, int B) {
        int l = 0, r = B - 1;
        float avg = 0f, minAvg = Float.MAX_VALUE;
        int ans = 0;
        while (r < A.length) {
            float sum = 0;
            for (int i = l; i <= r; i++) {
                sum += A[i];
            }
            avg = sum / B;
            if (avg < minAvg) {
                ans = l;
                minAvg = avg;
            }
            r++;
            l++;
        }
        return ans;
    }

    public static int solve2(int[] A, int B) {
        int ans = 0;
        int[] prefSum = new int[A.length];
        float avg = 0f, minAvg = Float.MAX_VALUE;
        prefSum[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            prefSum[i] = prefSum[i - 1] + A[i];
        }
        int l = 0, r = B - 1;
        while (r < A.length) {
            float sum = 0f;
            if (l == 0) {
                sum = prefSum[r];
            } else {
                sum = prefSum[r] - prefSum[l - 1];
            }
            avg = sum / B;
            if (avg < minAvg) {
                ans = l;
                minAvg = avg;
            }
            r++;
            l++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A = { 20, 3, 13, 5, 10, 14, 8, 5, 11, 9, 1, 11 };
        System.out.println(solve2(A, 9));
    }
}
