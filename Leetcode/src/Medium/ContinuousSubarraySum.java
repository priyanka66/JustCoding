package Medium;


public class ContinuousSubarraySum {

    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums.length == 0) return false;
        int[] prevSum = new int[nums.length+1];
        for (int i=1;i<=nums.length;i++) {
            prevSum[i] = prevSum[i-1] + nums[i-1];
        }
        for (int i=0;i<nums.length;i++) {
            for (int j=i+2;j<=nums.length;j++) {
                if (k == 0) {
                    if (prevSum[j] - prevSum[i] == 0) return true;
                } else if ((prevSum[j] - prevSum[i]) % k == 0) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ContinuousSubarraySum s = new ContinuousSubarraySum();
        int[] nums = {23, 2, 4, 6, 7};
        int k = 6;
        System.out.println(s.checkSubarraySum(nums, k));
    }
}
