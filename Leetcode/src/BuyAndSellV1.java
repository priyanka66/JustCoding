public class BuyAndSellV1 {

    public static int maxProfit(int[] prices) {
        int minSell = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i=0;i<prices.length;i++) {
            if (minSell > prices[i]) minSell = Math.min(minSell, prices[i]);
            else maxProfit = Math.max(maxProfit, prices[i]-minSell);
        }

        return maxProfit;
    }
    public static void main(String[] args) {
        int prices[] = {7,1,5,3,6,4};
        System.out.println("Max profit = " + maxProfit(prices));
    }
}
