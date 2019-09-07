import java.util.HashSet;
import java.util.Set;

public class LinkedListCycleII {
	public ListNode detectCycle(ListNode head) {
		Set<ListNode> set = new HashSet<>();
		ListNode startNode = null;
		while(head != null) {
			if(!set.add(head)) {
				startNode = head;
				break;
			}
			head = head.next;
		}
		return startNode;
	}
}
