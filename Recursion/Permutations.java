package Recursion;

import java.util.ArrayList;

public class Permutations {

    private static ArrayList<Integer> list = new ArrayList<Integer>();
    private static ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();

    public static void solve(int pos, ArrayList<Integer> res, Boolean[] used) {
        // Base Conition
        if (pos == list.size()) {
            ArrayList<Integer> copyRes = new ArrayList<Integer>();
            for (int val : res) {
                copyRes.add(val);
            }
            results.add(copyRes);
        }
        for (int i = 0; i < used.length; i++) {
            if (used[i] == false) {
                used[i] = true;
                res.add(list.get(i));
                solve(pos + 1, res, used);
                res.remove(res.size() - 1);
                used[i] = false;
            }
        }
    }

    public static void displayResults() {
        for (ArrayList<Integer> result : results) {
            for (Integer val : result) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        list.add(1);
        // list.add(2);

        Boolean[] used = new Boolean[list.size()];
        for (int i = 0; i < used.length; i++) {
            used[i] = false;
        }
        solve(0, new ArrayList<Integer>(), used);
        displayResults();
    }
}
