import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ValidParenthesis {

    public static boolean isValidParenthesis(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i<s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{' ){
                st.push(s.charAt(i));
            }
            else if (s.charAt(i) == ')' && !st.empty() && st.peek() == '(') {
                st.pop();
            }
            else if (s.charAt(i) == ']' && !st.empty() && st.peek() == '[') {
                st.pop();
            }
            else if (s.charAt(i) == '}' && !st.empty() && st.peek() == '{') {
                st.pop();
            }
            else
                return false;
            }

            if (!st.empty()) return false;
            return true;

    }

    public static void main(String[] args) {
        String s = "(";
        if (isValidParenthesis(s)) {
            System.out.println("Is valid");
        } else {
            System.out.println("Not valid");
        }
    }
}
