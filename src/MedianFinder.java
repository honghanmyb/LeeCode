import java.util.LinkedList;
import java.util.List;

public class MedianFinder {
	private List<Integer> dataFlow;
    public MedianFinder() {
        dataFlow = new LinkedList<>();
    }
    
    public void addNum(int num) {
//        for(int i = 0; i < dataFlow.size(); i++) {
//        	if(dataFlow.get(i) > num) {
//        		dataFlow.add(i, num);
//        		return;
//        	}
//        }
        dataFlow.add(num);
    }
    
    public double findMedian() {
    	dataFlow.sort((int1, int2) -> int2 - int1);
        if(dataFlow.size() % 2 == 0) {
        	return (1.0 * dataFlow.get(dataFlow.size() / 2 - 1) + 1.0 * dataFlow.get(dataFlow.size() / 2)) / 2;
        }
        
        return (double)dataFlow.get(dataFlow.size() / 2);
    }
}
