package Arrays;
public class MaxPosSubarray {
    public static int[] solve(int[] A) {
        long currSum = 0;
        int currLength = 0;
        int currStart = 0;
        long maxSum = -1;
        int maxLength = 0;
        int maxStart = 0;

        for (int i = 0; i < A.length; i++) {
            if (A[i] < 0) {
                currSum = 0;
                currLength = 0;
                currStart = i + 1;
            } else {
                currSum += A[i];
                currLength++;

                if (currSum < maxSum) {
                    continue;
                }
                if (currSum == maxSum && currLength < maxLength) {
                    continue;
                }
                maxLength = currLength;
                maxSum = currSum;
                maxStart = currStart;
            }
        }

        int[] ans = new int[maxLength];

        for (int i = 0; i < maxLength; i++) {
            ans[i] = A[maxStart + i];
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] A = { 0, 0, -1, 0 };
        int[] answer = solve(A);

        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }

    }
}
