import java.util.*;
public class TestCode {
	public static void main(String[] args) {
		RemoveNthNodeFromEndOfList test = new RemoveNthNodeFromEndOfList();
		ListNode head = TestUtils.constructLinkedListFromArray(new int[] {1,2,3,4,5});
		TestUtils.printLinkedList(test.removeNthFromEnd(head, 5));
	}
}
