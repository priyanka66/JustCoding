package Easy;

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

    private static int searchInsertV2(int [] nums, int target) {
        int start = 0, end = nums.length;
        while (start < end) {
            int mid  = (start+end)/2;
            if (nums[mid] > target) {
                end = mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return start;
    }

    private static int searchInsertV3(int [] nums, int target) {
        int i=0, j=nums.length;
        while (i<j) {
            if (target > nums[i]) i++;
            else break;
        }

        return i;
    }
    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int target = 7;
        System.out.println(searchInsert(nums, target));

        System.out.println(searchInsertV2(nums, target));
        System.out.println(searchInsertV3(nums, target));

    }
}
