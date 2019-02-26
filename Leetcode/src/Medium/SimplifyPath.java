package Medium;

import java.util.Stack;

public class SimplifyPath {

    public String simplifyPath(String path) {
        if (path == null || path.length() == 0) return "";
        StringBuilder result = new StringBuilder();
        Stack<String> st = new Stack<>();
        int i=0, j=0;
        while (i<path.length()) {
            if (path.charAt(i) == '/') j=i+1;
            while (j<path.length() && path.charAt(j) != '/') j++;
            String cur = path.substring(i+1,j);
            if (cur.equals("..")) {
                if (!st.isEmpty()) st.pop();
            } else {
                if (!cur.equals(".") && !cur.equals("")) {
                    st.push(cur);
                }
            }
            i = j;
        }

        for (String s : st) {
            result.append("/").append(s);
        }

        return  result.toString().length() == 0 ? "/" : result.toString();
    }

    public static void main(String[] args) {
        SimplifyPath p = new SimplifyPath();
        String path  ="/../";
        System.out.println(p.simplifyPath(path));
    }
}
