package Easy;

import java.util.PriorityQueue;

public class MaximumSumSubArray {
    static int maxSubArray(int[] nums) {
        int curMax = nums[0];
        int max = nums[0];
        for (int i=1;i<nums.length;i++){
            curMax = Math.max(nums[i], nums[i]+curMax);
            max = Math.max(curMax, max);
        }

        return max;
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int result = maxSubArray(nums);
        System.out.println("Max Sum : " + result);
    }
}
