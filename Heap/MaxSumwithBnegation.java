package Heap;

import java.util.PriorityQueue;

public class MaxSumwithBnegation {
    
    public static int solve(int[] A, int B){
        long sum = 0;

        // PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b );
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);

        for(int x : A){
            pq.offer(x);
        }

        while(B > 0){
            int minVal = pq.poll();
            if(minVal == 0){
                pq.offer(minVal);
                break;
            }
            else if(minVal < 0){
                minVal *= -1;
                B--;
                pq.offer(minVal);
            }
            else{
                if(B % 2 == 0){
                    pq.offer(minVal);
                    break;
                }
                else{
                    minVal *= -1;
                    pq.offer(minVal);
                    break;
                }
            }
        }

        while(!pq.isEmpty()){
            sum += (int)pq.poll();
        }

        return (int)sum;
    }

    public static void main(String[] args) {
        int[] A = {-43,-1,19,87,-45};
        System.out.println(solve(A, 5));
    }
}
