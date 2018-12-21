package Medium;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {

    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums.length == 0) return result;
        if(nums.length==1){
            result.add(String.valueOf(nums[0]));
            return result;
        }
        for (int i=0;i<nums.length;i++) {
            int val = nums[i];
            while (i+1 < nums.length && nums[i+1]-nums[i] == 1)
                i++;
            if (val != nums[i])
               result.add(String.valueOf(val) +"->" + String.valueOf(nums[i]));
            else
                result.add(String.valueOf(val));
        }

        return result;
    }

    public static void main(String[] args) {
        SummaryRanges r = new SummaryRanges();
        int[] nums = {0,1,2,4,5,7};
        System.out.println(r.summaryRanges(nums));
    }
}
