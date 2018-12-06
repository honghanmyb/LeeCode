import java.util.*;
public class TestCode {
	public static void main(String[] args) {
		CombinationSumII test = new CombinationSumII();
//		int[] candidates = {10,1,2,7,6,1,5};
		int[] candidates = {1 , 2, 2, 2, 5};
		List<List<Integer>>result = test.combinationSum2(candidates, 5);
		for(int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i));
		}
	}
}
