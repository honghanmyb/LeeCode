import java.util.*;
public class TestCode {
	public static void main(String[] args) {
		CountCompleteTreeNodes test = new CountCompleteTreeNodes();
		TreeNode root = TreeUtil.deserialize("[1, 2, 3, 4, 5, 6, null]");
		System.out.println(test.countNodes(root));
	}
}
