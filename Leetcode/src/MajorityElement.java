import java.util.HashMap;

public class MajorityElement {

    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
        int val = 0;
        for (int num : nums){
            if (!map.containsKey(num)){
                map.put(num,1);
            } else
                map.put(num, map.get(num)+1);
                if (map.get(num) > Math.floor(nums.length /2)) {
                    val = num;
                    break;
                }
        }

        return val;
    }

    // by voting method
    public int majorityElementByVoting(int[] nums) {
        int majIndex = 0, count = 1;
        for (int i =1 ; i<nums.length ; i++){
            if (nums[majIndex] == nums[i]){
                count++;
            }
            else {
                count-- ;
                if (count ==0){
                    majIndex = i;
                    count =1;
                }
            }
        }

        return nums[majIndex];
    }



    public static void main(String[] args) {
        MajorityElement m1 = new MajorityElement();
        int nums[] = {7,7,8,8,8};
        System.out.println("MajorityElement " + m1.majorityElement(nums));
        System.out.println("MajorityElement " + m1.majorityElementByVoting(nums));




    }
}
