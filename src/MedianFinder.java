import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class MedianFinder {
	private PriorityQueue<Integer> maxHeap;//for num smaller or equal to median
	private PriorityQueue<Integer> minHeap;//for num larger than median
	private int median;
    public MedianFinder() {
    	maxHeap = new PriorityQueue<>((element1, element2) -> element2 - element1);
    	minHeap = new PriorityQueue<>((element1, element2) -> element1 - element2);
    	
    	median = Integer.MAX_VALUE;
    }
    
    public void addNum(int num) {
    	if(num > median) {
    		minHeap.add(num);
    		
    	}else {
    		maxHeap.add(num);
    	}
    }
    
//    public double findMedian() {
//        if(dataFlow.size() % 2 == 0) {
//        	return (1.0 * dataFlow.get(dataFlow.size() / 2 - 1) + 1.0 * dataFlow.get(dataFlow.size() / 2)) / 2;
//        }
//        
//        return (double)dataFlow.get(dataFlow.size() / 2);
//    }
}
