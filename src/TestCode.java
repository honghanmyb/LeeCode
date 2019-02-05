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
		
		CourseSchedule test = new CourseSchedule();
		int[][] prerequisities = new int[][] {{1,0}, {0,1}, {3,2}, {4, 3}};
		System.out.println(test.canFinish(6, prerequisities));
	}
}
