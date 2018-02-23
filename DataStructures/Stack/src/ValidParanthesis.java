import java.util.Stack;

public class ValidParanthesis {


    public static boolean checkifValid(char a, char b) {
        if (a == '(' && b == ')') return  true;
        else if (a == '[' && b == ']') return  true;
        else if (a == '{' && b == '}') return  true;
        else return false;
    }
    public static boolean isValidParanthesis(char exp[]) {
        Stack<Character> st = new Stack<Character>();
        for (int i=0; i<exp.length; i++) {
            if (exp[i] == '(' || exp[i] == '{' || exp[i]=='[') {
                st.push(exp[i]);
            }
            if (exp[i] == ')' || exp[i] == '}' || exp[i]==']') {
                if (!st.empty())
                    if (!checkifValid(st.pop(), exp[i]))
                        return false;
            }
        }

        if (st.empty()) return true;
        else return false;
    }
    public static void main (String[] args) {
        char exp [] = {'(', '{' ,'[' ,']','}' };
        if (isValidParanthesis(exp)) {
            System.out.println("Valid");
        } else
            System.out.println("InValid");
    }
}
