import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseScheduleII {
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		int[][] courseGraph = reconstructGraph(numCourses, prerequisites);
		Queue<Integer> courseOrder = createAndInitCourseQueue(courseGraph);
		List<Integer> courseTaken = new ArrayList<>();
		while (!courseOrder.isEmpty()) {
			int currentClass = courseOrder.poll();
			courseTaken.add(currentClass);
			for(int i = 0; i < courseGraph.length; i++) {
				if(courseGraph[currentClass][i] == 1) {
					courseGraph[currentClass][i] = 0;
					if(isClassQualify(i, courseGraph)) {
						courseOrder.add(i);
					}
				}
			}
		}
		if (courseTaken.size() < numCourses) {
			courseTaken.clear();
		}
		return courseTaken.stream().mapToInt(i -> i).toArray();
	}

	private int[][] reconstructGraph(int numCourses, int[][] prerequisites) {
		int[][] courseGraph = new int[numCourses][numCourses];
		for (int[] courseEdge : prerequisites) {
			courseGraph[courseEdge[1]][courseEdge[0]] = 1;
		}
		return courseGraph;
	}

	private Queue<Integer> createAndInitCourseQueue(int[][] courseGraph) {
		Queue<Integer> courseOrder = new LinkedList<>();
		for (int j = 0; j < courseGraph.length; j++) {
			boolean needPrerequisite = false;
			for (int i = 0; i < courseGraph.length; i++) {
				if (courseGraph[i][j] == 1) {
					needPrerequisite = true;
					break;
				}
			}
			if (!needPrerequisite) {
				courseOrder.add(j);
			}
		}

		return courseOrder;
	}
	
	private boolean isClassQualify(int currentClass, int[][] courseGraph) {
		for(int i = 0; i < courseGraph.length; i++) {
			if(courseGraph[i][currentClass] == 1) {
				return false;
			}
		}
		return true;
	}
}
