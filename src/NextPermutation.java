
public class NextPermutation {
	public void nextPermutation(int[] nums) {
        if(nums.length <= 1){
            return;
        }
        if(nums[nums.length - 1] > nums[nums.length - 2]){
            swap(nums.length - 1, nums.length - 2, nums);
            return;
        }
        for(int i = nums.length - 1; i > 0; i--){
            if(nums[i] > nums[i - 1]){
                int leftMostPos = i - 1;
                int nextMax = Integer.MAX_VALUE;
                int nextMaxPos = 0;
                for(int j = leftMostPos; j < nums.length; j++){
                    if(nums[j] > nums[leftMostPos]){
                        if(nums[j] < nextMax){
                            nextMax = nums[j];
                            nextMaxPos = j;
                        }
                    }
                }
                swap(leftMostPos, nextMaxPos, nums);
                for(int j = leftMostPos + 1; j < nums.length; j++){
                    for(int k = j; k < nums.length; k++){
                        if(nums[k] < nums[j]){
                            swap(j, k, nums);
                        }
                    }
                }
                return;
            }
        }
        
        int head = 0, tail = nums.length - 1;
        while(head < tail){
            swap(head++, tail--, nums);
        }
	}
	
    private void swap(int posA, int posB, int[] nums){
        int temp = nums[posA];
        nums[posA] = nums[posB];
        nums[posB] = temp;
    }
}
