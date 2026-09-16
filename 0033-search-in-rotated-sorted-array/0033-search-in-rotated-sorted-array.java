class Solution {
    public int search(int[] nums, int target) {
        int l=0;
        int r=nums.length-1;
        while(l<=r){
            if (nums[l]==target){
                return l;
            }
            l++;
        }
        return -1;
    }
}