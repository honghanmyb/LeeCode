


public class FindMedian {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		if(nums1 == null) nums1 = nums2;
		if(nums2 == null) {
			if(nums1.length % 2 ==0) return ((double)nums1[nums1.length/2] + nums1[nums1.length / 2 -1])/2;
			return (double)nums1[nums1.length / 2];
		}
		if(nums1.length == 1|| nums2.length == 1) {
			if(nums1.length ==1) {
				int[] temp = nums1;
				nums1 = nums2;
				nums2 = temp;
			}
			if(nums1.length == 1) return ((double)nums1[0] + nums2[0]) / 2;
			if(nums1.length ==2) {
				if(nums1[0] >= nums2[0]) return (double)nums1[0];
				if(nums2[0] >= nums1[1]) return (double) nums1[1];
				return nums2[0];
			}
		/*	if(nums1[nums1.length / 2] < nums2[0]) {
				
			}*/
		}
		int subsetSize = (nums1.length + nums2.length) / 2;
		if(nums1[0] > nums2[0]) {
			int[] temp = nums1;
			nums1 = nums2;
			nums2 = temp;
		}
		for(int i = 0; i < nums1.length; i++) {
			int j = subsetSize - i - 2;
			if(nums1[i] <= nums2[j+1] && nums2[j] <= nums1[i + 1]) {
				if(subsetSize * 2 == nums1.length + nums2.length) {
					return (Math.max(nums1[i], nums2[j]) + (double)Math.min(nums1[i+1], nums2[j+1])) / 2;
				}else {
					return (double)Math.min(nums1[i+1], nums2[j+1]);
				}
			}
		}
		return 0;
	}
}
