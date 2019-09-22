import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class BSTMaximumPathSum {
    private int maxPathSum = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        addAllPathSum(root);
        return maxPathSum;
    }
    
    private int addAllPathSum(TreeNode treeNode){
        if(treeNode == null){
            return 0;
        }
        int currentPathSum = treeNode.val;
        int left = addAllPathSum(treeNode.left);
        int right = addAllPathSum(treeNode.right);
        currentPathSum += left > 0? left: 0;
        currentPathSum += right > 0? right: 0;
        maxPathSum = Integer.max(maxPathSum, currentPathSum);
        int currentSum = Integer.max(left, right);
        if(currentSum <= 0){
            currentSum = treeNode.val;
        }else{
            currentSum += treeNode.val;
        }
        return currentSum;
    }
}
