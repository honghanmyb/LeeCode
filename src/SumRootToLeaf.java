
public class SumRootToLeaf {
	public int sumNumbers(TreeNode root) {
		if(root == null) return 0;
		addSum(root, 0);
		
		return sum;
	}
	
	private void addSum(TreeNode root, int currentSum) {
		if(root == null) return;
		currentSum = currentSum * 10 + root.val;
		if(root.left == null && root.right == null) {
			sum += currentSum;
			return;
		}
		addSum(root.left, currentSum);
		addSum(root.right, currentSum);
	}
	
	private int sum = 0;
}
