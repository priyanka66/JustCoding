package Medium;

public class IncreasingTripletSubsequence {

    private boolean increasingTriplet(int[] nums) {
        int min = nums[0], max = Integer.MAX_VALUE;
        for (int i=1;i<nums.length;i++) {
                if (nums[i] > max) return true;
                else if (nums[i] > min && nums[i] < max) max = nums[i];
                else if (nums[i] < min) min = nums[i];
            }

            return false;
    }

    public static void main(String[] args) {
        IncreasingTripletSubsequence s = new IncreasingTripletSubsequence();
        int[] nums = {1,2,3};
        System.out.println(s.increasingTriplet(nums));
    }
}
