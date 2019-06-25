import java.util.*;
public class SerializeAndDeserialize {
	public String serialize(TreeNode root) {
		Queue<TreeNode> levelOrderQueue = new LinkedList<>();
		List<Integer> serializeData = new ArrayList<>();
		levelOrderQueue.add(root);
		while(serializeData.size() < Math.pow(2, getTreeLevel(root, 0)) - 1) {
			TreeNode currentHead = levelOrderQueue.poll();
			if(currentHead != null) {
				levelOrderQueue.add(currentHead.left);
				levelOrderQueue.add(currentHead.right);
				serializeData.add(currentHead.val);
			}else {
				serializeData.add(null);
			}
		}
		return serializeData.toString();
	}
	
	public TreeNode deserialize(String data) {
		return null;
	}
	
	private int getTreeLevel(TreeNode currentNode, int currentLevel) {
		if(currentNode != null) {
			return Math.max(getTreeLevel(currentNode.left, currentLevel + 1),
					getTreeLevel(currentNode.right, currentLevel + 1));
		}
		return currentLevel;
	}
}
