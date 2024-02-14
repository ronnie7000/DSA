package Hashing;

import java.util.HashMap;
import java.util.HashSet;

public class SubarraySumK {

    // Check if a subraay exists with K sum
    public static String solve(int[] A, int K) {
        HashSet<Long> hs = new HashSet<>();
        long sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            if (sum == K || hs.contains(sum - K))
                return "True";
            hs.add(sum);
        }
        return "False";
    }

    // Get total count of subarrays with K sum
    public static int solve2(int[] A, int K) {
        int ans = 0;
        HashMap<Long, Integer> hm = new HashMap<>();
        hm.put((long) 0, 1);
        long sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            if (hm.containsKey(sum - K) || sum == K) {
                ans += hm.get(sum - K);
            }
            hm.put(sum, hm.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A = { 2, 3, 9, -4, 1, 5, 6, 2, 5 };
        System.out.println(solve(A, 11));
    }
}
