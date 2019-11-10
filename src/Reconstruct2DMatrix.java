import java.util.ArrayList;
import java.util.List;

public class Reconstruct2DMatrix {
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        List<List<Integer>> matrix = new ArrayList<>(2);
        int sum = 0;
        for(int col: colsum){
            sum += col;
        }
        if(sum != upper + lower){
            return matrix;
        }
        int[] upperRow = new int[colsum.length];
        int[] lowerRow = new int[colsum.length];
        int upperSum = 0;
        int lowerSum = 0;
        for(int i = 0; i < colsum.length; i++){
            if(colsum[i] == 2){
                upperRow[i]++;
                lowerRow[i]++;
                upperSum++;
                lowerSum++;
                if(upperSum > upper || lowerSum > lower){
                    return matrix;
                }
            }
        }
        int currentIndex = 0;
        boolean hasBreak = false;
        for(int i = 0; i < colsum.length; i++){
            if(upperSum == upper){
                currentIndex = i;
                hasBreak = true;
                break;
            }
            if(colsum[i] == 1){
                upperRow[i]++;
                upperSum++;
            }
        }
        if(hasBreak == false){
            currentIndex = colsum.length;
        }
        for(int i = currentIndex; i < colsum.length; i++){
            if(colsum[i] == 1){
                lowerRow[i]++;
            }
        }
        List<Integer> upperRowList = new ArrayList<>(upperRow.length);
        List<Integer> lowerRowList = new ArrayList<>(lowerRow.length);
        for(int i = 0; i < upperRow.length; i++){
            upperRowList.add(upperRow[i]);
            lowerRowList.add(lowerRow[i]);
        }
        matrix.add(upperRowList);
        matrix.add(lowerRowList);
        return matrix;
    }
}
