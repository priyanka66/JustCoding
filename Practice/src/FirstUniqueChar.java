import java.util.HashMap;
import java.util.LinkedHashMap;

public class FirstUniqueChar {

    private int firstUniqChar(String s) {
        int[] uni = new int[26];
        for (int i =0;i<s.length();i++)
            uni[s.charAt(i)-'a'] ++;
        for (int i =0;i<s.length();i++) {
            if (uni[s.charAt(i)-'a'] == 1) return i;
        }

        return -1;
    }

//    private int firstUniqChar1(String s) {
//        HashMap<Character, Integer> uniq = new LinkedHashMap<>();
//        for (int i=0;i<s.length();i++){
//            if (uniq.containsKey(s.charAt(i))) {
//                uniq.put(s.charAt(i), uniq.get(s.charAt(i))+1);
//            } else {
//                uniq.put(s.charAt(i),1);
//            }
//        }
//
//        for (Integer val : uniq.values()) {
//            if (val == 1)
//        }
//    }

    public static void main(String[] args) {
        FirstUniqueChar f = new FirstUniqueChar();
        String s = "loveleetcode";
        System.out.println(f.firstUniqChar(s));
//        System.out.println(f.firstUniqChar1(s));

    }
}
