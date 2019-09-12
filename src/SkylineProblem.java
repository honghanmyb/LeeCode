import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SkylineProblem {
	//each building is an array of int with 3 elements, e.g. [left, right, height]
	//each skyline point is a list of Integer with two elements, e.g. [xCoordinate, yCoordinate]
	public List<List<Integer>> getSkyline(int[][] buildings){
		List<List<Integer>> skylinePoints = new ArrayList<>();
		if(buildings == null || buildings.length == 0) {
			return skylinePoints;
		}
		
		List<List<Integer>> groupIndexes = getGroupIndexes(buildings);
		convergeSameHeight(buildings, groupIndexes);
		List<List<Integer>> validBuildingEndIndex = getValidBuildingEndIndex(buildings, groupIndexes);
		List<List<Integer>> validBuildingStartIndex = getValidBuildingStartIndex(buildings, groupIndexes);

		skylinePoints.addAll(validBuildingStartIndex);
		skylinePoints.addAll(validBuildingEndIndex);
		
		Collections.sort(skylinePoints, (element1, element2) -> element1.get(0) - element2.get(0));
		return skylinePoints;
	}
	
	private List<List<Integer>> getGroupIndexes(int[][] buildings){
		List<List<Integer>> groupIndexes = new ArrayList<>();
		int startIndex = 0;
		int mostRightIndex = buildings[startIndex][1];
		for(int i = 0; i < buildings.length; i++) {
			if(buildings[i][0] > mostRightIndex) {
				groupIndexes.add(Arrays.asList(startIndex, i - 1));
				startIndex = i;
				mostRightIndex = buildings[startIndex][1];
			}else {
				mostRightIndex = Integer.max(mostRightIndex, buildings[i][1]);
			}
		}
		groupIndexes.add(Arrays.asList(startIndex, buildings.length - 1));
		return groupIndexes;
	}
	
	private void convergeSameHeight(int[][] buildings, List<List<Integer>> groupIndexes) {
		for(List<Integer> groupIndex: groupIndexes) {
			int groupStartIndex = groupIndex.get(0);
			int groupEndIndex = groupIndex.get(1);
			for(int i = groupStartIndex; i <= groupEndIndex; i++) {
				for(int j = i + 1; j <= groupEndIndex; j++) {
					if(buildings[j][0] > buildings[i][1]) {
						break;
					}
					if(buildings[j][2] == buildings[i][2]) {
						buildings[i][1] = Integer.max(buildings[i][1], buildings[j][1]);
						buildings[j][2] = 0;
					}
				}
			}
		}
	}
	
	private List<List<Integer>> getValidBuildingEndIndex(int[][] buildings, List<List<Integer>> groupIndexes){
		List<List<Integer>> validBuildingEndIndex = new ArrayList<>();
		for(List<Integer> groupIndex: groupIndexes) {
			int groupStartIndex = groupIndex.get(0);
			int groupEndIndex = groupIndex.get(1);
			int mostRight = 0;
			for(int i = groupStartIndex; i <= groupEndIndex; i++) {
				int[] building = buildings[i];
				int secondMaxHeight = 0;
				mostRight = Integer.max(mostRight, building[1]);
				boolean findPoint = false;
				for(int j = groupStartIndex; j <= groupEndIndex; j++) {
					int[] comparedBuilding = buildings[j];
					if(building[1] >= comparedBuilding[1]) {
						continue;
					}
					if(comparedBuilding[0] > building[1]) {
						break;
					}
					if(comparedBuilding[2] >= building[2]) {
						findPoint = false;
						break;
					}
					secondMaxHeight = Integer.max(comparedBuilding[2], secondMaxHeight);
					findPoint = true;
				}
				if(findPoint) {
					validBuildingEndIndex.add(Arrays.asList(building[1], secondMaxHeight));
				}
			}
			validBuildingEndIndex.add(Arrays.asList(mostRight, 0));
		}
		return validBuildingEndIndex;
	}
	
	private List<List<Integer>> getValidBuildingStartIndex(int[][] buildings, List<List<Integer>> groupIndexes){
		List<List<Integer>> validBuildingStartIndex = new ArrayList<>();
		for(List<Integer> groupIndex: groupIndexes) {
			int startIndex = groupIndex.get(0);
			int endIndex = groupIndex.get(1);
			for(int i = startIndex; i <= endIndex; i++) {
				int[] building = buildings[i];
				boolean isValidPoint = true;
				for(int j = startIndex; j <= endIndex; j++) {
					int[] comparedBuilding = buildings[j];
					if(comparedBuilding[0] > building[0]) {
						break;
					}
					if(comparedBuilding[1] < building[0] || j == i) {
						continue;
					}
					if(comparedBuilding[2] >= building[2]) {
						isValidPoint = false;
						break;
					}
				}
				if(isValidPoint) {
					validBuildingStartIndex.add(Arrays.asList(building[0], building[2]));
				}
			}
		}
		return validBuildingStartIndex;
	}
//	Example test case
//	SkylineProblem test = new SkylineProblem();
//	int[][] buildings = new int[][] {
//		new int[] {2, 9, 10},
//		new int[] {3, 7, 15},
//		new int[] {5, 12, 12},
//		new int[] {15, 20, 10},
//		new int[] {19, 24, 8}
//	};
//	System.out.println(test.getSkyline(buildings));
//	int[][] soloBuilding = new int[][] {
//		new int[] {0,2147483647,2147483647},
//		new int[] {1, 2, 1},
//		new int[] {1, 2, 2},
//		new int[] {1, 2, 3},
//		new int[] {3, 4, 4},
//		new int[] {3, 4, 4},
//		new int[] {3, 4, 4},
//		new int[] {3, 10, 20},
//		new int[] {3, 9, 19},
//		new int[] {3, 8, 18}
//	};
//	System.out.println(test.getSkyline(soloBuilding));
}
