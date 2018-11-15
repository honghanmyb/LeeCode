
public class RemoveDuplicate {
	public ListNode removeDuplicates(ListNode head) {
		if(head == null) return head;
		if(head.next == null) return head;
		ListNode current = head;
		ListNode next = head.next;
		while(next != null) {
			if(next.val == current.val) {
				current.next = next.next;
				next = current.next;
				continue;
			}
			current = next;
			next = next.next;
		}
		return head;
	}
}
