import java.util.*;
public class MergeTwoLists {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1.val > l2.val) {
			ListNode temp = l1;
			l1 = l2;
			l2 = temp;
		}
		ListNode m = l1,  n = l2;
		while(n != null) {
			while(true) {
				if(m.next == null) {
					m.next = n;
					return l1;
				}
				if(m.next.val > n.val) break;
				m = m.next;
			}

			ListNode temp = n;
			n = n.next;
			temp.next = m.next;
			m.next = temp;
			m = temp.next;
		}
		
		int a = 0;

		return l1;
	}
}
