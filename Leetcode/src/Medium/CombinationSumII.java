package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum2(result, temp, candidates, target, 0);
        return result;
    }

    void combinationSum2(List<List<Integer>> result,List<Integer> temp, int[] candidates, int target, int start) {
        if (target < 0) return;
        if (target == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i=start;i<candidates.length;i++) {
            if (i>start && candidates[i] == candidates[i-1]) continue;
            temp.add(candidates[i]);
            combinationSum2(result, temp, candidates, target-candidates[i], i+1);
            temp.remove(temp.size()-1);
        }
    }

    public static void main(String[] args) {
        CombinationSumII s = new CombinationSumII();
        int[] nums = {10,1,2,7,6,1,5};
        int target =  8;
        System.out.println(s.combinationSum2(nums, target));
    }
}
