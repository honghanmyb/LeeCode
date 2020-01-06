import java.util.ArrayList;
import java.util.List;

public class SearchSuggestionSystem {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        TrieNode head = new TrieNode('#');
        for(String product : products){
            addWord(head, product, 0);
        }
        List<List<String>> suggestions = new ArrayList<>();
        TrieNode curNode = head;
        for(int i = 0; i < searchWord.length(); i++){
            List<String> suggestion = new ArrayList<>();
            if(curNode != null){
                char curCh = searchWord.charAt(i);
                findAll(suggestion, curNode.nextChars[curCh - 'a']);
                curNode = curNode.nextChars[curCh - 'a'];
            }
            suggestions.add(suggestion);
        }
        return suggestions;
    }

    private void addWord(TrieNode curNode, String word, int chPos){
        if(chPos == word.length()){
            curNode.isWord = true;
            curNode.curWord = word;
            return;
        }
        char nextCh = word.charAt(chPos);
        if(curNode.nextChars[nextCh - 'a'] == null){
            curNode.nextChars[nextCh - 'a'] = new TrieNode(nextCh);
        }
        addWord(curNode.nextChars[nextCh - 'a'], word, chPos + 1);
    }

    private void findAll(List<String> suggestion, TrieNode nextNode){
        if(suggestion.size() == 3){
            return;
        }
        if(nextNode == null){
            return;
        }
        if(nextNode.isWord){
            suggestion.add(nextNode.curWord);
        }
        for(TrieNode node : nextNode.nextChars){
            if(node != null){
                findAll(suggestion, node);
            }
        }
    }

    private class TrieNode{
        char ch;
        boolean isWord;
        TrieNode[] nextChars;
        String curWord;

        TrieNode(char ch){
            this.ch = ch;
            this.isWord = false;
            this.nextChars = new TrieNode[26];
            this.curWord = null;
        }
    }
}
