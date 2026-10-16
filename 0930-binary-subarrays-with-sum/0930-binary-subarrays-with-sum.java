class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return atmost(nums,goal)-atmost(nums,goal-1);
    }
    public int atmost(int[] nums,int target){
        if(target<0){
            return 0;
        }
        int sum=0;
        int count=0;
        int left=0;
        for (int right=0;right<nums.length;right++){
            sum=sum+nums[right];
            while(sum>target){
                sum=sum-nums[left++];
            }
            count=count+(right-left+1);
        }
        return count;
    }
}