import java.util.*;

public class CheckDuplicatesInArray {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> dup = new HashSet<Integer>();
        for(int num:nums) {
            if(dup.contains(num)) return true;
            dup.add(num);
        }
         return false;
    }

    // any value appears atleast twice
    public boolean containsDuplicateV2(int[] nums) {
        Arrays.sort(nums);
        for(int i=0;i<nums.length-1;i++) {
            if (nums[i] == nums[i+1]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CheckDuplicatesInArray c1 = new CheckDuplicatesInArray();
        int[] nums = {1,3,2,4,5, 2};
        if (c1.containsDuplicate(nums)) System.out.println("Yes");
        else System.out.println("NO");
        System.out.println(c1.containsDuplicateV2(nums));
    }
}
