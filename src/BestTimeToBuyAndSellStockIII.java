import java.util.*;
public class BestTimeToBuyAndSellStockIII {
	public int maxProfit(int[] prices) {
		if(prices.length == 0) {
			return 0;
		}
		int minPrice = prices[0], maxProfit = 0;
		int minPricePos = 0, maxProfitPos = 0, tempMinPricePos = 0;
		for(int i = 0; i < prices.length; i++) {
			if(prices[i] < minPrice) {
				minPrice = prices[i];
				tempMinPricePos = i;
				continue;
			}
			if(prices[i] - minPrice > maxProfit) {
				maxProfit = prices[i] - minPrice;
				minPricePos = tempMinPricePos;
				maxProfitPos = i;
			}
		}
		if(maxProfit == 0) {
			return 0;
		}
		
		int leftMaxProfit = getMaxProfitInSubArray(prices, 0, minPricePos - 1);
		int rightMaxProfit = getMaxProfitInSubArray(prices, maxProfitPos + 1, prices.length - 1);
		int[] reversePrices = new int[maxProfitPos - minPricePos - 1];
		for(int i = 0; i < reversePrices.length; i++) {
			reversePrices[i] = prices[maxProfitPos - i - 1];
		}
		int middleMaxProfit = getMaxProfitInSubArray(reversePrices, 0, reversePrices.length - 1);
		return Math.max(middleMaxProfit, Math.max(leftMaxProfit, rightMaxProfit)) + maxProfit;
	}
	
	private int getMaxProfitInSubArray(int[] prices, int startPos, int endPos) {
		if(endPos <= startPos) {
			return 0;
		}
		int minPrice = prices[startPos], maxProfit = 0;
		for(int i = startPos; i <= endPos; i++) {
			if(prices[i] < minPrice) {
				minPrice = prices[i];
			}
			if(prices[i] - minPrice > maxProfit) {
				maxProfit = prices[i] - minPrice;
			}
		}
		return maxProfit;
	}
}
