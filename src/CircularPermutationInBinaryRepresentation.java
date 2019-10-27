import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CircularPermutationInBinaryRepresentation {
    public List<Integer> circularPermutation(int n, int start) {
        List<String> binary = new ArrayList<>();
        binary.add("0");
        binary.add("1");
        
        if(n == 1){
            if(start == 0){
                return Arrays.asList(0, 1);
            }else{
                return Arrays.asList(1, 0);
            }
        }
        for(int i = 1; i < n; i++){
            int currentSize = binary.size();
            for(int j = currentSize - 1; j >= 0; j--){
                binary.add("1" + binary.get(j));
                binary.set(j, "0" + binary.get(j));
            }
        }
        System.out.println(binary);
        List<Integer> convertedBinary = new ArrayList<>(binary.size());
        for(String biString: binary){
            convertedBinary.add(Integer.parseInt(biString, 2));
        }
        int startIndex = 0;
        List<Integer> rotated = new ArrayList<>(binary.size());
        while(convertedBinary.get(startIndex) != start){
            startIndex ++;
        }
        for(int i = startIndex; i < convertedBinary.size(); i++){
            rotated.add(convertedBinary.get(i));
        }
        for(int i = 0; i < startIndex; i++){
            rotated.add(convertedBinary.get(i));
        }
        return rotated;
    }
}
