package Easy;

import java.util.Arrays;

public class MoveZero {

    private void moveZero(int[] nums) {
        if (nums == null) return;
        int index =0;
        for (int i=0;i<nums.length;i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }
        for (int i=index;i<nums.length;i++)
            nums[i] = 0;

        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        MoveZero m1 = new MoveZero();
        int[] nums = null;
        m1.moveZero(nums);
    }
}
