import java.util.ArrayList;
import java.util.List;

public class KWeakestRowsInMatrix {
    public int[] kWeakestRows(int[][] mat, int k) {
        int curColumn = 0;
        boolean[] used = new boolean[mat.length];
        List<Integer> weakestRow = new ArrayList<>();
        while(weakestRow.size() < k && curColumn < mat[0].length){
            for(int i = 0; i < mat.length; i++){
                if(!used[i] && mat[i][curColumn] == 0){
                    used[i] = true;
                    weakestRow.add(i);
                }
            }
            curColumn++;
        }
        int curRow = 0;
        while(weakestRow.size() < k){
            if(!used[curRow]){
                weakestRow.add(curRow);
            }
            curRow++;
        }
        int[] kWeakestRows = new int[k];
        for(int i = 0; i < k; i++){
            kWeakestRows[i] = weakestRow.get(i);
        }
        return kWeakestRows;
    }
}
