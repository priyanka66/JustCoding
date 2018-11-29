package Easy;

import java.util.Arrays;

public class ClimbStairs {

    public static int climbStairs(int n) {
        if (n == 0 || n==1) return n;
        int[] ways = new int[n];
        ways[0] = 1;
        ways[1] = 2;
        int i;
        for (i=2; i<n;i++) {
            ways[i] = ways[i-1] +  ways[i-2];
            System.out.println(Arrays.toString(ways));
        }
        return ways[i-1];
    }
    public static void main(String[] args) {
        int n = 3;
        System.out.println("Number of ways " +  climbStairs(n));
    }
}
