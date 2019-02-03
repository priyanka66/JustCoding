package Medium;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class SubarraySumEqualsK {

    public int subarraySum(int[] nums, int k) {
        if (nums.length == 0) return 0;
        HashMap<Integer, Integer> hmap = new LinkedHashMap<>();
        int sum=0,ans=0;
        hmap.put(0,1);
        for (int num:nums) {
            sum += num;
            int target = sum - k;
            if (hmap.containsKey(target)) {
                ans += hmap.get(target);
            }

            hmap.put(sum, hmap.getOrDefault(sum,0)+1);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1};
        int k=2;
        SubarraySumEqualsK s = new SubarraySumEqualsK();
        System.out.println(s.subarraySum(nums,k));
    }
}
