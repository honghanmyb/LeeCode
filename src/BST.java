
public class BST {
	public TreeNode buildBST(int[] nums) {
		TreeNode root = null;
		for(int i = 0; i < nums.length; i++) {
			root = insert(root, nums[i]);
		}

		return root;
		
	}
	
	private TreeNode insert(TreeNode root, int val) {
		if(root == null) {
			root = new TreeNode(val);

		}
		else if(root.val > val) {
			root.left = insert(root.left, val);
			
		}
		else root.right = insert(root.right, val);
		
		return root;
	}
	
	//TreeNode root ;
}
