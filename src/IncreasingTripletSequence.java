import java.util.TreeSet;

public class IncreasingTripletSequence {
    public boolean increasingTriplet(int[] nums) {
        if(nums.length < 3){
            return false;
        }
        int min = nums[0];
        int mid = Integer.MAX_VALUE;
        for(int num: nums){
            if(num > min){
                if(num > mid){
                    return true;
                }else{
                    mid = num;
                }
            }else{
                min = num;
            }
        }
        return false;
    }
}
