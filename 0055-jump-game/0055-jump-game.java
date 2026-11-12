class Solution {
    public boolean canJump(int[] nums) {
        int a=0;
        for(int i=0;i<nums.length;i++){
            if(i>a){
                return false;
            }
            a=Math.max(a,i+nums[i]);
        }
        return true;
    }
}