
public class MinimumCostToMergeStones {
    public int mergeStones(int[] stones, int K) {
        if(K > 2 && (stones.length) % (K - 1) != 1){
            return -1;
        }
        return merge(stones, K, (stones.length - 1) / (K - 1));
    }
    
    private int merge(int[] stones, int K, int step){
        if(step == 0){
            return 0;
        }
        int minCost = Integer.MAX_VALUE;
        int currentCost = 0;
        int minStartIndex = 0;
        int minEndIndex = 0;
        int currentStartIndex = 0;
        int currentEndIndex = 0;
        int currentCount = 0;
        while(stones[currentStartIndex] == 0){
            currentStartIndex++;
        }
        currentEndIndex = currentStartIndex;
        while(currentCount < K){
            currentCost += stones[currentEndIndex];
            if(stones[currentEndIndex] != 0){
                currentCount++;
                if(currentCount == K) {
                	break;
                }
            }
        	currentEndIndex++;
        }
        minCost = currentCost;
        minStartIndex = currentStartIndex;
        minEndIndex = currentEndIndex;
        while(currentCount >= K){
            currentCost -= stones[currentStartIndex++];
            currentCount --;
            while(currentStartIndex < stones.length && stones[currentStartIndex] == 0){
                currentStartIndex ++;
            }
            
            currentEndIndex++;
            while(currentEndIndex < stones.length && stones[currentEndIndex] == 0){
                currentEndIndex++;
            }
            if(currentEndIndex < stones.length){
                currentCount++;
                currentCost += stones[currentEndIndex];
                if(currentCount == K && minCost > currentCost){
                    minCost = currentCost;
                    minStartIndex = currentStartIndex;
                    minEndIndex = currentEndIndex;
                }
            }
        }
        
        for(int i = minStartIndex; i <= minEndIndex; i++){
            stones[i] = 0;
        }
        stones[minStartIndex] = minCost;
        System.out.println("step " + step + ", cost " + minCost);
        for(int i = 0; i < stones.length; i++){
            System.out.print(stones[i] + ", ");
        }
        return minCost + merge(stones, K, step - 1);
    }
}
