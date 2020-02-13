import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BoundaryOfBinaryTree {
    private List<Integer> leftBoundary;
    private List<Integer> rightBoundary;
    private List<Integer> leafNodes;
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        if(root.left == null && root.right == null){
            return Collections.singletonList(root.val);
        }
        this.leftBoundary = new ArrayList<>();
        this.rightBoundary = new ArrayList<>();
        this.leafNodes = new ArrayList<>();
        addLeftBoundary(root);
        addRightBoundary(root);
        addAllLeafNodes(root);
        if(root.left == null){
            leftBoundary.clear();
        }
        if(root.right == null){
            rightBoundary.clear();
        }
        if(!leftBoundary.isEmpty()){
            leafNodes.remove(0);
        }
        if(!rightBoundary.isEmpty()){
            leafNodes.remove(leafNodes.size() - 1);
        }
        if(!leftBoundary.isEmpty()){
            leftBoundary.remove(0);
        }
        if(!rightBoundary.isEmpty()){
            rightBoundary.remove(rightBoundary.size() - 1);
        }
        List<Integer> boundary = new ArrayList<>(1 + leftBoundary.size() + rightBoundary.size() + leafNodes.size());
        boundary.add(root.val);
        boundary.addAll(leftBoundary);
        boundary.addAll(leafNodes);
        boundary.addAll(rightBoundary);
        return boundary;
    }

    private void addLeftBoundary(TreeNode node){
        if(node == null){
            return;
        }
        leftBoundary.add(node.val);
        if(node.left != null){
            addLeftBoundary(node.left);
        }else if(node.right != null){
            addLeftBoundary(node.right);
        }
    }

    private void addRightBoundary(TreeNode node){
        if(node == null){
            return;
        }
        if(node.right != null){
            addRightBoundary(node.right);
        }else if(node.left != null){
            addRightBoundary(node.left);
        }
        rightBoundary.add(node.val);
    }

    private void addAllLeafNodes(TreeNode node){
        if(node == null){
            return;
        }
        addAllLeafNodes(node.left);
        addAllLeafNodes(node.right);
        if(node.left == null && node.right == null){
            leafNodes.add(node.val);
        }
    }
}
