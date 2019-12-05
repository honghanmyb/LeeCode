public class BinaryTreeColoringGame {
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        TreeNode nodeX =  findNode(root, x);
        int left = getCount(nodeX.left);
        int right = getCount(nodeX.right);
        return 1 + left + right <= n / 2 || Math.max(left, right) > n / 2;
    }

    private int getCount(TreeNode node){
        if(node == null){
            return 0;
        }
        return 1 + getCount(node.left) + getCount(node.right);
    }

    private TreeNode findNode(TreeNode node, int x){
        if(node == null){
            return null;
        }
        if(node.val == x){
            return node;
        }
        TreeNode left = findNode(node.left, x);
        TreeNode right = findNode(node.right, x);
        return left == null? right: left;
    }
}
