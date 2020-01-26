public class MinDifficultyOfJobSchedule {
    public int minDifficulty(int[] jobDifficulty, int d) {
        if(jobDifficulty.length < d){
            return -1;
        }
        int[][] dayWork = new int[d][jobDifficulty.length];
        int maxWork = jobDifficulty[0];
        for(int i = 0; i < jobDifficulty.length; i++){
            maxWork = Math.max(maxWork, jobDifficulty[i]);
            dayWork[0][i] = maxWork;
        }
        for(int i = 1; i < d; i++){
            for(int j = i; j < jobDifficulty.length; j++){
                int curMax = jobDifficulty[j];
                int curMin = Integer.MAX_VALUE;
                for(int k = j; k >= i; k--){
                    curMax = Math.max(curMax, jobDifficulty[k]);
                    curMin = Math.min(curMin, dayWork[i - 1][k - 1] + curMax);
                }
                dayWork[i][j] = curMin;
            }
        }
        return dayWork[d - 1][jobDifficulty.length - 1];
    }
}
