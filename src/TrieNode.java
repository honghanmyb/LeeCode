
public class TrieNode {
	private int numChar = 26;
	
	public char ch;
	
	public TrieNode[] chList;
	
	public boolean isEnd = false;
	
	public TrieNode() {
		chList = new TrieNode[numChar];
		
	}
	
	public TrieNode(char ch) {
		this.ch = ch;
		chList = new TrieNode[numChar];
	}
}
