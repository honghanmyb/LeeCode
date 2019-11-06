
public class SubtreeOfAnotherTree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null && t == null){
            return true;
        }
        if(s == null && t != null){
            return false;
        }
        if(s != null && t == null){
            return false;
        }
        if(s.val == t.val){
            if(isStrictSubtree(s.left, t.left) && isStrictSubtree(s.right, t.right)){
                return true;
            }
        }
        if(isSubtree(s.left, t) || isSubtree(s.right, t)){
            return true;
        }
        
        return false;
    }
    
    private boolean isStrictSubtree(TreeNode s, TreeNode t){
        if(s == null && t == null){
            return true;
        }
        if(s == null && t != null){
            return false;
        }
        if(s != null && t == null){
            return false;
        }
        if(s.val != t.val){
            return false;
        }
        if(isStrictSubtree(s.left, t.left) && isStrictSubtree(s.right, t.right)){
            return true;
        }
        return false;
    }
}
