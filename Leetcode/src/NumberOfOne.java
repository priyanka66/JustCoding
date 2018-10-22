public class NumberOfOne {

    public static int hammingWeight(int n) {
       String s = Integer.toBinaryString(n);
       int count=0;
       for (int i=0; i<s.length();i++) {
           if((Character.getNumericValue(s.charAt(i)) & 1) == 1) count++;
       }
       return count;
    }

    public static int hammingWeightV2(int n) {

        long un = Integer.toUnsignedLong(n);
        int c = 0;
        /** if we subtract a number by 1 and do bitwise & with itself (n & (n-1)), we unset the rightmost set bit.
         * If we do n & (n-1) in a loop and count the no of times loop executes we get the set bit count.
         *
          */
        while (un>0){
            un &= un - 1;
            c++;
        }
        return c;

    }
    public static void main(String[] args) {
        long n =   2147483648l;
        System.out.println("Number of 1's  " +  hammingWeight((int)n));
        System.out.println("Number of 1's  " +  hammingWeightV2((int)2147483648l));

    }
}
