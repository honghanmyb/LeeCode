import java.util.Stack;

public class RemoveNthNodeFromEndOfList {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode dummyHead = new ListNode(0);
		dummyHead.next = head;
		Stack<ListNode> stack = new Stack<>();
		ListNode temp = dummyHead;
		while(temp != null) {
			stack.add(temp);
			temp = temp.next;
		}
		
		for(int i = 0; i < n; i++) {
			temp = stack.pop();
		}
		ListNode nextNode = stack.pop();
		nextNode.next = temp.next;
		return dummyHead.next;
	}
}
