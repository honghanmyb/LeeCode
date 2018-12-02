import java.util.*;
public class BalancedTree {
	public boolean isBalanced(TreeNode root) {
		if(root == null) return true;
		
		if(isBalanced(root.left) && isBalanced(root.right)) {
			int left = height(root.left);
			int right = height(root.right);
			
			return (left <= right + 1 && right <= left + 1);
		}
		
		
		
		
		return false;
	}
	
	private int height(TreeNode root) {
		if(root == null) return 0;
		
		return Math.max(height(root.left), height(root.right)) + 1;
		
//		if(treeHeight.containsKey(root)) return treeHeight.get(root);
//		
//		
//		if(root.left == null && root.right == null) {
//			treeHeight.put(root, 1);
//			return 1;
//		}
//		int subTreeHeight = Math.max(height(root.left, treeHeight), height(root.right, treeHeight)) + 1;
//		treeHeight.put(root, subTreeHeight);
//		return subTreeHeight;
	}
	
//	HashMap<TreeNode, Integer> treeHeight = new HashMap<>();
}
