import java.util.Arrays;

class Solution {
    public int climbStairs(int n, int[] costs) {
        int[] f = new int[n + 1];
        final int inf = Integer.MAX_VALUE / 2;
        Arrays.fill(f, inf);
        
        // Base case: starting at step 0 with cost 0
        f[0] = 0;
        
        for (int i = 1; i <= n; ++i) {
            int costVal = costs[i - 1];
            // We can jump from j to i, where the jump distance (i - j) is between 1 and 3
            for (int j = Math.max(0, i - 3); j < i; ++j) {
                f[i] = Math.min(f[i], f[j] + costVal + (i - j) * (i - j));
            }
        }
        
        return f[n];
    }
}