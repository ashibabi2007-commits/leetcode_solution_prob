class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap <Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int ps=0;
        int total=0;
        for(int num:nums){
            ps=ps+num;
            total=total+map.getOrDefault(ps-k,0);
            map.put(ps,map.getOrDefault(ps,0)+1);
        }
        return total;
    }
}