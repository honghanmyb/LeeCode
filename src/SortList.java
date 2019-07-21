import java.util.Arrays;

public class SortList {
	public ListNode sortList(ListNode head) {
		if(head == null) return head;
		int listSize = 0;
		ListNode temp = head;
		while(temp != null) {
			listSize++;
			temp = temp.next;
		}
		
		int[] listVals = new int[listSize];
		temp = head;
		for(int i = 0; i < listSize; i++) {
			listVals[i] = temp.val;
			temp = temp.next;
		}
		Arrays.sort(listVals);
		ListNode[] listNodeArray = new ListNode[listSize];
//		temp = head;
//		while(temp != null) {
//			listNodeArray[getSortedIndex(listVals, temp.val, 0, listSize)] = temp;
//			temp = temp.next;
//		}
		for(int i = 0; i < listSize; i++) {
			listNodeArray[i] = new ListNode(listVals[i]);
		}
		
		for(int i = 0; i < listSize - 1; i++) {
			listNodeArray[i].next = listNodeArray[i + 1];
		}
		listNodeArray[listSize - 1].next = null;
		return listNodeArray[0];
	}
	
	private int getSortedIndex(int[] listVals, int val, int startIndex, int endIndex) {
		int middle = (startIndex + endIndex) / 2;
		if(listVals[middle] == val) {
			return middle;
		}
		if(listVals[middle] < val) {
			return getSortedIndex(listVals, val, middle, endIndex);
		}
		return getSortedIndex(listVals, val, startIndex, middle);
	}
}
