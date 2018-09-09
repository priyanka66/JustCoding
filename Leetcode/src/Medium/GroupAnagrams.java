package Medium;

import java.util.*;

public class GroupAnagrams {

    private List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>();
        if (strs.length == 0) return result;
        HashMap<String, List<String>> anagrams = new LinkedHashMap<>();
        for (int i=0;i<strs.length;i++) {
            char[] str = strs[i].toCharArray();
            Arrays.sort(str);
            if (anagrams.containsKey(String.valueOf(str))) {
                List<String> temp = anagrams.get(String.valueOf(str));
                temp.add(strs[i]);
                anagrams.put(String.valueOf(str), temp);
            }
            else {
                List<String> temp = new ArrayList<>();
                temp.add(strs[i]);
                System.out.println((str));
                anagrams.put(String.valueOf(str), temp);
            }
        }

        for (List<String> str : anagrams.values()) {
            result.add(str);
        }

        return result;
    }
    public static void main(String[] args) {
        GroupAnagrams a = new GroupAnagrams();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(a.groupAnagrams(strs));
    }
}
