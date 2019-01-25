package Hard;

import java.util.HashSet;
import java.util.Set;

public class FindClosestPalindrome {

    public String nearestPalindromic(String n) {
        Set<Long> palindromes = new HashSet<>();

        // 1221 => 10001 , 999
        getUpperAndLower(palindromes, n);

        // get mid => 1221, previous => 1111 => next => 1221
        getPrevAndNext(palindromes, n);

        // Get closest palindrome
        long num = Long.parseLong(n);
        long diff = Long.MAX_VALUE;
        long res=0;
        for (Long val:palindromes) {
            long curDiff = Math.abs(num-val);
            if (curDiff == diff) {
                res = Math.min(res, val);
            }
            if (curDiff < diff && curDiff!=0) {
                res = val;
                diff = curDiff;
            }
        }
        System.out.println(palindromes);
        return String.valueOf(res);
    }

    public void getPrevAndNext(Set<Long> palindromes, String n) {
        Long mid = Long.parseLong(n.substring(0,(n.length()+1)/2));
        for (int i=-1;i<=1;i++) {
            Long curMid = mid+i;
            String midString = String.valueOf(curMid);
            String temp;
            if (n.length() % 2 ==  0) {
                temp = new StringBuilder(midString).reverse().toString();
                temp = midString + temp;
            } else {
                temp = new StringBuilder(midString.substring(0, midString.length()-1)).reverse().toString();
                temp = midString + temp;
            }
            palindromes.add(Long.parseLong(temp));
        }
    }

    public void getUpperAndLower(Set<Long> palindromes, String n) {
        Long num = Long.parseLong(n);
        Long val =  (long)Math.pow(10,n.length()) +1;
        palindromes.add(val);
        val = (long) Math.pow(10,n.length()-1) -1;
        palindromes.add(val);
    }
    public static void main(String[] args) {
        FindClosestPalindrome p = new FindClosestPalindrome();
        System.out.println(p.nearestPalindromic("88"));
    }
}
