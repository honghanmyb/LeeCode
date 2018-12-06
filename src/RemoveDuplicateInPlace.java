import java.util.Arrays;

public class RemoveDuplicateInPlace {
	public int removeDuplicates(int[] nums) {
		if(nums.length <= 1) {
			return nums.length;
		}
		int currentFlag = 0;
		int movingFlag = currentFlag + 1;
		int count = 0;
		while(movingFlag < nums.length) {
			if(nums[currentFlag] == nums[movingFlag]) {
//				if(movingFlag != currentFlag) {
//					count++;
//				}
				count++;
				movingFlag++;
			}else {
				currentFlag = movingFlag;
				movingFlag++;
			}
		}
		int length = nums.length - count;
		
		
		int firstFlag = 0, firstMove = 1;
//		int secondFlag = length, secondMove = length;
		int secondFlag = nums.length - 1;
		while(secondFlag >= length && firstMove < length) {
			while(nums[firstFlag] != nums[firstMove]) {

				firstFlag = firstMove;

				firstMove++;
			}
			if(firstMove >= length) break;
//			while(nums[secondFlag] == nums[secondMove] && secondFlag < secondMove - 1) {
//				secondMove++;
//			}
//			if(nums[secondFlag] != nums[secondMove]) secondFlag = secondMove;
//			swap(firstMove, secondMove, nums);
//			secondFlag = firstMove;
			while( nums[secondFlag] == nums[secondFlag - 1]) {

				secondFlag --;
				if(secondFlag <= 0) break;
			}
			swap(firstMove, secondFlag, nums);
			secondFlag--;
			firstMove++;
		}
		Arrays.sort(nums, 0, length);

		return length;
		
	}
	
	
	private void swap(int first, int second, int[] nums) {
		int temp = nums[first];
		nums[first] = nums[second];
		nums[second] = temp;
	}
}
