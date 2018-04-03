import java.util.Stack;

public class ValidPalindrome {

    static boolean isPalindrome(String s) {
        Stack<Character> st = new Stack<Character>();
        if (s == null) return true;
        for (int i=0; i<s.length();i++) {
            if (Character.isLetterOrDigit(s.charAt(i))) {
                char x = s.charAt(i);
                st.push(Character.toLowerCase(x));
            }
        }
        for (int i =0; i<s.length(); i++) {
            if (Character.isLetterOrDigit(s.charAt(i))) {
                char x = Character.toLowerCase(s.charAt(i));
                char y = st.peek();
                if (x != y) return false;
                else st.pop();
            }
        }
        return true;
    }

    static boolean isPalindromeV1(String s) {
        int start = 0, end=s.length()-1;
        while (start<=end) {
            while (start<=end && !Character.isLetterOrDigit(s.charAt(start))) {
                start ++;
            }
            while (start<=end && !Character.isLetterOrDigit(s.charAt(end))) {
                end--;
            }
            if (start<=end && Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) return false;
            start ++;
            end --;
        }
        return true;
    }
    public static void main (String[] args) {
        String s = "A man, a plan, a canal: Panama";
        String s1 = "ana";
        if (isPalindromeV1(s)) System.out.println("Valid");
        else System.out.println("Not Valid");
    }
}
