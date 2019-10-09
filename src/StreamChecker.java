
public class StreamChecker {
    private WordTrie wordTrie;
    private String previousQueries = "";
    private int longestWordLength = 0;
    private String[] words;
    public StreamChecker(String[] words) {
        wordTrie = new WordTrie("#");
        wordTrie.isWord = false;
        this.words = words;
        for(String word: words){
            wordTrie.insert(word);
            longestWordLength = Integer.max(longestWordLength, word.length());
        }
    }
    
    public boolean query(char letter) {
        previousQueries += letter;
        if(previousQueries.length() > longestWordLength){
            previousQueries = previousQueries.substring(1);
        }
        WordTrie currentTrie = this.wordTrie;
        for(int i = previousQueries.length() - 1; i >= 0; i--){
            char currentCh = previousQueries.charAt(i);
            if(currentTrie.wordList[currentCh - 'a'] != null){
                currentTrie = currentTrie.wordList[currentCh - 'a'];
                if(currentTrie.isWord){
                    return true;
                }
            }else{
                return false;
            }
        }
        return false;
    }
    
    private class WordTrie{
        char ch;
        boolean isWord = false;
        WordTrie[] wordList;
        
        public WordTrie(String word){
            this.ch = word.charAt(word.length() - 1);
            this.wordList = new WordTrie[26];
            if(word.length() == 1){
                this.isWord = true;
                return;
            }
            char nextCh = word.charAt(word.length() - 2);
            wordList[nextCh - 'a'] = new WordTrie(word.substring(0, word.length() - 1));
        }
        
        public void insert(String word){
            if(word.isEmpty()){
                this.isWord = true;
                return;
            }
            char currentCh = word.charAt(word.length() - 1);
            if(wordList[currentCh - 'a'] != null){
                wordList[currentCh - 'a'].insert(word.substring(0, word.length() - 1));
            }else{
                wordList[currentCh - 'a'] = new WordTrie(word);
            }
        }
    }
}
