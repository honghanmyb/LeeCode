import java.util.TreeSet;

public class OddEvenJump {
    public int oddEvenJumps(int[] A) {
        boolean[] canReachOdd = new boolean[A.length];
        boolean[] canReachEven = new boolean[A.length];
        canReachOdd[A.length - 1] = true;
        canReachEven[A.length - 1] = true;
        TreeSet<Element> setCeiling = new TreeSet<>((e1, e2) -> {
            return e1.value == e2.value ? e1.index - e2.index: e1.value - e2.value;
        });
        TreeSet<Element> setFloor = new TreeSet<>((e1, e2) -> {
        	return e1.value == e2.value ? e2.index - e1.index: e1.value - e2.value;
        });
        Element firstElement = new Element(A[A.length - 1], A.length - 1);
        setCeiling.add(firstElement);
        setFloor.add(firstElement);
        for(int i = A.length - 2; i >= 0; i--){
            Element current = new Element(A[i], i);
            Element smallest = setCeiling.ceiling(current);
            Element largest = setFloor.floor(current);
            setCeiling.add(current);
            setFloor.add(current);
            if(smallest != null){
                canReachOdd[i] = canReachEven[smallest.index];
                if(smallest.value == current.value) {
                	largest = smallest;
                }
            }
            if(largest != null){
                canReachEven[i] = canReachOdd[largest.index];
            }
        }
        int count = 0;
        for(int i = 0; i < A.length; i++){
            if(canReachOdd[i]){
                count++;
            }
        }
        return count;
    }
    
    private class Element{
        public int value;
        public int index;
        
        public Element(int value, int index){
            this.value = value;
            this.index = index;
        }
    }
}
