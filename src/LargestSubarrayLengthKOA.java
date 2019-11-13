
public class LargestSubarrayLengthKOA {
	public int[] largestSubarray(int[] A, int K) {
		if(K == A.length) {
			return A;
		}
		int largestStartIndex = 0;
		int largestStartNum = A[0];
		for(int i = 1; i <= A.length - K; i++) {
			if(A[i] > largestStartNum) {
				largestStartNum = A[i];
				largestStartIndex = i;
			}else if(A[i] == largestStartNum) {
				if(isLargerSubarray(i, largestStartIndex, K, A)) {
					largestStartIndex = i;
				}
			}
		}
		int[] largestSubarray = new int[K];
		for(int i = 0; i < K; i++) {
			largestSubarray[i] = A[largestStartIndex++];
		}
		return largestSubarray;
	}
	
	private boolean isLargerSubarray(int newIndex, int oldIndex, int K, int[] A) {
		//return true if the new subarray is larger than the old one
		for(int i = 0; i < K; i++) {
			if(A[newIndex] > A[oldIndex]) {
				return true;
			}else if(A[newIndex] < A[oldIndex]) {
				return false;
			}
			newIndex++;
			oldIndex++;
		}
		return false;
	}
}
