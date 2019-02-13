package Hard;

import java.util.*;

public class AlienDictionary {
    public String alienOrder(String[] words) {
        if (words.length == 0) return "";
        StringBuilder result = new StringBuilder();

        HashMap<Character, Set<Character>> graph = new HashMap<>();
        HashMap<Character, Integer> inDegree = new HashMap<>();
        for (String word: words) {
            for (char c: word.toCharArray()) {
                inDegree.putIfAbsent(c, 0);
            }
        }
        for (int i=0;i<words.length-1;i++) {
            String curWord = words[i];
            String nextWord = words[i+1];
            int minlen = Math.min(curWord.length(), nextWord.length());
            for (int j=0;j<minlen;j++) {
                char c1 =  curWord.charAt(j), c2 = nextWord.charAt(j);
                if (c1 != c2) {
                    graph.putIfAbsent(c1, new HashSet<>());
                    Set<Character> st = graph.get(c1);
                    if (!st.contains(c2)) {
                        st.add(c2);
                        graph.put(c1,st);
                        inDegree.put(c2, inDegree.getOrDefault(c2,0)+1);
                    }
                    break; // compare only the first characters that are different
                }
            }
        }
        System.out.println(inDegree);
        System.out.println(graph);
        Queue<Character> queue = new LinkedList<>();
        for (char key: inDegree.keySet()) {
            if (inDegree.get(key) == 0) {
                queue.offer(key);
            }
        }


        while (!queue.isEmpty()) {
            char cur = queue.poll();
            result.append(cur);
            if (graph.containsKey(cur)) {
                for (char next: graph.get(cur)) {
                    inDegree.put(next, inDegree.get(next)-1);
                    if (inDegree.get(next) == 0) {
                        queue.offer(next);
                    }
                }
            }
        }
        System.out.println(result);
        if (result.length() == inDegree.size()) return result.toString();
        return "";
    }

    public static void main(String[] args) {
        AlienDictionary d = new AlienDictionary();
        String[] words  = {"za","zb","ca","cb"};
        System.out.println(d.alienOrder(words));
    }
}
