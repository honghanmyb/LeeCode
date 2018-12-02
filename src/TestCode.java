import java.util.*;
public class TestCode {
	public static void main(String[] args) {
		TreeToLinkedList test = new TreeToLinkedList();
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(5);
		root.left.left = new TreeNode(3);
		root.left.left.left = new TreeNode(7);
		root.left.left.left.right = new TreeNode(11);
		root.left.left.right = new TreeNode(8);
		root.left.right = new TreeNode(4);
		root.left.right.right = new TreeNode(9);
		root.right.right = new TreeNode(6);
		root.right.right.left = new TreeNode(10);
		
		test.flatten(root);
		
		TreeNode temp = root;
		while(temp != null) {
			System.out.println(temp.val + " ");
			if(temp.left == null) temp = temp.right;
		}
		
	}
}
