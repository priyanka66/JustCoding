import java.util.Stack;

public class PalindromeNumber {

    static boolean isPalindrome(int x) {
       long rev = 0;
       int num = x;
       while ( x > 0) {
           rev = (rev*10) + (x%10);
           x = x/10;
       }

       return (num == (int)rev) ? true : false;
    }
    public static void main(String[] args) {
        int num =  -2147447412;
        if(isPalindrome(num)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }
}
