import java.util.HashSet;
import java.util.Set;

public class LongestDuplicateString {
    public String longestDupSubstring(String S) {
        int min = 1;
        int max = S.length();
        String longestDuplicate = "";
        while(min <= max){
            int mid = min + (max - min) / 2;
            String curDuplicate = findDuplicate(S, mid);
            if(!curDuplicate.isEmpty()){
                longestDuplicate = curDuplicate;
                min = mid + 1;
            }else{
                max = mid - 1;
            }
        }
        return longestDuplicate;
    }

    private String findDuplicate(String S, int mid){
        Set<Integer> set = new HashSet<>();
        String curSubS = S.substring(0, mid);
        int removeInt = 1;
        for(int i = 1; i < mid; i++){
            removeInt *= 26;
        }
        int curInt = 0;
        for(int i = 0; i < mid; i++){
            curInt *= 26;
            curInt += curSubS.charAt(i) - 'a';
        }
        set.add(curInt);
        for(int i = 1; i + mid <= S.length(); i++){
            curInt -= (S.charAt(i - 1) - 'a') * removeInt;
            curInt *= 26;
            curInt += S.charAt(i + mid - 1) - 'a';
            if(set.contains(curInt)){
                return S.substring(i, i + mid);
            }
            set.add(curInt);
        }
        return "";
    }
}
