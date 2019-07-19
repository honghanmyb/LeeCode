import java.util.ArrayList;
import java.util.List;

public class UniqueBSTII {
	public List<TreeNode> generateTrees(int n){
		List<TreeNode> treeRoots = new ArrayList<>();
		for(int i = 1; i <= n; i++) {
			List<TreeNode> treesWithRoot = generateTreesWithRoot(1, i, n);
			treeRoots.addAll(treesWithRoot);
		}
		
		return treeRoots;
	}
	
	private List<TreeNode> generateTreesWithRoot(int startNum, int rootNum, int endNum){
		List<TreeNode> rootListAll = new ArrayList<>();
		if(startNum == rootNum && rootNum == endNum) {
			rootListAll.add(new TreeNode(rootNum));
			return rootListAll;
		}
		
		List<TreeNode> leftListAll = new ArrayList<>();
		List<TreeNode> rightListAll = new ArrayList<>();
		for(int i = startNum; i < rootNum; i++) {
			leftListAll.addAll(generateTreesWithRoot(startNum, i, rootNum - 1));
		}
		if(leftListAll.isEmpty()) {
			leftListAll.add(null);
		}
		
		for(int i = rootNum + 1; i <= endNum; i++) {
			rightListAll.addAll(generateTreesWithRoot(rootNum + 1, i, endNum));
		}
		if(rightListAll.isEmpty()) {
			rightListAll.add(null);
		}
		
		for(int i = 0; i < leftListAll.size(); i++) {
			for(int j = 0; j < rightListAll.size(); j++) {
				TreeNode root = new TreeNode(rootNum);
				root.left = leftListAll.get(i);
				root.right = rightListAll.get(j);
				rootListAll.add(root);
			}
		}
		
		return rootListAll;
	} 
}
