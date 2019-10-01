
public class MinimumDominoRotationForEqualRow {
    public int minDominoRotations(int[] A, int[] B) {
        int minRotation = Integer.MAX_VALUE;
        for(int i = 1; i <= 6; i++){
            int rotation = 0;
            boolean canRotate = false;
            for(int j = 0; j < A.length; j++){
                if(A[j] != i){
                    if(B[j] != i){
                        canRotate = false;
                        break;
                    }
                    rotation += 1;
                }
                if(j == A.length - 1){
                    canRotate = true;
                }
            }
            if(canRotate){
                minRotation = Integer.min(minRotation, rotation);
            }
            rotation = 0;
            canRotate = false;
            for(int j = 0; j < B.length; j++){
                if(B[j] != i){
                    if(A[j] != i){
                        canRotate = false;
                        break;
                    }
                    rotation += 1;
                }
                if(j == B.length - 1){
                    canRotate = true;
                }
            }
            if(canRotate){
                minRotation = Integer.min(minRotation, rotation);
            }
        }
        if(minRotation > A.length){
            return -1;
        }
        return minRotation;
    }
}
