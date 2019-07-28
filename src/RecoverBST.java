import java.util.ArrayList;
import java.util.List;

public class RecoverBST {
	public void recoverTree(TreeNode root) {
		if(root == null) {
			return;
		}
		TreeNode misPlaceSmall = null, misPlaceLarge = null;
		List<TreeNode> bstList = new ArrayList<>();
		bstList.add(new TreeNode(Integer.MIN_VALUE));
		putBstInorder(bstList, root);
		bstList.add(new TreeNode(Integer.MAX_VALUE));
		
		int misPlaceSmallNext = 0;
		for(int i = 1; i < bstList.size() - 1; i++) {
			if(misPlaceSmall != null && misPlaceLarge != null) {
				break;
			}
			TreeNode current = bstList.get(i);
			if(misPlaceSmall == null) {
				TreeNode later = bstList.get(i + 1);
				if(current.val > later.val) {
					misPlaceSmall = current;
					i++;
					misPlaceSmallNext = i;
					continue;
				}
			}
			if(misPlaceLarge == null) {
				TreeNode former = bstList.get(i - 1);
				if(current.val < former.val) {
					misPlaceLarge = current;
				}
			}
		}
		if(misPlaceLarge == null) {
			misPlaceLarge = bstList.get(misPlaceSmallNext);
		}
		
		int temp = misPlaceSmall.val;
		misPlaceSmall.val = misPlaceLarge.val;
		misPlaceLarge.val = temp;
	}
	
	private void putBstInorder(List<TreeNode> bstList, TreeNode treeNode) {
		if(treeNode == null) {
			return;
		}
		putBstInorder(bstList, treeNode.left);
		bstList.add(treeNode);
		putBstInorder(bstList, treeNode.right);
	}
}
