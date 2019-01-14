import java.util.*;

public class InorderTreversal {
	
	public static List<Integer> inorderTreversal(TreeNode root){

		if(root != null) {
			inorderTreversal(root.left);
			returnList.add(root.val);
			inorderTreversal(root.right);
		}
		return returnList;
	}

	private static List<Integer> returnList = new ArrayList<Integer>();
	

}
