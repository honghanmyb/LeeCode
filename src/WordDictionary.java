
public class WordDictionary {
	WordElement startWord;
	public WordDictionary() {
		startWord = new WordElement('.');
	}
	
	public void addWord(String word) {
		startWord.addWord(word);
	}
	
	public boolean search(String word) {
		return startWord.search(word);
	}
	
	private class WordElement {
		private char ch;
		private boolean isEnd;
		private WordElement[] nextWords;
		
		public WordElement(char ch) {
			this.ch = ch;
			nextWords = new WordElement[26];
		}
		
		public void addWord(String word) {
			if(word.equals("")) {
				this.isEnd = true;
				return;
			}
			char leadingWord = word.charAt(0);
			if(this.nextWords[leadingWord - 'a'] == null) {
				this.nextWords[leadingWord - 'a'] = new WordElement(leadingWord);
			}
			this.nextWords[leadingWord - 'a'].addWord(word.substring(1));
		}
		
		public boolean search(String word) {
			if(word.equals("")) {
				return this.isEnd;
			}
			char firstCh = word.charAt(0);
			if(firstCh != '.') {
				WordElement nextElement = this.nextWords[firstCh - 'a'];
				if(nextElement == null) {
					return false;
				}
				return nextElement.search(word.substring(1));
			}
			for(WordElement nextElement: this.nextWords) {
				if(nextElement != null) {
					if(nextElement.search(word.substring(1))) {
						return true;
					}
				}
			}
			return false;
		}
	}
}
