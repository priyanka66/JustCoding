package Easy;

public class PalindromePermutation {

    private boolean canPermutePalindrome(String s) {
        int[] count = new int[256];
        int even=0, odd=0;
        for (int i=0;i<s.length();i++) {
            count[s.charAt(i)] ++;
        }
        for (int num : count) {
            if (num % 2 == 0) even++;
            else odd++;
        }
        if (s.length() % 2 == 1) {
            return odd == 1 ? true:false;
        } else {
            return  odd == 0 ? true:false;
        }
    }
    public static void main(String[] args) {
        PalindromePermutation p = new PalindromePermutation();
        String s = "aabbccdfg";
        System.out.println(p.canPermutePalindrome(s));
    }
}
