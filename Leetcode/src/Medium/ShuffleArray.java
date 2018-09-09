package Medium;

import java.util.Arrays;
import java.util.Random;

public class ShuffleArray {

    private int[] nums ;
    private Random random = new Random();
    public ShuffleArray(int[] nums) {
        this.nums = nums;
    }

    public int[] reset() {

        return nums;
    }

    public int[] shuffle() {
        if (nums.length == 0 ) return null;
        int[] a = nums.clone();
        for (int i = 0; i<nums.length;i++) {
            int j = random.nextInt(i+1);
            swap(a,i,j);
        }

        return a;
    }

    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args ){
        int[] nums = {1,2,3};
        ShuffleArray s = new ShuffleArray(nums);
        System.out.println(Arrays.toString(s.shuffle()));
        System.out.println(Arrays.toString(s.reset()));
    }
}
