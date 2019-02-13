package Medium;

public class PowXN {
    public double myPow(double x, int n) {
        if (n == 1) return x;
        if (n == 0) return 1;
        if (n>0) {
            if (n%2 != 0) {
                return x * (myPow(x*x, n/2));
            } else {
                return (myPow(x*x, n/2));
            }
        } else {
            return 1/x * (myPow(1/x , -(n+1)));
        }
    }

    public static void main(String[] args) {
        PowXN p = new PowXN();
        double x = 2;
        int n = -5;
        System.out.println(p.myPow(x, n));

    }
}
