class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        int total=0;
        int currentmin=0;
        int currentmax=0;
        for(int i:nums){
            currentmax=Math.max(i,currentmax+i);
            max=Math.max(max,currentmax);
            currentmin=Math.min(i,currentmin+i);
            min=Math.min(min,currentmin);
            total+=i;
        }
        if(max<0){
            return max;
        }
        return Math.max(max,total-min);
    }
}