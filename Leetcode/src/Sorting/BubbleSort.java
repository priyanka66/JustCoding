package Sorting;

import java.util.Arrays;

public class BubbleSort {

    public void bubbleSort(int[] nums) {
        if (nums.length < 2) return;
        int n = nums.length;
        for (int k=1;k<n;k++) {
            for (int i=0;i<n-1;i++) {
                if (nums[i] > nums[i+1]) {
                    int temp = nums[i];
                    nums[i] = nums[i+1];
                    nums[i+1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        BubbleSort s = new BubbleSort();
        int[] nums = {2,7,4,1,5,3};
        System.out.println(Arrays.toString(nums));
        s.bubbleSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
