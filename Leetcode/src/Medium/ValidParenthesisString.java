package Medium;

public class ValidParenthesisString {


    public boolean checkValidString(String s) {
        if (s == null) return false;
        if (s.length() == 0) return true;
        if (s.charAt(0) == ')') return false;
        if (s.length()>1 && s.charAt(s.length()-1) == '(') return false;
        int bal = 0;
        for (int i=0;i<s.length();i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '*') bal++;
            else bal--;
            if (bal < 0) return false;
        }

        bal = 0;
        for (int i=s.length()-1;i>=0;i--) {
            if (s.charAt(i) == ')' || s.charAt(i) == '*') bal++;
            else bal--;
            if (bal < 0) return false;
        }

        return true;
    }


    public static void main(String[] args) {
        ValidParenthesisString v = new ValidParenthesisString();
        String s = "";
        System.out.println(v.checkValidString(s));
    }
}
