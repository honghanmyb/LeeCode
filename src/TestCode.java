import java.util.*;
public class TestCode {
	public static void main(String[] args) {
		ReverseLinkedListII test = new ReverseLinkedListII();
		ListNode head = TestUtils.constructLinkedListFromArray(new int[] {1, 2, 3, 4, 5});
		TestUtils.printLinkedList(test.reverseBetween(head, 4, 5));
	}
}
