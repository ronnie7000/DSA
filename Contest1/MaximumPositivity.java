package Contest1;

public class MaximumPositivity {

    public static int[] solve(int[] A) {

        int maxLength = Integer.MIN_VALUE, maxStart = 0;
        int currLength = 0, currStart = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] > 0) {
                currLength++;
                if (currLength > maxLength) {
                    maxLength = currLength;
                    maxStart = currStart;
                }
            } else {
                currLength = 0;
                currStart = i + 1;
            }
        }

        int[] ans = new int[maxLength];
        for (int i = 0; i < maxLength; i++) {
            ans[i] = A[maxStart + i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A = { 108986143, -5026827, 5591744, 4058312, 2210051, 5680315, -5251946, -607433, 1633303, 2186575  };
        int[] ans = solve(A);
        for (int val : ans) {
            System.out.println(val);
        }
    }
}
