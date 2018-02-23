import java.util.Stack;

public class InfixtoPostFix {

    static int Precedence(char ch) {
        switch (ch) {
            case '+' :
            case '-' :
                return 1;
            case '*' :
            case '/' :
                return 2;
            case '^' :
                return 3;

        }

        return -1;
    }


    static String infixToPost (String exp) {
        Stack<Character> st = new Stack<>();
        String result = new String("");

        for (int i=0; i<exp.length(); i++) {
            char x = exp.charAt(i);
            if (Character.isLetterOrDigit(x))
                result += x;
            else if (x == '(')
                st.push(x);
            else if (x == ')') {
                while (!st.empty() && st.peek() != '(')
                    result += st.pop();
                if (!st.empty() && st.peek() != '(')
                    return  "Invalid";
                else
                    result += st.pop();

            } else {
                while (!st.empty() && Precedence(x) <= Precedence(st.peek()))
                    result += st.pop();
                st.push(x);
            }
        }

        while (!st.empty())
        result += st.pop();
        return  result;
    }

    public static void main (String[] args) {
        String exp = "a+b";
        System.out.println(infixToPost(exp));
    }
}


