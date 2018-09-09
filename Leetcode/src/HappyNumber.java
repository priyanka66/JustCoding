import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

    public static boolean isHappy(int n) {
        Set<Integer> visitedNum = new HashSet<>();
        while(visitedNum.add(n)) {
            int sum=0;
            int rem=0;
            while(n>0) {
                rem = n%10;
                sum += rem*rem;
                n/=10;
            }
            n = sum;
            if(sum == 1) return true;
        }
        return false;
    }
    public static void main(String[] args) {
        int n = 19;
        if(isHappy(n)) System.out.println("Happy Number");
        else System.out.println("Not happy");
    }
}
