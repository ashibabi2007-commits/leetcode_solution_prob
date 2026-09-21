class Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int l=0;
        int r=1;
        while(r<nums.length){
            if (r+1<nums.length-1 && nums[l]==nums[r] && nums[r]==nums[r+1] ){
                l+=3;
                r+=3;
            }
            else{
                return nums[l];
            }
        }return nums[l];
    }
}