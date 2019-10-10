import java.util.ArrayList;
import java.util.List;

public class CrackingSafe {
    public String crackSafe(int n, int k) {
        String password = "";
        if(n == 1){
            for(int i = 0; i < k; i++){
                password += i;
            }
            return password;
        }
        List<String> possibleSequences = new ArrayList<>();
        for(int i = 0; i < k; i++){
            addPossibleSequence(Integer.toString(i), n - 1, k, possibleSequences);
        }
        String[] sequences = possibleSequences.toArray(new String[possibleSequences.size()]);
        boolean[] hasUsed = new boolean[sequences.length];
        for(int i = 0; i < n - 1; i++){
            password += '0';
        }
        password += k - 1;
        for(int i = 0; i < sequences.length; i++){
            if(sequences[i].equals(password)){
                hasUsed[i] = true;
                break;
            }
        }
        int useCount = 1;
        String lastPrefix = password.substring(1);
        while(useCount < hasUsed.length){
            for(int i = findMaxPossibleIndex(lastPrefix, hasUsed.length, k); i >= 0; i--){
                String candidate = sequences[i];
                if(hasUsed[i] == false && candidate.startsWith(lastPrefix)){
                    password += candidate.charAt(n - 1);
                    lastPrefix = candidate.substring(1);
                    hasUsed[i] = true;
                    useCount += 1;
                    break;
                }
            }
        }
        return password;
    }
    
    private int findMaxPossibleIndex(String lastPrefix, int totalLength, int k){
        int maxIndex = 0;
        for(int i = 0; i < lastPrefix.length(); i++){
            int pos = Character.getNumericValue(lastPrefix.charAt(i));
            totalLength /= k;
            maxIndex += pos * totalLength;
        }
        maxIndex += (k - 1);
        return maxIndex;
    }
    
    private void addPossibleSequence(String last, int n, int k, List<String> possibleSequences){
        if(n == 1){
            for(int i = 0; i < k; i++){
                possibleSequences.add(last + i);
            }
            return;
        }
        for(int i = 0; i < k; i++){
            addPossibleSequence(last + Integer.toString(i), n - 1, k, possibleSequences);
        }
    }
}
