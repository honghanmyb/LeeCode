import java.util.*;
public class TestCode {
	public static void main(String[] args) {
		int[] nums = {2,1};
		ListNode head = Helper.createLinkedList(nums);
		PartitionList test = new PartitionList();
		head = test.partition(head, 2);
		
		while(head != null) {
			System.out.print(head.val + "-");
			head = head.next;
		}
	}
}
