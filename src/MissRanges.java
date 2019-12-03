import java.util.ArrayList;
import java.util.List;

public class MissRanges {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> ranges = new ArrayList<>();
        if(nums.length == 0){
            ranges.add(lower == upper? "" + lower : lower + "->" + upper);
            return ranges;
        }
        long diffEnd = (long)nums[0] - lower;
        if(diffEnd > 0){
            ranges.add(diffEnd > 1? lower + "->" + ((long)nums[0] - 1): lower + "");
        }
        for(int i = 1; i < nums.length; i++){
            long diff = (long)nums[i] - (long)nums[i - 1];
            if(diff <= 1){
                continue;
            }
            if(diff == 2){
                ranges.add(nums[i] - 1 + "");
            }else{
                ranges.add(nums[i - 1] + 1 + "->" + (nums[i] - 1));
            }
        }
        diffEnd = (long)upper - nums[nums.length - 1];
        if(diffEnd > 0){
            ranges.add(diffEnd == 1? upper + "" : nums[nums.length - 1] + 1 + "->" + upper);
        }
        return ranges;
    }
}
