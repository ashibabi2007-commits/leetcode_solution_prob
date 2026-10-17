class Solution {
    public int minEatingSpeed(int[] piles, int h) {
      int hi=0;
      int lo=1;
      for(int p:piles){
        hi=Math.max(p,hi);
      }
      while(lo<hi){
        int mid=lo+(hi-lo)/2;
        if(cat(piles,h,mid)){
            hi=mid;
        }
        else{
            lo=mid+1;
        }
      }  
      return lo;
    }
    public boolean cat(int[] piles,int h,int speed){
        long hrs=0;
        for(int p:piles){
            hrs=hrs+(p+speed-1)/speed;
            if(hrs>h){
                return false;
            }
        }
        return hrs<=h;
    }
}