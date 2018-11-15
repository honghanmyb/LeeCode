
public class BSTIterator {
	public BSTIterator(TreeNode root) {
		this.root = root;
		currentReturnVal = findSmallest(root);
		firstCall = true;
	}
	
	public boolean hasNext(){
		if(firstCall == false) {
			currentReturnVal = nextLarge(currentReturnVal);
		}

		if(currentReturnVal != null) return true;
		return false;
	}
	
	public int next() {
		if(firstCall == true) {
			firstCall = false;
		}
		
		return currentReturnVal.val;
	}
	private TreeNode nextLarge(TreeNode current) {
		if(current.right != null) {
			return findSmallest(current.right);
		}
		return findFirstLeftFather(current, this.root);
		
	}
	
	private TreeNode findSmallest(TreeNode root) {
		TreeNode temp = root;
		if(temp == null) return null;
		while(true) {
			if(temp.left != null) temp = temp.left;
			else return temp;
		}
	}
	
	private TreeNode findFirstLeftFather(TreeNode current, TreeNode root) {
		if(root == null) return null;
		if(root.val == current.val) return findSmallest(root.right);
		if(root.val > current.val) {
			TreeNode left = findFirstLeftFather(current, root.left);
			if(left == null) return root;
			return left;
		}else {
			return findFirstLeftFather(current, root.right);
		}
		
	}
	TreeNode currentReturnVal;
	TreeNode root;
	boolean firstCall;
	
}
