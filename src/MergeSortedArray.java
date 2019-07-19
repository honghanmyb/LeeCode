
public class MergeSortedArray {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int[] tempArray = new int[m + n];
		
		int mIndicator = 0;
		int nIndicator = 0;
		int tempArrayIndex = 0;
		
		while(mIndicator < m && nIndicator < n) {
			if(nums1[mIndicator] <= nums2[nIndicator]) {
				tempArray[tempArrayIndex++] = nums1[mIndicator++];
			}else {
				tempArray[tempArrayIndex++] = nums2[nIndicator++];
			}
		}
		if(mIndicator < m) {
			addRest(tempArray, tempArrayIndex, nums1, mIndicator);
		}
		
		if(nIndicator < n) {
			addRest(tempArray, tempArrayIndex, nums2, nIndicator);
		}
		
		for(int i = 0; i < m + n; i++) {
			nums1[i] = tempArray[i];
		}
	}
	
	private void addRest(int[] tempArray, int tempArrayIndex, int[] sourceArray, int sourceIndex) {
		while(tempArrayIndex < tempArray.length) {
			tempArray[tempArrayIndex++] = sourceArray[sourceIndex++];
		}
	}
}
