package Hard;


import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianOfDataStream {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    public MedianOfDataStream() {
        maxHeap = new PriorityQueue<>(1, Comparator.reverseOrder());
        minHeap = new PriorityQueue<>();
    }

    void addNum(int num) {
        if (maxHeap.size() == minHeap.size()) {
            if (maxHeap.isEmpty()) {
                maxHeap.offer(num);
            } else if (num > maxHeap.peek()) {
                minHeap.offer(num);
                maxHeap.offer(minHeap.poll());
            } else {
                maxHeap.offer(num);
            }
        } else  {
            if (num > maxHeap.peek()) {
                minHeap.offer(num);
            } else {
                maxHeap.offer(num);
                minHeap.offer(maxHeap.poll());
            }
        }
    }


    double findMedian() {
        if (maxHeap.size() > minHeap.size()) return maxHeap.peek();
        else return (double) (maxHeap.peek() + minHeap.peek()) /2;
    }


    public static void main(String[] args) {

        MedianOfDataStream m = new MedianOfDataStream();
        m.addNum(6);
        System.out.println(m.findMedian());
        m.addNum(10);
        System.out.println(m.findMedian());
        m.addNum(2);
        System.out.println(m.findMedian());
//        m.addNum(6);
//        System.out.println(m.findMedian());
//        m.addNum(5);
//        System.out.println(m.findMedian());
//        m.addNum(0);
//        System.out.println(m.findMedian());
//        m.addNum(3);
//        System.out.println(m.findMedian());
//        m.addNum(1);
//        System.out.println(m.findMedian());
//        m.addNum(0);
//        System.out.println(m.findMedian());
//        m.addNum(0);
//        System.out.println(m.findMedian());

    }
}
