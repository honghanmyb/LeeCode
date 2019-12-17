import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class PhoneDirectory {
    private Set<Integer> usedNums;
    private Stack<Integer> nextNums;

    /**
     * Initialize your data structure here
     *
     * @param maxNumbers - The maximum numbers that can be stored in the phone directory.
     */
    public PhoneDirectory(int maxNumbers) {
        usedNums = new HashSet<>();
        nextNums = new Stack<>();
        for (int i = 0; i < maxNumbers; i++) {
            nextNums.add(i);
        }
    }

    /**
     * Provide a number which is not assigned to anyone.
     *
     * @return - Return an available number. Return -1 if none is available.
     */
    public int get() {
        if (nextNums.isEmpty()) {
            return -1;
        }
        int nextNum = nextNums.pop();
        usedNums.add(nextNum);
        return nextNum;
    }

    /**
     * Check if a number is available or not.
     */
    public boolean check(int number) {
        return !usedNums.contains(number);
    }

    /**
     * Recycle or release a number.
     */
    public void release(int number) {
        if (usedNums.remove(number)) {
            nextNums.add(number);
        }
    }
}

