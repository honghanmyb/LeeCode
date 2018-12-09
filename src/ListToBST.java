import java.util.*;
public class ListToBST {
	public TreeNode sortedListToBST (ListNode head) {
		if(head == null) return null;
		List<Integer> storedList = new ArrayList<>();
		while(head != null) {
			storedList.add(head.val);
			head = head.next;
		}
		
		return findBST(storedList, 0, storedList.size() - 1);
	}
	
	private TreeNode findBST(List<Integer> list, int startIndex, int endIndex) {
		if(startIndex == endIndex) {
			return new TreeNode(list.get(startIndex));
		}
//		if(startIndex == endIndex - 1) {
//			TreeNode newNode = new TreeNode(list.get(endIndex));
//			newNode.left = new TreeNode(list.get(startIndex));
//			return newNode;
//		}
		
		int newIndex = (startIndex + endIndex + 1) / 2;
		TreeNode newNode = new TreeNode(list.get(newIndex));
		if(newIndex > startIndex) {
			newNode.left = findBST(list, startIndex, newIndex - 1);
		}
		if(newIndex < endIndex) {
			newNode.right = findBST(list, newIndex + 1, endIndex);
		}

		
		return newNode;
	}
}
