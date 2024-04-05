package Sorting;

import java.util.ArrayList;
import java.util.Collections;

public class LargestNumber {
    public static String largestNumber(ArrayList<Integer> A) {
        Collections.sort(A, (a, b) -> {
            String s1 = Integer.toString(a) + Integer.toString(b);
            String s2 = Integer.toString(b) + Integer.toString(a);
            return s2.compareTo(s1);
        });

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < A.size(); i++) {
            int val = A.get(i);
            if (i == A.size() - 1 && sb.length() == 0 && val == 0)
                sb.append("0");
            else if (sb.length() == 0 && val == 0)
                continue;
            else
                sb.append(val);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(0);
        list.add(0);
        list.add(0);
        System.out.println(largestNumber(list));

    }
}
