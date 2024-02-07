package Recursion;

import java.util.ArrayList;
import java.util.Collections;

public class Subsets {

    private static ArrayList<ArrayList<Integer>> subsets = new ArrayList<ArrayList<Integer>>();

    // No duplicates in input list
    public static ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> A) {
        solve(0, new ArrayList<Integer>(), A);
        // Sort individual subset
        for (ArrayList<Integer> arr : subsets) {
            Collections.sort(arr);
        }
        // Sort all subsets lexicographically
        subsets.sort((a, b) -> {
            for (int i = 0; i < Math.min(a.size(), b.size()); i++) {
                int cmp = a.get(i).compareTo(b.get(i));
                if (cmp != 0) {
                    return cmp;
                }
            }
            return Integer.compare(a.size(), b.size());
        });
        return subsets;
    }

    public static void solve(int index, ArrayList<Integer> subset, ArrayList<Integer> list) {
        if (index == list.size()) {
            subsets.add(new ArrayList<Integer>(subset));
            return;
        }
        solve(index + 1, subset, list);
        subset.add(list.get(index));
        solve(index + 1, subset, list);
        subset.remove(subset.size() - 1);
    }

    public static void displayResults() {
        for (ArrayList<Integer> result : subsets) {
            for (Integer val : result) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> noDuplicates = new ArrayList<>();
        noDuplicates.add(1);
        noDuplicates.add(2);
        noDuplicates.add(3);
        getSubsets(noDuplicates);
        displayResults();
    }
}
