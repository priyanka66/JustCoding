package Easy;

import java.util.Arrays;

public class LastWord {

    static int lengthLastWord(String s) {
        int length;
        if(s.trim().length() == 0) return 0;
        if (s.trim().length() == 1) return 1;
        String[] str = s.split(" ");
        length = str[str.length -1].length();

        return length;
    }

    static int lengthLastWordV1(String s) {
        int length=0;
        for (int i=s.length()-1;i>=0;i--) {
            if (s.charAt(i) ==' ') {
                if(length == 0) continue;
                else break;
            }
            length++;
        }

        return length;
    }
    public static void main(String[] args) {
        String s = "Hello World";
        System.out.println("The length of last word is " + lengthLastWord(s));
        System.out.print(lengthLastWordV1(s));
    }
}
