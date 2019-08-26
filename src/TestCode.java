import java.util.*;
public class TestCode {
	public static void main(String[] args) {
		RemoveDuplicatesFromSortedListII test = new RemoveDuplicatesFromSortedListII();
		ListNode head = TestUtils.constructLinkedListFromArray(new int[] { 2, 1});
		TestUtils.printLinkedList(test.deleteDuplicates(head));
	}
}
