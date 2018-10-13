package Medium;

import java.util.Arrays;

public class NextInt {
    public static void main(String[] args) {
        String line = "206155";
        char[] first  = line.toCharArray();
        Arrays.sort(first);
        for (int i=Integer.parseInt(line)+1;;i++) {
            String s = String.valueOf(i);
            char[] next = s.toCharArray();
            Arrays.sort(next);
            char[] nextTemp = new char[first.length];
            nextTemp = Arrays.copyOfRange(next,next.length-first.length, next.length);
            if (Arrays.equals(first, nextTemp)) {
                System.out.println(i);
                break;
            }

        }

    }
}
