public class Pattern132 {
    public boolean find132pattern(int[] nums) {
        for(int i = 0; i < nums.length - 2; i++){
            int curMin = nums[i];
            int curMax = curMin + 1;
            for(int j = i + 1; j < nums.length; j++){
                curMax = Math.max(curMax, nums[j]);
                if(nums[j] > curMin && nums[j] < curMax){
                    return true;
                }
            }
        }
        return false;
    }
}
