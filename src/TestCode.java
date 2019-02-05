import java.util.*;
public class TestCode {
	public static void main(String[] args) {
//		PermutationsII test = new PermutationsII();
//		int[] nums = {1, 1, 2};
//		List<List<Integer>> result = test.permuteUnique(nums);
//		
//		for(List<Integer> eachRound : result) {
//			System.out.println(eachRound);
//		}
		
//		Trie trie = new Trie();
//		trie.insert("apple");
//		System.out.println(trie.search("apple"));
//		
//		System.out.println(trie.search("app"));     // returns false
//		System.out.println(trie.startsWith("app")); // returns true
//		trie.insert("app");   
//		System.out.println(trie.search("app"));  
		
		InsertionSortList test = new InsertionSortList();
		
		ListNode head = new ListNode(4);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(1);
		
		ListNode newHead = test.insertionSortList(head);
		while(newHead != null) {
			System.out.print(newHead.val + " -> ");
			newHead = newHead.next;
		}
	}
}
