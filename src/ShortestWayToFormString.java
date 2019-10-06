import java.util.Arrays;

public class ShortestWayToFormString {
    public int shortestWay(String source, String target) {
        int[] shortest = new int[target.length()];
        int currentHeadIndex = 0;
        int lastPos = source.indexOf(target.charAt(0)) + 1;
        shortest[0] = 1;
        for(int i = 1; i < shortest.length; i++){
            char currentCh = target.charAt(i);
            int currentPos = source.indexOf(currentCh, lastPos);
            if(currentPos == -1){
                lastPos = source.indexOf(currentCh) + 1;
                if(lastPos == 0){
                    return -1;
                }
                shortest[i] = shortest[currentHeadIndex] + 1;
                currentHeadIndex = i;
            }else{
                shortest[i] = shortest[currentHeadIndex];
                lastPos = currentPos + 1;
            }
        }
        return shortest[shortest.length - 1];
    }
}
