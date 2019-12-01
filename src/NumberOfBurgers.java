import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberOfBurgers {
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        if (tomatoSlices < 2 * cheeseSlices) {
            return new ArrayList<>();
        }
        if (4 * cheeseSlices < tomatoSlices) {
            return new ArrayList<>();
        }
        if (tomatoSlices % 2 != 0) {
            return new ArrayList<>();
        }
        return Arrays.asList(tomatoSlices / 2 - cheeseSlices, 2 * cheeseSlices - tomatoSlices / 2);
    }
}
