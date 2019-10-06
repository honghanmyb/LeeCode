import java.util.Arrays;

public class CompareStringByFrequencyOfSmallestChar {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] queryFrequency = new int[queries.length];
        int[] wordFrequency = new int[words.length];
        for(int i = 0; i < queries.length; i++){
            queryFrequency[i] = smallestCharFrequency(queries[i]);
        }
        for(int i = 0; i < words.length; i++){
            wordFrequency[i] = smallestCharFrequency(words[i]);
        }
        Arrays.sort(wordFrequency);
        int[] numSmaller = new int[queries.length];
        for(int i = 0; i < numSmaller.length; i++){
            numSmaller[i] = countNumLarger(queryFrequency[i], wordFrequency);
        }
        return numSmaller;
    }
    
    private int countNumLarger(int queryFrequency, int[] wordFrequency){
        // int head = 0, tail = wordFrequency.length - 1;
        // while(head <= tail){
        //     int mid = head + (tail - head) / 2;
        //     if(wordFrequency[mid] > queryFrequency){
        //         tail = mid - 1;
        //     }else{
        //         head = mid ;
        //     }
        // }
        for(int i = 0; i < wordFrequency.length; i++){
            if(wordFrequency[i] > queryFrequency){
                return wordFrequency.length - i;
            }
        }
        return 0;
    }
    
    private int smallestCharFrequency(String word){
        int[] frequencies = new int[26];
        char smallest = word.charAt(0);
        for(int i = 0; i < word.length(); i++){
            char currentCh = word.charAt(i);
            if(currentCh > smallest){
                continue;
            }
            frequencies[currentCh - 'a'] += 1;
            if(currentCh < smallest){
                smallest = currentCh;
            }
        }
        for(int frequency: frequencies){
            if(frequency != 0){
                return frequency;
            }
        }
        return 0;
    }
}
