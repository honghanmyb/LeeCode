import java.util.*;
public class TestCode {
	public static void main(String[] args) {
		int[] listArray = {1, 2, 3, 4, 5, 6, 7};
		ListNode head = TestUtils.constructLinkedListFromArray(listArray);
		ReverseInKGroup test = new ReverseInKGroup();
		
		TestUtils.printLinkedList(test.reverseKGroup(head, 3));
//		TestUtils.printLinkedList(head);
	}

}
