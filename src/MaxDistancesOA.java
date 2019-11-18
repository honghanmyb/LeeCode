
public class MaxDistancesOA {
	public int maxDistance(String[] strings) {
		Trie head = new Trie(".");
		head.isEnd = false;
		for(String s: strings) {
			if(!s.equals("")) {
				head.insert(s);
			}
		}
		
		return head.longestCommon();
	}
	
	private class Trie{
		public int num;
		public Trie[] nextTrie;
		public int[] nextLength;
		public boolean isEnd = false;
		
		public Trie(String s) {
			this.num = s.charAt(0) - '0';
			this.nextTrie = new Trie[2];
			this.nextLength = new int[2];
			if(s.length() == 1) {
				this.isEnd = true;
				return;
			}
			int nextStartNum = s.charAt(1) - '0';
			this.nextLength[nextStartNum] = Integer.max(this.nextLength[nextStartNum], s.length() - 1);
			this.nextTrie[nextStartNum] = new Trie(s.substring(1));
		}
		
		public void insert(String s) {
			if(s.length() == 0) {
				this.isEnd = true;
				return;
			}
			int nextNum = s.charAt(0) - '0';
			this.nextLength[nextNum] = Integer.max(this.nextLength[nextNum], s.length());
			if(this.nextTrie[nextNum] == null) {
				this.nextTrie[nextNum] = new Trie(s);
			}else {
				this.nextTrie[nextNum].insert(s.substring(1));
			}
		}
		public int longestCommon() {
			int max = 0;
			if(this.nextTrie[0] != null) {
				max = Integer.max(max, this.nextTrie[0].longestCommon());
			}
			if(this.nextTrie[1] != null) {
				max = Integer.max(max, this.nextTrie[1].longestCommon());
			}
			if(this.nextTrie[0] != null && this.nextTrie[1] != null) {
				max = Integer.max(max, this.nextLength[0] + this.nextLength[1]);
			}
			if(this.isEnd) {
				max = Integer.max(max, Integer.max(this.nextLength[0], this.nextLength[1]));
			}
			return max;
		}
	}
}
