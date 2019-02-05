
public class InsertionSortList {
	public ListNode insertionSortList(ListNode head) {
		if(head == null) return null;
		
		ListNode newHead = head;
		head = head.next;
		newHead.next = null;
		while(head != null) {
			if(head.val <= newHead.val) {
				ListNode firstTemp = newHead;
				newHead = head;
				head = head.next;
				newHead.next = firstTemp;
				continue;
			}
			ListNode temp = newHead;
			while(true) {
				if(temp.next == null) break;
				if(temp.val < head.val && temp.next.val >= head.val) break;
				temp = temp.next;
			}
			ListNode nextTemp = temp.next;
			temp.next = head;
			head = head.next;
			temp.next.next = nextTemp;
			
			
		}
		return newHead;
	}
}
