package Arrays;

public class MaxAbsoluteDifference {
    public static int solve(int[] A) {
        int maxFirst = Integer.MIN_VALUE;
        int maxSecond = Integer.MIN_VALUE;
        int minFirst = Integer.MAX_VALUE;
        int minSecond = Integer.MAX_VALUE;
        for (int i = 0; i < A.length; i++) {
            if ((A[i] + i) > maxFirst) {
                maxFirst = A[i] + i;
            }
            if ((A[i] + i) < minFirst) {
                minFirst = A[i] + i;
            }
            if ((A[i] - i) > maxSecond) {
                maxSecond = A[i] - i;
            }
            if ((A[i] - i) < minSecond) {
                minSecond = A[i] - i;
            }
        }
        int first = maxFirst - minFirst;
        int second = maxSecond - minSecond;
        if (first > second) {
            return first;
        } else
            return second;
    }

    public static void main(String[]args){
        int[]A ={1,3,-1};
        System.err.println(solve(A));
    }
}
