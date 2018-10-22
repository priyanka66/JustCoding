package Medium;

import java.util.*;

public class ThreeSum {

    private  List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0) return result;
        Arrays.sort(nums);

        for (int i=0;i<nums.length-2;i++) {
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            int start=i+1, end=nums.length-1;
            while (start<end) {
                int sum = nums[i] + nums[start]+nums[end];
                if(sum == 0) {
                    result.add(new ArrayList<>(Arrays.asList(nums[i], nums[start], nums[end])));
                    while(start < end && nums[start] == nums[start + 1]) start++;
                    while(start < end && nums[end] == nums[end - 1]) end--;
                }
                if (sum <0) start++;
                else end--;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        ThreeSum s = new ThreeSum();
//        int[] nums = {1,-2,-5,-13,-10,-11,0,-12,-11,13,-4,9,8,10,-7,3,-9,-12,-7,8,-2,-12,1,-10,-15,-8,5,14,-7,-8,-8,9,-3,-6,3,-5,-1,-11,-10,3,-13,1,-10,3,-12,-10,-9,-13,-7,-1,10,6,-6,-12,12,-13,-13,-6,-14,-13,-7,-7,4,6,-6,-8,8,8,-4,13,-11,-1,-8,-14,9,-5,-9,7,-3,-1,14,14,13,-7,9,2,-5,12,11,-12,14,-11,-12,3,2,-2,3,-5,-9,14,-14,-13,-10,-7,-12,14,3,-6,-1,8,1,-2,-1,-1,6,-6};
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(s.threeSum(nums));
    }
}
