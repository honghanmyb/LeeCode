import java.util.*;
public class TestCode {
	public static void main(String[] args) {
		SubsetsII test = new SubsetsII();
		int[] nums = {1, 2, 2};
		List<List<Integer>> subsets = test.subsetsWithDup(nums);
		for(int i = 0; i < subsets.size(); i++) {
			System.out.println(subsets.get(i));
		}
	}
}
