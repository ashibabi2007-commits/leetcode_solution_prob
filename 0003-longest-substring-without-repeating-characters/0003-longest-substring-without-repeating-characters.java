class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left=0;
        HashMap <Character,Integer> map=new HashMap<>();
        int ans=0;
        for (int right=0;right<s.length();right++){
            char c=s.charAt(right);
            if(map.containsKey(c)){
                left=Math.max(left,map.get(c)+1);
            }
            map.put(c,right);
            ans=Math.max(ans,right-left+1);
        }
        return ans;
    }
}