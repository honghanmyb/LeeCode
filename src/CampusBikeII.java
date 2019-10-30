
public class CampusBikeII {
    private int minDistTotal = 0;
    public int assignBikes(int[][] workers, int[][] bikes) {
        int[][] table = new int[workers.length][bikes.length];
        for(int i = 0; i < workers.length; i++){
            for(int j = 0; j < bikes.length; j++){
                int[] worker = workers[i];
                int[] bike = bikes[j];
                table[i][j] = Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1]);
            }
        }
        boolean[][] hasTaken = new boolean[workers.length][bikes.length];
        for(int i = 0; i < workers.length; i++){
            this.minDistTotal += table[i][i];
        }
        
        return findMinDist(table, hasTaken, 0, 0);
    }
    
    private int findMinDist(int[][] table, boolean[][] hasTaken, int currentWorkerIndex, int previousDist){
        int minDist = Integer.MAX_VALUE;
        if(currentWorkerIndex >= table.length){
            return 0;
        }
        if(previousDist > this.minDistTotal){
            return 20000;
        }
        for(int j = 0; j < table[0].length; j++){
            if(hasTaken[currentWorkerIndex][j] == true){
                continue;
            }
            int currentDist = table[currentWorkerIndex][j];
            for(int i = 0; i < table.length; i++){
                hasTaken[i][j] = true;
            }
            currentDist += findMinDist(table, hasTaken, currentWorkerIndex + 1, currentDist + previousDist);
            minDist = Integer.min(minDist, currentDist);
            this.minDistTotal = Integer.min(this.minDistTotal, minDist + previousDist);
            
            for(int i = 0; i < table.length; i++){
                hasTaken[i][j] = false;
            }
        }
        return minDist;
    }
}
