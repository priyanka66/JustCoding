public class RemoveDuplicates {

    public static int removeDuplicate(int[] nums){
        int i;
        int count = 0;
        if (nums.length == 0) {
            return 0;
        }
        for (i=0; i< nums.length - 1; i++) {
            if (nums[i] != nums[i+1]) {
                nums[count++] = nums[i];
            }
        }

        nums[count++] = nums[i];
        return count;
    }
    public static void main(String[] args) {
        int[] nums = {1,1,2};
        int result = removeDuplicate(nums);
        System.out.println("The new length " + result);
    }
}
