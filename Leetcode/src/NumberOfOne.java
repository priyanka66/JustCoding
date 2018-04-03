public class NumberOfOne {

    public static int hammingWeight(int n) {
       String s = Integer.toBinaryString(n);
       int count=0;
       for (int i=0; i<s.length();i++) {
           if((Character.getNumericValue(s.charAt(i)) & 1) == 1) count++;
       }
       return count;
    }
    public static void main(String[] args) {
        int n = 3;
        System.out.println("Number of 1's  " +  hammingWeight(n));

    }
}
