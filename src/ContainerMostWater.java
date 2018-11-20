
public class ContainerMostWater {
	public int maxArea(int[] height) {
		if(height.length < 2) return 0;
		int maxWater = 0;
		int head = 0;
		int tail = height.length - 1;
		 while(head < tail) {
			 int currentWater = (tail - head) * Math.min(height[head], height[tail]);
			 if(height[head] < height[tail]) head++;
			 else tail--;
			 if(maxWater < currentWater) maxWater = currentWater;
		 }
		 
		 return maxWater;
		
	}
}
