
public class ReverseList {
	public ListNode reverseList(ListNode head) {
		ListNode prev, current;
		prev = null; current = head;
		while(current != null) {
			ListNode temp;
			temp = current.next;
			current.next = prev;
			prev = current;
			current = temp;
		}
		
		return prev;
	}
}
