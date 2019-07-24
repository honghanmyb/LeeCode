import java.util.*;
public final class TreeUtil {
	private TreeUtil() {
		
	}
    public static String serialize(TreeNode root) {
        Queue<TreeNode> levelOrderQueue = new LinkedList<>();
		List<Integer> serializeData = new LinkedList<>();
		levelOrderQueue.add(root);
		while(serializeData.size() < Math.pow(2, getTreeLevel(root, 0)) - 1) {
			TreeNode currentHead = levelOrderQueue.poll();
			if(currentHead != null) {
				levelOrderQueue.add(currentHead.left);
				levelOrderQueue.add(currentHead.right);
				serializeData.add(currentHead.val);
			}else {
				levelOrderQueue.add(null);
				levelOrderQueue.add(null);
				serializeData.add(null);
			}
		}
		return serializeData.toString();
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if(data.equals("[]")) return null;
        String[] treeNodeVals = data.replace("[", "").replace("]", "").replaceAll(" ", "").split(",");
		TreeNode[] treeNodes = new TreeNode[treeNodeVals.length];
		for(int i = 0; i < treeNodeVals.length; i++) {
			if(!treeNodeVals[i].equals("null")) {
				treeNodes[i] = new TreeNode(Integer.parseInt(treeNodeVals[i]));
			}
		}
		
		for(int i = 0; i < treeNodes.length / 2; i++) {
			if(treeNodes[i] != null) {
				treeNodes[i].left = treeNodes[i * 2 + 1];
				treeNodes[i].right = treeNodes[i * 2 + 2];
			}
		}
		return treeNodes[0];
    }
    
    private static int getTreeLevel(TreeNode currentNode, int currentLevel) {
		if(currentNode != null) {
			return Math.max(getTreeLevel(currentNode.left, currentLevel + 1),
					getTreeLevel(currentNode.right, currentLevel + 1));
		}
		return currentLevel;
	}
}
