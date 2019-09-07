import java.util.HashSet;
import java.util.Set;

public class LinkedListCycleII {
	public ListNode detectCycle(ListNode head) {
		ListNode slowRunner, fastRunner;
		fastRunner = hasCycle(head);
		if(fastRunner == null) {
			return null;
		}
		slowRunner = head;
		while(fastRunner != slowRunner) {
			fastRunner = fastRunner.next;
			slowRunner = slowRunner.next;
		}
		return fastRunner;
	}
	
	//assumes a linked list has cycle, distance from head to startNode = x, distance from startNode to 
	//slow and fast runner meets = y, from meet point to end of list is z
	//when slow and fast runner meets, if slow travels t, then fast travels 2t(because slow speed is 1, fast is 2)
	//so t = x + y, 2t = x + y + z + y
	//so x = z, which means from head to startNode equals from meet point to end of list
	private ListNode hasCycle(ListNode head) {
		ListNode slowRunner, fastRunner;
		slowRunner = head.next;
		if(slowRunner == null) {
			return null;
		}
		fastRunner = slowRunner.next;
		if(fastRunner == null) {
			return null;
		}
		while(fastRunner != slowRunner) {
			if(fastRunner == null || slowRunner == null ||fastRunner.next == null) {
				return null;
			}
			fastRunner = fastRunner.next.next;
			slowRunner = slowRunner.next;
		}
		return fastRunner;
	}
}
