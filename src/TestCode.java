import java.util.*;
public class TestCode {
	public static void main(String[] args) {
		IntersectionOfTwoLinkedLists test = new IntersectionOfTwoLinkedLists();
		ListNode headA = TestUtils.constructLinkedListFromArray(new int[] {4,1,8,4,5});
		ListNode headB = new ListNode(5);
		headB.next = new ListNode(0);
		headB.next.next = new ListNode(1);
		headB.next.next.next = headA.next.next;
		
		System.out.println(test.getIntersectionNode(headA, headB).val);
	}
}
