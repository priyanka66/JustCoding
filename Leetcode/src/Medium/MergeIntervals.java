package Medium;

import java.util.*;

public class MergeIntervals {
    public static class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
  }

    private List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new LinkedList<>();

        Collections.sort(intervals, new Comparator<Interval> (){
            @Override
            public int compare (Interval i1, Interval i2) {
                if (i1.start > i2.start) return 1;
                else if (i1.start < i2.start) return -1;
                else return 0;
            }
        });

        if (intervals.size() == 0) return result;
        Interval i1 = intervals.get(0);
        for (int i=1;i<intervals.size();i++) {
            Interval i2 = intervals.get(i);
            if (intervals.get(i).start <= i1.end) {
                i1.end = intervals.get(i).end > i1.end ? i1.end : intervals.get(i).end;
            } else {
                result.add(i1);
                i1 = intervals.get(i);
            }
        }
        result.add(i1);
        return result;
    }
    public static void main(String[] args) {
        MergeIntervals m1 = new MergeIntervals();
        List<Interval> intervals = new LinkedList<>();
        Interval i1 = new Interval(1,4);
        intervals.add(i1);
        i1 = new Interval(0,4);
        intervals.add(i1);
//        i1 = new Interval(8,10);
//        intervals.add(i1);
//         i1 = new Interval(15,18);
//        intervals.add(i1);
        List<Interval> result = m1.merge(intervals);
        System.out.println(result);


    }
}
