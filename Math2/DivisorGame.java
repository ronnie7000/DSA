package Math2;

public class DivisorGame {
    public static int solve(int a, int b, int c) {
        int count = 0;
        int min = Math.min(b, c);
        for (int i = min; i <= a; i += min) {
            if ((i % b == 0) && (i % c == 0))
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(solve(81991, 2549, 7));
    }
}
