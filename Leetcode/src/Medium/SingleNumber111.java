package Medium;

import java.util.Arrays;

public class SingleNumber111 {
    public int[] singleNumber(int[] nums) {
        int[] result = new int[2];
        int xor=0;

        // Get xor of numbers that are not duplicate
        for (int num:nums) xor ^= num;

        //Get the rightmost bit in xor that is set to 1

        int x = xor & ~(xor-1);

        //Iterate through the list and check for number where this 'x' bit set or not and group them
        for (int num:nums) {
            if ((x & num) > 0) {
                result[0] ^= num;
            } else {
                result[1] ^= num;
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
