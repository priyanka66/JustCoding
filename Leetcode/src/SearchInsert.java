public class SearchInsert {

    static int searchInsert(int[] nums, int target) {
        int index =0 ;
        int flag = 0;
        int i = 0;
        for (i=0; i<nums.length;i++) {
            if(nums[i] == target) {
                index = i;
                flag =1;
                break;
            } else if (nums[i] > target) {
                index = i;
                flag =1;
                break;
            }
        }
        if (flag ==0  && index==0) {
            if (target > nums[i-1]) index = i;
        }

        return index;
    }
    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int target = 0;
        int result = searchInsert(nums, target);
        System.out.println(result);

    }
}
