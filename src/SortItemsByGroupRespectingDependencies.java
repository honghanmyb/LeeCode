import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SortItemsByGroupRespectingDependencies {
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        Map<Integer, Set<Integer>> groupToItem = new HashMap<>();
        for (int i = 0; i < group.length; i++) {
            if (group[i] != -1) {
                if (!groupToItem.containsKey(group[i])) {
                    groupToItem.put(group[i], new HashSet<>());
                }
                groupToItem.get(group[i]).add(i);
            }
        }
        List<Integer> sortedList = new ArrayList<>(n);
        boolean[] sorted = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!sorted[i]) {
                if (!sort(group, beforeItems, groupToItem, sortedList, sorted, new HashSet<>(), i)) {
                    return new int[]{};
                }
            }
        }
        int[] sortedItems = new int[n];
        for (int i = 0; i < n; i++) {
            sortedItems[i] = sortedList.get(i);
        }
        return sortedItems;
    }

    private boolean sort(int[] group, List<List<Integer>> beforeItems, Map<Integer, Set<Integer>> groupToItem, List<Integer> sortedList, boolean[] sorted, Set<Integer> afterItems, int item) {
        if (sorted[item]) {
            return true;
        }
        if (group[item] == -1 && beforeItems.get(item).isEmpty()) {
            sorted[item] = true;
            sortedList.add(item);
            return true;
        }
        Set<Integer> groupSet;
        if (group[item] != -1) {
            groupSet = groupToItem.get(group[item]);
        } else {
            groupSet = new HashSet<>();
            groupSet.add(item);
        }
        afterItems.addAll(groupSet);
        for (int groupItem : groupSet) {
            List<Integer> beforeList = beforeItems.get(groupItem);
            for (int beforeItem : beforeList) {
                if (!groupSet.contains(beforeItem) && !sorted[beforeItem]) {
                    if (afterItems.contains(beforeItem)) {
                        return false;
                    }
                    if (!sort(group, beforeItems, groupToItem, sortedList, sorted, afterItems, beforeItem)) {
                        return false;
                    }
                }
            }
        }
        afterItems.removeAll(groupSet);
        for (int groupItem : groupSet) {
            if (!addItemsInGroup(groupItem, groupSet, beforeItems, sorted, sortedList, new HashSet<>())) {
                return false;
            }
        }
        return true;
    }

    private boolean addItemsInGroup(int item, Set<Integer> groupSet, List<List<Integer>> beforeItems, boolean[] sorted, List<Integer> sortedList, Set<Integer> afterItems) {
        if (sorted[item]) {
            return true;
        }
        List<Integer> beforeList = beforeItems.get(item);
        afterItems.add(item);
        for (int beforeItem : beforeList) {
            if (groupSet.contains(beforeItem) && !sorted[beforeItem]) {
                if (afterItems.contains(beforeItem)) {
                    return false;
                }
                if (!addItemsInGroup(beforeItem, groupSet, beforeItems, sorted, sortedList, afterItems)) {
                    return false;
                }
            }
        }
        sortedList.add(item);
        sorted[item] = true;
        afterItems.remove(item);
        return true;
    }
}
