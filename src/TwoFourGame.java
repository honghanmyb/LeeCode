import java.util.ArrayList;
import java.util.List;

public class TwoFourGame {
    public boolean judgePoint24(int[] nums) {
        Fraction[] fractions = new Fraction[4];
        for (int i = 0; i < nums.length; i++) {
            fractions[i] = new Fraction(nums[i], 1);
        }
        if (can24TwoGroup(fractions, 0, 1, 2, 3) || can24TwoGroup(fractions, 0, 3, 1, 2)) {
            return true;
        }
        boolean[] used = new boolean[4];
        for (int i = 0; i < fractions.length; i++) {
            used[i] = true;
            if (dfs(fractions, fractions[i], used, 1)) {
                return true;
            }
            used[i] = false;
        }

        return false;
    }

    private boolean dfs(Fraction[] fractions, Fraction num, boolean[] used, int useCount) {
        if (useCount == 4) {
            return num.is24();
        }
        for (int i = 0; i < fractions.length; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            if (dfs(fractions, Fraction.add(fractions[i], num), used, useCount + 1) ||
                    dfs(fractions, Fraction.minus(fractions[i], num), used, useCount + 1) ||
                    dfs(fractions, Fraction.minus(num, fractions[i]), used, useCount + 1) ||
                    dfs(fractions, Fraction.times(fractions[i], num), used, useCount + 1) ||
                    dfs(fractions, Fraction.divide(fractions[i], num), used, useCount + 1) ||
                    dfs(fractions, Fraction.divide(num, fractions[i]), used, useCount + 1)) {
                return true;
            }
            used[i] = false;
        }
        return false;
    }

    private boolean can24TwoGroup(Fraction[] fractions, int g11, int g12, int g21, int g22) {
        List<Fraction> arr1 = new ArrayList<>(6);
        List<Fraction> arr2 = new ArrayList<>(6);
        addPossibleFractions(arr1, fractions[g11], fractions[g12]);
        addPossibleFractions(arr2, fractions[g21], fractions[g22]);
        for (Fraction num1 : arr1) {
            for (Fraction num2 : arr2) {
                if (Fraction.add(num1, num2).is24() || Fraction.minus(num1, num2).is24()
                        || Fraction.minus(num2, num1).is24() || Fraction.times(num1, num2).is24()
                        || Fraction.divide(num1, num2).is24() || Fraction.divide(num2, num1).is24()) {
                    return true;
                }
            }
        }
        return false;
    }

    private void addPossibleFractions(List<Fraction> arr, Fraction num1, Fraction num2) {
        arr.add(Fraction.add(num1, num2));
        arr.add(Fraction.minus(num1, num2));
        arr.add(Fraction.minus(num2, num1));
        arr.add(Fraction.times(num1, num2));
        arr.add(Fraction.divide(num1, num2));
        arr.add(Fraction.divide(num2, num1));
    }

    private static class Fraction {
        int top;
        int buttom;

        Fraction(int top, int buttom) {
            this.top = top;
            this.buttom = buttom;
        }

        boolean is24() {
            return this.top / this.buttom == 24 && this.top % this.buttom == 0;
        }

        static Fraction add(Fraction num1, Fraction num2) {
            int newTop = num1.top * num2.buttom + num2.top * num1.buttom;
            int newButtom = num1.buttom * num2.buttom;
            if (newTop % newButtom == 0) {
                newTop /= newButtom;
                newButtom = 1;
            }
            return new Fraction(newTop, newButtom);
        }

        static Fraction minus(Fraction num1, Fraction num2) {
            int newTop = num1.top * num2.buttom - num2.top * num1.buttom;
            int newButtom = num1.buttom * num2.buttom;
            if (newTop % newButtom == 0) {
                newTop /= newButtom;
                newButtom = 1;
            }
            return new Fraction(newTop, newButtom);
        }

        static Fraction times(Fraction num1, Fraction num2) {
            int newTop = num1.top * num2.top;
            int newButtom = num1.buttom * num2.buttom;
            if (newTop % newButtom == 0) {
                newTop /= newButtom;
                newButtom = 1;
            }
            return new Fraction(newTop, newButtom);
        }

        static Fraction divide(Fraction num1, Fraction num2) {
            int newTop = num1.top * num2.buttom;
            int newButtom = num1.buttom * num2.top;
            if (newButtom == 0) {
                return new Fraction(newTop, Integer.MAX_VALUE);
            }
            if (newTop % newButtom == 0) {
                newTop /= newButtom;
                newButtom = 1;
            }
            return new Fraction(newTop, newButtom);
        }
    }
}
