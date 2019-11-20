//In OA, the two people refill the can at the same time
//so, if there's one can cannot water the next plant, but another can still have enough water for next plant
//both cans will be refill
public class WaterFlowerOA {
	public int numOfRefill(int[] plants, int capacity1, int capacity2) {
		if(plants.length == 0) {
			return 0;
		}
		if(plants.length == 1) {
			return 1;
		}
		int totalNum = 2;
		int headRemain = capacity1, tailRemain = capacity2;
		int headPos = 0, tailPos = plants.length - 1;
		while(headPos <= tailPos) {
			if(headPos == tailPos) {
				if(headRemain + tailRemain < plants[headPos]) {
					totalNum++;
				}
				break;
			}
			if(headRemain < plants[headPos]) {
				headRemain = capacity1;
				totalNum++;
			}
			headRemain -= plants[headPos];
			if(tailRemain < plants[tailPos]) {
				tailRemain = capacity2;
				totalNum++;
			}
			tailRemain -= plants[tailPos];
			headPos++;
			tailPos--;
		}
		return totalNum;
	}
}
