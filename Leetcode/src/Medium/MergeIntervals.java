package Medium;

import java.util.*;

public class MergeIntervals {
    public static class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }

        @Override
        public String toString() {
          return this.start + " " + this.end;
        }

    }

    List<Interval> mergeV1 (List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();
        if (intervals.size() == 0) return result;
        intervals.sort((i1,i2) -> i1.start-i2.start);
//        Collections.sort(intervals, new Comparator<Interval>() {
//            @Override
//            public int compare (Interval i1, Interval i2) {
//                if (i1.start < i2.start) return -1;
//                else if (i1.start == i2.start) return 0;
//                else return 1;
//            }
//        });

        Interval i1 = intervals.get(0);
        for (int i=1; i<intervals.size();i++) {
            Interval i2=intervals.get(i);
            if (i2.start < i1.end) {
                i1.end = Math.max(i1.end, i2.end);
            } else {
                result.add(i1);
                i1=i2;
            }
        }

        result.add(i1);

        return result;
    }
    public static void main(String[] args) {
        MergeIntervals m1 = new MergeIntervals();
        List<Interval> intervals = new LinkedList<>();
        Interval i1 = new Interval(1,3);
        intervals.add(i1);
        i1 = new Interval(8,10);
        intervals.add(i1);
        i1 = new Interval(2,6);
        intervals.add(i1);
         i1 = new Interval(15,18);
        intervals.add(i1);
        List<Interval> result = m1.mergeV1(intervals);
        System.out.println(result);


    }
}
