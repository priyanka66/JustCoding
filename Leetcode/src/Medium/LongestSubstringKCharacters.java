package Medium;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringKCharacters {
    private int longestSubstring(String s, int k) {
        if (s.length() ==0 || s == null) return 0;
        if (k == 0) return 0;
        if (k == 1) return 1;
        int sum=0;
        HashMap<Character, Integer> hmap = new HashMap<>();
        for (int i=0; i<s.length();i++) {
            if (hmap.containsKey(s.charAt(i))) {
                hmap.put(s.charAt(i), hmap.get(s.charAt(i))+1);
            } else {
                hmap.put(s.charAt(i), 1);
            }
        }
        for (Map.Entry<Character, Integer> entry: hmap.entrySet()) {
            if (entry.getValue() >= k) {
                sum += entry.getValue();
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        String s = "ababacb";
        LongestSubstringKCharacters l = new LongestSubstringKCharacters();
        int k =3;
        System.out.println(l.longestSubstring(s,k));
    }
}
