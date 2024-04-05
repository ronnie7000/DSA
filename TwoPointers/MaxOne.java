package TwoPointers;

public class MaxOne {

    public static int[] solve(int[] A, int B) {
        int p1 = 0;
        int size = A.length;
        int count = 0;
        int start = 0;
        int len = Integer.MIN_VALUE;
        for (int p2 = 0; p2 < size; p2++) {
            if (A[p2] == 0) {
                count++;
            }
            if (count > B) {
                if (A[p1] == 0) {
                    count--;
                }
                p1++;
            }
            if ((p2 - p1 + 1) > len) {
                len = p2 - p1 + 1;
                start = p1;
            }
        }
        int[] ans = new int[len];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = i + start;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A = { 1, 0, 0, 0, 1, 0, 1 };
        int[] ans = solve(A, 2);
        for (int val : ans) {
            System.out.print(val + " ");
        }
    }

}
