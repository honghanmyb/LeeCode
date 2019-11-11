import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ConcatenatedWords {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> concatenatedWords = new ArrayList<>();
        if(words.length <= 1){
            return concatenatedWords;
        }
        
        Set<String> wordSet = new HashSet<>();
        for(String word: words){
            if(word.equals("")){
                continue;
            }
            wordSet.add(word);
        }
        for(String word: words){
            if(word.equals("")){
                continue;
            }
            wordSet.remove(word);
            if(isConcatenatedWord(word, wordSet)){
                concatenatedWords.add(word);
            }
            wordSet.add(word);
        }
        return concatenatedWords;
    }
    
    private boolean isConcatenatedWord(String word, Set<String> wordSet){
        boolean[] canForm = new boolean[word.length() + 1];
        canForm[0] = true;
        for(int i = 1; i < canForm.length; i++){
            if(canForm[i - 1] == false){
                continue;
            }
            for(int j = i; j < canForm.length; j++){
                if(wordSet.contains(word.substring(i - 1, j))){
                    canForm[j] = true;
                }
            }
        }
        return canForm[canForm.length - 1];
    }
}
