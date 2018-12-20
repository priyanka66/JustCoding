package Medium;

import java.util.Arrays;

public class WiggleSort {

    public void wiggleSort(int[] nums) {
        if (nums.length <2) return;
        int temp;
        for (int i=0;i<nums.length-1;i++) {
            if ((i%2==0 && nums[i] <= nums[i+1]) || (i%2!=0 && nums[i] >= nums[i+1])) continue;
            else {
                temp = nums[i];
                nums[i] = nums[i+1];
                nums[i+1] = temp;
            }
        }

        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        int[] nums = {3,5,2,1,6,4};
        WiggleSort s = new WiggleSort();
        s.wiggleSort(nums);
    }
}
