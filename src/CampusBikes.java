import java.util.Arrays;

public class CampusBikes {
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        int[] workerBike = new int[workers.length];
        Arrays.fill(workerBike, -1);
        int[][] bikeDists = new int[workers.length][bikes.length];
        int currentWorker = 0;
        while(currentWorker < workers.length){
            if(workerBike[currentWorker] >= 0){
                currentWorker += 1;
                continue;
            }
            int minBikeIndex = 0, minWorkerIndex = currentWorker;
            int workerIndex = currentWorker;
            while(true){
                int bikeIndex = findMinBikeGivenWorker(workerIndex, bikeDists, workers, bikes);
                workerIndex = findMinWorkerGivenBike(bikeIndex, bikeDists, workers, bikes);
                if(bikeIndex == minBikeIndex && workerIndex == minWorkerIndex){
                    break;
                }
                if(bikeIndex != minBikeIndex){
                    minBikeIndex = bikeIndex;
                }
                if(workerIndex != minWorkerIndex){
                    minWorkerIndex = workerIndex;
                }
            }
            workerBike[minWorkerIndex] = minBikeIndex;
            Arrays.fill(bikeDists[minWorkerIndex], -1);
            for(int i = 0; i < workers.length; i++){
                bikeDists[i][minBikeIndex] = -1;
            }
        }
        return workerBike;
    }
    
    private int findMinBikeGivenWorker(int workerIndex, int[][] bikeDists, int[][] workers,
                                       int[][] bikes){
        int minBikeDist = Integer.MAX_VALUE;
        int minBikeIndex = -1;
        for(int i = 0; i < bikes.length; i++){
           if(bikeDists[workerIndex][i] < 0){
                continue;
           }
            if(bikeDists[workerIndex][i] == 0){
                bikeDists[workerIndex][i] = Math.abs(workers[workerIndex][0] - bikes[i][0]) 
                                            + Math.abs(workers[workerIndex][1] - bikes[i][1]);
            }
            if(minBikeDist > bikeDists[workerIndex][i]){
                minBikeDist = bikeDists[workerIndex][i];
                minBikeIndex = i;
            }
        }
        return minBikeIndex;
    }
    
    private int findMinWorkerGivenBike(int bikeIndex, int[][] bikeDists, int[][] workers,
                                      int[][] bikes){
        int minWorkerIndex = -1;
        int minBikeDist = Integer.MAX_VALUE;
        for(int i = 0; i < workers.length; i++){
            if(bikeDists[i][bikeIndex] < 0){
                continue;
            }
            if(bikeDists[i][bikeIndex] == 0){
               bikeDists[i][bikeIndex] = Math.abs(workers[i][0] - bikes[bikeIndex][0])
                                                + Math.abs(workers[i][1] - bikes[bikeIndex][1]);
            }
            if(minBikeDist > bikeDists[i][bikeIndex]){
                minWorkerIndex = i;
                minBikeDist = bikeDists[i][bikeIndex];
            }
        }
        return minWorkerIndex;
    }
}
