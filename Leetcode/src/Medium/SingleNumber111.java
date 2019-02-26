package Medium;

import java.util.Arrays;

public class SingleNumber111 {
    public int[] singleNumber(int[] nums) {
        int[] result = new int[2];
        int num = nums[0];
        for (int i=1;i<nums.length;i++) {
            num ^= nums[i];
        }

        int xor = num & ~(num-1);
        for (int n :nums) {
            if ((xor & n) > 0) {
                result[0] ^= n;
            } else {
                result[1] ^= n;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        SingleNumber111 sn = new SingleNumber111();
        int[] nums = {1,2,1,3,2,5};
        System.out.println(Arrays.toString(sn.singleNumber(nums)));
    }
}
