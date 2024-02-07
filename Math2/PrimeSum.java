package Math2;

import java.util.Arrays;

public class PrimeSum {
    public static int[] solve(int A) {
        int[] ans = new int[2];
        int[] seive = new int[A + 1];
        Arrays.fill(seive, 1);
        seive[0] = 0;
        seive[1] = 0;
        for (int i = 2; i*i <= A; i++) {
            if (seive[i] == 1) {
                for (int j = i * i; j < seive.length; j += i) {
                    seive[j]++;
                }
            }
        }
        for (int i = 2; i < seive.length; i++) {
            if (seive[i] == 1 && seive[A - i] == 1) {
                ans[0] = i;
                ans[1] = A - i;
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] ans = solve(1048574);
        for (int x : ans) {
            System.out.println(x);
        }
    }
}
