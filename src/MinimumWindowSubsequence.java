import java.util.Arrays;

public class MinimumWindowSubsequence {
    public String minWindow(String S, String T) {
        if(S == null || S.isEmpty() || T == null || T.isEmpty()){
            return "";
        }
        int[][] table = new int[T.length()][S.length()];
        for(int[] row: table){
            Arrays.fill(row, -1);
        }
        char firstCh = T.charAt(0);
        for(int i = 0; i < table[0].length; i++){
            if(S.charAt(i) == firstCh){
                table[0][i] = i;
            }
        }
        for(int i = 1; i < table.length; i++){
            char currentCh = T.charAt(i);
            int lastStartIndex = -1;
            for(int j = 0; j < table[0].length; j++){
                if(lastStartIndex != -1 && S.charAt(j) == currentCh){
                    table[i][j] = lastStartIndex;
                }
                if(table[i - 1][j] != -1){
                    lastStartIndex = table[i - 1][j];
                }
            }
        }
        String minWindow = "";
        for(int i = T.length() - 1; i < table[0].length; i++){
            if(table[T.length() - 1][i] != -1){
                if(minWindow.isEmpty()){
                    minWindow = S.substring(table[T.length() - 1][i], i + 1);
                }else{
                    if(i + 1 - table[T.length() - 1][i] < minWindow.length()){
                        minWindow = S.substring(table[T.length() - 1][i], i + 1);
                    }
                }
            }
        }
        return minWindow;
    }
}
