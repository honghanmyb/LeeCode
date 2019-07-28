
public class MergeKSortedLists {
	public ListNode mergeKLists(ListNode[] lists) {
		if(lists.length == 0) {
			return null;
		}
		if(lists.length == 1) {
			return lists[0];
		}
		
		ListNode mergedListDummyHead = new ListNode(Integer.MIN_VALUE);
		mergedListDummyHead.next = lists[0];
		for(int i = 1; i < lists.length; i++) {
			ListNode insertStartNode = mergedListDummyHead;
			ListNode tempListNode = lists[i];
			while(tempListNode != null) {
				ListNode tempNextListNode = tempListNode.next;
				insertStartNode = insertNodeToList(insertStartNode, tempListNode);
				tempListNode = tempNextListNode;
			}
		}
		
		return mergedListDummyHead.next;
	}
	
	private ListNode insertNodeToList(ListNode dummyHead, ListNode insertedNode) {
		ListNode temp = dummyHead;
		while(true) {
			if(temp.next == null) {
				insertedNode.next = temp.next;
				temp.next = insertedNode;
				break;
			}
			if(temp.val <= insertedNode.val && temp.next.val > insertedNode.val) {
				insertedNode.next = temp.next;
				temp.next = insertedNode;
				break;
			}
			temp = temp.next;
		}
		
		return insertedNode;
	}
}
