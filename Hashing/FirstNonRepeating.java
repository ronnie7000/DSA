package Hashing;

import java.util.HashMap;

public class FirstNonRepeating {
    public static int solve(int[] A) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            hm.put(A[i], hm.getOrDefault(A[i], 0) + 1);
        }
        for (int i = 0; i < A.length; i++) {
            if (hm.get(A[i]) == 1)
                return A[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] A = { 4, 3, 3, 2, 5, 6, 4, 5 };
        System.out.println(solve(A));
    }
}
