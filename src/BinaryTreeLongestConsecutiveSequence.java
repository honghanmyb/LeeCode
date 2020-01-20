public class BinaryTreeLongestConsecutiveSequence {
    private int longest = 1;
    public int longestConsecutive(TreeNode root) {
        if(root == null){
            return 0;
        }
        findLongest(root);
        return this.longest;
    }

    private int findLongest(TreeNode node){
        if(node == null){
            return 0;
        }
        int length = 1;
        int leftLength = findLongest(node.left);
        int rightLength = findLongest(node.right);
        if(node.left != null && node.left.val == node.val + 1){
            length = Math.max(length, 1 + leftLength);
        }
        if(node.right != null && node.right.val == node.val + 1){
            length = Math.max(length, 1 + rightLength);
        }
        longest = Math.max(longest, length);
        return length;
    }
}
