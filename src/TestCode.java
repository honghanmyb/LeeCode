import java.util.*;
public class TestCode {
	public static void main(String[] args) {
		ListNode head = TestUtils.constructLinkedListFromArray(new int[] {
				1, 2, 3, 4, 5
		});
		ReorderList test = new ReorderList();
		test.reorderList(head);
		TestUtils.printLinkedList(head);
	}
}
