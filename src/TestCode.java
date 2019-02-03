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

		BullsCows test = new BullsCows();
		String secret = "1123";
		String guess = "0111";
		
		System.out.println(test.getHint(secret, guess));
	}
}
