import java.util.*;
public class TestCode {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(5);
		BinaryTreePaths test = new BinaryTreePaths();
		
		System.out.println(test.binaryTreePaths(root));
	}
}
