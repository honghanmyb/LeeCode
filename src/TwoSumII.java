//import java.util.*;
public class TwoSumII {
	public int[] twoSum(int[] numbers, int target) {
		int index1 = 0, index2 = numbers.length -1;
		while(true) {
			int temp = numbers[index1] + numbers[index2];
			if(temp == target) break;
			if(temp > target) index2--;
			else index1++;
		}
		
		int[] result = {index1 + 1, index2+1};
		return result;
	}
}
