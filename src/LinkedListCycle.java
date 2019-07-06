import java.util.HashSet;

public class LinkedListCycle {
	public boolean hasCycle(ListNode head) {
//		HashSet<ListNode> set = new HashSet<>();
//		ListNode temp = head;
//		while(temp != null) {
//			if(set.contains(temp)) {
//				return true;
//			}
//			set.add(temp);
//			temp = temp.next;
//		}
//		return false;
		if(head == null) return false;
		if(head.next == null) return false;
		ListNode slow = head;
		ListNode fast = head.next;
		while(slow != fast) {
			if(fast.next != null) {
				fast = fast.next.next;
			} else {
				return false;
			}
			if(slow != null) {
				slow = slow.next;
			}
			if(fast == null) {
				return false;
			}
		}
		
		return true;
	}
}
