package Medium;

public class StringToInteger {

    public int myAtoi(String str) {
        str = str.trim();
        if (str.length() == 0 || str == null) return 0;
        int i =0;
        double num = 0;
        boolean isPositive = true;

        if (str.charAt(i) == '+') {
            isPositive = true;
            i++;
        } else if (str.charAt(i) == '-') {
            isPositive = false;
            i++;
        }

        while (i<str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            num *= 10;
            num += str.charAt(i)-'0';
            i++;
        }
        if (!isPositive) num=-num;
        if (num > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (num < Integer.MIN_VALUE) return Integer.MIN_VALUE;

        return (int)num;
    }

    public static void main(String[] args) {
        StringToInteger s = new StringToInteger();
        String str = "-91283472332";
        System.out.println(s.myAtoi(str));
    }
    // 32
    // 0 * 10 => 0+3 = 3
    //3*10 + 2 = 32
}
