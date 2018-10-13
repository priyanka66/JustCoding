package Sorting;

import java.util.Arrays;

public class QuickSort {

    int partition(int[] nums, int start, int end) {
        int pivot = nums[end];
        int pIndex = start;
        for (int i=start;i<end;i++) {
            if (nums[i] <= pivot) {
                int temp = nums[i];
                nums[i] = nums[pIndex];
                nums[pIndex] = temp;
                pIndex++;
            }
            int temp = nums[pIndex];
            nums[pIndex] = pivot;
            nums[end] = temp;

        }

        return pIndex;
    }

    public void quickSort(int[] nums, int start, int end) {
        if (start < end) {
            int pIndex = partition(nums, 0, nums.length-1);
            quickSort(nums, start, pIndex-1);
            quickSort(nums, pIndex, end);
        }
    }
    public static void main(String[] args) {
        QuickSort s = new QuickSort();
        int[] nums = {2,7,4,1,5,3};
        System.out.println(Arrays.toString(nums));
        s.quickSort(nums, 0, nums.length);
        System.out.println(Arrays.toString(nums));
    }
}
