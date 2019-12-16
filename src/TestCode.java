import java.util.*;
public class TestCode {
	public static void main(String[] args) {
		ShortestPathWithObstacleElimination test = new ShortestPathWithObstacleElimination();
		int[][] grid = new int[][]{
				{0,0,1,0,0,0,0,1,0,1,1,0,0,1,1},{0,0,0,1,1,0,0,1,1,0,1,0,0,0,1},{1,1,0,0,0,0,0,1,0,1,0,0,1,0,0},{1,0,1,1,1,1,0,0,1,1,0,1,0,0,1},{1,0,0,0,1,1,0,1,1,0,0,1,1,1,1},{0,0,0,1,1,1,0,1,1,0,0,1,1,1,1},{0,0,0,1,0,1,0,0,0,0,1,1,0,1,1},{1,0,0,1,1,1,1,1,1,0,0,0,1,1,0},{0,0,1,0,0,1,1,1,1,1,0,1,0,0,0},{0,0,0,1,1,0,0,1,1,1,1,1,1,0,0},{0,0,0,0,1,1,1,0,0,1,1,1,0,1,0}
		};
		System.out.println(test.shortestPath(grid, 27));
	}
}
