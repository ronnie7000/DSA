package Recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class DuplicateSubsets {
    private static ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();

    public static ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> A) {
        Collections.sort(A);    
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        for( Integer num : A ){
            map.put( num, map.getOrDefault(num, 0) +1 );
            if( !list.contains(num) ){
                list.add(num);
            }
        }
        ArrayList<Integer> subset = new ArrayList<Integer>();
        solve( 0, subset, map, list );

        return ans;
    }


    public static void solve(int index, ArrayList<Integer> subset, HashMap<Integer, Integer> map, ArrayList<Integer> list){
        
        //Base Condition
        if(index == list.size()){
            ans.add( new ArrayList<Integer>(subset));
            return;
            
        }

        int num = list.get(index);
        int count = map.get(num);

        while( count >=0 ){
            subset.add(num);
            map.put( num, count -1 );
            solve( index, subset, map, list );
            // subset.remove( subset.size() -1 );
            // map.put( num, count );
        }

        solve( index + 1, subset, map, list );
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
        ArrayList<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(4);
        list.add(4);
        list.add(4);
        subsetsWithDup(list);
        displayResults();
    }
}
