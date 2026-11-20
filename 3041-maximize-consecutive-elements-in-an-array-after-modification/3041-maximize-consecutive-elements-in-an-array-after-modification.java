import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxSelectedElements(int[] nums) {
        Arrays.sort(nums);
        // dp.get(v) = max length of a consecutive sequence ending at value v
        Map<Integer, Integer> dp = new HashMap<>();
        int maxLen = 0;

        for (int num : nums) {
            // Option 1: increment num -> num + 1, extending sequence ending at num
            int lenPlusOne = dp.getOrDefault(num, 0) + 1;
            dp.put(num + 1, lenPlusOne);

            // Option 2: keep num -> num, extending sequence ending at num - 1
            int lenSame = dp.getOrDefault(num - 1, 0) + 1;
            dp.put(num, lenSame);

            if (lenPlusOne > maxLen) {
                maxLen = lenPlusOne;
            }
            if (lenSame > maxLen) {
                maxLen = lenSame;
            }
        }

        return maxLen;
    }
}