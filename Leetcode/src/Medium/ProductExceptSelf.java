package Medium;

import java.util.Arrays;

public class ProductExceptSelf {

    private int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] output = new int[len];
        int[] leftPro = new int [len];
        int[] rightPro = new int[len];
        leftPro[0]=1;
        for (int i=1;i<len;i++) {
            leftPro[i] = leftPro[i-1] * nums[i-1];
        }
        rightPro[len-1] = 1;
        for (int i=len-2; i>=0; i--) {
            rightPro[i] = rightPro[i+1] * nums[i+1];
        }

        for(int i=0; i<len;i++) {
            output[i] = leftPro[i] * rightPro[i];
        }

        return output;
    }
    public static void main(String[] args) {
        ProductExceptSelf p1 = new ProductExceptSelf();
        int[] nums = {1,2,3,4};
        System.out.println(Arrays.toString(p1.productExceptSelf(nums)));

    }
}
