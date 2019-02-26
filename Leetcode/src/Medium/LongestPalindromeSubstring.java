package Medium;

public class LongestPalindromeSubstring {
    public String longestPalindrome(String s) {
        if (s.length() ==  0 || s == null) return "";
        boolean[][] palindrome = new boolean[s.length()][s.length()];
        for (int i=0;i<s.length();i++) {
            palindrome[i][i] = true;
        }
        int x=0,y=0;
        for (int len=2;len<=s.length();len++) {
            for (int i=0;i<s.length()-len+1;i++) {
                int j=i+len-1;
                if (len == 2 && s.charAt(i) == s.charAt(j)) {
                    palindrome[i][j] = true;
                    x = i;
                    y = j;
                } else {
                    if (s.charAt(i) == s.charAt(j) && palindrome[i+1][j-1]) {
                        palindrome[i][j] = true;
                        x = i;
                        y = j;
                    }
                }
            }
        }
        return s.substring(x,y+1);
    }

    public static void main(String[] args) {
        LongestPalindromeSubstring p = new LongestPalindromeSubstring();
        String s = "abba";
        System.out.println(p.longestPalindrome(s));
    }
}
