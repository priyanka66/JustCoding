import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {

        int[] nums = {3,2,4};
        int target = 6;
        int[] result = findTwoSum2(nums, target);

        System.out.println(Arrays.toString(result));

        result = findTwoSum(nums, target);

        System.out.println(Arrays.toString(result));
    }

    static int[] findTwoSum2 (int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int i;
        for (i=0; i<nums.length; i++ ) {
            if (map.containsKey(target-nums[i])){
                result[0] = map.get(target-nums[i]);
                result[1] = i;
                return result;
            }

            map.put(nums[i], i);
        }
        return result;
    }
    static int[] findTwoSum(int[] nums, int target) {
        int[] result = new int[2];
        l1:    for (int i=0; i<nums.length; i++) {
            for (int j=i+1; j<nums.length;j++){
                if (nums[i] + nums[j] == target) {
                    result[0]=i+1;
                    result[1]=j+1;
                    break l1;
                }
            }
        }

        return result;
    }
}
