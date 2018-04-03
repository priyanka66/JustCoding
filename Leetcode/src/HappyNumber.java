import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

    public static boolean isHappy(int n) {
//        if (n == 1) return true;
//        if (n > 1 && n < 10) return false;
        Set<Integer> visitedNum = new HashSet<>();
        int rem = 0, squareSum = 0;
        while (visitedNum.add(n)) {
            squareSum = 0;
            while(n>0) {
                rem = n%10;
                squareSum += rem*rem;
                n = n/10;
            }
            if (squareSum == 1) return true;
            else {
                n = squareSum;

            }

        }
        return false;
    }
    public static void main(String[] args) {
        int n = 7;
        if(isHappy(n)) System.out.println("Happy Number");
        else System.out.println("Not happy");
    }
}
