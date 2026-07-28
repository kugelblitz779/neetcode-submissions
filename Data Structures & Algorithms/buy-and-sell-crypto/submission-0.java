class Solution {
    public int maxProfit(int[] prices) {
        int[] greater = new int[prices.length];
        int n = prices.length;

        greater[n-1] = prices[n-1];
        for(int i=n-2; i>=0; i--){
            greater[i] = Math.max(prices[i], greater[i+1]);
        }

        // for(int x : greater){
        //     System.out.print(x + ", ");
        // }
        // System.out.println("");

        int profit = 0;
        for(int i=0; i<n-1; i++){
            int buy = prices[i];
            int sell = greater[i+1];

            profit = Math.max(sell-buy, profit);
        }

        return profit;
    }
}
