package Easy;

public class PalindromeNumber {

     private boolean isPalindrome(int x) {
      long rev = 0;
      int num =x;
      while (x>0) {
          rev = (rev*10) + (x%10);
          x = x/10;
      }

      return num == (int)rev;
    }

    private boolean isPalindromeV2(int x) {
         String s = String.valueOf(x);
         int i=(s.length()-1)/2;
         int j = s.length()/2;
         while (i>=0 && j<s.length()) {
             if (s.charAt(i) != s.charAt(j)) return false;
             else {
                 i--;
                 j++;
             }
         }
         return true;

    }

    public static void main(String[] args) {
        int num =  121;
        PalindromeNumber p = new PalindromeNumber();
        System.out.println(p.isPalindrome(num));
        System.out.println(p.isPalindromeV2(num));

    }
}
