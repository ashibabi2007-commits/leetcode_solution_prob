class Solution {
    public int removeDuplicates(int[] nums) {
        int left=0;
        int right=1;
        while(right<=nums.length-1){
            if(nums[left]!=nums[right]){
                left++;
                nums[left]=nums[right];
            }
            right++;
        }
        return left+1;
    }
}