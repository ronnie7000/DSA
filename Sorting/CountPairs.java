package Sorting;

import java.util.ArrayList;
import java.util.Collections;

public class CountPairs {

    public static int solve(ArrayList<Integer> l1, ArrayList<Integer> l2) {
        int ans = 0;
        Collections.sort(l1);
        Collections.sort(l2);

        int i = 0, j = 0;

        while (i < l1.size() && j < l2.size()) {
            if (l1.get(i) > l2.get(j)) {
                ans += l1.size() - i;
                j++;
            } else {
                i++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(7);
        list1.add(3);
        list1.add(5);

        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(2);
        list2.add(0);
        list2.add(6);

        System.out.println(solve(list1, list2));
    }
}