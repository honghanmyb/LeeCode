import java.util.*;
public class TestCode {
	public static void main(String[] args) {
		BSTMinDepth test = new BSTMinDepth();
		TreeNode root = TreeUtil.deserialize("[3,9,20,null,null,15,7]");
		System.out.println(test.minDepth(root));
	}
}
