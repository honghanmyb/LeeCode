public class ConstructBinaryTreeFromPreorderAndPostorder {
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        return construct(pre, 0, pre.length - 1, post, 0, post.length - 1);
    }

    private TreeNode construct(int[] pre, int preStart, int preEnd, int[] post, int postStart, int postEnd){
        TreeNode mid = new TreeNode(pre[preStart]);
        if(preStart == preEnd){
            return mid;
        }
        if(pre[preStart + 1] == post[postEnd - 1]){
            mid.left = construct(pre, preStart + 1, preEnd, post, postStart, postEnd - 1);
            return mid;
        }
        int postChildNode = post[postEnd - 1];
        int preChildNodePos = preStart;
        for(int i = preStart + 1; i <= preEnd; i++){
            if(pre[i] == postChildNode){
                preChildNodePos = i;
                break;
            }
        }
        int postChildNodePos = preChildNodePos - preStart - 1 + postStart;
        mid.left = construct(pre, preStart + 1, preChildNodePos - 1, post, postStart, postChildNodePos - 1);
        mid.right = construct(pre, preChildNodePos, preEnd, post, postChildNodePos, postEnd - 1);
        return mid;
    }
}
