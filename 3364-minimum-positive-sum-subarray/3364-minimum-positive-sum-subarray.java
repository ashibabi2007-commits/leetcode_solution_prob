class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n = nums.size();
        int ans = Integer.MAX_VALUE;
        
        // Iterate through all possible starting points
        for (int i = 0; i < n; ++i) {
            int s = 0;
            // Extend the subarray to the right
            for (int j = i; j < n; ++j) {
                s += nums.get(j);
                int k = j - i + 1; // Current subarray length
                
                // Check if length is within [l, r] and the sum is strictly positive
                if (k >= l && k <= r && s > 0) {
                    ans = Math.min(ans, s);
                }
            }
        }
        
        // If ans wasn't updated, no valid subarray was found
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}