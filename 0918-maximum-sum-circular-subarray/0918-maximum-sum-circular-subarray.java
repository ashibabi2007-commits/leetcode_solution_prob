class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int currentmin=0;
        int currentmax=0;
        int total=0;
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for(int num:nums){
            currentmax=Math.max(num,currentmax+num);
            max=Math.max(max,currentmax);
            currentmin=Math.min(num,currentmin+num);
            min=Math.min(min,currentmin);
            total+=num;
        }
        if(max<0){
            return max;
        }
        return Math.max(max,total-min);
    }
}