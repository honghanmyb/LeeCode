import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PalindromePartitionIII {
    public int palindromePartition(String s, int k) {
        if (k == s.length()) {
            return 0;
        }
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                map.put(s.substring(i, j + 1), count(s, i, j));
            }
        }
        int[][] dp = new int[k][s.length()];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], 1000);
        }
        for (int i = 0; i < s.length(); i++) {
            dp[0][i] = map.get(s.substring(0, i + 1));
        }
        for (int i = 1; i < k; i++) {
            for (int j = i; j < s.length(); j++) {
                for (int t = 0; t < j; t++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][t] + map.get(s.substring(t + 1, j + 1)));
                }
            }
        }
        return dp[k - 1][s.length() - 1];
    }

    private int count(String s, int head, int tail) {
        int count = 0;
        while (head <= tail) {
            if (s.charAt(head) != s.charAt(tail)) {
                count++;
            }
            head++;
            tail--;
        }
        return count;
    }
}
