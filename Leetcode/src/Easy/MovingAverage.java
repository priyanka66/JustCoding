package Easy;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverage {
    Queue<Integer> que ;
    double sum=0.0;
    int maxSize;

    public MovingAverage(int size) {
        maxSize = size;
        que = new LinkedList<>();
    }

    public double next(int n) {
        if (maxSize ==  que.size()) {
            sum = sum - que.remove();
        }

        que.add(n);
        sum += n;

        return (sum)/(que.size());
    }

    public static void main(String[] args) {
        MovingAverage m = new MovingAverage(3);
        System.out.println(m.next(1));
        System.out.println(m.next(10));
        System.out.println(m.next(3));
        System.out.println(m.next(5));


            /*
            m.next(1) = 1
            m.next(10) = (1 + 10) / 2
            m.next(3) = (1 + 10 + 3) / 3
            m.next(5) = (10 + 3 + 5) / 3
         */
    }
}
