package Medium;

import java.util.*;

public class MinimuminRotatedSortedArray {

    private int findMin(int[] nums) {
        if (nums.length == 0) return -1;
        if (nums.length == 1) return nums[0];

        int i=0, j=nums.length-1;
        while (i<=j) {
            int mid = (i+j)/2;
            if (mid > 0 && nums[mid] < nums[mid-1] ) return nums[mid];
            else if (nums[i] <= nums[mid] && nums[mid] > nums[j]) i = mid+1;
            else j=mid-1;
        }
        return nums[i];
    }

    public static void main(String[] args) {
        int[] nums = {2,4,5,6,7,8, 8,0};

        MinimuminRotatedSortedArray m = new MinimuminRotatedSortedArray();
        System.out.println(m.findMin(nums));

    }
}
