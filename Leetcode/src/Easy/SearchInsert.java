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
        int left = 0, right = nums.length;
        while (left < right) {
            int mid  = (left+right)/2;
            if (nums[mid] > target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return left;
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
        int result = searchInsert(nums, target);
        System.out.println(result);
        System.out.println(searchInsertV2(nums, target));
        System.out.println(searchInsertV3(nums, target));

    }
}
