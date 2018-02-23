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
    public static void main(String[] args) {
        String s = "Hello World";
        System.out.println("The length of last word is " + lengthLastWord(s));
    }
}
