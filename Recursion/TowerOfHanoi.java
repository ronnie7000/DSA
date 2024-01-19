package Recursion;

import java.util.ArrayList;

public class TowerOfHanoi {

    // Move n towers from source -> tower 'a' to dest-> tower 'c' using spare -> tower 'b'
    public static void solve(int n, char a, char b, char c) {

        // Base Condition
        if (n == 1) {
            System.out.println("Disk " + "1" + " --> " + a + " to " + c);
            return;
        }
        //Move smaller n-1 disks from source tower to spare tower
        solve(n-1, a, c, b);

        //Move nth largest disk from source tower to dest tower
        System.out.println("Disk " + n + " --> " + a + " to " + c);

        //Move remaining  smaller n-1 disks from spare tower to dest tower
        solve(n-1, b, a, c);
    }


    public static ArrayList<ArrayList<Integer>> towerOfHanoi(int A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();        
        result = solve2(A, 1, 2, 3, result);

        return result;
    }

    public static ArrayList<ArrayList<Integer>> solve2(int n, int start, int spare, int end, ArrayList<ArrayList<Integer>> results){
        ArrayList<Integer> curr = new ArrayList<>();
        if(n==1){
            curr.add(1);    curr.add(start);    curr.add(end);
            results.add(curr);
            return results;
        }
        solve2( n-1, start, end, spare, results);
        curr.add(n);    curr.add(start);    curr.add(end);
        results.add(curr);
        solve2(n-1, spare, start, end, results);

        return results;
    }

    public static void main(String[] args) {
        //solve(4, 'A', 'B', 'C');
        ArrayList<ArrayList<Integer>> result = towerOfHanoi(2);

        for(ArrayList<Integer> row: result){
            for(Integer val: row){
                System.out.print(val + " ");
            }
            System.out.println();
        }

    }
}
