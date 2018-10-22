package Medium;

import java.util.ArrayList;
import java.util.List;

public class Permutations {


    List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length ==0) return result;
        getPermutation(result, nums, 0);

        return result;
    }

    public void getPermutation(List<List<Integer>> result, int[] nums, int index) {
        if (index == nums.length) {
            List<Integer> res1 = new ArrayList<>();
            for (int num : nums) {
                res1.add(num);
            }
            result.add(res1);
        }

        for (int i =index; i<nums.length;i++) {
            swap(index, i, nums);
            getPermutation(result, nums, index+1);
            swap(index, i, nums);
        }
    }

    public void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    private  List<List<Integer>> permuteBackTrack(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        backTrack(result, temp, nums);
        return result;
    }

    void backTrack(List<List<Integer>> result,List<Integer> temp, int[] nums) {
        if (temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        } else {
            for (int i=0;i<nums.length;i++) {
                if (temp.contains(nums[i])) continue;
                temp.add(nums[i]);
                backTrack(result, temp, nums);
                temp.remove(temp.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        Permutations p = new Permutations();
        int[] nums = {1,2,3};
        List<List<Integer>> result = p.permute(nums);
        System.out.println(result);

        result = p.permuteBackTrack(nums);
        System.out.println(result);


    }
}
