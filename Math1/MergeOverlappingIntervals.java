package Math1;

import java.util.ArrayList;

public class MergeOverlappingIntervals {

    public static ArrayList<Interval> solve(ArrayList<Interval> intervals) {
        intervals.sort((a, b) -> {
            return a.start - b.start;
        });
        ArrayList<Interval> res = new ArrayList<Interval>();
        int s = intervals.get(0).start, e = intervals.get(0).end;
        int size = intervals.size();
        for (int i = 1; i < size; i++) {
            Interval itr = intervals.get(i);
            if (e < itr.start) {
                res.add(new Interval(s, e));
                s = itr.start;
                e = itr.end;
            } else {
                e = Math.max(e, itr.end);
            }
        }
        res.add(new Interval(s, e));
        return res;
    }

    public static void main(String[] args) {
        ArrayList<Interval> intervals = new ArrayList<Interval>();
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(15, 18));
        intervals.add(new Interval(2, 6));
        intervals.add(new Interval(8, 10));

        ArrayList<Interval> res = solve(intervals);
        for (Interval itr : res) {
            itr.display();
        }

    }
}
