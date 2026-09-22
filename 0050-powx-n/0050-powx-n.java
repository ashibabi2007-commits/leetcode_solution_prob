class Solution {
    public double myPow(double x, int n) {
        long num=n;
        double ans=1;
        if (num<0){
            x=1/x;
            num=-num;
        }
        while(num>0){
            if(num%2==1){
                ans=ans*x;
            }
            x=x*x;
            num=num/2;
        }
        return ans;
    }
}