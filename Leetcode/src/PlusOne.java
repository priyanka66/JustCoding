import java.util.Arrays;

public class PlusOne {

    public int[] plusOne(int[] nums) {
        int carry = 0;
        for(int i = nums.length-1;i>=0;i--) {
            if((nums[i]+1) >9) {
                nums[i] = 0;
                carry = 1;
            } else {
                nums[i] = nums[i] +1;
                carry = 0;
                break;
            }
        }
        if (carry == 1) {
            int[] res = new int[nums.length+1];
            res[0] = 1;
            for (int i=1;i<res.length;i++) {
                res[i] = nums[i-1];
            }

            return res;
        }
//        System.out.println(carry);
        return nums;
    }


    public static void main(String[] args) {
        PlusOne p1 = new PlusOne();
        int[] nums = {9,9};
        System.out.println(Arrays.toString(p1.plusOne(nums)));
    }
}
