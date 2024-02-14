package Hashing;

import java.util.HashMap;

public class Frequency {

    public static int[] solve(int[] A, int[] Q) {
        int[] ans = new int[Q.length];
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            int val = hm.getOrDefault(A[i], 0);
            hm.put(A[i], val + 1);
        }
        for (int i = 0; i < ans.length; i++) {
            ans[i] = hm.getOrDefault(Q[i], 0);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A = { 1, 1, 5, 2, 3, 3 };
        int[] Q = { 1, 2, 3, 4, 5 };
        int[] res = solve(A, Q);
        for (int val : res) {
            System.out.print(val + " ");
        }
    }
}
