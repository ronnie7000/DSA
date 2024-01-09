package Arrays;

public class NextPermutation {
    public static int[] solve(int[] A) {
        int suffStartIndex = A.length - 1;
        for (int i = A.length - 2; i > -1; i--) {
            if (A[i] > A[suffStartIndex]) {
                suffStartIndex = i;
            } else
                break;
        }
        int pivotIndex = suffStartIndex - 1;
        if (suffStartIndex > 0) {
            int minLargeIndex = 0;
            for (int i = A.length - 1; i >= suffStartIndex; i--) {
                if (A[i] > A[pivotIndex]) {
                    minLargeIndex = i;
                    break;
                } else
                    continue;
            }
            int temp = A[pivotIndex];
            A[pivotIndex] = A[minLargeIndex];
            A[minLargeIndex] = temp;

        }
        int l = suffStartIndex, r = A.length - 1;
        while (l < r) {
            int temp = A[l];
            A[l] = A[r];
            A[r] = temp;
            l++;
            r--;
        }
        return A;
    }

    public static void main(String[] args) {
        int[] A = { 1, 5, 8, 4, 7, 6, 5, 3, 1 };
        // int[] A = { 1,2,3,6,5,4 };
        int[] ans = solve(A);
        for (int x : ans) {
            System.out.println(x);
        }
    }
}