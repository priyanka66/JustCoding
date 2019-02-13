package Easy;

import java.util.PriorityQueue;

public class KthLargestElementInStream {

    PriorityQueue<Integer> queue;
    int k;
    public KthLargestElementInStream(int k, int[] nums) {
        queue = new PriorityQueue<>(k);
        this.k = k;
        for (int num: nums) {
            add(num);
        }
    }

    public int add(int val) {
        if (queue.size() < k) {
            queue.offer(val);
        } else if (queue.peek() < val) {
            queue.poll();
            queue.add(val);
        }

        return queue.peek();
    }

    public static void main(String[] args) {
        int k=3;
        int[] nums = {4,5,8,2};
        KthLargestElementInStream kthLargest = new KthLargestElementInStream(k, nums);
        System.out.println(kthLargest.add(3));   // returns 4
        System.out.println(kthLargest.add(5));   // returns 5
        System.out.println(kthLargest.add(10));  // returns 5
        System.out.println(kthLargest.add(9));   // returns 8
        System.out.println(kthLargest.add(4));
    }
}
