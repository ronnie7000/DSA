package Heap;

import java.util.PriorityQueue;

public class HeapSort {
    public static int[] sort(int[] A){
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a-b);
        for(int x : A){
            pq.offer(x);
        }
        int[]res = new int[A.length];
        int idx = 0;

        while(!pq.isEmpty()){
            res[idx] = pq.poll();
            idx++;
        }
        return res;
    }
    
    public static void main(String[] args) {
        int[] A = {2,4,3,1,5};
        int[] res = sort(A);

        for(int x : res)
            System.out.println(x);
    }
}
