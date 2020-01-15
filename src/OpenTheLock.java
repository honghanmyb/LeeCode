import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class OpenTheLock {
    public int openLock(String[] deadends, String target) {
        Set<Integer> deadendSet = new HashSet<>();
        Set<Integer> used = new HashSet<>();
        for (String deadend : deadends) {
            deadendSet.add(Integer.parseInt(deadend));
        }
        if (deadendSet.contains(0)) {
            return -1;
        }

        int flag = Integer.MAX_VALUE;
        Queue<Integer> queue = new LinkedList<>();
        used.add(0);
        queue.add(0);
        queue.add(flag);
        int moveCount = 1;
        int targetInt = Integer.parseInt(target);

        while (true) {
            int curState = queue.poll();
            if (curState == flag) {
                if (queue.isEmpty()) {
                    break;
                } else {
                    queue.add(flag);
                    ++moveCount;
                }
                continue;
            }
            List<Integer> possibleNextMoves = getNextMoves(curState);
            for (int nextMove : possibleNextMoves) {
                if (nextMove == targetInt) {
                    return moveCount;
                }
                if (!deadendSet.contains(nextMove) && !used.contains(nextMove)) {
                    used.add(nextMove);
                    queue.add(nextMove);
                }
            }
        }
        return -1;
    }

    private List<Integer> getNextMoves(int curState) {
        int thousand = curState / 1000;
        curState %= 1000;
        int hundred = curState / 100;
        curState %= 100;
        int ten = curState / 10;
        curState %= 10;
        int one = curState;
        int[] digits = new int[]{thousand, hundred, ten, one};
        List<Integer> nextMoves = new ArrayList<>(8);
        for (int i = 0; i < digits.length; i++) {
            int origin = digits[i];
            digits[i] = origin == 9 ? 0 : origin + 1;
            nextMoves.add(convert(digits));
            digits[i] = origin == 0 ? 9 : origin - 1;
            nextMoves.add(convert(digits));
            digits[i] = origin;
        }
        return nextMoves;
    }

    private int convert(int[] digits) {
        int num = 0;
        for (int digit : digits) {
            num = num * 10 + digit;
        }
        return num;
    }
}
