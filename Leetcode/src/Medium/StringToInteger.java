package Medium;

public class StringToInteger {

    public int myAtoi(String str) {
        str = str.trim();
        if (str.length() == 0 || str == null) return -1;
        int i=0;
        double num = 0;
        boolean isPositive = true;

        if (str.charAt(i) == '-') {
            isPositive = false;
            i++;
        } else if (str.charAt(i) == '+') {
            i++;
        }

        while(i < str.length() && str.charAt(i) >='0' && str.charAt(i) <='9') {
            num *= 10;
            num += str.charAt(i) - '0';
            i++;
        }

        if (!isPositive) {
            num = -num;
        }

        if (num > Integer.MAX_VALUE ) {
            return Integer.MAX_VALUE;
        }

        if (num < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }


        return (int)num;

    }

    public static void main(String[] args) {
        StringToInteger s = new StringToInteger();
        String str = " ";
        System.out.println(s.myAtoi(str));
    }
}
