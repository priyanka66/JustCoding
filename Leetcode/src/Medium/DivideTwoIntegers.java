package Medium;

public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        int flag = 1;
        if ((dividend > 0 && divisor < 0) || (dividend <0 && divisor >0)) flag = -1;
        //To avoid overflow  make numbers negative and perform calculations

        if (divisor >0) divisor = -divisor;
        if (dividend > 0) dividend = -dividend;

        int quotient = 0;
        while (dividend <= divisor) {
            int count = 1;
            int temp = divisor;
            while (dividend - temp <= temp) {
                count = count<<1;
                temp = temp<<1;
            }

            quotient+=count;
            dividend = dividend-temp;
        }

        return quotient*flag;
    }

    public static void main(String[] args) {
        DivideTwoIntegers d = new DivideTwoIntegers();
        System.out.println(d.divide(7,-3));
    }
}
