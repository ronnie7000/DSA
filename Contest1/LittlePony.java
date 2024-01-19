package Contest1;

public class LittlePony {

    public static int[] solve(int[] A) {
        int[] ans = new int[2];
        int n = A.length;
        int minMarks = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (A[i] < minMarks)
                minMarks = A[i];
        }
        int minMarksCount = 0;
        for (int i = 0; i < n; i++) {
            if (A[i] == minMarks)
                minMarksCount++;
        }

        int gcd = gcd(minMarksCount, n);
        ans[0] = minMarksCount / gcd;
        ans[1] = n / gcd;
        return ans;
    }

    public static int gcd(int A, int B) {
        if (A < B) {
            A = A + B;
            B = A - B;
            A = A - B;
        }
        while (B > 0) {
            A = A % B;
            A = A + B;
            B = A - B;
            A = A - B;
        }
        return A;
    }

    public static void main(String[] args) {
        int[] A = { 36, 75, 87, 60, 36, 91, 96 };
        int[] ans = solve(A);
        for (int i : ans) {
            System.out.println(i);
        }
    }
}