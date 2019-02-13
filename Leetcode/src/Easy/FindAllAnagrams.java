package Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagrams {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int[] anagram = new int[52];
        for (char c: p.toCharArray()) {
            anagram[c-'a']++;
        }
        int right=0, left=0, len=0;
        while (right < s.length()) {
            if (anagram[s.charAt(right)-'a'] > 0) {
                anagram[s.charAt(right)-'a']--;
                right++;
                len++;
            } else {
                anagram[s.charAt(left)-'a']++;
                left++;
                len--;
            }
            if (len == p.length()) result.add(left);
        }

        return result;
    }

    public static void main(String[] args) {
        String s =  "abab";
        String p = "ab";
        FindAllAnagrams a = new FindAllAnagrams();
        System.out.println(a.findAnagrams(s, p));
    }
}
