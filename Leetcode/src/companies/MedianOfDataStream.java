package companies;


import java.util.*;

public class MedianOfDataStream {
    PriorityQueue<Integer> max;
    PriorityQueue<Integer> min;

    public MedianOfDataStream() {
        max = new PriorityQueue<>(Collections.reverseOrder());
        min = new PriorityQueue<Integer>();
    }

    public void addNum(int num) {
        if (max.size() == min.size()) {
            if (max.isEmpty()) {
                max.offer(num);
            } else if (num >  max.peek()) {
                min.offer(num);
                max.offer(min.poll());
            } else {
                max.offer(num);
            }
        } else {
            if (num > max.peek()) {
                min.offer(num);
            } else {
                max.offer(num);
                min.offer(max.poll());
            }
        }
    }

    public double findMedian() {
        if(min.size() == max.size()){
            return (min.peek() + max.peek()) / 2.0;
        } else {
            return max.peek();
        }

    }

    public static void main(String[] args) {
        /**["MedianFinder","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian"]
         [[],[6],[],[10],[],[2],[],[6],[],[5],[],[0],[],[6],[],[3],[],[1],[],[0],[],[0],[]]
         */
        MedianOfDataStream m = new MedianOfDataStream();
        m.addNum(6);
        System.out.println(m.findMedian());
        m.addNum(10);
        System.out.println(m.findMedian());
        m.addNum(2);
        System.out.println(m.findMedian());
        m.addNum(6);
        System.out.println(m.findMedian());
        m.addNum(5);
        System.out.println(m.findMedian());
        m.addNum(0);
        System.out.println(m.findMedian());
        m.addNum(3);
        System.out.println(m.findMedian());
        m.addNum(1);
        System.out.println(m.findMedian());
        m.addNum(0);
        System.out.println(m.findMedian());
        m.addNum(0);
        System.out.println(m.findMedian());

    }
}
