import java.util.ArrayList;
import java.util.List;

public class PathWithMaximumGold {
    public int getMaximumGold(int[][] grid) {
        List<int[]> goldGrids = new ArrayList<>();
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] != 0){
                    goldGrids.add(new int[]{i, j, grid[i][j]});
                }
            }
        }
        List<int[]> startGrids = new ArrayList<>();
        for(int[] goldGrid : goldGrids){
            if(findIndex(goldGrids, goldGrid[0], goldGrid[1]).size() <= 2){
                startGrids.add(goldGrid);
            }
        }
        boolean[] hasUsed = new boolean[goldGrids.size()];
        int maxGold = 0;
        for(int[] startGrid: startGrids){
            maxGold = Math.max(maxGold, findGold(goldGrids, hasUsed, indexOf(startGrid, goldGrids)));
        }
        return maxGold;
    }

    private int findGold(List<int[]> goldGrids, boolean[] hasUsed, int index){
        int[] currentGrid = goldGrids.get(index);
        int max = 0;
        hasUsed[index] = true;
        List<Integer> nextIndexes = findIndex(goldGrids, currentGrid[0], currentGrid[1]);
        for(int nextIndex : nextIndexes){
            if(nextIndex != -1 && !hasUsed[nextIndex]){
                max = Math.max(max, findGold(goldGrids, hasUsed, nextIndex));
            }
        }
        hasUsed[index] = false;
        return currentGrid[2] + max;
    }

    private int indexOf(int[] grid, List<int[]> goldGrids){
        for(int i = 0; i < goldGrids.size(); i++){
            if(goldGrids.get(i) == grid){
                return i;
            }
        }
        return 0;
    }

    private List<Integer> findIndex(List<int[]> goldGrids, int row, int column){
        List<Integer> indexes = new ArrayList<>(4);
        for(int i = 0; i < goldGrids.size(); i++){
            int[] currentGrid = goldGrids.get(i);
            if(currentGrid[0] == row - 1 && currentGrid[1] == column){
                indexes.add(i);
                continue;
            }
            if(currentGrid[0] == row + 1 && currentGrid[1] == column){
                indexes.add(i);
                continue;
            }
            if(currentGrid[0] == row && currentGrid[1] == column - 1){
                indexes.add(i);
                continue;
            }
            if(currentGrid[0] == row && currentGrid[1] == column + 1){
                indexes.add(i);
                continue;
            }
        }
        return indexes;
    }
}
