import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

class RandomizedSet {
    private Set<Integer> valSet;
    private List<Integer> valList;
    private Random random;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        this.valSet = new HashSet<>();
        this.valList = new ArrayList<>();
        this.random = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(valSet.contains(val)){
            return false;
        }
        valSet.add(val);
        valList.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        return valSet.remove(val);
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int index = -1;
        while(true){
            index = random.nextInt(valList.size());
            if(valSet.contains(valList.get(index))){
                break;
            }
        }
        return valList.get(index);
    }
}