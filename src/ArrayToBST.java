
public class ArrayToBST {
	public TreeNode srotedArrayToBST(int[] nums) {
		TreeNode root = null;
		if(nums == null) return root;
		root = buildTree(0, nums.length, root, nums);
		return root;
	}
	
	private TreeNode buildTree(int head, int tail, TreeNode root, int[] nums) {
		int temp = (head + tail) / 2;
		root = insert(root, nums[temp]);
		if(temp != head) {
			root = buildTree(head, temp, root, nums);
			if(temp + 1 != tail) {
				root = buildTree(temp + 1, tail, root, nums);
			}

		}
		return root;
	}
	
	private TreeNode insert(TreeNode root, int val) {
		if(root == null) root = new TreeNode(val);
		else if(val < root.val) root.left = insert(root.left, val);
		else root.right = insert(root.right, val);
		return root;
	}
}
