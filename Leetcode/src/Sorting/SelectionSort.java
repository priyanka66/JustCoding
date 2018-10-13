package Sorting;

import java.util.Arrays;

public class SelectionSort {

    public void selectionSort(int[] nums) {
        if (nums.length < 2) return;

        for (int i=0;i<nums.length;i++) {
            int min = i;
            for(int j=i+1;j<nums.length;j++) {
                if (nums[j] < nums[min]) min = j;
            }
            int temp = nums[i];
            nums[i] = nums[min];
            nums[min] = temp;
        }
    }
    public static void main(String[] args) {
        SelectionSort s = new SelectionSort();
        int[] nums = {2,7,4,1,5,3};
        System.out.println(Arrays.toString(nums));
        s.selectionSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
