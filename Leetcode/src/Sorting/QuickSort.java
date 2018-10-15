package Sorting;

import java.util.Arrays;

public class QuickSort {

    int partition(int[] nums, int start, int end) {
        int pivot = nums[end];
        int pIndex=start;
        for (int i=start;i<end;i++){
            if (nums[i]<pivot) {
                swap(nums, i, pIndex);
                pIndex++;
            }
        }

        swap(nums,end,pIndex);
        return pIndex;
    }

    private static void swap(int[] nums, int num, int num1) {
        int temp = nums[num];
        nums[num] = nums[num1];
        nums[num1] = temp;
    }

    public void quickSort(int[] nums, int start, int end) {
        if (start < end) {
            int partition = partition(nums, start, end);
            quickSort(nums, start,partition-1);
            quickSort(nums,partition+1, end);
        }
    }
    public static void main(String[] args) {
        QuickSort s = new QuickSort();
        int[] nums = {2,7,4,1,5,3};
        System.out.println(" before "+Arrays.toString(nums));
        s.quickSort(nums, 0, nums.length-1);
        System.out.println(Arrays.toString(nums));
    }
}
