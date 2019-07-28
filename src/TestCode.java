import java.util.*;
public class TestCode {
	public static void main(String[] args) {
		MergeKSortedLists test = new MergeKSortedLists();
		ListNode[] lists = new ListNode[2];
		lists[0] = TestUtils.constructLinkedListFromArray(new int[] {1, 2, 3});
		lists[1] = TestUtils.constructLinkedListFromArray(new int[] {4, 5, 6, 7});
//		lists[2] = TestUtils.constructLinkedListFromArray(new int[] {2, 6});
		TestUtils.printLinkedList(test.mergeKLists(lists));
	}
}
