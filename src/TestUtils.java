
public final class TestUtils {
	private TestUtils() {
		
	}
	
	public static ListNode constructLinkedListFromArray(int[] nums) {
		ListNode dummyHead = new ListNode(0);
		ListNode currentHead = dummyHead;
		ListNode temp;
		for(int i = 0; i < nums.length; i++) {
			temp = new ListNode(nums[i]);
			currentHead.next = temp;
			currentHead = temp;
		}
		
		return dummyHead.next;
	}
	
	public static void printLinkedList(ListNode head) {
		ListNode temp = head;
		while(temp != null) {
			System.out.print(temp.val + "-> ");
			temp = temp.next;
		}
	}
}
