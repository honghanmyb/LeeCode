import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class PeekingIterator implements Iterator<Integer>{
	Queue<Integer> queue;
	public PeekingIterator(Iterator<Integer> iterator) {
		queue = new LinkedList<>();
		while(iterator.hasNext()) {
			queue.add(iterator.next());
		}
	    
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return queue.peek();
	}
	
	@Override
	public boolean hasNext() {
		return !queue.isEmpty();
	}

	@Override
	public Integer next() {
		return queue.poll();
	}
	
}
