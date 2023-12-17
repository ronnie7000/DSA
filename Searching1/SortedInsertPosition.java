package Searching1;
public class SortedInsertPosition {
    public static int solve(int[] A, int key) {
        int ans = -1;
        int t = 0, e = A.length - 1, m = 0;
        while (t <= e) {
            m = (t + e) / 2;
            if (A[m] == key)
                return m;
            else if (A[m] > key)
                e = m - 1;
            else {
                ans = m;
                t = m + 1;
            }
        }
        return ans + 1;
    }

    public static void main(String[] args) {
        int[] A = { 1, 4, 9 };
        System.out.println(solve(A, 3));
    }

}
