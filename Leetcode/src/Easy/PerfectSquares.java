package Easy;

public class PerfectSquares {


    private int numSquares(int n) {
//        if (n <= 3) return n;
//        int count = n;
//        for (int i=2;i<n;i++) {
//            int temp = i*i;
//            if (temp <= n) {
//                count = Math.min(count, 1+numSquares(n-temp));
//            }
//            else {
//                break;
//            }
//        }
//
//        return count;
        int dp[] = new int[n+1];
        for (int i=0;i<=n;i++) dp[i] = i;

        for (int i= (int)Math.sqrt(n);i<=n;i++) {
            for(int j=1;j<=Math.sqrt(i);j++) {
                dp[i] = Math.min(dp[i], dp[i-(j*j)] +1);
            }
        }

        return dp[n];

    }
    public static void main(String[] args) {
        PerfectSquares s = new PerfectSquares();
        int n = 13;
        System.out.println(s.numSquares(n));
    }
}
