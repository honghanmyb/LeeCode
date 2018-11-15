import java.util.*;
public class TreeLevelOrderTraversal {
	public List<List<Integer>> levelOrder(TreeNode root){
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(root == null) return result;
		List<TreeNode> original = new ArrayList<TreeNode>();
		List<Integer> rootInt = new ArrayList<Integer>();
		rootInt.add(root.val);
		original.add(root);
		levelOrderTra(original,rootInt, result);
		
		/*for(int i = 0; i < resultTreeNode.size(); i++) {
			List<Integer>lists = new ArrayList<Integer>();
			List<TreeNode> temp = resultTreeNode.get(i);
			for(int j = 0; j < temp.size(); j++) {
				lists.add(temp.get(j).val);
			}
			result.add(lists);
		}*/
		return result;
	}
	
	private void levelOrderTra(List<TreeNode> last,List<Integer> lastInt, List<List<Integer>> result) {
		resultTreeNode.add(last);
		result.add(lastInt);
		List<TreeNode> current = new ArrayList<TreeNode>();
		List<Integer> currentInt = new ArrayList<Integer>();
		for(int i = 0; i < last.size(); i++) {
			TreeNode temp = last.get(i);
			if(temp.left != null) {
				current.add(temp.left);
				currentInt.add(temp.left.val);
			}
			if(temp.right != null) {
				current.add(temp.right);
				currentInt.add(temp.right.val);
			}
		}
		if(current.size() == 0) return;
		levelOrderTra(current,currentInt, result);
	}
	List<List<TreeNode>> resultTreeNode = new ArrayList<List<TreeNode>>();
}
