class Solution {
    public boolean isPerfectSquare(int num) {
        int l=1;
        int r=num;
        
        if(num==0 || num==1){
            return true;
        }
        while(l<=r){
            int mid=l+(r-l)/2;
            if (mid==num/mid){
                if(mid*mid==num){
                return true;
            }}
            if (mid<num/mid){
                l=mid+1;
            }
            else{
                r=mid-1;
            }
        }
        return false;
    }
}