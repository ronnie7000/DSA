package Primer;
public class XORingSubarray {
    public static int solve(int[] A) {
        int ans = 0;
        int size = A.length;
        for (int i = 0; i < size; i++) {
            int count = (i + 1) * (size - i);
            if (count % 2 != 0)
                ans = ans ^ A[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A = { 3, 4, 5 };
        System.out.println(solve(A));
    }
}
