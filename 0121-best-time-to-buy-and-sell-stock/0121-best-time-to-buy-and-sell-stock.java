class Solution {
    public int maxProfit(int[] prices) {
        int l=0;
        int r=1;
        int profit=0;
        while(r<prices.length){
            if(prices[r]>prices[l]){
            profit=Math.max(profit,prices[r]-prices[l]);
            
            }
            else{
                l=r;
            }
            r++;
        }
        
        if (profit==0){
            return 0;
        }
        return profit;
    }
}