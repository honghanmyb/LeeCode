
public class StreamChecker {
    private WordTrie wordTrie;
    private String previousQueries = "";
    public StreamChecker(String[] words) {
        wordTrie = new WordTrie("#");
        wordTrie.isWord = false;
        for(String word: words){
            wordTrie.insert(word);
        }
    }
    
    public boolean query(char letter) {
        
        return false;
    }
    
    private class WordTrie{
        char ch;
        boolean isWord = false;
        WordTrie[] wordList;
        
        public WordTrie(String word){
            this.ch = word.charAt(0);
            this.wordList = new WordTrie[26];
            if(word.length() == 1){
                this.isWord = true;
                return;
            }
            char nextCh = word.charAt(1);
            wordList[nextCh - 'a'] = new WordTrie(word.substring(1));
        }
        
        public void insert(String word){
            if(word.isEmpty()){
                this.isWord = true;
                return;
            }
            char currentCh = word.charAt(0);
            if(wordList[currentCh - 'a'] != null){
                wordList[currentCh - 'a'].insert(word.substring(1));
            }else{
                wordList[currentCh - 'a'] = new WordTrie(word);
            }
        }
        
        public boolean isWord(String word){
            if(word.isEmpty()){
                return this.isWord;
            }
            char currentCh = word.charAt(0);
            if(wordList[currentCh - 'a'] == null){
                return false;
            }
            return wordList[currentCh - 'a'].isWord(word.substring(1));
        }
    }
}
