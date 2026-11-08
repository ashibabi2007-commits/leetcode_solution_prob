class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer,Boolean> map=new HashMap<>();
        for(int i:nums){
            map.put(i,true);
        }
        int longest=0;
        for(int n:map.keySet()){
            if(!map.containsKey(n-1)){
                int current=n;
                int count=1;
                while(map.containsKey(current+1)){
                    current++;
                    count++;
                }
                longest=Math.max(longest,count);
            }
        }
        return longest;
    }
}