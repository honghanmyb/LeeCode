import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DeleteNodesAndReturnForests {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> roots = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for(int num: to_delete){
            set.add(num);
        }
        iterate(root, null, roots, set, true);
        return roots;
    }
    
    private void iterate(TreeNode currentNode, TreeNode parent, List<TreeNode> roots, Set<Integer> set, boolean isRoot){
        if(currentNode == null){
            return;
        }
        if(set.contains(currentNode.val)){
            if(parent != null){
                if(parent.left == currentNode){
                    parent.left = null;
                }else{
                    parent.right = null;
                }
            }
            iterate(currentNode.left, currentNode, roots, set, true);
            iterate(currentNode.right, currentNode, roots, set, true);
        }else {
            if(isRoot){
                roots.add(currentNode);
            }
            iterate(currentNode.left, currentNode, roots, set, false);
            iterate(currentNode.right, currentNode, roots, set, false);
        }
    }
}
