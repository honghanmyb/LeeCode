import java.util.*;
public class TestCode {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.right.right = new TreeNode(5);
		root.right.left = new TreeNode(4);
		
		SerializeAndDeserialize test = new SerializeAndDeserialize();
		String serialize = test.serialize(root);
		System.out.println(serialize);
//		System.out.println(test.serialize(test.deserialize(serialize)));
	}
}
