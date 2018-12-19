package Medium;

public class SearchRoatedArray {

    private int search(int[] nums, int target) {
        int start = 0, end=nums.length-1, mid=0;
        while (start<=end){
            mid=(start+(end))/2;
            if (nums[mid] == target) return mid;
            if (nums[start] <= nums[mid]) {
                if (target <= nums[mid] && target >= nums[start]) end = mid-1;
                else start = mid+1;
            } else {
                if (target >= nums[mid] && target <= nums[end])  start = mid+1;
                else end = mid-1;

            }
        }

        return -1;
    }
    public static void main(String[] args) {
        SearchRoatedArray s = new SearchRoatedArray();
        int nums[] = {5,6,7,0,1,2,3};
        int target = 7;
        System.out.println(s.search(nums,target));
    }
}
