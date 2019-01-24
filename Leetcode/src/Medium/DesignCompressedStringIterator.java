package Medium;

import java.util.LinkedList;
import java.util.Queue;

public class DesignCompressedStringIterator {
    Queue<int[]> queue;
    public DesignCompressedStringIterator(String s) {
        queue = new LinkedList<int[]>();
        int i=0,j=0;
        while (i<s.length()) {
            j=i+1;
            while (j<s.length() && s.charAt(j)-'A' < 0) j++;
            queue.add(new int[]{s.charAt(i)-'A', Integer.parseInt(s.substring(i+1,j))});
            i=j;
        }
    }


    public char next() {
        if (hasNext()) {
            int[] val = queue.peek();
            if (val[1]-1 == 0)  queue.poll();
            else {
                queue.peek()[1] = queue.peek()[1]-1;
            }
            return (char)(val[0]+'A');
        } else {
            return ' ';
        }
    }

    public boolean hasNext() {
        return !queue.isEmpty();
    }

    public static void main(String[] args) {
        DesignCompressedStringIterator iterator = new DesignCompressedStringIterator("L1e2t1C1o1d1e1");

        System.out.println(iterator.next()); // return 'L'
        System.out.println(iterator.next()); // return 'e'
        System.out.println(iterator.next()); // return 'e'
        System.out.println(iterator.next()); // return 't'
        System.out.println(iterator.next()); // return 'C'
        System.out.println(iterator.next()); // return 'o'
        System.out.println(iterator.next()); // return 'd'
        System.out.println(iterator.hasNext()); // return true
        System.out.println(iterator.next()); // return 'e'
        System.out.println(iterator.hasNext()); // return false
        System.out.println(iterator.next()); // return ' '
    }
}
