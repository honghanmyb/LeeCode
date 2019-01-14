import java.util.*;
public class ConstructTree {
	public TreeNode buildTree(int[] preorder, int[] inorder) {

		return newBuildTree(preorder, inorder, 0, preorder.length, 0, inorder.length);
	}
	
	private TreeNode newBuildTree(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
		if(preStart == preEnd) return null;
		TreeNode root = new TreeNode(preorder[preStart]);
		int rootIndexIn = 0;
		for(int i = inStart; i < inEnd; i++) {
			if(inorder[i] == preorder[preStart]) {
				rootIndexIn = i;
				break;
			}
		}
		int leftInStart = inStart;
		int leftInEnd = rootIndexIn;
		int leftPreStart = preStart + 1;
		int leftPreEnd = leftPreStart + leftInEnd - leftInStart;
		
		int rightInStart = rootIndexIn + 1;
		int rightInEnd = inEnd;
		int rightPreEnd = preEnd;
		int rightPreStart = rightInStart - rightInEnd + rightPreEnd;

		root.left = newBuildTree(preorder, inorder, leftPreStart, leftPreEnd, leftInStart, leftInEnd);
		root.right = newBuildTree(preorder, inorder, rightPreStart, rightPreEnd, rightInStart, rightInEnd);
		return root;
	}
}
