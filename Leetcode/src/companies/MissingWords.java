package companies;

import java.util.ArrayList;
import java.util.List;

public class MissingWords {
    public static void main(String[] args) {
        String s = "I am using HackerRank to improve programming";
        String t = "am HackerRank to improve";
        String[] sWords = s.split(" ");
        String[] tWords = t.split(" ");
        List<String> result = new ArrayList<>();
        int i=0, j=0;

        while (i < sWords.length && j< tWords.length ) {
            if (sWords[i].equals(tWords[j])) {
                i++;
                j++;
            } else {
                result.add(sWords[i]);

                i++;
            }
        }

        while (i<sWords.length) {
            result.add(sWords[i++]);
        }

        System.out.print(result);

    }
}
