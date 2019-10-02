
public class LongestMountainInArray {
    public int longestMountain(int[] A) {
        int longest = 0;
        int startIndex = 0;
        int endIndex = 1;
        int peakIndex = 0;
        if(A.length < 3){
            return 0;
        }
        boolean isGoUp = true;
        for(int i = 0; i < A.length - 1; i++){
            if(isGoUp){
                if(A[i] < A[i + 1]){
                    continue;
                }else if(A[i] == A[i + 1]){
                    startIndex = i + 1;
                }else{
                    peakIndex = i;
                    isGoUp = false;
                }
            }else{
                if(startIndex < peakIndex){
                    longest = Integer.max(longest, i - startIndex + 1); 
                }
                if(A[i] > A[i + 1]){
                    continue;
                }else if(A[i] == A[i + 1]){
                    startIndex = i + 1;
                    isGoUp = true;
                }else{
                    endIndex = i;
                    isGoUp = true;
                    startIndex = i;
                }
            }
        }
        if(!isGoUp && peakIndex > startIndex){
            longest = Integer.max(longest, A.length - startIndex);
        }
        return longest;
    }
}
