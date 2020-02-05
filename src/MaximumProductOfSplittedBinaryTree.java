import java.util.HashMap;
import java.util.Map;

public class MaximumProductOfSplittedBinaryTree {
    private long maxProduct;
    public int maxProduct(TreeNode root) {
        Map<TreeNode, Integer> nodeToSum = new HashMap<>();
        int totalSum = getSum(root, nodeToSum);
        maxProduct = 0;
        findMaxProduct(root, totalSum, nodeToSum);
        return (int)(maxProduct % 1000000007);
    }

    private void findMaxProduct(TreeNode node, int totalSum, Map<TreeNode, Integer> nodeToSum){
        if(node == null){
            return;
        }
        int curSum = nodeToSum.get(node);
        int remainSum = totalSum - curSum;
        long product = (long) curSum * (long)remainSum;
        maxProduct = Math.max(product, maxProduct);
        findMaxProduct(node.left, totalSum, nodeToSum);
        findMaxProduct(node.right, totalSum, nodeToSum);
    }

    private int getSum(TreeNode node, Map<TreeNode, Integer> nodeToSum){
        if(node == null){
            return 0;
        }
        int left = getSum(node.left, nodeToSum);
        int right = getSum(node.right, nodeToSum);
        int sum = left + right + node.val;
        nodeToSum.put(node, sum);
        return sum;
    }
}
