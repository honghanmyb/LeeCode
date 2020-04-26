import java.util.ArrayList;
import java.util.List;

public class DiagonalTraversalII {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        List<Integer> numList = new ArrayList<>();
        for (int i = 0; i < nums.size(); i++) {
            for (int j = i; j >= 0; j--) {
                List<Integer> curList = nums.get(j);
                if (!curList.isEmpty()) {
                    numList.add(curList.get(0));
                    curList.remove(0);
                } else {
                    nums.remove(curList);
                    i--;
                }
            }
        }
        while (!nums.isEmpty()) {
            for (int i = nums.size() - 1; i >= 0; i--) {
                List<Integer> curList = nums.get(i);
                if (!curList.isEmpty()) {
                    numList.add(curList.get(0));
                    curList.remove(0);
                } else {
                    nums.remove(curList);
                }
            }
        }

        int[] numArray = new int[numList.size()];
        for (int i = 0; i < numArray.length; i++) {
            numArray[i] = numList.get(i);
        }
        return numArray;
    }
}
