import java.util.Arrays;

public class BubbleSort {

    private int[] bubbleSort(int[] nums) {
        for(int i=0;i<nums.length; i++){
            for (int j=0;j<nums.length-i-1;j++) {
                if (nums[j]>nums[j+1]) {
                    int temp = nums[j+1];
                    nums[j+1] = nums[j];
                    nums[j] = temp;
                }
            }
        }

        return  nums;
    }

    public static void main(String[] args) {
        BubbleSort s = new BubbleSort();
        int[] nums = {2,1,3,6,4,8,5,7};
        System.out.println(Arrays.toString(s.bubbleSort(nums)));
    }
}
