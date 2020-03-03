public class LinkedListInBinaryTree {
    //The solution here uses two recursive methods
    //the first one checks if for the current treenode and all its decedents, there's a linked list
    //the second one checks if the current treenode correspond to the current linked list node
    public boolean isSubPath(ListNode head, TreeNode root) {
        if(head == null){
            return true;
        }
        if(root == null){
            return false;
        }
        return isPath(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    private boolean isPath(ListNode node, TreeNode curNode){
        if(node == null){
            return true;
        }
        if(curNode == null){
            return false;
        }
        return node.val == curNode.val && (isPath(node.next, curNode.left) || isPath(node.next, curNode.right));
    }
}
