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

		NQueensII test = new NQueensII();
		List<List<String>> result = test.solveQueens(4);
		for(int i = 0; i < result.size(); i++) {
			for(int j = 0; j < result.get(i).size(); j++) {
				System.out.println(result.get(i).get(j));
			}
			System.out.println("-----");
		}
	}
}
