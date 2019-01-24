package Medium;

import java.util.*;
public class DesignPhoneDirectory {

        /** Initialize your data structure here
         @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
        Set<Integer> used = new HashSet<Integer>();
        Queue<Integer> available = new LinkedList<Integer>();
        int max;
        public DesignPhoneDirectory(int maxNumbers) {
            max = maxNumbers;
            for (int i = 0; i < maxNumbers; i++) {
                available.offer(i);
            }
        }

        public int get() {
            Integer ret = available.poll();
            if (ret == null) {
                return -1;
            }
            used.add(ret);
            return ret;
        }

        public boolean check(int number) {
            if (number >= max || number < 0) {
                return false;
            }
            return !used.contains(number);
        }

        public void release(int number) {
            if (used.remove(number)) {
                available.offer(number);
            }
        }

    public static void main(String[] args) {
        // Init a phone directory containing a total of 3 numbers: 0, 1, and 2.
        DesignPhoneDirectory directory = new DesignPhoneDirectory(3);

// It can return any available phone number. Here we assume it returns 0.
        directory.get();

// Assume it returns 1.
        directory.get();

// The number 2 is available, so return true.
        directory.check(2);

// It returns 2, the only number that is left.
        directory.get();

// The number 2 is no longer available, so return false.
        directory.check(2);

// Release number 2 back to the pool.
        directory.release(2);

// Number 2 is available again, return true.
        directory.check(2);
    }
}



