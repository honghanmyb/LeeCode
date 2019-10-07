
public class CountOfSmallerNumbersAfterSelf {
    public List<Integer> countSmaller(int[] nums) {
        if(nums.length == 0){
            return new ArrayList<>();
        }
        List<Integer> numCount = new ArrayList<>(nums.length);
        for(int i = 0; i < nums.length ; i++){
            int count = 0;
            for(int j = i + 1; j < nums.length; j++){
                if(nums[j] < nums[i]){
                    count++;
                }
            }
            numCount.add(count);
        }
        return numCount;
    }
}
