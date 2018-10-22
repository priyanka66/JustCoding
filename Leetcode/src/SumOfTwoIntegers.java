public class SumOfTwoIntegers {

    public int getSum(int a, int b) {
        if (a==0) return b;
        if (b==0) return a;
        while ( b!= 0) {
            int carry = a &b;
            a = a ^ b;
            b = carry <<1;
        }
        return a;
    }

    public static void main(String[] args) {
        SumOfTwoIntegers s1 = new SumOfTwoIntegers();
        int a = 3, b=1;
        System.out.println(s1.getSum(a,b));
    }
}
