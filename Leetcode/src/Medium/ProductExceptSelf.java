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
        int zeroCount = 0, product = 1;
        for (int i=0;i<nums.length;i++) {
            if (nums[i] == 0) {
                zeroCount++;
                continue;
            }
            product *= nums[i];
        }
        if (zeroCount > 1) {
            return result;
        }
        for (int i=0;i<nums.length;i++) {
            if (nums[i] == 0) {
                result[i] = product;
            } else {
                result[i] = product/nums[i];
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
