package Hashing;

import java.util.HashSet;

public class CountDistinctElements {

    public static int solve(int[] A) {
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            hs.add(A[i]);
        }
        return hs.size();
    }

    public static void main(String[] args) {
        int[] A = { 3, 5, 6, 5, 4 };
        System.out.println(solve(A));
    }
}
