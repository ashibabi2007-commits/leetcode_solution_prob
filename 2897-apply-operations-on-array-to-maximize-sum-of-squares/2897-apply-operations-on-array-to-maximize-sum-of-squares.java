import java.util.List;

class Solution {
    public int maxSum(List<Integer> nums, int k) {
        final int MOD = 1_000_000_007;
        int[] bitCount = new int[31];
        
        // Step 1: Count the set bits at each position (0 to 30)
        for (int x : nums) {
            for (int i = 0; i <= 30; i++) {
                if ((x & (1 << i)) != 0) {
                    bitCount[i]++;
                }
            }
        }
        
        long totalSum = 0;
        
        // Step 2: Greedily construct k numbers to maximize the sum of squares
        for (int i = 0; i < k; i++) {
            long currentNum = 0;
            for (int bit = 0; bit <= 30; bit++) {
                if (bitCount[bit] > 0) {
                    currentNum |= (1L << bit);
                    bitCount[bit]--;
                }
            }
            totalSum = (totalSum + (currentNum * currentNum) % MOD) % MOD;
        }
        
        return (int) totalSum;
    }
}