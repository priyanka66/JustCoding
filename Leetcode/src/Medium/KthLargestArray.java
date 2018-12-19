package Medium;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargestArray {

    private int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);

        return nums[nums.length-k];

    }

    private int findKthLargestV2(int[] nums, int k) {
        PriorityQueue<Integer> que = new PriorityQueue<>(Collections.reverseOrder());
        for (int num:nums) {
            que.offer(num);
        }

        while (k>1){
            que.poll();
            k--;
        }
        return que.poll();
    }

    private int findKthLargestV3(int[] nums, int k) {
        PriorityQueue<Integer> que = new PriorityQueue<>(k+1);
        for(int num:nums) {
            que.offer(num);
            if(que.size()>k) que.poll();
        }
        return que.poll();
    }

        public static void main(String[] args) {
        KthLargestArray m = new KthLargestArray();
        int[] nums = {3,2,1,5,6,4};
        int k = 4;
        System.out.println(m.findKthLargest(nums, k));
        System.out.println(m.findKthLargestV2(nums, k));
        System.out.println(m.findKthLargestV3(nums, k));

    }

}
