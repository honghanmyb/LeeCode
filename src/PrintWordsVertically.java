import java.util.ArrayList;
import java.util.List;

public class PrintWordsVertically {
    public List<String> printVertically(String s) {
        String[] words = s.split(" ");
        int maxLength = 0;
        for(String word : words){
            maxLength = Math.max(maxLength, word.length());
        }
        List<String> verticalWords = new ArrayList<>(maxLength);
        for(int curIndex = 0; curIndex < maxLength; curIndex++){
            String curVerticalWord = "";
            for(String word : words){
                if(word.length() <= curIndex){
                    curVerticalWord += " ";
                    continue;
                }
                curVerticalWord += word.charAt(curIndex);
            }
            int lastCharIndex = 0;
            for(int i = curVerticalWord.length() - 1; i >= 0; i--){
                if(curVerticalWord.charAt(i) != ' '){
                    lastCharIndex = i;
                    break;
                }
            }
            verticalWords.add(curVerticalWord.substring(0, lastCharIndex + 1));
        }
        return verticalWords;
    }
}
