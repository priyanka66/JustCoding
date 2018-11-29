package Sorting;

import java.util.Arrays;

public class InsertionSort {


    public void insertionSort(int[] nums) {
        if (nums.length < 2) return;
        for (int i=1;i<nums.length;i++) {
            int hole=i, value= nums[hole];
            while (hole>0 && nums[hole-1] > nums[hole]) {
                int temp = nums[hole-1];
                nums[hole-1] = nums[hole];
                nums[hole] = temp;
                hole = hole-1;
            }

            nums[hole] = value;
        }
    }

    public static void main(String[] args) {
        InsertionSort s = new InsertionSort();
        int[] nums = {2,7,4,1,5,3};
        System.out.println(Arrays.toString(nums));
        s.insertionSort(nums);
        System.out.println(Arrays.toString(nums));
    }

}

