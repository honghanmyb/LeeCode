import java.util.*;
public class TestCode {
	public static void main(String[] args) {
		PermutationsII test = new PermutationsII();
		int[] nums = {1, 1, 2};
		List<List<Integer>> result = test.permuteUnique(nums);
		
		for(List<Integer> eachRound : result) {
			System.out.println(eachRound);
		}

	}
}
