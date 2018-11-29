package Easy;

import java.util.Arrays;

public class PlusOne {

    public int[] plusOne(int[] digits) {
        int carry = 0;
        for (int i=digits.length-1;i>=0;i--) {
            if (digits[i]+1 > 9) {
                digits[i] = 0;
                carry = 1;
            } else {
                digits[i] = digits[i] +1;
                carry = 0;
            }
        }

        if (carry == 1) {
            int[] res = new int[digits.length+1];
            res[0] = 1;
            for (int i=0;i<digits.length; i++) {
                res[i+1] = digits[i];
            }

            return res;
        }

        return digits;
    }


    public static void main(String[] args) {
        PlusOne p1 = new PlusOne();
        int[] digits = {9,9};
        System.out.println(Arrays.toString(p1.plusOne(digits)));
    }
}
