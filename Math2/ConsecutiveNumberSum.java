package Math2;

public class ConsecutiveNumberSum {

    public static int solve(int A) {
        int count = 0;
        int limit = (int) Math.sqrt(2 * A);
        for (int k = 1; k <= limit; k++) {
            int term = A - (k * (k - 1)) / 2;
            if (term % k == 0)
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(solve(15));
    }
}