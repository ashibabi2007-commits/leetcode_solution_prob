class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int left=-1;
        int right=-1;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]>nums[i+1]){
                left=i;
                break;
            }
        }
        if (left == -1) {
            return 0 ;
        }
        for(int i=nums.length-1;i>0;i--){
            if(nums[i]<nums[i-1]){
                right=i;
                break;
            }
        }
        int min = Integer.MAX_VALUE ;
        int max = Integer.MIN_VALUE ;
        for (int i = left ; i <= right ; i++) {
            min=Math.min(min,nums[i]);
            max=Math.max(max,nums[i]);
        }
        while(left>0 && nums[left-1]>min){
            left--;
        }
        while(right<nums.length-1 && nums[right+1]<max){
            right++;
        }
        return right-left+1;
        
    }
}