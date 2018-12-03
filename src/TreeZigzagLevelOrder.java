import java.util.*;
public class TreeZigzagLevelOrder {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		if(root == null) return null;
		List<List<TreeNode>> levelOrder = new ArrayList<List<TreeNode>>();
		List<TreeNode> firstLevel = new ArrayList<>();
		firstLevel.add(root);
		levelOrder.add(firstLevel);
		List<TreeNode> lastLevel = firstLevel;
		boolean levelFlag = true;
		while(true) {
			List<TreeNode> nextLevel = new ArrayList<>();
			for(int i = lastLevel.size() - 1; i >= 0; i--) {
				TreeNode leftChild = lastLevel.get(i).left;
				TreeNode rightChild = lastLevel.get(i).right;
				
				if(levelFlag) {
					if(rightChild != null) nextLevel.add(rightChild);
					if(leftChild != null) nextLevel.add(leftChild);
				} else {
					if(leftChild != null) nextLevel.add(leftChild);
					if(rightChild != null) nextLevel.add(rightChild);
				}
			}

			levelFlag = !levelFlag;
			if(nextLevel.size() == 0) break;
			levelOrder.add(nextLevel);
			lastLevel = nextLevel;
		}
		
		List<List<Integer>> result = new ArrayList<>();
		for(int i = 0; i < levelOrder.size(); i++) {
			List<Integer> levelVal = new ArrayList<>();
			List<TreeNode> levelTree = levelOrder.get(i);
			for(int j = 0; j < levelTree.size(); j++) {
				levelVal.add(levelTree.get(j).val);
			}
			result.add(levelVal);
		}
		
		return result;
		
	}
}
