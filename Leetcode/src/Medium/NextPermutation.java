package Medium;

import java.util.Arrays;

public class NextPermutation {

    public void nextPermutation(int[] nums) {
        if (nums.length == 0) return;
        int index = -1;
        for (int i =nums.length-2;i>=0;i--) {
            if (nums[i] < nums[i+1]) {
                index =  i;
                break;
            }
        }

        if (index == -1) {
            Arrays.sort(nums);
            return;
        }

        for (int i=nums.length-1;i>=0;i--) {
            if (nums[i] > nums[index]) {
                int x = nums[i];
                nums[i] = nums[index];
                nums[index] = x;
                break;
            }
        }
        Arrays.sort(nums, index+1,nums.length);
    }

    public static void main(String[] args) {
        NextPermutation p = new NextPermutation();
        int[] nums = {1,3,2};
        p.nextPermutation(nums);
    }
}
