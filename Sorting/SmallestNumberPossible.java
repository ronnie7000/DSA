package Sorting;

import java.util.Arrays;

public class SmallestNumberPossible {
    public static int BruteForceSolve(int[] A) {
        Arrays.sort(A);
        int pos = 1;
        int ans = 0;
        for (int i = A.length - 1; i >= 0; i--) {
            ans += pos * A[i];
            pos *= 10;
        }
        return ans;
    }

    // Count Sort
    public static int[] OptimizedSolve(int[] A) {
        int size = A.length;
        int[] ans = new int[size];
        int[] freq = new int[10];
        Arrays.fill(freq, 0);
        for (int i = 0; i < size; i++) {
            freq[A[i]]++;
        }
        int idx = 0;
        for (int i = 0; i < 10; i++) {
            if (freq[i] != 0) {
                int count = freq[i];
                while (count > 0) {
                    ans[idx] = i;
                    idx++;
                    count--;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A = { 6, 3, 4, 2, 7, 2, 1, 0, 0 };
        int res = BruteForceSolve(A);
        System.out.println(res);
        int[] ans = OptimizedSolve(A);
        for (int val : ans) {
            System.out.print(val + " ");
        }
    }
}
