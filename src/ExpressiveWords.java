import java.util.ArrayList;
import java.util.List;

public class ExpressiveWords {
    public int expressiveWords(String S, String[] words) {
        if(words.length == 0){
            return 0;
        }
        List<PatternElement> sPattern = getWordPattern(S);
        int count = 0;
        for(String word: words){
            List<PatternElement> wordPattern = getWordPattern(word);
            if(isSamePattern(sPattern, wordPattern)){
                count++;
            }
        }
        
        return count;
    }
    
    private List<PatternElement> getWordPattern(String word){
        List<PatternElement> pattern = new ArrayList<>();
        int chPos = 0;
        if(word.isEmpty()){
            return pattern;
        }
        char currentCh = word.charAt(chPos);
        int count = 0;
        while(chPos < word.length()){
            if(word.charAt(chPos) == currentCh){
                count++;
                chPos++;
            }else{
                pattern.add(new PatternElement(currentCh, count));
                currentCh = word.charAt(chPos);
                count = 0;
            }
        }
        pattern.add(new PatternElement(currentCh, count));
        return pattern;
    }
    
    private boolean isSamePattern(List<PatternElement> sPattern, List<PatternElement> wordPattern){
        if(sPattern.size() != wordPattern.size()){
            return false;
        }
        int size = sPattern.size();
        for(int i = 0; i < size; i++){
            PatternElement sElement = sPattern.get(i);
            PatternElement wordElement = wordPattern.get(i);
            if(sElement.ch != wordElement.ch){
                return false;
            }
            if(sElement.count < wordElement.count){
                return false;
            }
            if(sElement.count < 3 && sElement.count != wordElement.count){
                return false;
            }
        }
        return true;
    }
    
    private class PatternElement{
        char ch;
        int count;
        public PatternElement(char ch, int count){
            this.ch = ch;
            this.count = count;
        }
    }
}
