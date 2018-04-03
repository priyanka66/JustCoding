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
    public static void main(String[] args) {
        RotateArray r = new RotateArray();
        int[] nums = {1,2};
        int k = 1;
        r.rotate(nums,k);
    }
}
