import java.util.TreeSet;

public class IncreasingTripletSequence {
    public boolean increasingTriplet(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        if(nums.length < 3){
            return false;
        }
        int min = nums[0];
        for(int num: nums){
            if(num > min){
                Integer lower = set.lower(num);
                if(lower != null){
                    return true;
                }
                set.add(num);
            }else{
                min = num;
            }
        }
        return false;
    }
}
