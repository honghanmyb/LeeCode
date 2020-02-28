public class NumberOfDiceRollsWithTargetSum {
    public int numRollsToTarget(int d, int f, int target) {
        int[][] numRolls = new int[d + 1][target + 1];
        for(int i = 1; i <= Math.min(f, target); i++){
            numRolls[1][i] = 1;
        }
        for(int i = 2; i <= d; i++){
            for(int j = i; j <= Math.min(i * f, target); j++){
                int count = 0;
                for(int k = Math.max(1, j - f); k < j; k++){
                    count += numRolls[i - 1][k];
                    count %= 1000000007;
                }
                numRolls[i][j] = count;
            }
        }
        return numRolls[d][target];
    }
}
