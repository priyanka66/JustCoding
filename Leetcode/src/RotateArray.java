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
        if (nums == null || k ==0 ) return;
        int len = nums.length;
        for(int i=0;i<=nums.length-1;i++) {
            int temp = nums[(i+k) % len];
            nums[(i+k) % len] = nums[i];
            nums[i] = temp;
        }
        System.out.println(Arrays.toString(nums));
    }
    public static void main(String[] args) {
        RotateArray r = new RotateArray();
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
        r.rotate(nums,k);
        r.rotateV2(nums,k);
    }
}
