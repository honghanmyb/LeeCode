
public class ReverseLinkedListII {
	public ListNode reverseBetween(ListNode head, int m, int n) {
		if(m == n) {
			return head;
		}
		ListNode nodeBeforeM = null;
		ListNode dummyHead = new ListNode(0);
		dummyHead.next = head;
		ListNode prev = null, current = dummyHead;
		while(m > 0) {
			prev = nodeBeforeM = current;
			current = current.next;
			m--;
			n--;
		}
		ListNode nodeNext = null;
		while(n >= 0) {
			nodeNext = current.next;
			current.next = prev;
			prev = current;
			current = nodeNext;
			n--;
		}
		nodeBeforeM.next.next = nodeNext;
		nodeBeforeM.next = prev;
		return dummyHead.next;
	}
}
