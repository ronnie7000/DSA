package Hashing;

import java.util.HashMap;

public class LongestSubarrayZeroSum {

    public static int solve(int[] A) {
        int ans = 0;
        HashMap<Long, Integer> hm = new HashMap<>();
        long sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            if (hm.containsKey(sum)) {
                ans = Math.max(ans, i - hm.get(sum));
            } else if (sum == 0) {
                ans = Math.max(ans, i + 1);
            }
            hm.put(sum, hm.getOrDefault(sum, i));
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A = { 1, -2, 1, 2 };
        System.out.println(solve(A));
    }
}
