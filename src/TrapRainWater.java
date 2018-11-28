
public class TrapRainWater {
	public int trap(int[] height) {
		if(height.length <= 1) return 0;
		int maxIndex = 0;
		int starter = 0;
		int water = 0;
		for(int i = 0; i < height.length; i++) {
			if(height[i] > height[maxIndex]) maxIndex = i;
		}
		
		for(int i = 0; i <= maxIndex; i++) {
			if(height[i] > height[starter]) {
				starter = i;
			}else {
				water += height[starter] - height[i];
			}
		}
		starter = height.length - 1;
		for(int i = height.length - 1; i >= maxIndex; i--) {
			if(height[i] > height[starter]) {
				starter = i;
			}else {
				water += height[starter] - height[i];
			}
		}
		return water;
	}
}
