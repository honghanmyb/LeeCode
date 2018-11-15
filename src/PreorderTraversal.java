/*
 * Preorder Traversal: access the root first, then left child, then right child.
 */
import java.util.*;

public class PreorderTraversal {
	public List<Integer> preorderTraversal(TreeNode root){
		result = new ArrayList<Integer>();
		preorder(root);
		return result;
	}
	private void preorder(TreeNode root) {
		if(root == null) return;
		result.add(root.val);
		preorder(root.left);
		preorder(root.right);
	}
	
	ArrayList<Integer> result;
}
