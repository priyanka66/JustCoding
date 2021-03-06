package Medium;

public class PowXN {
    public double myPow(double x, int n) {
        if (x==0) return 0;
        if (n==0)  return 1;
        if (n  >  0)  {
            if (n%2 == 0) {
                return myPow(x*x, n/2);
            } else {
                return x * myPow(x*x, n/2);
            }
        }  else {
            return (1/x) * myPow(1/x, -(n+1));
        }
    }

    public static void main(String[] args) {
        PowXN p = new PowXN();
        double x = 2;
        int n = -2;
        System.out.println(p.myPow(x, n));

    }
}
