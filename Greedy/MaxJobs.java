package Greedy;

import java.util.ArrayList;
import java.util.Collections;

public class MaxJobs {
    class Pair{
        int start;
        int end;
        public Pair(int s, int e){
            start = s;
            end = e;
        }
    }
    
    public int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        ArrayList<Pair> jobs = new ArrayList<>();
        for(int i = 0; i < A.size(); i++){
            int s = A.get(i);
            int e = B.get(i);
            jobs.add(new Pair(s, e));
        }

        Collections.sort(jobs, (a, b) -> a.end - b.end);
        int count = 0;
        int last_end = Integer.MIN_VALUE;
        for(int i = 0; i < jobs.size(); i++){
            int curr_start = jobs.get(i).start;
            if(curr_start >= last_end){
                count++;
                last_end = jobs.get(i).end;
            }
            else
                continue;
        }
        return count;
    }
}

