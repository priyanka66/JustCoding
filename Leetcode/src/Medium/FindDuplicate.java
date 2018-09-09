package Medium;



public class FindDuplicate {

    private int findDuplicate(int[] nums) {
        if (nums.length == 0) return -1;
        for (int i =0; i<nums.length; i++) {
            if (nums[Math.abs(nums[i])] >=0 ) {
                nums[Math.abs(nums[i])] = - nums[Math.abs(nums[i])];
            } else {
                return -nums[i];
            }
        }
        return -1;
    }

    private int findDuplicateV2(int[] nums) {
        if (nums.length == 0) return -1;
        int slow = 0;
        int fast = 0;

        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while(slow != fast);

        int find = 0;

        System.out.println(nums[slow]);

        System.out.println(nums[fast]);

        while(find != slow){
            slow = nums[slow];
            find = nums[find];
        }
        return find;

    }
    public static void main(String[] args) {
        FindDuplicate d = new FindDuplicate();
        int[] nums = {1,3,4,2,2};
        System.out.println(d.findDuplicate(nums));
        int[] nums1 = {1,3,4,2,2};
        System.out.println(d.findDuplicateV2(nums1));

    }
}
