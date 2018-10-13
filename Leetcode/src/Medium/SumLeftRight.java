package Medium;

import java.util.Arrays;

public class SumLeftRight {

    private int sumLeftRight(int[] nums) {
        int len = nums.length;
        int[] leftSum = new int[len];
        int[] rightSum = new int[len];
        leftSum[0]= 0;
        rightSum[len-1]=0;
        for (int i=1;i<nums.length;i++) {
            leftSum[i] = leftSum[i-1] + nums[i-1];
        }

        for (int i=nums.length-2;i>=0;i--) {
            rightSum[i] = rightSum[i+1] +  nums[i+1];
        }

        for (int i=0;i<len;i++) {
            if (leftSum[i] == rightSum[i]) return nums[i];
        }

        return -1;
    }

    public static void main(String[] args) {
        SumLeftRight s = new SumLeftRight();
        int[] nums = {2,3,4,1,4,5};

        System.out.println(s.sumLeftRight(nums));
    }
}
