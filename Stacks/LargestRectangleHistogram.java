package Stacks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class LargestRectangleHistogram {
    public static int largestRectangleArea(ArrayList<Integer> A) {
        ArrayList<Integer> smallestLeftList = getSmallestLeft(A);
        ArrayList<Integer> smallestRightList = getSmallestRight(A);
        int maxArea = 0;
        for (int i = 0; i < A.size(); i++) {
            int smallestLeft = smallestLeftList.get(i);
            int smallestRight = smallestRightList.get(i) == -1 ? A.size() : smallestRightList.get(i);
            int width = A.get(i) * (smallestRight - smallestLeft - 1);
            maxArea = Math.max(maxArea, width);
        }
        return maxArea;
    }

    public static ArrayList<Integer> getSmallestLeft(ArrayList<Integer> A) {
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
                res.add(stack.peek());
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
                res.add(stack.peek());
            stack.push(i);
        }
        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {
        ArrayList<Integer> inp = new ArrayList<>();
        inp.add(2);
        inp.add(1);
        inp.add(5);
        inp.add(6);
        inp.add(2);
        inp.add(3);

        System.out.println(largestRectangleArea(inp));
    }
}
