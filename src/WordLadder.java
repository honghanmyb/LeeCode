import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new LinkedList<>();
        boolean[] used = new boolean[wordList.size()];
        int count = 1;
        String flag = "";
        queue.add(beginWord);
        queue.add(flag);
        while(true){
            String curS = queue.poll();
            if(curS == flag){
                if(queue.isEmpty()){
                    return 0;
                }
                count++;
                queue.add(flag);
                continue;
            }
            if(curS.equals(endWord)){
                break;
            }
            for(int i = 0; i < wordList.size(); i++){
                String word = wordList.get(i);
                if(!used[i] && isNextStep(curS, word)){
                    queue.add(word);
                    used[i] = true;
                }
            }
        }
        return count;
    }

    private boolean isNextStep(String curS, String nextS){
        int count = 0;
        if(curS.length() != nextS.length()){
            return false;
        }
        for(int i = 0; i < curS.length(); i++){
            if(curS.charAt(i) != nextS.charAt(i)){
                count++;
            }
        }
        return count == 1;
    }
}
