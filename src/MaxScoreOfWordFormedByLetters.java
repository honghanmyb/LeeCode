
public class MaxScoreOfWordFormedByLetters {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] scores = new int[words.length];
        int[] chNums = new int[26];
        int[][] wordChNums = new int[words.length][];
        for(char letter: letters){
            chNums[letter - 'a']++;
        }
        for(int i = 0; i < words.length; i++){
            scores[i] = getScore(words[i], chNums, score, i, wordChNums);
        }
        int maxScore = 0;
        for(int i = 0; i < scores.length; i++){
            maxScore = Math.max(maxScore, findMaxScore(i, scores, chNums, wordChNums, 0));
        }
        return maxScore;
    }
    
    private int findMaxScore(int startIndex, int[] scores, int[] chNums, int[][] wordChNums, int previousScore){
        int maxScore = previousScore;
        if(scores[startIndex] == 0){
            return previousScore;
        }
        for(int i = 0; i < chNums.length; i++){
            if(wordChNums[startIndex][i] > chNums[i]){
                return previousScore;
            }
        }
        for(int i = 0; i < chNums.length; i++){
            chNums[i] -= wordChNums[startIndex][i];
        }
        maxScore += scores[startIndex];
        int currentScore = maxScore;
        for(int i = startIndex + 1; i < scores.length; i++){
            maxScore = Math.max(maxScore, findMaxScore(i, scores, chNums, wordChNums, currentScore));
        }
        for(int i = 0; i < chNums.length; i++){
            chNums[i] += wordChNums[startIndex][i];
        }
        // System.out.println("index " + startIndex + ", score " + maxScore);
        return maxScore;
    }
    
    private int getScore(String word, int[] chNums, int[] score, int index, int[][] wordChNums){
        int[] wordCh = new int[26];
        int wordScore = 0;
        for(int i = 0; i < word.length(); i++){
            wordCh[word.charAt(i) - 'a']++;
            wordScore += score[word.charAt(i) - 'a'];
        }
        wordChNums[index] = wordCh;
        for(int i = 0; i < chNums.length; i++){
            if(wordCh[i] > chNums[i]){
                return 0;
            }
        }
        
        return wordScore;
    }
}
