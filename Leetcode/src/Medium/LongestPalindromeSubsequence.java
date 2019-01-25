package Medium;

public class LongestPalindromeSubsequence {
    public int longestPalindromeSubseq(String s) {
        if (s.length() == 0 || s == null) return 0;
        int[][] palindrome = new int[s.length()][s.length()];
        for (int i=0;i<s.length();i++) {
            palindrome[i][i] = 1;
        }
        for (int len = 2; len <= s.length(); len++) {
            for (int i=0;i<s.length()-len+1;i++) {
                int j=i+len-1;
                if (len == 2 && s.charAt(i) == s.charAt(j)) {
                    palindrome[i][j] = 2;
                } else if (s.charAt(i) == s.charAt(j)) {
                    palindrome[i][j] = 2 + palindrome[i+1][j-1];
                }  else { // if characters are different
                    palindrome[i][j] = Math.max(palindrome[i][j-1], palindrome[i+1][j]);
                }
            }
        }

        return palindrome[0][s.length()-1];
    }

    public static void main(String[] args) {
        LongestPalindromeSubsequence p = new LongestPalindromeSubsequence();
        String s = "agapasa";
        System.out.println(p.longestPalindromeSubseq(s));
    }
}
