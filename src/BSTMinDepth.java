
public class BSTMinDepth {
	private int minDepth = Integer.MAX_VALUE;
	public int minDepth(TreeNode root) {
		int currentLevel = 1;
		if(root == null) {
			return 0;
		}
		traversalTree(root, currentLevel);
		return minDepth;
	}
	
	private void traversalTree(TreeNode treeNode, int currentLevel) {
		if(currentLevel >= minDepth) {
			return;
		}
		TreeNode leftNode = treeNode.left;
		TreeNode rightNode = treeNode.right;
		if(leftNode == null && rightNode == null) {
			minDepth = Math.min(minDepth, currentLevel);
			return;
		}
		if(leftNode != null) {
			traversalTree(leftNode, currentLevel + 1);
		}
		if(rightNode != null) {
			traversalTree(rightNode, currentLevel + 1);
		}
	}
}
