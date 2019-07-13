import java.util.*;
public class TestCode {
	public static void main(String[] args) {
		int[] linkedListArray = {-129, -129, -128};
		ListNode head = TestUtils.constructLinkedListFromArray(linkedListArray);
		PalindromeLinkedList test = new PalindromeLinkedList();
		
		System.out.println(test.isPalindrome(head));
//		System.out.println(-129 != -129);
	}
}
