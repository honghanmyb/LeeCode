import java.util.Arrays;

public class CompareStringByFrequencyOfSmallestChar {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] smallestFrequencyCount = new int[11];
        for(int i = 0; i < words.length; i++){
            smallestFrequencyCount[smallestCharFrequency(words[i]) - 1]++;
        }
        for(int i = 9; i >= 0; i--){
            smallestFrequencyCount[i] += smallestFrequencyCount[i + 1];
        }
        int[] numSmaller = new int[queries.length];
        for(int i = 0; i < queries.length; i++){
            numSmaller[i] = smallestFrequencyCount[smallestCharFrequency(queries[i])];
        }
        return numSmaller;
    }
    
    private int smallestCharFrequency(String s){
        if(s.equals("")){
            return 0;
        }
        int frequency = 1;
        int smallestChar = s.charAt(0);
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) < smallestChar){
                smallestChar = s.charAt(i);
                frequency = 1;
            }else if(s.charAt(i) == smallestChar){
                frequency++;
            }
        }
        return frequency;
    }
}
