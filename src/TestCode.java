import java.util.*;
public class TestCode {
	public static void main(String[] args) {
		ConstructTree test = new ConstructTree();
		int[] preorder = {3,9,5,20,15,7};
		int[] inorder = {5,9,3,15,20,7};
		
		
		System.out.println(InorderTreversal.inorderTreversal(test.buildTree(preorder, inorder)));

	}
}
