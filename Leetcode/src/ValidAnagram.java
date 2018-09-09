import java.util.HashMap;

public class ValidAnagram {

    private boolean isAnagram(String s, String t) {
      if (s.length() != t.length()) return false;
      if (s == null && t == null) return true;
      int[] valid = new int[26];
      for (int i=0;i<s.length();i++) {
          valid[s.charAt(i)-'a']++;
          valid[t.charAt(i)-'a']--;
      }
      for(int num:valid) {
          if (num != 0) return false;
      }
      return true;
    }

    private boolean isAnagramV2(String s, String t) {
        if (s.length() != t.length()) return false;
        if (s == null && t == null) return true;
        HashMap<Character, Integer> anagram = new HashMap<Character, Integer>();
        for (int i=0;i<s.length();i++) {
            if(!anagram.containsKey(s.charAt(i))) {
                anagram.put(s.charAt(i),1);
            } else {
                anagram.put(s.charAt(i), anagram.get(s.charAt(i)) +1);
            }
        }

        for (int i=0; i<t.length();i++) {
            if(anagram.containsKey(t.charAt(i))) {
                if(anagram.get(t.charAt(i)) > 1) anagram.put(t.charAt(i), anagram.get(t.charAt(i))-1);
                else anagram.remove(t.charAt(i));
            } else return false;
        }
        if (anagram.isEmpty()) return true;

        return false;
    }

    public static void main(String[] args) {
        ValidAnagram v1 = new ValidAnagram();
        String s = "anagram";
        String t = "nagaram";
        if(v1.isAnagram(s, t)) System.out.println("Valid Anagram");
        else System.out.println("Not a Valid Anagram");
//        if(v1.isAnagramV2(s, t)) System.out.println("Valid Anagram");
//        else System.out.println("Not a Valid Anagram");
    }
}
