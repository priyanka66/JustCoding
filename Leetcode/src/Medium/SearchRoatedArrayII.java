package Medium;

public class SearchRoatedArrayII {

    public boolean search(int[] nums, int target) {
        if (nums.length == 0) return false;
        int start = 0, end = nums.length - 1, mid = 0;
        while (start <= end) {
            mid = (start + end) / 2;
            if (nums[mid] == target) return true;
            if (nums[mid] == nums[start]) start++;
            else if (nums[start] < nums[mid]) {
                if (target >= nums[start] && target < nums[mid]) end = mid - 1;
                else start = mid + 1;
            } else {
                if (target > nums[mid] && target <= nums[end]) start = mid + 1;
                else end = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SearchRoatedArrayII s = new SearchRoatedArrayII();
        int nums[] = {3,1}; //{5,6,7,0,1,2,3};

        int target = 1;
        System.out.println(s.search(nums,target));
    }

}
