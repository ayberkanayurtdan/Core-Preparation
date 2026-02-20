public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int l=0, r=1; //l=buy ,r=sell
        int maxProfit=0;
        while(r<prices.length){
            int profit=prices[r]-prices[l];
            if(prices[l]<prices[r]){
                if(profit>maxProfit){
                    maxProfit=profit;
                }
            }else{
                l=r;
            }
            r++;
        }
        return maxProfit;
    }

    // Test Verisi
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        
        BestTimeToBuyAndSellStock solver = new BestTimeToBuyAndSellStock();
        int result = solver.maxProfit(prices);
        
        System.out.println("Max Profit: " + result);
    }
}
