import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class BSTMaximumPathSum {
	public int maxPathSum(TreeNode root) {
        Map<TreeNode, Integer> treeNodeToPathSum = new HashMap<>();
        int maxPathSum = root.val;
        addAllPathSum(root, treeNodeToPathSum);
        int left = root.left == null? 0: treeNodeToPathSum.get(root.left);
        int right = root.right == null? 0: treeNodeToPathSum.get(root.right);
        maxPathSum += left > 0? left: 0;
        maxPathSum += right > 0? right: 0;
        for(Entry<TreeNode, Integer> entry: treeNodeToPathSum.entrySet()){
            TreeNode currentNode = entry.getKey();
            int currentPathSum = currentNode.val;
            left = currentNode.left == null? 0: treeNodeToPathSum.get(currentNode.left);
            right = currentNode.right == null? 0: treeNodeToPathSum.get(currentNode.right);
            currentPathSum += left > 0? left: 0;
            currentPathSum += right > 0? right: 0;
            maxPathSum = Integer.max(maxPathSum, currentPathSum);
        }
        return maxPathSum;
	}
	
    private int addAllPathSum(TreeNode treeNode, Map<TreeNode, Integer> treeNodeToPathSum){
        if(treeNode == null){
            return 0;
        }
        int left = addAllPathSum(treeNode.left, treeNodeToPathSum);
        int right = addAllPathSum(treeNode.right, treeNodeToPathSum);
        int currentSum = Integer.max(left, right);
        if(currentSum <= 0){
            currentSum = treeNode.val;
        }else{
            currentSum += treeNode.val;
        }
        treeNodeToPathSum.put(treeNode, currentSum);
        return currentSum;
    }
}
