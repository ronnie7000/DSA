package Searching1;
public class RotatedArraySearch {
    public static int solve(int[] A, int key) {
        int start = 0, end = A.length - 1, mid = 0;
        int n = A.length - 1;
        int pos = -1;
        while (start <= end) {
            mid = (start + end) / 2;
            if (A[mid] > A[n]) {
                start = mid + 1;
            } else if (A[mid] <= A[n]) {
                pos = mid;
                end = mid - 1;
            }
        }
        if (A[n] >= key) {
            start = pos;
            end = n;
        } else {
            start = 0;
            end = pos - 1;
        }
        while (start <= end) {
            mid = (start + end) / 2;
            if (A[mid] == key)
                return mid;
            else if (A[mid] < key)
                start = mid + 1;
            else
                end = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] A = { 4, 5, 6, 7, 0, 1, 2, 3 };
        System.out.println(solve(A, 7));
    }
}
