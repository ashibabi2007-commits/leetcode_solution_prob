import java.util.HashMap;
import java.util.Map;

class Solution {
    private static final int MOD = 1_000_000_007;
    private long[] sum;
    private long[] sumSq;
    private long[] lazy;

    public int sumCounts(int[] nums) {
        int n = nums.length;
        sum = new long[4 * n];
        sumSq = new long[4 * n];
        lazy = new long[4 * n];

        Map<Integer, Integer> lastOccurrence = new HashMap<>();
        long currentAns = 0;

        for (int i = 0; i < n; i++) {
            int x = nums[i];
            int last = lastOccurrence.getOrDefault(x, -1);
            
            // Update the range [last + 1, i] by adding 1 to distinct counts
            update(1, 0, n - 1, last + 1, i, 1);
            lastOccurrence.put(x, i);

            // The root node contains the sum of squares for all subarrays ending at the current index i
            currentAns = (currentAns + sumSq[1]) % MOD;
        }

        return (int) currentAns;
    }

    private void pushDown(int node, int l, int r) {
        if (lazy[node] != 0) {
            int mid = (l + r) / 2;
            apply(2 * node, l, mid, lazy[node]);
            apply(2 * node + 1, mid + 1, r, lazy[node]);
            lazy[node] = 0;
        }
    }

    private void apply(int node, int l, int r, long v) {
        long len = r - l + 1;
        // new_sumSq = sumSq + 2 * v * sum + len * v^2
        sumSq[node] = (sumSq[node] + 2 * v * sum[node] + len * (v % MOD) % MOD * (v % MOD)) % MOD;
        // new_sum = sum + len * v
        sum[node] = (sum[node] + len * v) % MOD;
        lazy[node] = (lazy[node] + v) % MOD;
    }

    private void update(int node, int l, int r, int ql, int qr, long v) {
        if (ql > r || qr < l) {
            return;
        }
        if (ql <= l && r <= qr) {
            apply(node, l, r, v);
            return;
        }
        pushDown(node, l, r);
        int mid = (l + r) / 2;
        update(2 * node, l, mid, ql, qr, v);
        update(2 * node + 1, mid + 1, r, ql, qr, v);
        
        sum[node] = (sum[2 * node] + sum[2 * node + 1]) % MOD;
        sumSq[node] = (sumSq[2 * node] + sumSq[2 * node + 1]) % MOD;
    }
}