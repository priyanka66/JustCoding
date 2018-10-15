package Medium;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if (nums.length == 0) return result;
        generateSubsets(result, new ArrayList<>(), nums, 0);

        return result;
    }

    public void generateSubsets(List<List<Integer>> result, List<Integer> temp, int[] nums, int start) {
        result.add(new ArrayList<>(temp));
        for (int i = start;i<nums.length;i++) {
            temp.add(nums[i]);
            generateSubsets(result, temp, nums, i+1);
            temp.remove(temp.size()-1);
        }
    }

    public static void main(String[] args) {
        Subsets s = new Subsets();
        int[] nums = {1,2,3};
        System.out.println(s.subsets(nums));

    }
}
