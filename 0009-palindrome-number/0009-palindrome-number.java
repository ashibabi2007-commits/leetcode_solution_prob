class Solution {
    public boolean isPalindrome(int x) {
        int rev=0;
            int b=x;
        if (x<0 ){
            return false;
        }
        else{
            
             while(x!=0){
                int a=x%10;
                x=x /10;
                rev=(rev*10)+a;
             }}
        if (rev==b){
            return true;
        }
        
        else{
            return false;
        }
    }
}