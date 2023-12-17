package Math1;
import java.util.ArrayList;

public class MergeIntervals {
    
    public static ArrayList<Interval> solve(ArrayList<Interval> intervals, Interval newInterval)
    {
        ArrayList<Interval> res = new ArrayList<Interval>();
        Interval temp = newInterval;
        boolean mergedNew = false;
        
        if(intervals.size() == 0)
        {
            res.add(temp);
            return res;
        }
        else{
            for(Interval i : intervals)
            {
                //Non Ovelapping
                if(Math.max(i.start, temp.start) > Math.min(i.end,temp.end))
                {
                    //New interval is smaller -> push that first to result
                    if(temp.end < i.start && mergedNew==false)
                    {
                        res.add(temp);
                        mergedNew = true;
                        res.add(i);
                    }
                    else{
                        res.add(i);
                    }
                }
                //Overlapping
                else{
                    temp.start = Math.min(temp.start, i.start);
                    temp.end = Math.max(temp.end, i.end);
                }
            }
        }

        return res;
    }
    
    
    public static void main(String[] args)
    {
        ArrayList<Interval> intervals = new ArrayList<Interval>();
        intervals.add( new Interval(1,3));
        intervals.add( new Interval(6,9));

        Interval newInterval = new Interval(2,6);

        ArrayList<Interval> res = solve(intervals, newInterval);
        for(Interval i:res)
        {
            i.display();
        }
        
    }
}
