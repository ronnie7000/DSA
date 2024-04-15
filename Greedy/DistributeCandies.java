package Greedy;

import java.util.ArrayList;

public class DistributeCandies {
    public int candy(ArrayList<Integer> A) {
        int n = A.size();
        
        ArrayList<Integer> candies = new ArrayList<>();
        for(int x : A){
            candies.add(1);
        }

        for(int i = 1; i < n; i++){
            if(A.get(i) > A.get(i-1)){
                candies.set(i, candies.get(i-1) + 1);
            }
        }
        for(int i = n-2; i > -1; i--){
            if(A.get(i) > A.get(i+1)){
                candies.set(i, Math.max(candies.get(i), candies.get(i+1) + 1));
            }
        }

        int sum = 0;
        for(int x : candies){
            sum += x;
        }
        return sum;
    }
}
