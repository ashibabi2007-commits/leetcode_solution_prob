class Solution {
    public int[] sortedSquares(int[] nums) {
        int l=0;
        int r=nums.length-1;
        while(l<=r){
            nums[l]=nums[l]*nums[l];
            l++;
        }
        Arrays.sort(nums);
        return nums;
    }
}