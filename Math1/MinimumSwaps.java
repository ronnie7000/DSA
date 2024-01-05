package Math1;

public class MinimumSwaps {

    public static int countElements(int[] A, int start, int end, int key) {
        int count = 0;
        for (int i = start; i <= end; i++) {
            if (A[i] <= key)
                count++;
        }
        return count;
    }

    public static int solve(int[] A, int B) {
        int totCount = countElements(A, 0, A.length - 1, B);
        int r = totCount - 1;
        int minCount = totCount - countElements(A, 0, r, B);
        int count = minCount;
        r++;
        while (r < A.length) {
            if (A[r] > B)
                count++;
            if (A[r - totCount] > B)
                count--;
            if (count < minCount)
                minCount = count;
            r++;
        }
        return minCount;
    }

    public static void main(String[] args) {
        int[] A = { 31, 98, 58, 86, 36, 31, 3, 22, 4, 17, 51, 33, 56, 7, 91, 17, 59, 66, 54, 67, 55, 41, 58, 24, 100, 1,
                    98, 68, 21, 33, 27, 67, 20, 66, 20, 100, 36, 89, 20, 15, 13, 26, 11, 29, 99, 36, 39, 49, 74, 77, 54, 66,
                    30, 21, 14, 18, 83, 72, 10, 22, 53, 83, 60, 9, 68, 56, 9, 21, 77, 44, 45, 61, 97, 82, 35, 16, 38, 95,
                    55, 11, 46, 77, 25, 3, 44 };
        System.out.println(solve(A, 18));
    }
}
