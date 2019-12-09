import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GuessTheWord {
    public void findSecretWord(String[] wordlist, Master master) {
        Arrays.sort(wordlist);
        List<String> remainWords = new ArrayList<>(Arrays.asList(wordlist));
        String guessWord = wordlist[0];
        int match = 0;
        int count = 10;
        while(count > 0){
            match = master.guess(guessWord);
            count--;
            if(match == 6){
                return;
            }
            List<String> curWords = new ArrayList<>();
            for(String word : remainWords){
                if(countMatch(guessWord, word) == match){
                    curWords.add(word);
                }
            }
            remainWords = curWords;
            guessWord = remainWords.get(0);
        }
    }

    private int countMatch(String guessWord, String word){
        int count = 0;
        for(int i = 0; i < word.length(); i++){
            if(guessWord.charAt(i) == word.charAt(i)){
                count++;
            }
        }
        return count;
    }

    private class Master{
        int guess(String word){
            return 0;
        }
    }
}
