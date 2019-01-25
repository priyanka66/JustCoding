package Medium;

public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        int maxlength=1;
        int[] dp = new int[nums.length];
        for (int i=0;i<nums.length;i++) dp[i] =1;
        for(int i=1;i<nums.length;i++) {
            for (int j=0;j<i;j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[j]+1, dp[i]);
                    maxlength = Math.max(maxlength, dp[i]);
                }
            }
        }
        return maxlength;
    }
    public static void main(String[] args) {
        LongestIncreasingSubsequence l = new LongestIncreasingSubsequence();
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(l.lengthOfLIS(nums));
    }

}
