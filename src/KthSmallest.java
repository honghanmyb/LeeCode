
public class KthSmallest {
	public int kthSmallest(TreeNode root, int k) {
		TreeNode smallest = findSmallest(root);
		if(k == 1) return smallest.val;
		TreeNode kthSmall = findKthSmallest(root, smallest, k);
		return kthSmall.val;
		
	}
	
	private TreeNode findSmallest(TreeNode root) {
		if(root.left == null) return root;
		return findSmallest(root.left);
	}
	
	private TreeNode findKthSmallest(TreeNode root, TreeNode smallest, int k) {
		TreeNode nextLarge = null;
		TreeNode last = smallest;
		for(int i = 1; i < k; i++) {
			nextLarge = findNextLarge(root, last);
			last = nextLarge;
			System.out.println(i + 1 + " " + nextLarge.val);
		}
		
		return nextLarge;
	}
	
	private TreeNode findNextLarge(TreeNode root, TreeNode current) {
		if(current.right != null) return findSmallest(current.right);
		TreeNode last = findLast(root, current);
		while(last.val < current.val) last = findLast(root, last);
		return last;
	}
	
	private TreeNode findLast(TreeNode root, TreeNode current) {
		TreeNode temp = root;
		if(temp.left == current || temp.right == current) return temp;
		if(temp.val > current.val) return findLast(temp.left, current);
		return findLast(temp.right, current);
	}
}
