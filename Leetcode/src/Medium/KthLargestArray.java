package Medium;

import java.util.Arrays;

public class KthLargestArray {

    private int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);

        return nums[nums.length-k];

    }

    public static void main(String[] args) {
        KthLargestArray m = new KthLargestArray();
        int[] nums = {3,2,1,5,6,4};
        int k = 2;
        System.out.println(m.findKthLargest(nums, k));
    }

}
