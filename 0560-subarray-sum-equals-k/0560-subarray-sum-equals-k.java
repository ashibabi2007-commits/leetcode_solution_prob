class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int prevend=0;
        int total=0;
        for(int num:nums){
            prevend+=num;
            total+=map.getOrDefault(prevend-k,0);
            map.put(prevend,map.getOrDefault(prevend,0)+1);
        }
        return total;
    }
}