package Medium;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesinArray {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<nums.length;i++) {
            if (nums[Math.abs(nums[i])-1] < 0) {
                result.add(Math.abs(nums[i]));
            } else {
                nums[Math.abs(nums[i])-1] = -nums[Math.abs(nums[i])-1];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        FindAllDuplicatesinArray d = new FindAllDuplicatesinArray();
        int[] nums = {4,3,2,7,8,2,3,1};
        System.out.println(d.findDuplicates(nums));
    }
}
