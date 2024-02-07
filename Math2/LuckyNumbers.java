package Math2;

import java.util.Arrays;

public class LuckyNumbers {
    public static int solve(int A) {
        int[] seive = new int[A + 1];
        Arrays.fill(seive, 1);
        seive[0] = 0;
        seive[1] = 0;
        for (int i = 2; i <= A; i++) {
            if (seive[i] == 1) {
                for (int j = 2 * i; j < seive.length; j += i) {
                    seive[j]++;
                }
            }
        }
        int count = 0;
        for (int i = 2; i <= A; i++) {
            if (seive[i] == 3) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(solve(50000));
    }
}
