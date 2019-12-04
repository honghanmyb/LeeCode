public class MinSwapsToMakeSequenceIncreasing {
    public int minSwap(int[] A, int[] B) {
        int count = 0;
        if(A.length == 1){
            return 0;
        }
        int unswapPre = 0;
        int swapPre = 1;
        for(int i = 1; i < A.length; i++){
            int unswapCur = Integer.MAX_VALUE;
            int swapCur = Integer.MAX_VALUE;
            if(A[i] > A[i - 1] && B[i] > B[i - 1]){
                unswapCur = Math.min(unswapCur, unswapPre);
                swapCur = Math.min(swapCur, swapPre + 1);
            }
            if(A[i] > B[i - 1] && B[i] > A[i - 1]){
                unswapCur = Math.min(unswapCur, swapPre);
                swapCur = Math.min(swapCur, unswapPre + 1);
            }
            swapPre = swapCur;
            unswapPre = unswapCur;
        }

        return Math.min(unswapPre, swapPre);
    }
}
