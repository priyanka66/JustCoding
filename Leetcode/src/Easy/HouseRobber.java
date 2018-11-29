package Easy;

public class HouseRobber {

    public static int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int[] maxAmount = new int[nums.length];
        maxAmount[0] = nums[0];
        maxAmount[1] = Math.max(nums[0], nums[1]);
        for (int i=2; i<nums.length;i++) {
            maxAmount[i] =  Math.max(nums[i]+ maxAmount[i-2], maxAmount[i-1]);
        }

        return maxAmount[nums.length-1];
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,2};
        System.out.println(rob(nums));
    }
}
