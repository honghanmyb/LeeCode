import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ConcatenatedWords {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> wordList = new ArrayList<>(words.length);
        Set<String> wordSet = new HashSet<>();
        for(String word: words){
            if(word.equals("")){
                continue;
            }
            wordList.add(word);
        }
        Collections.sort(wordList, (word1, word2) -> word1.length() - word2.length());
        List<String> concatenatedWordList = new ArrayList<>();
        if(wordList.isEmpty()){
            return concatenatedWordList;
        }
        wordSet.add(wordList.get(0));
        for(int i = 1; i < wordList.size(); i++){
            if(canForm(wordList.get(i), wordSet)){
                concatenatedWordList.add(wordList.get(i));
            }
            wordSet.add(wordList.get(i));
        }
        return concatenatedWordList;
    }
    
    private boolean canForm(String word, Set<String> wordSet){
        boolean[] canForm = new boolean[word.length() + 1];
        canForm[0] = true;
        for(int i = 1; i < canForm.length; i++){
            for(int j = 0; j < i; j++){
                if(wordSet.contains(word.substring(j, i)) && canForm[j] == true){
                    canForm[i] = true;
                    break;
                }
            }
        }
        return canForm[canForm.length - 1];
    }
}
