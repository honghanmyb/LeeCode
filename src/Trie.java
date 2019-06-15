
public class Trie {
	private TrieNode dummyHead;
	public Trie() {
		dummyHead = new TrieNode();
	}
	
	public void insert(String word) {
		insertWordAtPos(word, 0, dummyHead);
	}
	
	public boolean search(String word) {
		return searchWordAtPos(word, 0, dummyHead);
	}
	
	public boolean startsWith(String prefix) {
		return searchStartWith(prefix, 0, dummyHead);
	}
	
	private void insertWordAtPos(String word, int index, TrieNode trieNode) {
		TrieNode newTrieNode;
		if(trieNode.chList[word.charAt(index) - 'a'] == null) {
			newTrieNode = new TrieNode(word.charAt(index));
			trieNode.chList[word.charAt(index) - 'a'] = newTrieNode;
		}else {
			newTrieNode = trieNode.chList[word.charAt(index) - 'a'];
		}
		if(index + 1 == word.length()) {
			newTrieNode.isEnd = true;
			return;
		}
		insertWordAtPos(word, index + 1, newTrieNode);
	}
	
	private boolean searchWordAtPos(String word, int index, TrieNode trieNode) {
		TrieNode nodeAtPos = trieNode.chList[word.charAt(index) - 'a'];
		if(nodeAtPos == null) return false;
		if(index == word.length() - 1) {
			if(nodeAtPos.isEnd) {
				return true;
			}
			return false;
		}
		return searchWordAtPos(word, index + 1, nodeAtPos);
	}
	
	private boolean searchStartWith(String prefix, int index, TrieNode trieNode) {
		TrieNode nodeAtPos = trieNode.chList[prefix.charAt(index) - 'a'];
		if(nodeAtPos == null) return false;
		if(index == prefix.length() - 1) return true;
		return searchStartWith(prefix, index + 1, nodeAtPos);
	}
}
