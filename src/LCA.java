import java.util.ArrayList;
import java.util.List;

public class LCA {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		List<TreeNode> pRoute = new ArrayList<>();
		List<TreeNode> qRoute = new ArrayList<>();
		findNodeRoute(p, root, pRoute);
		findNodeRoute(q, root, qRoute);
		for(int i = 0; i < Math.min(pRoute.size(), qRoute.size()) - 1; i++) {
			if(pRoute.get(i + 1) != qRoute.get(i + 1)) {
				return pRoute.get(i);
			}
		}
		return pRoute.get(Math.min(pRoute.size(), qRoute.size()) - 1);
	}
	
	private boolean findNodeRoute(TreeNode child, TreeNode ancester, List<TreeNode> route) {
		route.add(ancester);
		if(ancester == child) return true;
		if(ancester == null) return false;
		if(findNodeRoute(child, ancester.left, route)) {
			return true;
		}
		if(findNodeRoute(child, ancester.right, route)) {
			return true;
		}
		route.remove(ancester);
		return false;
	}
}
