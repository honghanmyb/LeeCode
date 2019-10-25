import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class AutocompleteSystem {
    private RecordTrie dummy;
    private String previousInput;
    private RecordTrie currentTrie;
    private int totalWordCount;
    public AutocompleteSystem(String[] sentences, int[] times) {
        dummy = new RecordTrie("", 0);
        for(int i = 0; i < sentences.length; i++){
            dummy.insert(sentences[i], times[i]);
        }
        previousInput = "";
        currentTrie = dummy;
        totalWordCount = sentences.length;
    }
    
    public List<String> input(char c) {
        if(c == '#'){
            if(!this.previousInput.isEmpty()){
                dummy.insert(this.previousInput, 1);
            }
            this.previousInput = "";
            this.currentTrie = this.dummy;
            this.totalWordCount += 1;
            return new ArrayList<>(); 
        }
        if(this.currentTrie == null){
            previousInput += c;
            return new ArrayList<>();
        }
        this.currentTrie = c == ' '? this.currentTrie.nextWords[0]: this.currentTrie.nextWords[c - 'a' + 1];
        if(currentTrie == null){
            previousInput += c;
            return new ArrayList<>();
        }
        PriorityQueue<HotWord> hotWords = new PriorityQueue<>(this.totalWordCount, (word1, word2) -> {
           if(word1.time != word2.time){
               return word2.time - word1.time;
           }else{
               return word1.word.compareTo(word2.word);
           }
        });
         currentTrie.search(hotWords, previousInput);
        // Collections.sort(hotWords, (word1, word2) -> {
        //    if(word1.time != word2.time){
        //        return word2.time - word1.time;
        //    }else{
        //        return word1.word.compareTo(word2.word);
        //    }
        // });
        int size = Integer.min(3, hotWords.size());
        List<String> topHotWords = new ArrayList<>(size);
        for(int i = 0; i < size; i++){
            topHotWords.add(hotWords.poll().word);
        }
        previousInput += c;
        return topHotWords;
    }
    
    private class RecordTrie{
        char ch;
        boolean isEnd;
        int time;
        RecordTrie[] nextWords;
        
        public RecordTrie(String sentence, int time){
            //first char of sentence is stored in this trie
            nextWords = new RecordTrie[27];
            if(sentence.isEmpty()){
                return;
            }
            this.ch = sentence.charAt(0);
            if(sentence.length() == 1){
                this.isEnd = true;
                this.time = time;
                return;
            }
            String remainingSentence = sentence.substring(1);
            char nextCh = remainingSentence.charAt(0);
            if(nextCh == ' '){
                nextWords[0] = new RecordTrie(remainingSentence, time);
            }else{
                nextWords[nextCh - 'a' + 1] = new RecordTrie(remainingSentence, time);
            }
        }
        
        public void insert(String sentence, int time){
            //first char of sentence is stored in next trie
            if(sentence.isEmpty()){
                if(!this.isEnd){
                    this.isEnd = true;
                    this.time = time;
                }else{
                    this.time += time;
                }
                return;
            }
            char firstCh = sentence.charAt(0);
            if(firstCh == ' '){
                if(this.nextWords[0] == null){
                    this.nextWords[0] = new RecordTrie(sentence, time);
                }else{
                    this.nextWords[0].insert(sentence.substring(1), time);
                }
            }else{
                if(this.nextWords[firstCh - 'a' + 1] == null){
                    this.nextWords[firstCh - 'a' + 1] = new RecordTrie(sentence, time);
                }else{
                    this.nextWords[firstCh - 'a' + 1].insert(sentence.substring(1), time);
                }
            }
        }
        
        public void search(PriorityQueue<HotWord> hotWords, String previous){
            if(this.isEnd){
                hotWords.add(new HotWord(previous + this.ch, this.time));
            }
            if(this.nextWords == null){
                return;
            }
            for(RecordTrie nextWord: nextWords){
                if(nextWord != null){
                    nextWord.search(hotWords, previous + this.ch);
                }
            }
        }
    }
    
    private class HotWord{
        String word;
        int time;
        
        public HotWord(String word, int time){
            this.word = word;
            this.time = time;
        }
    }
}
