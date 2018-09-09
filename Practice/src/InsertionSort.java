import java.util.Arrays;

public class InsertionSort {

    private int[] insertionSort(int[] nums) {
        for (int i=1;i<nums.length;i++){
            int index = i;
            int val = nums[i];
            while (index>0 && nums[index-1] > nums[index]) {
                nums[index] = nums[index-1];
                index = index-1;
            }
            nums[index] = val;
        }

        return nums;
    }

    public static void main(String[] args) {
        InsertionSort s = new InsertionSort();
        int[] nums = {2,1,3,6,4,8,5,7};
        System.out.println(Arrays.toString(s.insertionSort(nums)));
    }
}
