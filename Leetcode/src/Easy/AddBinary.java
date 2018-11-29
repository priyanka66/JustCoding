package Easy;

import java.util.List;

public class AddBinary {

    static String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        if (a == null ) return b;
        if (b == null) return a;
        int carry = 0;
        int i = a.length()-1, j=b.length() -1;
        while (i>=0 || j>=0) {
            int sum = carry;
            if (i >=0 ) sum = sum + a.charAt(i--) - '0';
            if (j >= 0) sum = sum + b.charAt(j--) - '0';
            carry = sum/2;
            sum = sum % 2;
            result.append(sum);
        }
        String finalSum = result.reverse().toString();
        return finalSum;
    }
    public static void main(String[] main) {
        String a = "101";
        String b = "1";
        String result = addBinary(a,b);
        System.out.println(result);
    }
}
