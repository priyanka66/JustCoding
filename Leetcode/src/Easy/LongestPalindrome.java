package Easy;

import java.lang.reflect.Array;
import java.util.Arrays;

public class LongestPalindrome {
    public int longestPalindrome(String s) {
        if (s.length() == 0 || s == null) return 0;
        int length = 0;
        int[] chars = new int[60];
        for (int i=0;i<s.length();i++) {
            chars[s.charAt(i)-'A'] ++ ;
        }
        for (int i : chars) {
            if (i%2 == 0) {
                length+=i;
            } else {
                length += (i-1);
            }
        }

        return length < s.length() ? length+1: length;

    }

    public static void main(String[] args) {
        LongestPalindrome p = new LongestPalindrome();
        String s = "a";
        System.out.println(p.longestPalindrome(s));

    }
}
