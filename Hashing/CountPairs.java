package Hashing;

import java.util.HashMap;
import java.util.HashSet;

public class CountPairs {
    public static String solve(int[] A, int K) {
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            if (hs.contains(K - A[i])) {
                return "True";
            }
            hs.add(A[i]);
        }
        return "False";
    }

    public static int solve2(int[] A, int K) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            if (hm.containsKey(K - A[i])) {
                count += hm.get(K-A[i]);
            }
            hm.put(A[i], hm.getOrDefault(A[i], 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] A = { 2,5,2,5,8,5,2,8};
        System.out.println(solve2(A, 10));
    }
}
