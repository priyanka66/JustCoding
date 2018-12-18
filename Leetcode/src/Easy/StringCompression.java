package Easy;

import com.sun.jdi.CharType;

import java.lang.reflect.Array;
import java.util.Arrays;

public class StringCompression {

    public int compress(char[] chars) {
        int count=0, i=0, pos=0;
        while (i<chars.length) {
            char val = chars[i];
            count=0;
            while (i<chars.length && val == chars[i]) {
                i++;
                count++;
            }
            chars[pos++] = val;
            if(count != 1)
                for(char x : Integer.toString(count).toCharArray())
                    chars[pos++] = x;
        }
        System.out.println(Arrays.toString(chars));
        return pos;
    }

    public static void main(String[] args) {
        StringCompression s = new StringCompression();
        char[] chars = {'a','b', 'b', 'b', 'b','b','b','b','b', 'b', 'b', 'b','b','b','b'};
        System.out.println(s.compress(chars));

    }
}
