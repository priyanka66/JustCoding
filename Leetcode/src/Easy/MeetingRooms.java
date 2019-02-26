package Easy;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRooms {
    public static class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
  }

    public boolean canAttendMeetings(Interval[] intervals) {
        if (intervals.length == 0) return true;

        PriorityQueue<Interval> queue = new PriorityQueue<>((a,b)->a.start-b.start);
        for (Interval interval: intervals) {
            queue.offer(interval);
        }
        Interval i1 = queue.poll();
        while (!queue.isEmpty()) {
            Interval i2 = queue.poll();
            if (i2.start < i1.end) return false;
            i1 = i2;
        }
        return true;
    }

    public static void main(String[] args) {
        MeetingRooms m = new MeetingRooms();
        Interval[] intervals = new Interval[3];
        intervals[0] = new Interval(0,30);
        intervals[1] = new Interval(15,20);
        intervals[2] = new Interval(5,10);

        System.out.println(m.canAttendMeetings(intervals));

    }
}
