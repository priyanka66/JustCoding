import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SingleNumber {

    int singleNumber(int[] nums) {
        Set<Integer> numberSet = new HashSet<Integer>();
        for (int i : nums) {
            if (!numberSet.add(i)) {
                numberSet.remove(i);
            }
        }
        Iterator<Integer> intInter = numberSet.iterator();
        return intInter.next();
    }
    public static void main(String[] args){
        SingleNumber s1 = new SingleNumber();
        int[] nums = {1,1,2,3,2};
        System.out.println(s1.singleNumber(nums));
    }
}
