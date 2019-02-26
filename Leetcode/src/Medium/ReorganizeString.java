package Medium;

import java.util.HashMap;
import java.util.*;

public class ReorganizeString {

    public String reorganizeString(String S) {
        if (S.length() == 0 || S == null) return "";
        StringBuilder result = new StringBuilder();
        HashMap<Character, Integer> hmap = new HashMap<>();
        for (char c: S.toCharArray()) {
            int count  = hmap.getOrDefault(c, 0)+1;
            if (count > (S.length()+1)/2) return "";
            hmap.put(c, count);
        }

        PriorityQueue<Map.Entry<Character, Integer>> queue = new PriorityQueue<>(
                (a,b)->b.getValue()-a.getValue());
        queue.addAll(hmap.entrySet());

        while (!queue.isEmpty()) {
            Map.Entry<Character, Integer> e1 = queue.poll();
            if (result.length() == 0 || result.charAt(result.length()-1) != e1.getKey()) {
                result.append(e1.getKey());
                e1.setValue(e1.getValue()-1);
                if (e1.getValue() > 0) queue.add(e1);
            } else {
                Map.Entry<Character, Integer> e2 = queue.poll();
                result.append(e2.getKey());
                e2.setValue(e2.getValue()-1);
                if (e2.getValue() > 0) queue.add(e2);
                queue.add(e1);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        ReorganizeString r = new ReorganizeString();
        System.out.println(r.reorganizeString("aab"));
    }
}
