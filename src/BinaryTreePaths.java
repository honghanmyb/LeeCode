import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
	public List<String> binaryTreePaths(TreeNode root){
		List<String> resultList = new ArrayList<>();
		if(root == null) return resultList;
		
		traverseTreeNode(resultList, root, "");
		return resultList;
	}
	
	private void traverseTreeNode(List<String> resultList, TreeNode currentNode, String currentString) {
		String nextString = currentString + currentNode.val;
		if(currentNode.left == null && currentNode.right == null) {
			resultList.add(nextString);
			return;
		}
		
		if(currentNode.left != null) {
			traverseTreeNode(resultList, currentNode.left, nextString + "->");
		}
		
		if(currentNode.right != null) {
			traverseTreeNode(resultList, currentNode.right, nextString + "->");
		}
	}
}
