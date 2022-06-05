class Solution {
    public int maxProfit(int k, int[] prices) {
        if(k >= prices.length) {  // Case of Problem 122. Best Time to Buy and Sell Stock II
            int maxProfit = 0;
            for(int i = 1; i < prices.length; i++)
                if(prices[i] > prices[i - 1])
                    maxProfit += prices[i] - prices[i - 1];
            return maxProfit;
        }
        
        int T[][] = new int[k+1][prices.length];
        for (int i = 1; i < T.length; i++) {
            int maxDiff = -1 * prices[0];
            for (int j = 1; j < T[0].length; j++) {
                T[i][j] = Math.max(T[i][j-1], prices[j] + maxDiff);
                maxDiff = Math.max(maxDiff, T[i-1][j] - prices[j]);
            }
        }
        return T[k][prices.length-1];
    }
}