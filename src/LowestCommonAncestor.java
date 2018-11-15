
public class LowestCommonAncestor {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		TreeNode small;
		TreeNode large;
		if(p.val > q.val) {
			small = q;
			large = p;
		}else {
			small = p;
			large = q;
		}
		TreeNode lca = root;
		/*while(true) {
			if(lca.val > large.val) {
				lca = lca.left;
				continue;
			}
			if(lca.val < small.val) {
				lca = lca.right;
				continue;
			}
			break;
		}*/
		
		return findLCA(lca, small, large);
	}
	
	private TreeNode findLCA(TreeNode lca, TreeNode small, TreeNode large) {
		if(lca.val > large.val) return findLCA(lca.left, small, large);
		if(lca.val < small.val) return findLCA(lca.right, small, large);
		return lca;
	}
}
