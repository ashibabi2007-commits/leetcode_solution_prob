class Solution {
    public int maxArea(int[] height) {
        int l=0;
        
        int ans=0;
        int r=height.length-1;
        while(l<=r){
            int minheight=Math.min(height[l],height[r]);
            int max=minheight*(r-l);
            ans=Math.max(max,ans);
            if (height[l]<height[r]){
                l++;
            }
            else{
                r--;
            }
        }
        return ans;
    }
}