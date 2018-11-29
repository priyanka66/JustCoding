package Easy;

import java.util.Arrays;

public class TwoSumSorted {


    private  int[] twoSum(int[] nums, int target) {
       int [] result = new int[2];
       if (nums.length == 0) return result;
       int i=0, j=nums.length-1;
       while (i<j) {
           if (nums[i]+nums[j] == target) {
               result[0] = i+1;
               result[1] = j+1;
               break;
           } else if (nums[i] + nums[j] > target) j--;
           else i++;
       }

       return result;
    }
    public static void main(String[] args) {
        TwoSumSorted t = new TwoSumSorted();
        int[] nums = {1,2,6,8,11};
        int target = 10;
        System.out.println(Arrays.toString(t.twoSum(nums, target)));
    }
}
