package Medium;

import java.util.HashMap;

public class PermutationInString {

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
       HashMap<Character, Integer> hmap =  new HashMap<>();
       for (char c:s1.toCharArray()) {
           hmap.put(c, hmap.getOrDefault(c,0)+1);
       }
       int len=hmap.size(), left=0, right=0;
       while (right < s2.length()) {
           char c = s2.charAt(right);
           if (hmap.containsKey(c)) {
               hmap.put(c, hmap.get(c)-1);
               if (hmap.get(c) == 0) len--;
           }
           while (len == 0) {
               if (right-left+1 == s1.length()) return true;
               c = s2.charAt(left);
               if (hmap.containsKey(c)) {
                   hmap.put(c, hmap.get(c)+1);
                   if (hmap.get(c) > 0) len++;
               }
               left++;
           }
           right++;
       }
        return false;
    }

    public static void main(String[] args) {
        PermutationInString p = new PermutationInString();
        String s1 = "adc", s2 = "dcda";
        System.out.println(p.checkInclusion(s1,s2));

    }
}
