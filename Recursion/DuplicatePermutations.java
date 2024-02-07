package Recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DuplicatePermutations {

    private static ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();

    public static ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int val : A) {
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        ArrayList<Integer> perm = new ArrayList<Integer>();
        solve(0, perm, map, A);
        return ans;
    }

    public static void solve(int pos, ArrayList<Integer> perm, HashMap<Integer, Integer> map, ArrayList<Integer> A) {
        // Base Condition
        if (pos == A.size()) {
            ans.add(new ArrayList<Integer>(perm));
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() != 0) {
                entry.setValue(entry.getValue() - 1);
                perm.add(entry.getKey());
                solve(pos + 1, perm, map, A);
                entry.setValue(entry.getValue() + 1);
                perm.remove(perm.size() - 1);
            }
        }
    }

    public static void displayResults() {
        for (ArrayList<Integer> result : ans) {
            for (Integer val : result) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(1);
        list.add(2);
        permute(list);
        displayResults();
    }
}
