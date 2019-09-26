import java.util.HashMap;
import java.util.Map;

public class PrisonCellsAfterNDays {
    public int[] prisonAfterNDays(int[] cells, int N) {
        if(N == 0){
            return cells;
        }
        int[] lastDayCells = cells;
        int order = 1;
        int previousOrder = 0;
        Map<Integer, Integer> cellToOrder = new HashMap<>();
        for(int i = 0; i < N; i++){
            int[] newCells = new int[8];
            newCells[0] = 0;
            newCells[7] = 0;
            for(int j = 1; j < 7; j++){
                if(lastDayCells[j - 1] == lastDayCells[j + 1]){
                    newCells[j] = 1;
                }else{
                    newCells[j] = 0;
                }
            }
            int convertedInt = convertCellToInt(newCells);
            if(cellToOrder.containsKey(convertedInt)){
                previousOrder = cellToOrder.get(convertedInt);
                break;
            }
            cellToOrder.put(convertedInt, order++);
            lastDayCells = newCells;
        }
        if(previousOrder == 0){
            return lastDayCells;
        }
        int offPreviousOrder = (N - previousOrder + 1) % (order - previousOrder);
        offPreviousOrder = offPreviousOrder == 0? order- previousOrder : offPreviousOrder;
        int dayNOrder = previousOrder + offPreviousOrder - 1;
        int dayNConvertedInt = 0;
        for(Map.Entry entry: cellToOrder.entrySet()){
            if((int)entry.getValue() == dayNOrder){
                dayNConvertedInt = (int)entry.getKey();
                break;
            }
        }
        int[] dayNCells = new int[8];
        for(int i = 1; i < 7; i++){
            int twoPow = (int)Math.pow(2, 7 - i);
            if(dayNConvertedInt >= twoPow){
                dayNCells[i] = 1;
                dayNConvertedInt -= twoPow;
            }
        }
        return dayNCells;
    }
    
    private int convertCellToInt(int[] newCells){
        int convertedInt = 0;
        for(int i = 0; i < newCells.length; i++){
            convertedInt += newCells[i] * (int)Math.pow(2, 7 - i);
        }
        return convertedInt;
    }
}
