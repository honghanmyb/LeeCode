import java.util.*;
public class TestCode {
	public static void main(String[] args) {
		int[] listNodeArray = {1,1};
		ListNode head = TestUtils.constructLinkedListFromArray(listNodeArray);
		RemoveLinkedListElements test = new RemoveLinkedListElements();
		TestUtils.printLinkedList(test.removeElements(head, 1));
	}
}
