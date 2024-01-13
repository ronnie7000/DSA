package Sorting;

public class MergeSortedArrays {
    public static int[] solve(int[] A, int[] B) {
        int n = A.length;
        int m = B.length;
        int[] res = new int[n + m];
        int l = 0, r = 0;
        int index = 0;
        while (index < res.length) {
            int a = l < A.length ? A[l] : Integer.MAX_VALUE;
            int b = r < B.length ? B[r] : Integer.MAX_VALUE;
            if (a < b) {
                res[index] = a;
                l++;
            } else {
                res[index] = b;
                r++;
            }
            index++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] A = { 4, 7, 9 };
        int[] B = { 2, 11, 19 };
        int[] res = solve(A, B);
        for (int i : res) {
            System.out.println(i);
        }
    }
}
