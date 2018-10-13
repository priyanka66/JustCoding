package Sorting;

import java.util.Arrays;

public class MergeSort {


    public void mergeSort(int[] nums) {
        if (nums.length < 2) return;
        int mid = nums.length/2;
        int[] left = new int[mid];
        int[] right = new int[(nums.length)-mid];
        for (int i=0;i<mid;i++) left[i]=nums[i];
        for (int i=mid;i< nums.length;i++) right[i-mid] = nums[i];

        mergeSort(left);
        mergeSort(right);
        merge(nums, left, right);

        return;
    }

    public void merge(int[] nums, int[] left, int[] right) {
        int i=0,j=0,k=0;
        while (i<left.length && j< right.length) {
            if (left[i] <= right[j]) nums[k++] = left[i++];
            else nums[k++] = right[j++];
        }

        while (i<left.length) nums[k++] = left[i++];
        while (j<right.length) nums[k++] = right[j++];

        return;
    }
    public static void main(String[] args) {
        MergeSort s = new MergeSort();
        int[] nums = {2,7,4,1,5,3};
        System.out.println(Arrays.toString(nums));
        s.mergeSort(nums);
        System.out.println(Arrays.toString(nums));
    }

}
