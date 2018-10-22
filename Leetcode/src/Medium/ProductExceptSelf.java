package Medium;

import java.util.Arrays;

public class ProductExceptSelf {

    private int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] output = new int[len];
        int right = 1;
        output[0]=1;
        for (int i=1;i<len;i++) {
            output[i] = output[i-1] * nums[i-1];
        }
        System.out.println(Arrays.toString(output));
        for (int i=len-1; i>=0; i--) {
            output[i] = output[i] * right;
            right = right * nums[i];

        }

        return output;
    }

    private int[] productExceptSelfV2(int[] nums) {
        int[] result = new int[nums.length];
        int total = 1;
        int zeroCount =0;
        for (int num:nums) {
            if (num == 0) zeroCount++;
            else total*=num;
        }

        for (int i=0;i<nums.length;i++) {
            if (zeroCount == 0) {
                result[i] = total/nums[i];
            }
            if (zeroCount > 1) result[i] = 0;
            else if (zeroCount == 1) {
                if (nums[i] == 0) result[i] = total;
                else result[i] = 0;
            }
        }

        return result;
    }
    public static void main(String[] args) {
        ProductExceptSelf p1 = new ProductExceptSelf();
        int[] nums = {1,2,3,4};
        System.out.println(Arrays.toString(p1.productExceptSelf(nums)));
        System.out.println(Arrays.toString(p1.productExceptSelfV2(nums)));

    }
}
