package Medium;

import java.util.Arrays;

public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        int n1 =  num1.length(), n2 = num2.length();
        StringBuilder result = new StringBuilder();
        int[] product = new int[n1+n2];
        for (int i=n1-1;i>=0;i--) {
            for (int j=n2-1;j>=0;j--) {
                product[i+j+1] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
            }
        }
        int carry=0;
        for (int i=product.length-1;i>=0;i--) {
            int val = (carry+product[i]) % 10;
            carry = (carry + product[i]) / 10;
            product[i] = val;
        }
        for (int num:product) result.append(num);
        while (result.length() != 0 && result.charAt(0) == '0') result.deleteCharAt(0);
        return result.length() > 0 ? result.toString() : "0";
    }

    public static void main(String[] args) {
        String num1 = "12", num2 = "34";
        MultiplyStrings m = new MultiplyStrings();
        System.out.println(m.multiply(num1,num2));
    }
}
