package Medium;

public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        /**
         * Initialize the result to 1 (since we are going to double our denominator until it is bigger than the dividend)
         Double the denominator (with bitwise shifts) until it is bigger than the dividend
         Since we know our denominator is bigger than our dividend, we can subtract the divisor until it is less than the dividend
         Return the recorded actions it took to get as close to the denominator as possible using the divisor
         */

        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        int flag = 1;
        if ((dividend > 0 && divisor < 0) || (dividend <0 && divisor >0)) flag = -1;
        //To avoid overflow  make numbers negative and perform calculations

        int quotient = 0;
        if (divisor >0) divisor = -divisor;
        if (dividend > 0) dividend = -dividend;

        while (dividend <= divisor) {
            int temp = divisor;
            int count = 1;
            while (dividend-temp <= temp) {
                count <<= 1;
                temp <<= 1;
            }
            quotient += count;
            dividend -= temp;
        }

        return quotient*flag;
    }

    public static void main(String[] args) {
        DivideTwoIntegers d = new DivideTwoIntegers();
        System.out.println(d.divide(10,3));
    }
}
