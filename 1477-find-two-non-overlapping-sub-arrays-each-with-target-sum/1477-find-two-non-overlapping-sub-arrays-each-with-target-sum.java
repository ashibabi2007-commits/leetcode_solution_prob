class Solution {
    public int minSumOfLengths(int[] arr, int target) {

        int n = arr.length;
        int[] best = new int[n];

        int left = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;

        for (int right = 0; right < n; right++) {

            sum += arr[right];

            while (sum > target) {
                sum -= arr[left];
                left++;
            }

            if (right > 0) {
                best[right] = best[right - 1];
            }

            if (sum == target) {

                int length = right - left + 1;

                if (left > 0 && best[left - 1] != 0) {
                    min = Math.min(min, length + best[left - 1]);
                }

                if (best[right] == 0 || length < best[right]) {
                    best[right] = length;
                }
            }
        }

        if (min == Integer.MAX_VALUE) {
            return -1;
        }

        return min;
    }
}