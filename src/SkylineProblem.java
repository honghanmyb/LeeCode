import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class SkylineProblem {
	//each building is an array of int with 3 elements, e.g. [left, right, height]
	//each skyline point is a list of Integer with two elements, e.g. [xCoordinate, yCoordinate]
	public List<List<Integer>> getSkyline(int[][] buildings){
		List<Point> groupIndexes = new ArrayList<>();
		List<List<Integer>> skylinePoints = new ArrayList<>();
		if(buildings == null || buildings.length == 0) {
			return skylinePoints;
		}
		
		int startIndex = 0;
		int mostRightIndex = buildings[startIndex][1];
		for(int i = 0; i < buildings.length; i++) {
			if(buildings[i][0] > mostRightIndex) {
				groupIndexes.add(new Point(startIndex, i - 1));
				startIndex = i;
				mostRightIndex = buildings[startIndex][1];
			}else {
				mostRightIndex = Integer.max(mostRightIndex, buildings[i][1]);
			}
		}
		groupIndexes.add(new Point(startIndex, buildings.length - 1));
		
		for(Point groupIndex: groupIndexes) {
			int[] buildingHeights = new int[buildings[groupIndex.y][1] - buildings[groupIndex.x][0] + 1];
			int offOrigin = buildings[groupIndex.x][0];
			for(int i = groupIndex.x; i <= groupIndex.y; i++) {
				int[] building = buildings[i];
				for(int j = building[0] - offOrigin; j <= building[1] - offOrigin; j++) {
					buildingHeights[j] = Integer.max(buildingHeights[j], building[2]);
				}
			}
			
			List<Integer> firstPoint = new ArrayList<>(2);
			firstPoint.add(offOrigin);
			firstPoint.add(buildingHeights[0]);
			skylinePoints.add(firstPoint);
			for(int i = 1; i < buildingHeights.length; i++) {
				if(buildingHeights[i] > buildingHeights[i - 1]) {
					List<Integer> point = new ArrayList<>(2);
					point.add(offOrigin + i);
					point.add(buildingHeights[i]);
					skylinePoints.add(point);
				}
				if(buildingHeights[i] < buildingHeights[i - 1]) {
					List<Integer> point = new ArrayList<>(2);
					point.add(offOrigin + i - 1);
					point.add(buildingHeights[i]);
					skylinePoints.add(point);
				}
			}
			List<Integer> lastPoint = new ArrayList<>(2);
			lastPoint.add(buildings[groupIndex.y][1]);
			lastPoint.add(0);
			skylinePoints.add(lastPoint);
		}
		return skylinePoints;
	}
}
