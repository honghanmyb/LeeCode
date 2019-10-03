import java.util.PriorityQueue;

public class SplitArrayLargestSum {
    public int splitArray(int[] nums, int m) {
        int total = 0;
        for(int num: nums){
            total += num;
        }
        if(m == 1){
            return total;
        }
        PriorityQueue<SubArray> heap = new PriorityQueue<>(m, (sub1, sub2) -> sub2.totalNum - sub1.totalNum);
        heap.add(new SubArray(0, nums.length - 1, total));
        while(heap.size() < m){
            SubArray largestSub = heap.poll();
            if(largestSub.startIndex == largestSub.endIndex){
                return largestSub.totalNum;
            }
            int middleIndex = getMiddleIndex(nums, largestSub.startIndex, largestSub.endIndex, 
                                            largestSub.totalNum);
            int firstTotal = 0;
            for(int i = largestSub.startIndex; i <= middleIndex; i++){
                firstTotal += nums[i];
            }
            heap.add(new SubArray(largestSub.startIndex, middleIndex, firstTotal));
            heap.add(new SubArray(middleIndex + 1, largestSub.endIndex, largestSub.totalNum - firstTotal));
        }
        return heap.peek().totalNum;
    }
    
    private int getMiddleIndex(int[] nums, int startIndex, int endIndex, int totalNum){
        if(startIndex + 1 >= endIndex ){
            return startIndex;
        }
        int firstTotal = 0;
        int minMaxTotal = totalNum;
        int middleIndex = startIndex;
        for(int i = startIndex; i < endIndex; i++){
            firstTotal += nums[i];
            totalNum -= nums[i];
            int currentMinMax = Integer.max(firstTotal, totalNum);
            if(minMaxTotal > currentMinMax){
                minMaxTotal = currentMinMax;
                middleIndex = i;
            }
        }
        System.out.println(middleIndex);
        return middleIndex;
    }
    
    private class SubArray{
        public int startIndex;
        public int endIndex;
        public int totalNum;
        
        public SubArray(int startIndex, int endIndex, int totalNum){
            this.startIndex = startIndex;
            this.endIndex = endIndex;
            this.totalNum = totalNum;
        }
    }
}
