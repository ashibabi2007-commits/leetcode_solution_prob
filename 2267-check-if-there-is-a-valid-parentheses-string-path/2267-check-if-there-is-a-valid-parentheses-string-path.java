class Solution {
    public boolean hasValidPath(char[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        if (grid[0][0] == ')' || grid[m - 1][n - 1] == '(') {
            return false;
        }

        boolean[][][] dp = new boolean[m][n][m + n];

        dp[0][0][1] = true;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                for (int balance = 0; balance < m + n; balance++) {

                    if (!dp[i][j][balance]) {
                        continue;
                    }

                    if (i + 1 < m) {
                        int next = balance + (grid[i + 1][j] == '(' ? 1 : -1);

                        if (next >= 0) {
                            dp[i + 1][j][next] = true;
                        }
                    }

                    if (j + 1 < n) {
                        int next = balance + (grid[i][j + 1] == '(' ? 1 : -1);

                        if (next >= 0) {
                            dp[i][j + 1][next] = true;
                        }
                    }
                }
            }
        }

        return dp[m - 1][n - 1][0];
    }
}