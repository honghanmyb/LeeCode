
public final class TestUtils {
	private TestUtils() {
		
	}
	
	public static ListNode constructLinkedListFromArray(int[] nums) {
		ListNode head = new ListNode(nums[0]);
		ListNode temp = head.next;
		for(int i = 1; i < nums.length; i++) {
			temp = new ListNode(nums[i]);
			temp = temp.next;
		}
		
		return head;
	}
}
