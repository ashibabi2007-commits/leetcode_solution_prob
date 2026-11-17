import java.util.Arrays;

class Solution {
    public int minimumChanges(String s, int k) {
        int n = s.length();
        int INF = 1_000_000;

        // 1. Precompute minimum changes to make s[i..j] a semi-palindrome
        int[][] cost = new int[n][n];
        for (int[] row : cost) {
            Arrays.fill(row, INF);
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                cost[i][j] = getSemiPalindromeCost(s, i, j);
            }
        }

        // 2. DP: dp[parts][end] = min cost to partition s[0..end] into `parts` substrings
        int[][] dp = new int[k + 1][n];
        for (int[] row : dp) {
            Arrays.fill(row, INF);
        }

        for (int j = 1; j < n; j++) {
            dp[1][j] = cost[0][j];
        }

        for (int parts = 2; parts <= k; parts++) {
            // Each part needs at least 2 characters
            for (int j = 2 * parts - 1; j < n; j++) {
                for (int m = 2 * (parts - 1) - 1; m <= j - 2; m++) {
                    if (dp[parts - 1][m] != INF && cost[m + 1][j] != INF) {
                        dp[parts][j] = Math.min(dp[parts][j], dp[parts - 1][m] + cost[m + 1][j]);
                    }
                }
            }
        }

        return dp[k][n - 1];
    }

    private int getSemiPalindromeCost(String s, int start, int end) {
        int len = end - start + 1;
        int minChanges = Integer.MAX_VALUE;

        for (int d = 1; d < len; d++) {
            if (len % d != 0) continue;

            int changes = 0;
            for (int offset = 0; offset < d; offset++) {
                int left = start + offset;
                int right = end + 1 - d + offset;
                while (left < right) {
                    if (s.charAt(left) != s.charAt(right)) {
                        changes++;
                    }
                    left += d;
                    right -= d;
                }
            }
            minChanges = Math.min(minChanges, changes);
        }

        return minChanges;
    }
}