package Primer;
public class BalanceArray {
    public static int solve(int[] A) {
        int count = 0;
        int size = A.length;
        int[] preOdd = new int[size];
        int[] preEven = new int[size];
        int[] sufOdd = new int[size];
        int[] sufEven = new int[size];

        for (int i = 1; i < size; i++) {
            if (i % 2 == 0) {
                preOdd[i] = preOdd[i - 1] + A[i - 1];
                preEven[i] = preEven[i - 1];
            } else {
                preOdd[i] = preOdd[i - 1];
                preEven[i] = preEven[i - 1] + A[i - 1];
            }
        }
        for (int i = size - 2; i >= 0; i--) {
            if (i % 2 == 0) {
                sufOdd[i] = sufOdd[i + 1] + A[i + 1];
                sufEven[i] = sufEven[i + 1];
            } else {
                sufOdd[i] = sufOdd[i + 1];
                sufEven[i] = sufEven[i + 1] + A[i + 1];
            }
        }
        for (int i = 0; i < size; i++) {
            if (preOdd[i] + sufEven[i] == sufOdd[i] + preEven[i])
                count++;
        }
        return count;
    }

    public static void main(String[] ars) {
        int[] A = { 5, 5, 2, 5, 8 };
        System.out.println(solve(A));
    }
}
