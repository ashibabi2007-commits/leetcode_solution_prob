class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int[] free = new int[n];

        for (int i = 0; i < n; i++) {
            int f1 = items[i][0];
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && items[j][0] % f1 == 0) {
                    count++;
                }
            }
            free[i] = count;
        }

        int[] dp = new int[budget + 1];

        for (int i = 0; i < n; i++) {
            int cost = items[i][1];
            int bonus = free[i];
            if (cost > budget) {
                continue;
            }

            // 1. First purchase of item i: 1 purchased + bonus free items
            for (int b = budget; b >= cost; b--) {
                dp[b] = Math.max(dp[b], dp[b - cost] + 1 + bonus);
            }

            // 2. Subsequent copies of item i: 1 item per copy
            for (int b = cost; b <= budget; b++) {
                dp[b] = Math.max(dp[b], dp[b - cost] + 1);
            }
        }

        return dp[budget];
    }
}