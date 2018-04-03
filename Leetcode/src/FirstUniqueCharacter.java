import java.util.*;

public class FirstUniqueCharacter {

    int firstUniqChar(String s) {
        Set<Character> st = new HashSet<>();
        HashMap<Character, Integer> hmap = new LinkedHashMap<>();
        for(int i=0; i<s.length(); i++){
            if(st.contains(s.charAt(i))) {
                if(hmap.get(s.charAt(i)) != null) {
                    hmap.remove(s.charAt(i));
                }
            } else {
                st.add(s.charAt(i));
                hmap.put(s.charAt(i), i);
            }
        }
        if (hmap.size() == 0) return -1;
        else return hmap.entrySet().iterator().next().getValue();
    }

    int firstUniqCharV2(String s) {
        int freq[] = new int[26];
        for (int i=0; i< s.length();i++)
            freq[s.charAt(i) -'a'] ++ ;
        for (int i=0; i<s.length();i++) {
            if (freq[s.charAt(i) - 'a'] ==1) return i;
        }
        return -1;
    }
    public static void main(String[] args) {
        FirstUniqueCharacter f = new FirstUniqueCharacter();
        String s = "lleetcode";
        System.out.println(f.firstUniqChar(s));
        System.out.println(f.firstUniqCharV2(s));

    }
}
