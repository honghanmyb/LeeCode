public class MaxPointsObtainedFromCards {
    public int maxScore(int[] cardPoints, int k) {
        if (k == 1) {
            return Math.max(cardPoints[0], cardPoints[cardPoints.length - 1]);
        }
        int[] headPoints = new int[k + 1];
        int[] tailPoints = new int[k + 1];
        headPoints[0] = 0;
        tailPoints[k] = 0;
        for (int i = 1; i < k + 1; i++) {
            headPoints[i] = headPoints[i - 1] + cardPoints[i - 1];
        }
        for (int i = 0; i < k; i++) {
            tailPoints[k - 1 - i] = tailPoints[k - i] + cardPoints[cardPoints.length - 1 - i];
        }
        int max = 0;
        for (int i = 0; i <= k; i++) {
            max = Math.max(max, headPoints[i] + tailPoints[i]);
        }
        return max;
    }
}
