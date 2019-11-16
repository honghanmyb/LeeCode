import java.util.LinkedList;
import java.util.Queue;

public class MaxLevelSumOfBinaryTreeOA {
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> currentQueue = new LinkedList<>();
        Queue<TreeNode> nextQueue = new LinkedList<>();
        currentQueue.add(root);
        int maxLevelIndex = 1;
        int maxLevelSum = root.val;
        int currentLevel = 1;
        while(!currentQueue.isEmpty()){
            int currentLevelSum = 0;
            while(!currentQueue.isEmpty()){
                TreeNode node = currentQueue.poll();
                if(node.left != null){
                    nextQueue.add(node.left);
                }
                if(node.right != null){
                    nextQueue.add(node.right);
                }
                currentLevelSum += node.val;
            }
            if(currentLevelSum > maxLevelSum){
                maxLevelSum = currentLevelSum;
                maxLevelIndex = currentLevel;
            }
            currentLevel++;
            Queue<TreeNode> temp = currentQueue;
            currentQueue = nextQueue;
            nextQueue = temp;
        }
        
        return maxLevelIndex;
    }
}
