import java.util.*;

public class OptimalAccountBalancing {
    private int totalCount = Integer.MAX_VALUE;
    public int minTransfers(int[][] transactions) {
        if(transactions.length == 0){
            return 0;
        }
        Map<Integer, Integer> idToMoney = new HashMap<>();
        for(int[] transaction: transactions){
            int borrowId = transaction[0];
            int lentId = transaction[1];
            if(idToMoney.containsKey(borrowId)){
                idToMoney.put(borrowId, idToMoney.get(borrowId) + transaction[2]);
            }else{
                idToMoney.put(borrowId, transaction[2]);
            }
            idToMoney.put(lentId, idToMoney.getOrDefault(lentId, 0) - transaction[2]);
        }
        List<Integer> recordList = new ArrayList<>();
        Set<Map.Entry<Integer, Integer>> set = idToMoney.entrySet();
        for(Map.Entry<Integer, Integer> entry: set){
            recordList.add(entry.getValue());
        }
        int[] record = toArray(recordList);
        settle(record, 0, 0);

        return this.totalCount;
    }

    private void settle(int[] record, int current, int count){
        if(count >= this.totalCount){
            return;
        }
        int nextPos = current + 1;
        while(record[current] != 0 && nextPos < record.length && record[current] * record[nextPos] >= 0){
            nextPos++;
        }
        if(nextPos >= record.length){
            this.totalCount = Math.min(count, this.totalCount);
            return;
        }
        if(record[current] == 0){
            settle(record, current + 1, count);
            return;
        }

        for(int i = nextPos; i < record.length; i++){
            if(record[current] * record[i] < 0){
                int temp = record[current];
                record[i] += temp;
                settle(record, current + 1, count + 1);
                record[i] -= temp;
            }
        }
    }

    private int[] toArray(List<Integer> list){
        int[] arr = new int[list.size()];
        for(int i = 0; i < arr.length; i++){
            arr[i] = list.get(i);
        }
        return arr;
    }
}
