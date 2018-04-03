public class BuyAndSellV2 {

    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i=0;i<prices.length-1;i++) {
           if (prices[i+1] > prices[i]) maxProfit+= prices[i+1] - prices[i];
        }

        return maxProfit;
    }
    public static void main(String[] args) {
        int prices[] = {};
        System.out.println("Max profit = " + maxProfit(prices));
    }
}
