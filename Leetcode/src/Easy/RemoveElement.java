package Easy;

import java.lang.reflect.Array;
import java.util.Arrays;

public class RemoveElement {

    public static int removeElement(int[] nums, int val){
        int count = 0;
        int i ;
        if (nums.length == 0) return 0;
        for (i =0; i< nums.length; i++){
            if (nums[i] != val) {
                nums[count++] = nums[i];
            }
        }

        System.out.println(Arrays.toString(nums));
        return count;
    }

    public static int[] removeElementV2(int[] nums, int val) {
        int index = 0;
        for (int i=0;i<nums.length;i++) {
            if (nums[i] != val) nums[index++] = nums[i];
        }

        return Arrays.copyOf(nums, index-1);

    }
    public static void main(String[] args) {
        int[] nums = {3,2,2,3};
        int val = 3;
        int result = removeElement(nums, val);
        System.out.println("The new length " + result);
        System.out.println(Arrays.toString(removeElementV2(nums, val)));
    }
}
