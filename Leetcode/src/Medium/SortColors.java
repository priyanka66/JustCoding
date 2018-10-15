package Medium;

import java.util.Arrays;

public class SortColors {

    private int[] sortColors(int[] nums) {
        int start=0, end=nums.length-1, index = 0;
        while (index <= end) {
            if (nums[index] == 0) {
                nums[index] = nums[start];
                nums[start] = 0;
                start++;
            }
            if (nums[index] == 2) {
                nums[index] = nums[end];
                nums[end] = 2;
                index--;
                end--;
            }
            index++;

        }

        return nums;
    }
    public static void main(String[] args) {
        SortColors s = new SortColors();
        int[] nums = {2,0,2,1,1,0};
        System.out.println(Arrays.toString(s.sortColors(nums)));
    }
}
