
public class CountCompleteTreeNodes {
	public int countNodes(TreeNode root) {
		if(root == null) {
			return 0;
		}
		if(root.left == null && root.right == null) {
			System.out.println(root.val);
			return 1;
		}
		return countNodes(root.left) + countNodes(root.right) + 1;
	}
}
