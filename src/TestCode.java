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
		
		DPfindSlice test = new DPfindSlice();
		int[] S = {1, 1, -1, 1, 1, -1, 1};
//		int[] S = new int[1000];
//		for(int i = 0; i < S.length; i++) {
//			S[i] = -100;
//		}
		System.out.println(test.solution(S));
	}
}
