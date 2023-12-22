package Math1;

public class PickBothSides {
    public static int solve(int[] A, int B) {
        int maxSum = Integer.MIN_VALUE, sum = 0;
        int[] preSum = new int[A.length];
        preSum[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            preSum[i] = preSum[i - 1] + A[i];
        }
        int n = A.length - 1;
        int[] sufSum = new int[A.length];
        sufSum[n] = A[n];
        for (int i = n - 1; i >= 0; i--) {
            sufSum[i] = sufSum[i + 1] + A[i];
        }
        for (int i = 0; i <= B; i++) {
            if (i == 0) {
                sum = sufSum[n - B + 1];
            } else if (i == B) {
                sum = preSum[i-1];
            } else {
                sum = preSum[i-1] + sufSum[n - (B - i)+1];
            }
            if (maxSum < sum)
                maxSum = sum;
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] A = { 2, 3, -1, 4, 2, 1 };
        System.out.println(solve(A, 4));
    }
}
