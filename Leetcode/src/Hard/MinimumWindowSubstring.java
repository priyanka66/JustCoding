package Hard;

import java.util.HashMap;

public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        if (t.length() > s.length()) return "";
        HashMap<Character, Integer> hmap = new HashMap<>();
        for (char c:t.toCharArray()) {
            hmap.putIfAbsent(c, hmap.getOrDefault(c,0)+1);
        }
        int left = 0, right = 0, count = 0, minStart=0, minLength=Integer.MAX_VALUE;
        for (right =0;right<s.length();right++) {
            char c = s.charAt(right);
            if (hmap.containsKey(c)) {
                hmap.put(c, hmap.get(c)-1);
                if (hmap.get(c)>=0) count++;
            }

            while (count == t.length()) {
                if (right-left+1 < minLength) {
                    minLength = right-left+1;
                    minStart = left;
                }

                c = s.charAt(left);
                if (hmap.containsKey(c)) {
                    hmap.put(c, hmap.get(c)+1);
                    if (hmap.get(c) > 0) count--;
                }

                left++;
            }
        }
        if (minLength > s.length()) return "";
        return s.substring(minStart, minLength+minStart);

    }

    public static void main(String[] args) {
        MinimumWindowSubstring m = new MinimumWindowSubstring();
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(m.minWindow(s, t));
    }
}
