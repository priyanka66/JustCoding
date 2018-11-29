package Easy;

import java.util.Arrays;

public class RotateArray {

    public void rotate(int[] nums, int k){
        if (nums == null || k ==0 ) return;
        int len = nums.length, i=0;
        int[] temp = new int[len];
        while (i<len) {
            temp[ (i+k) % len] = nums[i++];
        }
        nums = Arrays.copyOf(temp, temp.length);
        System.out.println(Arrays.toString(nums));
    }

    public void rotateV2(int[] nums, int k){
        if (nums == null || k==0) return;

        for (int i=0;i<k;i++) {
            rotate(nums);
        }

        System.out.println(Arrays.toString(nums));
    }

    public void rotate(int[] nums) {
        int temp = nums[nums.length-1];
        for (int i=nums.length-1;i>0;i--) {
            nums[i] = nums[i-1];
        }
        nums[0] = temp;
    }
    public static void main(String[] args) {
        RotateArray r = new RotateArray();
        int[] nums = {1,2,3,4,5,6,7};
        int k = 1;
        r.rotate(nums,k);
        int[] num = {1,2,3,4,5,6,7};
        r.rotateV2(num,k);
    }
}
