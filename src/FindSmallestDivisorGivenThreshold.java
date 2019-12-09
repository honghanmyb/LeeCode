public class FindSmallestDivisorGivenThreshold {
    public int smallestDivisor(int[] nums, int threshold) {
        int min = 1;
        int max = 0;
        for(int num: nums){
            max = Math.max(num, max);
        }
        while(min <= max){
            int mid = min + (max - min) / 2;
            if(canDivide(nums, mid, threshold)){
                max = mid - 1;
            }else{
                min = mid + 1;
            }
        }
        return min;
    }

    private boolean canDivide(int[] nums, int mid, int threshold){
        for(int num : nums){
            int divide = num % mid == 0? num / mid : num / mid + 1;
            threshold -= divide;
            if(threshold < 0){
                return false;
            }
        }
        return true;
    }
}
