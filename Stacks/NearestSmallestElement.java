package Stacks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class NearestSmallestElement {

    public static ArrayList<Integer> solve(ArrayList<Integer> A) {
        Stack<Integer> stack = new Stack<Integer>();
        ArrayList<Integer> res = new ArrayList<>();

        for (int i = 0; i < A.size(); i++) {
            int val = A.get(i);
            while (!stack.isEmpty() && A.get(stack.peek()) >= val) {
                stack.pop();
            }
            if (stack.isEmpty())
                res.add(-1);
            else
                res.add(A.get(stack.peek()));
            stack.push(i);
        }
        return res;
    }

    public static ArrayList<Integer> getSmallestRight(ArrayList<Integer> A) {
        Stack<Integer> stack = new Stack<Integer>();
        ArrayList<Integer> res = new ArrayList<>();

        for (int i = A.size() - 1; i > -1; i--) {
            int val = A.get(i);
            while (!stack.isEmpty() && A.get(stack.peek()) >= val) {
                stack.pop();
            }
            if (stack.isEmpty())
                res.add(-1);
            else
                res.add(A.get(stack.peek()));
            stack.push(i);
        }
        Collections.reverse(res);
        return res;
    }


    public static void main(String[] args) {
        ArrayList<Integer> inp = new ArrayList<>();
        // inp.add(8);
        // inp.add(2);
        inp.add(4);
        // inp.add(9);
        // inp.add(7);
        inp.add(5);
        inp.add(2);
        // inp.add(3);
        inp.add(10);
        inp.add(8);

        ArrayList<Integer> res = getSmallestRight(inp);
        for (int val : res) {
            System.out.println(val);
        }
    }
}
