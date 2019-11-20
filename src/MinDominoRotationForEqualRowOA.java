//The problem has changed to that given array A and B, and int K,
//switch at most K times for value in A and B, find the largest num
//you can get either in A or in B
public class MinDominoRotationForEqualRowOA {
	public int minDominoRotations(int[] A, int[] B) {
		int minRotate = Integer.MAX_VALUE;
		minRotate = Integer.min(minRotate, rotate(A, B, A[0]));
		minRotate = Integer.min(minRotate, rotate(A, B, B[0]));
		minRotate = Integer.min(minRotate, rotate(B, A, A[0]));
		minRotate = Integer.min(minRotate, rotate(B, A, B[0]));
		
		if(minRotate == Integer.MAX_VALUE) {
			return -1;
		}
		return minRotate;
	}
	
	private int rotate(int[] target, int[] support, int targetValue) {
		int rotate = 0;
		for(int i = 0; i < target.length; i++) {
			if(target[i] != targetValue) {
				if(support[i] != targetValue) {
					return Integer.MAX_VALUE;
				}
				rotate++;
			}
		}
		return rotate;
	}
}
