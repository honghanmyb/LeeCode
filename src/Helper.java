
public final class Helper {
	public static ListNode createLinkedList(int[] nums) {
		ListNode head = new ListNode(nums[0]);
		ListNode currentNode = head;
		for(int i = 1; i < nums.length; i++) {
			ListNode newNode = new ListNode(nums[i]);
			currentNode.next = newNode;
			currentNode = newNode;
		}
		
		return head;
	}
}
