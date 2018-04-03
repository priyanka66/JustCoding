import java.util.HashSet;
import java.util.Set;

public class CheckDuplicatesInArray {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i : nums) {
            if (set.contains(i)) return true;
            else set.add(i);
        }
        return false;
    }
    public static void main(String[] args) {
        CheckDuplicatesInArray c1 = new CheckDuplicatesInArray();
        int[] nums = {1,3,2,4,5};
        if (c1.containsDuplicate(nums)) System.out.println("Yes");
        else System.out.println("NO");
    }
}
