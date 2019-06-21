
public class PartitionList {
	public ListNode partition(ListNode head, int x) {
		ListNode dummyHead = new ListNode(0);
		dummyHead.next = head;
		ListNode largeNodeHold = head;
		ListNode nodeBeforeLargeNode = dummyHead;
		while(largeNodeHold != null) {
			if(largeNodeHold.val >= x) break;
			nodeBeforeLargeNode = largeNodeHold;
			largeNodeHold = largeNodeHold.next;
		}
		ListNode currentNode = largeNodeHold;
		ListNode nodeBeforeCurrentNode = nodeBeforeLargeNode;
		while(currentNode != null) {
			if(currentNode.val < x){
				nodeBeforeCurrentNode.next = currentNode.next;
				currentNode.next = largeNodeHold;
				nodeBeforeLargeNode.next = currentNode;
				nodeBeforeLargeNode = currentNode;
				currentNode = nodeBeforeCurrentNode.next;
				continue;
			}
			nodeBeforeCurrentNode = currentNode;
			currentNode = currentNode.next;
		}
		return dummyHead.next;
	}
}
