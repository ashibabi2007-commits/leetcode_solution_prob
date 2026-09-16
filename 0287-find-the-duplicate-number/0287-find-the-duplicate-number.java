class Solution {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        int l=0;
        int r=nums.length-1;
        while(l<=r){
            if(nums[l]==nums[l+1]){
                return nums[l];
            }
            l++;
        }
        return -1;
    }
}