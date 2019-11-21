import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums.length < 3){
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        List<List<Integer>> allTriplets = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        for(int i = 0; i < nums.length - 2; i++){
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            int head = i + 1, tail = nums.length - 1;
            int target = -1 * nums[i];
            while(head < tail){
                if(nums[head] + nums[tail] == target){
                    set.add(Arrays.asList(nums[i], nums[head], nums[tail]));
                }
                if(nums[head] + nums[tail] < target){
                    head++;
                }else{
                    tail--;
                }
            }
        }
        allTriplets.addAll(set);
        return allTriplets;
    }
}
