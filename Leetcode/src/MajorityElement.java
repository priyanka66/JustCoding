import java.util.HashMap;

public class MajorityElement {

    private int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        if (nums.length == 1) return nums[0];
        int result = 0;
        for (int num: nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num)+1);
                if (map.get(num) > Math.floor(nums.length/2)) {
                    result = num;
                    break;
                }
            }
        }

        return result;
    }

    private int majorityElementByVoting(int[] nums) {
        int majIndex = 0;
        int count = 1;
        for (int i=1; i<nums.length; i++) {
            if (nums[i] ==  nums[majIndex]) {
                count++;
            } else {
                count --;
            }
            if (count == 0) {
                majIndex = i;
                count = 1;

                continue;
            }
        }

        if (count > 0) {
            count = 0;
            for (int num: nums) {
                if (nums[majIndex] == num) count++;
            }
        }

        return count > (nums.length/2) ?  nums[majIndex] : -1;
    }

    public static void main(String[] args) {
        MajorityElement m1 = new MajorityElement();
        int nums[] = {2,1,2,4,7};
//        System.out.println("MajorityElement " + m1.majorityElement(nums));
        System.out.println("MajorityElement " + m1.majorityElementByVoting(nums));




    }
}
