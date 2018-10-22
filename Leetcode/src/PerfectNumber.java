import java.util.ArrayList;
import java.util.List;

public class PerfectNumber {

    private boolean checkPerfectNumber(int num) {
        if (num <= 1) return false;
        double sum = 1;
        for (int i=2;i<=Math.sqrt(num);i++) {
            if (num % i == 0) {
                sum += i;
                sum += (num/i);
            }
        }

        if (sum == num) return true;
        return false;
    }
    public static void main(String[] args) {
        int n = 23;
        PerfectNumber p = new PerfectNumber();
        System.out.println(p.checkPerfectNumber(n));
    }
}
