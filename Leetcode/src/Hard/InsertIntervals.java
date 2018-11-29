//package Hard;
//
//import java.util.LinkedList;
//import java.util.List;
//
//public class InsertIntervals {
//    public static class Interval {
//        int start;
//        int end;
//        Interval() { start = 0; end = 0; }
//        Interval(int s, int e) { start = s; end = e; }
//
//        @Override
//        public String toString() {
//            return this.start + " " + this.end;
//        }
//
//        }
//    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
//
//        List<Interval> result = new LinkedList<>();
//        if (intervals.size() == 0) return result;
//        boolean foundStart = false;
//        for (int i=0;i<intervals.size();i++) {
//            Interval i1 = intervals.get(i);
//            if (i1.end > newInterval.end && !foundStart) {
//                i1.start = Math.min(i1.start, newInterval.start);
//                foundStart = true;
//            }
//            if (foundStart) {
//                if (newInterval.end < i1.start) {
//                    i1.end = Math.min()
//                }
//            }
//        }
//
//    }
//        public static void main(String[] args) {
//        InsertIntervals m1 = new InsertIntervals();
//        List<Interval> intervals = new LinkedList<>();
//        Interval i1 = new Interval(1,2);
//        intervals.add(i1);
//        i1 = new Interval(3,5);
//        intervals.add(i1);
//        i1 = new Interval(6,7);
//        intervals.add(i1);
//        i1 = new Interval(8,10);
//        intervals.add(i1);
//        i1 = new Interval(12,16);
//        intervals.add(i1);
//        Interval newInterval  = new Interval(4,8);
//
//        List<Interval> result = m1.insert(intervals, newInterval);
//        System.out.println(result);
//
//
//    }
//}
