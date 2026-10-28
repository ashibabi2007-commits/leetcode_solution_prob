import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        // dp[i][j] will store all possible XOR values to reach cell (i, j)
        // Since values are < 1024, we can use boolean arrays of size 1024 for each cell,
        // or a Set of Integers for simplicity.
        @SuppressWarnings("unchecked")
        Set<Integer>[][] dp = new HashSet[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = new HashSet<>();
            }
        }
        
        dp[0][0].add(grid[0][0]);
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int xorVal : dp[i][j]) {
                    // Move Down
                    if (i + 1 < m) {
                        dp[i + 1][j].add(xorVal ^ grid[i + 1][j]);
                    }
                    // Move Right
                    if (j + 1 < n) {
                        dp[i][j + 1].add(xorVal ^ grid[i][j + 1]);
                    }
                }
            }
        }
        
        // Find the minimum XOR value at the bottom-right cell (m - 1, n - 1)
        int minXor = Integer.MAX_VALUE;
        for (int xorVal : dp[m - 1][n - 1]) {
            minXor = Math.min(minXor, xorVal);
        }
        
        return minXor;
    }
}