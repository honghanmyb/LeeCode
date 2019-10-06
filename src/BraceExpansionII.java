import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class BraceExpansionII {
    public List<String> braceExpansionII(String expression) {
        Set<String> set = new HashSet<>();
        int firstLeftBraceIndex = 0;
        while(firstLeftBraceIndex < expression.length() && expression.charAt(firstLeftBraceIndex) != '{'){
            firstLeftBraceIndex += 1;
        }
        if(firstLeftBraceIndex >= expression.length()){
            String[] elements = expression.split(",");
            Arrays.sort(elements);
            return Arrays.asList(elements);
        }
        if(firstLeftBraceIndex != 0){
            int lastCommaIndex = firstLeftBraceIndex;
            while(lastCommaIndex >= 0 && expression.charAt(lastCommaIndex) != ','){
               lastCommaIndex -= 1;
            }
            if(lastCommaIndex < 0){
                int sameLevelCommaIndex = firstLeftBraceIndex;
                int braceCount = 0;
                while(sameLevelCommaIndex < expression.length()){
                    char ch = expression.charAt(sameLevelCommaIndex);
                    if(ch == '{'){
                        braceCount += 1;
                    }
                    if(ch == '}'){
                        braceCount -= 1;
                    }
                    if(ch == ',' && braceCount == 0){
                        break;
                    }
                    sameLevelCommaIndex += 1;
                }
                if(sameLevelCommaIndex >= expression.length()){
                    String firstPart = expression.substring(0, firstLeftBraceIndex);
                    List<String> secondPart = braceExpansionII(expression.substring(firstLeftBraceIndex));
                    for(String secondPartElement: secondPart){
                        set.add(firstPart + secondPartElement);
                    }
                }else{
                    List<String> firstPart = braceExpansionII(expression.substring(0, sameLevelCommaIndex));
                    List<String> secondPart = braceExpansionII(expression.substring(sameLevelCommaIndex + 1));
                    set.addAll(firstPart);
                    set.addAll(secondPart);
                }
            }else{
                List<String> left = braceExpansionII(expression.substring(0, lastCommaIndex));
                List<String> right = braceExpansionII(expression.substring(lastCommaIndex + 1));
                set.addAll(left);
                set.addAll(right);
            }
        }else{
            int firstRightBraceIndex = firstLeftBraceIndex;
            int braceCount = 0;
            int currentPos = firstLeftBraceIndex;
            while(true){
                char currentCh = expression.charAt(currentPos);
                if(currentCh == '{'){
                    braceCount += 1;
                }else if(currentCh == '}'){
                    braceCount -= 1;
                    if(braceCount == 0){
                        firstRightBraceIndex = currentPos;
                        break;
                    }
                }
                currentPos += 1;
            }
            if(firstRightBraceIndex == expression.length() - 1){
                set.addAll(braceExpansionII(expression.substring(1, firstRightBraceIndex)));
            }else{
                int firstSameLevelCommaIndex = firstRightBraceIndex + 1;
                while(firstSameLevelCommaIndex < expression.length()){
                    char currentCh = expression.charAt(firstSameLevelCommaIndex);
                    if(currentCh == '{'){
                        braceCount += 1;
                    }
                    if(currentCh == '}'){
                        braceCount -= 1;
                    }
                    if(currentCh == ',' && braceCount == 0){
                        break;
                    }
                    firstSameLevelCommaIndex += 1;
                }
                if(firstSameLevelCommaIndex >= expression.length()){
                    List<String> left = braceExpansionII(expression.substring(firstLeftBraceIndex + 1, firstRightBraceIndex));
                    List<String> right = braceExpansionII(expression.substring(firstRightBraceIndex + 1));
                    for(String leftElement: left){
                        for(String rightElement: right){
                            set.add(leftElement + rightElement);
                        }
                    }
                }else{
                    set.addAll(braceExpansionII(expression.substring(firstLeftBraceIndex, firstSameLevelCommaIndex)));
                    set.addAll(braceExpansionII(expression.substring(firstSameLevelCommaIndex + 1)));
                }
            }
        }
        List<String> total = new ArrayList<>(set.size());
        total.addAll(set);
        Collections.sort(total);
        return total;
    }
}
