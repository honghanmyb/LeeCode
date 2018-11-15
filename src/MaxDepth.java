
public class MaxDepth {
	public int maxDepth(TreeNode root) {
		int treeMaxDepth = 0, treeLeftDepth, treeRightDepth;
		if(root == null) return treeMaxDepth;
		treeLeftDepth = maxDepth(root.left);
		treeRightDepth = maxDepth(root.right);
		if(treeLeftDepth > treeRightDepth) return treeLeftDepth + 1;
		else return treeRightDepth + 1;
	}
}
