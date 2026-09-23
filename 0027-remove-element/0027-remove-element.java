class Solution {
    public int removeElement(int[] nums, int val) {
        int l=0;
        int r=0;
        while(r<nums.length){
            if(nums[r]!=val){
                nums[l]=nums[r];
                l++;
            }
            r++;
        }
        return l;
    }
}