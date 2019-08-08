import java.util.Stack;

public class RemoveNthNodeFromEndOfList {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode dummyHead = new ListNode(0);
		dummyHead.next = head;
		ListNode temp = dummyHead;
		int listNodeNum = 0;
		while(temp != null) {
			listNodeNum++;
			temp = temp.next;
		}
		
		temp = dummyHead;
		for(int i = 0; i < listNodeNum - n - 1; i++) {
			temp = temp.next;
		}
		ListNode nodeToRemove = temp.next;
		temp.next = nodeToRemove.next;
		return dummyHead.next;
	}
}
