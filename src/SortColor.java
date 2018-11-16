
public class SortColor {
	public void sortColors(int[] nums) {
		if(nums.length <= 1) return;
		int point0 = 0;
		int point = 0;
		int point2 = nums.length - 1;
		while(true) {
			while(point0 < nums.length && nums[point0] == 0) point0++;
			
			if(point < point0) point = point0;
			
			while(point2 >= 0 && nums[point2] == 2) point2--;
			
			while(point < nums.length && nums[point] == 1) point++;
			
			if(point > point2) break;
			
			if( nums[point] == 0) {
				int temp = nums[point];
				nums[point] = nums[point0];
				nums[point0] = temp;
			}
			if(nums[point] == 2) {
				int temp = nums[point];
				nums[point] = nums[point2];
				nums[point2] = temp;
			}
		}
	}
}
