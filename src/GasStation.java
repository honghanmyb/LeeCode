
public class GasStation {
	public int canCompleteCircuit(int[] gas, int[] cost) {
		if(gas.length == 1) {
			if(gas[0] >= cost[0]) {
				return 0;
			}
			return -1;
		}
		for(int i = 0; i < gas.length; i++) {
			gas[i] -= cost[i];
		}
		int[] boost = gas;
		int sum = 0;
		for(int singleBoost: boost) {
			sum += singleBoost;
		}
		
		if(sum < 0) {
			return -1;
		}
		
		int startPoint = 0, currentPoint = 0;
		for(int i = 0; i < boost.length; i++) {
			if(boost[i] > 0) {
				sum = boost[i];
				startPoint = i;
				currentPoint = (startPoint + 1) % boost.length;
				break;
			}
		}
		while(true) {
			sum += boost[currentPoint];
			if(sum < 0) {
				sum = 0;
				startPoint = (currentPoint + 1) % boost.length;
				currentPoint = startPoint;
				continue;
			}
			currentPoint = (currentPoint + 1) % boost.length;
			if(startPoint == currentPoint && sum >= 0) {
				break;
			}
		}
		
		return startPoint;
	}
}
