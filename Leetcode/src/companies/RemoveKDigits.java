package companies;

import java.util.Stack;

public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        if (num.length() == 0 ||  num == null) return null;
        if (num.length() <= k) return null;

        StringBuilder result = new StringBuilder();
        Stack<Character> st = new Stack<>();
        int i=0;
        while (i<num.length()) {
            if (k>0 && !st.isEmpty() && st.peek() > num.charAt(i)) {
                st.pop();
                k--;
            }
            st.push(num.charAt(i));
            i++;
        }

        System.out.println("st"+st);

        while(k>0){
            st.pop();
            k--;
        }

        while(!st.isEmpty())
            result.append(st.pop());
        result.reverse();

        while(result.length()>1 && result.charAt(0)=='0')
            result.deleteCharAt(0);
        return result.toString();

    }

    public String removeKdigitsV2(String num, int k) {
        if (num.length() == 0 ||  num == null) return null;
        if (num.length() <= k) return "0";

        StringBuilder result = new StringBuilder();
        int i;
        for (i=0;i<num.length()-1;i++){
            if (num.charAt(i) <= num.charAt(i+1) && k>0) {
                result.append(num.charAt(i));
            } else {
                k--;
                if (k==0) {
                    i++;
                    break;
                }
            }
        }

        while (i<num.length()) {
            result.append(num.charAt(i));
            i++;
        }
        if (k > 0) {
            i = num.length() - 1;
            while (k > 0) {
                result.deleteCharAt(i--);
                k--;
            }
        }

        if (result.length() > 1 && result.charAt(0) == '0')
            result.deleteCharAt(0);
        return result.toString();
    }

    public static void main(String[] args) {
        String num = "1234567890";
        int k=9;
        RemoveKDigits r = new RemoveKDigits();
        System.out.println(r.removeKdigits(num,k));
//        System.out.println(r.removeKdigitsV2(num,k));

    }
}
