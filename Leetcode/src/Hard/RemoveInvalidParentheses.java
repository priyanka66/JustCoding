package Hard;

import java.util.*;

public class RemoveInvalidParentheses {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        if (s == null) return result;
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(s);
        visited.add(s);
        boolean valid = false;
        while (!queue.isEmpty()) {
           s = queue.poll();
           if (isValid(s)) {
               result.add(s);
               valid = true;
           }
           if (valid) continue;
           for (int i=0;i<s.length();i++) {
               if (Character.isLetter(s.charAt(i))) continue;
               StringBuilder t = new StringBuilder(s.substring(0,i)).append(s.substring(i+1));
               if (!visited.contains(t.toString())) {
                   visited.add(t.toString());
                   queue.add(t.toString());
               }
           }
        }

        return result;
    }

    boolean isValid(String s) {
       int count = 0;
       for (int i=0;i<s.length();i++) {
           if (s.charAt(i) == '(') count++;
           else if (s.charAt(i) == ')') {
               count --;
               if (count <0) return false;
           }
       }

        return count == 0;
    }



    public static void main(String[] args) {
       RemoveInvalidParentheses p = new RemoveInvalidParentheses();
       String s = "";
       System.out.println(p.removeInvalidParentheses(s));
    }
}
