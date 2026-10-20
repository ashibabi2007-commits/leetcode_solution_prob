import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;
        int ans = 0;
        
        // Find all divisors of n
        List<Integer> divisors = new ArrayList<>();
        for (int d = 1; d * d <= n; d++) {
            if (n % d == 0) {
                divisors.add(d);
                if (d * d != n) {
                    divisors.add(n / d);
                }
            }
        }
        
        for (int k : divisors) {
            boolean valid = true;
            int prevMax = Integer.MIN_VALUE;
            
            // Check each block of size k
            for (int i = 0; i < n; i += k) {
                int[] block = new int[k];
                System.arraycopy(nums, i, block, 0, k);
                
                int[] sortedBlock = block.clone();
                Arrays.sort(sortedBlock);
                
                // Verify if the block is a valid cyclic shift of its sorted version
                if (!isCyclicShift(block, sortedBlock, k)) {
                    valid = false;
                    break;
                }
                
                int currMin = sortedBlock[0];
                int currMax = sortedBlock[k - 1];
                
                // Check inter-block ordering constraint
                if (prevMax > currMin) {
                    valid = false;
                    break;
                }
                prevMax = currMax;
            }
            
            if (valid) {
                ans += k;
            }
        }
        
        return ans;
    }
    
    private boolean isCyclicShift(int[] block, int[] sortedBlock, int k) {
        int descentCount = 0;
        int dropIdx = -1;
        
        // Count the number of drops (where block[j] > block[j+1] cyclically)
        for (int j = 0; j < k; j++) {
            if (block[j] > block[(j + 1) % k]) {
                descentCount++;
                dropIdx = j;
            }
        }
        
        // A valid cyclic shift can have at most one descent
        if (descentCount > 1) return false;
        
        int[] rotated = new int[k];
        if (descentCount == 1) {
            int start = dropIdx + 1;
            for (int j = 0; j < k; j++) {
                rotated[j] = block[(start + j) % k];
            }
        } else {
            System.arraycopy(block, 0, rotated, 0, k);
        }
        
        return Arrays.equals(rotated, sortedBlock);
    }
}