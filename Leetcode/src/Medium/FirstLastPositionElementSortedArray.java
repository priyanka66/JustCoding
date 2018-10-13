package Medium;

import java.util.Arrays;

public class FirstLastPositionElementSortedArray {

    private int[] searchRange(int[]nums, int target) {
        if (nums.length ==0 || nums == null) {
            return new int[] {-1,-1};
        }
        int start=0, end=nums.length-1;
        int[] result = {-1,-1};
        while (start<=end) {
            int mid = (start+end) /2;
            if (target == nums[mid]) {
                int s = mid, e=mid;
                while ((s-1)>=0 && nums[s-1] == target) {
                    s--;
                }
                while ((e+1)<nums.length && nums[e+1] == target) {
                    e++;
                }
                result[0] = s;
                result[1] = e;
                return result;
            } else if (target > nums[mid]) start = mid+1;
            else end = mid-1;
        }
        return result;
    }
    public static void main(String[] args) {
        FirstLastPositionElementSortedArray s = new FirstLastPositionElementSortedArray();
        int nums[] = {1};
        int target = 1;
        System.out.println(Arrays.toString(s.searchRange(nums, target)));
    }
}
