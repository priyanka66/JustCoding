package Easy;

import java.util.Arrays;
import java.util.HashSet;

public class GoatLatin {

    public String toGoatLatin(String S) {
        if (S.length() == 0 || S == null) return "";
        Character[] vowelsList = {'a','e','i','o','u','A','E','I','O','U'};
        HashSet<Character> vowels = new HashSet<>(Arrays.asList(vowelsList));
        StringBuilder result  = new StringBuilder();
        int index = 1;
        for (String word: S.split(" ")) {
            if (index!=1) result.append(" ");
            char first = word.charAt(0);
            if (vowels.contains(first)) {
                result.append(word);
            } else {
                result.append(word.substring(1));
                result.append(first);
            }
            result.append("ma");
            for (int i=0;i<index;i++) {
                result.append("a");
            }
            index++;
        }

        return result.toString();
    }

    public static void main(String[] args) {
        GoatLatin g = new GoatLatin();
        String S = "I speak Goat Latin";
        System.out.println(g.toGoatLatin(S));
    }

}
