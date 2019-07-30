import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoLinkedLists {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		Set<ListNode> nodeSet = new HashSet<>();
		ListNode tempA = headA, tempB = headB;
		while(tempA != null) {
			nodeSet.add(tempA);
			tempA = tempA.next;
		}
		
		while(tempB != null) {
			if(nodeSet.contains(tempB)) {
				return tempB;
			}
			tempB = tempB.next;
		}
		
		return null;
	}
}
