package Greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class InventoryManagement {
    class Pair{
        int time;
        int val;
        public Pair(int t, int v){
            time = t;
            val = v;
        }
    }
    
    public int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        ArrayList<Pair> pairs = new ArrayList<>();

        for(int i = 0; i < A.size(); i++){
            int t = A.get(i);
            int v = B.get(i);
            pairs.add(new Pair(t, v));
        }

        Collections.sort(pairs, (a, b) -> a.time - b.time);

        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> a-b);

        for(int i = 0; i < pairs.size(); i++){
            Pair p = pairs.get(i);
            minHeap.offer(p.val);

            if(minHeap.size() > p.time){
                minHeap.poll();
            }
        }
        long mod = 1000000007;
        long profit = 0;
        while(!minHeap.isEmpty()){
            profit += (long)minHeap.poll();
            profit %= mod;
        }
        return (int)profit;
    }
}
