import java.util.*;
public class TestCode {
	public static void main(String[] args) {
		int[] listNodeArray = {4,19,14,5,-3,1,8,5,11,15};
		ListNode head = TestUtils.constructLinkedListFromArray(listNodeArray);
		SortList test = new SortList();
		TestUtils.printLinkedList(test.sortList(head));
	}
}
