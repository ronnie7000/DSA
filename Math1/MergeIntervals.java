package Math1;
import java.util.*;

public class MergeIntervals {

    public static ArrayList<Interval> solve(ArrayList<Interval> intervals, Interval newInterval) {
        int l = newInterval.start, r = newInterval.end;
        int size = intervals.size();
        ArrayList<Interval> res = new ArrayList<Interval>();

        for (int i = 0; i < size; i++) {
            Interval it = intervals.get(i);
            // Case 1 - No overlap and new interval has not been handled
            if (it.end < l) {
                res.add(it);
            }

            // Case 2 - No overlap and new interval has been handled
            else if (r < it.start) {
                res.add(new Interval(l, r));
                for (int j = i; j < size; j++) {
                    res.add(intervals.get(j));
                }
                return res;
            }

            // Case 3 - Overlap
            else {
                l = Math.min(l, it.start);
                r = Math.max(r, it.end);
            }
        }
        res.add(new Interval(l, r));
        return res;
    }

    public static void main(String[] args) {
        ArrayList<Interval> intervals = new ArrayList<Interval>();
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(6, 9));

        Interval newInterval = new Interval(2, 5);

        ArrayList<Interval> res = solve(intervals, newInterval);
        for (Interval i : res) {
            i.display();
        }

    }
}
