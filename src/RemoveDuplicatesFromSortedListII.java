
public class RemoveDuplicatesFromSortedListII {
	public ListNode deleteDuplicates(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}
		ListNode dummyHead = new ListNode(head.val - 1);
		ListNode dummyTail = new ListNode(head.val - 1);
		dummyHead.next = head;
		ListNode previousNode = dummyHead;
		ListNode nextNode = head;
		while(nextNode.next != null) {
			nextNode = nextNode.next;
		}
		nextNode.next = dummyTail;
		dummyTail.val = nextNode.val + 1;
		nextNode = head;
		while(nextNode.next != null) {
			if(nextNode.val != nextNode.next.val) {
				nextNode = nextNode.next;
				previousNode = previousNode.next;
				continue;
			}
			while(nextNode.val == nextNode.next.val) {
				nextNode = nextNode.next;
			}
			previousNode.next = nextNode.next;
			nextNode = nextNode.next;
		}
		nextNode = dummyHead.next;
		if(nextNode == dummyTail) {
			return null;
		}
		while(nextNode.next.val != dummyTail.val) {
			nextNode = nextNode.next;
		}
		nextNode.next = null;
		return dummyHead.next;
	}
}
