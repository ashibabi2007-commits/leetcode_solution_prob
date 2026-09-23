class Solution {
    public int minOperations(int[] nums, int x) {
        int total = 0;

        for (int n : nums) {
            total += n;
        }

        int target = total - x;

        if (target < 0) {
            return -1;
        }

        if (target == 0) {
            return nums.length;
        }

        int l = 0;
        int sum = 0;
        int max = -1;

        for (int r = 0; r < nums.length; r++) {
            sum += nums[r];

            while (sum > target) {
                sum -= nums[l];
                l++;
            }

            if (sum == target) {
                max = Math.max(max, r - l + 1);
            }
        }

        if (max == -1) {
            return -1;
        }

        return nums.length - max;
    }
}