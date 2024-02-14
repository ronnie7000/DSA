package Hashing;

import java.util.HashMap;

public class DistinctElementinWindow {

    public static int[] solve(int[] A, int K) {
        int[] res = new int[A.length - K + 1];
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < K; i++) {
            hm.put(A[i], hm.getOrDefault(A[i], 0) + 1);
        }
        int idx = 1;
        res[0] = hm.size();
        for (int r = K; r < A.length; r++) {
            hm.put(A[r], hm.getOrDefault(A[r], 0) + 1);
            if (hm.get(A[r - K]) > 1) {
                hm.put(A[r - K], hm.get(A[r - K]) - 1);
            } else {
                hm.remove(A[r - K]);
            }
            res[idx] = hm.size();
            idx++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] A = { 1, 2, 1, 3, 4, 2, 3 };
        int[] res = solve(A, 4);
        for (int val : res) {
            System.out.println(val);
        }
    }
}
