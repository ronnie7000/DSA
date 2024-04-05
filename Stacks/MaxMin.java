package Stacks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class MaxMin {
    public static int solve(ArrayList<Integer> A) {
        ArrayList<Integer> smallLeftList = getSmallLeftList(A);
        ArrayList<Integer> smallRightList = getSmallRightList(A);
        ArrayList<Integer> bigLeftList = getBigLeftList(A);
        ArrayList<Integer> bigRightList = getBigRightList(A);
        long mod = 100000007;
        long ans = 0;

        for (int i = 0; i < A.size(); i++) {
            long val = (long) A.get(i);
            long maxStart = (long) i - (long) bigLeftList.get(i);
            long maxEnd = (long) bigRightList.get(i) - (long) i;
            long minStart = (long) i - (long) smallLeftList.get(i);
            long minEnd = (long) smallRightList.get(i) - (long) i;

            long maxSubs = ((long)(i - bigLeftList.get(i)) * (long)(bigRightList.get(i) - i)) % mod;
            long minSubs = ((long)(i - smallLeftList.get(i)) * (long)(smallRightList.get(i) - i)) % mod;
            
            ans = (ans + ((maxSubs - minSubs) * val) % mod) % mod;
        }
        return (int) ans;
    }

    public static ArrayList<Integer> getSmallLeftList(ArrayList<Integer> A) {
        Stack<Integer> stack = new Stack<Integer>();
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < A.size(); i++) {
            int val = A.get(i);
            while (!stack.isEmpty() && A.get(stack.peek()) > val) {
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

    public static ArrayList<Integer> getSmallRightList(ArrayList<Integer> A) {
        Stack<Integer> stack = new Stack<Integer>();
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = A.size() - 1; i > -1; i--) {
            int val = A.get(i);
            while (!stack.isEmpty() && A.get(stack.peek()) > val) {
                stack.pop();
            }
            if (stack.isEmpty())
                res.add(A.size());
            else
                res.add(stack.peek());
            stack.push(i);
        }
        Collections.reverse(res);
        return res;
    }

    public static ArrayList<Integer> getBigLeftList(ArrayList<Integer> A) {
        Stack<Integer> stack = new Stack<Integer>();
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < A.size(); i++) {
            int val = A.get(i);
            while (!stack.isEmpty() && A.get(stack.peek()) < val) {
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

    public static ArrayList<Integer> getBigRightList(ArrayList<Integer> A) {
        Stack<Integer> stack = new Stack<Integer>();
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = A.size() - 1; i > -1; i--) {
            int val = A.get(i);
            while (!stack.isEmpty() && A.get(stack.peek()) < val) {
                stack.pop();
            }
            if (stack.isEmpty())
                res.add(A.size());
            else
                res.add(stack.peek());
            stack.push(i);
        }
        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {
        int[] A = {994390,986616,976849,979707,950477,968402,992171,937674,933065,960863,980981,937319,951236,959547,991052,991799,992213,941294,978103,997198,960759,988476,963517,980366,921767,979757,977912,983761,981869,947454,930202,999086,973538,999798,996446,944001,974217,951595,942688,975075,970973,970130,897109,927660,862233,997130,986068,954098,978175,889682,988973,996036,969675,985751,977724,881538,988613,924230,906475,915565,986952,975702,994316,964011,986848,983699,949076,989673,981788,929094,988310,926471,994763,999736,980762,973560,996622,934475,998365,966255,998697,998700,911868,983245,996382,996992,953142,994104,987303,853837,960626,904203,998063,977596,977868,996012,946345,949255,988138,996298,954933,965036,886976,998628,990878,953725,916744,985233,919661,970903,986066};
    
        ArrayList<Integer> inp = new ArrayList<>();
        for(int val : A)
            inp.add(val);
        System.out.println(solve(inp));
    }
}
