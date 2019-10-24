
public class FindKthLargestElementInTwoSortedArray {
	/**
	 * This method takes two sorted array, arr1 and arr2, and returns the 
	 * k-th largest element in the union array
	 */
	public int find(int[] arr1, int[] arr2, int k) {
		int arr1Head = 0, arr1Tail = arr1.length - 1;
		int arr2Head = 0, arr2Tail = arr2.length - 1;
		while(true) {
			int mid1 = arr1[arr1Head + (arr1Tail - arr1Head) / 2];
			int mid2 = arr1[arr2Head + (arr2Tail - arr2Head) / 2];
			if(mid1 > mid2) {
				if(k > (arr1.length + arr2.length) / 2) {
					arr2Head = arr2Head + (arr2Tail - arr2Head) / 2;
				}else {
					
				}
			}
			break;
		}
		return 0;
	}
}
