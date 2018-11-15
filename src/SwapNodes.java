
public class SwapNodes {
	public ListNode swapPairs(ListNode head) {
		//head = swapListNodes(head, null);
		
		return swapListNodes(head, null);
	}
	
	private ListNode swapListNodes(ListNode head, ListNode priviousHead) {
		if(head == null) return head;
		if(head.next == null) return head;
		
		ListNode temp = head.next;
		head.next = temp.next;
		temp.next = head;
		head = temp;
		if(priviousHead != null) {
			priviousHead.next = head;
		}
		swapListNodes(head.next.next, head.next);
		return head;
	}
}
