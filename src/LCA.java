import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class LCA {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		Map<TreeNode, TreeNode> relations = new HashMap<>();
		addRelations(root, null, relations, p, q);
		Set<TreeNode> set = new HashSet<>();
		TreeNode temp = p;
		while(temp != null) {
			set.add(temp);
			temp = relations.get(temp);
		}
		
		temp = q;
		while(temp != null) {
			if(set.contains(temp)) return temp;
			temp = relations.get(temp);
		}
		return root;
	}
	
//	private boolean findNodeRoute(TreeNode child, TreeNode ancester, List<TreeNode> route) {
//		route.add(ancester);
//		if(ancester == child) return true;
//		if(ancester == null) return false;
//		if(findNodeRoute(child, ancester.left, route)) {
//			return true;
//		}
//		if(findNodeRoute(child, ancester.right, route)) {
//			return true;
//		}
//		route.remove(ancester);
//		return false;
//	}
	
	private void addRelations(TreeNode node, TreeNode ancester, Map<TreeNode, TreeNode> relations,
			TreeNode p, TreeNode q) {
		if(node == null) return;
		if(relations.containsKey(q) && relations.containsKey(p)) return;
		relations.put(node, ancester);
		addRelations(node.left, node, relations, p, q);
		addRelations(node.right, node, relations, p, q);
	}
}
