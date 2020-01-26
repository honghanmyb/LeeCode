import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FilterRestaurants {
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        List<int[]> filteredRes = new ArrayList<>();
        for(int[] restaurant : restaurants){
            if(veganFriendly == 1 && restaurant[2] == 0){
                continue;
            }
            if(restaurant[3] <= maxPrice && restaurant[4] <= maxDistance){
                filteredRes.add(restaurant);
            }
        }
        filteredRes.sort((res1, res2) -> {
            if (res1[1] != res2[1]) {
                return res2[1] - res1[1];
            }
            return res2[0] - res1[0];
        });
        List<Integer> ids = new ArrayList<>(filteredRes.size());
        for(int[] restaurant : filteredRes){
            ids.add(restaurant[0]);
        }
        return ids;
    }
}
