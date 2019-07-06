import java.util.*;
public class TestCode {
	public static void main(String[] args) {
		ListNode head = new ListNode(3);
		head.next = new ListNode(2);
		head.next.next = new ListNode(0);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = head.next;
		LinkedListCycle test = new LinkedListCycle();
		
		System.out.println(test.hasCycle(head));
	}

}
