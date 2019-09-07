import java.util.*;
public class TestCode {
	public static void main(String[] args) {
		LinkedListCycleII test = new LinkedListCycleII();
		ListNode head = TestUtils.constructLinkedListFromArray(new int[] {-1,-7,7,-4,19,6,-9,-5,-2,-5});
		head.next.next.next.next.next.next.next.next.next = head.next;
		System.out.println(test.detectCycle(head).val);
	}
}
