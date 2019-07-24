
public class BSTMinDepth {
	public int minDepth(TreeNode root) {
		if(root == null) {
			return 0;
		}
		int leftMin = minDepth(root.left);
		int rightMin = minDepth(root.right);
		return (leftMin * rightMin == 0 ? Math.max(leftMin, rightMin) : Math.min(leftMin, rightMin)) + 1;
	}
}
