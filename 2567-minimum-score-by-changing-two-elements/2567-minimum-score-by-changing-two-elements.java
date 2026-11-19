import java.util.Arrays;

class Solution {
    public int minimizeSum(int[] nums) {
        int n = nums.length;
        if (n <= 3) {
            return 0;
        }

        Arrays.sort(nums);

        // 1. Change two smallest elements -> new range is nums[n - 1] - nums[2]
        int changeTwoSmallest = nums[n - 1] - nums[2];

        // 2. Change two largest elements -> new range is nums[n - 3] - nums[0]
        int changeTwoLargest = nums[n - 3] - nums[0];

        // 3. Change one smallest and one largest -> new range is nums[n - 2] - nums[1]
        int changeOneEach = nums[n - 2] - nums[1];

        return Math.min(changeTwoSmallest, Math.min(changeTwoLargest, changeOneEach));
    }
}