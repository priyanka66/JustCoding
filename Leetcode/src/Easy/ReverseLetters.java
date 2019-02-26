package Easy;

public class ReverseLetters {

    boolean isLetter(char x) {
        if ((x >= 'A' && x <='Z') || (x >= 'a' && x <='z')) return true;
        return false;
    }
    String reverseOnlyLetters(String S) {
        if (S == null) return null;
        int i=0,j=S.length()-1;
        char[] s = S.toCharArray();
        while (i<j) {
            while (i<=j && !Character.isLetter(s[i])) i++;
            while (i<=j && !Character.isLetter(s[j])) j--;
            if (i<j) {
                char x = s[i];
                s[i] = s[j];
                s[j] = x;
                i++;
                j--;
            }
        }

        return String.valueOf(s);
    }
    public static void main(String[] args) {
        String s = "ab_cd";
        ReverseLetters r = new ReverseLetters();
        System.out.println(r.reverseOnlyLetters(s));
    }
}
