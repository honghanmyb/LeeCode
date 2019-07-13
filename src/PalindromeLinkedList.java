import java.util.ArrayList;
import java.util.List;

public class PalindromeLinkedList {
	public boolean isPalindrome(ListNode head) {
		if(head == null) {
			return true;
		}
		ListNode originDummyHead = new ListNode(0);
		originDummyHead.next = head;
		
		ListNode newDummyHead = new ListNode(0);
		ListNode temp = head;
		while(temp != null) {
			ListNode newNode = new ListNode(temp.val);
			newNode.next = newDummyHead.next;
			newDummyHead.next = newNode;
			temp = temp.next;
		}
		
		ListNode originPointer = head;
		ListNode newPointer = newDummyHead.next;
		
		while(originPointer != null) {
			if(originPointer.val != newPointer.val) {
				return false;
			}
			originPointer = originPointer.next;
			newPointer = newPointer.next;
		}
		
		return true;
	}
}
