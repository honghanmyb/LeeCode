import java.util.*;
public class LevelOrderButtom {
	public List<List<Integer>> levelOrderButtom(TreeNode root){
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(root == null) return result;
		List<TreeNode> rootList = new ArrayList<>();
		rootList.add(root);
		levelOrderTraversal(rootList);
		for(int i = levelOrder.size() - 1; i >= 0; i--) {
			List<Integer> temp = new ArrayList<>();
			List<TreeNode> tempTree = levelOrder.get(i);
			for(int j = 0; j < tempTree.size(); j++) {
				temp.add(tempTree.get(j).val);
			}
			result.add(temp);
		}
		return result;
	}
	
	private void levelOrderTraversal(List<TreeNode> last) {
		if(last.size() == 0) return;
		levelOrder.add(last);
		List<TreeNode> current = new ArrayList<TreeNode>();
		for(int i = 0; i < last.size(); i++) {
			TreeNode temp = last.get(i);
			if(temp.left != null) current.add(temp.left);
			if(temp.right != null) current.add(temp.right);
		}
		levelOrderTraversal(current);
	}
	
	List<List<TreeNode>> levelOrder = new ArrayList<List<TreeNode>>();
}
