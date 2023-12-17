package Primer;
public class StringPrefix {
    public static int[] solve(String[] A, String B) {
        int preSize = B.length();
        int a = -1, b = -1;
        boolean foundOne = false;

        for (int i = 0; i < A.length; i++) {
            if (A[i].length() < preSize) {
                continue;
            } else {
                if (!foundOne && A[i].startsWith(B)) {
                    foundOne = true;
                    a = i;
                }
                if (A[i].startsWith(B)) {
                    b = i;
                }
            }
        }
        return new int[] { a, b };
    }

    public static void main(String[] args) {
        String[] A = { "a", "b"};
        int[] ans = solve(A, "c");
        System.out.println(ans[0] + " " + ans[1]);
    }
}
