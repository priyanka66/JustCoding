package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoomsII {

    public static  class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
  }

    private static int minMeetingRooms(Interval[] intervals) {

        if (intervals.length == 0 || intervals == null) return 0;
        int count = 0;
        Arrays.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });


        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        queue.offer(intervals[0].end);
        count = 1;
        for (int i =1;i<intervals.length;i++) {
            if (intervals[i].start < queue.peek()) {
                count++;
            } else {
                queue.poll();
            }

            queue.offer(intervals[i].end);
        }

        return count;
    }

    public static void main(String[] args) {
        MeetingRoomsII m = new MeetingRoomsII();
        Interval[] intervals = new Interval[3];
        intervals[0] = new Interval(7,10);
        intervals[1] = (new Interval(2,4));
        intervals[2] = (new Interval(15,20));

        System.out.println(m.minMeetingRooms(intervals));



    }
}
