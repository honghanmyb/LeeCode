import java.util.*;
public class TestCode {
	public static void main(String[] args) {
//		PermutationsII test = new PermutationsII();
//		int[] nums = {1, 1, 2};
//		List<List<Integer>> result = test.permuteUnique(nums);
//		
//		for(List<Integer> eachRound : result) {
//			System.out.println(eachRound);
//		}

		SlideWindowMax test = new SlideWindowMax();
		int[] nums = {1,3,-1,-3,5,3,6,7};
		int[] result = test.maxSlidingWindow(nums, 1);
		for(int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
	}
}
