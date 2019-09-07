import java.util.*;
public class TestCode {
	public static void main(String[] args) {
		LinkedListCycleII test = new LinkedListCycleII();
		ListNode head = TestUtils.constructLinkedListFromArray(new int[] {3, 2, 0, 4});
		head.next.next.next.next = head.next;
		System.out.println(test.detectCycle(head).val);
	}
}
