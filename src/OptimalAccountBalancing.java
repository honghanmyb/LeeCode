import java.util.*;

public class OptimalAccountBalancing {
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
            if(idToMoney.containsKey(lentId)){
                idToMoney.put(lentId, idToMoney.get(lentId) - transaction[2]);
            }else{
                idToMoney.put(lentId, 0 - transaction[2]);
            }
        }
        List<Integer> borrow = new ArrayList<>();
        List<Integer> lent = new ArrayList<>();
        Set<Map.Entry<Integer, Integer>> set = idToMoney.entrySet();
        int total = 0;
        int count = Integer.MAX_VALUE;
        for(Map.Entry<Integer, Integer> entry: set){
            int money = entry.getValue();
            if(money > 0){
                total += money;
                borrow.add(money);
            }else if(money < 0){
                lent.add(0 - money);
            }
        }
        if(borrow.size() == 1 || lent.size() == 1){
            return Math.max(borrow.size(), lent.size());
        }
        if(borrow.size() + lent.size() == 0){
            return 0;
        }
        boolean[] borrowUsed = new boolean[borrow.size()];
        boolean[] lentUsed = new boolean[lent.size()];
        for(int i = 0; i < borrow.size(); i++){
            borrowUsed[i] = true;
            count = Math.min(count, transfer(borrow, lent, borrowUsed, lentUsed, borrow.get(i), 0, 0, total));
            borrowUsed[i] = false;
        }
        return count;
    }

    private int transfer(List<Integer> borrow, List<Integer> lent, boolean[] borrowUsed, boolean[] lentUsed, int currentMoney, int count, int transNum, int total){
        if(transNum == total){
            return count;
        }
        int minCount = Integer.MAX_VALUE;

        if(currentMoney == 0){
            for(int i = 0; i < borrow.size(); i++){
                if(borrowUsed[i]){
                    continue;
                }
                borrowUsed[i] = true;
                currentMoney = borrow.get(i);
                minCount = Math.min(minCount, transfer(borrow, lent, borrowUsed, lentUsed, currentMoney, count, transNum, total));
                borrowUsed[i] = false;
            }
            return minCount;
        }

        for(int i = 0; i < lent.size(); i++){
            if(lentUsed[i]){
                continue;
            }
            if(lent.get(i) <= currentMoney){
                lentUsed[i] = true;
                minCount = Math.min(minCount, transfer(borrow, lent, borrowUsed, lentUsed, currentMoney - lent.get(i), count + 1, transNum + lent.get(i), total));
                lentUsed[i] = false;
            }else {
                int temp = lent.get(i);
                lent.set(i, temp - currentMoney);
                minCount = Math.min(minCount, transfer(borrow, lent, borrowUsed, lentUsed, 0, count + 1, transNum + currentMoney, total));
                lent.set(i, temp);
            }
        }
        return minCount;
    }
}
