import java.util.*;
public class PathSumII {
	public List<List<Integer>> pathSum(TreeNode root, int sum){
		List<List<Integer>> arraySum = new ArrayList<>();
		
		findPathSum(root, new ArrayList<Integer>(), sum, arraySum);
		return arraySum;
	}
	
	private void findPathSum(TreeNode root, List<Integer> last, int sum, List<List<Integer>> arraySum) {
		if(root == null) {
//			if(sum == 0) {
//				arraySum.add(last);
//			}
			return ;
		}
//		if(root.val > sum) return;
		
//		List<Integer> current = new ArrayList<>();
//		current.addAll(last);
//		current.add(root.val);
		last.add(root.val);
		
		if(root.left == null && root.right == null && root.val == sum) {
			List<Integer> current = new ArrayList<>();
			current.addAll(last);
			arraySum.add(current);
			return;
		}
		if(root.left != null) {
			findPathSum(root.left, last, sum - root.val, arraySum);
			last.remove(last.size() - 1);
		}
		if(root.right != null) {
			findPathSum(root.right, last, sum - root.val, arraySum);
			last.remove(last.size() - 1);
		}

	}
}
