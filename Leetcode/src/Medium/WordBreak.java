package Medium;

import java.util.ArrayList;
import java.util.List;

public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null && wordDict == null) return true;
        if (s == null || wordDict == null) return false;
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for (int i=1;i<=s.length();i++) {
            for (int j=0;j<i;j++) {
                if(dp[j] && wordDict.contains(s.substring(j,i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }

    public static void main(String[] args) {
        WordBreak w = new WordBreak();
        String s ="applepenapple";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("apple");
        wordDict.add("pen");
        System.out.println(w.wordBreak(s,wordDict));

    }
}
