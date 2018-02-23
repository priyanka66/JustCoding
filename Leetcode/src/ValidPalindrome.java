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
    public static void main (String[] args) {
        String s = "A man, a plan, a canal: Panama";
        if (isPalindrome(s)) System.out.println("Valid");
        else System.out.println("Not Valid");
    }
}
