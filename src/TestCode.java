import java.util.*;
public class TestCode {
	public static void main(String[] args) {
		ConstructBSTFromInorderAndPostorder test = new ConstructBSTFromInorderAndPostorder();
//		int[] inorder = {6, 9, 8, 3, 15, 20, 7};
//		int[] postorder = {6, 8, 9, 15, 7, 20, 3};
		int[] inorder = {2, 1};
		int[] postorder = {2, 1};
		System.out.println(TreeUtil.serialize(test.buildTree(inorder, postorder)));
	}
}
