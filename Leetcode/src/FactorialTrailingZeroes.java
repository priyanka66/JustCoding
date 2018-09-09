public class FactorialTrailingZeroes {

    private int trailingZeroes(int n) {
        int count = 0;
        while (n>=5) {
            n = n/5;
            count = count +n;
        }

        return count;
    }

    public static void main(String[] args) {
        FactorialTrailingZeroes f = new FactorialTrailingZeroes();
        int n = 14;
        System.out.println(f.trailingZeroes(n));
    }
}
