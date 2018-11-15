
public class AddTwoNums {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		if(length(l1) < length(l2)) {
			ListNode temp = l1;
			l1 = l2;
			l2 = temp;
		}
		ListNode p1 = l1, p2 = l2;
		while(p1 != null) {
			if(p2 != null) {
				int temp = p1.val + p2.val;
				if(temp >= 10) {
					if(p1.next == null) p1.next = new ListNode(1);
					else	p1.next.val++;
				}
				p1.val = temp % 10;
				p1 = p1.next; p2 = p2.next;
			}else {
				if(p1.val >=10) {
					p1.val %=10;
					if(p1.next != null) p1.next.val++;
					else p1.next = new ListNode(1);
				}
				p1 = p1.next;
			}
			
		}

		return l1;
	}
	

	private int length(ListNode head) {
		int count = 0;
		while(head != null) {
			count++;
			head = head.next;
		}
		return count;
	}
}
