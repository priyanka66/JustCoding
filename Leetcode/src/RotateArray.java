import java.util.Arrays;

public class RotateArray {

    public void rotate(int[] nums, int k){
        if (nums == null || k ==0 ) return;
        int len = nums.length;
        int[] temp = new int[len];
        for (int i=0; i<len ; i++) {
            int pos = (i+k) % len;
            temp[pos] = nums[i];
        }
        nums = Arrays.copyOf(temp, temp.length);
    }
    public static void main(String[] args) {
        RotateArray r = new RotateArray();
        int[] nums = {1,2};
        int k = 1;
        r.rotate(nums,k);
    }
}
