package Easy;

import java.util.*;

public class MostCommonWord {

    String mostCommonWord(String paragraph, String[] banned) {
        HashMap<String, Integer> hmap = new HashMap<>();
        int max=0, freq=0;
        String result = new String();
        Set<String> bannedSet = new HashSet<>();
        for(String s : banned) {
            bannedSet.add(s);
        }

        int i=0;
        while (i<paragraph.length()) {
            if (!Character.isLetter(paragraph.charAt(i))) {
                i++;
                continue;
            }
            int j=i+1;
            while (j<paragraph.length() && Character.isLetter(paragraph.charAt(j))) {
                j++;
            }
            String word = paragraph.substring(i,j).toLowerCase();
            if (bannedSet.contains(word)) {
                i=j;
                continue;
            }
            freq = hmap.getOrDefault(word,0) + 1;
            hmap.put(word, freq);
            if (freq > max) {
                max=freq;
                result = word;
            }
            i=j;
        }

        return result;
    }
    public static void main(String[] args) {
        MostCommonWord w = new MostCommonWord();
        String paragraph="Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = {"poll"};
        System.out.println(w.mostCommonWord(paragraph, banned));

    }
}
