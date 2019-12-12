public class DivideChocolate {
    public int maximizeSweetness(int[] sweetness, int K) {
        int min = sweetness[0];
        int max = 0;
        for (int sweet : sweetness) {
            min = Math.min(min, sweet);
            max += sweet;
        }
        if (K == 0) {
            return max;
        }
        while (min <= max) {
            int mid = min + (max - min) / 2;
            if (canDivide(sweetness, mid, K + 1)) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        return max;
    }

    private boolean canDivide(int[] sweetness, int total, int K) {
        int current = 0;
        for (int sweet : sweetness) {
            current += sweet;
            if (current >= total) {
                current = 0;
                K--;
                if (K <= 0) {
                    return true;
                }
            }
        }
        return false;
    }
}
