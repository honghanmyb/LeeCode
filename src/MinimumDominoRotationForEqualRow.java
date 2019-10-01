
public class MinimumDominoRotationForEqualRow {
    public int minDominoRotations(int[] A, int[] B) {
        int minRotations = Integer.MAX_VALUE;
        minRotations = Integer.min(minRotations, rotate(A, B, B[0]));
        minRotations = Integer.min(minRotations, rotate(A, B, A[0]));
        minRotations = Integer.min(minRotations, rotate(B, A, A[0]));
        minRotations = Integer.min(minRotations, rotate(B, A, B[0]));
        if(minRotations > A.length){
            return -1;
        }
        return minRotations;
    }
    
    private int rotate(int[] target, int[] other, int targetValue){
        int rotate = 0;
        for(int i = 0; i < target.length; i++){
            if(target[i] != targetValue){
                if(other[i] != targetValue){
                    return Integer.MAX_VALUE;
                }
                rotate += 1;
            }
        }
        return rotate;
    }
}
