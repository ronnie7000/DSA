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
            int j = size - i - 1;
            if (i % 2 == 0) {
                preOdd[i] = preOdd[i - 1] + A[i - 1];
                preEven[i] = preEven[i - 1];
                sufEven[j] = sufEven[j + 1] + A[j + 1];
                sufOdd[j] = sufOdd[j + 1];
            } else {
                preOdd[i] = preOdd[i - 1];
                preEven[i] = preEven[i - 1] + A[i - 1];
                sufEven[j] = sufEven[j + 1];
                sufOdd[j] = sufOdd[j + 1] + A[j + 1];
            }
        }
        for (int i = 0; i < size; i++) {
            if (preOdd[i] + sufEven[i] == sufOdd[i] + preEven[i])
                count++;
        }
        return count;
    }

    public static void main(String[] ars) {
        int[] A = { 2, 1, 6, 4 };
        System.out.println(solve(A));
    }
}
