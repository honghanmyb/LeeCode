public class WiggleSort {
    public void wiggleSort(int[] nums) {
        if(nums.length <= 1){
            return;
        }
        for(int i = 0; i < nums.length - 1; i++){
            if(i % 2 == 0){
                if(nums[i] <= nums[i + 1]){
                    continue;
                }
                swap(nums, i, i + 1);
            }else{
                if(nums[i] >= nums[i + 1]){
                    continue;
                }
                swap(nums, i, i + 1);
            }
        }
    }

    private void swap(int[] nums, int first, int second){
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}
