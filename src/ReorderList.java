
public class ReorderList {
	public void reorderList(ListNode head) {
		if(head == null || head.next == null) {
			return;
		}
		if(head.next.next == null) {
			return;
		}
		ListNode firstListHead = head;
		ListNode secondListHead;
		ListNode temp = head;
		int count = 0;
		while(temp != null) {
			temp = temp.next;
			count++;
		}
		temp = head;
		count = count / 2;
		while(count > 0) {
			temp = temp.next;
			count--;
		}
		secondListHead = temp.next;
		temp.next = null;
		
		ListNode previous = null, current = secondListHead, next = current.next;
		while(current != null) {
			current.next = previous;
			previous = current;
			current = next;
			if(next != null) {
				next = next.next;
			}
		}
		ListNode firstTemp = firstListHead, secondTemp = previous;
		while(firstTemp != null) {
			if(secondTemp == null) {
				break;
			}
			ListNode firstTempNext = firstTemp.next;
			ListNode secondTempNext = secondTemp.next;
			firstTemp.next = secondTemp;
			secondTemp.next = firstTempNext;
			firstTemp = firstTempNext;
			secondTemp = secondTempNext;
		}
	}
}
