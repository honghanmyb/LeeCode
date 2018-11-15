import java.util.*;

public class InorderTreversal {
	
	public List<Integer> inorderTreversal(TreeNode root){

		if(root != null) {
			inorderTreversal(root.left);
			returnList.add(root.val);
			inorderTreversal(root.right);
		}
		return returnList;
	}

	private List<Integer> returnList = new ArrayList<Integer>();
	

}
