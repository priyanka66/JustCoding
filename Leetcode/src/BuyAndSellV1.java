public class BuyAndSellV1 {

    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minBuy = Integer.MAX_VALUE;
        for (int i = 0; i<prices.length-1;i++) {
            if (minBuy > prices[i]) {
                minBuy = prices[i];
            }
            maxProfit = Math.max(maxProfit, prices[i+1]-minBuy);
        }
        return maxProfit;
    }
    public static void main(String[] args) {
        int prices[] = {7,1,5,3,6,4};
        System.out.println("Max profit = " + maxProfit(prices));
    }
}
