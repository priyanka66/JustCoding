package Medium;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartioning {


    private List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<List<String>>();
        List<String> temp = new ArrayList<>();

        partition(s, result, temp, 0);
        return result;
    }

    private void partition(String s, List<List<String>> result, List<String> temp, int k) {
        if (k == s.length()) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i=k+1;i<=s.length();i++) {
            if (isPalindrome(s.substring(k,i))) {
                temp.add(s.substring(k,i));
                partition(s, result, temp, i);
                temp.remove(temp.size()-1);
            }
        }
    }

    private boolean isPalindrome(String s) {
        int i=0,j=s.length()-1;
        while (i<j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }

        return true;
    }
    public static void main(String[] args) {
        PalindromePartioning p = new PalindromePartioning();
        String s = "aab";
        System.out.println(p.partition(s));
    }
}
