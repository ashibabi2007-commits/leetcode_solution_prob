class Solution {
    public int reverseDegree(String s) {
        int ans=0;
        int n=s.length();
        int ch=0;
        for (int i=0;i<n;i++) {
            ch='z'-s.charAt(i)+1;
            ans=ans+ch*(i+1);
        }
        return ans;
    }
}