import java.util.*;
public class TestCode {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(9);
		root.right = new TreeNode(0);
		root.left.left = new TreeNode(5);
		root.left.right = new TreeNode(1);
		
		SumRootToLeaf test = new SumRootToLeaf();
		
		System.out.println(test.sumNumbers(root));
	}
}
