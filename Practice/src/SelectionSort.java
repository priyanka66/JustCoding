import java.util.Arrays;

public class SelectionSort {

    private int[] selectionSort(int[] nums) {
        for (int i=0;i<nums.length;i++) {
            int min = i;
            for (int j=i+1;j<nums.length;j++) {
                if (nums[j] < nums[min]) {
                    min = j;
                }
            }

            int temp = nums[i];
            nums[i] = nums[min];
            nums[min] = temp;
        }

        return nums;
    }

    public static void main(String[] args) {
        SelectionSort s = new SelectionSort();
        int[] nums = {2,1,3,6,4,8,5,7};
        System.out.println(Arrays.toString(s.selectionSort(nums)));
    }
}
