package Medium;

import java.util.*;

public class Insert_Delete_GetRandom {
    List<Integer> nums;
    HashMap<Integer, Integer> hmap;
    Random rand;

    Insert_Delete_GetRandom() {
        nums = new ArrayList<>();
        hmap = new LinkedHashMap<>();
        rand = new Random();
    }

    public boolean insert(int val) {
        if (hmap.containsKey(val)) return false;
        hmap.put(val, nums.size());
        nums.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!hmap.containsKey(val)) return false;
        int pos = hmap.get(val);
        if (pos < nums.size()-1) {
            int lastVal = nums.get(nums.size()-1);
            hmap.put(lastVal, pos);
            nums.set(pos, lastVal);
        }
        hmap.remove(val);
        nums.remove(nums.size()-1);
        return true;
    }

    public int getRandom() {
        return nums.get(rand.nextInt(nums.size()));
    }
    public static void main(String[] args) {
        Insert_Delete_GetRandom i = new Insert_Delete_GetRandom();
        System.out.println(i.insert(1));
        System.out.println(i.remove(2));
        System.out.println(i.insert(2));
        System.out.println(i.getRandom());
        System.out.println(i.remove(1));
        System.out.println(i.insert(2));
        System.out.println(i.getRandom());

    }
}
