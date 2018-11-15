
public class BestTimeToBuyNSellI {
	public int bestTimeToBuyNSell(int[] prices) {
		int min, max, highestProfit;
		if(prices.length <=1) return 0;
		min = prices[0];
		max = 0; highestProfit = 0;
		for(int i = 0; i < prices.length;i++) {
			if(prices[i] < min) min = prices[i];
			if(prices[i] - min > max) max = prices[i] - min;
		}
		
		return max;
	}
}
