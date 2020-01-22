import java.util.Arrays;
import java.util.Comparator;

public class FindAndReplaceInString {
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        int[] replaceIndexes = new int[S.length()];
        Arrays.fill(replaceIndexes, -1);
        for(int i = 0; i < indexes.length; i++){
            if(S.substring(indexes[i], indexes[i] + sources[i].length()).equals(sources[i])){
                replaceIndexes[indexes[i]] = i;
            }
        }
        StringBuilder newS = new StringBuilder("");
        int index = 0;
        while(index < S.length()){
            if(replaceIndexes[index] < 0){
                newS.append(S.charAt(index++));
                continue;
            }
            newS.append(targets[replaceIndexes[index]]);
            index += sources[replaceIndexes[index]].length();
        }
        return newS.toString();
    }
}
