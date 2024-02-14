package Hashing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class CommonElements {

    public static int[] solve(int[] A, int[] B) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            freq.put(A[i], freq.getOrDefault(A[i], 0) + 1);
        }
        ArrayList<Integer> res = new ArrayList<>();
        for (int val : B) {
            if (freq.containsKey(val)) {
                res.add(val);
                if (freq.get(val) == 1)
                    freq.remove(val);
                else
                    freq.put(val, freq.getOrDefault(val, 0) - 1);
            }
        }
        Collections.sort(res);
        int[] ans = new int[res.size()];
        int index = 0;
        for (int val : res) {
            ans[index] = val;
            index++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A = { 1, 2, 2, 1 };
        int[] B = { 2, 3, 1, 2 };
        int[] res = solve(A, B);
        for (int val : res) {
            System.out.print(val + " ");
        }
    }
}
