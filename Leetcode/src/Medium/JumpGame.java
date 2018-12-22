package Medium;

public class JumpGame {
    public boolean canJump(int[] nums) {
        if(nums.length == 0) return false;
        int cur = 0, jump = 0;
        while (cur < nums.length && cur <= jump) {
            if (cur + nums[cur] > jump) jump= cur+nums[cur];
            cur++;
        }

        return cur == nums.length ? true : false;
    }

    public static void main(String[] args) {
        JumpGame g = new JumpGame();
        int[] nums = {2,3,1,1,4};
        System.out.println(g.canJump(nums));
   }
}
