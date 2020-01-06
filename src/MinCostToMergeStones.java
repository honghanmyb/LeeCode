public class MinCostToMergeStones {
    //use dp, totalCost[i][j] stands for the min cost to merge stones from i to j into as min piles of stones
    //as possible.
    //we start with the right limit of the stones, then go left, for each totalCost[i][j], the update method is
    //totalCost[i][j] = min(totalCost[i][j], totalCost[i][mid] + totalCost[mid + 1][j]), for every mid in the range of i to j
    //if stones from i to j can be merged into 1 pile, then after the update, add a cost of merging the whole pile of stones,
    //which should be equal to the sum of stones from i to j
    public int mergeStones(int[] stones, int K) {
        if((stones.length - 1) % (K - 1) != 0){
            return -1;
        }
        int[] stoneSum = new int[stones.length];
        int curSum = 0;
        for(int i = 0; i < stones.length; i++){
            stoneSum[i] = stones[i] + curSum;
            curSum += stones[i];
        }
        int[][] totalCost = new int[stones.length][stones.length];
        for(int j = 0; j < stones.length; j++){
            for(int i = j - 1; i >= 0; i--){
                //calculate totalCost[i][j], meaning merging stone i to j
                int minCost = Integer.MAX_VALUE;
                for(int mid = j - 1; mid >= i; mid -= K - 1){
                    minCost = Math.min(minCost, totalCost[i][mid] + totalCost[mid + 1][j]);
                }
                minCost = minCost == Integer.MAX_VALUE ? 0 : minCost;
                if((j - i) % (K - 1) == 0){
                    minCost += stoneSum[j] - stoneSum[i] + stones[i];
                }
                totalCost[i][j] = minCost;
            }
        }
        return totalCost[0][stones.length - 1];
    }
}
