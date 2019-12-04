public class CapacityToShipPackagesWithinNDays {
    public int shipWithinDays(int[] weights, int D) {
        int min = weights[0];
        int max = 0;
        for(int weight: weights){
            min = Math.max(min, weight);
            max += weight;
        }
        while(min <= max){
            int mid = min + (max - min) / 2;
            if(canShip(weights, mid, D)){
                max = mid - 1;
            }else{
                min = mid + 1;
            }
        }
        return min;
    }

    private boolean canShip(int[] weights, int capacity, int D){
        int day = 1;
        int currentWeight = 0;
        for(int weight: weights){
            currentWeight += weight;
            if(currentWeight > capacity){
                currentWeight = weight;
                day++;
                if(day > D){
                    return false;
                }
            }
        }
        return true;
    }
}
