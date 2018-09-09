package Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class RandomizedSet {

    HashMap<Integer,Integer> hmap ;
    List<Integer> list;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        hmap = new HashMap<Integer,Integer>();
        list = new ArrayList<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (hmap.containsKey(val)) return false;
        hmap.put(val, 1);
        list.add(val);

        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        boolean contain = hmap.containsKey(val);
        if ( ! contain ) return false;
        int loc = hmap.get(val);
        if (loc < list.size() - 1 ) { // not the last one than swap the last one with this val
            int lastone = list.get(list.size() - 1 );
            System.out.println(list);
            list.set( loc , lastone );
            System.out.println(list);
            hmap.put(lastone, loc);
        }

        hmap.remove(val);
        list.remove(list.size() - 1);

        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        Random random = new Random();
        return list.get(random.nextInt(list.size()));
    }

    public static void main(String[] args) {
        RandomizedSet r = new RandomizedSet();
        r.insert(-1);
        r.insert(-2);
        r.insert(-3);
        r.insert(-4);

        r.remove(-2);


//        r.insert(-2);
//
//        System.out.println(r.getRandom());
//        r.remove(-1);
//////        r.insert(3);
//        r.insert(-2);
////
//        System.out.println(r.getRandom());
    }
}
