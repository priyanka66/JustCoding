import java.util.*;

public class FirstUniqueCharacter {

    private int firstUniqChar(String s) {
        Set<Character> st = new HashSet<>();
        HashMap<Character, Integer> hmap = new LinkedHashMap<>();
        for (int i=0;i<s.length();i++) {
            if(st.contains(s.charAt(i))) {
                if(hmap.containsKey(s.charAt(i))) hmap.remove(s.charAt(i));
            } else {
                st.add(s.charAt(i));
                hmap.put(s.charAt(i), i);
            }
        }
        for(HashMap.Entry<Character,Integer> entry :hmap.entrySet()) {
            return entry.getValue();
        }
        return -1;
    }

    private int firstUniqCharV2(String s) {
        int[] uniq = new int[26];
        for(int i=0;i<s.length();i++) {
            uniq[s.charAt(i)-'a']++;
        }
        for (int i=0;i<s.length();i++) {
           if(uniq[s.charAt(i)-'a'] == 1) return i;
        }

        return -1;
    }
    public static void main(String[] args) {
        FirstUniqueCharacter f = new FirstUniqueCharacter();
        String s = "aadadaad";
        System.out.println(f.firstUniqChar(s));
        System.out.println(f.firstUniqCharV2(s));

    }
}
