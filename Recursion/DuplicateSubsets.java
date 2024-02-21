package Recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DuplicateSubsets {
    private static ArrayList<ArrayList<Integer>> res = new ArrayList<>();

    public static ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> A) {
        if (A == null)
            return null;
        Collections.sort(A);
        rec(A, new ArrayList<>(), 0);
        Collections.sort(res, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> a, List<Integer> b) {
                int size = Math.min(a.size(), b.size());
                for (int i = 0; i < size; i++) {
                    int cmp = Integer.compare(a.get(i), b.get(i));
                    if (cmp != 0)
                        return cmp;
                }
                return Integer.compare(a.size(), b.size());
            }
        });
        return res;
    }

    public static void rec(ArrayList<Integer> A, ArrayList<Integer> ans, int index) {
        if (index >= A.size()) {
            res.add(new ArrayList<>(ans));
            return;
        }
        int curIndex = index + 1;
        while (curIndex < A.size() && A.get(curIndex) == A.get(index))
            curIndex++;
        for (int i = 0; i <= (curIndex - index); i++) {
            for (int j = 0; j < i; j++)
                ans.add(A.get(index));
            rec(A, ans, curIndex);
            for (int j = 0; j < i; j++)
                ans.remove(ans.size() - 1);
        }
    }

    public static void displayResults() {
        for (ArrayList<Integer> result : res) {
            for (Integer val : result) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(4);
        list.add(4);
        list.add(4);
        subsetsWithDup(list);
        displayResults();
    }
}
