package Medium;

import java.util.*;

public class LargestNumber {
    String largestNumber(int[] nums) {
        String[] s = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            s[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(s, new Comparator<String>(){
            public int compare(String A, String B){
                String AB = A + B;
                String BA = B + A;
                return AB.compareTo(BA)>0 ? -1:1;
            }
        });
        if(s[0].equals("0")) return "0";
        String res = new String();
        for (int i = 0; i < nums.length; i++)
            res = res + s[i];

        return res;


    }

    public static void main(String[] args) {
        int[] nums = {3,30,34,5,9};
        LargestNumber l = new LargestNumber();
        System.out.print(l.largestNumber(nums));
    }
}
