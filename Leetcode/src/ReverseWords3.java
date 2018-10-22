import java.util.Stack;

public class ReverseWords3 {
    private String reverseWords(String s) {
        String strs[] = s.split(" ");
        StringBuilder result = new StringBuilder();
        for (int i=0;i<strs.length;i++) {
            int k=strs[i].length()-1;
            while (k>=0) {
                result.append(strs[i].charAt(k--));
            }
            result.append(" ");
        }

        return result.toString().trim();
    }


    private String reverseWordsV2(String s) {
        Stack<Character> st = new Stack<>();
        StringBuilder result = new StringBuilder();
        for (int i=0; i<s.length();i++) {
            if (s.charAt(i) != ' ') {
                st.push(s.charAt(i));
            } else {
                while(!st.empty()) {
                    result.append(st.pop());
                }
                if (st.empty()) result.append(" ");
            }
        }

        while (!st.empty()) {
            result.append(st.pop());
        }

        return result.toString();
    }
    public static void main(String[] args) {
        ReverseWords3 r = new ReverseWords3();
        String s = "Let's take LeetCode contest";
        System.out.println(r.reverseWords(s));
        System.out.println(r.reverseWordsV2(s));
    }
}
