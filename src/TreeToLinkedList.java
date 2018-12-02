
public class TreeToLinkedList {
	public void flatten(TreeNode root) {
		if(root == null) return;
		
		flatten(root.left);
		flatten(root.right);
		
		setOneLine(root);
	}
	
	private void setOneLine(TreeNode root) {
		if(root.left == null) return;
		TreeNode temp = root.left;
		TreeNode lastRight = null;
		while(temp != null) {
			lastRight = temp;
			temp = temp.right;
		}
		lastRight.right = root.right;
		root.right = root.left;
		root.left = null;
		
	}
}
