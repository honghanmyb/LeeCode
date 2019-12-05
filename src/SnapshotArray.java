import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;

public class SnapshotArray {
    private int snapId = 0;
    private int[] arr;
    private TreeMap<Integer, Integer>[] snapRecords;
    private Set<Integer> changedIndex;
    public SnapshotArray(int length) {
        this.arr = new int[length];
        this.snapRecords = new TreeMap[length];
        for(int i = 0; i < length; i++){
            snapRecords[i] = new TreeMap<>();
            snapRecords[i].put(0, 0);
        }
        this.changedIndex = new HashSet<>();
    }

    public void set(int index, int val) {
        this.arr[index] = val;
        this.changedIndex.add(index);
    }

    public int snap() {
        for(int index: this.changedIndex){
            snapRecords[index].put(snapId, this.arr[index]);
        }
        snapId++;
        this.changedIndex.clear();
        return snapId - 1;
    }

    public int get(int index, int snap_id) {
        return this.snapRecords[index].floorEntry(snap_id).getValue();
    }
}
