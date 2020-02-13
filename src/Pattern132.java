import java.util.TreeSet;

public class Pattern132 {
    public boolean find132pattern(int[] nums) {
        if(nums.length < 3){
            return false;
        }
        int[] minLeft = new int[nums.length];
        int[] maxRight = new int[nums.length];
        int min = nums[0];
        for(int i = 0; i < nums.length; i++){
            min = Math.min(min, nums[i]);
            minLeft[i] = min;
        }
        TreeSet<Integer> set = new TreeSet<>();
        for(int i = nums.length - 1; i >= 0; i--){
            Integer maxLower = set.lower(nums[i]);
            maxRight[i] = Integer.MAX_VALUE;
            if(maxLower != null){
                maxRight[i] = maxLower;
            }
            set.add(nums[i]);
        }
        for(int i = 0; i < nums.length; i++){
            if(minLeft[i] < nums[i] && nums[i] > maxRight[i] && maxRight[i] > minLeft[i]){
                return true;
            }
        }
        return false;
    }
}
