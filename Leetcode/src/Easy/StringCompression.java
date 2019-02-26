
package Easy;

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

    public int compressV1(char[] chars) {
        int count=1;
        StringBuilder result = new StringBuilder();
        for (int i=0;i<chars.length-1;i++) {
            if (chars[i] == chars[i+1]) count++;
            else {
                if (count > 1) {
                    result.append(chars[i]).append(count);
                    count = 1;
                } else result.append(chars[i]);
            }
        }

        if (count > 1) {
            result.append(chars[chars.length-1]).append(count);
            count = 1;
        } else result.append(chars[chars.length-1]);

        System.out.println(result.toString());
        return result.length();
    }


    public static void main(String[] args) {
        StringCompression s = new StringCompression();
        char[] chars = {'a','b', 'b', 'b', 'b','b','b','b','b', 'b', 'b', 'b','b','b','b','c','c'};
        System.out.println(s.compress(chars));
        char[] chars1 = {'a','b', 'b', 'b', 'b','b','b','b','b', 'b', 'b', 'b','b','b','b','c','c'};
        System.out.println(s.compressV1(chars1));

    }
}
