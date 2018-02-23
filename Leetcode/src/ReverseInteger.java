public class ReverseInteger {

    static int reverse(int num){
        long result = 0;
        while (num != 0) {
            result = (result*10) + (num%10);
            if (result>Integer.MAX_VALUE || result < Integer.MIN_VALUE) return 0;
            num = num/10;
        }
         return (int)result;
    }
    public static void main(String[] args) {
        int num =  1534236469;
        int result =  reverse(num);
        System.out.println("Reverse of " + num +" is " + result);
    }
}
