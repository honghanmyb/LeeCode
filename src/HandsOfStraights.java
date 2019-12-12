import java.util.Arrays;

public class HandsOfStraights {
    public boolean isNStraightHand(int[] hand, int W) {
        if(W == 1){
            return true;
        }
        Arrays.sort(hand);
        boolean[] used = new boolean[hand.length];
        for(int i = 0; i < hand.length; i++){
            if(used[i]){
                continue;
            }
            if(!findStartAt(i, hand, used, W)){
                return false;
            }
        }
        return true;
    }

    private boolean findStartAt(int startIndex, int[] hand, boolean[] used, int W){
        used[startIndex] = true;
        int current = hand[startIndex];
        int count = 1;
        for(int i = startIndex + 1; i < hand.length; i++){
            if(used[i]){
                continue;
            }
            if(hand[i] == current + 1){
                count++;
                current = hand[i];
                used[i] = true;
                if(count == W){
                    return true;
                }
            }else if(hand[i] > current + 1){
                return false;
            }
        }
        return count == W;
    }
}
