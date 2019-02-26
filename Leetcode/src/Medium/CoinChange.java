package Medium;


public class CoinChange {

    private int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];

        for(int i=0;i<amount+1;i++){
            dp[i] = amount+1; //no coin # is greater than amount + 1
        }

        dp[0] = 0;

        for(int i=1;i<amount+1;i++) {
            for(int j=0;j<coins.length;j++) {
                if(i-coins[j] >= 0){
                    dp[i] = Math.min(dp[i],dp[i-coins[j]]+1);
                }
            }
        }

        return  (dp[amount] == amount+1) ? -1 : dp[amount];
    }


    public static void main(String[] args) {
        CoinChange c = new CoinChange();
        int[] coins = {1, 2,5};
        int amount = 11;
        System.out.println(c.coinChange(coins, amount));
    }
}
