import java.util.Stack;

public class ReverseInKGroup {
	public ListNode reverseKGroup(ListNode head, int k) {
		ListNode dummyHead = new ListNode(0);
		dummyHead.next = head;
		ListNode currentHead;
		ListNode currentTail;
		ListNode nextHead;
		ListNode beforeHead = dummyHead;
		while(true) {
			currentTail = beforeHead;
			currentHead = beforeHead.next;
			for(int i = 0; i < k; i++) {
				if(currentTail != null) {
					currentTail = currentTail.next;
				}
			}
			if(currentTail == null) {
				break;
			}
			
			nextHead = currentTail.next;
			beforeHead.next = currentTail;
			
			ListNode temp = currentHead.next;
			ListNode tempHead = currentHead;
			while(temp != nextHead) {
				ListNode nextTemp = temp.next;
				temp.next = tempHead;
				tempHead = temp;
				temp = nextTemp;
			}

			currentHead.next = nextHead;
			beforeHead = currentHead;
		}
		
		return dummyHead.next;
	}
}
