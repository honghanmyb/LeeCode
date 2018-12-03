import java.util.*;
public class TestCode {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		root.left.left.left = new TreeNode(8);
		root.left.left.right = new TreeNode(9);
		root.right.left.left = new TreeNode(10);
		root.right.left.right = new TreeNode(11);
		
		TreeZigzagLevelOrder test = new TreeZigzagLevelOrder();
		List<List<Integer>> result = test.zigzagLevelOrder(root);
		for(int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i));
		}
	}
}
