
public class MaximumProduct {
	public int maxProduct(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int currentMax = 1;
        int currentMin = 1;
        int maxProduct = nums[0];
        for(int i = 0; i < nums.length; i++){
            if(currentMax == 0 && currentMin == 0){
                    currentMax = 1;
                    currentMin = 1;
            }
            if(nums[i] > 0){
                if(currentMax < 0){
                    currentMax = 1;
                }
                currentMax *= nums[i];
                currentMin *= nums[i];
            }else if(nums[i] == 0){
                currentMax = 0;
                currentMin = 0;
            }else{
                int temp = currentMin;
                currentMin = Integer.min(currentMax * nums[i], nums[i]);
                currentMax = Integer.max(temp * nums[i], nums[i]);
            }
            maxProduct = Integer.max(maxProduct, currentMax);
        }
        return maxProduct;
	}
}
