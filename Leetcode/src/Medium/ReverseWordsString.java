package Medium;

public class ReverseWordsString {

    public String reverseWords(String s) {
        if (s.length() == 0 || s == null) return "";
        StringBuilder result = new StringBuilder();
        int i = s.length()-1, j=i, k=i;
        while (i>=0)  {
            if (s.charAt(i) != ' ') {
                j=i-1;
                while (j>=0 && s.charAt(j)!=' ')
                    j--;
                result.append(s.substring(j+1, i+1));
                result.append(" ");
                i=j;
            } else i--;

        }
        return result.toString().trim();
    }


    public static void main(String[] args) {
        String s = "the sky is blue ";
        ReverseWordsString r = new ReverseWordsString();
        System.out.println(r.reverseWords(s));
    }
}
