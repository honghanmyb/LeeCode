import java.util.*;
public class RightSideView {
	public List<Integer> rightSideView(TreeNode root){
		List<Integer> result = new ArrayList<>();
		if(root == null) return result;
		List<TreeNode> current = new ArrayList<>();
		current.add(root);
		getLevelOrder(current);

		for(int i = 0; i < levelOrder.size(); i++) {
			result.add(levelOrder.get(i).get(0).val);
		}
		return result;
	}
	
	private void getLevelOrder(List<TreeNode> last) {
		if(last.size() == 0) return;
		levelOrder.add(last);
		List<TreeNode> current = new ArrayList<>();
		for(int i = 0; i < last.size(); i++) {
			if(last.get(i).right != null) {
				current.add(last.get(i).right);
			}
			if(last.get(i).left != null) {
				current.add(last.get(i).left);
			}

		}
		getLevelOrder(current);
		
	}
	
	List<List<TreeNode>> levelOrder = new ArrayList<List<TreeNode>>();
}
