
public class ConstructBSTFromInorderAndPostorder {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if(inorder.length == 0) {
			return null;
		}
		TreeNode root = new TreeNode(postorder[postorder.length - 1]);
		int rootIndex = getTreeNodeIndex(root.val, inorder, 0);
		root.left = constructTree(inorder, postorder, 0, rootIndex, 0, rootIndex);
		root.right = constructTree(inorder, postorder, rootIndex + 1, inorder.length,
				rootIndex, postorder.length - 1);
		return root;
	}
	
	//startIndex include, stopIndex exclude
	private TreeNode constructTree(int[] inorder, int[] postorder, int inorderStartIndex,
			int inorderStopIndex, int postorderStartIndex, int postorderStopIndex) {
		if(inorderStartIndex >= inorderStopIndex) {
			return null;
		}
		
		TreeNode treeNode = new TreeNode(postorder[postorderStopIndex - 1]);
		int treeNodeIndex = getTreeNodeIndex(treeNode.val, inorder, inorderStartIndex);
		
		int postorderLeftStopIndex = treeNodeIndex - inorderStartIndex + postorderStartIndex;
		int postorderRightStartIndex = postorderStopIndex - inorderStopIndex + treeNodeIndex;
		treeNode.left = constructTree(inorder, postorder, inorderStartIndex, treeNodeIndex,
				postorderStartIndex, postorderLeftStopIndex);
		treeNode.right = constructTree(inorder, postorder, treeNodeIndex + 1, inorderStopIndex,
				postorderRightStartIndex, postorderStopIndex - 1);
		
		return treeNode;
	}
	
	private int getTreeNodeIndex(int val, int[] inorder, int startIndex) {
		int temp = startIndex;
		while(inorder[temp] != val) {
			temp++;
		}
		
		return temp;
	}
}
