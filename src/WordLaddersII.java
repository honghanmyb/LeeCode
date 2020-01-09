import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class WordLaddersII {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> remainWords = new HashSet<>();
        remainWords.addAll(wordList);
        if(!remainWords.contains(endWord)){
            return new ArrayList<>();
        }
        Queue<String> queue = new LinkedList<>();
        Set<String> usedWords = new HashSet<>();
        String flag = "";
        List<String> firstList = new ArrayList<>();
        Map<String, List<List<String>>> lastWordToLadders = new HashMap<>();
        for(String word : wordList){
            lastWordToLadders.put(word, new ArrayList<>());
        }
        lastWordToLadders.put(beginWord, new ArrayList<>());
        lastWordToLadders.get(beginWord).add(firstList);
        firstList.add(beginWord);
        queue.add(beginWord);
        queue.add(flag);
        List<List<String>> ladders = new ArrayList<>();
        lastWordToLadders.put(endWord, ladders);
        while(true){
            String curWord = queue.poll();
            if(curWord == flag){
                if(queue.isEmpty() || !ladders.isEmpty()){
                    break;
                }
                for(String word : usedWords){
                    remainWords.remove(word);
                }
                usedWords.clear();
                queue.add(flag);
                continue;
            }
            if(!lastWordToLadders.containsKey(curWord)){
                continue;
            }
            List<List<String>> laddersEndsWithCurWord = lastWordToLadders.get(curWord);
            lastWordToLadders.remove(curWord);
            List<String> nextWords = getNextWords(curWord, remainWords);
            if(nextWords.isEmpty()){
                continue;
            }
            for(String nextWord : nextWords){
                if(!lastWordToLadders.containsKey(nextWord)){
                    continue;
                }
                updateLadders(nextWord, lastWordToLadders, laddersEndsWithCurWord);
                queue.add(nextWord);
                usedWords.add(nextWord);
            }
        }
        return ladders;
    }

    private void updateLadders(String nextWord, Map<String, List<List<String>>> lastWordToLadders, List<List<String>> laddersEndsWithCurWord){
        List<List<String>> laddersEndsWithNextWord = lastWordToLadders.get(nextWord);
        for(List<String> ladderEndsWithCurWord : laddersEndsWithCurWord){
            List<String> nextList = new ArrayList<>(ladderEndsWithCurWord.size() + 1);
            nextList.addAll(ladderEndsWithCurWord);
            nextList.add(nextWord);
            laddersEndsWithNextWord.add(nextList);
        }
        lastWordToLadders.put(nextWord, laddersEndsWithNextWord);
    }

    private List<String> getNextWords(String lastWord, Set<String> remainWords){
        List<String> nextWords = new ArrayList<>();
        for(String word : remainWords){
            int count = 0;
            for(int i = 0; i < lastWord.length(); i++){
                if(lastWord.charAt(i) != word.charAt(i)){
                    count++;
                    if(count > 1){
                        break;
                    }
                }
            }
            if(count == 1){
                nextWords.add(word);
            }
        }
        return nextWords;
    }
}
