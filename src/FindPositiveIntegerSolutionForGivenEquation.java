import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindPositiveIntegerSolutionForGivenEquation {
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 1; i <= 1000; i++){
            for(int j = 1; i <= 1000; j++){
                int current = customfunction.f(i, j);
                if(current == z){
                    result.add(Arrays.asList(i, j));
                }else if(current > z){
                    break;
                }
            }
        }
        return result;
    }
}
