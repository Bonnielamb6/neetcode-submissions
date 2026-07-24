class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int left = 0;
        for(int pointer = 0; pointer < prices.length; pointer++){
            max = Math.max(max,prices[pointer] - prices[left]);
            if(prices[pointer] < prices[left]){
                left = pointer;
            }
        }
        return max;
    }
}
