package Math2;
public class DeleteOne {

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

    public static int solve(int[] A) {
        int[] preGcd = new int[A.length + 1];
        int[] sufGcd = new int[A.length + 1];
        int size = A.length;

        for (int i = 0; i < size; i++) {
            preGcd[i + 1] = gcd(A[i], preGcd[i]);
        }

        for (int i = size - 1; i >= 0; i--) {
            sufGcd[i] = gcd(A[i], sufGcd[i + 1]);
        }

        int maxGcd = 1;

        for (int i = 0; i < size; i++) {
            int val = gcd(preGcd[i], sufGcd[i + 1]);
            if (val > maxGcd) {
                maxGcd = val;
            }
        }

        return maxGcd;
    }

    public static void main(String[] args) {
        int[] A = { 5, 15, 30 };
        System.out.println(solve(A));
    }
}
