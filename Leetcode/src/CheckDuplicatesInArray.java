import java.util.HashSet;
import java.util.Set;

public class CheckDuplicatesInArray {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> dup = new HashSet<Integer>();
        for(int num:nums) {
            if(dup.contains(num)) return true;
            dup.add(num);
        }
         return false;
    }

    public boolean containsDuplicateV2(int[] nums) {
        Set<Integer> dup = new HashSet<>();
        for (int i : nums) {
            if (!dup.add(i)) return true;
        }

        return false;
    }

    public static void main(String[] args) {
        CheckDuplicatesInArray c1 = new CheckDuplicatesInArray();
        int[] nums = {1,3,2,4,5, 2};
        if (c1.containsDuplicate(nums)) System.out.println("Yes");
        else System.out.println("NO");
        System.out.println(c1.containsDuplicateV2(nums));
    }
}
