class Solution {
    public int findPeakElement(int[] nums) {
        int l=0;
        int r=nums.length-1;
        
        while(l<r){
            if (nums[l+1]<nums[l]){
                return l;
            }
            
            l++;
        }
        return r;
    }
}