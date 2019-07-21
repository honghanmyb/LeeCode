
public class RemoveLinkedListElements {
	public ListNode removeElements(ListNode head, int val) {
		if(head == null) return head;
		ListNode dummyHead = new ListNode(0);
		dummyHead.next = head;
		ListNode temp = dummyHead;
		
		while(temp != null) {
			ListNode next = temp.next;
			if(next == null) {
				break;
			}
			if(next.val == val) {
				temp.next = next.next;
			}else {
				temp = temp.next;
			}
		}
		
		return dummyHead.next;
	}
}
