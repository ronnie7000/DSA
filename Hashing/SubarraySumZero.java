package Hashing;

import java.util.HashMap;
import java.util.HashSet;

public class SubarraySumZero {

    // Check if a subarray with 0 sum exists
    public static String solve(int[] A) {
        HashSet<Long> hs = new HashSet<>();
        long sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            if (sum == 0 || A[i] == 0 || hs.contains(sum))
                return "True";
            hs.add(sum);
        }
        return "False";
    }

    // Get total count of subarrays with 0 sum
    public static int solve2(int[] A) {
        long ans = 0;
        long mod = 1000000007;
        HashMap<Long, Integer> hm = new HashMap<>();
        long sum = 0;
        hm.put((long) 0, 1);
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            if (hm.containsKey(sum) || sum == 0) {
                ans += hm.getOrDefault(sum, 1);
            }
            hm.put(sum, hm.getOrDefault(sum, 0) + 1);
        }
        ans %= mod;
        return (int) ans;
    }

    // Get longest subarray length with 0 sum
    public static int solve3(int[] A) {
        int ans = Integer.MIN_VALUE;
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
        return ans == Integer.MIN_VALUE ? 0 : ans;
    }

    public static void main(String[] args) {
        int[] A = { 1, -1, -2, 2 };
        System.out.println(solve2(A));
    }
}
