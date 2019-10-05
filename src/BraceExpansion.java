import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BraceExpansion {
    public String[] expand(String S) {
        String[] elements = S.split("\\{|}");
        List<String> combinations = new ArrayList<>();
        addAllCombinations("", 0, elements, combinations);
        Collections.sort(combinations);
        return combinations.toArray(new String[combinations.size()]);
    }
    
    private void addAllCombinations(String previous, int elementIndex, String[] elements,
                                   List<String> combinations){
        if(elementIndex >= elements.length){
            combinations.add(previous);
            return;
        }
        String[] currentElementSplits = elements[elementIndex].split(",");
        for(String elementSplit: currentElementSplits){
            addAllCombinations(previous + elementSplit, elementIndex + 1, elements, combinations);
        }
    }
}
