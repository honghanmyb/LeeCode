import java.util.*;
public class SerializeAndDeserialize {
	private int currentIndex = 0;
	public String serialize(TreeNode root) {
		List<Integer> serializeData = new ArrayList<>();
		preorderTraversal(root, serializeData);
		return serializeData.toString();
	}
	
	public TreeNode deserialize(String data) {
		if(data.equals("[]")) return null;
		String[] treeNodeVals = data.replace("[", "").replace("]", "").replaceAll(" ", "").split(",");

		TreeNode root = reconstructTree(treeNodeVals);
		return root;
	}
	
	private void preorderTraversal(TreeNode currentNode, List<Integer> serializeData) {
		if(currentNode == null) {
			serializeData.add(null);
			return;
		}
		serializeData.add(currentNode.val);
		preorderTraversal(currentNode.left, serializeData);
		preorderTraversal(currentNode.right, serializeData);
	}
	
	private TreeNode reconstructTree(String[] treeNodeVals) {
		if(currentIndex >= treeNodeVals.length) return null;
		if(treeNodeVals[currentIndex].equals("null")) return null;
		TreeNode currentNode = new TreeNode(Integer.parseInt(treeNodeVals[currentIndex]));
		currentIndex += 1;
		currentNode.left = reconstructTree(treeNodeVals);
		currentIndex += 1;
		currentNode.right = reconstructTree(treeNodeVals);
		
		return currentNode;
	}
}
