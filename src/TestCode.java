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

		PopulateNextPointer test = new PopulateNextPointer();
		TreeLinkNode root = new TreeLinkNode(0);
		root.left = new TreeLinkNode(1);
		root.right = new TreeLinkNode(2);
		root.left.left = new TreeLinkNode(3);
		root.left.right = new TreeLinkNode(4);
		root.right.left = new TreeLinkNode(5);
		root.right.right = new TreeLinkNode(6);
		
		test.connect(root);
	}
}
