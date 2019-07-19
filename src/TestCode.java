import java.util.*;
public class TestCode {
	public static void main(String[] args) {
		UniqueBSTII test = new UniqueBSTII();
		List<TreeNode> trees = test.generateTrees(1);
		for(TreeNode treeRoot: trees) {
			System.out.println(TreeUtil.serialize(treeRoot));
		}
	}
}
