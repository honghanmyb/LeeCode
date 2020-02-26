import java.util.HashSet;
import java.util.Set;

public class TwoSumBSTs {
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        addNodesToSet(root1, set1);
        addNodesToSet(root2, set2);
        for(Integer val : set1){
            if(set2.contains(target - val)){
                return true;
            }
        }
        return false;
    }

    private void addNodesToSet(TreeNode node, Set<Integer> set){
        if(node == null){
            return;
        }
        set.add(node.val);
        addNodesToSet(node.left, set);
        addNodesToSet(node.right, set);
    }
}
