package Medium;


import java.util.Collections;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class CountWords {

    private int solution(String S) {
        String[] strs = S.split("[.!?]");
        StringTokenizer vals = new StringTokenizer(S);
        TreeSet<Integer> words = new TreeSet<>( Collections.reverseOrder());
        for (int i=0;i<strs.length;i++) {
            int count = 0;
            String s = strs[i].trim();
            String[] str = s.split(" ");
            for (int j=0;j<str.length;j++) {
                    if (!str[j].equals("")) {
                        count ++;
                }
            }
            words.add(count);
        }
        return words.first();
    }
    public static void main(String[] args) {
        CountWords c = new CountWords();
        String S = "We test coders. Give us a try?";
        System.out.println("We test coders".trim());
        System.out.println(" Give us a try".trim());
        System.out.println(c.solution(S));
    }
}
