import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupPeopleGivenGroupSizeTheyBelongTo {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, List<Integer>> sizeToGroup = new HashMap<>();
        List<List<Integer>> groups = new ArrayList<>();
        for(int i = 0; i < groupSizes.length; i++){
            List<Integer> ids = null;
            if(!sizeToGroup.containsKey(groupSizes[i])){
                ids = new ArrayList<>();
                sizeToGroup.put(groupSizes[i], ids);
            }else{
                ids = sizeToGroup.get(groupSizes[i]);
            }
            ids.add(i);
            if(ids.size() == groupSizes[i]){
                groups.add(ids);
                sizeToGroup.remove(groupSizes[i]);
            }
        }
        return groups;
    }
}
