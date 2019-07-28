import java.util.*;
public class TestCode {
	public static void main(String[] args) {
		RecoverBST test = new RecoverBST();
//		TreeNode root = TreeUtil.deserialize("[3,1,4,null,null,2, null]");
		TreeNode root = TreeUtil.deserialize("[1,3,null,null,2]");
		test.recoverTree(root);
		System.out.println(TreeUtil.serialize(root));
	}
}
