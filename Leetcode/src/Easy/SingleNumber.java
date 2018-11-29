package Easy;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SingleNumber {

    private int singleNumber(int[] nums) {
        int n = nums[0];
        for (int i =1; i<nums.length;i++) {
            n ^= nums[i];
        }
       return n;
//        Set<Integer> set = new HashSet<Integer>();
//        for (int i=0; i<nums.length; i++) {
//            if(!set.add(nums[i])) set.remove(nums[i]);
//        }
//        Iterator <Integer> it = set.iterator();
//        return it.next();


    }
    private  int singleNumberV2(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i=0; i<nums.length; i++) {
            if(!set.add(nums[i])) return nums[i];
        }
        Iterator<Integer> it = set.iterator();
        return  it.next();
    }

    public static void main(String[] args) {
        SingleNumber sn = new SingleNumber();
        int[] nums = {2,2,1};
        System.out.println(sn.singleNumber(nums));
        System.out.println(sn.singleNumberV2(nums));
    }
}
