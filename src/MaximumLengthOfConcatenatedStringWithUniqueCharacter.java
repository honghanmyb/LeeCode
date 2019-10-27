import java.util.List;

public class MaximumLengthOfConcatenatedStringWithUniqueCharacter {
    private int maxLength = 0;
    public int maxLength(List<String> arr) {
        int[] record = new int[26];
        for(int i = 0; i < arr.size(); i++){
            greedy(i, arr, record, 0);
        }
        return maxLength;
    }
    
    private void greedy(int index, List<String> arr, int[] record, int currentLength){
        boolean isUnique = true;
        String current = arr.get(index);
        int[] newRecord = new int[26];
        for(int i = 0; i < 26; i++){
            newRecord[i] = record[i];
        }
        
        for(int i = 0; i < current.length(); i++){
            newRecord[current.charAt(i) - 'a']++;
            if(newRecord[current.charAt(i) - 'a'] > 1){
                isUnique = false;
            }
        }
        if(isUnique == false){
            return;
        }else{
            currentLength += current.length();
            this.maxLength = Integer.max(this.maxLength, currentLength);
            for(int i = index + 1; i < arr.size(); i++){
                greedy(i, arr, newRecord, currentLength);
            }
        }
    }
}
