
public class CourseSchedule {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		int[][] courseGraph = new int[numCourses][numCourses];
		
		boolean[] needPrerequisite = new boolean[numCourses];
		boolean[] isCovered = new boolean[numCourses];
		
		for(int i = 0; i < prerequisites.length; i++) {
			needPrerequisite[prerequisites[i][0]] = true;
		}
		
		if(allNeedPrerequisite(needPrerequisite)) return false;
		
		reconstructCourseGraph(prerequisites, courseGraph);
		
		for(int i = 0; i < numCourses; i++) {
			if(!needPrerequisite[i]) {
				if(isContainLoop(i, courseGraph, null, isCovered)) return false;
			}
		}
		
		for(int i = 0; i < numCourses; i++) {
			if(!isCovered[i]) return false;
		}
		return true;
	}
	
	private boolean allNeedPrerequisite(boolean[] needPrerequisite) {
		for(int i = 0; i < needPrerequisite.length; i++) {
			if(!needPrerequisite[i]) return false;
		}
		return true;
	}
	
	private void reconstructCourseGraph(int[][] prerequisites, int[][] courseGraph) {
		for(int i = 0; i < prerequisites.length; i++) {
			courseGraph[prerequisites[i][0]][prerequisites[i][1]] = 1;
		}
	}
	
	private boolean isContainLoop(int entry, int[][] courseGraph, boolean[] inStack, boolean[] isCovered) {
		if(inStack == null) inStack = new boolean[courseGraph.length];
		if(inStack[entry]) return true;
		inStack[entry] = true;
		isCovered[entry] = true;
		for(int i = 0; i < inStack.length; i++) {
			if(courseGraph[i][entry] == 1) {
				if(!isContainLoop(i, courseGraph, inStack, isCovered)) continue;
				return true;
			}
		}
		inStack[entry] = false;
		return false;
	}
}
