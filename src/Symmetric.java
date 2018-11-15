

public class Symmetric {
	public boolean isSymmetric(TreeNode root) {
		if(root == null) return true;
		TreeNode p = root.left;
		TreeNode q = root.right;
		
		return findIfSymmetric(p, q);
	}
	
	private boolean findIfSymmetric(TreeNode p, TreeNode q) {
		if(p == null && q == null) return true;
		if(p == null && q != null) return false;
		if(p != null && q == null) return false;
		if(p.val != q.val) return false;
		if(findIfSymmetric(p.left, q.right) && findIfSymmetric(p.right, q.left)) return true;
		
		return false;
	}

}
