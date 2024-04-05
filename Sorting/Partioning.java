package Sorting;

public class Partioning {

    public static int[] solve(int[] A) {
        int p = A[0];
        int l = 1, r = A.length - 1;

        while (l <= r) {
            if (A[l] < p)
                l++;
            else if (A[r] > p)
                r--;
            else {
                int temp = A[l];
                A[l] = A[r];
                A[r] = temp;
            }
        }

        int temp = A[r];
        A[r] = p;
        A[0] = temp;

        return A;
    }

    public static void main(String[] args) {
        int[] A = { 54, 26, 93, 17, 77, 31, 44, 55, 20 };
        int[] ans = solve(A);
        for (int val : ans)
            System.out.println(val + " ");
    }
}